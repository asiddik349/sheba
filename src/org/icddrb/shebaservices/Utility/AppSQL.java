package org.icddrb.shebaservices.Utility;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/7/14
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppSQL {


    public static final String QRY_CHECK_LOGIN_EXPIRED =
            " SELECT " +
            "[" + Constraint.USER_ID + "]" +
            " FROM " +
            Constraint.TABLE_USER ;
    public static final String QRY_USER_SETUP =
            " SELECT " +
                    "[" + Constraint.USER_ID + "], " +
                    "[" + Constraint.EMAIL_ID + "], " +
                    "[" + Constraint.EMPLOYEE_ID + "], " +
                    "[" + Constraint.USER_TYPE + "], " +
                    "[" + Constraint.DOCOTOR_TYPE + "], " +
                    "[" + Constraint.PROGRESS_REPORT + "], " +
                    "[" + Constraint.DOCTORS_ORDER + "], " +
                    "[" + Constraint.DISCHARGE_ADVICE + "], " +
                    "[" + Constraint.PATIENT_INTAKE + "], " +
                    "[" + Constraint.PATIENT_OUTPUT + "], " +
                    "[" + Constraint.DIET_REQUIREMENT + "], " +
                    "[" + Constraint.VITAL_SIGN + "], " +
                    "[" + Constraint.DRUG_ADMINISTRATION + "], " +
                    "[" + Constraint.WARD_TRANSFER + "], " +
                    "[" + Constraint.BEDID_VERIFICATION + "], " +
                    "[" + Constraint.TWENTY_FOUR_HOUR_ACCESS + "], " +
                    "[" + Constraint.GENERATE_DIET_REQUISITION + "], " +
                    "[" + Constraint.VIEW_DIET_REQUISITION + "], " +
                    "[" + Constraint.CANTEEN_DIET_REQUISITION + "], " +
                    "[" + Constraint.DIET_SETUP + "], " +
                    "[" + Constraint.DIET_SETUP_ADMIN + "], " +
                    "[" + Constraint.APPLICABLE_FOR_SSU_LAB_REQ + "]" +

                    " FROM " +
                    Constraint.TABLE_USER_SETUP ;

    public static final String QRY_CURRENT_HOSPITAL_PATIENT =
            " SELECT " +
                    "[" + Constraint.PATIENT_ID + "], " +
                    "[" + Constraint.WARD_ID + "], " +
                    "[" + Constraint.WARD_LOCATION_ID + "], " +
                    "[" + Constraint.PATIENT_NAME + "], " +
                    "[" + Constraint.PATIENT_DIED + "], " +
                    "[" + Constraint.UH_ID + "], " +
                    "[" + Constraint.BED_ID + "], " +
                    "[" + Constraint.DISCHARGED + "], " +
                    "[" + Constraint.WEIGHT_IN_KG + "], " +
                    "[" + Constraint.Z_SCORE_HA + "], " +
                    "CONVERT(Decimal(9,2), " +  "[" + Constraint.WEIGHT_IN_KG + "])" + " as weightInKg, " +
                    "CONVERT(Decimal(9,2), " +  "[" + Constraint.Z_SCORE_HA + "])" + " as zScoreHA, " +
                    "CONVERT(Decimal(9,2), " +  "[" + Constraint.Z_SCORE_WA + "])" + " as zScoreWA, " +
                    "CONVERT( VARCHAR(10), [" + Constraint.VISIT_DATE + "], 105 ) as formattedDateOfAdmission, " +
                    "[" + Constraint.VISIT_DATE + "] as dateOfAdmission, " +
                    //"[" + Constraint.VISIT_DATE + "], " +
                    //"[" + Constraint.VISIT_TIME + "], " +
                    "CONVERT(VARCHAR(8), [" + Constraint.VISIT_TIME + "], 108) + ' ' + SUBSTRING(CONVERT(VARCHAR(19), " + "[" + Constraint.VISIT_TIME + "], 100),18,2) as formattedTimeOfAdmission, " +
                    "[" + Constraint.VISIT_TIME + "] as timeOfAdmission, " +
                    "[" + Constraint.SEX + "], " +
                    "[" + Constraint.AGE_IN_YEAR + "], " +
                    "[" + Constraint.AGE_IN_MONTH + "], " +
                    "[" + Constraint.AGE_IN_DAY + "] " +


                    " FROM " +
                    Constraint.TABLE_CURRENT_HOSPITAL_PATIENT;

    public static final String QRY_SINGLE_PRESCRIPTION =
            " SELECT TOP 1 " +
                    "[" + Constraint.PATIENT_ID + "], " +
                    "[" + Constraint.UH_ID + "], " +
                    "[" + Constraint.PRESCRIPTION_NO + "], " +
                    "[" + Constraint.PRESCRIPTION_DATE + "], " +
                    "[" + Constraint.DISCHARGE_PRESCRIPTION + "], " +
                    "[" + Constraint.DOCTOR_CODE + "], " +
                    "[" + Constraint.DOCTOR_NAME + "], " +
                    "[" + Constraint.OLD_DISCHARGED_PRESCRIPTION + "], " +
                    "[" + Constraint.STOPPED + "], " +
                    "[" + Constraint.SCHEDULE_GENERATED + "] " +


                    " FROM " +
                    Constraint.TABLE_PRESCRIPTION;


    public static final String QRY_SELECT_COLUMN_PRESCRIPTION_LINE =
            " SELECT " +
                    "pl.[" + Constraint.LINE_NO + "] as lineNumber, " +
                    "pl.[" + Constraint.PRESCRIPTION_SMALL_ID + "] as prescriptionID, " +     // Temp
                    "pl.[" + Constraint.STOP + "] as drugStopped, " +     //
                    "pl.[" + Constraint.DRUG_TYPE + "] as drugType, " +
                    "pl.[" + Constraint.DRUG_INVENTORY + "] as drugInventory, " +  // From Enum  :Internal, External
                    1 + " as prescriptionLineTable, " +
                    "pl.[" + Constraint.SUBMITTED_BY + "] as doctorCode, " +
                    "pl.[" + Constraint.ACTUAL_DOZE + "] as drugUsingType, " +  // From Enum ; ig Regular
                    "pl.[" + Constraint.DRUG_CODE + "] as drugCode, " +
                    "pl.[" + Constraint.DRUG_NAME + "] as drugName, " +
                    "CONVERT(Decimal(9,2), " +  "pl.[" + Constraint.TOTAL_QUANTITY + "])" + " as doses," +
                    "pl.[" + Constraint.UNIT_OF_MEASURE + "] as uom, " +
                    "pl.[" + Constraint.FREQUENCY + "] as frequency, " +    // From Enum ; 0=""
                    "pl.[" + Constraint.ROUTE + "] as route, " +            // From Enum  ; 0=""
                    "CONVERT( VARCHAR(10), pl.[" + Constraint.STARTING_DATE + "], 105 ) as startDate, " +
                    "pl.[" + Constraint.NO_OF_DAYS + "] as noOfDays, " +
                    "CONVERT( VARCHAR(10), pl.[" + Constraint.END_DATE + "], 105 ) as endDate, " +
                    "CONVERT(Decimal(9,2), " +  "pl.[" + Constraint.NO_OF_DOSES + "])" + " as noOfDoses," +
                    "pl.[" + Constraint.REMARKS + "] as remarks ";

    public static final String QRY_SELECT_COLUMN_FLUID_PRESCRIPTION_LINE =
            " SELECT " +
                    "fpl.[" + Constraint.LINE_NO + "] as lineNumber, " +
                    "fpl.[" + Constraint.FLUID_PRESCRIPTION_NO + "] as prescriptionID, " +
                    "fpl.[" + Constraint.STOPPED_SMALL + "] as drugStopped, " +
                    "fpl.[" + Constraint.DRUG_TYPE + "] as drugType, " +
                    0 + " as drugInventory, " +     // From Enum
                    0 + " as prescriptionLineTable, " +
                    "fpl.[" + Constraint.DOCTOR_CODE + "] as doctorCode, " +
                    "fpl.[" + Constraint.PRESCRIPTION_TYPE + "] as drugUsingType, " +  // From Enum , Regular, STAT
                    "fpl.[" + Constraint.FLUID_CODE + "] as drugCode, " +
                    "fpl.[" + Constraint.FLUID_NAME + "] as drugName, " +
                    "CONVERT(Decimal(9,2), " +  "fpl.[" + Constraint.VOLUME + "])" + " as doses," +
                    "fpl.[" + Constraint.UNIT_OF_MEASURE + "] as uom, " +
                    "fpl.[" + Constraint.REPEAT_TYPE + "] as frequency, " +  // From Enum  ; 0=""
                    "fpl.[" + Constraint.ROUTE + "] as route, " +            // From Enum  ;0=""
                    "CONVERT( VARCHAR(10), fpl.[" + Constraint.START_DATE + "], 105 ) as startDate, " +
                    "fpl.[" + Constraint.DURATION + "]/(24*60*60*1000) as noOfDays, " +
                    "CONVERT( VARCHAR(10), fpl.[" + Constraint.END_DATE + "], 105 ) as endDate, " +
                    "CONVERT(Decimal(9,2), " +  "fpl.[" + Constraint.ACTUAL_DOZE + "])" + " as noOfDoses," +
                    "fpl.[" + Constraint.DOCTORS_REMARKS + "] as remarks " ;
    
    public static String QRY_LOS_COUNT = "SELECT DATEDIFF(hour,Dateadd(hour,6,[Registration Complete DateTime]),getdate()) as los from " + Constraint.TABLE_PATIENT_REGISTRATION + " WHERE [Patient ID]=?";
    
    public static String QRY_DISCHARGE_PRESCRIPTION = " SELECT " +
            "[" + Constraint.DISCHARGE_PRESCRIPTION + "]" +
            " from " + Constraint.TABLE_PRESCRIPTION +
            " where " +
            "["  + Constraint.PATIENT_ID + "]=?" +
            " AND [" + Constraint.OLD_DISCHARGED_PRESCRIPTION + "]=0" +
            " AND [" + Constraint.STOPPED + "]=0" +
            " AND [" + Constraint.DISCHARGE_PRESCRIPTION + "]=1 ";

    public static String QRY_PROGRESS_REPORT= " SELECT " +
            "[" + Constraint.PROGRESS_REPORT_NO + "], " +
            "[" + Constraint.PATIENT_ID + "], " +
            "[" + Constraint.UH_ID + "], " +
            "[" + Constraint.PATIENT_NAME + "], " +
           // "[" + Constraint.AGE + "], " +
            "[" + Constraint.SEX + "], " +
            "[" + Constraint.DATE_OF_ADMISSION + "], " +
            "[" + Constraint.TIME_OF_ADMISSION + "], " +
            "[" + Constraint.DATE_OF_EXAM + "], " +
            "[" + Constraint.TIME_OF_EXAM + "], " +
            "[" + Constraint.DIARRHOEA_DURATION + "], " +
            "[" + Constraint.DIARRHOEA_DURATION_IN + "], " +
            "[" + Constraint.GENERAL_CONDITION + "], " +
            "[" + Constraint.VOMITING + "], " +
            "[" + Constraint.RADIAL_PULSE + "], " +
            "[" + Constraint.DEHYDRATION + "], " +
            "[" + Constraint.STOOL + "], " +
            "[" + Constraint.BLOODIN_STOOL + "], " +
            "[" + Constraint.FEVER + "], " +
            "[" + Constraint.COUGH + "], " +
            "[" + Constraint.ABDOMINAL_DISTENTION + "], " +
            "[" + Constraint.ABDOMINAL_TENDERNESS + "], " +
            "[" + Constraint.BREATHING + "], " +
            "[" + Constraint.CHESTRE_TRACTION + "], " +
            "[" + Constraint.BOWEL_SOUND + "], " +
            "[" + Constraint.HEART + "], " +
            "[" + Constraint.LUNGS + "], " +
            "[" + Constraint.URINENOT_PASSED + "], " +
            "[" + Constraint.URINE_NOT_PASSED_DURATION + "], " +
            "[" + Constraint.OTHER_FINDINGS_1 + "], " +
            "[" + Constraint.OTHER_FINDINGS_2 + "], " +
            "[" + Constraint.OTHER_FINDINGS_3 + "], " +
            "[" + Constraint.CLINICAL_DIAGNOSIS + "], " +
            "[" + Constraint.PATIENT_CONDITION + "], " +
            "[" + Constraint.DOCTORS_CODE + "], " +
            "[" + Constraint.APPROVED_BY_DOCTOR + "], " +
            "[" + Constraint.APPROVAL_TIME + "], " +
            "[" + Constraint.NO_SERIES + "], " +
            "[" + Constraint.CHOLERA_LIKE_ILLNESS + "], " +
            "[" + Constraint.URINE_NOT_PASSED_DURATIONIN + "], " +
            "[" + Constraint.CREATED_BY + "], " +
            "[" + Constraint.CREATION_DATETIME + "], " +
            "[" + Constraint.LAST_MODIFIED_BY + "], " +
            "CONVERT( VARCHAR(10), [" + Constraint.DATE_OF_ADMISSION + "], 105 ) as formattedDateOfAdmission, " +
            "CONVERT(VARCHAR(8), [" + Constraint.TIME_OF_ADMISSION + "], 108) + ' ' + SUBSTRING(CONVERT(VARCHAR(19), " + "[" + Constraint.TIME_OF_ADMISSION + "], 100),18,2) as formattedTimeOfAdmission, " +
            "CONVERT(VARCHAR(8), [" + Constraint.APPROVAL_TIME + "], 108) + ' ' + SUBSTRING(CONVERT(VARCHAR(19), " + "[" + Constraint.APPROVAL_TIME + "], 100),18,2) as formattedApprovalTime, " +
            "CONVERT( VARCHAR(10), [" + Constraint.DATE_OF_EXAM + "], 105 ) as formattedDateOfExam, " +
            "CONVERT(VARCHAR(8), [" + Constraint.TIME_OF_EXAM + "], 108) + ' ' + SUBSTRING(CONVERT(VARCHAR(19), " + "[" + Constraint.TIME_OF_EXAM + "], 100),18,2) as formattedTimeOfExam, " +
            "[" + Constraint.LAST_MODIFICATION_DATETIME + "] " +

            " from " + Constraint.TABLE_PROGRESS_REPORT ;
            //" where " +
            //"["  + Constraint.PATIENT_ID + "]=?";

    public static String QRY_TRIAGE_INFORMATION = " SELECT " +
            "[" + Constraint.DIARRHOEA + "], " +
            "[" + Constraint.DIARRHOEA_DURATION + "], " +
            "[" + Constraint.DIARRHOEA_DURATION_IN + "], " +
            "[" + Constraint.ABDOMEN_DISTENTION + "], " +
            "[" + Constraint.ABD_DISTENTION_DURATION + "], " +
            "[" + Constraint.ABD_DISTENTION_DURATION_IN + "], " +
            "[" + Constraint.VOMITING + "], " +
            "[" + Constraint.VOMITING_DURATION + "], " +
            "[" + Constraint.VOMITING_DURATION_IN + "], " +
            "[" + Constraint.FEVER + "], " +
            "[" + Constraint.FEVER_DURATION + "], " +
            "[" + Constraint.FEVER_DURATION_IN + "], " +
            "[" + Constraint.COUGH + "], " +
            "[" + Constraint.COUGH_DURATION + "], " +
            "[" + Constraint.COUGH_DURATIONIN + "], " +
            "[" + Constraint.STOOL_CONSISTENCY + "], " +
            "[" + Constraint.BLOODIN_STOOL + "], " +
            "[" + Constraint.STRAINING_AT_STOOL + "], " +
            "[" + Constraint.MUCOUS_IN_STOOL + "], " +
            "[" + Constraint.CONDITION + "], " +
            "[" + Constraint.MUCOSA + "], " +
            "[" + Constraint.SKIN_TURGOR + "], " +
            "[" + Constraint.EYES + "], " +
            "[" + Constraint.RADIAL_PULSE + "], " +
            "[" + Constraint.THIRST + "], " +
            "[" + Constraint.STATUS + "], " +
            "[" + Constraint.OTHER_PROBLEMS + "], " +
            "[" + Constraint.MENTAL_STATUS + "], " +
            "[" + Constraint.NUTRITIONAL_STATUS + "], " +
            "[" + Constraint.RESPIRATION + "], " +
            "[" + Constraint.OEDEMA + "], " +
            "[" + Constraint.CHEST_WALL_RETRACTION + "], " +
            "[" + Constraint.OTHERS + "], " +
            "[" + Constraint.ORS_TAKEN + "], " +
            "[" + Constraint.ORS_VOLUME_TAKEN_IN_PACKETS + "], " +
            //"CONVERT(Decimal(9,2), " +  "[" + Constraint.ORS_VOLUME_TAKEN_IN_PACKETS + "])" + " as orsVolumeTakenInPackets, " +
            "[" + Constraint.IV_FLUID + "], " +
            "[" + Constraint.DRUG_TAKEN + "], " +
            "[" + Constraint.DRUG_NAMES + "], " +

            "[" + Constraint.TYPE_OF_DIARRHOEA + "], " +
            "[" + Constraint.REFERRED_TO_DOCTOR + "], " +
            "[" + Constraint.CAUSE_OF_REFERRAL + "], " +
            "[" + Constraint.REHYDRATION + "], " +
            "[" + Constraint.EXTERNAL_REFERRED_TO + "], " +
            "[" + Constraint.ICD10CODE + "], " +
            "[" + Constraint.ICD10NAME + "], " +
            "[" + Constraint.NURSE_CODE + "], " +
            "[" + Constraint.DOCTOR_CODE + "] " +


            " from " + Constraint.TABLE_CURRENT_HOSPITAL_PATIENT +
            " where " +
            "["  + Constraint.PATIENT_ID + "]=?";


    //public static String SQL_DOCTOR_MASTER = "Select [Doctor_s Code], [Doctor_s Name] from " + Constraint.TABLE_DOCTOR_MASTER + " where [" + Constraint.DOCTORS_CODE + "]=? AND "
}

