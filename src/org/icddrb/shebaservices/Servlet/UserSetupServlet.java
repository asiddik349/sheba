package org.icddrb.shebaservices.Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.UserSetup;
import org.icddrb.shebaservices.dl.UserInfoDL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserSetupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserSetupServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");

        String userID = request.getParameter("userID");
        if( Util.isValidString(userID) ){
            userID = userID.toUpperCase();
        }
        //System.out.println("Test User ID: " + userID );
        ConnectionParameter cp = new ConnectionParameter();
        cp.setUserID(userID);
        cp.setPassword(request.getParameter("password"));
        String serverIP = Util.getServerIPParameter(request);
        String databaseName = Util.getDBNameParameter(request);
        cp.setServerIP(serverIP);        
        cp.setDatabaseName(databaseName);
        System.out.println("Login userID: " + cp.getUserID() );

        boolean  serverSetting = false;

        if( Util.isValidString(serverIP) && Util.isValidString(databaseName) ){
            serverSetting = true;
        }


        byte  login = 0;
        boolean  expiredUser = false;
        UserSetup user = null;

        if( serverSetting ){
            login = Util.verifyDynamicLogin(cp);
            if(login>0){

                expiredUser = UserInfoDL.userExpired(cp);
                if(!expiredUser){
                    user = UserInfoDL.getUserInfoByID(cp);
                    System.out.println("Test User Obj: " + user );
                    if( user==null ){
                        user = new UserSetup();
                        user.setAnyRule(0);
                    }
                }
            }
        }

        //if invalid country code
        if( !serverSetting ){
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", Constraint.Message.SERVER_SETTINGS_NOT_FOUND );
            out.println(myObj.toString());
        }
        else if( login == 0 ){
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", "Invalid UserID or Password!");
            out.println(myObj.toString());
        }else if( expiredUser ){
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", "Login expired, Please contact to administrator");
            out.println(myObj.toString());
        }
        //if a valid credential was sent
        else {
            Gson gson = new Gson();
            //creates json from user object
            JsonElement userObj = gson.toJsonTree(user);
            //create a new JSON object
            JsonObject myObj = new JsonObject();
            //add property as success
            myObj.addProperty("success", true);
            //add the user object
            myObj.add("userInfo", userObj);
            //convert the JSON to string and send back
            out.println(myObj.toString());
        }
        out.close();
    }
}
