<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Sarvika | Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link rel="stylesheet" href="css/agritech.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/font-awesome.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
<script src="js/agritech.js"></script>
<script src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" />
<link href="css/jquery.uls.css" rel="stylesheet" />
<link href="css/jquery.uls.grid.css" rel="stylesheet" />
<link href="css/jquery.uls.lcd.css" rel="stylesheet" />
<script src="js/jquery.uls.data.js"></script>
<script src="js/jquery.uls.data.utils.js"></script>
<script src="js/jquery.uls.lcd.js"></script>
<script src="js/jquery.uls.languagefilter.js"></script>
<script src="js/jquery.uls.regionfilter.js"></script>
<script src="js/jquery.uls.core.js"></script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="index"><span>Sarvika</span>Tech</a>
			</div>
			<div class="header-right">
				<% if (session.getAttribute("user") != null && session.getAttribute("roleCode").equals("2"))  { %>
				<a class="account" href="myProfile">My Profile</a> <a
					class="account" href="logMyHour">Log My Hours</a> <a
					class="account" href="addAttendance">Log My Attendance</a> <a
					class="account" href="myTimesheet">My Timesheet</a> <a
					class="account" href="myAttendance">My Attendance</a> <a
					class="account" href="logout">Log out</a>
				<% } %>


				<% if (session.getAttribute("user") != null && session.getAttribute("roleCode").equals("1")) { %>
				<a class="account" href="myProfile">My Profile</a> <a
					class="account" href="addProject">Add Project</a> <a
					class="account" href="addClient">Add Client</a> <a class="account"
					href="addTask">Add Task</a> <a
					class="account" href="generateReport">Generate Report</a><a class="account" href="logout">Log
					out</a>

				<% } %>


				<% if (session.getAttribute("user") == null) { %>
				<a class="account" href="login">Log in</a>
				<% } %>

			</div>
		</div>
	</div>