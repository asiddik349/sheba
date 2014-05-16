package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.CurrentHospitalPatient;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/22/14
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonDL extends Persistent {
    
    public int getLOS(ConnectionParameter cp ,String patientID) {

        int los = 0;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            String query = "SELECT DATEDIFF(hour,Dateadd(hour,6,[Registration Complete DateTime]),getdate()) as los from " + Constraint.TABLE_PATIENT_REGISTRATION + " WHERE [Patient ID]=?";
            System.out.println("Query LOS: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, patientID );
            rst = pstmt.executeQuery();

            if( rst.next() )
            {
                los = rst.getInt("los");
            }

        }catch (Exception ex)
        {
            los = -1;
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
                los = -1;
                sqe.printStackTrace();
            }
        }

        return  los;
    }
}
