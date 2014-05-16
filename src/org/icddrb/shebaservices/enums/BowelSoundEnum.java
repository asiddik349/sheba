package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public enum BowelSoundEnum {

    SELECT(0),NORMAL(1), SLUGGISH(2), ABSENT(3), NOT_CLINICALY_INDICATED(4);

    private  String name;
    private String returnValue = "";

    private BowelSoundEnum(int code){

        if( code==0 ){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "Normal";
        }else if(code==2){
            returnValue = "Sluggish";
        }else if(code==3){
            returnValue = "Absent";
        }else if(code==4){
            returnValue = "Not Clinicaly Indicated";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
