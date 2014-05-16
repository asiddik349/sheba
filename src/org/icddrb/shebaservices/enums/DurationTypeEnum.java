package org.icddrb.shebaservices.enums;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DurationTypeEnum {

    OVER(0),RUNNING(1);

    private  String name;
    private String returnValue = "";

    private DurationTypeEnum(int code){

        if(code==0){
            returnValue = "Over";
        }else if(code==1){
            returnValue = "Running";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
