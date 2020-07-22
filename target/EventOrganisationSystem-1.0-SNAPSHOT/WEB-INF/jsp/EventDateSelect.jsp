<%-- 
    Document   : EventDateSelect
    Created on : Apr 18, 2020, 1:04:49 PM
    Author     : aishw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
          $(function () {
            $("#datepicker").datepicker({ minDate: 0 });
          });
        </script>
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
        <br/><br/>
  </div>
        ${message}
        <br/><br/>
        <h1>Select Date:</h1>
        <form method="post" action="EventDateSelected.htm">
        <input type="text" name="eventdate" id="datepicker" /><br/><br/>
        <h1>Enter eventname:</h1><input type="text" name="eventname" />
        <input type="submit" value="submit"/>
        </form>
    </body>
</html>
