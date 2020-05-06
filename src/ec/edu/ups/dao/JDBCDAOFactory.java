package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCPersonaDAO;
/**
 * Clase JDBCGenericDAO.
 * 
 * 
 * Esta clase implementa los métodos abstractos de la clase DAOFatcory
 * gestionando de esta manera a través de esta clase el acceso a los DAOs que
 * persistiran la información en la base de datos.
 * 
 * @author Gabriel A. León Paredes 
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 *
 * @see DAOFactory
 * @version 1.0
 * 
 */
public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getPersonaDAO().createTable();		

	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JDBCPersonaDAO();
	}	

}
