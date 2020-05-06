package ec.edu.ups.dao;

import ec.edu.ups.modelo.Persona;

/**
 * Interface CategoryDAO.
 * 
 * La interface CategoryDAO ha sido creada como interface específica para la
 * persistencia de objetos de tipo Persona en la base de datos. Dicha interface
 * hereda de la clase GenericDAO y será imlementada en una clase específica que
 * controlará la conexión a la base de datos de un sistema que permite
 * ejemplificar el uso del patrón de diseño DAO.
 * 
 * Además, en esta interface se pueden agregar método específicos para el manejo
 * del objeto Persona, por ejemplo: buscarPersonaPorName,
 * buscarPersonaPorLastName, entre otras.
 * 
 * @author Gabriel A. León Paredes.
 * Doctor en Tecnologías de Información
 * https://www.linkedin.com/in/gabrielleonp
 * 
 * @see GenericDAO
 * @see Persona
 * @version 1.0
 *
 */
public interface PersonaDAO extends GenericDAO<Persona, Integer> {

}
