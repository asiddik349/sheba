package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/28/14
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Diagnosis implements Serializable {

    private String typeOfDiarrhoea;   // From Enum
    private int boolReferredToDoctor;
    private String causeOfReferral;
    private String externallyReferredTo; // From Enum

    private String rehydration; // From Enum

    private String icd10Code;
    private String icd10Name;
    private String doctorCode;
    private String nurseCode;

    public Diagnosis(){

    }

    public String getTypeOfDiarrhoea() {
        return typeOfDiarrhoea;
    }

    public void setTypeOfDiarrhoea(String typeOfDiarrhoea) {
        this.typeOfDiarrhoea = typeOfDiarrhoea;
    }

    public int getBoolReferredToDoctor() {
        return boolReferredToDoctor;
    }

    public void setBoolReferredToDoctor(int boolReferredToDoctor) {
        this.boolReferredToDoctor = boolReferredToDoctor;
    }

    public String getCauseOfReferral() {
        return causeOfReferral;
    }

    public void setCauseOfReferral(String causeOfReferral) {
        this.causeOfReferral = causeOfReferral;
    }

    public String getRehydration() {
        return rehydration;
    }

    public void setRehydration(String rehydration) {
        this.rehydration = rehydration;
    }

    public String getExternallyReferredTo() {
        return externallyReferredTo;
    }

    public void setExternallyReferredTo(String externallyReferredTo) {
        this.externallyReferredTo = externallyReferredTo;
    }

    public String getIcd10Code() {
        return icd10Code;
    }

    public void setIcd10Code(String icd10Code) {
        this.icd10Code = icd10Code;
    }

    public String getIcd10Name() {
        return icd10Name;
    }

    public void setIcd10Name(String icd10Name) {
        this.icd10Name = icd10Name;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getNurseCode() {
        return nurseCode;
    }

    public void setNurseCode(String nurseCode) {
        this.nurseCode = nurseCode;
    }
}
