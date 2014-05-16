package org.icddrb.shebaservices.enums;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DrugInventoryEnum {

    INTERNAL(0),EXTERNAL(1);

    private  String name;
    private String returnValue = "";

    private DrugInventoryEnum(int code){

        if(code==0){
            returnValue = "Internal";
        }else if(code==1){
            returnValue = "External";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }

}
