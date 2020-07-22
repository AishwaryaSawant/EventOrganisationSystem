<%-- 
    Document   : EventAdminAddVenue
    Created on : Apr 16, 2020, 11:15:41 PM
    Author     : aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <table border="2" align="center"><tr><td colspan="2">
                    <h1>Add Food</h1></td></tr><tr><td>
        <form action="EventAdminAddedFood.htm" method="post">
            <div class="row">
                <div class="form-group col-md-4">
            <label for="foodname" >Food Name </label></td><td>
            <input type="text" name="foodname" id="foodname" placeholder="food name" required/>
          </div>
            </div></td></tr><tr><td>
            <div class="row">
          <div class="form-group col-md-4">
              <label for="foodtype">Food Type </label></td><td>
            <input type="text" name="foodtype" id="foodtype" placeholder="food type" required/>
          </div>
            </div></td></tr><tr><td>
            <div class="row">
          <div class="form-group col-md-4">
              <label for="capacity">Serve Capacity </label></td><td>
            <input type="number" name="capacity" id="capacity" placeholder="0" min="0" required/>
          </div>
            </div></td><tr><td>
            <div class="row">
          <div class="form-group col-md-4">
              <label for="price">Price </label></td><td>
            <input type="number" name="price" id="price" placeholder="$" min="0" required/>
          </div>
            </div></td></tr><tr><td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="submit"/>
        </form></td></tr>
        </table>
    </body>
</html>
