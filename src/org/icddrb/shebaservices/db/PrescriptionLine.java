package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/13/14
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionLine implements Serializable {

    public String strPrescriptionNo="";
    public int intLineNumber;
    public int intPrescriptionType;  //Regular, As Req/SOS, Single Dose/ORS, STAT
    public int intDrugType; // Drug, Fluid
    public int intFrequency;
    public int intDrugInventory;  // Internal, External ; Only for DRUG
    public String strDrugName="";
    public String strDrugCode="";

    public String decDose=""; // Decimal
    public String strUnitOfMeasure="";

    public int intRoute;
    public String strStartDate="";
    public String strStartTime="";
    public int intNoOfDays; //  Only for DRUG
    public String strEndDate="";
    public String strEndTime="";
    public String decTotalDose=""; // Decimal
    public String strRemarks="";

    public int intCholeraLikeIllness;  //  Only for DRUG
    public int intDehydrationStatus;   //  Only for DRUG

    public int intDurationType;       //  Only for Fluid
    public int intDurationIn;        //  Only for Fluid
    public int intDurationValue;    //  Only for Fluid


    public DrugPrescriptionLine drugPrescriptionLine = null;
    public FluidPrescriptionLine fluidPrescriptionLine = null;


    public PrescriptionLine(){

        this.drugPrescriptionLine = new DrugPrescriptionLine();
        this.fluidPrescriptionLine = new FluidPrescriptionLine();
    }

    public String getStrPrescriptionNo() {
        return strPrescriptionNo;
    }

    public void setStrPrescriptionNo(String strPrescriptionNo) {
        this.strPrescriptionNo = strPrescriptionNo;
    }

    public int getIntLineNumber() {
        return intLineNumber;
    }

    public void setIntLineNumber(int intLineNumber) {
        this.intLineNumber = intLineNumber;
    }

    public int getIntPrescriptionType() {
        return intPrescriptionType;
    }

    public void setIntPrescriptionType(int intPrescriptionType) {
        this.intPrescriptionType = intPrescriptionType;
    }

    public int getIntDrugType() {
        return intDrugType;
    }

    public void setIntDrugType(int intDrugType) {
        this.intDrugType = intDrugType;
    }

    public int getIntDrugInventory() {
        return intDrugInventory;
    }

    public void setIntDrugInventory(int intDrugInventory) {
        this.intDrugInventory = intDrugInventory;
    }

    public String getStrDrugName() {
        return strDrugName;
    }

    public void setStrDrugName(String strDrugName) {
        this.strDrugName = strDrugName;
    }

    public String getStrDrugCode() {
        return strDrugCode;
    }

    public void setStrDrugCode(String strDrugCode) {
        this.strDrugCode = strDrugCode;
    }

    public String getDecDose() {
        return decDose;
    }

    public void setDecDose(String decDose) {
        this.decDose = decDose;
    }

    public String getStrUnitOfMeasure() {
        return strUnitOfMeasure;
    }

    public void setStrUnitOfMeasure(String strUnitOfMeasure) {
        this.strUnitOfMeasure = strUnitOfMeasure;
    }

    public int getIntFrequency() {
        return intFrequency;
    }

    public void setIntFrequency(int intFrequency) {
        this.intFrequency = intFrequency;
    }

    public int getIntRoute() {
        return intRoute;
    }

    public void setIntRoute(int intRoute) {
        this.intRoute = intRoute;
    }

    public String getStrStartDate() {
        return strStartDate;
    }

    public void setStrStartDate(String strStartDate) {
        this.strStartDate = strStartDate;
    }

    public String getStrStartTime() {
        return strStartTime;
    }

    public void setStrStartTime(String strStartTime) {
        this.strStartTime = strStartTime;
    }

    public int getIntNoOfDays() {
        return intNoOfDays;
    }

    public void setIntNoOfDays(int intNoOfDays) {
        this.intNoOfDays = intNoOfDays;
    }

    public String getStrEndDate() {
        return strEndDate;
    }

    public void setStrEndDate(String strEndDate) {
        this.strEndDate = strEndDate;
    }

    public String getStrEndTime() {
        return strEndTime;
    }

    public void setStrEndTime(String strEndTime) {
        this.strEndTime = strEndTime;
    }

    public String getDecTotalDose() {
        return decTotalDose;
    }

    public void setDecTotalDose(String decTotalDose) {
        this.decTotalDose = decTotalDose;
    }

    public String getStrRemarks() {
        return strRemarks;
    }

    public void setStrRemarks(String strRemarks) {
        this.strRemarks = strRemarks;
    }

    public int getIntCholeraLikeIllness() {
        return intCholeraLikeIllness;
    }

    public void setIntCholeraLikeIllness(int intCholeraLikeIllness) {
        this.intCholeraLikeIllness = intCholeraLikeIllness;
    }

    public int getIntDehydrationStatus() {
        return intDehydrationStatus;
    }

    public void setIntDehydrationStatus(int intDehydrationStatus) {
        this.intDehydrationStatus = intDehydrationStatus;
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


    public DrugPrescriptionLine getDrugPrescriptionLine() {
        return drugPrescriptionLine;
    }

    public void setDrugPrescriptionLine(DrugPrescriptionLine drugPrescriptionLine) {
        this.drugPrescriptionLine = drugPrescriptionLine;
    }

    public FluidPrescriptionLine getFluidPrescriptionLine() {
        return fluidPrescriptionLine;
    }

    public void setFluidPrescriptionLine(FluidPrescriptionLine fluidPrescriptionLine) {
        this.fluidPrescriptionLine = fluidPrescriptionLine;
    }
}
