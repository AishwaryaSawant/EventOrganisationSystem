<%-- 
    Document   : EventOrderPlacement
    Created on : Apr 18, 2020, 9:15:28 AM
    Author     : aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Place your order:</h1>
        <br/><br/>
        <table>
            <tr>
             <th>Food Name</th>
             <th>Food Type</th>
            <th>Serve Capacity</th>
            <th>Price</th>
            
            </tr>
             <select name="foodname" id="foodname" size="2" multiple>
            <c:forEach var="food" items="${foolist}">
                    <tr>
                    <td><c:out value="${food.getFoodname()}" /></td>
                    <td><c:out value="${venue.getFoodtype()}" /></td>
                    <td><c:out value="${venue.getServecapacity()}" /></td>
                    <td><c:out value="${venue.getPrice()}" /></td>
                    <td>
                        <!--<button onclick="window.location.href = 'EventVenueUp.htm?id=${venue.getOid()}';">Select Venue</button>--> 
<!--                        <a href="EventVenueUp.htm?id=${venue.getOid()}">
                            Select 
                        </a>-->
                        
                    </td>
                    </tr>
            </c:forEach> 
             </select>
        </table>

    </body>
</html>
