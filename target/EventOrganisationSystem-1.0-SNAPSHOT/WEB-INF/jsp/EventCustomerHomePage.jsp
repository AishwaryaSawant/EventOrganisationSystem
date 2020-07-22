<%-- 
    Document   : CustomerHomePage
    Created on : Mar 28, 2020, 12:19:11 AM
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
    </ul>
    </nav>
  </div>
        <h3>Welcome ${sessionScope.usercust.firstname}</h3>
         <!--<p>Create an Event</p>-->
            <br><br>
            <Form method="post" action="EventCustomerOptionSelected.htm">
            <select name="customeroptions">
                <option value="placeEventOrder">Place an Order</option>
                <option value="viewEventOrders">View/Update order</option>
<!--                <option value="placeOrderService">Select a Worker</option>-->
            </select>
            <input type="submit" value="Send"/>
            <br/><br/>
<!--            <p>Browse Events</p>
            <select name="browseOrder">
                <option value="browsePlaceOrder">Browse Places selected</option>
                <option value="browseFoodOrder">Browse Food selected</option>
                <option value="browseCateringOrder">Browse Catering Service selected</option>
            </select>
            <input type="submit" value="Send"/>
            <p>Search Events</p>
            <select name="browseOrder">
                <option value="browsePlaceOrder">Browse Places selected</option>
                <option value="browseFoodOrder">Browse Food selected</option>
                <option value="browseCateringOrder">Browse Catering Service selected</option>
            </select>
            <input type="submit" value="Send"/>-->
            <br/><br/>
            </Form>
    </body>
</html>
