package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public enum TypeofDiarrhoeaEnum {

    AWD(0),ID(1),PD(2);

    private  String name;
    private String returnValue = "";

    private TypeofDiarrhoeaEnum(int code){

        if( code==0 ){
            returnValue = "AWD";
        }else if(code==1){
            returnValue = "ID";
        }else if(code==2){
            returnValue = "PD";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
