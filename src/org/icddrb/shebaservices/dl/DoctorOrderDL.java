package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.DoctorOrder;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;
import org.icddrb.shebaservices.enums.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoctorOrderDL extends Persistent {

    public ArrayList<DoctorOrder> getDoctorOrdersPatientID(ConnectionParameter cp, String patientID)
    {
        //String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=? AND " + Constraint.OLD_DISCHARGED_PRESCRIPTION + "=0 AND " + Constraint.DISCHARGE_PRESCRIPTION + "=0" ;
        return getDoctorOrder(cp, patientID);
    }

    private ArrayList<DoctorOrder> getDoctorOrder( ConnectionParameter cp ,String patientID) {

        
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        ArrayList<DoctorOrder> orderList = new ArrayList<DoctorOrder>();
        try
        {
            String query = getQueryText(patientID);
            //Util.writeDataIntoText(query);
            System.out.println("Test Query: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            //pstmt.setString(1, patientID );
            rst = pstmt.executeQuery();
            //System.out.println("Connection is DL:" + userID );
            while( rst.next() )
            {
                DoctorOrder order= new DoctorOrder();

                    order.setLineNumber(rst.getInt("lineNumber"));
                    order.setDoctorCode(rst.getString("doctorCode"));
                    order.setDose(rst.getString("doses"));
                //SexEnum.values()[rst.getInt( Constraint.SEX )].toString()
                    order.setDrugInventory( DrugInventoryEnum.values()[ rst.getInt("drugInventory") ].getName() );  // From Enum; Int/Ext
                    order.setDrugCode(rst.getString("drugCode"));
                    order.setDrugName(rst.getString("drugName"));
                    order.setDrugUsingType( DrugUsingTypeEnum.values()[ rst.getInt("drugUsingType")].getName() );   // From enum; Regular
                    order.setEndDate(rst.getString("endDate"));
                    order.setFrequency( FrequencyEnum.values()[ rst.getInt("frequency")].getName() );    // From Enum ; q1h,q2h
                    order.setDrugType( DrugTypeEnum.values()[ rst.getInt( "drugType" ) ].getName() );    // From Enum ; DRUG, Fluid
                    order.setNoOfDays(rst.getInt("noOfDays"));
                    order.setNoOfDose(rst.getString("noOfDoses"));
                    order.setPatientID(patientID);
                    order.setPrescriptionID(rst.getString("prescriptionID"));
                    order.setRemarks(rst.getString("remarks"));
                    order.setRoute( RouteEnum.values()[ rst.getInt("route")].getName() ); // From Enum
                    order.setStartDate(rst.getString("startDate"));
                    order.setUOM(rst.getString("uom"));

                    order.setPrescriptionDate(rst.getString("prescriptionDate"));  //
                    order.setStopped(rst.getInt("stopped"));
                    order.setDrugStopped( rst.getInt( "drugStopped" ) );
                    order.setDischargedPrescription(rst.getInt("dischargePrescription"));
                    order.setPrescriptionLineTable(rst.getInt("prescriptionLineTable"));

                orderList.add(order);
                
            }
        }catch (Exception ex)
        {
            orderList = null;
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
                orderList = null;
                sqe.printStackTrace();
            }
        }

        return orderList;
    }     

    private String getQueryText(String patientID){
        
        String query = "";

        query = AppSQL.QRY_SELECT_COLUMN_PRESCRIPTION_LINE +
                " , " +
                "CONVERT( VARCHAR(10), pres.[" + Constraint.PRESCRIPTION_DATE + "], 105 ) as prescriptionDate, " +
                "pres.[" + Constraint.DISCHARGE_PRESCRIPTION + "] as dischargePrescription, " +
                "pres.[" + Constraint.STOPPED + "] as stopped " +
                " from " + Constraint.TABLE_PRESCRIPTION_LINE + " as pl " +
                " INNER JOIN " + Constraint.TABLE_PRESCRIPTION + " as pres " +
                " ON " +
                "pres.[" + Constraint.PRESCRIPTION_NO + "]=" +
                "pl.[" + Constraint.PRESCRIPTION_SMALL_ID + "]" +
                " where " +
                "pres.["  + Constraint.PATIENT_ID + "]='" + patientID + "' " +
                " AND pres.[" + Constraint.OLD_DISCHARGED_PRESCRIPTION + "]=0" +
                " AND pl.[" + Constraint.DELETED_DISCHARGE_PRESCRIPTION + "]=0 ";

//        query = query + " UNION " +
//                AppSQL.QRY_SELECT_FLUID_PRESCRIPTION_LINE + " where ["  + Constraint.PATIENT_ID+ "]='" + patientID + "' AND [" + Constraint.FLUID_PRESCRIPTION_NO + "]='" +
//                prescriptionID + "' AND [" + Constraint.DELETED_DISCHARGE_PRESCRIPTION + "]=0 ";

        query = query + " UNION ALL " +
                AppSQL.QRY_SELECT_COLUMN_FLUID_PRESCRIPTION_LINE +
                " , " +
                "CONVERT( VARCHAR(10), pres.[" + Constraint.PRESCRIPTION_DATE + "], 105 ) as prescriptionDate, " +
                "pres.[" + Constraint.DISCHARGE_PRESCRIPTION + "] as dischargePrescription, " +
                "pres.[" + Constraint.STOPPED + "] as stopped " +
                " from " + Constraint.TABLE_FLUID_PRESCRIPTION_LINE+ " as fpl " +
                " INNER JOIN " + Constraint.TABLE_PRESCRIPTION + " as pres " +
                " ON " +
                "pres.[" + Constraint.PRESCRIPTION_NO + "]=" +
                "fpl.[" + Constraint.FLUID_PRESCRIPTION_NO + "]" +
                " where " +
                "pres.["  + Constraint.PATIENT_ID + "]='" + patientID + "' " +
                " AND pres.[" + Constraint.OLD_DISCHARGED_PRESCRIPTION + "]=0" +
                " AND fpl.[" + Constraint.DELETED_DISCHARGE_PRESCRIPTION + "]=0 ";

        
        return  query;
    }
}
