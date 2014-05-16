package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/28/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Assessment implements Serializable {

    private String condition;  // From Enum
    private String mucosa;  // From Enum
    private String skinTurgor; // From Enum
    private String eyes; // From Enum
    private String radialPulse; // From Enum
    private String thirst;  // From Enum
    private String status; // From Enum
    private String otherProblem;


    public Assessment(){

    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMucosa() {
        return mucosa;
    }

    public void setMucosa(String mucosa) {
        this.mucosa = mucosa;
    }

    public String getSkinTurgor() {
        return skinTurgor;
    }

    public void setSkinTurgor(String skinTurgor) {
        this.skinTurgor = skinTurgor;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getRadialPulse() {
        return radialPulse;
    }

    public void setRadialPulse(String radialPulse) {
        this.radialPulse = radialPulse;
    }

    public String getThirst() {
        return thirst;
    }

    public void setThirst(String thirst) {
        this.thirst = thirst;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOtherProblem() {
        return otherProblem;
    }

    public void setOtherProblem(String otherProblem) {
        this.otherProblem = otherProblem;
    }
}
