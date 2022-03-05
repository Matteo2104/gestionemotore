package it.prova.gestionemotore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionemotore.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaMotoreServlet")
public class ExecuteVisualizzaMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExecuteVisualizzaMotoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotore = request.getParameter("idMotore");
		
		if (!NumberUtils.isCreatable(idMotore)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore");
			request.getRequestDispatcher("/motore/index.jsp").forward(request, response);
			return;
		}
		
		try {
			request.setAttribute("visualizza_motore_attr", MyServiceFactory.getMotoreServiceInstance().caricaSingoloElemento(Long.parseLong(idMotore)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/motore/show.jsp").forward(request, response);
	}

}
