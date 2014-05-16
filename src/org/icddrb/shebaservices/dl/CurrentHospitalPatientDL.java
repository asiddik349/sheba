package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.CurrentHospitalPatient;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;
import org.icddrb.shebaservices.enums.SexEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/15/14
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurrentHospitalPatientDL extends Persistent {

    public CurrentHospitalPatient getCurrentHospitalPatienByPatientID(ConnectionParameter cp, String patientID)
    {
        String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=?";
        return getCurrentHospitalPatien(whereClause, cp, patientID);
    }

    private CurrentHospitalPatient getCurrentHospitalPatien(String whereClause, ConnectionParameter cp ,String patientID) {

        CurrentHospitalPatient chp = new CurrentHospitalPatient();
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            String query = AppSQL.QRY_CURRENT_HOSPITAL_PATIENT + whereClause;

            //Util.writeDataIntoText(query);
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, patientID );
            rst = pstmt.executeQuery();
            //System.out.println("Connection is DL:" + userID );
            while( rst.next() )
            {
                chp= new CurrentHospitalPatient();
                chp.setPatientID(rst.getString(Constraint.PATIENT_ID));
                chp.setBedID(rst.getString(Constraint.PATIENT_ID));
                chp.setDischarged(rst.getInt(Constraint.DISCHARGED));
                chp.setPatientDied(rst.getInt(Constraint.PATIENT_DIED));
                chp.setPatientName(rst.getString(Constraint.PATIENT_NAME));
                chp.setUhID(rst.getString(Constraint.UH_ID));
                chp.setWardID(rst.getString(Constraint.WARD_ID));
                chp.setWardLocationID(rst.getString(Constraint.WARD_LOCATION_ID));
                chp.setWeightInKg(rst.getString("weightInKg"));
                chp.setzScoreHA(rst.getString("zScoreHA"));
                chp.setzScoreWA(rst.getString("zScoreWA"));

                chp.setFormattedDateOfAdmission(rst.getString("formattedDateOfAdmission"));
                chp.setDateOfAdmission(rst.getString("dateOfAdmission"));
                chp.setFormattedTimeOfAdmission(rst.getString("formattedTimeOfAdmission"));
                chp.setTimeOfAdmission(rst.getString("timeOfAdmission"));

                chp.setAgeInDay(rst.getInt(Constraint.AGE_IN_DAY));
                chp.setAgeInMonth(rst.getInt(Constraint.AGE_IN_MONTH));
                chp.setAgeInYear(rst.getInt(Constraint.AGE_IN_YEAR));
                chp.setAge(chp.getAge());
                String discharge = Util.getQueryResultAsStringWithActiveConnection( AppSQL.QRY_DISCHARGE_PRESCRIPTION,patientID,dbCon);

                if(discharge!=null){
                    chp.setHasDischargePrescription(Util.parseInt(discharge));
                }else{
                    chp = null;
                    break;
                }
                chp.setSex(rst.getInt( Constraint.SEX ));
                chp.setSexName(SexEnum.values()[rst.getInt(Constraint.SEX)].getName());
                String los = Util.getQueryResultAsStringWithActiveConnection(AppSQL.QRY_LOS_COUNT,patientID,dbCon);

                if(los!=null){
                    chp.setLos(Util.parseInt( los ));
                }else{
                    chp = null;
                    break;
                }


            }
        }catch (Exception ex)
        {
            chp = null;
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                }
                if(pstmt != null)
                {
                    pstmt.close();
                }
                if(dbCon != null)
                {
                    dbCon.close();
                }
            }
            catch (Exception sqe)
            {
                chp = null;
                sqe.printStackTrace();
            }
        }

        return chp;
    }
}
