<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page='header.jsp' />
<jsp:include page='message.jsp' />
<section>
   <div id="page-wrapper" class="sign-in-wrapper">
      <div class="graphs">
         <div class="sign-in-form">
            <div class="sign-in-form-top">
               <h1>Log in</h1>
            </div>
            <div class="signin">
               <form method="POST" action="authenticate">
                  <div class="log-input">
                     <div class="log-input-left">
                        <input type="text" class="user" value="User Id" name="username" />
                     </div>
                  </div>
                  <div class="log-input">
                     <div class="log-input-left">
                        <input type="password" class="lock" value="password" name="password" />
                     </div>
                  </div>
                  <input type="submit" value="Log in">
               </form>
            </div>
            <div class="new_people">
               <a href="register">Register Now</a>
            </div>
         </div>
      </div>
   </div>
</section>
<jsp:include page='footer.jsp' />