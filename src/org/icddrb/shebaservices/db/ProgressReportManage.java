package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgressReportManage implements Serializable {


    public String progressReportNo;

    // Comes from CurrentHospitalPatient
    public String patientID; // Come from CurrentHospitalPatient Object
    public String uhID; // Come from CurrentHospitalPatient Object
    public String patientName; // Come from CurrentHospitalPatient Object
    public String age; // // Come from CurrentHospitalPatient Object; Calculate Year, Month and Day
    public int sex;  // Come from CurrentHospitalPatient Object;
    public String dateOfAdmission; // Come from CurrentHospitalPatient Object
    public String timeOfAdmission; // Come from CurrentHospitalPatient Object

    // End Box Title

    // Main Info
    public int diarrhoeaDuration; // Number
    public int ddlDiarrhoeaDurationIn; // Drop down
    public int ddlGeneralCondition; // Drop down
    public int ddlVomiting; // Drop Down
    public int ddlRadialPulse;   // Drop down
    public int ddlDehydration; // Drop down
    public int ddlStool;  // Drop down

    public int boolBloodInStool; // True/False
    public int boolFever;  // True/False
    public int boolCough;  // True/False
    public int boolAbdominalDistention; // True/False
    public int boolAbdominalTenderness; // True/False
    public int ddlBreathing; // Drop down
    public int boolChestRetraction; // True/False
    public int boolUrineNotPassed; // True/False
    public int urineNotPassedDuration; // Number
    public int ddlUrineNotPassedDurationIn; // Drop down
    public int ddlBowelSound; // Drop down
    public int ddlHeart;  // Drop down
    public int ddlLungs;  // Drop down
    public String otherFindings1;
    public String otherFindings2;
    public String otherFindings3;
    public String clinicalDiagnosis;
    public int ddlPatientCondition; // Drop down
    public int ddlCholeraLikeIllness;    // Drop down ; Yes, No
    public String doctorCode; // LoggedInUser ID, Read Only
    public int boolApprovedByDoctor; // True/False

    // End Main Info
    public String dateOfExam;
    public String timeOfExam;
    public String approvalTime;

    // System Field
    public String noSeries;  // From Number Series
    public String createdBy;
    public String creationDateTime;
    public String lastModifiedBy;
    public String lastModificationDatetime;

    public ProgressReportManage(){

    }

    public String getProgressReportNo() {
        return progressReportNo;
    }

    public void setProgressReportNo(String progressReportNo) {
        this.progressReportNo = progressReportNo;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getUhID() {
        return uhID;
    }

    public void setUhID(String uhID) {
        this.uhID = uhID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getTimeOfAdmission() {
        return timeOfAdmission;
    }

    public void setTimeOfAdmission(String timeOfAdmission) {
        this.timeOfAdmission = timeOfAdmission;
    }

    public int getDiarrhoeaDuration() {
        return diarrhoeaDuration;
    }

    public void setDiarrhoeaDuration(int diarrhoeaDuration) {
        this.diarrhoeaDuration = diarrhoeaDuration;
    }

    public int getDdlDiarrhoeaDurationIn() {
        return ddlDiarrhoeaDurationIn;
    }

    public void setDdlDiarrhoeaDurationIn(int ddlDiarrhoeaDurationIn) {
        this.ddlDiarrhoeaDurationIn = ddlDiarrhoeaDurationIn;
    }

    public int getDdlGeneralCondition() {
        return ddlGeneralCondition;
    }

    public void setDdlGeneralCondition(int ddlGeneralCondition) {
        this.ddlGeneralCondition = ddlGeneralCondition;
    }

    public int getDdlVomiting() {
        return ddlVomiting;
    }

    public void setDdlVomiting(int ddlVomiting) {
        this.ddlVomiting = ddlVomiting;
    }

    public int getDdlRadialPulse() {
        return ddlRadialPulse;
    }

    public void setDdlRadialPulse(int ddlRadialPulse) {
        this.ddlRadialPulse = ddlRadialPulse;
    }

    public int getDdlDehydration() {
        return ddlDehydration;
    }

    public void setDdlDehydration(int ddlDehydration) {
        this.ddlDehydration = ddlDehydration;
    }

    public int getDdlStool() {
        return ddlStool;
    }

    public void setDdlStool(int ddlStool) {
        this.ddlStool = ddlStool;
    }

    public int getBoolBloodInStool() {
        return boolBloodInStool;
    }

    public void setBoolBloodInStool(int boolBloodInStool) {
        this.boolBloodInStool = boolBloodInStool;
    }

    public int getBoolFever() {
        return boolFever;
    }

    public void setBoolFever(int boolFever) {
        this.boolFever = boolFever;
    }

    public int getBoolCough() {
        return boolCough;
    }

    public void setBoolCough(int boolCough) {
        this.boolCough = boolCough;
    }

    public int getBoolAbdominalDistention() {
        return boolAbdominalDistention;
    }

    public void setBoolAbdominalDistention(int boolAbdominalDistention) {
        this.boolAbdominalDistention = boolAbdominalDistention;
    }

    public int getBoolAbdominalTenderness() {
        return boolAbdominalTenderness;
    }

    public void setBoolAbdominalTenderness(int boolAbdominalTenderness) {
        this.boolAbdominalTenderness = boolAbdominalTenderness;
    }

    public int getDdlBreathing() {
        return ddlBreathing;
    }

    public void setDdlBreathing(int ddlBreathing) {
        this.ddlBreathing = ddlBreathing;
    }

    public int getBoolChestRetraction() {
        return boolChestRetraction;
    }

    public void setBoolChestRetraction(int boolChestRetraction) {
        this.boolChestRetraction = boolChestRetraction;
    }

    public int getBoolUrineNotPassed() {
        return boolUrineNotPassed;
    }

    public void setBoolUrineNotPassed(int boolUrineNotPassed) {
        this.boolUrineNotPassed = boolUrineNotPassed;
    }

    public int getUrineNotPassedDuration() {
        return urineNotPassedDuration;
    }

    public void setUrineNotPassedDuration(int urineNotPassedDuration) {
        this.urineNotPassedDuration = urineNotPassedDuration;
    }

    public int getDdlUrineNotPassedDurationIn() {
        return ddlUrineNotPassedDurationIn;
    }

    public void setDdlUrineNotPassedDurationIn(int ddlUrineNotPassedDurationIn) {
        this.ddlUrineNotPassedDurationIn = ddlUrineNotPassedDurationIn;
    }

    public int getDdlBowelSound() {
        return ddlBowelSound;
    }

    public void setDdlBowelSound(int ddlBowelSound) {
        this.ddlBowelSound = ddlBowelSound;
    }

    public int getDdlHeart() {
        return ddlHeart;
    }

    public void setDdlHeart(int ddlHeart) {
        this.ddlHeart = ddlHeart;
    }

    public int getDdlLungs() {
        return ddlLungs;
    }

    public void setDdlLungs(int ddlLungs) {
        this.ddlLungs = ddlLungs;
    }

    public String getOtherFindings1() {
        return otherFindings1;
    }

    public void setOtherFindings1(String otherFindings1) {
        this.otherFindings1 = otherFindings1;
    }

    public String getOtherFindings2() {
        return otherFindings2;
    }

    public void setOtherFindings2(String otherFindings2) {
        this.otherFindings2 = otherFindings2;
    }

    public String getOtherFindings3() {
        return otherFindings3;
    }

    public void setOtherFindings3(String otherFindings3) {
        this.otherFindings3 = otherFindings3;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public int getDdlPatientCondition() {
        return ddlPatientCondition;
    }

    public void setDdlPatientCondition(int ddlPatientCondition) {
        this.ddlPatientCondition = ddlPatientCondition;
    }

    public int getDdlCholeraLikeIllness() {
        return ddlCholeraLikeIllness;
    }

    public void setDdlCholeraLikeIllness(int ddlCholeraLikeIllness) {
        this.ddlCholeraLikeIllness = ddlCholeraLikeIllness;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public int getBoolApprovedByDoctor() {
        return boolApprovedByDoctor;
    }

    public void setBoolApprovedByDoctor(int boolApprovedByDoctor) {
        this.boolApprovedByDoctor = boolApprovedByDoctor;
    }

    public String getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(String dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public String getTimeOfExam() {
        return timeOfExam;
    }

    public void setTimeOfExam(String timeOfExam) {
        this.timeOfExam = timeOfExam;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getNoSeries() {
        return noSeries;
    }

    public void setNoSeries(String noSeries) {
        this.noSeries = noSeries;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModificationDatetime() {
        return lastModificationDatetime;
    }

    public void setLastModificationDatetime(String lastModificationDatetime) {
        this.lastModificationDatetime = lastModificationDatetime;
    }
}
