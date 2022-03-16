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
					<input type="hidden" name="action" value="adduser">
					<div class="mb-3">
						<label for="user_Name_First" class="form-label">First Name</label> <input
							type="text" class="form-control" id="user_Name_First" name="user_Name_First">
					</div>
					<div class="mb-3">
						<label for="user_Name_Last" class="form-label">Last Name</label> <input
							type="text" class="form-control" id="user_Name_Last" name="user_Name_Last">
					</div>
					<div class="mb-3">
						<label for="user_Type" class="form-label">User Type</label><br> 
						<input type="radio"  id="user_Type" name="user_Type" value="Admin"> 	<label for="user_Type" class="form-label">Admin</label>
							<input type="radio"  id="user_Type" name="user_Type" value="Customer"> <label for="user_Type" class="form-label">Customer</label>
					</div>
					<div class="mb-3">
						<label for="user_Email" class="form-label">Email Address</label> <input
							type="text" class="form-control" id="user_Email" name="user_Email">
					</div>
					<div class="mb-3">
						<label for="user_Password" class="form-label">Password</label> <input
							type="text" class="form-control" id="user_Password" name="user_Password">
					</div>
					<div class="mb-3">
						<label for="user_Address" class="form-label">Address</label> <input
							type="text" class="form-control" id="user_Address" name="user_Address">
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