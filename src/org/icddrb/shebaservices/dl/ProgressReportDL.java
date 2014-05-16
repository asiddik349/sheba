package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.AppSQL;
import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.MyDate;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.CurrentHospitalPatient;
import org.icddrb.shebaservices.db.ProgressReport;
import org.icddrb.shebaservices.db.ProgressReportManage;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;
import org.icddrb.shebaservices.enums.DrugInventoryEnum;
import org.icddrb.shebaservices.enums.DrugUsingTypeEnum;
import org.icddrb.shebaservices.enums.FrequencyEnum;
import org.icddrb.shebaservices.enums.RouteEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProgressReportDL {

    public ArrayList<ProgressReport> getProgressReportsPatientID(ConnectionParameter cp, String patientID)
    {
        //String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=? AND " + Constraint.OLD_DISCHARGED_PRESCRIPTION + "=0 AND " + Constraint.DISCHARGE_PRESCRIPTION + "=0" ;
        return getProgressReport(cp, patientID);
    }

    private ArrayList<ProgressReport> getProgressReport( ConnectionParameter cp ,String patientID) {


        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        ArrayList<ProgressReport> prescriptionList = new ArrayList<ProgressReport>();
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
                //System.out.println("Start 0");
                ProgressReport progressReport= new ProgressReport();
                    progressReport.setProgressReportNo(rst.getString(Constraint.PROGRESS_REPORT_NO));
                    progressReport.setDateOfExam(rst.getString(Constraint.DATE_OF_EXAM));
                //System.out.println("Start 1");
                    progressReport.setTimeOfExam(rst.getString(Constraint.TIME_OF_EXAM));
                //System.out.println("Start 2");
                    progressReport.setPatientID(rst.getString(Constraint.PATIENT_ID));
                    progressReport.setUhID(rst.getString(Constraint.UH_ID));
                    progressReport.setPatientName(rst.getString(Constraint.PATIENT_NAME));
                    //progressReport.setAge(rst.getString(Constraint.AGE));
                    progressReport.setSex(rst.getInt(Constraint.SEX));
                    progressReport.setDateOfAdmission(rst.getString(Constraint.DATE_OF_ADMISSION));
                    progressReport.setTimeOfAdmission(rst.getString(Constraint.TIME_OF_ADMISSION));

                    progressReport.setDiarrhoeaDuration(rst.getInt(Constraint.DIARRHOEA_DURATION));
                    progressReport.setUrineNotPassedDuration( rst.getInt(Constraint.URINE_NOT_PASSED_DURATION));
                    progressReport.setDdlDiarrhoeaDurationIn(rst.getInt(Constraint.DIARRHOEA_DURATION_IN));
                    progressReport.setDdlUrineNotPassedDurationIn(rst.getInt(Constraint.URINE_NOT_PASSED_DURATIONIN));
                    progressReport.setDdlGeneralCondition(rst.getInt(Constraint.GENERAL_CONDITION));
                    progressReport.setDdlRadialPulse(rst.getInt(Constraint.RADIAL_PULSE));
                    progressReport.setDdlDehydration(rst.getInt(Constraint.DEHYDRATION));
                    progressReport.setDdlStool(rst.getInt(Constraint.STOOL));
                    progressReport.setDdlBreathing(rst.getInt(Constraint.BREATHING));
                    progressReport.setDdlBowelSound(rst.getInt(Constraint.BOWEL_SOUND));
                    progressReport.setDdlHeart(rst.getInt(Constraint.HEART));
                    progressReport.setDdlLungs(rst.getInt(Constraint.LUNGS));
                    progressReport.setDdlPatientCondition(rst.getInt(Constraint.PATIENT_CONDITION));
                    progressReport.setDdlCholeraLikeIllness(rst.getInt(Constraint.CHOLERA_LIKE_ILLNESS));

                    progressReport.setBoolUrineNotPassed(rst.getInt(Constraint.URINENOT_PASSED));
                    progressReport.setDdlVomiting(rst.getInt(Constraint.VOMITING));
                    progressReport.setBoolBloodInStool(rst.getInt(Constraint.BLOODIN_STOOL));
                    progressReport.setBoolFever(rst.getInt(Constraint.FEVER));
                    progressReport.setBoolCough(rst.getInt(Constraint.COUGH));
                    progressReport.setBoolAbdominalDistention(rst.getInt(Constraint.ABDOMINAL_DISTENTION));
                    progressReport.setBoolAbdominalTenderness(rst.getInt(Constraint.ABDOMINAL_TENDERNESS));
                    progressReport.setBoolChestRetraction(rst.getInt(Constraint.CHESTRE_TRACTION));
                    progressReport.setBoolApprovedByDoctor(rst.getInt(Constraint.APPROVED_BY_DOCTOR));

                    progressReport.setOtherFindings1(rst.getString(Constraint.OTHER_FINDINGS_1));
                    progressReport.setOtherFindings2(rst.getString(Constraint.OTHER_FINDINGS_2));
                    progressReport.setOtherFindings3(rst.getString(Constraint.OTHER_FINDINGS_3));
                    progressReport.setClinicalDiagnosis(rst.getString(Constraint.CLINICAL_DIAGNOSIS));
                    progressReport.setDoctorCode(rst.getString(Constraint.DOCTORS_CODE));
                    progressReport.setApprovalTime(rst.getString(Constraint.APPROVAL_TIME));
                    progressReport.setNoSeries(rst.getString(Constraint.NO_SERIES));
                    progressReport.setCreatedBy(rst.getString(Constraint.CREATED_BY));
                    progressReport.setCreationDateTime(rst.getString(Constraint.CREATION_DATETIME));
                    progressReport.setLastModifiedBy(rst.getString(Constraint.LAST_MODIFIED_BY));
                //System.out.println("Start 3");
                    progressReport.setLastModificationDatetime(rst.getString(Constraint.LAST_MODIFICATION_DATETIME));
                //System.out.println("Start 4");

//                    progressReport.setFormattedApprovalTime(rst.getString("formattedApprovalTime"));
//                    progressReport.setFormattedDateOfAdmission(rst.getString("formattedDateOfAdmission"));
//                    progressReport.setFormattedTimeOfAdmission(rst.getString("formattedTimeOfAdmission"));
//                    progressReport.setFormattedDateOfExam(rst.getString("formattedDateOfExam"));
//                    progressReport.setFormattedTimeOfExam(rst.getString("formattedTimeOfExam"));       DF_DD_MM_YYYY_BD

                progressReport.setFormattedApprovalTime( MyDate.getEndDate( progressReport.getApprovalTime(),Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS,Constraint.DateFormat.TF_HH_MM_SS_AMPM,0) );
                progressReport.setFormattedDateOfAdmission( MyDate.getEndDate( progressReport.getDateOfAdmission(),Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS,Constraint.DateFormat.DF_DD_MM_YYYY_BD,0) );
                progressReport.setFormattedTimeOfAdmission( MyDate.getEndDate( progressReport.getTimeOfAdmission(),Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS,Constraint.DateFormat.TF_HH_MM_SS_AMPM,0) );
                progressReport.setFormattedDateOfExam( MyDate.getEndDate( progressReport.getDateOfExam(),Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS,Constraint.DateFormat.DF_DD_MM_YYYY_BD,0) );
                progressReport.setFormattedTimeOfExam( MyDate.getEndDate( progressReport.getTimeOfExam(),Constraint.DateFormat.DTF_YYYY_MM_DD_24HH_MM_SS,Constraint.DateFormat.TF_HH_MM_SS_AMPM,0) );

                //System.out.println("Start 5");
                System.out.println("100");
                    progressReport.setTranBowelSound( progressReport.getTranBowelSound() );
                System.out.println("101");
                    progressReport.setTranBreathing( progressReport.getTranBreathing() );
                System.out.println("102");
                    progressReport.setTranCholeraLikeIllness( progressReport.getTranCholeraLikeIllness() );
                System.out.println("103");
                    progressReport.setTranDehydration( progressReport.getTranDehydration() );
                System.out.println("104");
                    progressReport.setTranDiarrhoeaDurationIn( progressReport.getTranDiarrhoeaDurationIn() );
                System.out.println("105");
                    progressReport.setTranGeneralCondition( progressReport.getTranGeneralCondition() );
                System.out.println("106");
                    progressReport.setTranHeart( progressReport.getTranHeart() );
                System.out.println("107");
                    progressReport.setTranLungs( progressReport.getTranLungs() );
                System.out.println("108");
                    progressReport.setTranPatientCondition( progressReport.getTranPatientCondition() );
                System.out.println("109");
                    progressReport.setTranRadialPulse( progressReport.getTranRadialPulse() );
                System.out.println("110");
                    progressReport.setTranStool( progressReport.getTranStool() );
                System.out.println("111");
                    progressReport.setTranSexName( progressReport.getTranSexName() );
                System.out.println("112");
                    progressReport.setTranUrineNotPassedDurationIn( progressReport.getTranUrineNotPassedDurationIn() );
                System.out.println("113");
                    progressReport.setTranVomiting(progressReport.getTranVomiting());
                System.out.println("114");

                prescriptionList.add(progressReport);
            }
        }catch (Exception ex)
        {
            prescriptionList = null;
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
                prescriptionList = null;
                sqe.printStackTrace();
            }
        }

        return prescriptionList;
    }

    private String getQueryText(){

        String query = AppSQL.QRY_PROGRESS_REPORT + " where " + "["  + Constraint.PATIENT_ID + "]=? order by [" + Constraint.DATE_OF_EXAM + "] DESC, [" + Constraint.PROGRESS_REPORT_NO + "] DESC";
        return  query;
    }

    public ProgressReport getProgressReportPatientID(ConnectionParameter cp, String patientID, String progressReportNo)
    {
        //String whereClause = " WHERE [" + Constraint.PATIENT_ID + "]=? AND " + Constraint.OLD_DISCHARGED_PRESCRIPTION + "=0 AND " + Constraint.DISCHARGE_PRESCRIPTION + "=0" ;
        return getProgressReport(cp, patientID,progressReportNo);
    }

    private ProgressReport getProgressReport( ConnectionParameter cp ,String patientID, String progressReportNo) {


        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        ProgressReport progressReport = new ProgressReport();
        try
        {
            String query = getQueryTextForView();
           // Util.writeDataIntoText(query);
            //System.out.println("Test Query: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, progressReportNo );
            rst = pstmt.executeQuery();

            while( rst.next() )
            {

                progressReport.setProgressReportNo(rst.getString(Constraint.PROGRESS_REPORT_NO));
                progressReport.setDateOfExam(rst.getString(Constraint.DATE_OF_EXAM));
                progressReport.setTimeOfExam(rst.getString(Constraint.TIME_OF_EXAM));
                progressReport.setPatientID(rst.getString(Constraint.PATIENT_ID));
                progressReport.setUhID(rst.getString(Constraint.UH_ID));
                progressReport.setPatientName(rst.getString(Constraint.PATIENT_NAME));

                progressReport.setSex(rst.getInt(Constraint.SEX));
                progressReport.setDateOfAdmission(rst.getString(Constraint.DATE_OF_ADMISSION));
                progressReport.setTimeOfAdmission(rst.getString(Constraint.TIME_OF_ADMISSION));

                progressReport.setDiarrhoeaDuration(rst.getInt(Constraint.DIARRHOEA_DURATION));
                progressReport.setUrineNotPassedDuration( rst.getInt(Constraint.URINE_NOT_PASSED_DURATION));
                progressReport.setDdlDiarrhoeaDurationIn(rst.getInt(Constraint.DIARRHOEA_DURATION_IN));
                progressReport.setDdlUrineNotPassedDurationIn(rst.getInt(Constraint.URINE_NOT_PASSED_DURATIONIN));
                progressReport.setDdlGeneralCondition(rst.getInt(Constraint.GENERAL_CONDITION));
                progressReport.setDdlRadialPulse(rst.getInt(Constraint.RADIAL_PULSE));
                progressReport.setDdlDehydration(rst.getInt(Constraint.DEHYDRATION));
                progressReport.setDdlStool(rst.getInt(Constraint.STOOL));
                progressReport.setDdlBreathing(rst.getInt(Constraint.BREATHING));
                progressReport.setDdlBowelSound(rst.getInt(Constraint.BOWEL_SOUND));
                progressReport.setDdlHeart(rst.getInt(Constraint.HEART));
                progressReport.setDdlLungs(rst.getInt(Constraint.LUNGS));
                progressReport.setDdlPatientCondition(rst.getInt(Constraint.PATIENT_CONDITION));
                progressReport.setDdlCholeraLikeIllness(rst.getInt(Constraint.CHOLERA_LIKE_ILLNESS));

                progressReport.setBoolUrineNotPassed(rst.getInt(Constraint.URINENOT_PASSED));
                progressReport.setDdlVomiting(rst.getInt(Constraint.VOMITING));
                progressReport.setBoolBloodInStool(rst.getInt(Constraint.BLOODIN_STOOL));
                progressReport.setBoolFever(rst.getInt(Constraint.FEVER));
                progressReport.setBoolCough(rst.getInt(Constraint.COUGH));
                progressReport.setBoolAbdominalDistention(rst.getInt(Constraint.ABDOMINAL_DISTENTION));
                progressReport.setBoolAbdominalTenderness(rst.getInt(Constraint.ABDOMINAL_TENDERNESS));
                progressReport.setBoolChestRetraction(rst.getInt(Constraint.CHESTRE_TRACTION));
                progressReport.setBoolApprovedByDoctor(rst.getInt(Constraint.APPROVED_BY_DOCTOR));

                progressReport.setOtherFindings1(rst.getString(Constraint.OTHER_FINDINGS_1));
                progressReport.setOtherFindings2(rst.getString(Constraint.OTHER_FINDINGS_2));
                progressReport.setOtherFindings3(rst.getString(Constraint.OTHER_FINDINGS_3));
                progressReport.setClinicalDiagnosis(rst.getString(Constraint.CLINICAL_DIAGNOSIS));
                progressReport.setDoctorCode(rst.getString(Constraint.DOCTORS_CODE));
                progressReport.setApprovalTime(rst.getString(Constraint.APPROVAL_TIME));
                progressReport.setNoSeries(rst.getString(Constraint.NO_SERIES));
                progressReport.setCreatedBy(rst.getString(Constraint.CREATED_BY));
                progressReport.setCreationDateTime(rst.getString(Constraint.CREATION_DATETIME));
                progressReport.setLastModifiedBy(rst.getString(Constraint.LAST_MODIFIED_BY));
                progressReport.setLastModificationDatetime(rst.getString(Constraint.LAST_MODIFICATION_DATETIME));

                progressReport.setFormattedApprovalTime(rst.getString("formattedApprovalTime"));
                progressReport.setFormattedDateOfAdmission(rst.getString("formattedDateOfAdmission"));
                progressReport.setFormattedTimeOfAdmission(rst.getString("formattedTimeOfAdmission"));
                progressReport.setFormattedDateOfExam(rst.getString("formattedDateOfExam"));
                progressReport.setFormattedTimeOfExam(rst.getString("formattedTimeOfExam"));

                progressReport.setTranBowelSound( progressReport.getTranBowelSound() );
                progressReport.setTranBreathing( progressReport.getTranBreathing() );
                progressReport.setTranCholeraLikeIllness( progressReport.getTranCholeraLikeIllness() );
                progressReport.setTranDehydration( progressReport.getTranDehydration() );
                progressReport.setTranDiarrhoeaDurationIn( progressReport.getTranDiarrhoeaDurationIn() );
                progressReport.setTranGeneralCondition( progressReport.getTranGeneralCondition() );
                progressReport.setTranHeart( progressReport.getTranHeart() );
                progressReport.setTranLungs( progressReport.getTranLungs() );
                progressReport.setTranPatientCondition( progressReport.getTranPatientCondition() );
                progressReport.setTranRadialPulse( progressReport.getTranRadialPulse() );
                progressReport.setTranStool( progressReport.getTranStool() );
                progressReport.setTranSexName( progressReport.getTranSexName() );
                progressReport.setTranUrineNotPassedDurationIn( progressReport.getTranUrineNotPassedDurationIn() );
                progressReport.setTranVomiting( progressReport.getTranVomiting() );

            }
        }catch (Exception ex)
        {
            progressReport = null;
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
                progressReport = null;
                sqe.printStackTrace();
            }
        }

        return progressReport;
    }

    public ProgressReportManage getProgressReportManage( ConnectionParameter cp ,String progressReportNo) {


        Connection dbCon = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        ProgressReportManage progressReport = new ProgressReportManage();
        try
        {
            String query = getQueryTextForView();
            // Util.writeDataIntoText(query);
            //System.out.println("Test Query: " + query );
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, progressReportNo );
            rst = pstmt.executeQuery();

            while( rst.next() )
            {

                progressReport.setProgressReportNo(rst.getString(Constraint.PROGRESS_REPORT_NO));
                progressReport.setDateOfExam(rst.getString(Constraint.DATE_OF_EXAM));
                progressReport.setTimeOfExam(rst.getString(Constraint.TIME_OF_EXAM));
                progressReport.setPatientID(rst.getString(Constraint.PATIENT_ID));
                progressReport.setUhID(rst.getString(Constraint.UH_ID));
                progressReport.setPatientName(rst.getString(Constraint.PATIENT_NAME));

                progressReport.setSex(rst.getInt(Constraint.SEX));
                progressReport.setDateOfAdmission(rst.getString(Constraint.DATE_OF_ADMISSION));
                progressReport.setTimeOfAdmission(rst.getString(Constraint.TIME_OF_ADMISSION));

                progressReport.setDiarrhoeaDuration(rst.getInt(Constraint.DIARRHOEA_DURATION));
                progressReport.setUrineNotPassedDuration( rst.getInt(Constraint.URINE_NOT_PASSED_DURATION));
                progressReport.setDdlDiarrhoeaDurationIn(rst.getInt(Constraint.DIARRHOEA_DURATION_IN));
                progressReport.setDdlUrineNotPassedDurationIn(rst.getInt(Constraint.URINE_NOT_PASSED_DURATIONIN));
                progressReport.setDdlGeneralCondition(rst.getInt(Constraint.GENERAL_CONDITION));
                progressReport.setDdlRadialPulse(rst.getInt(Constraint.RADIAL_PULSE));
                progressReport.setDdlDehydration(rst.getInt(Constraint.DEHYDRATION));
                progressReport.setDdlStool(rst.getInt(Constraint.STOOL));
                progressReport.setDdlBreathing(rst.getInt(Constraint.BREATHING));
                progressReport.setDdlBowelSound(rst.getInt(Constraint.BOWEL_SOUND));
                progressReport.setDdlHeart(rst.getInt(Constraint.HEART));
                progressReport.setDdlLungs(rst.getInt(Constraint.LUNGS));
                progressReport.setDdlPatientCondition(rst.getInt(Constraint.PATIENT_CONDITION));
                progressReport.setDdlCholeraLikeIllness(rst.getInt(Constraint.CHOLERA_LIKE_ILLNESS));

                progressReport.setBoolUrineNotPassed(rst.getInt(Constraint.URINENOT_PASSED));
                progressReport.setDdlVomiting(rst.getInt(Constraint.VOMITING));
                progressReport.setBoolBloodInStool(rst.getInt(Constraint.BLOODIN_STOOL));
                progressReport.setBoolFever(rst.getInt(Constraint.FEVER));
                progressReport.setBoolCough(rst.getInt(Constraint.COUGH));
                progressReport.setBoolAbdominalDistention(rst.getInt(Constraint.ABDOMINAL_DISTENTION));
                progressReport.setBoolAbdominalTenderness(rst.getInt(Constraint.ABDOMINAL_TENDERNESS));
                progressReport.setBoolChestRetraction(rst.getInt(Constraint.CHESTRE_TRACTION));
                progressReport.setBoolApprovedByDoctor(rst.getInt(Constraint.APPROVED_BY_DOCTOR));

                progressReport.setOtherFindings1(rst.getString(Constraint.OTHER_FINDINGS_1));
                progressReport.setOtherFindings2(rst.getString(Constraint.OTHER_FINDINGS_2));
                progressReport.setOtherFindings3(rst.getString(Constraint.OTHER_FINDINGS_3));
                progressReport.setClinicalDiagnosis(rst.getString(Constraint.CLINICAL_DIAGNOSIS));
                progressReport.setDoctorCode(rst.getString(Constraint.DOCTORS_CODE));
                progressReport.setApprovalTime(rst.getString(Constraint.APPROVAL_TIME));
                progressReport.setNoSeries(rst.getString(Constraint.NO_SERIES));
                progressReport.setCreatedBy(rst.getString(Constraint.CREATED_BY));
                progressReport.setCreationDateTime(rst.getString(Constraint.CREATION_DATETIME));
                progressReport.setLastModifiedBy(rst.getString(Constraint.LAST_MODIFIED_BY));
                progressReport.setLastModificationDatetime(rst.getString(Constraint.LAST_MODIFICATION_DATETIME));



            }
        }catch (Exception ex)
        {
            progressReport = null;
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
                progressReport = null;
                sqe.printStackTrace();
            }
        }

        return progressReport;
    }

    private String getQueryTextForView(){

        String query = AppSQL.QRY_PROGRESS_REPORT + " where " + "["  + Constraint.PROGRESS_REPORT_NO + "]=? order by [" + Constraint.DATE_OF_EXAM + "] ASC";
        return  query;
    }
    
    public int insertProgressReport(ConnectionParameter cp, ProgressReportManage progressReportManage, CurrentHospitalPatient currentHospitalPatient){
        System.out.println("Start Insert In DL");
        int returnValue = 0;
        boolean success = false;
        Connection dbCon = null;
        PreparedStatement pstmt = null;
        
        String query = qryInsertProgressreport(progressReportManage,currentHospitalPatient);
        //Util.writeDataIntoText(query);
        System.out.println("PR Insert Query Test:" + query );
        try
        {
            //String progressReportNo = NumberSeriesDL.getNumberSeries(cp,Constraint.NumberSeries.PROGRESS_REPORT_NO_SERIES );
            System.out.println("cp db:" + cp.getDatabaseName());
            System.out.println("cp IP:" + cp.getServerIP());
            System.out.println("cp getDatabaseName:" + cp.getDatabaseName());

            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            System.out.println("Test dbCon:" + dbCon );
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, progressReportManage.getProgressReportNo() );
            pstmt.setString(2, currentHospitalPatient.getPatientID() );
            pstmt.setString(3, currentHospitalPatient.getUhID() );
            pstmt.setString(4, currentHospitalPatient.getPatientName() );
            pstmt.setString(5, currentHospitalPatient.getAge() );
            pstmt.setInt(6, currentHospitalPatient.getSex() );
            pstmt.setString(7, currentHospitalPatient.getDateOfAdmission() );
            pstmt.setString(8, currentHospitalPatient.getTimeOfAdmission() );
            pstmt.setString(9, progressReportManage.getDateOfExam() );
            pstmt.setString(10, progressReportManage.getTimeOfExam() );

            pstmt.setInt(11, progressReportManage.getDiarrhoeaDuration() );
            pstmt.setInt(12, progressReportManage.getDdlDiarrhoeaDurationIn() );
            pstmt.setInt(13, progressReportManage.getDdlGeneralCondition() );
            pstmt.setInt(14, progressReportManage.getDdlVomiting());
            pstmt.setInt(15, progressReportManage.getDdlRadialPulse());
            pstmt.setInt(16, progressReportManage.getDdlDehydration() );
            pstmt.setInt(17, progressReportManage.getDdlStool() );
            pstmt.setInt(18, progressReportManage.getBoolBloodInStool() );
            pstmt.setInt(19, progressReportManage.getBoolFever() );
            pstmt.setInt(20, progressReportManage.getBoolCough());

            pstmt.setInt(21, progressReportManage.getBoolAbdominalDistention() );
            pstmt.setInt(22, progressReportManage.getBoolAbdominalTenderness() );
            pstmt.setInt(23, progressReportManage.getDdlBreathing());
            pstmt.setInt(24, progressReportManage.getBoolChestRetraction());
            pstmt.setInt(25, progressReportManage.getDdlBowelSound() );
            pstmt.setInt(26, progressReportManage.getDdlHeart() );
            pstmt.setInt(27, progressReportManage.getDdlLungs() );
            pstmt.setInt(28, progressReportManage.getBoolUrineNotPassed() );
            pstmt.setInt(29, progressReportManage.getUrineNotPassedDuration() );
            pstmt.setString(30, progressReportManage.getOtherFindings1());

            pstmt.setString(31, progressReportManage.getOtherFindings2() );
            pstmt.setString(32, progressReportManage.getOtherFindings3() );
            pstmt.setString(33, progressReportManage.getClinicalDiagnosis() );
            pstmt.setInt(34, progressReportManage.getDdlPatientCondition() );
            pstmt.setString(35, progressReportManage.getDoctorCode() );
            pstmt.setInt(36, progressReportManage.getBoolApprovedByDoctor());
            pstmt.setString(37, progressReportManage.getApprovalTime() );
            pstmt.setString(38, progressReportManage.getNoSeries() );
            pstmt.setInt(39, progressReportManage.getDdlUrineNotPassedDurationIn() );
            pstmt.setString(40, progressReportManage.getCreatedBy());

            pstmt.setString(41, progressReportManage.getCreationDateTime());
            pstmt.setString(42, progressReportManage.getLastModifiedBy() );
            pstmt.setString(43, progressReportManage.getLastModificationDatetime() );
            pstmt.setInt(44, progressReportManage.getDdlCholeraLikeIllness() );
            System.out.println("Test Execute Method for Insert2");
            returnValue = pstmt.executeUpdate();
            System.out.println("Test Execute Method for returnValue:" + success );
//            if( success ){
//              returnValue = 1;
//            }

        }catch (Exception ex) {
            returnValue = -1;
            ex.printStackTrace();
        }finally
        {
            try
            {
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
                returnValue = -1;
                sqe.printStackTrace();
            }
        }
        
        return returnValue;
    }

    public String qryInsertProgressreport(ProgressReportManage progressReportManage, CurrentHospitalPatient currentHospitalPatient){
        
        String query = "INSERT INTO " +
                Constraint.TABLE_PROGRESS_REPORT +
                "(" +
                "[" + Constraint.PROGRESS_REPORT_NO + "]," +
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
                    "?, ?, ?, ?" +
                ")";


        return query;
    }


    public int updateProgressReport(ConnectionParameter cp, ProgressReportManage progressReportManage, CurrentHospitalPatient currentHospitalPatient){

        int returnValue = 0;
        boolean success = false;
        Connection dbCon = null;
        PreparedStatement pstmt = null;

        if( Util.isValidString( progressReportManage.getProgressReportNo() ) || Util.isValidString(progressReportManage.getPatientID() ) ) {

            returnValue = -1;
            return returnValue;
        }

        String query = qryUpdateProgressreport( progressReportManage,currentHospitalPatient);

        try
        {
            //String progressReportNo = NumberSeriesDL.getNumberSeries(cp,Constraint.NumberSeries.PROGRESS_REPORT_NO_SERIES );

            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement(query);



            pstmt.setString(1, currentHospitalPatient.getDateOfAdmission() );
            pstmt.setString(2, currentHospitalPatient.getTimeOfAdmission() );
            pstmt.setString(3, progressReportManage.getDateOfExam() );
            pstmt.setString(4, progressReportManage.getTimeOfExam() );

            pstmt.setInt(5, progressReportManage.getDiarrhoeaDuration() );
            pstmt.setInt(6, progressReportManage.getDdlDiarrhoeaDurationIn() );
            pstmt.setInt(7, progressReportManage.getDdlGeneralCondition() );
            pstmt.setInt(8, progressReportManage.getDdlVomiting());
            pstmt.setInt(9, progressReportManage.getDdlRadialPulse());
            pstmt.setInt(10, progressReportManage.getDdlDehydration() );
            pstmt.setInt(11, progressReportManage.getDdlStool() );
            pstmt.setInt(12, progressReportManage.getBoolBloodInStool() );
            pstmt.setInt(13, progressReportManage.getBoolFever() );
            pstmt.setInt(14, progressReportManage.getBoolCough());

            pstmt.setInt(15, progressReportManage.getBoolAbdominalDistention() );
            pstmt.setInt(16, progressReportManage.getBoolAbdominalTenderness() );
            pstmt.setInt(17, progressReportManage.getDdlBreathing());
            pstmt.setInt(18, progressReportManage.getBoolChestRetraction());
            pstmt.setInt(19, progressReportManage.getDdlBowelSound() );
            pstmt.setInt(20, progressReportManage.getDdlHeart() );
            pstmt.setInt(21, progressReportManage.getDdlLungs() );
            pstmt.setInt(22, progressReportManage.getBoolUrineNotPassed() );
            pstmt.setInt(23, progressReportManage.getUrineNotPassedDuration() );
            pstmt.setString(24, progressReportManage.getOtherFindings1());

            pstmt.setString(25, progressReportManage.getOtherFindings2() );
            pstmt.setString(26, progressReportManage.getOtherFindings3() );
            pstmt.setString(27, progressReportManage.getClinicalDiagnosis() );
            pstmt.setInt(28, progressReportManage.getDdlPatientCondition() );
            pstmt.setString(29, progressReportManage.getDoctorCode() );
            pstmt.setInt(30, progressReportManage.getBoolApprovedByDoctor());
            pstmt.setString(31, progressReportManage.getApprovalTime() );
            pstmt.setString(32, progressReportManage.getNoSeries() );
            pstmt.setInt(33, progressReportManage.getDdlUrineNotPassedDurationIn() );
            pstmt.setString(34, progressReportManage.getCreatedBy());

            pstmt.setString(35, progressReportManage.getCreationDateTime());
            pstmt.setString(36, progressReportManage.getLastModifiedBy() );
            pstmt.setString(37, progressReportManage.getLastModificationDatetime() );
            pstmt.setInt(38, progressReportManage.getDdlCholeraLikeIllness() );

            returnValue = pstmt.executeUpdate();
            System.out.println("Update Value In Update Method: " + returnValue );
            if( returnValue<=0 ){
                returnValue = -1;
            }

        }catch (Exception ex) {
            returnValue = -1;
            ex.printStackTrace();
        }finally
        {
            try
            {
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
                returnValue = -1;
                sqe.printStackTrace();
            }
        }

        return returnValue;
    }

    public String qryUpdateProgressreport(ProgressReportManage progressReportManage, CurrentHospitalPatient currentHospitalPatient){

        String query = "UPDATE " +
                Constraint.TABLE_PROGRESS_REPORT +
                " SET " +


                "[" + Constraint.DATE_OF_ADMISSION + "]=?," +
                "[" + Constraint.TIME_OF_ADMISSION + "]=?," +
                "[" + Constraint.DATE_OF_EXAM + "]=?," +
                "[" + Constraint.TIME_OF_EXAM + "]=?," +

                "[" + Constraint.DIARRHOEA_DURATION + "]=?," +
                "[" + Constraint.DIARRHOEA_DURATION_IN + "]=?," +
                "[" + Constraint.GENERAL_CONDITION + "]=?," +
                "[" + Constraint.VOMITING + "]=?," +
                "[" + Constraint.RADIAL_PULSE + "]=?," +
                "[" + Constraint.DEHYDRATION + "]=?," +
                "[" + Constraint.STOOL + "]=?," +
                "[" + Constraint.BLOODIN_STOOL + "]=?," +
                "[" + Constraint.FEVER + "]=?," +
                "[" + Constraint.COUGH + "]=?," +

                "[" + Constraint.ABDOMINAL_DISTENTION + "]=?," +
                "[" + Constraint.ABDOMINAL_TENDERNESS + "]=?," +
                "[" + Constraint.BREATHING + "]=?," +
                "[" + Constraint.CHESTRE_TRACTION + "]=?," +
                "[" + Constraint.BOWEL_SOUND + "]=?," +
                "[" + Constraint.HEART + "]=?," +
                "[" + Constraint.LUNGS + "]=?," +
                "[" + Constraint.URINENOT_PASSED + "]=?," +
                "[" + Constraint.URINE_NOT_PASSED_DURATION + "]=?," +
                "[" + Constraint.OTHER_FINDINGS_1 + "]=?," +

                "[" + Constraint.OTHER_FINDINGS_2 + "]=?," +
                "[" + Constraint.OTHER_FINDINGS_3 + "]=?," +
                "[" + Constraint.CLINICAL_DIAGNOSIS + "]=?," +
                "[" + Constraint.PATIENT_CONDITION + "]=?," +
                "[" + Constraint.DOCTORS_CODE + "]=?," +
                "[" + Constraint.APPROVED_BY_DOCTOR + "]=?," +
                "[" + Constraint.APPROVAL_TIME + "]=?," +
                "[" + Constraint.NO_SERIES + "]=?," +
                "[" + Constraint.URINE_NOT_PASSED_DURATIONIN + "]=?," +
                "[" + Constraint.CREATED_BY + "]=?," +

                "[" + Constraint.CREATION_DATETIME + "]=?," +
                "[" + Constraint.LAST_MODIFIED_BY + "]=?," +
                "[" + Constraint.LAST_MODIFICATION_DATETIME + "]=?," +
                "[" + Constraint.CHOLERA_LIKE_ILLNESS + "]=? where [" + Constraint.PROGRESS_REPORT_NO + "='" + progressReportManage.getProgressReportNo() + "'";


        return query;
    }

}
