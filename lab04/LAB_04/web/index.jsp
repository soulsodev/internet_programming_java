<%@ page import="JSP.DateHelper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
  DateHelper dateHelper = new DateHelper();

  private String printGreeting(int hourNow) {
    String greeting = "Good ";

    if (hourNow >= 0 && hourNow <= 4) {
      greeting += "Night";
      return greeting;
    }

    if(hourNow >= 5 && hourNow <= 11) {
      greeting += "Morning";
      return greeting;
    }

    if(hourNow >= 12 && hourNow <= 16) {
      greeting += "Afternoon";
      return greeting;
    }

    greeting += "Evening";
    return greeting;
  }


  private String getDateWithDaysOffset(int daysOffset) {
    return dateHelper.getDay() + daysOffset + "." + dateHelper.getMonth() + "." + dateHelper.getYear();
  }

  private ArrayList<String> getListOfDates() {
    ArrayList<String> datesList = new ArrayList<String>();
    for (int i =0; i<=7; i++) {
      datesList.add(getDateWithDaysOffset(i));
    }
    return datesList;
  }

    private int getPageByHour(int hourNow) {
    //hourNow = hourNow + 6;
    System.out.println("howerNow:" + hourNow);
    if (hourNow >= 0 && hourNow <= 4) {
      return 0;
    }

    if(hourNow >= 5 && hourNow <= 11) {
      return 1;
    }

    if(hourNow >= 12 && hourNow <= 16) {
      return 2;
    }

    return 3;
  }

%>
<html>
<head>
    <title>$Title$</title>
  </head>
  <body>

  <div class="container mt-5">
    <p>
      <%= printGreeting(dateHelper.getHours()) %><br>
    </p>

    <table border="2">
      <tr>
        <td width="100px"><b>xx.dd.yyyy</b></td>
        <td width="100px"><b>Day of Week</b></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(0) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay(), dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(1) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 1, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(2) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 2, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(3) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 3, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(4) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 4, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(5) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 5, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
      <tr>
        <td width="100px"><%= getDateWithDaysOffset(6) %></td>
        <td width="100px"><%= dateHelper.getDayByDate(dateHelper.getDay() + 6, dateHelper.getMonth(), dateHelper.getYear()) %></td>
      </tr>
    </table>


    <p>
      <br>
      <b>Task %include%</b>
        <%int caseToUse = getPageByHour(dateHelper.getHours());
          switch(caseToUse) {
          case 0:
        %>
      <%@include file="night.jsp"%>
<%--      <jsp:include page="night.jsp"></jsp:include>--%>
<%--      <jsp:forward page="night.jsp"></jsp:forward>--%>
      <%
          break;
        case 1:
      %>
      <%@include file="morning.jsp"%>
<%--      <jsp:include page="morning.jsp"></jsp:include>--%>
<%--      <jsp:forward page="morning.jsp"></jsp:forward>--%>
      <%
          break;
        case 2:
      %>
       <%@include file="afternoon.jsp"%>
<%--      <jsp:include page="afternoon.jsp"/>--%>
<%--      <jsp:forward page="afternoon.jsp"/>--%>
<%--      <jsp:include page="/AfternoonServlet"/>--%>
      <%
          break;
        case 3:
      %>
      <%@include file="evening.jsp"%>
<%--      <jsp:include page="evening.jsp"></jsp:include>--%>
<%--      <jsp:forward page="evening.jsp"></jsp:forward>--%>
      <%
            break;
        }
      %>
    </p>

    <form action="Jjj" method="GET">
      <button type="submit">Jjj (GET)</button>
    </form>

    <form action="Jjj" method="POST">
      <button type="submit">Jjj (POST)</button>
    </form>
  </div>
  </body>
</html>