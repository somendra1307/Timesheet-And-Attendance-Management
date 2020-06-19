<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Sarvika | Register</title>
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
               <h1>Create an account</h1>
               <form method="post" action="signup">
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Name :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="fullName" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Mobile No. :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="mobileNo" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Address :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="address" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Select State :</h4>
                     </div>
                     <select class="sign-up2 form-control" id="state" name="state">
                         <option value="">Select State</option>
                         <c:forEach var="state" items="${states}">
                             <option value="${state.value}">${state.value}</option>
                         </c:forEach>
                     </select>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Pin Code :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="pincode" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Employee ID :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="empId" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                   <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Date of Birth :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="date" name="birthDate" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Email Id :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="text" name="emailId" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Password :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="password" name="password" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sign-u">
                     <div class="sign-up1">
                        <h4>Confirm Password :</h4>
                     </div>
                     <div class="sign-up2">
                        <input type="password" name="cnfPassword" required="required" />
                     </div>
                     <div class="clearfix"></div>
                  </div>
                  <div class="sub_home">
                     <div class="sub_home_left">
                        <input type="submit" value="Create">
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