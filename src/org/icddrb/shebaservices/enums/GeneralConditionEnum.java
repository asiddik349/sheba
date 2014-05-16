package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public enum GeneralConditionEnum {

    SELECT(0),NORMAL(1), IMITABLE(2),LATHERGIC(3),COMATOSE(4);

    private  String name;
    private String returnValue = "";

    private GeneralConditionEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Normal";
        }else if(code==2){
            returnValue = "Imitable";
        }else if(code==3){
            returnValue = "Lathergic";
        }else if(code==4){
            returnValue = "Comatose";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
