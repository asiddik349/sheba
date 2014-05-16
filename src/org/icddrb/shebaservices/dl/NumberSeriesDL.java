package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberSeriesDL extends Persistent{
    

    public static String getNumberSeries(ConnectionParameter cp,String columnName){

        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        String numberSeries = "";
        try
        {

            String query = "SELECT " + columnName + " from " + Constraint.TABLE_HMS_SETUP;
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);

            rst = pstmt.executeQuery();

            if( rst.next() ){
                numberSeries = rst.getString(1);
            }
            
            if( Util.isValidString(numberSeries) ){

            }else{
                return numberSeries = null;
            }

        }catch ( Exception ex )
        {
            numberSeries = null;
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
                numberSeries = null;
                sqe.printStackTrace();
            }
        }

        return numberSeries;
    }

    public static String getSerialNumber(ConnectionParameter cp,String seriesCode){

        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        String serialNumber = "";
        boolean hasError = false;
        try
        {
            String startNo= "",endNo="",lastNo="";
            int increment = 0;
            //System.out.println("Test Number Series CALL");
            String query = "SELECT " +
                    "[" + Constraint.STARTING_NO + "], " +
                    "[" + Constraint.ENDING_NO_ + "], " +
                    "[" + Constraint.INCREMENT_BY_NO_ + "], " +
                    "[" + Constraint.LAST_NO_USED + "]" +
                    " from " + Constraint.TABLE_NUMBER_SERIES_LINE + " where " + Constraint.SERIES_CODE + "=? AND " + Constraint.OPEN + "=1" ;
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            //System.out.println("Test Number Series query");
            pstmt = dbCon.prepareStatement(query);

            pstmt.setString(1,seriesCode);
            rst = pstmt.executeQuery();
            //System.out.println("Test Number Series query end");

            while( rst.next() ){
                startNo = rst.getString(Constraint.STARTING_NO);
                endNo = rst.getString(Constraint.ENDING_NO_);
                increment = rst.getInt(Constraint.INCREMENT_BY_NO_);
                lastNo = rst.getString(Constraint.LAST_NO_USED);
            }

            if( !Util.isValidString(startNo) ){   // Not Set Starting Number
                    hasError = true;
                    serialNumber = null;
            }

            //System.out.println("Test Number Series 0000");
            if(!Util.isValidString(lastNo) && !hasError ){  // Set Last No if not already set

                    String queryUpdateLastNo = " update " + Constraint.TABLE_NUMBER_SERIES_LINE +
                            " set [Last No_ Used] = [Starting No_] " +
                            "where [Series Code] = '" + seriesCode + "' and [Open] = 1 and [Last No_ Used] = ''";

                    int updateLastNo = isUpdate(queryUpdateLastNo,cp);

                    if(updateLastNo>=0){
                     if(updateLastNo>0){ // If Update Occured
                         serialNumber = startNo;
                     }else{
                         lastNo = startNo;
                     }
                    }else{  // Error Occured
                        hasError = true; // Number generation failed
                        serialNumber = null;
                    }
            }
            //System.out.println("Test Number Series 1111");
            int updateNumberSeries = 0;
            int intSeparator = 0;

            if(!hasError && Util.isValidString(lastNo) && !Util.isValidString(serialNumber)) {
                char[] chrRandomNo = lastNo.toCharArray();
                int intIndex = 0;
                for (int i = (chrRandomNo.length - 1); i >= 0; i--)
                {
                    if (!Character.isDigit(chrRandomNo[i]))
                    {
                        intIndex = i;
                        break;
                    }
                }
                //System.out.println("Test Number Series 333");
                intSeparator = intIndex + 2;

                updateNumberSeries = isUpdate( qryNumberSeries(intSeparator,seriesCode),cp);
                if(updateNumberSeries>0){
                    //System.out.println("Test Number Series 4444");
                    String queryLastNo = "Select [Last No_ Used] from " + Constraint.TABLE_NUMBER_SERIES_LINE + " where [Series Code]=?" + " and [Open]=1";
                    serialNumber = Util.getQueryResultAsStringWithActiveConnection(queryLastNo,seriesCode,dbCon);
                    if( !Util.isValidString(serialNumber) ){
                        serialNumber = null;
                        hasError = true;
                    }
                    
                }else{
                    //System.out.println("Test Number Series 5555");
                    hasError = true;
                    serialNumber = null;
                }

            }

            //System.out.println("Final Serial Number: " + serialNumber );


        }catch ( Exception ex )
        {
            serialNumber = null;
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
                serialNumber = null;
                sqe.printStackTrace();
            }
        }

        return serialNumber;
    }
    
    public static int isUpdate(String query, ConnectionParameter dbConn ){

        int updated = 0;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        
        String numberSeries = "";
        try
        {
            dbCon = ConnectionPool.getDynamicDatabaseConnection(dbConn);
            pstmt = dbCon.prepareStatement(query);
            updated = pstmt.executeUpdate();

        }catch ( Exception ex )
        {
            updated = -1;
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                
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
                updated = -1;
                sqe.printStackTrace();
            }
        }
        
        return updated;
    }
    
    
    public  static String qryNumberSeries(int separatorIndex, String code){

        String query = "UPDATE " + Constraint.TABLE_NUMBER_SERIES_LINE + " set [Last No_ Used] = substring([Last No_ Used], 1, "
                + separatorIndex + " - 1) + substring((substring([Last No_ Used], " + separatorIndex +
                ", len([Last No_ Used]))), 1, (len(substring([Last No_ Used], " + separatorIndex + ", len([Last No_ Used]))) - len(substring([Last No_ Used], "
                + separatorIndex + ", len([Last No_ Used])) + [Increment-by No_]))) + convert(varchar, (substring([Last No_ Used], "
                + separatorIndex + ", len([Last No_ Used])) + [Increment-by No_])) where [Series Code] = '" + code + "'";
        return query;
    }
}
