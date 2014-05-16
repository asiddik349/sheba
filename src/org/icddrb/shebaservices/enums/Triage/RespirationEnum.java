package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public enum RespirationEnum {

    NORMAL(0),FAST_AND_SHALLOW(1),FAST_AND_DEEP(2),GASPING(3);

    private  String name;
    private String returnValue = "";

    private RespirationEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Fast and Shallow";
        }else if(code==2){
            returnValue = "Fast and Deep";
        }else if(code==3){
            returnValue = "Gasping";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
