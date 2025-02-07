<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>WELCOME</title>
	<link href='welcome.css' rel='stylesheet' type='text/css'/>
	<link href='http://fonts.googleapis.com/css?family=Creepster' rel='stylesheet' type='text/css'>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
		<span style="padding-left: 20px; font-size: 1em; letter-spacing: 2px;"><a href="#">HOME</a></span>
		<span style="float: right; padding-right: 20px;"><a href="student-form.xhtml">Study Decks</a> | <a href="reset-pw.jsp">Change
				Password</a> | <a href="Logout">Log Out | <a href="Download.xhtml">Download</a></span>
	</div>



	<!-- container -->
	<div style="width: 100%; margin-left: auto; margin-right: auto;">

		<div id="heading-text">
			<h2>Welcome Back ${un}</h2>
			<p style="font-weight: bold">We Missed You!</p>
		</div>


		<div id="bottomcontainer">

			<div id="leftside">
				<h2>WHAT IS ACTIVE RECALL?</h2>
				<p>Active recall occurs when you continuously stimulate your memory to retain
				a piece of memory. When you try and remember an answer to a question, you are 
				using active recall.</p>
				<p>Active recall will help you to learn efficiently and effectively. Instead of
				somewhat knowing the answer active recall will help to ensure that you know the 
				answer. </p>

			</div>

			<div id="rightside">
				<h2>WHY USE STUDYSMART?</h2>
				<p>StudySmart utilizes what helps learners the most, active recall.</p>
				<p>By using active recall we allow our users to study in the most efficient
				way possible, we allow our users to StudySmart. By utilizing our service our
				users will be able to ace any test and pass classes with flying colors.</p>
				<p>StudySmart is the best way to study and prepare for classes.</p>
			</div>

		</div>


		<!-- not sure if I will teach this.-->

		<div id="css-table">

			<div style="display: table-cell; vertical-align: top; text-align: left; width: 33%; padding: 10px;">
				<p>New-school two column - dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
				<ol>
					<li>Book Store</li>
					<li>Online Tutoring</li>
					<li>Scholarships</li>
					<li>Internships</li>
					<li>Financial Aid</li>
				</ol>
			</div>

			<div style="display: table-cell; vertical-align: top; text-align: left; padding: 10px;">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>

			<div style="display: table-cell; vertical-align: top; text-align: left; padding: 10px;">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
					cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
					proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
			</div>


		</div>

		<div id="video">
			<iframe width="80%" height="315" src="https://www.youtube.com/embed/5qap5aO4i9A" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope;
	 picture-in-picture" allowfullscreen>
			</iframe>
			<h3 style="margin-top: 25px;">STUDY SMARTER NOT HARDER</h3>
		</div>


		<div id="pagefooter">All STUDYSMART FLASH CARDS RIGHTS RESERVED</div>

	</div>
	<c:set var="un" value="${un}" scope="session" />
</body>

</html>