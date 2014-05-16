package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public enum StatusEnum {

    EMTY(0),NO_SIGN_OF_DEHYDRATION(1),SOME_DEHYDRATION(2),SEVERE_DEHYDRATION(3);

    private  String name;
    private String returnValue = "";

    private StatusEnum(int code){

        if( code==0 ){
            returnValue = "";
        }else if(code==1){
            returnValue = "No Sign of Dehydration";
        }else if(code==2){
            returnValue = "Some Dehydration";
        }else if(code==3){
            returnValue = "Severe Dehydration";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
