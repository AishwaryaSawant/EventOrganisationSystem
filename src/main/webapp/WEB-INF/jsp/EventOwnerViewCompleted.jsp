<%-- 
    Document   : EventOwnerViewCompleted
    Created on : Apr 20, 2020, 5:24:19 PM
    Author     : aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="temp.css">
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <div>
        <!-- Image and text -->
    <nav class="navbar navbar-dark bg-dark navbar-collapse navbar-expand-lg">
        <ul class="navbar-nav">
            <li class="nav-item">
      <a class="navbar-brand" href="#">
          <img src="pictures\icons8-property-script-64.png" width="30" height="30" class="d-inline-block align-top" alt="">
          Event-O : End-to-End Event Organization
          <a href='/EventOrganisationSystem/EventSystemLogout.htm'><button type="button" class="btn btn-info">Log Out</button></a>       
        </button>
      </a>
        
            </li>
    </ul>
    </nav>
  </div>
        <h1>View All Completed and Closed orders:</h1>
        <table border="2">
            <tr>
             <th>Event Name</th>
             <th>Calculated Sum</th>
            <th>Status</th>
            <th>DateOfEvent</th>
            <th>DateOfReg</th>
            <th>CustomerName</th>
            </tr>
            <c:forEach var="custreq" items="${listcompleted}">
                    <tr>
                    <td><c:out value="${custreq.getEventname()}" /></td>
                    <td><c:out value="${custreq.getCalculatedsum()}" /></td>
                    <td><c:out value="${custreq.getStatus()}" /></td>
                    <td><c:out value="${custreq.getDateofevent()}" /></td>
                    <td><c:out value="${custreq.getDateofreg()}" /></td>
                    <td><c:out value="${custreq.getCustomer().getFirstname()}" /></td>
<!--                    <td>
                        <a href="EventOwnerCustReqUp.htm?id=${custreq.getEid()}">
                            Approve 
                        </a></td>
                        <td>
                        <a href="EventOwnerCustReqDec.htm?id=${custreq.getEid()}">
                            Decline 
                        </a>
                    </td>-->
                    </tr>
            </c:forEach> 
        </table>
    </body>
</html>
