<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page='header.jsp' />
<jsp:include page='message.jsp' />
<section>
	<div class="container-fluid">
		My Logged Hours:
		<div class="row content">
			
			<div class="col-sm-10">

				<div class="col-sm-12">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Date</th>
								<th>Project</th>
								<th>Client</th>
								<th>Task</th>
								<th>Ticket Id</th>
								<th>Duration</th>
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${logHours}">
								<tr>
									<td>${item.date}</td>
									<td>${item.project}</td>
									<td>${item.client}</td>
									<td>${item.task}</td>
									<td>${item.issueTrackingId}</td>
									<td>${item.duration}</td>
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
