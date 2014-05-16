package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.Prescription;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionDL extends Persistent {

    public Prescription getActivePrescriptionByPatientID(ConnectionParameter cp, String patientID)
    {
        String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=? AND [" + Constraint.OLD_DISCHARGED_PRESCRIPTION + "]=0 AND [" + Constraint.DISCHARGE_PRESCRIPTION + "]=0" ;
        System.out.println("Test Prescription Where Claue:" + whereClause );
        return getPrescription(whereClause, cp, patientID);
    }

    private Prescription getPrescription(String whereClause, ConnectionParameter cp ,String patientID) {

        Prescription prescription = null;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            String query = AppSQL.QRY_SINGLE_PRESCRIPTION + whereClause;
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, patientID );
            rst = pstmt.executeQuery();
            //System.out.println("Connection is DL:" + userID );
            while( rst.next() )
            {
                prescription= new Prescription();
                prescription.setUhID(rst.getString(Constraint.UH_ID));
                prescription.setPatientID(rst.getString(Constraint.PATIENT_ID));
                prescription.setDischargePrescription(rst.getInt(Constraint.DISCHARGE_PRESCRIPTION));
                prescription.setDoctorCode(rst.getString(Constraint.DOCTOR_CODE));
                prescription.setDoctorName(rst.getString(Constraint.DOCTOR_NAME));
                prescription.setOldDischargedPrescription(rst.getInt(Constraint.OLD_DISCHARGED_PRESCRIPTION));
                prescription.setPrescriptionDate(rst.getString(Constraint.PRESCRIPTION_DATE));
                prescription.setPrescriptionNo(rst.getString(Constraint.PRESCRIPTION_NO));
                prescription.setScheduledGenerated(rst.getInt(Constraint.SCHEDULE_GENERATED));
                prescription.setStopped(rst.getInt(Constraint.STOPPED));

            }
        }catch (Exception ex)
        {
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
                sqe.printStackTrace();
            }
        }

        return prescription;
    }

}
