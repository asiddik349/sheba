package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/1/14
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DrugTypeEnum {

    SELECT(0),DRUG(1), FLUID(2);

    private  String name;
    private String returnValue = "";

    private DrugTypeEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Drug";
        }else if(code==2){
            returnValue = "Fluid";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
