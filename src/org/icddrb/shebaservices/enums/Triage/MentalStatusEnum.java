package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public enum MentalStatusEnum {

    NORMAL(0),IRRITABLE(1), LESS_ACTIVE(2), LETHARGIC(3), CONVULSION(4), UNCONSCIOUS(5);

    private  String name;
    private String returnValue = "";

    private MentalStatusEnum(int code){

        if( code==0 ){
            returnValue = "Normal";
        }else if(code==1){
            returnValue = "Irritable";
        }else if(code==2){
            returnValue = "Less Active";
        }else if(code==3){
            returnValue = "Lethargic";
        }else if(code==4){
            returnValue = "Convulsion";
        }else if(code==5){
            returnValue = "Unconscious";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
