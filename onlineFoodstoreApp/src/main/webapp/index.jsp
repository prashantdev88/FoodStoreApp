<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<jsp:include page="header.jsp"></jsp:include>

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
    		%><div class="alert alert-danger" role="alert">
						<%=Emsg%>
				</div>	<%	
    	}
    %>



	<jsp:include page="footer.jsp"></jsp:include>
	
