package org.icddrb.shebaservices.enums;

import org.icddrb.shebaservices.Utility.Constraint;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/16/14
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public enum RouteEnum {

    SELECT(0),TOP(1), PO(2), IV(3), IM(4), SC(5), ID(6), NG(7), SL(8), PR(9), PV(10), NEB(11);

    private  String name;
    private String returnValue = "";

    private RouteEnum(int code){

        if(code==0){
            returnValue = Constraint.SELECT;
        }else if(code==1){
            returnValue = "TOP";
        }else if(code==2){
            returnValue = "PO";
        }else if(code==3){
            returnValue = "IV";
        }else if(code==4){
            returnValue = "IM";
        }else if(code==5){
            returnValue = "SC";
        }else if(code==6){
            returnValue = "ID";
        }else if(code==7){
            returnValue = "NG";
        }else if(code==8){
            returnValue = "SL";
        }else if(code==9){
            returnValue = "PR";
        }else if(code==10){
            returnValue = "PV";
        }else if(code==11){
            returnValue = "NEB";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
