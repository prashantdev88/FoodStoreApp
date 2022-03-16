<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<!-- include JSTL Core Tag Library in Current JSP page. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<!-- It jsp action tag -->
<div class="container">
    <%
	    	String Smsg = (String)request.getAttribute("Smsg");
			if(Smsg!=null){
				%><div class="alert alert-success" role="alert">
						<%=Smsg%>
				</div>	<%	
	
			}

    %>
    <%
    	String Emsg = (String)request.getAttribute("Emsg");
    	if(Emsg!=null){
    		%><div class="alert alert-success" role="alert">
						<%=Emsg%>
				</div>	<%	
    	}

    %>
	
	
	<div class="row">
		
		<core:forEach var="user" items="${ulist}">
			<div class=" col-12 col-md-6 col-lg-4 col-xl-3 my-3"> 
				<div class="card">
					<img src="img\img-256x256.png" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">NAME: ${user.first_Name}  ${user.last_Name}</h5> 
						<p class="card-text">TYPE: ${user.type}</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">ID: ${user.user_Id}</li>
						<li class="list-group-item">EMAIL: ${user.user_Email}</li>
						<li class="list-group-item">PASSWORD: ${user.user_Password}</li>
						<li class="list-group-item">ADDRESS: ${user.user_Address}</li>
					</ul>
					<div class="card-body">
						
							<a  onclick = "return confirm('Do you want to delete  ${user.first_Name}')" href="do.foodoperation?action=deleteuser&User_Id=${user.user_Id}&First_Name=${user.first_Name}" class="btn btn-danger"><i class="fas fa-trash"></i></a> 
							<!-- for Edit -->
							<a data-bs-toggle="modal" data-bs-target="#updateuser-${user.user_Id}"  class="btn btn-danger"><i class="fas fa-edit"></i></a>
 						
	 					<!-- Button trigger modal -->
	
	
													<!-- Modal -->
							<div class="modal fade" id="updateuser-${user.user_Id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        		
							        		<form action="do.foodoperation" method="post">
												<input type="hidden" name="action" value="updateuser">
												<div class="mb-3">
													<label for="User_Id" class="form-label">User Id</label> <input
														type="text" class="form-control" id="User_Id" name="User_Id" value="${user.user_Id}" readonly>
												</div>
												<div class="mb-3">
													<label for="firstname" class="form-label">First Name</label> <input
														type="text" class="form-control" id="firstname" name="First_Name" value="${user.first_Name}">
												</div>
												<div class="mb-3">
													<label for="lastname" class="form-label">Last Name</label> <input
														type="text" class="form-control" id="lastname" name="Last_Name" value="${user.last_Name}">
												</div>
												<div class="mb-3">
													<label for="user_Type" class="form-label">User Type</label><br> 
													<input type="radio"  id="Type" name="Type" value="Admin"> 	<label for="Type" class="form-label">Admin</label>
														<input type="radio"  id="Type" name="Type" value="Customer"> <label for="Type" class="form-label">Customer</label>
												</div>
												<div class="mb-3">
													<label for="user_Email" class="form-label">Email Address</label> <input                                  
														type="text" class="form-control" id="user_Email" name="User_Email" value="${user.user_Email}">
												</div>
												<div class="mb-3">
													<label for="user_Password" class="form-label">Password</label> <input
														type="text" class="form-control" id="user_Password" name="User_Password"  value="${user.user_Password}">
												</div>
												<div class="mb-3">
													<label for="user_Address" class="form-label">Address</label> <input
														type="text" class="form-control" id="user_Address" name="User_Address"  value="${user.user_Address}">
												</div>
																						
				
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
							        <button type="submit" class="btn btn-primary">Save changes</button>
							      </div>
							    </div>
							    </form>
							    
							  </div>
							</div>
							 				
 				
 				
						
					</div>
				</div>
			</div>
		</core:forEach>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>