<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Here we import java classes and interface  -->
<%@ page import="java.util.List,com.foodstore.pojo.Food_pojo" %>


    
 <%
 	List<Food_pojo> flist =(List<Food_pojo>)session.getAttribute("flist");
 %>
 
 <jsp:include page="header.jsp"></jsp:include>
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
				
 	<table class="table table-stripped">
 		<tr>
 			<td>Food Id</td>
 			<td>Food Name</td>
 			<td>Food Price</td>
 		</tr>
 		<% for(Food_pojo food : flist){%>
 			<tr>
 				<td><%=food.getFood_Id()%></td>
 				<td><%=food.getFood_Name()%></td>
 				<td><%=food.getFood_Price()%></td>
 			
 				<core:if test="${user.user_Type == 'Admin'}">
	 				<td> <a  onclick = "return confirm('Do you want to delete  <%=food.getFood_Name()%>')" href="do.foodoperation?action=deletefood&food_Id=<%=food.getFood_Id()%>&food_Name=<%=food.getFood_Name()%>" class="btn btn-danger"><i class="fas fa-trash"></i></a></td>
	 			
	 				<td><a data-bs-toggle="modal" data-bs-target="#updatefood-<%=food.getFood_Id() %>"  class="btn btn-danger"><i class="fas fa-edit"></i></a>
					 				
	 					<!-- Button trigger modal -->
	
	
													<!-- Modal -->
							<div class="modal fade" id="updatefood-<%=food.getFood_Id() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							        		
							        		<form action="do.foodoperation" method="post">
												<input type="hidden" name="action" value="updatefood">
												<div class="mb-3">
													<label for="foodname" class="form-label">Food Id</label> <input
														type="text" class="form-control" id="foodname" name="food_id" value="<%=food.getFood_Id()%>" readonly>
												</div>
												<div class="mb-3">
													<label for="foodname" class="form-label">Food Name</label> <input
														type="text" class="form-control" id="foodname" name="food_name" value="<%=food.getFood_Name()%>">
												</div>
												<div class="mb-3">
													<label for="foodprice" class="form-label">Food Price</label> <input
														type="text" class="form-control" id="foodprice" name="food_price" value="<%=food.getFood_Price()%>">
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
														 				
 				
			
 				</td>
`				</core:if> 	
 				
 			</tr>
 		<%} %>
 		<tr>
 			<td colspan="5"><h3>Total Number of Foods are <%=flist.size()%></h3></td>
 		</tr>
 	</table>
 	
 	
 
  
 <jsp:include page="footer.jsp"></jsp:include>