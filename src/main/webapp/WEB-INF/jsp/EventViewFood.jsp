<%-- 
    Document   : EventViewFood
    Created on : Apr 15, 2020, 7:37:24 AM
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
        <h1>View Food Added</h1>
        <table border="2">
            <tr>
            <th>Food Name</th>
            <th>Food Type</th>
            <th>Serve Capacity</th>
            <th>Price</th>
            </tr>
            <c:forEach var="food" items="${listFoods}">
                    <tr>
                    <td><c:out value="${food.getFoodname()}" /></td>
                    <td><c:out value="${food.getFoodtype()}" /></td>
                    <td><c:out value="${food.getServecapacity()}" /></td>
                    <td><c:out value="${food.getPrice()}" /></td>
<!--                     <td>
                        <a href="EventFoodDel.htm?id=${food.getOid()}">
                            Delete 
                        </a>
                    </td>-->
<!--                     <td>
                        <a href="EventFoodUp.htm?id=${venue.getOid()}">
                            Update 
                        </a>
                        <a href="EventVenueDel.htm?id=${venue.getOid()}">
                            Delete 
                        </a>
                    </td>-->
                    </tr>
            </c:forEach> 
        </table>
    </body>
</html>
