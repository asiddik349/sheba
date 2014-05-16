package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.UserSetup;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoDL extends Persistent {

    public static UserSetup getUserInfoByID(ConnectionParameter cp)
    {
        String whereClause = " WHERE [" + Constraint.USER_ID + "]=?";
        return getUserInfo(whereClause,cp );
    }

    private static UserSetup getUserInfo(String whereClause, ConnectionParameter cp ) {

        UserSetup user = null;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            String query =  queryUserInfo(whereClause);
            dbCon = ConnectionPool.getDynamicDatabaseConnection( cp );
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, cp.getUserID() );
            rst = pstmt.executeQuery();
            //System.out.println("Connection is DL:" + userID );
            while( rst.next() )
            {
                user= new UserSetup();
                user.setAnyRule(1);
                user.setUserID(rst.getString(Constraint.USER_ID));
                user.setEmailID(rst.getString(Constraint.EMAIL_ID));
                user.setEmpID(rst.getString(Constraint.EMPLOYEE_ID));
                user.setUserType(rst.getInt(Constraint.USER_TYPE));
                user.setDoctorType(rst.getInt(Constraint.DOCOTOR_TYPE));
                user.setProgressReport(rst.getInt(Constraint.PROGRESS_REPORT));
                user.setDoctorsOrder(rst.getInt(Constraint.DOCTORS_ORDER));
                user.setDischargeAdvice(rst.getInt(Constraint.DISCHARGE_ADVICE));
                user.setPatientIntake(rst.getInt(Constraint.PATIENT_INTAKE));
                user.setPatientOutput(rst.getInt(Constraint.PATIENT_OUTPUT));
                user.setDietRequirement(rst.getInt(Constraint.DIET_REQUIREMENT));
                user.setVitalSign(rst.getInt(Constraint.VITAL_SIGN));
                user.setDrugAdministration(rst.getInt(Constraint.DRUG_ADMINISTRATION));
                user.setWardTransfer(rst.getInt(Constraint.WARD_TRANSFER));
                user.setBedIDVerification(rst.getInt(Constraint.BEDID_VERIFICATION));
                user.setTwentyFourHourAccess(rst.getInt(Constraint.TWENTY_FOUR_HOUR_ACCESS));
                user.setGenerateDietRequisition(rst.getInt(Constraint.GENERATE_DIET_REQUISITION));
                user.setViewDietRequisition(rst.getInt(Constraint.VIEW_DIET_REQUISITION));
                user.setCanteenDietRequisition(rst.getInt(Constraint.CANTEEN_DIET_REQUISITION));
                user.setDietSetup(rst.getInt(Constraint.DIET_SETUP));
                user.setDietSetupAdmin(rst.getInt(Constraint.DIET_SETUP_ADMIN));
                user.setApplicableForSSULabReq(rst.getInt(Constraint.APPLICABLE_FOR_SSU_LAB_REQ));
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

        return user;
    }
    
    private  static String queryUserInfo(String whereClause){

        String query= AppSQL.QRY_USER_SETUP + whereClause;

        return  query;
    }

    public static boolean userExpired(ConnectionParameter cp)
    {
        String whereClause = " WHERE [" + Constraint.USER_ID + "]=? AND [" + Constraint.EXPIRATION_DATE + "]<>'1753-01-01 00:00:00.000'" + " AND [" +  Constraint.EXPIRATION_DATE  + "]<getdate()" ;
        return getUserExpired(whereClause, cp);
    }

    private static boolean getUserExpired(String whereClause, ConnectionParameter cp ) {

        UserSetup user = null;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        boolean  expired = false;
        try
        {

            String query =  AppSQL.QRY_CHECK_LOGIN_EXPIRED + whereClause;
            //System.out.println("Test Expired Query: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection( cp );
            pstmt = dbCon.prepareStatement(query);

            pstmt.setString(1, cp.getUserID() );
            rst = pstmt.executeQuery();

            if( rst.next() )
            {
                expired = true;
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

        return expired;
    }
}
