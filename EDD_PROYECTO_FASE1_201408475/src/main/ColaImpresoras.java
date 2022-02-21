package main;

import models.Impresoras;
import nodos.NodoColaImpresoras;

public class ColaImpresoras {
	private NodoColaImpresoras inicio;
	private NodoColaImpresoras termino;

	// Constructor sin parametros
	public ColaImpresoras() {
		inicio = null;
		termino = null;
	}

	// Metodo insertar
	public void insertar(Impresoras dato) {
		NodoColaImpresoras i = new NodoColaImpresoras(dato);
		i.setNext(null);
		if (inicio == null & termino == null) {
			inicio = i;
			termino = i;
		}
		termino.setNext(i);
		termino = termino.getNext();
	}

	// Metodo extraer dato
	public Impresoras extraer() {
		Impresoras dato = inicio.getDato();
		inicio = inicio.getNext();
		return dato;
	}

	// Metodo para comprobar que la cola no esta vacia
	public boolean estaVacia() {
		boolean cola = false;
		if (inicio == null & termino == null) {
			cola = true;
			System.out.println("La cola esta vacia");
		} else {
			System.out.println("La cola no esta vacia");
			cola = false;
		}
		return cola;
	}

	// Metodo para contar los elementos de la cola
	public int contar() {
		int contador = 0;
		NodoColaImpresoras c = this.inicio;
		while (c != null) {
			contador++;
			c = c.getNext();
		}
		System.out.println("Numero de datos en la cola: " + contador);
		return contador;
	}

	// Metodo toString
	public String toString() {
		NodoColaImpresoras c = this.inicio;
		String s = "";
		while (c != null) {
			s = s + c.toString();
			c = c.getNext();
		}
		return s;
	}
}
