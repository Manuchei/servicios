package TCPObjetos;

import java.io.Serializable;

public class Persona implements Serializable {

	String nombre;
	int edad;
	float nota;

	public Persona(String nombre, int edad, float nota) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nota = nota;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", nota=" + nota + "]";
	}

}
