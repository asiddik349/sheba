package org.icddrb.shebaservices.Utility;



import java.text.DecimalFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
//import javax.servlet.http.*;
//import javax.servlet.ServletOutputStream;
//import javax.*;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;
import org.icddrb.shebaservices.db.ConnectionParameter;
import org.icddrb.shebaservices.dbconnection.ConnectionPool;



/**
 * Created by IntelliJ IDEA.
 * User: siddik
 * Date: 3/25/14
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Util {

    public static boolean isValidString(String param)
    {
        if (param != null && !param.equals("null") && !param.trim().equals("") && param.length() > 0)
            return true;
        else
            return false;
    }

    public static String parseString(String param)
    {
        if ( isValidString(param) )
            return param;
        else
            return "";
    }

    public static long parseLong(String param)
    {
        long returnValue = 0;
        try
        {
            //System.out.println("Ret: " + param );
            returnValue = Long.parseLong(param);

            //System.out.println("Ret 22: " + param );
        }
        catch( NumberFormatException nfe)
        {
            returnValue = 0;
        }
        return returnValue;
    }

    public static boolean isValidLong(String param)
    {
        boolean returnValue = true;
        try
        {
            Long.parseLong(param);
        }
        catch( NumberFormatException nfe)
        {
            returnValue = false;
        }
        return returnValue;
    }

    public static double parseDouble(String param)
    {
        double returnValue = 0;
        try
        {
            returnValue = Double.parseDouble(param);
        }
        catch(NumberFormatException nfe)
        {
            returnValue = 0;
        }
        return returnValue;
    }

    public static boolean isValidDouble(String param)
    {
        boolean returnValue = true;
        try
        {
            if( Util.isValidString(param) )
            {
                int decimalPoint = 0;
                int nonDigit = 0;
                char[] charArray = param.toCharArray();
                for( int i = 0 ; i < charArray.length ; i++ )
                {
                    if( charArray[i] == '.' )
                        decimalPoint++;
                    else if ( !Character.isDigit( charArray[i] ) )
                        nonDigit++;
                    if(  decimalPoint > 1 || nonDigit > 0 )
                        returnValue = false;
                }
            }
            else
                returnValue = false;
        }
        catch(Exception nfe)
        {
            returnValue = false;
        }
        return returnValue;
    }

    public static int parseInt(String param)
    {
        int returnValue = 0;
        try
        {
            returnValue = Integer.parseInt(param);
        }
        catch( NumberFormatException nfe)
        {
            returnValue = 0;
        }
        return returnValue;
    }

    public static boolean isValidInteger(String param)
    {
        boolean returnValue = true;
        try
        {
            Integer.parseInt(param);
        }
        catch( NumberFormatException nfe)
        {
            returnValue = false;
        }
        return returnValue;
    }

    public static boolean isValidEmail(String param)
    {
        String str = param;
        boolean result = false;
        int indexOfAtChar = str.indexOf("@");
        int lastIndexOfAtChar = str.lastIndexOf("@");
        if ( (indexOfAtChar > 0) && (indexOfAtChar == lastIndexOfAtChar) )
        {
            int indexOfDotChar = str.indexOf(".", indexOfAtChar);
            if (indexOfDotChar > 0)
                result = true;
            else
                result = false; //not . after @
        }
        else
            result = false; // no @ or multiple @
        return result;
    }


    public static String[] stringAsArray(String allTypes)
    {
        StringTokenizer token = new StringTokenizer(allTypes, ",");
        String inCommonTypes[] = new String[token.countTokens()];
        int i = 0;
        while (token.hasMoreTokens())
        {
            inCommonTypes[i] = token.nextToken();
            i++;
        }
        return inCommonTypes;
    }

    public static String encodeHTMLQuote(String src)
    {
        if (isValidString(src))
            return src.replaceAll("\"", "&quot;");
        else
            return "";
    }

    public static String decodeHTMLQuote(String src)
    {
        if (isValidString(src))
            return src.replaceAll("&quot;", "\"");
        else
            return "";
    }

    public static String[] compareAndConcate(String prevSelectedTypes[],
                                             String priviligesTypes[])
    {

        String tmpPrivilegeTypes[];
        Vector vTempData = new Vector();
        for (int i = 0; i < prevSelectedTypes.length; i++)
        {
            for (int j = 0; j < priviligesTypes.length; j++)
            {
                if (priviligesTypes[j].equalsIgnoreCase(prevSelectedTypes[i]))
                    vTempData.add(prevSelectedTypes[i]);
            }
        }
        tmpPrivilegeTypes = new String[vTempData.size()];
        for (int i = 0; i < vTempData.size(); i++)
            tmpPrivilegeTypes[i] = (String) vTempData.get(i);
        return tmpPrivilegeTypes;
    }

    public static String[] concat(String a[], String b[])
    {
        String c[] = new String[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    public static boolean compareTwoFields(String first, String second)
    {
        int i = first.compareToIgnoreCase(second);
        if (i > 0)
            return false;
        else
            return true;
    }

    public static String getImageURI(String contentType)
    {
        String imageURI;
        if(contentType.equalsIgnoreCase("pdf"))
            imageURI = "../images/pdf.gif";
        else if(contentType.equalsIgnoreCase("doc"))
            imageURI = "../images/doc.gif";
        else if(contentType.equalsIgnoreCase("xls"))
            imageURI = "../images/xls.gif";
        else if(contentType.equalsIgnoreCase("ppt"))
            imageURI = "../images/ppt.gif";
        else if(contentType.equalsIgnoreCase("zip"))
            imageURI = "../images/zip.gif";
//          else if(contentType.equalsIgnoreCase("text/plain"))
//            patientFile.setImageURI("../images/file.gif");
        else
            imageURI = "../images/file.gif";
        return imageURI;
    }

    public static boolean sendMail(String fromAddress, String fromAddressTitle, List recipientList, List attachFileList, String subject, String content, String smtpServer)
    {
        boolean success = true;
        try
        {
            boolean debug = false;

            // Using ICDDR,B Mail Server
            //Set the host smtp address

            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", smtpServer);

            // create some properties and get the default Session
            Session session = Session.getInstance(props, null);
            session.setDebug(debug);

            // create a message
            Message message = new MimeMessage(session);

            InternetAddress addressFrom = new InternetAddress(fromAddress, fromAddressTitle);
            message.setFrom(addressFrom);
            message.setSubject(subject);
//      message.setSentDate( ( Calendar.getInstance() ).getTime() );
            for( int i = 0 ; i < recipientList.size() ; i++ )
                message.addRecipient( Message.RecipientType.TO, new InternetAddress( (String) recipientList.get(i) ) );
            // so that the mail does not show any attachment image.
            if( attachFileList.isEmpty() )
                message.setContent(content, "text/html");
            else
            {
                Multipart multiPart = new MimeMultipart();
                BodyPart messagePart = new MimeBodyPart();
                messagePart.setContent(content, "text/html");
                multiPart.addBodyPart(messagePart);
                for( int i = 0 ; i < attachFileList.size() ; i++ )
                {
                    File attachFile = (File) attachFileList.get(i);
                    FileDataSource fileSource = new FileDataSource(attachFile);
                    BodyPart attachPart = new MimeBodyPart();
                    attachPart.setDataHandler(new DataHandler(fileSource));
                    attachPart.setFileName(attachFile.getName());
                    multiPart.addBodyPart(attachPart);
                }
                message.setContent(multiPart);
            }
            // Start tempoary close for testing by siddik, 29.03.2010
            //Transport.send(message);
            // End tempoary close for testing by siddik, 29.03.2010

        }
        catch( MessagingException me)
        {
            success = false;
            me.printStackTrace();
        }
        catch( UnsupportedEncodingException uee)
        {
            success = false;
            uee.printStackTrace();
        }
        catch( Exception e)
        {
            success = false;
            e.printStackTrace();
        }
        return success;
    }



    public static String getQueryResult(String query , ConnectionParameter cp)
    {
        String  returnValue = null;
        PreparedStatement pstmt = null;
        Connection dbCon = null;
        ResultSet rst = null;
        try
        {
            dbCon = ConnectionPool.getDynamicDatabaseConnection(cp);
            pstmt = dbCon.prepareStatement( query );
            rst = pstmt.executeQuery();
            while(rst.next())
            {
                returnValue = rst.getString( 1 );
            }
        }
        catch (Exception exe)
        {
            returnValue = null;
            exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(pstmt != null)
                {
                    pstmt.close();
                    pstmt = null;
                }

                if(dbCon != null)
                {
                    dbCon.close();
                    dbCon = null;
                }
            }
            catch (Exception ex)
            {
                returnValue = null;
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static Date stringToDate(String strDate,String format){

        Date myDate=null;
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try{

            if(Util.isValidString(strDate) && Util.isValidString(format)){
                myDate = formatter.parse(strDate);
                //formatter.format(myDate);
                //System.out.println("Test Fotmat: " + formatter.format(myDate));
            }
        }catch(ParseException e){
            e.printStackTrace();
        }

        return myDate;
    }

    public static String getFileSize(long sizeInByte) throws Exception
    {
        String fileSize;
        if(sizeInByte >= (1024*1024))
        {
            double dSize = (double)sizeInByte/(1024*1024);
            fileSize = String.valueOf(dSize);
            fileSize = fileSize.substring(0, fileSize.indexOf(".") + 2) + " MB" ;
        }
        else if(sizeInByte >= 1024)
        {
            double dSize = (double)sizeInByte/1024;
            fileSize = String.valueOf(dSize);
            fileSize = fileSize.substring(0, fileSize.indexOf(".") + 2) + " KB" ;
        }
        else
            fileSize = sizeInByte + " Bytes" ;
        return fileSize;
    }

    public static File uploadFile(FormFile theFile, String fileDirectoryPath, String targetFileName)
    {
        File outFile;
        try
        {
            outFile = new File( fileDirectoryPath + "/" + targetFileName );
            outFile.delete();
            outFile.createNewFile();
            FileOutputStream out = new FileOutputStream(outFile);
            out.write(theFile.getFileData());
            out.flush();
            theFile.destroy();
            out.close();
        }
        catch (FileNotFoundException fe)
        {
            outFile = null;
            fe.printStackTrace();
        }
        catch(IOException ioe)
        {
            outFile = null;
            ioe.printStackTrace();
        }
        return outFile;
    }

    public static String arrayToString(String[] IDs){

        String categoryIDs="";
        if(IDs!=null && IDs.length>0){
            for(int i=0;i<IDs.length;i++){
                //System.out.println("Category IDS in Loop:  "+categoryIDs);
                categoryIDs=categoryIDs+IDs[i]+",";
                //System.out.println("Category IDS IMPL Loop: "+categoryIDs);

            }
            categoryIDs = categoryIDs.substring( 0, categoryIDs.lastIndexOf(',') );
        }

        //System.out.println("Category IDS IMPL: "+categoryIDs);
        return categoryIDs;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static String[] stringToArray(String str, String seperator) {

        String [] temp = null;
        if(str==null || str.equals("")) return temp;
        temp = str.split(seperator);

        return temp;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static byte verifyLogin( String user, String password )
    {
        byte  returnValue = 0;
        Connection dbCon = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            dbCon = DriverManager.getConnection("jdbc:jtds:sqlserver://172.16.8.91:1433/02-Mar-2014;tds=8.0;lastupdatecount=true", user, password);
            returnValue = 1;
        }
        catch (Exception exe)
        {
            returnValue = 0;
//      exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(dbCon != null)
                {
                    dbCon.close();
                }
            }
            catch (Exception ex)
            {
                returnValue = 0;
//        ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static byte verifyDynamicLogin( ConnectionParameter cp)
    {
        byte  returnValue = 0;
        Connection dbCon = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String url = String.format( "%s%s:1433/%s;tds=8.0;lastupdatecount=true", "jdbc:jtds:sqlserver://", cp.getServerIP(), cp.getDatabaseName());
            dbCon = DriverManager.getConnection(url, cp.getUserID(), cp.getPassword());
            returnValue = 1;
        }
        catch (Exception exe)
        {
            returnValue = 0;
//      exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(dbCon != null)
                {
                    dbCon.close();
                }
            }
            catch (Exception ex)
            {
                returnValue = 0;
//        ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static String arrayToStringWithSingleQuote(String[] IDs){

        String categoryIDs="";
        if(IDs!=null && IDs.length>0){
            for(int i=0;i<IDs.length;i++){
                //System.out.println("Category IDS in Loop:  "+categoryIDs);
                categoryIDs=categoryIDs + "'"+ IDs[i] + "'" + ",";
                //System.out.println("Category IDS IMPL Loop: "+categoryIDs);

            }
            categoryIDs = categoryIDs.substring( 0, categoryIDs.lastIndexOf(',') );
        }

        //System.out.println("Category IDS IMPL: "+categoryIDs);
        return categoryIDs;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static String getServerIPParameter(HttpServletRequest request){

        String serverIP = request.getParameter("serverIP");
//        if(!isValidString(serverIP)){
//            serverIP = "172.16.8.91";
//        }
        return  serverIP;
    }

    public static String getDBNameParameter(HttpServletRequest request){

        String databaseName = request.getParameter("databaseName");
//        if(!isValidString(databaseName)){
//            databaseName = "02-Mar-2014";
//        }
        return  databaseName;
    }

    public static String getUserID(HttpServletRequest request){

        String userID = request.getParameter("loggedInUserID");
        if(!isValidString(userID)){
            userID = "";
        }
        return  userID;
    }

    public static String getPatientID(HttpServletRequest request){

        String patientID = request.getParameter("patientID");
        if(!isValidString(patientID)){
            patientID = "";
        }
        return  patientID;
    }

    public static String getActionName(HttpServletRequest request){

        String actionName = request.getParameter("actionName");
        if(!isValidString(actionName)){
            actionName = "";
        }
        return  actionName;
    }

    public static String setSelectColumn(String column)
    {
        if (isValidString(column))
            return String.format("[%s]",column );
        else
            return "";
    }
    
    public static void writeDataIntoText(String content){

        try {



            File file = new File("C:\\Users\\Public\\log.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            //System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static String decimalFormat(String pattern, double value ) {

         if( value>0 ){
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String output = myFormatter.format(value);
            return  output;
         }
        return "";
    }
    
    public static String calculateAge(int year, int month, int days, String format){
        String age = "";
        System.out.println("month:" + month );
        System.out.println("days:" + days );
        System.out.println("year:" + year );
        days = 20;
        double monthInYear = month>0?(double)month/12:0;
        double daysInYear = days>0?(double)days/365:0;
        System.out.println("Test daysInYear:" + daysInYear);
        //double totalDays = (month * 30 + days ) + (year>0?(year*365):0);
        double tempYear = year + monthInYear + daysInYear;
        //double yearDays = 365;
        //System.out.println("totalDays:" + totalDays );
        //double tempYear = totalDays>0?totalDays/yearDays:0;
        System.out.println("tempYear:" + tempYear );
        age = decimalFormat( format,tempYear );
        //System.out.println("decimalFormat age:" + age );
        return  age;
    }

    public static String getQueryResultAsStringWithActiveConnection(String query,String param,Connection dbCon )
    {

        String  returnValue = "";
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            pstmt = dbCon.prepareStatement(query);
            pstmt.setString(1, param );
            rst = pstmt.executeQuery();
            if(rst.next())
                returnValue = rst.getString(1);

            //System.out.println("LOS or others : " + returnValue );
        }
        catch (Exception exe)
        {
            returnValue = null;
            exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(pstmt != null)
                {
                    pstmt.close();
                    pstmt = null;
                }

            }
            catch (Exception ex)
            {
                returnValue = null;
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static String[] getQueryResultAsString(String query, int noOfFields, Connection dbCon)
    {
        String[]  returnValue = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            pstmt = dbCon.prepareStatement(query);
            rst = pstmt.executeQuery();
            while(rst.next())
            {
                returnValue = new String[noOfFields];
                for( int i = 0; i < noOfFields; i++ )
                    returnValue[i] = rst.getString( i+1 );
            }
        }
        catch (Exception exe)
        {
            returnValue = null;
            exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(pstmt != null)
                {
                    pstmt.close();
                    pstmt = null;
                }
            }
            catch (Exception ex)
            {
                returnValue = null;
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static String[] getQueryResultAsArrayWithConnection(String query, Connection dbCon)
    {
        String[]  returnValue = null;
        String val = "";
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            int noOfFields = 1;
            pstmt = dbCon.prepareStatement(query);
            rst = pstmt.executeQuery();
            while(rst.next())
            {
                val += rst.getString( 1 ) + "#";
            }

            if(isValidString(val)){
                val = val.substring( 0, val.lastIndexOf('#') );
                returnValue = stringToArray(val,"#");
            }
        }
        catch (Exception exe)
        {
            returnValue = null;
            exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(pstmt != null)
                {
                    pstmt.close();
                    pstmt = null;
                }
            }
            catch (Exception ex)
            {
                returnValue = null;
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static String getQueryResultWithActiveConnection(String query , Connection dbCon)
    {
        String  returnValue = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try
        {
            pstmt = dbCon.prepareStatement(query);
            rst = pstmt.executeQuery();
            while(rst.next())
            {
                returnValue = rst.getString( 1 );
            }
        }
        catch (Exception exe)
        {
            returnValue = null;
            exe.printStackTrace();
        }
        finally
        {
            try
            {
                if(rst != null)
                {
                    rst.close();
                    rst = null;
                }
                if(pstmt != null)
                {
                    pstmt.close();
                    pstmt = null;
                }
            }
            catch (Exception ex)
            {
                returnValue = null;
                ex.printStackTrace();
            }
        }
        return returnValue;
    }

    public static boolean isAzithromycin(String drugCode){

        return ( drugCode.equalsIgnoreCase("IM-00005") || drugCode.equalsIgnoreCase("IM-00034") || drugCode.equalsIgnoreCase("IM-01397")?true:false );
    }

}
