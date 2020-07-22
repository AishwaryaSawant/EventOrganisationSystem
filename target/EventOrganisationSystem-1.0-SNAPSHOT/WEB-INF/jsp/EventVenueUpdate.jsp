<%-- 
    Document   : EventVenueUpdate
    Created on : Apr 17, 2020, 10:25:03 AM
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
        <h1>Venue Update</h1>
        <table border="2"><tr><td>
        <form action="EventVenueUpdated.htm" method="post">
            Venue ID</td><td><input type="text" name="oid" value="${venue.getOid()}" readonly/><br/><br/></td></tr><tr><td>
            Placename</td><td><input type="text" name="placename" value="${venue.getPlacename()}" required/><br/><br/></td></tr><tr><td>
            <div class="row">
<!--          <div class="form-group col-md-4">
                Select a Location: &nbsp;
            <select name="location">
                <c:forEach items="${locationList}" var="location1">
                    <option value="${location1.lid}">${location1.name}</option>
                </c:forEach>
            </select>
                     </div>-->
        </div>
        Capacity</td><td><input type="text" name="capacity" value="${venue.getCapacity()}" min="0" required/><br/><br/></td></tr><tr><td>
            Price</td><td><input type="text" name="price" value="${venue.getPrice()}" min="0" required/><br/><br/></td></tr><tr><td>
            Is Available</td><td><input type="text" name="avail" value="${venue.isIsavailable()}" placeholder="true/false" required /><br/><br/></td></tr><tr><td>
            Is Negotiable</td><td><input type="text" name="nego" value="${venue.isIsnegotiable()}" placeholder="true/false" required /><br/><br/></td></tr><tr><td colspan="2">
<!--            <input type="hidden" value="updateMessage" name="option" />-->
<input type="submit" value="Update Venue" name="submit" /></td></tr>
        </form>
    </table>
    </body>
</html>
