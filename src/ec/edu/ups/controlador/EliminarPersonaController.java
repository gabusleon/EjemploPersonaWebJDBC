package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.modelo.Persona;

/**
 * Servlet implementation class EliminarPersonaController
 */
@WebServlet("/EliminarPersonaController")
public class EliminarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private Persona persona;

	public EliminarPersonaController() {
		personaDao = DAOFactory.getFactory().getPersonaDAO();
		persona = new Persona();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
			persona.setId(Integer.valueOf(request.getParameter("id")));			
			personaDao.delete(persona);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
