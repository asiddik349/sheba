package org.icddrb.shebaservices.dbconnection;

import org.icddrb.shebaservices.db.ConnectionParameter;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Persistent {

    protected static int insert(String query, ConnectionParameter cp) throws SQLException
    {
        int returnValue = 0;
        Connection dbCon = null;
        boolean sucess = false;
        PreparedStatement preparedStatement = null;
        try{
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            preparedStatement = dbCon.prepareStatement(query);
            returnValue =  preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }finally {
            try
            {
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if( dbCon!=null ){
                  dbCon.close();
                  dbCon = null;
                }
            }catch (Exception ex){
                ex.printStackTrace();
                returnValue = -1;
            }
        }
        return returnValue;
    }


    protected static int insertWithKey(String query, ConnectionParameter cp) throws SQLException
    {
        int returnValue = 0;
        Connection dbCon = null;
        ResultSet rst = null;
        PreparedStatement preparedStatement = null;
        try{
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            preparedStatement = dbCon.prepareStatement( query, PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement.executeUpdate();
            rst = preparedStatement.getGeneratedKeys();

            if( rst.next() )
                returnValue = rst.getInt( 1 );

        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }finally {
            try
            {
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if( dbCon!=null ){
                    dbCon.close();
                    dbCon = null;
                }
            }catch (Exception ex){
                ex.printStackTrace();
                returnValue = -1;
            }
        }
        return returnValue;
    }

    //--------------

    protected static int insertWithActiveConnection(String query, Connection dbCon ) throws SQLException
    {
        int returnValue = 0;

        PreparedStatement preparedStatement = null;
        try{

            preparedStatement = dbCon.prepareStatement(query);
            returnValue =  preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }finally {
            try
            {
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }

            }catch (Exception ex){
                ex.printStackTrace();
                returnValue = -1;
            }
        }
        return returnValue;
    }


    protected static int insertActiveConnectionWithKey(String query, Connection dbCon ) throws SQLException
    {
        int returnValue = 0;

        ResultSet rst = null;
        PreparedStatement preparedStatement = null;
        try{

            preparedStatement = dbCon.prepareStatement( query, PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement.executeUpdate();
            rst = preparedStatement.getGeneratedKeys();

            if( rst.next() )
                returnValue = rst.getInt( 1 );

        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }finally {
            try
            {
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }

            }catch (Exception ex){
                ex.printStackTrace();
                returnValue = -1;
            }
        }
        return returnValue;
    }


// --------------------------------------------------------------------------------------
protected static int update(String query, ConnectionParameter cp) throws SQLException
{
    int returnValue = 0;
    Connection dbCon = null;
    PreparedStatement preparedStatement = null;
    try{
        dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
        preparedStatement = dbCon.prepareStatement(query);
        returnValue =  preparedStatement.executeUpdate();

    }catch (Exception ex){
        ex.printStackTrace();
        returnValue = -1;
    }finally {
        try
        {
            if(preparedStatement != null)
            {
                preparedStatement.close();
                preparedStatement = null;
            }
            if( dbCon!=null ){
                dbCon.close();
                dbCon = null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }
    }
    return returnValue;
}


    protected static int updateWithActiveConnection(String query, Connection dbCon) throws SQLException
    {
        int returnValue = 0;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = dbCon.prepareStatement( query );
            returnValue = preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            returnValue = -1;
        }finally {
            try
            {
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
            }catch (Exception ex){
                ex.printStackTrace();
                returnValue = -1;
            }
        }
        return returnValue;
    }


// ---------------------------------------------------------------------------------------

// Select ---------------


}
