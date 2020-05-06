package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.modelo.Persona;

/**
 * Clase JDBCPersonaDAO.
 * 
 * La clase JDBCPersonaDAO hereda los métodos y atributos de la clase abstracta
 * padre JDBCGenericDAO, así como también, implementa los métodos de la
 * interface PersonaDAO.
 * 
 * Teniendo de esta manera una clase específica que gestionara la persistencia a
 * la base de datos del modelo Persona
 * 
 * @author Gabriel A. León Paredes Doctor en Tecnologías de Información
 *         https://www.linkedin.com/in/gabrielleonp
 *
 * @see JDBCGenericDAO
 * @see PersonaDAO
 * @see Persona
 * 
 * @version 1.0
 */
public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, Integer> implements PersonaDAO {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Persona");
		conexion.update("CREATE TABLE Persona (" + "ID INT NOT NULL, " + "CEDULA VARCHAR(10), "
				+ "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255)" + ", PRIMARY KEY (ID))");
	}

	@Override
	public void create(Persona persona) {
		conexion.update("INSERT Persona VALUES (" + persona.getId() + ", '" + persona.getCedula() + "', '"
				+ persona.getNombre() + "', '" + persona.getApellido() + "')");
	}

	@Override
	public Persona read(Integer id) {
		Persona persona = null;
		ResultSet rs = conexion.query("SELECT * FROM Persona WHERE id=" + id);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombre"),
						rs.getString("apellido"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return persona;
	}

	@Override
	public void update(Persona persona) {
		conexion.update("UPDATE Persona SET cedula = '" + persona.getCedula() + "', nombre = '" + persona.getNombre()
				+ "', apellido = '" + persona.getApellido() + "' WHERE id = " + persona.getId());

	}

	@Override
	public void delete(Persona persona) {
		conexion.update("DELETE FROM Persona WHERE id = " + persona.getId());

	}

	@Override
	public List<Persona> find() {
		List<Persona> list = new ArrayList<Persona>();
		ResultSet rs = conexion.query("SELECT * FROM Persona");
		try {
			while (rs.next()) {
				list.add(new Persona(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombre"),
						rs.getString("apellido")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

}
