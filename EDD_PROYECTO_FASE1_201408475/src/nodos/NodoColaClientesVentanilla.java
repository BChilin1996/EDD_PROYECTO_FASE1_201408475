package nodos;

import main.PilaImagenes;
import models.ClientesVentanilla;

public class NodoColaClientesVentanilla {
	// Declaracion de atributos
		private ClientesVentanilla dato;
		private NodoColaClientesVentanilla next;
		private PilaImagenes pila;
		
		// Constructor
		public NodoColaClientesVentanilla(ClientesVentanilla dato, PilaImagenes pila) {
			this.dato = dato;
			this.pila = pila;
		}

		// Metodos getter and setters
		public ClientesVentanilla getDato() {
			return dato;
		}
		
		public void setDato(ClientesVentanilla dato) {
			this.dato = dato;
		}

		public NodoColaClientesVentanilla getNext() {
			return next;
		}

		public PilaImagenes getPila() {
			return pila;
		}
		
		public void setNext(NodoColaClientesVentanilla next) {
			this.next = next;
		}

		// Metodo toString
		public String toString() {
			String s = " " + dato.getIDCliente() + " "+ dato.getIdVentanilla() + " ";
			return s;
		}
}
