<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Sarvika | Log Hours</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-select.css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link href="css/jquery.uls.css" rel="stylesheet" />
<link href="css/jquery.uls.grid.css" rel="stylesheet" />
<link href="css/jquery.uls.lcd.css" rel="stylesheet" />
<!-- Source -->
<script src="js/jquery.uls.data.js"></script>
<script src="js/jquery.uls.data.utils.js"></script>
<script src="js/jquery.uls.lcd.js"></script>
<script src="js/jquery.uls.languagefilter.js"></script>
<script src="js/jquery.uls.regionfilter.js"></script>
<script src="js/jquery.uls.core.js"></script>
</head>
<body>
	<jsp:include page='header.jsp' />
	<jsp:include page='message.jsp' />
	<section>
		<div id="page-wrapper" class="sign-in-wrapper">
			<div class="graphs">
				<div class="sign-up">
					<h1>Log Your Hours</h1>
					<form method="post" action="logHour">
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Select Project :</h4>
							</div>
							<select class="sign-up2 form-control" id="projectId"
								name="projectId">
								<option value="">Select Project</option>
								<c:forEach var="project" items="${projects}">
									<option value="${project.id}">${project.name}</option>
								</c:forEach>
							</select>
							<div class="clearfix"></div>
						</div>

						<div class="sign-u">
							<div class="sign-up1">
								<h4>Select Client :</h4>
							</div>
							<select class="sign-up2 form-control" id="clientId"
								name="clientId">
								<option value="">Select Client</option>
								<c:forEach var="client" items="${clients}">
									<option value="${client.id}">${client.name}</option>
								</c:forEach>
							</select>
							<div class="clearfix"></div>
						</div>

						<div class="sign-u">
							<div class="sign-up1">
								<h4>Select Task :</h4>
							</div>
							<select class="sign-up2 form-control" id="taskId" name="taskId">
								<option value="">Select Task</option>
								<c:forEach var="task" items="${tasks}">
									<option value="${task.id}">${task.name}</option>
								</c:forEach>
							</select>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Duration :</h4>
							</div>
							<div class="sign-up2">
								<input type="number" name="duration" required="required" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Task Jira Id. :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" name="ticketId" required="required" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Description :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" name="description" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sub_home">
							<div class="sub_home_left">
								<input type="submit" value="Log Hour">
							</div>
							<div class="sub_home_right">
								<p>
									Go Back to <a href="index">Home</a>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>
	<jsp:include page='footer.jsp' />
</body>
</html>