package org.icddrb.shebaservices.db;

import org.icddrb.shebaservices.Utility.EnumArray;

import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserSetup implements Serializable {
    
    public String userID = null;
    public  String empID = null;
    public  String emailID = null;
    public  int progressReport;
    public  int  doctorsOrder;
    public  int  dischargeAdvice;
    public  int  patientIntake;
    public  int  patientOutput;
    public  int  dietRequirement;
    public  int  vitalSign;
    public  int  drugAdministration;
    public  int  wardTransfer;
    public  int  bedIDVerification;
    public  int  userType;  //  ,Doctor, Nurse,Fellow,Dietician, Health Worker
    public  int  doctorType;  // , Senior, Fellow
    public  int  twentyFourHourAccess;
    public  int  generateDietRequisition;
    public  int  viewDietRequisition;
    public  int  canteenDietRequisition;
    public  int  dietSetup;
    public  int  dietSetupAdmin;
    public  int  applicableForSSULabReq;

    public EnumArray enumArray;
    public  int  anyRule;


    public UserSetup(){
        this.enumArray = new EnumArray();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(int progressReport) {
        this.progressReport = progressReport;
    }

    public int getDoctorsOrder() {
        return doctorsOrder;
    }

    public void setDoctorsOrder(int doctorsOrder) {
        this.doctorsOrder = doctorsOrder;
    }

    public int getDischargeAdvice() {
        return dischargeAdvice;
    }

    public void setDischargeAdvice(int dischargeAdvice) {
        this.dischargeAdvice = dischargeAdvice;
    }

    public int getPatientIntake() {
        return patientIntake;
    }

    public void setPatientIntake(int patientIntake) {
        this.patientIntake = patientIntake;
    }

    public int getPatientOutput() {
        return patientOutput;
    }

    public void setPatientOutput(int patientOutput) {
        this.patientOutput = patientOutput;
    }

    public int getDietRequirement() {
        return dietRequirement;
    }

    public void setDietRequirement(int dietRequirement) {
        this.dietRequirement = dietRequirement;
    }

    public int getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(int vitalSign) {
        this.vitalSign = vitalSign;
    }

    public int getDrugAdministration() {
        return drugAdministration;
    }

    public void setDrugAdministration(int drugAdministration) {
        this.drugAdministration = drugAdministration;
    }

    public int getWardTransfer() {
        return wardTransfer;
    }

    public void setWardTransfer(int wardTransfer) {
        this.wardTransfer = wardTransfer;
    }

    public int getBedIDVerification() {
        return bedIDVerification;
    }

    public void setBedIDVerification(int bedIDVerification) {
        this.bedIDVerification = bedIDVerification;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(int doctorType) {
        this.doctorType = doctorType;
    }

    public int getTwentyFourHourAccess() {
        return twentyFourHourAccess;
    }

    public void setTwentyFourHourAccess(int twentyFourHourAccess) {
        this.twentyFourHourAccess = twentyFourHourAccess;
    }

    public int getGenerateDietRequisition() {
        return generateDietRequisition;
    }

    public void setGenerateDietRequisition(int generateDietRequisition) {
        this.generateDietRequisition = generateDietRequisition;
    }

    public int getViewDietRequisition() {
        return viewDietRequisition;
    }

    public void setViewDietRequisition(int viewDietRequisition) {
        this.viewDietRequisition = viewDietRequisition;
    }

    public int getCanteenDietRequisition() {
        return canteenDietRequisition;
    }

    public void setCanteenDietRequisition(int canteenDietRequisition) {
        this.canteenDietRequisition = canteenDietRequisition;
    }

    public int getDietSetup() {
        return dietSetup;
    }

    public void setDietSetup(int dietSetup) {
        this.dietSetup = dietSetup;
    }

    public int getDietSetupAdmin() {
        return dietSetupAdmin;
    }

    public void setDietSetupAdmin(int dietSetupAdmin) {
        this.dietSetupAdmin = dietSetupAdmin;
    }

    public int getApplicableForSSULabReq() {
        return applicableForSSULabReq;
    }

    public void setApplicableForSSULabReq(int applicableForSSULabReq) {
        this.applicableForSSULabReq = applicableForSSULabReq;
    }

    public int getAnyRule() {
        return anyRule;
    }

    public void setAnyRule(int anyRule) {
        this.anyRule = anyRule;
    }
}
