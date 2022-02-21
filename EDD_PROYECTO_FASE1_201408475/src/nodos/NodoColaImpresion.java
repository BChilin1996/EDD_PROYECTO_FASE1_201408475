package nodos;

import models.ColaImpresiones;

public class NodoColaImpresion {
	// Declaracion de atributos
	private ColaImpresiones dato;
	private NodoColaImpresion next;

	// Constructor
	public NodoColaImpresion(ColaImpresiones dato) {
		this.dato = dato;
	}

	// Metodos getter and setters
	public ColaImpresiones getDato() {
		return dato;
	}

	public void setDato(ColaImpresiones dato) {
		this.dato = dato;
	}

	public NodoColaImpresion getNext() {
		return next;
	}

	public void setNext(NodoColaImpresion next) {
		this.next = next;
	}

	// Metodo toString
	public String toString() {
		String s = " " + dato + " ";
		return s;
	}
}
