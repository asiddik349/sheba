package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public enum StoolConsistencyEnum {

    LOOSE(0),WATERY(1);

    private  String name;
    private String returnValue = "";

    private StoolConsistencyEnum(int code){

        if( code==0 ){
            returnValue = "Loose";
        }else if(code==1){
            returnValue = "Watery";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
