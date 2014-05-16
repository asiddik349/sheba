package org.icddrb.shebaservices.Servlet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.MyDate;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.*;
import org.icddrb.shebaservices.dl.*;
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
 * Date: 4/27/14
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgressReportServlet extends HttpServlet {

    private static final long serialVersionUID = 3L;

    public ProgressReportServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("request:" + request);
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
        String progressReportNo = request.getParameter("progressReportNo"); // For View/Edit/Delete
        System.out.println("Action Nam:" + actionName);
        if( Util.isValidString(userID) ){
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

        ArrayList<ProgressReport> progressReportList = null;
        ProgressReportDL progressReportDL = new ProgressReportDL();
        ProgressReport progressReport = null;
        TriageInformation triageInformation = null;
        TriageInformationDL triageInformationDL = new TriageInformationDL();
        
        //boolean
        System.out.println("Test 33 Servlet");
        CurrentHospitalPatient patient = patientDL.getCurrentHospitalPatienByPatientID(cp,patientID);
        System.out.println("Test patient: " + patient);
        message = cs.patientStatusForNewProgressReport(patient);
        System.out.println("Test Message: " + message);
        //String[] test = {"one","Two"};

        //test[0].toString();
        if(serverSetting){
            if( message.equalsIgnoreCase(Constraint.Message.SUCCESS) ){
                // To do : Check this user is doctor or not
                System.out.println("Test 44 Servlet");

                if( !Util.isValidString(actionName) || actionName.equalsIgnoreCase("list") ) {
                    progressReportList = progressReportDL.getProgressReportsPatientID(cp, patientID);
                    if( progressReportList==null ){
                        hasError = true;
                        message = Constraint.Message.TRANSACTION_ERROR;
                    }else {
                        patient.setProgressReportArrayList(progressReportList);
                    }

                }else if(actionName.equalsIgnoreCase("view") ){
                    if(Util.isValidString(progressReportNo)) {
                        progressReport = progressReportDL.getProgressReportPatientID(cp,patientID,progressReportNo);
                        if(progressReport!=null){
                            System.out.println("Setting View for Progress Report....");
                            patient.setProgressReport(progressReport);
                        }else{
                            hasError = true; // Transaction Error
                            message = Constraint.Message.TRANSACTION_ERROR;
                        }
                    }else{
                        somethingWrong = true;
                        message = "Progress report no not found.";
                    }
                }else if(actionName.equalsIgnoreCase("insert") ){
                    System.out.println("Test Start Insert");
                    String seriesNo = NumberSeriesDL.getNumberSeries(cp, Constraint.NumberSeries.PROGRESS_REPORT_NO_SERIES);
                    System.out.println("seriesNo:" + seriesNo );
                    if(Util.isValidString(seriesNo)){
                        progressReportNo = NumberSeriesDL.getSerialNumber(cp,seriesNo);
                        System.out.println("progressReportNo:" + progressReportNo );
                        if(Util.isValidString(progressReportNo)){

                            ProgressReportManage prm = setRequestObject(request, cp,userID, progressReportNo, seriesNo,true);

                            int insert = progressReportDL.insertProgressReport(cp,prm,patient);
                            System.out.println("insert:" + insert );

                            if(insert>0){
                                message = Constraint.Message.ADD_PROGRESS_REPORT;
                            }else {
                                hasError = true;
                                message = Constraint.Message.TRANSACTION_ERROR;
                            }

                            System.out.println("insert message:" + message );

                        } else {
                            message = Constraint.Message.NUMBER_SERIES_GENERATION_FAILED;
                        }
                    }else {
                        hasError = true;
                        message = Constraint.Message.NUMBER_SERIES_GENERATION_FAILED;
                    }
                }else if(actionName.equalsIgnoreCase("update") ){
                    
                        progressReportNo = Util.parseString( request.getParameter("progressReportNo") );
                    System.out.println("Test progressReportNo in Update Block:" + progressReportNo );
                        if(Util.isValidString(progressReportNo)){
                            System.out.println("Test found progressReportNo");
                            String seriesNo = "";
                            ProgressReportManage prm = setRequestObject(request, cp, userID, progressReportNo, seriesNo,false);

                            int update = progressReportDL.updateProgressReport( cp, prm, patient );

                            System.out.println("Test Update Result: " + update );
                            if(update>0){
                                message = Constraint.Message.UPDATE_PROGRESS_REPORT;
                            }else {
                                hasError = true;
                                message = Constraint.Message.TRANSACTION_ERROR;
                            }

                        } else {
                            message = "Progress report number not found.";
                            somethingWrong = true;
                        }
                    
                }

                if(!somethingWrong && !hasError){
                    triageInformation = triageInformationDL.getTriageInformationPatientID(cp,patientID);
                    if(triageInformation==null){
                        hasError = true;
                        message = Constraint.Message.TRANSACTION_ERROR;
                    }else {
                        System.out.println("Found Triage Information");
                        patient.setTriageInformation(triageInformation);
                    }
                }



            }else{
                somethingWrong = true;
            }
        }


        System.out.println("hasError:" + hasError );
        System.out.println("somethingWrong:" + somethingWrong );
        //if invalid country code
        if( !serverSetting ){
            //System.out.println("isPatient ajax:" + isPatient );
            //System.out.println("message ajax:" + message );
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", Constraint.Message.SERVER_SETTINGS_NOT_FOUND );
            out.println(myObj.toString());
        }
        else if( somethingWrong || hasError ){
            //System.out.println("isPatient ajax:" + isPatient );
            //System.out.println("message ajax:" + message );
            JsonObject myObj = new JsonObject();
            myObj.addProperty("success", false);
            myObj.addProperty("message", message);
            out.println(myObj.toString());
        }
        //if a valid credential was sent
        else {
            //System.out.println("Test Success AJAX:" + currentOrderList.size() );


            Gson gson = new Gson();
            //creates json from user object
            JsonElement patientObj = gson.toJsonTree(patient);
            //create a new JSON object
            JsonObject myObj = new JsonObject();
            //add property as success
            myObj.addProperty("success", true);
            myObj.addProperty("message", message);
            //add the user object
            myObj.add("patientInfo", patientObj);

            //convert the JSON to string and send back
            out.println(myObj.toString());
            //-----------------------

        }
        out.close();
    }

    private ProgressReportManage setRequestObject(HttpServletRequest request, ConnectionParameter cp,String userID, String progressReportNo, String seriesNo, boolean isInsert) {

        ProgressReportManage prm = null;

        String doctorCode = "";
        String createdBy = "";
        String creationDateTime = "";
        String lastModifiedBy = "";
        String lastModificationDatetime = "";

        if(isInsert){
            prm = new ProgressReportManage();
            doctorCode = userID;
            createdBy = userID;
            creationDateTime = MyDate.getCurrentDateAsString(Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS );
            lastModificationDatetime = Constraint.DateFormat.DEFAULT_DATE_1753;
        }else {
            ProgressReportDL progressReportDL = new ProgressReportDL();
            prm = progressReportDL.getProgressReportManage(cp,progressReportNo);
            createdBy = prm.getCreatedBy();
            lastModifiedBy = userID;
            creationDateTime = prm.getCreationDateTime();
            lastModificationDatetime = MyDate.getCurrentDateAsString(Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS );
            seriesNo = prm.getNoSeries();
        }

        System.out.println("creationDateTime:" + creationDateTime );
        System.out.println("lastModificationDatetime:" + lastModificationDatetime );

        prm.setProgressReportNo(progressReportNo);
        prm.setNoSeries(seriesNo);

        String dateOfExam = MyDate.getCurrentDateAsString( Constraint.DateFormat.DF_YYYY_MM_DD );
        String timeOfExam = Constraint.DateFormat.DEFAULT_DATE + " " + MyDate.getCurrentDateAsString( Constraint.DateFormat.TF_24HH_MM_SS ) ;

        int diarrhoeaDuration = Util.parseInt(request.getParameter("diarrhoeaDuration"));
        int ddlDiarrhoeaDurationIn = Util.parseInt(request.getParameter("ddlDiarrhoeaDurationIn"));
        int ddlGeneralCondition = Util.parseInt(request.getParameter("ddlGeneralCondition"));
        int ddlVomiting = Util.parseInt(request.getParameter("ddlVomiting"));
        int ddlRadialPulse = Util.parseInt(request.getParameter("ddlRadialPulse"));
        int ddlDehydration = Util.parseInt(request.getParameter("ddlDehydration"));
        int ddlStool = Util.parseInt(request.getParameter("ddlStool"));
        int boolBloodInStool = Util.parseInt(request.getParameter("boolBloodInStool"));
        int boolFever = Util.parseInt(request.getParameter("boolFever"));
        int boolCough = Util.parseInt(request.getParameter("boolCough"));
        int boolAbdominalDistention = Util.parseInt(request.getParameter("boolAbdominalDistention"));
        int boolAbdominalTenderness = Util.parseInt(request.getParameter("boolAbdominalTenderness"));

        int ddlBreathing = Util.parseInt(request.getParameter("ddlBreathing"));
        int boolChestRetraction = Util.parseInt(request.getParameter("boolChestRetraction"));
        int boolUrineNotPassed = Util.parseInt(request.getParameter("boolUrineNotPassed"));
        int urineNotPassedDuration = Util.parseInt(request.getParameter("urineNotPassedDuration"));
        int ddlUrineNotPassedDurationIn = Util.parseInt(request.getParameter("ddlUrineNotPassedDurationIn"));
        int ddlBowelSound = Util.parseInt(request.getParameter("ddlBowelSound"));
        int ddlHeart = Util.parseInt(request.getParameter("ddlHeart"));
        int ddlLungs = Util.parseInt(request.getParameter("ddlLungs"));

        String otherFindings1 = Util.parseString(request.getParameter("otherFindings1"));
        String otherFindings2 = Util.parseString(request.getParameter("otherFindings2"));
        String otherFindings3 = Util.parseString(request.getParameter("otherFindings3"));

        String clinicalDiagnosis = Util.parseString(request.getParameter("clinicalDiagnosis"));
        int ddlPatientCondition = Util.parseInt(request.getParameter("ddlPatientCondition"));
        int ddlCholeraLikeIllness = Util.parseInt(request.getParameter("ddlCholeraLikeIllness"));


        int boolApprovedByDoctor = Util.parseInt(request.getParameter("boolApprovedByDoctor"));
        String approvalTime = Constraint.DateFormat.DEFAULT_DATE + " " + MyDate.getCurrentDateAsString( Constraint.DateFormat.TF_24HH_MM_SS );


        System.out.println("timeOfExam:" + timeOfExam );
        System.out.println("approvalTime:" + approvalTime );

        prm.setDateOfExam(dateOfExam);
        prm.setTimeOfExam(timeOfExam);

        prm.setDiarrhoeaDuration(diarrhoeaDuration);
        prm.setDdlDiarrhoeaDurationIn(ddlDiarrhoeaDurationIn);
        prm.setDdlVomiting(ddlVomiting);
        prm.setDdlDehydration(ddlDehydration);

        prm.setDdlRadialPulse(ddlRadialPulse);
        prm.setDdlGeneralCondition(ddlGeneralCondition);
        prm.setDdlStool(ddlStool);
        prm.setBoolBloodInStool(boolBloodInStool);
        prm.setBoolFever(boolFever);
        prm.setBoolCough(boolCough);
        prm.setBoolAbdominalDistention(boolAbdominalDistention);
        prm.setBoolAbdominalTenderness(boolAbdominalTenderness);
        prm.setDdlBreathing(ddlBreathing);
        prm.setBoolChestRetraction(boolChestRetraction);
        prm.setBoolUrineNotPassed(boolUrineNotPassed);
        prm.setUrineNotPassedDuration(urineNotPassedDuration);
        prm.setDdlUrineNotPassedDurationIn(ddlUrineNotPassedDurationIn);
        prm.setDdlBowelSound(ddlBowelSound);
        prm.setDdlHeart(ddlHeart);
        prm.setDdlLungs(ddlLungs);
        prm.setOtherFindings1(otherFindings1);
        prm.setOtherFindings2(otherFindings2);
        prm.setOtherFindings3(otherFindings3);
        prm.setClinicalDiagnosis(clinicalDiagnosis);
        prm.setDdlPatientCondition(ddlPatientCondition);
        prm.setDdlCholeraLikeIllness(ddlCholeraLikeIllness);
        prm.setDoctorCode(doctorCode);
        prm.setBoolApprovedByDoctor(boolApprovedByDoctor);
        prm.setApprovalTime(approvalTime);
        prm.setCreatedBy(createdBy);
        prm.setCreationDateTime(creationDateTime);
        prm.setLastModifiedBy(lastModifiedBy);
        prm.setLastModificationDatetime(lastModificationDatetime);

        return prm;
    }

}
