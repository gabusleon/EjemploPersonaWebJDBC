package ec.edu.ups.modelo;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;

	public Persona() {
		// Constructor obligatorio
	} 

	public Persona(int id, String cedula, String nombre, String apellido) { 
		// Constructor opcional
		this.setId(id);
		this.setCedula(cedula);
		this.setNombre(nombre);
		this.setApellido(apellido);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}

