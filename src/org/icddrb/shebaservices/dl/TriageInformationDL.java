package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.TriageInformation;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import org.icddrb.shebaservices.enums.Triage.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 1:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class TriageInformationDL extends Persistent {

    public TriageInformation getTriageInformationPatientID(ConnectionParameter cp, String patientID)
    {
        //String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=? AND " + Constraint.OLD_DISCHARGED_PRESCRIPTION + "=0 AND " + Constraint.DISCHARGE_PRESCRIPTION + "=0" ;
        return getTriageInformation(cp, patientID);
    }

    private TriageInformation getTriageInformation( ConnectionParameter cp ,String patientID) {


        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        TriageInformation triageInformation = new TriageInformation();
        try
        {
            String query = getQueryText();
            //Util.writeDataIntoText(query);
            System.out.println("Test Query: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, patientID );
            rst = pstmt.executeQuery();

            while( rst.next() )
            {
                // Assessment ----
                triageInformation.getAssessment().setCondition(ConditionEnum.values()[rst.getInt(Constraint.CONDITION)].getName());
                triageInformation.getAssessment().setEyes(EyesEnum.values()[rst.getInt(Constraint.EYES)].getName());
                triageInformation.getAssessment().setMucosa(MucosaEnum.values()[rst.getInt(Constraint.MUCOSA)].getName());
                triageInformation.getAssessment().setRadialPulse(RadialPulseEnum.values()[rst.getInt(Constraint.RADIAL_PULSE)].getName());
                triageInformation.getAssessment().setSkinTurgor(SkinTurgorEnum.values()[rst.getInt(Constraint.SKIN_TURGOR)].getName());
                triageInformation.getAssessment().setStatus(StatusEnum.values()[rst.getInt(Constraint.STATUS)].getName());
                triageInformation.getAssessment().setThirst(ThirstEnum.values()[rst.getInt(Constraint.THIRST)].getName());
                triageInformation.getAssessment().setOtherProblem( rst.getString(Constraint.OTHER_PROBLEMS));

                // Condition
                triageInformation.getCondition().setMentalStatus(MentalStatusEnum.values()[rst.getInt(Constraint.MENTAL_STATUS)].getName());
                triageInformation.getCondition().setNutritionalStatus(NutritionalStatusEnum.values()[rst.getInt(Constraint.NUTRITIONAL_STATUS)].getName());
                triageInformation.getCondition().setRespiration(RespirationEnum.values()[rst.getInt(Constraint.RESPIRATION)].getName());

                triageInformation.getCondition().setBoolOedema(rst.getInt(Constraint.OEDEMA ));
                triageInformation.getCondition().setBoolChestWallRetraction(rst.getInt(Constraint.CHEST_WALL_RETRACTION ));
                triageInformation.getCondition().setBoolOrsTaken(rst.getInt(Constraint.ORS_TAKEN ));
                triageInformation.getCondition().setBoolIVFluid(rst.getInt(Constraint.IV_FLUID ));
                triageInformation.getCondition().setBoolDrugTaken(rst.getInt(Constraint.DRUG_TAKEN ));

                triageInformation.getCondition().setOthers( rst.getString(Constraint.OTHERS));
                triageInformation.getCondition().setOrsVolumeTakenInPackets(  Util.decimalFormat(Constraint.DECIMAL_TWO_DIGIT_FORMAT,Double.valueOf(rst.getString(Constraint.ORS_VOLUME_TAKEN_IN_PACKETS))) );
                //triageInformation.getCondition().setOrsVolumeTakenInPackets( rst.getString("orsVolumeTakenInPackets"));

                triageInformation.getCondition().setDrugNames( rst.getString(Constraint.DRUG_NAMES));


                // Diagnosis
                triageInformation.getDiagnosis().setTypeOfDiarrhoea(TypeofDiarrhoeaEnum.values()[rst.getInt(Constraint.TYPE_OF_DIARRHOEA)].getName());
                triageInformation.getDiagnosis().setRehydration(RespirationEnum.values()[rst.getInt(Constraint.REHYDRATION)].getName());
                triageInformation.getDiagnosis().setExternallyReferredTo(TypeofDiarrhoeaEnum.values()[rst.getInt(Constraint.EXTERNAL_REFERRED_TO)].getName());

                triageInformation.getDiagnosis().setBoolReferredToDoctor(rst.getInt(Constraint.REFERRED_TO_DOCTOR ));

                triageInformation.getDiagnosis().setCauseOfReferral(rst.getString(Constraint.CAUSE_OF_REFERRAL ));
                triageInformation.getDiagnosis().setIcd10Code(rst.getString(Constraint.ICD10CODE ));
                triageInformation.getDiagnosis().setIcd10Name(rst.getString(Constraint.ICD10NAME ));
                triageInformation.getDiagnosis().setDoctorCode(rst.getString(Constraint.DOCTOR_CODE ));
                triageInformation.getDiagnosis().setNurseCode(rst.getString(Constraint.NURSE_CODE ));



                // Symptoms
                triageInformation.getSymptoms().setStoolConsistency(StoolConsistencyEnum.values()[rst.getInt(Constraint.STOOL_CONSISTENCY)].getName());
                triageInformation.getSymptoms().setDiarrhoeaDurationIn(DurationEnum.values()[rst.getInt(Constraint.DIARRHOEA_DURATION_IN)].getName());
                triageInformation.getSymptoms().setAbdomenDistensionDurationIn(DurationEnum.values()[rst.getInt(Constraint.ABD_DISTENTION_DURATION_IN)].getName());
                triageInformation.getSymptoms().setVomitingDurationIn(DurationEnum.values()[rst.getInt(Constraint.VOMITING_DURATION_IN)].getName());
                triageInformation.getSymptoms().setFeverDurationIn(DurationEnum.values()[rst.getInt(Constraint.FEVER_DURATION_IN)].getName());
                triageInformation.getSymptoms().setCoughDurationIn(DurationEnum.values()[rst.getInt(Constraint.COUGH_DURATIONIN)].getName());

                triageInformation.getSymptoms().setBoolDiarrhoea(rst.getInt(Constraint.DIARRHOEA ));
                triageInformation.getSymptoms().setBoolAbdomenDistension(rst.getInt(Constraint.ABDOMEN_DISTENTION ));
                triageInformation.getSymptoms().setBoolVomiting(rst.getInt(Constraint.VOMITING ));
                triageInformation.getSymptoms().setBoolFever(rst.getInt(Constraint.FEVER ));
                triageInformation.getSymptoms().setBoolCough(rst.getInt(Constraint.COUGH ));
                triageInformation.getSymptoms().setBoolBloodInStool(rst.getInt(Constraint.BLOODIN_STOOL ));
                triageInformation.getSymptoms().setBoolStrainingInStool(rst.getInt(Constraint.STRAINING_AT_STOOL ));
                triageInformation.getSymptoms().setBoolMucousInStool(rst.getInt(Constraint.MUCOUS_IN_STOOL ));

                triageInformation.getSymptoms().setNumberDiarrhoeaDuration(rst.getInt(Constraint.DIARRHOEA_DURATION ));
                triageInformation.getSymptoms().setNumberAbdomenDistensionDuration(rst.getInt(Constraint.ABD_DISTENTION_DURATION ));
                triageInformation.getSymptoms().setNumberVomitingDuration(rst.getInt(Constraint.VOMITING_DURATION ));
                triageInformation.getSymptoms().setNumberFeverDuration(rst.getInt(Constraint.FEVER_DURATION ));
                triageInformation.getSymptoms().setNumberCoughDuration(rst.getInt(Constraint.COUGH_DURATION ));

            }

        }catch (Exception ex)
        {
            triageInformation = null;
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                }
                if(pstmt != null)
                {
                    pstmt.close();
                }
                if(dbCon != null)
                {
                    dbCon.close();
                }
            }
            catch (Exception sqe)
            {
                triageInformation = null;
                sqe.printStackTrace();
            }
        }

        return triageInformation;
    }

    private String getQueryText(){

        String query = AppSQL.QRY_TRIAGE_INFORMATION ;
        return  query;
    }
}
