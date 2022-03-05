package it.prova.gestionemotore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionemotore.model.Motore;

/**
 * Servlet implementation class PrepareSearchMotoreServlet
 */
@WebServlet("/PrepareSearchMotoreServlet")
public class PrepareSearchMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrepareSearchMotoreServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("search_motore_attr", new Motore());
		request.getRequestDispatcher("/motore/search.jsp").forward(request, response);
	}

}
