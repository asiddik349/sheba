package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/15/14
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoctorOrder implements Serializable {

    public String patientID;
    public int lineNumber;
    public String prescriptionID;
    public String drugInventory;  // Internal, external
    public String doctorCode;
    public String drugCode;
    public String drugUsingType; // Regular, etc
    public String drugName;
    public String dose;
    public String UOM;
    public String frequency; // Q1H, etc
    public String route; // IV,ID etc
    private String drugType; // 0 = None, 1 = Drug, 2 = FLUID
    public String startDate;
    public int noOfDays;
    public String endDate;
    public String noOfDose;  // Decimal
    public String remarks;
    
    public String prescriptionDate;
    public int stopped;
    public int dischargedPrescription;
    public int prescriptionLineTable;
    public int drugStopped;

    public String getPatientID() {
        return patientID;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public int getDrugStopped() {
        return drugStopped;
    }

    public void setDrugStopped(int drugStopped) {
        this.drugStopped = drugStopped;
    }

    public String getPrescriptionID() {

        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getDrugInventory() {
        return drugInventory;
    }

    public void setDrugInventory(String drugInventory) {
        this.drugInventory = drugInventory;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDrugUsingType() {
        return drugUsingType;
    }

    public void setDrugUsingType(String drugUsingType) {
        this.drugUsingType = drugUsingType;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNoOfDose() {
        return noOfDose;
    }

    public void setNoOfDose(String noOfDose) {
        this.noOfDose = noOfDose;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public int getStopped() {
        return stopped;
    }

    public void setStopped(int stopped) {
        this.stopped = stopped;
    }

    public int getDischargedPrescription() {
        return dischargedPrescription;
    }

    public void setDischargedPrescription(int dischargedPrescription) {
        this.dischargedPrescription = dischargedPrescription;
    }

    public int getPrescriptionLineTable() {
        return prescriptionLineTable;
    }

    public void setPrescriptionLineTable(int prescriptionLineTable) {
        this.prescriptionLineTable = prescriptionLineTable;
    }
}
