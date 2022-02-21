package nodos;

import models.PasosClientes;

public class NodoPasosClientes {
	// Declaracion de atributos
	private PasosClientes dato;
	private NodoPasosClientes next;

	// Constructor
	public NodoPasosClientes(PasosClientes dato) {
		this.dato = dato;
	}

	// Metodos getter and setters
	public PasosClientes getDato() {
		return dato;
	}

	public void setDato(PasosClientes dato) {
		this.dato = dato;
	}

	public NodoPasosClientes getNext() {
		return next;
	}

	public void setNext(NodoPasosClientes next) {
		this.next = next;
	}

	// Metodo toString
	public String toString() {
		String s = "ID Cliente: " + dato.getIDCliente() + " Pasos en el Sistema "+ dato.getCantidadPasos() + "\n";
		return s;
	}
}