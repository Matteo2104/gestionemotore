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


@WebServlet("/PrepareDeleteMotoreServlet")
public class PrepareDeleteMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PrepareDeleteMotoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotoreParam = request.getParameter("idMotoreDaEliminare");

		if (!NumberUtils.isCreatable(idMotoreParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		try {
			Motore motoreDaEliminare = MyServiceFactory.getMotoreServiceInstance().caricaSingoloElemento(Long.parseLong(idMotoreParam));
			request.setAttribute("delete_motore_attr", motoreDaEliminare);
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/motore/delete.jsp").forward(request, response);
	}


}
