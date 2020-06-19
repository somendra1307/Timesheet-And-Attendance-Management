<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page='header.jsp' />
<jsp:include page='message.jsp' />
<section>
	<div class="container-fluid">
		Client List:
		<div class="row content">

			<div class="col-sm-10">

				<div class="col-sm-12">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Code</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${clients}">
								<tr>
									<td>${item.id}</td>
									<td>${item.code}</td>
									<td>${item.name}</td>
									<td>${item.description}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>Advertisement Section1</p>
				</div>
				<div class="well">
					<p>Advertisement Section2</p>
				</div>
				<div class="well">
					<p>Advertisement Section3</p>
				</div>
				<div class="well">
					<p>Advertisement Section4</p>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page='footer.jsp' />
