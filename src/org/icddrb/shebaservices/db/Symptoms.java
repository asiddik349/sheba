package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/28/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Symptoms implements Serializable {

    public int boolDiarrhoea;
    public int numberDiarrhoeaDuration;
    public String diarrhoeaDurationIn; // From Enum

    public int boolAbdomenDistension;
    public int numberAbdomenDistensionDuration;
    public String abdomenDistensionDurationIn; // From Enum

    public int boolVomiting;
    public int numberVomitingDuration;
    public String vomitingDurationIn; // From Enum

    public int boolFever;
    public int numberFeverDuration;
    public String feverDurationIn; // From Enum

    public int boolCough;
    public int numberCoughDuration;
    public String coughDurationIn; // From Enum

    public int boolBloodInStool;
    public int boolStrainingInStool;
    public int boolMucousInStool;
    public String stoolConsistency;  // From Enum

    public Symptoms(){

    }

    public int getBoolDiarrhoea() {
        return boolDiarrhoea;
    }

    public void setBoolDiarrhoea(int boolDiarrhoea) {
        this.boolDiarrhoea = boolDiarrhoea;
    }

    public int getNumberDiarrhoeaDuration() {
        return numberDiarrhoeaDuration;
    }

    public void setNumberDiarrhoeaDuration(int numberDiarrhoeaDuration) {
        this.numberDiarrhoeaDuration = numberDiarrhoeaDuration;
    }

    public int getBoolAbdomenDistension() {
        return boolAbdomenDistension;
    }

    public void setBoolAbdomenDistension(int boolAbdomenDistension) {
        this.boolAbdomenDistension = boolAbdomenDistension;
    }

    public int getNumberAbdomenDistensionDuration() {
        return numberAbdomenDistensionDuration;
    }

    public void setNumberAbdomenDistensionDuration(int numberAbdomenDistensionDuration) {
        this.numberAbdomenDistensionDuration = numberAbdomenDistensionDuration;
    }

    public int getBoolVomiting() {
        return boolVomiting;
    }

    public void setBoolVomiting(int boolVomiting) {
        this.boolVomiting = boolVomiting;
    }

    public int getNumberVomitingDuration() {
        return numberVomitingDuration;
    }

    public void setNumberVomitingDuration(int numberVomitingDuration) {
        this.numberVomitingDuration = numberVomitingDuration;
    }

    public int getBoolFever() {
        return boolFever;
    }

    public void setBoolFever(int boolFever) {
        this.boolFever = boolFever;
    }

    public int getNumberFeverDuration() {
        return numberFeverDuration;
    }

    public void setNumberFeverDuration(int numberFeverDuration) {
        this.numberFeverDuration = numberFeverDuration;
    }

    public int getBoolCough() {
        return boolCough;
    }

    public void setBoolCough(int boolCough) {
        this.boolCough = boolCough;
    }

    public int getNumberCoughDuration() {
        return numberCoughDuration;
    }

    public void setNumberCoughDuration(int numberCoughDuration) {
        this.numberCoughDuration = numberCoughDuration;
    }

    public int getBoolBloodInStool() {
        return boolBloodInStool;
    }

    public void setBoolBloodInStool(int boolBloodInStool) {
        this.boolBloodInStool = boolBloodInStool;
    }

    public int getBoolStrainingInStool() {
        return boolStrainingInStool;
    }

    public void setBoolStrainingInStool(int boolStrainingInStool) {
        this.boolStrainingInStool = boolStrainingInStool;
    }

    public int getBoolMucousInStool() {
        return boolMucousInStool;
    }

    public void setBoolMucousInStool(int boolMucousInStool) {
        this.boolMucousInStool = boolMucousInStool;
    }

    public String getDiarrhoeaDurationIn() {
        return diarrhoeaDurationIn;
    }

    public void setDiarrhoeaDurationIn(String diarrhoeaDurationIn) {
        this.diarrhoeaDurationIn = diarrhoeaDurationIn;
    }

    public String getAbdomenDistensionDurationIn() {
        return abdomenDistensionDurationIn;
    }

    public void setAbdomenDistensionDurationIn(String abdomenDistensionDurationIn) {
        this.abdomenDistensionDurationIn = abdomenDistensionDurationIn;
    }

    public String getVomitingDurationIn() {
        return vomitingDurationIn;
    }

    public void setVomitingDurationIn(String vomitingDurationIn) {
        this.vomitingDurationIn = vomitingDurationIn;
    }

    public String getFeverDurationIn() {
        return feverDurationIn;
    }

    public void setFeverDurationIn(String feverDurationIn) {
        this.feverDurationIn = feverDurationIn;
    }

    public String getCoughDurationIn() {
        return coughDurationIn;
    }

    public void setCoughDurationIn(String coughDurationIn) {
        this.coughDurationIn = coughDurationIn;
    }

    public String getStoolConsistency() {
        return stoolConsistency;
    }

    public void setStoolConsistency(String stoolConsistency) {
        this.stoolConsistency = stoolConsistency;
    }
}
