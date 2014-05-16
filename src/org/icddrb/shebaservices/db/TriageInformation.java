package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/28/14
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriageInformation implements Serializable {

    private Symptoms symptoms;
    private Assessment assessment;
    private Condition condition;
    private Diagnosis diagnosis;


    public TriageInformation(){

        this.symptoms = new Symptoms();
        this.assessment = new Assessment();
        this.condition = new Condition();
        this.diagnosis = new Diagnosis();
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
