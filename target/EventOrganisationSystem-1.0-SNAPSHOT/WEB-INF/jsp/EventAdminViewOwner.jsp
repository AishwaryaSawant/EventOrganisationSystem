<%-- 
    Document   : EventAdminOwnerView
    Created on : Apr 17, 2020, 12:43:26 PM
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
        <h1>Owner View/Update/Delete :</h1>
        <table border="2">
            <tr>
             <th>First Name</th>
             <th>Last Name</th>
            <th>Password</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email</th>
            </tr>
            <c:forEach var="owner" items="${listOwners}">
                    <tr>
                    <td><c:out value="${owner.getFirstname()}" /></td>
                    <td><c:out value="${owner.getLastname()}" /></td>
                    <td><c:out value="${owner.getPassword()}" /></td>
                    <td><c:out value="${owner.getAddress()}" /></td>
                    <td><c:out value="${owner.getPhonenumber()}" /></td>
                    <td><c:out value="${owner.getEmail()}" /></td>
                    <td>
                        <a href="EventOwnerUp.htm?id=${owner.getOid()}">
                            Update 
                        </a></td><td>
                        <a href="EventOwnerDel.htm?id=${owner.getOid()}">
                            Delete 
                        </a>
                    </td>
                    </tr>
            </c:forEach> 
        </table>
    </body>
</html>
