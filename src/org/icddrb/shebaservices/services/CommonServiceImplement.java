package org.icddrb.shebaservices.services;

import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.CurrentHospitalPatient;
import org.icddrb.shebaservices.db.Patient;
import org.icddrb.shebaservices.dl.CurrentHospitalPatientDL;
import org.icddrb.shebaservices.dl.PatientDL;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/15/14
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommonServiceImplement implements CommonService {


    public String currentHospitalPatient(ConnectionParameter cp, String patientID) {

        String message = "";
        CurrentHospitalPatientDL dl = new CurrentHospitalPatientDL();
        CurrentHospitalPatient hp = dl.getCurrentHospitalPatienByPatientID(cp,patientID);

        if(hp==null){
            message = Constraint.Message.TRANSACTION_ERROR;
        }
        else if(hp!=null && Util.isValidString(hp.getPatientID()) ){

            if(hp.getDischarged()==1){
                message = Constraint.Message.PATIENT_DISCHARGED;
            }else if(hp.getPatientDied()==1){
                message = Constraint.Message.PATIENT_DIED;
            }else if(hp.getWardID().equalsIgnoreCase(Constraint.WARD_SSU_OPD)){
                message = Constraint.Message.WARD_LOCATION_OPD;
            }else{
                message = Constraint.Message.SUCCESS;
            }

        }else{
            message = Constraint.Message.NOT_FOUND_PATIENT;
        }

        return  message;
    }

    @Override
    public String patientStatus(CurrentHospitalPatient hp) {

        String message = "";
        if(hp==null){
            message = Constraint.Message.TRANSACTION_ERROR;
        }
        else if( Util.isValidString(hp.getPatientID()) ){

            if(hp.getDischarged()==1){
                message = Constraint.Message.PATIENT_DISCHARGED;
            }else if(hp.getPatientDied()==1){
                message = Constraint.Message.PATIENT_DIED;
            }else if(hp.getWardID().equalsIgnoreCase(Constraint.WARD_SSU_OPD)){
                message = Constraint.Message.WARD_LOCATION_OPD;
            }else if(!Util.isValidString(hp.getWardID())){
                message = Constraint.Message.WARD_NOT_FOUND;
            }else{
                message = Constraint.Message.SUCCESS;
            }

        }else{
            message = Constraint.Message.NOT_FOUND_PATIENT;
        }

        return message;
    }

    @Override
    public String patientStatusForNewProgressReport(CurrentHospitalPatient hp) {

        String message = this.patientStatus(hp);
        String wardID = "";
        if( message.equalsIgnoreCase( Constraint.Message.SUCCESS ) ){
            wardID = hp.getWardID().substring(0,3);
            if( !wardID.equalsIgnoreCase(Constraint.CONST_WARD_SSU)){
              message = Constraint.Message.PATIENT_NOT_IN_SSU;
            }
        }

        return message;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public String getPatient(ConnectionParameter cp, String patientID) {

        String message = "";
        PatientDL dl = new PatientDL();
        Patient hp = dl.getCurrentHospitalPatienByPatientID(cp,patientID);

        if(hp==null){
            message = Constraint.Message.TRANSACTION_ERROR;
        }
        else if(hp!=null && Util.isValidString(hp.getPatientID()) ){

            if(hp.getDischarged()==1){
                message = Constraint.Message.PATIENT_DISCHARGED;
            }else if(hp.getPatientDied()==1){
                message = Constraint.Message.PATIENT_DIED;
            }else if(hp.getWardID().equalsIgnoreCase(Constraint.WARD_SSU_OPD)){
                message = Constraint.Message.WARD_LOCATION_OPD;
            }else{
                message = Constraint.Message.SUCCESS;
            }

        }else{
            message = Constraint.Message.NOT_FOUND_PATIENT;
        }

        return  message;
    }

    @Override
    public String patientStatus(Patient hp) {

        String message = "";
        if(hp==null){
            message = Constraint.Message.TRANSACTION_ERROR;
        }
        else if( Util.isValidString(hp.getPatientID()) ){

            if(hp.getDischarged()==1){
                message = Constraint.Message.PATIENT_DISCHARGED;
            }else if(hp.getPatientDied()==1){
                message = Constraint.Message.PATIENT_DIED;
            }else if(hp.getWardID().equalsIgnoreCase(Constraint.WARD_SSU_OPD)){
                message = Constraint.Message.WARD_LOCATION_OPD;
            }else if(!Util.isValidString(hp.getWardID())){
                message = Constraint.Message.WARD_NOT_FOUND;
            }else{
                message = Constraint.Message.SUCCESS;
            }

        }else{
            message = Constraint.Message.NOT_FOUND_PATIENT;
        }

        return message;
    }

    @Override
    public String patientStatusForNewProgressReport(Patient hp) {

        String message = this.patientStatus(hp);
        String wardID = "";
        if( message.equalsIgnoreCase( Constraint.Message.SUCCESS ) ){
            wardID = hp.getWardID().substring(0,3);
            if( !wardID.equalsIgnoreCase(Constraint.CONST_WARD_SSU)){
                message = Constraint.Message.PATIENT_NOT_IN_SSU;
            }
        }

        return message;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
