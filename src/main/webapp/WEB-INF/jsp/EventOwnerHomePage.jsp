<%-- 
    Document   : OwnerHomePage
    Created on : Mar 27, 2020, 5:25:57 PM
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
         <h1 style="text-align: center">Owner homepage</h1>
         <h3>Welcome ${sessionScope.user.firstname}</h3>
        <br><br>
        <form action="EventOwner.htm" method="post" style="text-align: center">
            <h2>Please make your selection below</h2>
            <br><br>
            <select name="optionAdd">
                <option value="addPlace" selected>Add Venue for Event</option>
                <option value="addFood">Add Food</option>
                <option value="addWorker">Add Worker</option>
            </select>
            <input type="submit" value="Send"/>
            <br/><br/>
        </form>
        <form action="EventOwnerView.htm" method="post" style="text-align: center">
            <select name="optionView">
                <option value="viewPlaces" selected>View Places added</option>
                <option value="viewFoods">View Food added</option>
                <option value="viewWorkers">View Workers added</option>
            </select> 
            <input type="submit" value="Send"/>
            <br/><br/>
        </form>
        <form action="EventOwnerChange.htm" method="post" style="text-align: center">
            <select name="optionViewPendingOrder">
                <option value="viewCustChange">View customer order change request</option>
                <option value="viewWorkerChange">View worker change request</option>
<!--                <option value="viewCompensationRequest">View compensation request</option>-->
            </select>
            <input type="submit" value="Send"/>
            <br/><br/>
        </form>
        <form action="EventOwnerBrowseOrder.htm" method="post" style="text-align: center">
            <select name="optionViewAllOrder">
                <option value="viewCompletedOrders">View Completed Orders</option>
                <option value="viewAllOrders">View All Orders</option>
            </select>
            &nbsp;
            <input type="submit" value="Send"/>
            <br/><br/>
        </form>
    </body>
</html>
