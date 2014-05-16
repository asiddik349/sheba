package org.icddrb.shebaservices.dbconnection;

import org.icddrb.shebaservices.db.ConnectionParameter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionPool {
    private static String DATASOURCE_NAME = "jdbc/shebaserver";
    private static Connection dbConnection = null;

//    public static Connection getDBConnection()
//    {
//        // Parameter dataSource for Tomcat server
//        try
//        {
//            DataSource dataSource = null;
//            if (dataSource == null)
//            {
//                // for Resin server
//                Context env = (Context) new InitialContext().lookup("java:comp/env");
//                dataSource = (DataSource) env.lookup(DATASOURCE_NAME);
//
//                if ( dataSource == null )
//                    System.out.println("'" + DATASOURCE_NAME + "' is an unknown DataSource");
//            else
//            {
//                //System.out.println("Before.......");
//                dbConnection = dataSource.getConnection();
//                //System.out.println("Db Con = " + dbConnection);
//            }
//            }
//       }
//        catch (Exception e)
//        {
//            //throw new ServletException(e);
//            System.out.println(e);
//        }
//        return dbConnection;
//    }

    public static Connection getDynamicDatabaseConnection(ConnectionParameter cp )
    {

        String jdbc_url="jdbc:jtds:sqlserver://" + cp.getServerIP() + ":1433/" + cp.getDatabaseName();
        String jdbc_username="";
        String jdbc_password="";
        String jdbc_driver="net.sourceforge.jtds.jdbc.Driver";
        Connection databaseConnection=null;
        String serverIP = cp.getServerIP();
        String databaseName = cp.getDatabaseName();

        if(serverIP.equals("172.16.8.91") && databaseName.equals("02-Mar-2014")){
            System.out.println("Server IP is Correct");
            jdbc_username = "IT-ADMIN";
            jdbc_password = "it111";
        }

        try
        {
            Class.forName(jdbc_driver);
            databaseConnection= DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
        }
        catch (Exception sqle)
        {
            sqle.printStackTrace();
        }

        System.out.println("Test databaseConnection:" + databaseConnection);

        return databaseConnection;

    }
}
