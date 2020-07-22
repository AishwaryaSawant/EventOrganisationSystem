<%-- 
    Document   : EventWorkerUpdate
    Created on : Apr 19, 2020, 12:37:57 PM
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
        <h1>Update Worker</h1>
        <table border="2"><tr><td>
        <form action="EventWorkerUpdated.htm" method="post">
            Worker id:</td><td><input type="text" name="id" value="${worker.getOid()}" readonly/><br/><br/></td></tr><tr><td>
        First Name:</td><td><input type="text" name="fname" value="${worker.getFirstname()}" minlength="2" required/><br/><br/></td></tr><tr><td>
        Last Name:</td><td><input type="text" name="lname" value="${worker.getLastname()}" minlength="2" required/><br/><br/></td></tr><tr><td>
            Email:</td><td><input type="text" name="email" value="${worker.getEmail()}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/><br/><br/></td></tr><tr><td>
            Password:</td><td><input type="password" name="password" value="${worker.getPassword()}" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/><br/><br/></td></tr><tr><td>
            Address:</td><td><input type="text" name="address" value="${worker.getAddress()}" required/><br/><br/></td></tr><tr><td>
            Phone Number:</td><td><input type="text" name="phonenumber" value="${worker.getPhonenumber()}" placeholder="111-111-1111" pattern="^\d{3}-\d{3}-\d{4}$" required/><br/><br/></td></tr><tr><td>
        Availability:</td><td><input type="text" name="avail" value="${worker.isIsavailable()}" placeholder="true/false" required/><br/><br/></td></tr><tr><td colspan="2">
<!--            <input type="hidden" value="updateMessage" name="option" />-->
            <input type="submit" value="Update Worker" name="submit" />
            </form></td></tr>
        </table>
    </body>
</html>
