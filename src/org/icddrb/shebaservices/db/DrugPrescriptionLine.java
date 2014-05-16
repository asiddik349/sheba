package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/13/14
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DrugPrescriptionLine implements Serializable {

    public String strStoppedDateTime="";
    public String decTotalDuration="";  // Decimal
    public int intScheduledGenerated;
    public String decNoOfDoses=""; // Decimal
    public String strSingleDoseUOM="";
    public String decSingleDispensePower="";
    public int intFullDay;
    public String strDoctorCode="";
    public String strDoctorName="";
    public String submissionDateTime="";
    public int intDoses;  // Total Schedule
    public String decPharmacyActualDispense="";
    public String pharmacyUOM="";
    public int intPharmacyUOMConversionError;
    public int strCreatedByDoctor;
    public String strWardCode="";


    public DrugPrescriptionLine(){


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

    public String getDecNoOfDoses() {
        return decNoOfDoses;
    }

    public void setDecNoOfDoses(String decNoOfDoses) {
        this.decNoOfDoses = decNoOfDoses;
    }

    public String getStrSingleDoseUOM() {
        return strSingleDoseUOM;
    }

    public void setStrSingleDoseUOM(String strSingleDoseUOM) {
        this.strSingleDoseUOM = strSingleDoseUOM;
    }

    public String getDecSingleDispensePower() {
        return decSingleDispensePower;
    }

    public void setDecSingleDispensePower(String decSingleDispensePower) {
        this.decSingleDispensePower = decSingleDispensePower;
    }

    public int getIntFullDay() {
        return intFullDay;
    }

    public void setIntFullDay(int intFullDay) {
        this.intFullDay = intFullDay;
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

    public int getIntDoses() {
        return intDoses;
    }

    public void setIntDoses(int intDoses) {
        this.intDoses = intDoses;
    }

    public String getDecPharmacyActualDispense() {
        return decPharmacyActualDispense;
    }

    public void setDecPharmacyActualDispense(String decPharmacyActualDispense) {
        this.decPharmacyActualDispense = decPharmacyActualDispense;
    }

    public String getPharmacyUOM() {
        return pharmacyUOM;
    }

    public void setPharmacyUOM(String pharmacyUOM) {
        this.pharmacyUOM = pharmacyUOM;
    }

    public int getIntPharmacyUOMConversionError() {
        return intPharmacyUOMConversionError;
    }

    public void setIntPharmacyUOMConversionError(int intPharmacyUOMConversionError) {
        this.intPharmacyUOMConversionError = intPharmacyUOMConversionError;
    }

    public int getStrCreatedByDoctor() {
        return strCreatedByDoctor;
    }

    public void setStrCreatedByDoctor(int strCreatedByDoctor) {
        this.strCreatedByDoctor = strCreatedByDoctor;
    }

    public String getStrWardCode() {
        return strWardCode;
    }

    public void setStrWardCode(String strWardCode) {
        this.strWardCode = strWardCode;
    }
}
