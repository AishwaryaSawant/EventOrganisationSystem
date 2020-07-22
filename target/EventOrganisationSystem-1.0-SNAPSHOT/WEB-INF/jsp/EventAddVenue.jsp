
<%-- 
    Document   : EventAddVenue
    Created on : Mar 28, 2020, 4:17:59 PM
    Author     : aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<!--    </nav>-->

<!--    <li class="nav-item">
        <a class="nav-link" href="#">Customer <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Owner</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Admin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Worker</a>
      </li>-->
<!--      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown link
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>-->
    </ul>
    </nav>
  </div>
            <h1>Add a Venue</h1>
        <form method="post" action="EventOwnerSubmit.htm">
        <div class="row">
          <div class="form-group col-md-4">
            Place name: <input type="text" class="form-control" placeholder="place name" name="venueName" minlength="2" required>
              </div>
            <br/>
            </div>
            
<!--            <div class="row">
          <div class="form-group col-md-4">
            <label for="inputLocation">Location</label>
            <select id="inputLocation" class="form-control" name="inputLocation">
              <option selected>Boston</option>
              <option>NewYork</option>
              <option>Newark</option>
            </select>
          </div>
        </div>-->
            
            <div class="row">
          <div class="form-group col-md-4">
                Select a Location: &nbsp;
            <select name="location">
                <c:forEach items="${listLocation}" var="location1">
                    <option value="${location1.lid}">${location1.name}</option>
                </c:forEach>
            </select>
                     </div>
        </div>
            
            
            <div class="row">
          <div class="form-group col-md-4">
            <label for="inputCapacity">Capacity</label>
            <select id="inputCapacity" class="form-control" name="inputCapacity">
              <option selected>50</option>
              <option>100</option>
              <option>200</option>
              <option>500</option>
              <option>750</option>
              <option>1000</option>
            </select>
          </div>
        </div>
            <div class="row">
          <div class="form-group col-md-4">
            <label for="inputPrice">Price</label>
            <select id="inputPrice" class="form-control" name="inputPrice">
              <option selected>1000.00</option>
              <option>2000.50</option>
              <option>3000.60</option>
            </select>
          </div>
        </div>
            <div class="row">
          <div class="form-group col-md-4">
            <label for="avail">Availability</label>
            <select id="avail" class="form-control" name="avail">
              <option selected>true</option>
              <option>false</option>

            </select>
          </div>
        </div>
            <div class="row">
          <div class="form-group col-md-4">
            <label for="negotiate">Negotiable</label>
            <select id="negotiate" class="form-control" name="negotiate">
              <option selected>true</option>
              <option>false</option>

            </select>
          </div>
        </div>
<!--            <input type="hidden">-->
            <input type="submit" value="submit"/>
      </form>
    </body>
</html>
