package org.icddrb.shebaservices.db;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/8/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Patient implements Serializable {

    private String patientID="";
    private  String wardID="";
    private String wardLocationID="";
    private String patientName="";
    private int patientDied;
    private String uhID="";
    private String bedID="";
    private  int discharged;
    private String weightInKg=""; // Decimal in DB
    private String zScoreHA="";  // Decimal in DB
    private  String zScoreWA=""; // Decimal in DB

    // --------------------------------------

    private String dateOfAdmission;
    private String timeOfAdmission;

    private int sex;
    private int ageInYear;
    private int ageInMonth;
    private int ageInDay;

    private String sexName; // Not DB Field
    private int hasDischargePrescription; // Not DB Field
    private int los; // Service time // Not DB Field
    private String age;  // Not DB Field
    private String formattedDateOfAdmission;
    private String formattedTimeOfAdmission;

    public Patient(){

    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getWardID() {
        return wardID;
    }

    public void setWardID(String wardID) {
        this.wardID = wardID;
    }

    public String getWardLocationID() {
        return wardLocationID;
    }

    public void setWardLocationID(String wardLocationID) {
        this.wardLocationID = wardLocationID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientDied() {
        return patientDied;
    }

    public void setPatientDied(int patientDied) {
        this.patientDied = patientDied;
    }

    public String getUhID() {
        return uhID;
    }

    public void setUhID(String uhID) {
        this.uhID = uhID;
    }

    public String getBedID() {
        return bedID;
    }

    public void setBedID(String bedID) {
        this.bedID = bedID;
    }

    public int getDischarged() {
        return discharged;
    }

    public void setDischarged(int discharged) {
        this.discharged = discharged;
    }

    public String getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(String weightInKg) {
        this.weightInKg = weightInKg;
    }

    public String getzScoreHA() {
        return zScoreHA;
    }

    public void setzScoreHA(String zScoreHA) {
        this.zScoreHA = zScoreHA;
    }

    public String getzScoreWA() {
        return zScoreWA;
    }

    public void setzScoreWA(String zScoreWA) {
        this.zScoreWA = zScoreWA;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAgeInYear() {
        return ageInYear;
    }

    public void setAgeInYear(int ageInYear) {
        this.ageInYear = ageInYear;
    }

    public int getAgeInMonth() {
        return ageInMonth;
    }

    public void setAgeInMonth(int ageInMonth) {
        this.ageInMonth = ageInMonth;
    }

    public int getAgeInDay() {
        return ageInDay;
    }

    public void setAgeInDay(int ageInDay) {
        this.ageInDay = ageInDay;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public int getHasDischargePrescription() {
        return hasDischargePrescription;
    }

    public void setHasDischargePrescription(int hasDischargePrescription) {
        this.hasDischargePrescription = hasDischargePrescription;
    }

    public int getLos() {
        return los;
    }

    public void setLos(int los) {
        this.los = los;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
}
