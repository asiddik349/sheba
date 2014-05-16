<%@ page import="org.icddrb.shebaservices.Utility.Util" %>
<%@ page import="org.icddrb.shebaservices.db.UserSetup" %>
<%@ page import="org.icddrb.shebaservices.db.ConnectionParameter" %>
<%@ page import="org.icddrb.shebaservices.db.CurrentHospitalPatient" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.icddrb.shebaservices.db.DoctorOrder" %>
<%@ page import="org.icddrb.shebaservices.enums.StoolEnum" %>
<%@ page import="org.icddrb.shebaservices.Utility.MyDate" %>
<%@ page import="org.icddrb.shebaservices.dl.*" %>
<%@ page import="org.icddrb.shebaservices.Utility.Constraint" %>
<%--
  Created by IntelliJ IDEA.
  User: siddik
  Date: 3/25/14
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>




  <%
        //byte  login = Util.verifyLogin("it-admin","it111");
      byte  login = 1;
      int st = 1;
      String stool = StoolEnum.values()[st].getName();



      ConnectionParameter cp = new ConnectionParameter();

        String testCol = Util.setSelectColumn("User ID");
      System.out.println("Test Col: " + testCol );
      //String userID = request.getParameter("userID");
      cp.setUserID("IT-ADMIN");
      //String password = request.getParameter("password");
      cp.setPassword("it111");
      //String serverIP = request.getParameter("serverIP");
      cp.setServerIP("172.16.8.91");
      //String databaseName = request.getParameter("databaseName");
      cp.setDatabaseName("02-Mar-2014");


      //NumberSeriesDL numberSeriesDL = new NumberSeriesDL();
      





      CommonDL commonDL = new CommonDL();

      int los = commonDL.getLOS(cp,"P-0683443");
      System.out.println("Test LOS: " + los );

      CurrentHospitalPatientDL dl = new CurrentHospitalPatientDL();
      CurrentHospitalPatient pa = dl.getCurrentHospitalPatienByPatientID(cp, "P-0683443");
      DoctorOrderDL docDL = new DoctorOrderDL();

      //ArrayList<DoctorOrder> list = docDL.getDoctorOrdersPatientID(cp,"P-0683443");

      //System.out.println("List Size Pres: " + list.size() );

  
      if( pa!=null ){
          System.out.println("Test Patieent ID:" + pa.getWeightInKg() );
          
      }else{

          System.out.println("Test Error Found");
      }

      System.out.println("Test Call");
      System.out.println("Test Stool:" + stool );

      System.out.println("Current Date: " + MyDate.getCurrentDateAsString("yyyy-MM-dd hh:mm:ss"));

      //String seriesNo = NumberSeriesDL.getNumberSeries(cp, Constraint.NumberSeries.PROGRESS_REPORT_NO_SERIES);

      //System.out.println("JSP Page: seriesNo : " + seriesNo );

      //String serialNumber =  NumberSeriesDL.getSerialNumber(cp,seriesNo);

      //System.out.println("JSP Page: Serial Number: " + serialNumber );

      System.out.println("JSP Page: Current Time: " + MyDate.getCurrentDateAsString( "hh:mm:ss a") );

    %>
  <table>
      <tr>
          <td>User Name:</td>

      </tr>
  </table>
  </body>
</html>