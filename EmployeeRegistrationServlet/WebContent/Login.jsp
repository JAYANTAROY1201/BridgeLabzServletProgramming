
<html>
<head>
<script src="jquery.min.js"></script>
<script type="text/javascript">
	function validateForm()
 	{
    var x = document.forms["myForm"]["email"].value;
    if (x == "") 
	  {
        alert("Enter the email");
        return false;
    }
	var y = document.forms["myForm"]["password"].value;
	if(y == "")
	{
	alert("Enter the password");
	return false;
	}
}
</script>

<title>LOGIN PAGE</title>
</head>
<body>
	<header>
		<center>
			<img src="capgemini.png">
		</center>
	</header>
	<h2>
		<u>Login</u>
	</h2>
	<form name="myForm" action="loginsuccessfull"
		onsubmit="return validateForm()" method="post">
		<label>Email</label><br> <input type="text" name="email"
			placeholder="Enter email"><br> <br> <label>Password</label><br>
		<input type="password" name="password" placeholder="Enter password"><br>
		<br> <input type="Submit" value="Login"> <a
			href="forgetpass.html">Forgot Password?</a>
	</form>
</body>
</html>