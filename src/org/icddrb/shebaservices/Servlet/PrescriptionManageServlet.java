package org.icddrb.shebaservices.Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.*;
import org.icddrb.shebaservices.dl.*;
import org.icddrb.shebaservices.services.CommonService;
import org.icddrb.shebaservices.services.CommonServiceImplement;
import org.icddrb.shebaservices.services.PrescriptionManageService;

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
 * Date: 5/14/14
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionManageServlet extends HttpServlet {

    private static final long serialVersionUID = 2L;

    public PrescriptionManageServlet(){

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

        String userID = Util.getUserID(request);
        String patientID = Util.getPatientID( request );;
        String actionName = Util.getActionName( request );;
        int dischargePrescription = Util.parseInt(request.getParameter("dischargePrescription"));

        //actionName = "list";
        if( Util.isValidString( userID ) ){
            userID = userID.toUpperCase();
        }

        if( Util.isValidString(patientID) ){
            patientID = patientID.toUpperCase();
        }

        ConnectionParameter cp = new ConnectionParameter();

        String serverIP = Util.getServerIPParameter(request);
        String databaseName = Util.getDBNameParameter(request);
        cp.setServerIP(serverIP);
        cp.setDatabaseName(databaseName);
        cp.setUserID(userID);

        boolean  serverSetting = false;
        boolean  hasError = false;


        if( Util.isValidString(serverIP) && Util.isValidString(databaseName) ){
            serverSetting = true;
        }


        PatientDL patientDL = new PatientDL();

        CommonService cs = new CommonServiceImplement();

        String message = "";


        boolean somethingWrong = false;


        HospitalDrugDL hospitalDrugDL = new HospitalDrugDL();
        HospitalDrug hospitalDrug = new HospitalDrug();

        PrescriptionManage prescriptionManage = new PrescriptionManage();
        PrescriptionManageService service = new PrescriptionManageService();
        //boolean
        System.out.println("Test 33 Servlet");
        Patient patient = patientDL.getCurrentHospitalPatienByPatientID(cp,patientID);
        System.out.println("Test patient: " + patient);
        message = cs.patientStatus(patient);
        System.out.println("Test Message: " + message);

        if(serverSetting){
            if( message.equalsIgnoreCase( Constraint.Message.SUCCESS) ){
                // To do : Check this user is doctor or not
                System.out.println("Test 44 Servlet");
                if( !Util.isValidString(actionName)  ) {
                    hasError = true;
                    message = "Action name not defined.";
                }else if(actionName.equalsIgnoreCase("new")){



                    ArrayList<HospitalDrug> drugs = service.getDrugList(cp);

                    ArrayList<HospitalDrug> filterFluidList = new ArrayList<HospitalDrug>();
                    ArrayList<HospitalDrug> filterDrugList = new ArrayList<HospitalDrug>();

                    if( drugs==null ){
                        hasError = true;
                    }else {
                        //System.out.println("Test drugs size:" + drugs.size() );
                        filterDrugList = service.filterDrugList(drugs);
                        filterFluidList = service.filterFluidDrugList( drugs );

                        //System.out.println("filterDrugList:" + filterDrugList.size() );
                        prescriptionManage.setDrugs(filterDrugList);
                        prescriptionManage.setFluidDrugs(filterFluidList);
                        //System.out.println("filterFluidList:" + filterFluidList.size() );
                    }
                }else if(actionName.equalsIgnoreCase("getDrugInfo")){
                 
                    String localDrugCode = Util.parseString(request.getParameter("strDrugCode"));
                    int hasCholeraInPreviousProgressReport = 0,isAzithromycin = 0;
                    if( Util.isValidString( localDrugCode )){

                        if ( Util.isAzithromycin( localDrugCode )){
                            isAzithromycin = 1;
                            if( service.isCholeraInLastProgressReport( cp, patientID ) ) { // Has
                                hasCholeraInPreviousProgressReport = 1;
                            }
                        }

                        hospitalDrug = hospitalDrugDL.getDrugInfoByCode(cp,localDrugCode);

                        if( hospitalDrug==null ){
                          hasError = true;
                        }else {
                            hospitalDrug.setAzithromycin(isAzithromycin);
                            hospitalDrug.setCholeraInPreviousProgressReport(hasCholeraInPreviousProgressReport);
                        }

                    }else{

                        somethingWrong = true;
                        message = "Drug Code Not Found!";
                    }

                }

            }else{
                somethingWrong = true;
            }
        }
        //System.out.println("Order List: " + currentOrderList.size());

        System.out.println("hasError:" + hasError );
        System.out.println("somethingWrong:" + somethingWrong );
        //if invalid country code
        if( !serverSetting ){
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", Constraint.Message.SERVER_SETTINGS_NOT_FOUND );
            out.println(myObj.toString());
        }
        else if( somethingWrong ){
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", message);
            out.println(myObj.toString());
        }else if( hasError ){
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
            JsonObject myObj = new JsonObject();

            if(actionName.equalsIgnoreCase("getDrugInfo")) {
                //creates json from user object
                JsonElement drug = gson.toJsonTree(hospitalDrug);
                //add property as success
                myObj.addProperty("success", true);
                //add the user object
                myObj.add("drugInfo", drug);
            }else {

            //creates json from user object
            JsonElement prescription = gson.toJsonTree(prescriptionManage);
            //add property as success
            myObj.addProperty("success", true);
            //add the user object
            myObj.add("prescriptionInfo", prescription);

            }
            //add property as success
            myObj.addProperty("success", true);
            //add the user object
            //convert the JSON to string and send back
            out.println(myObj.toString());
            //-----------------------

        }
        out.close();
    }
}
