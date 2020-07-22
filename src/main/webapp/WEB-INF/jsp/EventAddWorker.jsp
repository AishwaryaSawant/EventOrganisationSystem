<%-- 
    Document   : EventAddWorker
    Created on : Apr 12, 2020, 8:54:35 PM
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
        <h1>Add Worker</h1>
        <form action="EventUserAdd.htm" method="post">     
<!--        <div class="container">
       <table class="table table-striped">
          <tbody>
             <tr>
          
             <fieldset>-->
                         <div class="row">
<!--                            <label class="col-md-4 control-label">/label>-->
                            <div class="form-group col-md-4">First Name
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input id="firstname" name="firstname" placeholder="firstname" class="form-control" required="true" value="" type="text" minlength="2"></div>
                            </div>
                         </div>
                         <div class="row">                            
                            <div class="form-group col-md-4">Last Name
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span><input id="lastname" name="lastname" placeholder="lastname" class="form-control" required="true" value="" type="text" minlength="2"></div>
                            </div>
                         </div>
                         <div class="row">
                            <div class="form-group col-md-4">Password
                               <div class="input-group"><input id="password" name="password" placeholder="password" class="form-control" required="true" value="" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"></div>
                            </div>
                         </div>
                         <div class="row">
                            <div class="form-group col-md-4">Address
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span><input id="address" name="address" placeholder="address" class="form-control" required="true" value="" type="text" minlength="2"></div>
                            </div>
                         </div>
                         <div class="row">
                            <div class="form-group col-md-4">Phone Number
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span><input id="phonenumber" name="phonenumber" placeholder="Phone Number" class="form-control" required="true" value="" type="text" pattern="^\d{3}-\d{3}-\d{4}$"></div>
                            </div>
                         </div>

<!--                         <div class="form-group">
                            <label class="col-md-4 control-label">Type</label>
                            <div class="col-md-8 inputGroupContainer">
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span><input id="email" name="email" placeholder="Email" class="form-control" required="true" value="" type="text"></div>
                            </div>
                         </div>-->
                          <div class="row">
                            <div class="form-group col-md-4">Email
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span><input id="email" name="email" placeholder="Email" class="form-control" required="true" value="" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></div>
                            </div>
                         </div>
                         <div class="row">
                             <div class="form-group col-md-4">Type
                               <div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span><select class="form-control" id="usertype" name="usertype" class="form-control">
                              <option selected>Worker</option>
                            </select>
                                   <!--<input id="phoneNumber" name="phoneNumber" placeholder="Phone Number" class="form-control" required="true" value="" type="text"></div>-->
                            </div><br/>
                            <div class="row">
                             <div class="form-group col-md-4">
                                <input type="submit" value="submit"/>
<!--                                <a class="btn btn-primary" href="EventUserAdd.htm" role="button">Register</a>-->
                              </div>
                          </div>
                              
                            
<!--                      </fieldset> 
             </tr>
          </tbody>
       </table>
    </div>-->
          </form>
    </body>
</html>
