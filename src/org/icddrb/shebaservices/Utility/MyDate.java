package org.icddrb.shebaservices.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 4/27/14
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyDate {

    // dd-MM-yyyy hh:mm a = 27-04-2014 07:11 PM
    // yyyy-MM-dd hh:mm:ss = 2014-04-27 07:11:20

    public static String getCurrentDateAsString( String format )
    {
        SimpleDateFormat formatter = new SimpleDateFormat( format );
        Calendar cal = Calendar.getInstance();
        return formatter.format(cal.getTime());
    }

    public static String getEndDate(String startDate, String startFormat, String returnFormat, long millisecond)
    {
        String returnDate = null;
        try
        {
            //create SimpleDateFormat object with desired date format
            SimpleDateFormat returnFormatter = new SimpleDateFormat(returnFormat);
            if ( startDate != null && startFormat != null )
            {
                //create SimpleDateFormat object with start string date format
                SimpleDateFormat startFormatter = new SimpleDateFormat(startFormat);

                //parse the string into Date object
                Date date = startFormatter.parse(startDate);

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(date.getTime() + millisecond);

                //parse the date into another format
                returnDate = returnFormatter.format(cal.getTime());
            }
            else  // assuming the current date as start date
            {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(cal.getTimeInMillis() + millisecond);
                returnDate = returnFormatter.format(cal.getTime());
            }
        }
        catch( ParseException pe )
        {
            pe.printStackTrace();
        }
        return returnDate;
    }

    public static boolean isGreaterThanCurrentDate( String date, String format )
    {

        boolean isLessThan = false;
        SimpleDateFormat formatter = new SimpleDateFormat( format );

        Date currentDate = Util.stringToDate( getCurrentDateAsString("yyyy-MM-dd"),"yyyy-MM-dd" );
        Date givenDate = Util.stringToDate(date,"yyyy-MM-dd");

        //System.out.println("Test Cur:" + currentDate);
        //System.out.println("Test Giv:" + givenDate);

        if( givenDate.compareTo(currentDate)>=0 ){
            isLessThan = true;
        }
        return isLessThan;
    }
    
//    public static String getCurrentTime(String format){
//
//        String time = "";
//        Calendar cal = Calendar.getInstance();
//        cal.getTime();
//        if(Util.isValidString(format)){
//
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            time = sdf.format(cal.getTime());
//
//        }else {
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            time = sdf.format(cal.getTime());
//        }
//
//
//        return "";
//    }
}
