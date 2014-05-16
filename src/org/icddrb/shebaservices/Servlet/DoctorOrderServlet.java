package org.icddrb.shebaservices.Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.*;
import org.icddrb.shebaservices.dl.CurrentHospitalPatientDL;
import org.icddrb.shebaservices.dl.DoctorOrderDL;
import org.icddrb.shebaservices.dl.PrescriptionDL;
import org.icddrb.shebaservices.dl.UserInfoDL;
import org.icddrb.shebaservices.services.CommonService;
import org.icddrb.shebaservices.services.CommonServiceImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/17/14
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoctorOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 2L;

    public DoctorOrderServlet(){

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

        String userID = request.getParameter("loggedInUserID");
        String patientID = request.getParameter("patientID");
        String actionName = request.getParameter("actionName");
        String dischargePrescriptionNo = "";
        String regularPrescriptionNo = "";

        //actionName = "list";
        if( Util.isValidString(userID) ){
            userID = userID.toUpperCase();
        }

        if( Util.isValidString(patientID) ){
            patientID = patientID.toUpperCase();
        }

        ConnectionParameter cp = new ConnectionParameter();
        //cp.setUserID(userID);
        //cp.setPassword(request.getParameter("password"));
        String serverIP = Util.getServerIPParameter(request);
        String databaseName = Util.getDBNameParameter(request);
        cp.setServerIP(serverIP);
        cp.setDatabaseName(databaseName);
        System.out.println("Logged In userID: " + userID);

        boolean  serverSetting = false;
        boolean  hasError = false;


        if( Util.isValidString(serverIP) && Util.isValidString(databaseName) ){
            serverSetting = true;
        }

        System.out.println("Test 00 Servlet");
        CurrentHospitalPatientDL patientDL = new CurrentHospitalPatientDL();

        CommonService cs = new CommonServiceImplement();
        System.out.println("Test 11 Servlet patientID:" + patientID );
        String message = "";
        //String message = cs.currentHospitalPatient(cp,patientID);
        System.out.println("Test 22 Servlet message: " + message );
        boolean somethingWrong = false;

        ArrayList<DoctorOrder> currentOrderList = null;
        DoctorOrderDL orderDL = new DoctorOrderDL();

        PrescriptionDL prescriptionDL = null;

        //boolean
        System.out.println("Test 33 Servlet");
        CurrentHospitalPatient patient = patientDL.getCurrentHospitalPatienByPatientID(cp,patientID);
        System.out.println("Test patient: " + patient);
        message = cs.patientStatus(patient);
        System.out.println("Test Message: " + message);

        if(serverSetting){
            if( message.equalsIgnoreCase(Constraint.Message.SUCCESS) ){
                // To do : Check this user is doctor or not
                System.out.println("Test 44 Servlet");
                if( !Util.isValidString(actionName) || actionName.equalsIgnoreCase("list") ) {
                    currentOrderList = orderDL.getDoctorOrdersPatientID(cp,patientID);
                    if(currentOrderList==null){
                        hasError = true;
                    }else {
                        patient.setDoctorOrderArrayList(currentOrderList);

                        if(currentOrderList.size()>0){

                            boolean disPresFound = false,presFound=false;
                            for(DoctorOrder order : currentOrderList){

                               if( order.getDischargedPrescription() >0 && !disPresFound ){
                                dischargePrescriptionNo = order.getPrescriptionID();
                                   disPresFound = true;
                               }

                                if( order.getDischargedPrescription() == 0 && !presFound ){
                                    regularPrescriptionNo = order.getPrescriptionID();
                                    presFound = true;
                                }
                            }
                        }

                        patient.setRegularPrescriptionNo(regularPrescriptionNo );
                        patient.setDischargePrescriptionNo( dischargePrescriptionNo );
                    }
                }

            }else{
                somethingWrong = true;
            }
        }

        //System.out.println("Order List: " + currentOrderList.size());


        //System.out.println("hasError:" + hasError );
        //System.out.println("somethingWrong:" + somethingWrong );
        //if invalid country code
        if( !serverSetting ){
            //System.out.println("isPatient ajax:" + isPatient );
            //System.out.println("message ajax:" + message );
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", Constraint.Message.SERVER_SETTINGS_NOT_FOUND );
            out.println(myObj.toString());
        }
        else if( somethingWrong ){
            //System.out.println("isPatient ajax:" + isPatient );
            //System.out.println("message ajax:" + message );
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", message);
            out.println(myObj.toString());
        }else if( hasError ){
            //System.out.println("hasError ajax:" + hasError );
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", Constraint.Message.TRANSACTION_ERROR );
            out.println(myObj.toString());
        }
        //if a valid credential was sent
        else {
            //System.out.println("Test Success AJAX:" + currentOrderList.size() );
            //patient.setDoctorOrderArrayList(currentOrderList);

            Gson gson = new Gson();
            //creates json from user object
            JsonElement patientObj = gson.toJsonTree(patient);
            //create a new JSON object
            JsonObject myObj = new JsonObject();
            //add property as success
            myObj.addProperty("success", true);
            //add the user object
            myObj.add("patientInfo", patientObj);

            //convert the JSON to string and send back
            out.println(myObj.toString());
            //-----------------------

        }
        out.close();
    }
}
