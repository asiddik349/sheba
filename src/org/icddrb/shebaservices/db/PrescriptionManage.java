package org.icddrb.shebaservices.db;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/13/14
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionManage implements Serializable {
    
    private int disChargePrescription;
    private Patient patient = null;
    private PrescriptionLine prescriptionLine = null;
    private ArrayList<HospitalDrug> drugs = null;
    private ArrayList<HospitalDrug> fluidDrugs = null;
    //private HospitalDrug hospitalDrug = null;
    private String[] unitOfMeasure;

    public PrescriptionManage(){
        this.patient = new Patient();
        this.prescriptionLine = new PrescriptionLine();
        this.drugs = new ArrayList<HospitalDrug>();
        this.fluidDrugs = new ArrayList<HospitalDrug>();
        //this.hospitalDrug = new HospitalDrug();

    }

//    public HospitalDrug getHospitalDrug() {
//        return hospitalDrug;
//    }
//
//    public void setHospitalDrug(HospitalDrug hospitalDrug) {
//        this.hospitalDrug = hospitalDrug;
//    }

    public String[] getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String[] unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getDisChargePrescription() {
        return disChargePrescription;
    }

    public void setDisChargePrescription(int disChargePrescription) {
        this.disChargePrescription = disChargePrescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PrescriptionLine getPrescriptionLine() {
        return prescriptionLine;
    }

    public void setPrescriptionLine(PrescriptionLine prescriptionLine) {
        this.prescriptionLine = prescriptionLine;
    }

    public ArrayList<HospitalDrug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<HospitalDrug> drugs) {
        this.drugs = drugs;
    }

    public ArrayList<HospitalDrug> getFluidDrugs() {
        return fluidDrugs;
    }

    public void setFluidDrugs(ArrayList<HospitalDrug> fluidDrugs) {
        this.fluidDrugs = fluidDrugs;
    }
}
