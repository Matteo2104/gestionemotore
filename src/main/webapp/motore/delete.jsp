<%@page import="it.prova.gestionemotore.model.Motore"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<meta charset="ISO-8859-1">
	<title>Elimina Motore</title>
</head>
<body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Sei sicuro di voler eliminare il seguente motore?</h5>
					    </div>
					     <% Motore motoreDaEliminare = (Motore)request.getAttribute("delete_motore_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Id</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getId() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Codice</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getCodice() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Cilindrata:</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getCilindrata() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Potenza:</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getPotenza() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Coppia:</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getCoppia() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Produzione:</dt>
							  <dd class="col-sm-9"><%=motoreDaEliminare.getDataProduzione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(motoreDaEliminare.getDataProduzione()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form method="post" action="ExecuteDeleteMotoreServlet"  novalidate="novalidate">
					        		<input type="hidden" name="idMotoreDaEliminare" value="<%=motoreDaEliminare.getId() %>">
									<button type="submit"  id="submit" class="btn btn-primary">Elimina</button>
								<a href="ListArticoliServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> No
					        </a>
							</form>
					    </div>
					    
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />

</body>
</html>