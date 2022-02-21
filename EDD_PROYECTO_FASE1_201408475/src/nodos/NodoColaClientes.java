package nodos;

import main.PilaImagenes;
import models.Clientes;

public class NodoColaClientes {
	// Declaracion de atributos
	private Clientes dato;
	private NodoColaClientes next;
	// Constructor
	public NodoColaClientes(Clientes dato) {
		this.dato = dato;
	}

	// Metodos getter and setters
	public Clientes getDato() {
		return dato;
	}


	public void setDato(Clientes dato) {
		this.dato = dato;
	}

	public NodoColaClientes getNext() {
		return next;
	}

	public void setNext(NodoColaClientes next) {
		this.next = next;
	}

	// Metodo toString
	public String toString() {
		String s = " " + dato.getIDCliente() + " "+ dato.getNombreCliente() + " "+ dato.getImgBw() + " "+ dato.getImgColor() + " ";
		return s;
	}
}
