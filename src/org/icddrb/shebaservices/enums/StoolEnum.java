package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;
import org.icddrb.shebaservices.Utility.Util;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public enum StoolEnum {

    SELECT(0), WATERY(1), SOFT(2), FORMED(3);

    private  String name;
    private String returnValue = "";

    private StoolEnum(int code){

        if(code==0){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Watery";
        }else if(code==2){
            returnValue = "Soft";
        }else if(code==3){
            returnValue = "Formed";
        }
        name = returnValue;
    }

    public String getName(){
        return name;
    }

}
