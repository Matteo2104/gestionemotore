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
import it.prova.gestionemotore.utility.UtilityArticoloForm;


@WebServlet("/ExecuteSearchMotoreServlet")
public class ExecuteSearchMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExecuteSearchMotoreServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// estraggo input
		String codiceInputParam = request.getParameter("codice");
		String cilindrataInputParam = request.getParameter("cilindrata");
		String potenzaInputStringParam = request.getParameter("potenza");
		String coppiaInputStringParam = request.getParameter("coppia");
		String dataProduzioneStringParam = request.getParameter("dataProduzione");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Motore motoreInstance = UtilityArticoloForm.createMotoreFromParams(codiceInputParam, cilindrataInputParam,
				potenzaInputStringParam, coppiaInputStringParam, dataProduzioneStringParam);

		
		try {
			request.setAttribute("listaMotoriAttribute", MyServiceFactory.getMotoreServiceInstance().trovaDaEsempio(motoreInstance));
			request.setAttribute("successMessage", "Ricerca avvenuta con successo");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore: findByExample");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/motore/results.jsp").forward(request, response);
	}

}
