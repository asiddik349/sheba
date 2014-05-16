package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BreathingEnum {

    SELECT(0),NORMAL(1), FAST(2);

    private  String name;
    private String returnValue = "";

    private BreathingEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Normal";
        }else if(code==2){
            returnValue = "Fast";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
