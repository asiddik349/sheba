package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public enum NutritionalStatusEnum {

    NORMAL(0),MALNOURISHED(1);

    private  String name;
    private String returnValue = "";

    private NutritionalStatusEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Malnourished";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
