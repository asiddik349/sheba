package org.icddrb.shebaservices.enums;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DiarrhoeaDurationInEnum {

    HOURS(0), DAYS(1);

    private  String name;
    private String returnValue = "";

    private DiarrhoeaDurationInEnum(int code){

        if(code==0){
            returnValue = "Hrs";
        }else if(code==1){
            returnValue = "Days";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
