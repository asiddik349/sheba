package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ThirstEnum {

    NORMAL(0),THIRSTY(1),UNABLE_TO_DRINK(2);

    private  String name;
    private String returnValue = "";

    private ThirstEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Thirsty";
        }else if(code==2){
            returnValue = "Unable to Drink";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
