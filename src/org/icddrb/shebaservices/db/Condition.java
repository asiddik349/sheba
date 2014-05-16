package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/28/14
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Condition implements Serializable {

    private String mentalStatus; // From Enum
    private String nutritionalStatus; // From Enum
    private String respiration; // From Enum
    private int boolOedema;
    private int boolChestWallRetraction;
    private String others;

    // Medication Taken
    private int boolOrsTaken;
    private String orsVolumeTakenInPackets; // Decimal
    private int boolIVFluid;
    private int boolDrugTaken;
    private String drugNames;


    public Condition(){

    }

    public String getMentalStatus() {
        return mentalStatus;
    }

    public void setMentalStatus(String mentalStatus) {
        this.mentalStatus = mentalStatus;
    }

    public String getNutritionalStatus() {
        return nutritionalStatus;
    }

    public void setNutritionalStatus(String nutritionalStatus) {
        this.nutritionalStatus = nutritionalStatus;
    }

    public String getRespiration() {
        return respiration;
    }

    public void setRespiration(String respiration) {
        this.respiration = respiration;
    }

    public int getBoolOedema() {
        return boolOedema;
    }

    public void setBoolOedema(int boolOedema) {
        this.boolOedema = boolOedema;
    }

    public int getBoolChestWallRetraction() {
        return boolChestWallRetraction;
    }

    public void setBoolChestWallRetraction(int boolChestWallRetraction) {
        this.boolChestWallRetraction = boolChestWallRetraction;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public int getBoolOrsTaken() {
        return boolOrsTaken;
    }

    public void setBoolOrsTaken(int boolOrsTaken) {
        this.boolOrsTaken = boolOrsTaken;
    }

    public String getOrsVolumeTakenInPackets() {
        return orsVolumeTakenInPackets;
    }

    public void setOrsVolumeTakenInPackets(String orsVolumeTakenInPackets) {
        this.orsVolumeTakenInPackets = orsVolumeTakenInPackets;
    }

    public int getBoolIVFluid() {
        return boolIVFluid;
    }

    public void setBoolIVFluid(int boolIVFluid) {
        this.boolIVFluid = boolIVFluid;
    }

    public int getBoolDrugTaken() {
        return boolDrugTaken;
    }

    public void setBoolDrugTaken(int boolDrugTaken) {
        this.boolDrugTaken = boolDrugTaken;
    }

    public String getDrugNames() {
        return drugNames;
    }

    public void setDrugNames(String drugNames) {
        this.drugNames = drugNames;
    }
}
