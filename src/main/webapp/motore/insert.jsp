<%@page import="it.prova.gestionemotore.model.Motore"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
				        <h5>Inserisci nuovo motore</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertMotoreServlet" class="row g-3" novalidate="novalidate">
							
							    <c:set var="motoreInPagina" value="${insert_motore_attr}"/>
							
								<div class="col-md-6">
									<label for="codice" class="form-label">Codice <span class="text-danger">*</span></label>
									<c:choose>
										<c:when test="${motoreInPagina.codice!=null}">
											<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice"  value="${motoreInPagina.codice}" required>
  										</c:when>
										<c:otherwise>
											<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice"  value="" required>
  										</c:otherwise>
									</c:choose>
								</div>
								
								<div class="col-md-6">
									<label for="cilindrata" class="form-label">Cilindrata <span class="text-danger">*</span></label>
									<c:choose>
										<c:when test="${motoreInPagina.cilindrata!=0}">
											<input type="text" name="cilindrata" id="cilindrata" class="form-control" placeholder="Inserire la cilindrata"  value="${motoreInPagina.cilindrata}" required>
  										</c:when>
										<c:otherwise>
											<input type="text" name="cilindrata" id="cilindrata" class="form-control" placeholder="Inserire la cilindrata"  value="" required>
  										</c:otherwise>
									</c:choose>
								</div>
							
								<div class="col-md-6">
									<label for="potenza" class="form-label">Potenza <span class="text-danger">*</span></label>
									<c:choose>
										<c:when test="${motoreInPagina.potenza!=0}">
											<input type="text" name="potenza" id="potenza" class="form-control" placeholder="Inserire la potenza"  value="${motoreInPagina.potenza}" required>
  										</c:when>
										<c:otherwise>
											<input type="text" name="potenza" id="potenza" class="form-control" placeholder="Inserire la potenza"  value="" required>
  										</c:otherwise>
									</c:choose>
								</div>

								<div class="col-md-6">
									<label for="coppia" class="form-label">Coppia <span class="text-danger">*</span></label>
									<c:choose>
										<c:when test="${motoreInPagina.coppia!=0}">
											<input type="text" name="coppia" id="coppia" class="form-control" placeholder="Inserire la coppia"  value="${motoreInPagina.coppia}" required>
  										</c:when>
										<c:otherwise>
											<input type="text" name="coppia" id="coppia" class="form-control" placeholder="Inserire la coppia"  value="" required>
  										</c:otherwise>
									</c:choose>
								</div>
								
								<div class="col-md-3">
									<label for="dataProduzione" class="form-label">Data di Produzione<span class="text-danger">*</span></label>
									<c:choose>
										<c:when test="${motoreInPagina.dataProduzione!=null}">
											<fmt:formatDate value="${motoreInPagina.dataProduzione}" type="date" pattern="yyyy-MM-dd" var="theFormattedDate" />
											<input class="form-control"  name="dataProduzione" id="dataProduzione" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" value="${theFormattedDate}" required/>
										</c:when>
										<c:otherwise>
											<input class="form-control"  name="dataProduzione" id="dataProduzione" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" value="" required/>  										
										</c:otherwise>
									</c:choose>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
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