package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:10 PM
 * To change this template use File | Settings | File Templates.
 */
public enum RadialPulseEnum {

    SELECT(0),NORMAL(1), LOW_VOLUME(2),UNCOUNTABLE(3);

    private  String name;
    private String returnValue = "";

    private RadialPulseEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Normal";
        }else if(code==2){
            returnValue = "Low Volume";
        }else if(code==3){
            returnValue = "Uncountable";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
