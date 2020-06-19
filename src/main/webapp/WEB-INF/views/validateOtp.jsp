<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='header.jsp' />
<jsp:include page='message.jsp' />
<div class="submit-ad main-grid-border">
	<div class="container">
		<h2 class="head">Email OTP Verification:</h2>
		<div class="post-ad-form">
			<form id="validateOtp" method="get" action="validateOtp">

				<div class="clearfix"></div>
				<label>Enter OTP received on emailId </label> 
				<input type="text" class="phone" placeholder="" name="otp" id="otp" /> 
				<input type="submit" value="Validate">
				<div class="clearfix"></div>
			</form>
		</div>
	</div>
</div>
<jsp:include page='footer.jsp' />