package org.icddrb.shebaservices.enums.Triage;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/29/14
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public enum ExternallyReferredToEnum {

    EMTY(0),DSH(1), DMCH(2), SSMCH(3), NICVD(4), IDCH(5), BSMMU(6), OTHER(7);

    private  String name;
    private String returnValue = "";

    private ExternallyReferredToEnum(int code){

        if( code==0 ){
            returnValue = " ";
        }else if(code==1){
            returnValue = "DSH";
        }else if(code==2){
            returnValue = "DMCH";
        }else if(code==3){
            returnValue = "SSMCH";
        }else if(code==4){
            returnValue = "NICVD";
        }else if(code==5){
            returnValue = "IDCH";
        }else if(code==6){
            returnValue = "BSMMU";
        }else if(code==7){
            returnValue = "Other";
        }

        name = returnValue;
    }

    public String getName(){
        return name;
    }
}
