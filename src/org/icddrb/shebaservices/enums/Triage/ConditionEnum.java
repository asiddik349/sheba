package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ConditionEnum {

    NORMAL(0),IRRTIABLE(1), LESSACTIVE(2), LETHARGIC(3), COMATOSE(4);

    private  String name;
    private String returnValue = "";

    private ConditionEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Irrtiable";
        }else if(code==2){
            returnValue = "Less active";
        }else if(code==3){
            returnValue = "Lethargic";
        }else if(code==4){
            returnValue = "Comatose";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
