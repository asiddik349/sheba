package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
public enum FrequencyEnum {

    SELECT(0),ONE_HOURLY(1), TWO_HOURLY(2), THREE_HOURLY(3), FOUR_HOURLY(4), FIVE_HOURLY(5), SIX_HOURLY(6), EIGHT_HOURLY(7), TWELVE_HOURLY(8), TWENTY_FOUR_HOURLY(9), TDS(10);

    private  String name;
    private String returnValue = "";

    private FrequencyEnum(int code){

        if(code==0){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "q1h";
        }else if(code==2){
            returnValue = "q2h";
        }else if(code==3){
            returnValue = "q3h";
        }else if(code==4){
            returnValue = "q4h";
        }else if(code==5){
            returnValue = "q5h";
        }else if(code==6){
            returnValue = "q6h";
        }else if(code==7){
            returnValue = "q8h";
        }else if(code==8){
            returnValue = "q12h-BD";
        }else if(code==9){
            returnValue = "q24h-OD";
        }else if(code==10){
            returnValue = "TDS";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
