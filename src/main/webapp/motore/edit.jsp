<%@page import="it.prova.gestionemotore.model.Motore"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<meta charset="ISO-8859-1">
	<title>Modifica Motore</title>
</head>
<body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteEditMotoreServlet" class="row g-3" novalidate="novalidate">
							
								<% Motore motoreDaModificare = (Motore)request.getAttribute("edit_motore_attr"); %>
							
								<div class="col-md-6">
									<label for="codice" class="form-label">Codice <span class="text-danger">*</span></label>
									<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice"  
										value="<%=motoreDaModificare.getCodice()!=null?motoreDaModificare.getCodice():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="cilindrata" class="form-label">Cilindrata <span class="text-danger">*</span></label>
									<input type="number" name="cilindrata" id="cilindrata" class="form-control" placeholder="Inserire la cilindrata"  
										value="<%=motoreDaModificare.getCilindrata()!=0?motoreDaModificare.getCilindrata():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="potenza" class="form-label">Potenza <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="potenza" id="potenza" placeholder="Inserire potenza" 
									value="<%=motoreDaModificare.getPotenza()!=0?motoreDaModificare.getPotenza():"" %>" required>
								</div>

								<div class="col-md-6">
									<label for="coppia" class="form-label">Coppia <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="coppia" id="coppia" placeholder="Inserire coppia" 
									value="<%=motoreDaModificare.getCoppia()!=0?motoreDaModificare.getCoppia():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataProduzione" class="form-label">Data di Produzione<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataProduzione" id="dataProduzione" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=motoreDaModificare.getDataProduzione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(motoreDaModificare.getDataProduzione()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="idMotoreDaModificare" value="<%=motoreDaModificare.getId() %>" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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