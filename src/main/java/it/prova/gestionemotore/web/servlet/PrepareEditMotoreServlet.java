package it.prova.gestionemotore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionemotore.model.Motore;
import it.prova.gestionemotore.service.MyServiceFactory;

@WebServlet("/PrepareEditMotoreServlet")
public class PrepareEditMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PrepareEditMotoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotoreParam = request.getParameter("idMotoreDaModificare");

		if (!NumberUtils.isCreatable(idMotoreParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore: id non è numerico");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			Motore motoreDaModificare = MyServiceFactory.getMotoreServiceInstance().caricaSingoloElemento(Long.parseLong(idMotoreParam));
			request.setAttribute("edit_motore_attr", motoreDaModificare);
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore: caricamento by id fallito");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/motore/edit.jsp").forward(request, response);
	}
}
