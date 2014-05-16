package org.icddrb.shebaservices.enums;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/1/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DurationInPrescriptionEnum {

    HRS(0),MIN(1);

    private  String name;
    private String returnValue = "";

    private DurationInPrescriptionEnum(int code){

        if(code==0){
            returnValue = "Hrs";
        }else if(code==1){
            returnValue = "Min";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
