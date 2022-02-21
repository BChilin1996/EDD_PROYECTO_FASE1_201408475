package nodos;

import models.Impresoras;

public class NodoColaImpresoras {
	private Impresoras dato;
	private NodoColaImpresoras next;

	// Constructor
	public NodoColaImpresoras(Impresoras dato) {
		this.dato = dato;
	}

	// Metodos getter and setters
	public Impresoras getDato() {
		return dato;
	}

	public void setDato(Impresoras dato) {
		this.dato = dato;
	}

	public NodoColaImpresoras getNext() {
		return next;
	}

	public void setNext(NodoColaImpresoras next) {
		this.next = next;
	}

	// Metodo toString
	public String toString() {
		String s = " " + dato + " ";
		return s;
	}
}
