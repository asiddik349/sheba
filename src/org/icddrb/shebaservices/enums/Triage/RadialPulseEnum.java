package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public enum RadialPulseEnum {

    NORMAL(0),UNCOUNTABLE_OR_ABSENT(1);

    private  String name;
    private String returnValue = "";

    private RadialPulseEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Uncountable or Absent";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
