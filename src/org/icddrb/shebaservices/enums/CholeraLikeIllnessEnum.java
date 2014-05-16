package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public enum CholeraLikeIllnessEnum {

    SELECT(0),YES(1), NO(2);

    private  String name;
    private String returnValue = "";

    private CholeraLikeIllnessEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Yes";
        }else if(code==2){
            returnValue = "No";
        }
        name = returnValue;

    }

    public String getName(){
        return name;
    }
}
