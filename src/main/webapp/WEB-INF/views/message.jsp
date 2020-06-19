<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${success != null}">
   <div class="alert alert-success alert-dismissible">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <strong>${title}</strong> ${success}
   </div>
</c:if>
<c:if test="${error != null}">
   <div class="alert alert-danger alert-dismissible">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <strong>${title}</strong> ${error}
   </div>
</c:if>
<c:if test="${info != null}">
   <div class="alert alert-info alert-dismissible">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <strong>${title}</strong> ${info}
   </div>
</c:if>
<c:if test="${warning != null}">
   <div class="alert alert-warning alert-dismissible">
      <button type="button" class="close" data-dismiss="alert">&times;</button>
      <strong>${title}</strong> ${warning}
   </div>
</c:if>
