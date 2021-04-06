<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>PW RESET</title>
	<link href='http://fonts.googleapis.com/css?family=Creepster' rel='stylesheet' type='text/css'>
	<link href='reset-pw.css' rel='stylesheet' type='text/css'/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Playfair+Display+SC:ital@1&display=swap" rel="stylesheet">
	

</head>
<body>

	<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");	//Works for HTTP 1.1
	response.setHeader("Pragma", "no-cache");	//Works for HTTP 1.0
	response.setHeader("Expires", "0");		//Works for Proxies

	if(session.getAttribute("un")==null){
		response.sendRedirect("login.jsp");
	}
	%>

<div id="topdiv">
<span style="padding-left: 20px; font-size: 1em; letter-spacing: 2px;"><a href="welcome.jsp">HOME</a></span>

<br><br><br>

<form action="ResetPW" method="post" style="color: black; 
		padding-left: 40vw; padding-top:40vh; font-weight:bold; font-size: larger;">
	    <p>
	      <label style="color: white">Username:</label>
	      <input type="text" name="un" value="${un}" readonly>
	    </p>
	    <p>
	      <label style="color: white">Enter New Password:</label>
	      <input type="password" name="pw">
	    </p>
	    <p>
	        <label><input type="submit" value="CHANGE PASSWORD"></label>
	    </p>
	  </form>

</div>

<!-- container -->
<div style="width: 100%; margin-left: auto; margin-right: auto;">

	<div id="uno-div">
		
	</div>


<div id="pagefooter">All UNO RIGHTS RESERVED</div>

</div>
</body>
</html>
