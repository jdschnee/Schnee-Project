<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>LOGIN</title>
	<link href='http://fonts.googleapis.com/css?family=Creepster' rel='stylesheet' type='text/css'>
	<link href='login.css' rel='stylesheet' type='text/css'/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Playfair+Display+SC:ital@1&display=swap" rel="stylesheet">

</head>
<body>

<div id="topdiv">
<span style="padding-left: 20px; font-size: 1em; letter-spacing: 2px;"><a href="index.html">HOME</a></span>

<br><br><br>

<form action="Login" method="post" style="padding-left: 15vw; font-size: larger;">
    <p>
      <label >Enter Username:</label>
      <input type="text" name="un" value="${un}">
    </p>
    <p>
      <label>Enter Password:</label>
      <input type="password" name="pw" value="${pw}">
    </p>
    <p>
        <label><input type="submit" value="LOGIN"></label>
    </p>
  </form>

</div>

<!-- container -->
<div style="width: 100%; margin-left: auto; margin-right: auto;">

	<div id="study-div">
		<h1 id="study">Why Study Hard When You Can StudySmart?</h1><br>
	</div>


<div id="pagefooter">All UNO RIGHTS RESERVED</div>

</div>
</body>
</html>
