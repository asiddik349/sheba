package org.icddrb.shebaservices.dl;

import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.db.HospitalDrug;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;
import org.icddrb.shebaservices.dbconnection.Persistent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/14/14
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HospitalDrugDL extends Persistent{

    public ArrayList<HospitalDrug> getDrugList(ConnectionParameter cp){

        ArrayList<HospitalDrug> drugs = new ArrayList<HospitalDrug>();
        String query = "SELECT [Description],[Drug Type],[No_] from " + Constraint.TABLE_ITEM + " WHERE [Use For SSU]=1 AND [Blocked]=0 AND [Drug Type] IN(1,2) order by [Description] ASC "  ;

        Connection dbCon = null;
        ResultSet rst = null;
        PreparedStatement preparedStatement = null;

        try{
            dbCon = ConnectionPool.getDynamicDatabaseConnection( cp );
            preparedStatement = dbCon.prepareStatement(query);
            rst =  preparedStatement.executeQuery();
            
            while (rst!=null && rst.next()){
                HospitalDrug drug = new HospitalDrug();
                drug.setStrDrugName( Util.parseString( rst.getString( 1 ) ) );
                drug.setDrugType( rst.getInt( 2 ) );
                drug.setStrDrugCode( Util.parseString( rst.getString( 3 ) ) );
                drugs.add(drug) ;
                
            }
        }catch (SQLException ex){
            drugs = null; 
           ex.printStackTrace();
        }finally {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if( dbCon!=null ){
                    dbCon.close();
                    dbCon = null;
                }

            }catch (Exception ex){
                ex.printStackTrace();
                drugs = null;
            }
        }

        return  drugs;
    }


    public HospitalDrug getDrugInfoByCode(ConnectionParameter cp, String drugCode){

        HospitalDrug drug = null;
        String query = "SELECT [No_],[Description],[Single Dispense Power],[Single Dispense UOM],[Sales Unit of Measure] from " + Constraint.TABLE_ITEM + " WHERE [Use For SSU]=1 AND [Blocked]=0 AND [Drug Type] IN(1,2) AND [No_]=? "  ;

        Connection dbCon = null;
        ResultSet rst = null;
        PreparedStatement preparedStatement = null;

        try{
            dbCon = ConnectionPool.getDynamicDatabaseConnection( cp );
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setString(1, drugCode );
            rst =  preparedStatement.executeQuery();

            while (rst!=null && rst.next()){
              drug = new HospitalDrug();
                drug.setStrDrugCode( Util.parseString( rst.getString( 1 ) ) );
                drug.setStrDrugName( Util.parseString( rst.getString( 2 ) ) );
                drug.setDecSingleDispensePower( Util.decimalFormat( Constraint.DECIMAL_TWO_DIGIT_FORMAT, Util.parseDouble( rst.getString( 3 ) ) ) );
                drug.setStrSingleDispenseUOM( Util.parseString( rst.getString( 4 ) ) );
                drug.setStrPharmacyUOM(  Util.parseString(rst.getString(5)));
                String dispenseQuery = "Select [Dispense Doze UOM] from " + Constraint.TABLE_DRUG_DISPENSE_UOM  + " where [Item No_]='" + drug.getStrDrugCode() + "'";
                System.out.println("Test dispenseQuery query: " + dispenseQuery );
                String str[] = Util.getQueryResultAsArrayWithConnection(dispenseQuery, dbCon);
                drug.setUnitOfMeasure(str);

            }
        }catch (SQLException ex){
            drug = null;
            ex.printStackTrace();
        }finally {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(preparedStatement != null)
                {
                    preparedStatement.close();
                    preparedStatement = null;
                }
                if( dbCon!=null ){
                    dbCon.close();
                    dbCon = null;
                }

            }catch (Exception ex){
                ex.printStackTrace();
                drug = null;
            }
        }

        return  drug;
    }
}
