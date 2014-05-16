package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/13/14
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FluidPrescriptionLine implements Serializable {

    public String strStoppedDateTime="";
    public String decTotalDuration=""; // decDiffHours
    public int intScheduledGenerated;
    public String decActualDose="";   // decNoofDose
    public String decSingleDispensePower="";
    public String strDoctorCode="";
    public String strDoctorName="";
    public String submissionDateTime="";
    public int intCount;   //intTotalSchedule
    public String decQuantity="";  //decNoofDose * intTotalSchedule
    public int intChannelType;
    public String strDrugUOM="";
    public String decDuration="";  //decDiffHours * 60 * 60 * 1000
    public int intChannelNo;      //intTempChannelNo + 1
    public int intDurationType;
    public int intDurationIn;
    public int intDurationValue;

    public FluidPrescriptionLine(){

    }

    public String getStrStoppedDateTime() {
        return strStoppedDateTime;
    }

    public void setStrStoppedDateTime(String strStoppedDateTime) {
        this.strStoppedDateTime = strStoppedDateTime;
    }

    public String getDecTotalDuration() {
        return decTotalDuration;
    }

    public void setDecTotalDuration(String decTotalDuration) {
        this.decTotalDuration = decTotalDuration;
    }

    public int getIntScheduledGenerated() {
        return intScheduledGenerated;
    }

    public void setIntScheduledGenerated(int intScheduledGenerated) {
        this.intScheduledGenerated = intScheduledGenerated;
    }

    public String getDecActualDose() {
        return decActualDose;
    }

    public void setDecActualDose(String decActualDose) {
        this.decActualDose = decActualDose;
    }

    public String getDecSingleDispensePower() {
        return decSingleDispensePower;
    }

    public void setDecSingleDispensePower(String decSingleDispensePower) {
        this.decSingleDispensePower = decSingleDispensePower;
    }

    public String getStrDoctorCode() {
        return strDoctorCode;
    }

    public void setStrDoctorCode(String strDoctorCode) {
        this.strDoctorCode = strDoctorCode;
    }

    public String getStrDoctorName() {
        return strDoctorName;
    }

    public void setStrDoctorName(String strDoctorName) {
        this.strDoctorName = strDoctorName;
    }

    public String getSubmissionDateTime() {
        return submissionDateTime;
    }

    public void setSubmissionDateTime(String submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public int getIntCount() {
        return intCount;
    }

    public void setIntCount(int intCount) {
        this.intCount = intCount;
    }

    public String getDecQuantity() {
        return decQuantity;
    }

    public void setDecQuantity(String decQuantity) {
        this.decQuantity = decQuantity;
    }

    public int getIntChannelType() {
        return intChannelType;
    }

    public void setIntChannelType(int intChannelType) {
        this.intChannelType = intChannelType;
    }

    public String getStrDrugUOM() {
        return strDrugUOM;
    }

    public void setStrDrugUOM(String strDrugUOM) {
        this.strDrugUOM = strDrugUOM;
    }

    public String getDecDuration() {
        return decDuration;
    }

    public void setDecDuration(String decDuration) {
        this.decDuration = decDuration;
    }

    public int getIntChannelNo() {
        return intChannelNo;
    }

    public void setIntChannelNo(int intChannelNo) {
        this.intChannelNo = intChannelNo;
    }

    public int getIntDurationType() {
        return intDurationType;
    }

    public void setIntDurationType(int intDurationType) {
        this.intDurationType = intDurationType;
    }

    public int getIntDurationIn() {
        return intDurationIn;
    }

    public void setIntDurationIn(int intDurationIn) {
        this.intDurationIn = intDurationIn;
    }

    public int getIntDurationValue() {
        return intDurationValue;
    }

    public void setIntDurationValue(int intDurationValue) {
        this.intDurationValue = intDurationValue;
    }
}
