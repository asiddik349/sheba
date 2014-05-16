package org.icddrb.shebaservices.db;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 5/15/14
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Item implements Serializable {

    private String decSingleDispensePower = "";// Decimal
    private String strSingleDispenseUOM = "";
    private String strPharmacyUOM = "";// strSalesUnitOfMeasure
    private String drugCode = ""; // No_
    private String drugName = ""; // Description

}
