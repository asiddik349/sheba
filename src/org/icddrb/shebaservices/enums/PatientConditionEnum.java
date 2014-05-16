package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:21 PM
 * To change this template use File | Settings | File Templates.
 */
public enum PatientConditionEnum {

    SELECT(0), IMPROVED(1), UNCHANGED(2), DETORIATED(3);

    private  String name;
    private String returnValue = "";

    private PatientConditionEnum(int code){

        if(code==0){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Improved";
        }else if(code==2){
            returnValue = "Unchanged";
        }else if(code==3){
            returnValue = "Detoriated";
        }
        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
