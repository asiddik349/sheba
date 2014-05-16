package org.icddrb.shebaservices.Utility;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/1/14
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnumArray {
    
    public String[] optionsBowelSound = {Constraint.SELECT, "Normal","Sluggish","Absent","Not Clinicaly Indicated"};
    public String[] optionsBreathing = {Constraint.SELECT,"Normal","Fast"};
    public String[] optionsCholeraLikeIllness = {Constraint.SELECT,"Yes","No"};
    public String[] optionsDehydration = {Constraint.SELECT,"None","Some","Severe"};
    public String[] optionsDiarrhoeaDuration = {"Hrs","Days"};
    public String[] optionsDrugInventory = {"Internal","External"};
    public String[] optionsDrugUsingType = {"Regular","As Req/SOS","Single Dose/ORS","STAT"};  // Regular, SOS
    public String[] optionsFrequency = {Constraint.SELECT,"q1h","q2h","q3h","q4h","q5h","q6h","q8h","q12h-BD","q24h-OD","TDS"};
    public String[] optionsGeneralCondition = {Constraint.SELECT,"Normal","Imitable","Lathergic","Comatose"};
    public String[] optionsHeart = {Constraint.SELECT,"Normal","Abnormal"};
    public String[] optionsLungs = {Constraint.SELECT,"Normal","Abnormal"};
    public String[] optionsPatientCondition = {Constraint.SELECT,"Improved","Unchanged","Detoriated"};
    public String[] optionsRadialPulse = {Constraint.SELECT,"Normal","Low Volume","Uncountable"};
    public String[] optionsRoute = {Constraint.SELECT,"TOP","PO","IV","IM","SC","ID","NG","SL","PR","PV","NEB"};
    public String[] optionsSex = {Constraint.SELECT,"Male","Female"};
    public String[] optionsStool = {Constraint.SELECT,"Watery","Soft","Formed"};
    public String[] optionsUrineNotPassedDuration = {"Hrs","Days"};
    public String[] optionsVomiting = {Constraint.SELECT,"None","Occasional","Frequent"};

    public String[] optionsUrine = {Constraint.SELECT,"Yes","Yes, Volume not Measured","No","Unknown"};
    public String[] optionsStoollPO = {Constraint.SELECT,"G. W","G. L","G. Mucoid","Y. W","Y. L","R. W","S/S","O/C","Mucoid","B. Mucoid","Toilet"};
    public String[] optionsOxyzenSaturationOn = {Constraint.SELECT,"Without Oxygen","With Oxygen"};
    public String[] optionsDrugType = {Constraint.SELECT,"Drug","Fluid"};
    public String[] optionsStoolVolme = {Constraint.SELECT,"Ltr","ml"};
    public String[] optionsDurationIn = {Constraint.SELECT,"Days","Hrs"};
    public String[] optionsRouteDA = {Constraint.SELECT,"PO","NG","IV","IM","ID","PR"};
    public String[] optionsDietType = {Constraint.SELECT,"Normal Diet","Selected Diet","Attendant Diet","Staff Diet"};
    public String[] optionsDietItemType = {Constraint.SELECT,"Food Item","Raw Material"};

    // Prescription

    public String[] optionsDurationType = {"Over","Running"};
    public String[] optionsDurationInPrescription = {"Hrs","Min"};














}
