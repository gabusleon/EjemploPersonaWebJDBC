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
 * Servlet implementation class BuscarPersonaController
 */
@WebServlet("/BuscarPersonaController")
public class BuscarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;
	private Persona persona;

	public BuscarPersonaController() {
		personaDao = DAOFactory.getFactory().getPersonaDAO();
		persona = new Persona();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
			int id = Integer.valueOf(request.getParameter("id"));
			persona = personaDao.read(id);
			request.setAttribute("persona", persona);
			url = "/JSPs/buscar_persona.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
