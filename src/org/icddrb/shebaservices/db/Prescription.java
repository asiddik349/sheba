package org.icddrb.shebaservices.db;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Prescription implements Serializable {

    // For Insert --------

    public  String prescriptionNo;
    public String uhID;
    public String patientID;
    public String patientName;
    public String wardCode;
    public String prescriptionDate;
    public String doctorCode;
    public String doctorName;
    public String noSeries;
    public String bedID;
    public int readyForPharmacy;
    public int dischargePrescription;

    // Other Purpose

    public int oldDischargedPrescription;
    public int stopped;
    public int scheduledGenerated;

    // End Other Purpose

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public String getUhID() {
        return uhID;
    }

    public void setUhID(String uhID) {
        this.uhID = uhID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNoSeries() {
        return noSeries;
    }

    public void setNoSeries(String noSeries) {
        this.noSeries = noSeries;
    }

    public String getBedID() {
        return bedID;
    }

    public void setBedID(String bedID) {
        this.bedID = bedID;
    }

    public int getReadyForPharmacy() {
        return readyForPharmacy;
    }

    public void setReadyForPharmacy(int readyForPharmacy) {
        this.readyForPharmacy = readyForPharmacy;
    }

    public int getDischargePrescription() {
        return dischargePrescription;
    }

    public void setDischargePrescription(int dischargePrescription) {
        this.dischargePrescription = dischargePrescription;
    }

    public int getOldDischargedPrescription() {
        return oldDischargedPrescription;
    }

    public void setOldDischargedPrescription(int oldDischargedPrescription) {
        this.oldDischargedPrescription = oldDischargedPrescription;
    }

    public int getStopped() {
        return stopped;
    }

    public void setStopped(int stopped) {
        this.stopped = stopped;
    }

    public int getScheduledGenerated() {
        return scheduledGenerated;
    }

    public void setScheduledGenerated(int scheduledGenerated) {
        this.scheduledGenerated = scheduledGenerated;
    }
}
