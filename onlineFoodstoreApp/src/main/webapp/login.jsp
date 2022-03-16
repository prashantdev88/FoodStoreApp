<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container">
	
		<div class='row'>
			<div class='col'>
				<h2>Add New Food Here</h2>
			</div>
		</div>
		<div class="row">
			<div class='col'>
				<h1>add any Image</h1>
			</div>
			<div class='col'>
				<form action="do.foodoperation" method="post">
					<input type="hidden" name="action" value="userlogin">
					<div class="mb-3">
						<label for="user_Email" class="form-label">Email Address</label> <input
							type="text" class="form-control" id="User_Email" name="User_Email">
					</div>
					<div class="mb-3">
						<label for="user_Password" class="form-label">Password</label> <input
							type="text" class="form-control" id="User_Password" name="User_Password">
					</div>
					

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				
				<%
					String Smsg = (String) request.getAttribute("Smsg");
					
						
					if(Smsg!=null){
						%>
						<div class="alert alert-success" role="alert">
  						<%=Smsg%>
						</div>	<%	
					}
					
				%>
				<%
					String Emsg = (String) request.getAttribute("Emsg");
					
					if(Emsg!=null){
						%>
							<div class="alert alert-error" role="alert">
  							<%=Emsg%>
							</div>	<%				
					}
					
				%>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>