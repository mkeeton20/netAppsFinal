
function fnameFix() {
    var str = document.getElementById("fnameA");
    str = str.value;
   if(str.length<1)
     {
	   document.getElementById("fname").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("nameIconA").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	      
	 }
   else
     {
	   document.getElementById("fname").setAttribute("class", "form-group has-success has-feedback");
	   return true;    
     }
}
function lnameFix() {
    var str = document.getElementById("lnameA");
    str = str.value;
    if(str.length<1)
    {
	   document.getElementById("lname").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("nameIconB").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	      
	 }
  else
    {
	   document.getElementById("lname").setAttribute("class", "form-group has-success has-feedback");
	   return true;    
    }

}
function unameFix(){
	var str = document.getElementById("unameA");
    str = str.value;
    if(str.length<6)
    {
	   document.getElementById("uname").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("unameIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	      
	 }
  else
    {
	   document.getElementById("uname").setAttribute("class", "form-group has-success has-feedback");
	   return true;    
    }
}

function emailFix(){
	var str = document.getElementById("emailA");
    str = str.value;
    if(str.length<1)
    {
	   document.getElementById("email").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("emailIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	      
	 }
  else
    {
	   document.getElementById("email").setAttribute("class", "form-group has-success has-feedback");
	   return true;    
    }
}
function pwdFix()
{
	var str = document.getElementById("pwdA");
	 if(str.length<6)
     {
	   document.getElementById("pwd").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("pwdIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	      
	 }
   else
     {
	   document.getElementById("pwd").setAttribute("class", "form-group has-success has-feedback");
	   return true;    
     }
}