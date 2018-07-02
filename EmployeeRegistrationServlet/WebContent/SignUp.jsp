
<html>
<head>
<script src="jquery.min.js"></script>
<script type="text/javascript">
	function validateForm()
 	{
	 var x = document.forms["myForm"]["email"].value;
	 if (x == "") 
	{
	alert("Enter the Email ID");
	return false;
	}
	 else{
	
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(x)) {
    alert('Please provide a valid email address');
    
    return false;
    }
	}
    var y = document.forms["myForm"]["username"].value;
    if (y == "") 
	  {
        alert("Enter the UserName");
        return false;
    }
	var z = document.forms["myForm"]["password"].value;
	if(z == "")
	{
	alert("Enter the password");
	return false;
	}



	}
</script>

	<title>
		SignUp
	</title>
</head>
<body>
<header><center><img src="capgemini.png"></center></header>
		<h2><u>SignUp</u></h2>
		<form name="myForm" action="signup-successful" onsubmit="return validateForm()"  method="post">
		<input type="text" name="email" placeholder="Enter email"><br>
      	<label>Email</label>
      	<br>
      	<br>
      	<input type="text" name="user_name" placeholder="Enter username"><br>
      	<label>Username</label>
    	<br>
    	<br>	
           
      	<input type="password" name="password" placeholder="Enter password" ><br>
      	<label>Password</label>
    	<br>
    	<br>
    	<input type="text" name="mobile" placeholder="Enter Mobile no" ><br>
      	<label>Mobile</label>
      	<br>
      	<br>
		<input type="Submit"  value="SignUp"><br>
		</form>

</body>
</html>