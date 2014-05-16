package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/24/14
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SexEnum {

    SELECT(0), WATERY(1), SOFT(2);

    private  String name;
    private String returnValue = "";

    private SexEnum(int code){

        if(code==0){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Male";
        }else if(code==2){
            returnValue = "Female";
        }
        name = returnValue;
    }

    public String getName(){
        return name;
    }

}
