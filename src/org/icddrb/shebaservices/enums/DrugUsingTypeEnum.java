package org.icddrb.shebaservices.enums;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DrugUsingTypeEnum {

    REGULAR(0), SOS(1), SINGLE_DOSE(2), STAT(3);

    private  String name;
    private String returnValue = "";

    private DrugUsingTypeEnum(int code){

        if(code==0){
            returnValue = "Regular";
        }else if(code==1){
            returnValue = "As Req/SOS";
        }else if(code==1){
            returnValue = "Single Dose/ORS";
        }else if(code==1){
            returnValue = "STAT";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
