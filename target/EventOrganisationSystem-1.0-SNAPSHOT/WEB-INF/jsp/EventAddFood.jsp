<%-- 
    Document   : EventAddFood
    Created on : Apr 12, 2020, 8:48:11 PM
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
          <a href='/EventOrganisationSystem/EventSystemLogout.htm'><button type="button" class="btn btn-info">Log Out
              </button></a>       
        </button>
      </a>
        </li>
    </ul>
    </nav>
        <br/><br/>
  </div>
        
       <div class="d-flex justify-content-center">
           <table border="2" width="300"><tr><td colspan="2">
           <h1>Add Food</h1>
                   </td></tr>
               <tr><td>
        <form method="post" action="EventOwnerFoodSubmit.htm" name="abc">
        <div class="row">
          <div class="form-group col-md-4">
              <br/><br/><br/>
              
              
            <label for="foodname">Food Name </label>
                      </td><td>
            <!--<select name="foodname" id="foodname" onchange="populate()">-->
            <select name="foodname" id="foodname" size="10" multiple>
                <c:forEach items="${listFood}" var="food">
                    <option value="${food.oid}" selected>${food.foodname} | ${food.foodtype} | ${food.servecapacity} | ${food.price}</option>
                </c:forEach>
            </select>
                      </td>
                      <tr><td colspan="2" align="center">
        <input type="submit" value="submit"/>
      </form>
                   </td> </tr></table>
</div>
    </body>
</html>
