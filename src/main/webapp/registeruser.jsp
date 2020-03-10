<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<%@ include file="header.html" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<center><h2><font color="black" face="Comic Sans MS">REGISTRATION </font></h2></center>
<body >

<form action="RegisterUserServlet" method="post">
<div class="container">
<br/>
 <br/>
 <style>
.container {
  margin: auto;
  width: 60%;
  border: 3px solid #000066;
  padding: 10px;
  font-family: cursive;
}
text {
  color: black;
}</style>
<img src="images/social.jpg" align="right"alt="login image" height=90% width=50%/>
<text >
<div class="form-group">
<b>Enter the User Name:</b><input type="text" name="username"  pattern="^[0-9a-zA-Z]+$" required />
<br/>
<br/>
<b>Enter the User Email:</b><input type="email" name="useremail"   pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required />
<br/>
<br/>
<b>Enter the Age:</b><input type="text" name="age" maxlength="2"  pattern="[0-9]{2}" required/>
</br>
</br>
<b>Enter the Gender:</b><br/>
  <input type="radio" name="gender" value="male" > Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other
<br/>
<br/>

<b>Enter the DOB:</b><input type="date" name="dob"  id="dob" required/>
<br/>
<br/>
<b>Enter the City:</b><input type="text" name="city" required/>
<br/>
<br/>
<b>Enter the Country:</b><input type="text" name="country" required/>
<br/>
<br/>
<b>Enter the Status you want:</b><input type="text" name="status" required/>
<br/>
<br/>
<b>Enter the Password:</b><input type="password" name="password" required/>
<br/>
<br/>
<b>Upload  Profile picture:</b><input type="file" name="profilepic" required/>
<br/>
<br/></div>
</text>
<center>
<input class="btn btn-primary" type="submit" value="Create User"></center>
<br/>
<center><input class="btn btn-primary" type="reset" value="Reset" /></center>



</div>
<script>
    var dtToday = new Date();

    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();

    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();

    var maxDate = year + '-' + month + '-' + day;    
    document.getElementById('dob').setAttribute('max', maxDate);
</script>
</form>
</body>
</html>


