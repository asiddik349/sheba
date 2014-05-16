package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public enum RehydrationEnum {

    INTRAVENOUS(0),ORAL_WHO_SS(1),ORAL_RICE(2);

    private  String name;
    private String returnValue = "";

    private RehydrationEnum(int code){

        if( code==0 ){
            returnValue = "Intravenous";
        }else if(code==1){
            returnValue = "Oral(WHO/SS)";
        }else if(code==2){
            returnValue = "Oral(Rice)";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
