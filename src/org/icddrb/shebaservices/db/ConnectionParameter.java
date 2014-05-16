package org.icddrb.shebaservices.db;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/6/14
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionParameter {
    
    public  String userID;
    public  String password;
    public  String databaseName;
    public  String serverIP;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }
}
