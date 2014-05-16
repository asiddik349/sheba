package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DehydrationEnum {

    SELECT(0),NONE(1), SOME(2),SEVERE(3);

    private  String name;
    private String returnValue = "";

    private DehydrationEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "None";
        }else if(code==2){
            returnValue = "Some";
        }else if(code==3){
            returnValue = "Severe";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
