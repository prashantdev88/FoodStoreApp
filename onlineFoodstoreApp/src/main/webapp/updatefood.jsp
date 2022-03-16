<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

   

<div class="container">
		<div class='row'>
			<div class='col'>
				<h2>Update Food Here</h2>
			</div>
		</div>
		<div class="row">
			<div class='col'>
				<h1>add any Image</h1>
			</div>
			<div class='col'>
				<form action="do.foodoperation" method="post">
					<input type="hidden" name="action" value="updatefood">
					
					<div class="mb-3">
						<label for="foodid" class="form-label">Food ID to Update</label> <input
							type="text" class="form-control" id="foodid" name="foodid">
					</div>
					<div class="mb-3">
						<label for="foodname" class="form-label">Food Name</label> <input
							type="text" class="form-control" id="foodname" name="foodname">
					</div>
					<div class="mb-3">
						<label for="foodprice" class="form-label">Food Price</label> <input
							type="text" class="form-control" id="foodprice" name="foodprice">
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
	
