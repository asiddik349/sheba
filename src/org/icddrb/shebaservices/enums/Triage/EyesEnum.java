package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public enum EyesEnum {

    NORMAL(0),SUNKEN(1);

    private  String name;
    private String returnValue = "";

    private EyesEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Sunken";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
