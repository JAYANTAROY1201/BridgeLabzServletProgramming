<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
}
</script>

<title>FORGOT PASSWORD</title>
</head>
<body>
	<header>
		<center>
			<img src="capgemini.png">
		</center>
	</header>
	<h2>
		<u>Forget Password</u>
	</h2>
	<form action="recover-password"
		onsubmit="return validateForm()" method="post">
		<label>Email</label><br> <input type="text" name="email"
			placeholder="Enter email"><br> 
		<br> <input type="Submit" value="Submit">
	</form>
</body>
</html>