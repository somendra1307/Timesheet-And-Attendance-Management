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
					<form method="post" action="addAttendance">
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Date :</h4>
							</div>
							<div class="sign-up2">
								<input type="date" name="date" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Present Type :</h4>
							</div>
							<select class="sign-up2 form-control" id="attendance"
								name="attendance">
								<option value="">Select Project</option>
								<option value="PRESENT">Present</option>
								<option value="ABSENT">Absent</option>
								<option value="WORK_FROM_HOME">Work From Home</option>
								<option value="LEAVE">Leave</option>
							</select>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Punch In Time :</h4>
							</div>
							<div class="sign-up2">
								<input type="time" name="punchInTime" required="required" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Punch Out Time :</h4>
							</div>
							<div class="sign-up2">
								<input type="time" name="punchOutTime" required="required" />
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="sign-u">
							<div class="sign-up1">
								<h4>Remark :</h4>
							</div>
							<div class="sign-up2">
								<input type="text" name="remark" />
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="sub_home">
							<div class="sub_home_left">
								<input type="submit" value="Submit">
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