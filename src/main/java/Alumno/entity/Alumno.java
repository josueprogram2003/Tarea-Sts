package Alumno.entity;

public class Alumno {

	private int idalum;
	private String nombre;
	private String telefono;
	private String direccion;

	public Alumno() {
		super();
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
	
	public Alumno(String nombre, String telefono, String direccion) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Alumno(int idalum, String nombre, String telefono, String direccion) {
		super();
		this.idalum = idalum;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getIdalum() {
		return idalum;
	}

	public void setIdalum(int idalum) {
		this.idalum = idalum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
