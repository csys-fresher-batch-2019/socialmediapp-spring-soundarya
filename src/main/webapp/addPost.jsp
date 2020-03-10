<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header2.html" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Posts</title>
</head>
<body align="center">
<b>
<font face="Comic Sans MS">
<h3>Add Posts</h3><br>

<%String n=(String)session.getAttribute("semail"); 
 %>
<form action="AddPostServlet" method="post">
<input type="email"  name="requestor" value=<%out.print(n);
%> hidden>
<table align="center">
<tr><td><b>Upload media:</b></td><td><input type="file" name="postType"/></td></tr>
<tr><td><b>Enter the caption:</b></td><td><input type="text" name="caption"/></td></tr>
<tr><td><b>Select the viewability mode:</b></td><td>
<select id="viewability" name="viewability">
    <option value="public">Public</option>
    <option value="friends">Friends</option>
  </select></td></tr>
  </table><br><br>
<button onclick="myFunction()">Add Post</button>

<script>
function myFunction() {
  alert("post added");
}
</script>

</form>
</font></b>
</body>
</html>