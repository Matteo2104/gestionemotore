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


@WebServlet("/ExecuteEditMotoreServlet")
public class ExecuteEditMotoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteEditMotoreServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMotoreParam = request.getParameter("idMotoreDaModificare");

		if (!NumberUtils.isCreatable(idMotoreParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
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

		
		
		
		// se la validazione non risulta ok
		if (!UtilityArticoloForm.validateMotoreBean(motoreInstance)) {
			request.setAttribute("insert_motore_attr", motoreInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/motore/insert.jsp").forward(request, response);
			return;
		}
		
		// assegno l'id
		motoreInstance.setId(Long.parseLong(idMotoreParam));
				
		try {
			MyServiceFactory.getMotoreServiceInstance().aggiorna(motoreInstance);
			
			request.setAttribute("listaMotoriAttribute", MyServiceFactory.getMotoreServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/motore/results.jsp").forward(request, response);
	}

}
