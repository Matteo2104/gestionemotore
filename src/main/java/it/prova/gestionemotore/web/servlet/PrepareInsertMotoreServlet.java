package it.prova.gestionemotore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionemotore.model.Motore;


@WebServlet("/PrepareInsertMotoreServlet")
public class PrepareInsertMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PrepareInsertMotoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_motore_attr", new Motore());
		request.getRequestDispatcher("/motore/insert.jsp").forward(request, response);
	}


}
