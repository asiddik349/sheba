package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/14/14
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class HospitalDrug implements Serializable {
    
    private String strDrugName;
    private int drugType;
    private String strDrugCode;
    private String decSingleDispensePower = "";// Decimal
    private String strSingleDispenseUOM = "";
    private String strPharmacyUOM = "";// strSalesUnitOfMeasure
    private String[] unitOfMeasure;
    
    private int azithromycin;
    private int choleraInPreviousProgressReport;

    public String getStrDrugName() {
        return strDrugName;
    }

    public void setStrDrugName(String strDrugName) {
        this.strDrugName = strDrugName;
    }

    public int getDrugType() {
        return drugType;
    }

    public void setDrugType(int drugType) {
        this.drugType = drugType;
    }

    public String getStrDrugCode() {
        return strDrugCode;
    }

    public void setStrDrugCode(String strDrugCode) {
        this.strDrugCode = strDrugCode;
    }

    public String getDecSingleDispensePower() {
        return decSingleDispensePower;
    }

    public void setDecSingleDispensePower(String decSingleDispensePower) {
        this.decSingleDispensePower = decSingleDispensePower;
    }

    public String getStrSingleDispenseUOM() {
        return strSingleDispenseUOM;
    }

    public void setStrSingleDispenseUOM(String strSingleDispenseUOM) {
        this.strSingleDispenseUOM = strSingleDispenseUOM;
    }

    public String getStrPharmacyUOM() {
        return strPharmacyUOM;
    }

    public void setStrPharmacyUOM(String strPharmacyUOM) {
        this.strPharmacyUOM = strPharmacyUOM;
    }

    public String[] getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String[] unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getAzithromycin() {
        return azithromycin;
    }

    public void setAzithromycin(int azithromycin) {
        this.azithromycin = azithromycin;
    }

    public int getCholeraInPreviousProgressReport() {
        return choleraInPreviousProgressReport;
    }

    public void setCholeraInPreviousProgressReport(int choleraInPreviousProgressReport) {
        this.choleraInPreviousProgressReport = choleraInPreviousProgressReport;
    }
}
