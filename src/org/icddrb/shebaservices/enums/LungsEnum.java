package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
public enum LungsEnum {

    SELECT(0),NORMAL(1), ABNORMAL(2);

    private  String name;
    private String returnValue = "";

    private LungsEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Normal";
        }else if(code==2){
            returnValue = "Abnormal";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
