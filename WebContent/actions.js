
function fnameFix() {
    var str = document.getElementById("fname");
    str = str.value;
   if(str != "")
     {
     	document.getElementById("fnameA").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("fnameA").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("nameIconA").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
function lnameFix() {
    var str = document.getElementById("lname");
    str = str.value;
   if(str != "")
     {
     	document.getElementById("lnameB").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("lnameB").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("nameIconB").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }

}
function unameFix(){
	var str = document.getElementById("unameA");
    str = str.value;
   if(str != "")
     {
     	document.getElementById("user").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("user").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("unameIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
}

function emailFix(){
	var str = document.getElementById("emailA");
    str = str.value;
   if(str != "")
     {
     	document.getElementById("email").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("email").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("emailIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
}

function teleFix()
{
	var str = document.getElementById("tele");
	if(str != "")
     {
     	document.getElementById("phone").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("number").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("numberIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
 }
function adFix()
{
	var str = document.getElementById("ad");
	if(str != "")
     {
     	document.getElementById("address").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("address").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("addressIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
	}
 }
function majorChange()
{
	var str = document.getElementById("majorA");
	if(str != "")
     {
     	document.getElementById("major").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("major").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("majorIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
}
function pwdChange()
{
	var str = document.getElementById("pwdA");
	if(str != "")
     {
     	document.getElementById("pwd").setAttribute("class", "form-group has-success has-feedback");
	   return true;       
	 }
   else
     {
	   document.getElementById("pwd").setAttribute("class", "form-group has-error has-feedback");
	   document.getElementById("pwdIcon").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
	   return false;
     }
}
function phonenumber(inputtxt)
{
  var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
  if(inputtxt.value.match(phoneno))
     {
	   return true;       
	 }
   else
     {
	   document.getElementById("number").id = "inputError";
	   document.getElementById("phoneError").class = "glyphicon glyphicon-remove form-control-feedback";
	   return false;
     }
}
function toTitleCase(str)
{
    return str.replace(/([^\W_]+[^\s-]*) */g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
}