<%-- 
    Document   : WorkerHomePage
    Created on : Mar 28, 2020, 12:19:32 AM
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

      </a>
        
            </li>
    </ul>
    </nav>
  </div>
         <h3>Welcome ${sessionScope.userwork.firstname}</h3><br/><br/><br/>
        
        <table border="2">
            <tr>
             <th>Event Name</th>
            <th>Date of Event</th>
            <th>Date of Registration</th>
            <th>Status</th>
            <th>Venue</th>
            </tr>
            
            <c:forEach var="order" items="${orderlist}">
                    <tr>
                    <td><c:out value="${order.getEventname()}" /></td>
                    <td><c:out value="${order.getDateofevent()}" /></td>
                    <td><c:out value="${order.getDateofreg()}" /></td>
                    <td><c:out value="${order.getStatus()}" /></td>
                    <td><c:out value="${order.getVenue().getPlacename()}"/></td>

                    <td>
                        <a href="EventOrderWorkerChange.htm?id=${order.getEid()}">
                            Request for change
                        </a>
                        
                    </td>
<!--                    <td> <a href="EventOrderWorkerCompensationReq.htm?id=${order.getEid()}">
                            Request for Compensation
                        </a></td>-->
                    </tr>
            </c:forEach> 
        </table><br/><br/>
        <table border="2"><tr><td>
        <h2>Special Instructions</h2><br/>
        <b>Be on time</b><br/>
        <b>View assignment carefully and request owner for any changes</b><br/>
        <b>Expected professional behavior all the time</b><br/></td></tr></table>
<!--         <select name="optionViewPendingOrder">
            <option value="viewPendingPlace">Browse pending place orders</option>
            <option value="viewPendingFood">Browse pending food orders</option>
            <option value="viewPendingService">Browse pending service orders</option>
        </select>
        <input type="submit" value="Send"/>
        <br/><br/>
        <select name="optionViewCompletedOrder">
            <option value="viewCompletedPlace">View completed place orders</option>
            <option value="viewCompletedFood">View completed food orders</option>
            <option value="viewCompletedService">View completed service orders</option>
        </select>-->
    </body>
</html>
