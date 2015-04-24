<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	   <title>UGA CREATE</title>
	   <meta charset="utf-8" />
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  	    <script src="actions.js"></script>

  	    <style>
  	     .col-md-4{
  	      	border: 1px solid gray;
  	      	height: 200px;
  	      	padding: 0px;
  	      }
  	      .col-md-8{
  	      	border: 1px solid gray;
  	      	height: 220px;
  	      }
  	      .img-circle{
    	     position: absolute;
    	     top: 35%;
    	     left: 35%;
    	     width: 25%;
    	     background-color: white;
		} 
    </style>



	</head>
   <body>
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">Shopping Time</a>
            </div>
          <div>
         <ul class="nav navbar-nav">
           <li><a href="#">My Profile</a></li>
           <li><a href="#">Products</a></li>
           <li><a href="#">Cart</a></li>
         </ul>
       </div>
      </div>
     </nav>

     <br>
     <div class="container">
     <div class="jumbotron">
       <h1>Shoppalot.com</h1>      
       <p>New User? Sign up!</p>   
       <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Sign Up
    </button>   
      </div>
    </div>
    <br>


    <div class = "container">
      <h2>Already have an account? Welcome back!</h2>
      <form action = "project-search.php" method ="get">
      <input type="text" name="userLogin" class="textfield" placeholder="Username">
      <br><br>
      <input type="text" name="userPassword" class="textfield" placeholder="Password">
      <br><br>
      <input type="submit" name="submit" class="btn btn-primary btn-lg" value="Sign In">
      </form>
    </div>
  
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
             <h4 class="modal-title" id="myModalLabel">Create Account</h4>
            </div>
          <div class="modal-body">
            <form role="form" enctype="multipart/form-data" action="addUser" method="POST">
          <div class="form-group" id="fname">
             <label>First Name: </label>
             <input type="textarea" class="form-control" id="fnameA" onchange="fnameFix()">
             <span class="glyphicon glyphicon-ok form-control-feedback" id="nameIconA"></span>
          </div>
          <div class="form-group" id="lname">
               <label>Last Name: </label>
             <input type="textarea" class="form-control" id="lnameA">
             <span class="glyphicon glyphicon-ok form-control-feedback" id="nameIconB"></span>
          </div>
          <div class="form-group" id="user">
               <label>User Name: </label>
             <input type="textarea" class="form-control" id="unameA" onchange="unameFix">
             <span class="glyphicon glyphicon-ok form-control-feedback" id="nameIconB"></span>
          </div>
        <div class="form-group" id="email">
           <label for="email">Email address:</label>
             <input type="email" class="form-control" id="emailA">
             <span class="glyphicon glyphicon-ok form-control-feedback" id="emailIcon"></span>
        </div>
        <div class="form-group" id="address">
            <label>Address: </label>
              <input type="textarea" class="form-control" id="addressA">
              <span class="glyphicon glyphicon-ok form-control-feedback" id="addressIcon"></span>
        </div>
        <div class="form-group" id="pwd">
           <label for="pwd">Password:</label>
             <input type="password" class="form-control" id="pwdA">
             <span class="glyphicon glyphicon-ok form-control-feedback" id="pwdIcon"></span>
         </div>
         <input type="submit" class="btn btn-default" value="Submit">
       </form>
        </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>