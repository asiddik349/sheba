package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public enum DurationEnum {

    HRS(0),DAYS(1);

    private  String name;
    private String returnValue = "";

    private DurationEnum(int code){

        if( code==0 ){
            returnValue = "Hrs.";
        }else if(code==1){
            returnValue = "Days";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
