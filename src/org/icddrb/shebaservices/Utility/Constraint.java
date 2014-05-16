package org.icddrb.shebaservices.Utility;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Constraint {

    public static final String SELECT = "--Select--";

    public static final String COMPANY = "icddrb$";

    public static final String TABLE_ITEM = "[" + COMPANY + "Item" + "]";     //Drug Dispense UOM
    public static final String TABLE_DRUG_DISPENSE_UOM = "[" + COMPANY + "Drug Dispense UOM" + "]";


    public static final String TABLE_HMS_SETUP = "[" + COMPANY + "HMS Setup" + "]";  //
    public static final String TABLE_NUMBER_SERIES_LINE = "[" + COMPANY + "No_ Series Line" + "]";
    public static final String STARTING_NO = "Starting No_";
    public static final String ENDING_NO_ = "Ending No_";
    public static final String INCREMENT_BY_NO_ = "Increment-by No_";
    public static final String LAST_NO_USED = "Last No_ Used";
    public static final String SERIES_CODE = "[Series Code]";
    public static final String OPEN = "[Open]";

    public static final String TABLE_DOCTOR_MASTER = "[" + COMPANY + "Doctor Master" + "]";

    // Start Table User Setup-----------------
    public static final String TABLE_USER_SETUP = "[" + COMPANY + "User Setup" + "]";
    public static final String USER_ID = "User ID";
    public static final String EMAIL_ID = "E-Mail";
    public static final String EMPLOYEE_ID = "Employee ID";
    public static final String USER_TYPE = "Type";
    public static final String DOCOTOR_TYPE = "Docotor Type";

    public static final String PROGRESS_REPORT = "Progress Report";
    public static final String DOCTORS_ORDER = "Doctor_s Order";
    public static final String DISCHARGE_ADVICE = "Discharge Advice";
    public static final String PATIENT_INTAKE = "Patient Intake";
    public static final String PATIENT_OUTPUT = "Patient Output";
    public static final String DIET_REQUIREMENT = "Diet Requirement";
    public static final String VITAL_SIGN = "Vital Sign";
    public static final String DRUG_ADMINISTRATION = "Drug Administration";
    public static final String WARD_TRANSFER = "Ward Transfer";
    public static final String BEDID_VERIFICATION = "BedId Verification";

    public static final String TWENTY_FOUR_HOUR_ACCESS = "Twenty Four Hour Access";
    public static final String GENERATE_DIET_REQUISITION = "Generate Diet Requisition";
    public static final String VIEW_DIET_REQUISITION = "View Diet Requisition";
    public static final String CANTEEN_DIET_REQUISITION = "Canteen Diet Requisition";
    public static final String DIET_SETUP = "Diet Setup";
    public static final String DIET_SETUP_ADMIN = "Diet Setup Admin";

    public static final String APPLICABLE_FOR_SSU_LAB_REQ = "Applicable for SSU Lab Req";


    // End Table User Setup

    // Start Table User
    public static final String TABLE_USER = "[User]";
    public static final String EXPIRATION_DATE = "Expiration Date";
    //----- End Table User

    // Start Current Hospital Patient
    public static final String TABLE_CURRENT_HOSPITAL_PATIENT = "[" + COMPANY + "Current Hospital Patients" + "]";
    public static final String PATIENT_ID = "Patient ID";
    public static final String WARD_ID = "Ward Id";
    public static final String PATIENT_NAME = "Patient Name";
    public static final String PATIENT_DIED = "Patient Died";
    public static final String UH_ID= "UHID";
    public static final String BED_ID = "Bed Id";
    public static final String DISCHARGED = "Discharged";
    public static final String WEIGHT_IN_KG = "Weight In Kg_";
    public static final String Z_SCORE_HA = "Z_Score_HA";
    public static final String Z_SCORE_WA = "Z_Score_WA";

    public static final String VISIT_DATE = "Visit Date";
    public static final String VISIT_TIME = "Visit Time";
    public static final String SEX = "Sex";
    public static final String AGE_IN_YEAR = "Age (Yrs_)";      //Ward Location Id
    public static final String AGE_IN_MONTH = "Age(Months)";
    public static final String AGE_IN_DAY = "Age(Days)";
    public static final String WARD_LOCATION_ID = "Ward Location Id";


    //----- End Table Current Hospital Patient

    //----- Start Table Prescription
    public static final String TABLE_PRESCRIPTION = "[" + COMPANY + "Prescription" + "]";
    //public static final String UH_ID = "UHID";
    public static final String DOCTOR_CODE = "Doctor Code";
    public static final String DOCTOR_NAME = "Doctor Name";
    public static final String PRESCRIPTION_NO = "Prescription No_";
    public static final String PRESCRIPTION_DATE = "Prescription Date";
    public static final String SCHEDULE_GENERATED = "Schedule Generated";
    public static final String STOPPED = "Stopped";
         //Deleted Discharge Prescription
    public static final String DISCHARGE_PRESCRIPTION = "Discharge Prescription";
    public static final String OLD_DISCHARGED_PRESCRIPTION = "Old Discharged Prescription";




    //----- End Table Prescription


    //----- Start Table Prescription Line
    public static final String TABLE_PRESCRIPTION_LINE = "[" + COMPANY + "Prescription Line" + "]";
    public static final String DELETED_DISCHARGE_PRESCRIPTION = "Deleted Discharge Prescription";
    public static final String PRESCRIPTION_SMALL_ID = "Prescription Id";
    public static final String PATIENT_SMALL_ID = "Patient Id";
    public static final String DRUG_INVENTORY = "Drug Inventory";
    public static final String SUBMITTED_BY = "Submitted By";
    public static final String ACTUAL_DOZE = "Actual Doze"; // Type
    public static final String DRUG_CODE = "Drug Code";
    public static final String DRUG_NAME = "Drug Name";
    public static final String TOTAL_QUANTITY = "Total Quantity";
    public static final String UNIT_OF_MEASURE = "Unit Of Measure";
    public static final String FREQUENCY = "Frequency";
    public static final String ROUTE = "Route";
    public static final String STARTING_DATE = "Starting Date";
    public static final String NO_OF_DAYS = "No of Days";
    public static final String END_DATE = "End Date";
    public static final String NO_OF_DOSES = "No_ of Doses";
    public static final String REMARKS = "Remarks";
    public static final String LINE_NO = "Line No_";            //[Stop]
    public static final String STOP = "Stop";

    //Line No_



    //----- End Table Prescription Line


    //----- Start Table Fluid Prescription Line
    public static final String TABLE_FLUID_PRESCRIPTION_LINE = "[" + COMPANY + "Fluid Prescription Line" + "]";
    public static final String FLUID_PRESCRIPTION_NO = "Fluid Prescription No_";
    //public static final String DOCTOR_CODE = "Doctor Code";
    public static final String DRUG_TYPE = "Drug Type";
    public static final String FLUID_CODE = "Fluid Code";
    public static final String FLUID_NAME = "Fluid Name";
    public static final String VOLUME = "Volume";
    public static final String REPEAT_TYPE = "Repeat Type";
    public static final String START_DATE = "Start Date";
    public static final String TOTAL_DURATION = "Total Duration";
    public static final String DOCTORS_REMARKS = "Doctor_s Remarks";

    public static final String STOPPED_SMALL = "stopped";
    public static final String PRESCRIPTION_TYPE = "Prescription Type";
    public static final String DURATION = "Duration";



    //----- End Table Fluid Prescription Line
    //Table Patient Registration
    public static final String TABLE_PATIENT_REGISTRATION = "[" + COMPANY + "Patient Registration" + "]";

    //Table Patient Progress
    public static final String TABLE_PROGRESS_REPORT = "[" + COMPANY + "SSU Patient Progress" + "]";

    public static final String TABLE_PROGRESS_REPORT_INSERT = "[02-Mar-2014].[dbo].[icddrb$SSU Patient Progress]";

    public static final String PROGRESS_REPORT_NO = "Progress Report No_";
    //public static final String patientID = "Doctor_s Remarks";
    //public static final String uhID = "UHID";
    //public static final String patientName = "Patient Name";
    public static final String AGE = "Age";
    //public static final String SEX = "Sex";
    public static final String DATE_OF_ADMISSION = "Date of Admission";
    public static final String TIME_OF_ADMISSION = "Time of Admission";
    public static final String DATE_OF_EXAM = "Date of Exam";
    public static final String TIME_OF_EXAM = "Time of Exam";
    public static final String DIARRHOEA_DURATION = "Diarrhoea Duration";
    public static final String DIARRHOEA_DURATION_IN = "Diarrhoea Duration In";
    public static final String GENERAL_CONDITION = "General Condition";
    public static final String VOMITING = "Vomiting";
    public static final String RADIAL_PULSE = "Radial Pulse";
    public static final String DEHYDRATION = "Dehydration";
    public static final String STOOL = "Stool";
    public static final String BLOODIN_STOOL = "Blood In Stool";
    public static final String FEVER = "Fever";
    public static final String COUGH = "Cough";
    public static final String ABDOMINAL_DISTENTION = "Abdominal Distention";
    public static final String ABDOMINAL_TENDERNESS = "Abdominal Tenderness";
    public static final String BREATHING = "Breathing";
    public static final String CHESTRE_TRACTION = "Chest Retraction";
    public static final String BOWEL_SOUND = "Bowel Sound";
    public static final String HEART = "Heart";
    public static final String LUNGS = "Lungs";
    public static final String URINENOT_PASSED = "Urine Not Passed";
    public static final String URINE_NOT_PASSED_DURATION = "Urine Not Passed Duration";
    public static final String OTHER_FINDINGS_1 = "Other Findings 1";
    public static final String OTHER_FINDINGS_2 = "Other Findings 2";
    public static final String OTHER_FINDINGS_3 = "Other Findings 3";
    public static final String CLINICAL_DIAGNOSIS = "Clinical Diagnosis";
    public static final String PATIENT_CONDITION = "Patient Condition";
    public static final String DOCTORS_CODE = "Doctor_s Code";
    public static final String APPROVED_BY_DOCTOR = "Approved By Doctor";
    public static final String APPROVAL_TIME = "Approval Time";
    public static final String NO_SERIES = "No_ Series";
    public static final String URINE_NOT_PASSED_DURATIONIN = "Urine Not Passed Duration In";
    public static final String CREATED_BY = "Created By";
    public static final String CREATION_DATETIME = "Creation DateTime";
    public static final String LAST_MODIFIED_BY = "Last Modified By";
    public static final String LAST_MODIFICATION_DATETIME = "Last Modification Datetime";
    public static final String CHOLERA_LIKE_ILLNESS = "Cholera Like Illness";


    // Start TriageInfo---------
    public static final String DIARRHOEA = "Diarrhoea";  // Checkbox
    //public static final String CHOLERA_LIKE_ILLNESS = "Diarrhoea Duration";
    //public static final String CHOLERA_LIKE_ILLNESS = "Diarrhoea Duration In";  // From Array/Enum
    public static final String ABDOMEN_DISTENTION = "Abdomen Distention"; // Checkbox
    public static final String ABD_DISTENTION_DURATION = "Abd_ Distention Duration";
    public static final String ABD_DISTENTION_DURATION_IN = "Abd_ Distention Duration In"; // From Array/Enum
    //public static final String Vomiting = "Vomiting";    // Checkbox
    public static final String VOMITING_DURATION = "Vomiting Duration";
    public static final String VOMITING_DURATION_IN = "Vomiting Duration In"; // From Array/Enum
    //public static final String Fever = "Fever";  // Checkbox
    public static final String FEVER_DURATION = "Fever Duration";
    public static final String FEVER_DURATION_IN = "Fever Duration In"; // From Array/Enum
    //public static final String Cough = "Cough";   // Checkbox
    public static final String COUGH_DURATION = "Cough Duration";
    public static final String COUGH_DURATIONIN = "Cough Duration In"; // From Array/Enum
    public static final String STOOL_CONSISTENCY = "Stool Consistency";  // From Array/Enum
    //public static final String Blood In Stool = "Blood In Stool";   // Checkbox
    public static final String STRAINING_AT_STOOL = "Straining at Stool"; // Checkbox
    public static final String MUCOUS_IN_STOOL = "Mucous in Stool";  // Checkbox

    //------- End Sysmtomps------
    public static final String CONDITION = "Condition"; // From Array/Enum
    public static final String MUCOSA = "Mucosa"; // From Array/Enum
    public static final String SKIN_TURGOR = "Skin Turgor";  // From Array/Enum
    public static final String EYES = "Eyes"; // From Array/Enum
    //public static final String RadialPulse = "Radial Pulse"; // From Array/Enum
    public static final String THIRST = "Thirst";  // From Array/Enum
    public static final String STATUS = "Status"; // From Array/Enum
    public static final String OTHER_PROBLEMS = "Other Problems";

    //------- End Assesment------

    public static final String MENTAL_STATUS = "Mental Status"; // From Array/Enum
    public static final String NUTRITIONAL_STATUS = "Nutritional Status"; // From Array/Enum
    public static final String RESPIRATION = "Respiration"; // From Array/Enum
    public static final String OEDEMA = "Oedema";     // Checkbox
    public static final String CHEST_WALL_RETRACTION = "Chest Wall Retraction"; // Checkbox
    public static final String OTHERS = "Others";
    public static final String ORS_TAKEN = "ORS Taken";    // Unknown
    public static final String ORS_VOLUME_TAKEN_IN_PACKETS = "ORS Volume Taken(in packets)";
    public static final String IV_FLUID = "IV Fluid";   // Checkbox
    public static final String DRUG_TAKEN = "Drug Taken";  // Checkbox
    public static final String DRUG_NAMES = "Drug Names";

    //------- End Condition------

    public static final String TYPE_OF_DIARRHOEA = "Type of Diarrhoea"; // From Array/Enum
    public static final String REFERRED_TO_DOCTOR = "Referred to Doctor";  // Checkbox
    public static final String CAUSE_OF_REFERRAL = "Cause of Referral";  // From Array/Enum
    public static final String REHYDRATION = "Rehydration";  // From Array/Enum
    public static final String EXTERNAL_REFERRED_TO = "Referred To";  // From Array/Enum
    public static final String ICD10CODE = "ICDDR,B Disease Code";
    public static final String ICD10NAME = "ICDDR,B Disease Name";
    public static final String NURSE_CODE = "Nurse Code";
    //public static final String DoctorCode = "Doctor Code";
    // End Diagnosis
    // End Triage Info


    public  class Message{
        public static final String NOT_FOUND_PATIENT = "Patient not found";
        public static final String SUCCESS = "Success";
        public static final String PATIENT_DIED = "Patient had Expired";
        public static final String PATIENT_DISCHARGED = "Patient has already been discharged";
        public static final String DISCHARGED_PRESCRIPTION = "Patient has discharged prescription";
        public static final String WARD_LOCATION_OPD = "Patient's current location is SSU OPD";
        public static final String TRANSACTION_ERROR = "Error occurred, please contact with Sheba TEAM. Ext: 3522";
        public static final String PATIENT_NOT_IN_SSU = "Patient is not in SSU";
        public static final String WARD_NOT_FOUND = "The patient has no ward";
        public static final String SERVER_SETTINGS_NOT_FOUND = "Server settings not found";
        public static final String NUMBER_SERIES_GENERATION_FAILED = "Number series generation failed!";
        public static final String ADD_PROGRESS_REPORT = "A new progress report has been added sucessfully";
        public static final String UPDATE_PROGRESS_REPORT = "Update successfully done.";

    }
    
    public class  NumberSeries{
        
        public static final String PROGRESS_REPORT_NO_SERIES = "[Progress Report Nos_]";
        public static final String SSU_DISCHARGE_NO_SERIES = "[SSU Discharge Nos_]";
        public static final String PRESCRIPTION_NO_SERIES = "[Prescription No_]";
        public static final String PATIENT_VITAL_SIGN_NO_SERIES = "[Patient Vital Sign Entry Nos_]";
        public static final String INTER_WARD_TRANSFER_NO_SERIES = "[Interward Transfer Nos_]";
    }

    public class DateFormat{

        public static final String PROGRESS_REPORT_NO_SERIES = "[Progress Report Nos_]";
        public static final String SSU_DISCHARGE_NO_SERIES = "[SSU Discharge Nos_]";
        public static final String PRESCRIPTION_NO_SERIES = "[Prescription No_]";
        public static final String PATIENT_VITAL_SIGN_NO_SERIES = "[Patient Vital Sign Entry Nos_]";
        public static final String INTER_WARD_TRANSFER_NO_SERIES = "[Interward Transfer Nos_]";

        public static final String DEFAULT_DATE = "1754-01-01";
        public static final String DEFAULT_DATE_1753 = "1753-01-01";
        public static final String DEFAULT_GOLIVE_DATE = "2009-02-15";
        public static final String DF_DD_MM_YYYY = "dd-MM-yyyy";
        public static final String DF_YYYY_MM_DD = "yyyy-MM-dd";

        public static final String DF_DD_MM_YYYY_BD = "dd/MM/yyyy";

        public static final String DTF_DD_MM_YYYY_24HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
        public static final String DTF_DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy hh:mm:ss";

        public static final String DTF_YYYY_MM_DD_24HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        public static final String DTF_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";

        public static final String TF_HH_MM_SS = "hh:mm:ss";
        public static final String TF_24HH_MM_SS = "HH:mm:ss";

        public static final String TF_HH_MM_SS_AMPM = "hh:mm:ss a";

    }

    // Constant Value;

    public static final String WARD_SSU_OPD = "SSU OPD";
    public static final String CONST_WARD_SSU = "SSU";
    public static final String DECIMAL_TWO_DIGIT_FORMAT = "###.##";
    public static final String DECIMAL_THREE_DIGIT_FORMAT = "###.###";

    // End Constant Value;



    // Start Triage Information

    String query = "INSERT INTO " +
            Constraint.TABLE_PROGRESS_REPORT +
            "(" +
            "[" + "[" + Constraint.PROGRESS_REPORT_NO + "]]," +
            "[" + Constraint.PATIENT_ID + "]," +
            "[" + Constraint.UH_ID + "]," +
            "[" + Constraint.PATIENT_NAME + "]," +
            "[" + Constraint.AGE + "]," +
            "[" + Constraint.SEX + "]," +
            "[" + Constraint.DATE_OF_ADMISSION + "]," +
            "[" + Constraint.TIME_OF_ADMISSION + "]," +
            "[" + Constraint.DATE_OF_EXAM + "]," +
            "[" + Constraint.TIME_OF_EXAM + "]," +

            "[" + Constraint.DIARRHOEA_DURATION + "]," +
            "[" + Constraint.DIARRHOEA_DURATION_IN + "]," +
            "[" + Constraint.GENERAL_CONDITION + "]," +
            "[" + Constraint.VOMITING + "]," +
            "[" + Constraint.RADIAL_PULSE + "]," +
            "[" + Constraint.DEHYDRATION + "]," +
            "[" + Constraint.STOOL + "]," +
            "[" + Constraint.BLOODIN_STOOL + "]," +
            "[" + Constraint.FEVER + "]," +
            "[" + Constraint.COUGH + "]," +

            "[" + Constraint.ABDOMINAL_DISTENTION + "]," +
            "[" + Constraint.ABDOMINAL_TENDERNESS + "]," +
            "[" + Constraint.BREATHING + "]," +
            "[" + Constraint.CHESTRE_TRACTION + "]," +
            "[" + Constraint.BOWEL_SOUND + "]," +
            "[" + Constraint.HEART + "]," +
            "[" + Constraint.LUNGS + "]," +
            "[" + Constraint.URINENOT_PASSED + "]," +
            "[" + Constraint.URINE_NOT_PASSED_DURATION + "]," +
            "[" + Constraint.OTHER_FINDINGS_1 + "]," +

            "[" + Constraint.OTHER_FINDINGS_2 + "]," +
            "[" + Constraint.OTHER_FINDINGS_3 + "]," +
            "[" + Constraint.CLINICAL_DIAGNOSIS + "]," +
            "[" + Constraint.PATIENT_CONDITION + "]," +
            "[" + Constraint.DOCTORS_CODE + "]," +
            "[" + Constraint.APPROVED_BY_DOCTOR + "]," +
            "[" + Constraint.APPROVAL_TIME + "]," +
            "[" + Constraint.NO_SERIES + "]," +
            "[" + Constraint.URINE_NOT_PASSED_DURATIONIN + "]," +
            "[" + Constraint.CREATED_BY + "]," +

            "[" + Constraint.CREATION_DATETIME + "]," +
            "[" + Constraint.LAST_MODIFIED_BY + "]," +
            "[" + Constraint.LAST_MODIFICATION_DATETIME + "]," +
            "[" + Constraint.CHOLERA_LIKE_ILLNESS + "]" +
            ")" +
            " VALUES("+
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
            "?, ?, ?, ? " +
            ")";
}
