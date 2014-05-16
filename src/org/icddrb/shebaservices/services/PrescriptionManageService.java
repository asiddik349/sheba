package org.icddrb.shebaservices.services;

import org.icddrb.shebaservices.Utility.ConstantValue;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.HospitalDrug;
import org.icddrb.shebaservices.dl.HospitalDrugDL;
import org.icddrb.shebaservices.dl.PrescriptionManageDL;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/14/14
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrescriptionManageService {


    public PrescriptionManageService(){

    }

    public ArrayList<HospitalDrug> getDrugList(ConnectionParameter cp){

        HospitalDrugDL dl = new HospitalDrugDL();
        ArrayList<HospitalDrug> drugs = dl.getDrugList(cp);

        return  drugs;
    }

    public ArrayList<HospitalDrug> filterDrugList(ArrayList<HospitalDrug> drugs){


        ArrayList<HospitalDrug> filterDrugs = new ArrayList<HospitalDrug>();

        if(drugs!=null && drugs.size()>0){
            for( HospitalDrug drug: drugs ){
                if( drug.getDrugType() == ConstantValue.DRUG_DRUG)
                    filterDrugs.add( drug );
            }


        }

        return  filterDrugs;
    }

    public ArrayList<HospitalDrug> filterFluidDrugList(ArrayList<HospitalDrug> drugs){


        ArrayList<HospitalDrug> filterFluidDrugs = new ArrayList<HospitalDrug>();

        if(drugs!=null && drugs.size()>0){
            for( HospitalDrug drug: drugs ){
                if( drug.getDrugType() == ConstantValue.DRUG_FLUID )
                    filterFluidDrugs.add( drug );
            }


        }

        return  filterFluidDrugs;
    }


    public boolean isCholeraInLastProgressReport(ConnectionParameter cp, String patientID){

        boolean returnValue = false;
        String query= "SELECT [Cholera Like Illness] FROM " + Constraint.TABLE_PROGRESS_REPORT + " where " + Util.setSelectColumn( Constraint.PATIENT_ID ) +
                "='" + patientID + "'" +
                " AND " + Util.setSelectColumn( Constraint.PROGRESS_REPORT_NO) + "=(SELECT MAX([Progress Report No_]) FROM " + Constraint.TABLE_PROGRESS_REPORT + " where " + Util.setSelectColumn( Constraint.PATIENT_ID ) +
                "='" + patientID + "')" ;
        String result = Util.getQueryResult(query,cp);

        if( Util.isValidString(result) && Util.parseInt(result)>0){
            returnValue = true;
        }

        return returnValue;
    }


}
