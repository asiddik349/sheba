package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
public enum VomitingEnum {

    SELECT(0),NONE(1), OCCASIONAL(2),FREQUENT(3);

    private  String name;
    private String returnValue = "";

    private VomitingEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "None";
        }else if(code==2){
            returnValue = "Occasional";
        }else if(code==3){
            returnValue = "Frequent";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
