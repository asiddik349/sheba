package org.icddrb.shebaservices.db;

import org.icddrb.shebaservices.enums.*;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/24/14
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgressReport implements Serializable {

    // Box Title Information
    public String progressReportNo;
    public String formattedDateOfExam;  // Not DB Field
    public String formattedTimeOfExam;  // Not DB Field
    // End Box Title

    // Main Box
    public int diarrhoeaDuration; // Number
    public String tranDiarrhoeaDurationIn; // Drop down

    public int boolUrineNotPassed; // True/False
    public int urineNotPassedDuration; // Number
    public String tranUrineNotPassedDurationIn; // Drop down

    public int boolBloodInStool; // True/False
    public String tranDehydration; // Drop down
    public String tranGeneralCondition; // Drop down
    public String tranVomiting;
    public int boolFever;  // True/False
    public int boolCough;  // True/False
    public String tranRadialPulse;   // Drop down

    public String tranStool;  // Drop down
    public String tranBreathing; // Drop down
    public String tranBowelSound; // Drop down                s
    public String tranHeart;  // Drop down
    public String tranLungs;  // Drop down
    public String tranPatientCondition; // Drop down
    public String tranCholeraLikeIllness;    // Drop down ; Yes, No

    public int boolAbdominalDistention; // True/False
    public int boolAbdominalTenderness; // True/False
    public int boolChestRetraction; // True/False

    public String otherFindings1;
    public String otherFindings2;
    public String otherFindings3;
    public String clinicalDiagnosis;
    public String doctorCode;

    // End Main Box

    public int boolApprovedByDoctor; // True/False

    public String dateOfExam;
    public String timeOfExam;

    public String patientID; // Come from CurrentHospitalPatient Object
    public String uhID; // Come from CurrentHospitalPatient Object
    public String patientName; // Come from CurrentHospitalPatient Object
    public String age; // // Come from CurrentHospitalPatient Object; Calculate Year, Month and Day
    public int sex;  // Come from CurrentHospitalPatient Object;
    public String dateOfAdmission; // Come from CurrentHospitalPatient Object
    public String timeOfAdmission; // Come from CurrentHospitalPatient Object

    public String approvalTime;
    public String noSeries;

    public String createdBy;
    public String creationDateTime;

    public String lastModifiedBy;
    public String lastModificationDatetime;

    public int ddlDiarrhoeaDurationIn; // Drop down
    public int ddlUrineNotPassedDurationIn; // Drop down
    public int ddlGeneralCondition; // Drop down
    public int ddlRadialPulse;   // Drop down
    public int ddlDehydration; // Drop down
    public int ddlStool;  // Drop down
    public int ddlBreathing; // Drop down
    public int ddlBowelSound; // Drop down
    public int ddlHeart;  // Drop down
    public int ddlLungs;  // Drop down
    public int ddlPatientCondition; // Drop down
    public int ddlCholeraLikeIllness;    // Drop down ; Yes, No
    public int ddlVomiting; // Drop Down

    // Transient ---------




    public String tranSexName; // Male/Female
    // End Transient ----------

    public String formattedApprovalTime;    // Not DB Field
    public String formattedDateOfAdmission;   // Not DB Field
    public String formattedTimeOfAdmission;  // Not DB Field




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

    public int getDiarrhoeaDuration() {
        return diarrhoeaDuration;
    }

    public void setDiarrhoeaDuration(int diarrhoeaDuration) {
        this.diarrhoeaDuration = diarrhoeaDuration;
    }

    public int getUrineNotPassedDuration() {
        return urineNotPassedDuration;
    }

    public void setUrineNotPassedDuration(int urineNotPassedDuration) {
        this.urineNotPassedDuration = urineNotPassedDuration;
    }

    public int getDdlDiarrhoeaDurationIn() {
        return ddlDiarrhoeaDurationIn;
    }

    public void setDdlDiarrhoeaDurationIn(int ddlDiarrhoeaDurationIn) {
        this.ddlDiarrhoeaDurationIn = ddlDiarrhoeaDurationIn;
    }

    public int getDdlUrineNotPassedDurationIn() {
        return ddlUrineNotPassedDurationIn;
    }

    public void setDdlUrineNotPassedDurationIn(int ddlUrineNotPassedDurationIn) {
        this.ddlUrineNotPassedDurationIn = ddlUrineNotPassedDurationIn;
    }

    public int getDdlGeneralCondition() {
        return ddlGeneralCondition;
    }

    public void setDdlGeneralCondition(int ddlGeneralCondition) {
        this.ddlGeneralCondition = ddlGeneralCondition;
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

    public int getDdlBreathing() {
        return ddlBreathing;
    }

    public void setDdlBreathing(int ddlBreathing) {
        this.ddlBreathing = ddlBreathing;
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

    public int getBoolUrineNotPassed() {
        return boolUrineNotPassed;
    }

    public void setBoolUrineNotPassed(int boolUrineNotPassed) {
        this.boolUrineNotPassed = boolUrineNotPassed;
    }

    public String getTranVomiting() {
        //return tranVomiting;
        return VomitingEnum.values()[this.getDdlVomiting()].getName();
    }

    public void setTranVomiting(String tranVomiting) {
        this.tranVomiting = tranVomiting;
    }

    public int getDdlVomiting() {
        return ddlVomiting;
    }

    public void setDdlVomiting(int ddlVomiting) {
        this.ddlVomiting = ddlVomiting;
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

    public int getBoolChestRetraction() {
        return boolChestRetraction;
    }

    public void setBoolChestRetraction(int boolChestRetraction) {
        this.boolChestRetraction = boolChestRetraction;
    }

    public int getBoolApprovedByDoctor() {
        return boolApprovedByDoctor;
    }

    public void setBoolApprovedByDoctor(int boolApprovedByDoctor) {
        this.boolApprovedByDoctor = boolApprovedByDoctor;
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

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
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

    public String getTranDiarrhoeaDurationIn() {
        //return tranDiarrhoeaDurationIn;
        return DiarrhoeaDurationInEnum.values()[this.getDdlDiarrhoeaDurationIn()].getName();
    }

    public void setTranDiarrhoeaDurationIn(String tranDiarrhoeaDurationIn) {
        this.tranDiarrhoeaDurationIn = tranDiarrhoeaDurationIn;
    }

    public String getTranUrineNotPassedDurationIn() {
        //return tranUrineNotPassedDurationIn;
        return UrineNotPassedDurationInEnum.values()[this.getDdlUrineNotPassedDurationIn()].getName();
    }

    public void setTranUrineNotPassedDurationIn(String tranUrineNotPassedDurationIn) {
        this.tranUrineNotPassedDurationIn = tranUrineNotPassedDurationIn;
    }

    public String getTranGeneralCondition() {
        //return tranGeneralCondition;
        return GeneralConditionEnum.values()[this.getDdlGeneralCondition()].getName();
    }

    public void setTranGeneralCondition(String tranGeneralCondition) {
        this.tranGeneralCondition = tranGeneralCondition;
    }

    public String getTranRadialPulse() {
        //return tranRadialPulse;
        return RadialPulseEnum.values()[this.getDdlRadialPulse()].getName();
    }

    public void setTranRadialPulse(String tranRadialPulse) {
        this.tranRadialPulse = tranRadialPulse;
    }

    public String getTranDehydration() {
        //return tranDehydration;
        return DehydrationEnum.values()[this.getDdlDehydration()].getName();
    }

    public void setTranDehydration(String tranDehydration) {
        this.tranDehydration = tranDehydration;
    }

    public String getTranStool() {
        //return tranStool;
        return StoolEnum.values()[this.getDdlStool()].getName();
    }

    public void setTranStool(String tranStool) {
        this.tranStool = tranStool;
    }

    public String getTranBreathing() {
        //return tranBreathing;
        return BreathingEnum.values()[this.getDdlBreathing()].getName();
    }

    public void setTranBreathing(String tranBreathing) {
        this.tranBreathing = tranBreathing;
    }

    public String getTranBowelSound() {
        //return tranBowelSound;
        return BowelSoundEnum.values()[this.getDdlBowelSound()].getName();
    }

    public void setTranBowelSound(String tranBowelSound) {
        this.tranBowelSound = tranBowelSound;
    }

    public String getTranHeart() {
        //return tranHeart;
        return HeartEnum.values()[this.getDdlHeart()].getName();
    }

    public void setTranHeart(String tranHeart) {
        this.tranHeart = tranHeart;
    }

    public String getTranLungs() {
        //return tranLungs;
        return LungsEnum.values()[this.getDdlLungs()].getName();
    }

    public void setTranLungs(String tranLungs) {
        this.tranLungs = tranLungs;
    }

    public String getTranPatientCondition() {
        //return tranPatientCondition;
        return PatientConditionEnum.values()[this.getDdlPatientCondition()].getName();
    }

    public void setTranPatientCondition(String tranPatientCondition) {
        this.tranPatientCondition = tranPatientCondition;
    }

    public String getTranCholeraLikeIllness() {
        //return tranCholeraLikeIllness;
        return CholeraLikeIllnessEnum.values()[this.getDdlCholeraLikeIllness()].getName();
    }

    public void setTranCholeraLikeIllness(String tranCholeraLikeIllness) {
        this.tranCholeraLikeIllness = tranCholeraLikeIllness;
    }

    public String getTranSexName() {
        return SexEnum.values()[this.getSex()].getName();
        //return tranSexName;
    }

    public void setTranSexName(String tranSexName) {
        this.tranSexName = tranSexName;
    }

    public String getFormattedApprovalTime() {
        return formattedApprovalTime;
    }

    public void setFormattedApprovalTime(String formattedApprovalTime) {
        this.formattedApprovalTime = formattedApprovalTime;
    }

    public String getFormattedDateOfAdmission() {
        return formattedDateOfAdmission;
    }

    public void setFormattedDateOfAdmission(String formattedDateOfAdmission) {
        this.formattedDateOfAdmission = formattedDateOfAdmission;
    }

    public String getFormattedTimeOfAdmission() {
        return formattedTimeOfAdmission;
    }

    public void setFormattedTimeOfAdmission(String formattedTimeOfAdmission) {
        this.formattedTimeOfAdmission = formattedTimeOfAdmission;
    }

    public String getFormattedDateOfExam() {
        return formattedDateOfExam;
    }

    public void setFormattedDateOfExam(String formattedDateOfExam) {
        this.formattedDateOfExam = formattedDateOfExam;
    }

    public String getFormattedTimeOfExam() {
        return formattedTimeOfExam;
    }

    public void setFormattedTimeOfExam(String formattedTimeOfExam) {
        this.formattedTimeOfExam = formattedTimeOfExam;
    }
}
