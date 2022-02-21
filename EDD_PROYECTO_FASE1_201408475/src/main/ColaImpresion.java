package main;

import models.ColaImpresiones;
import nodos.NodoColaImpresion;

public class ColaImpresion {
	private NodoColaImpresion inicio;
	private NodoColaImpresion termino;

	// Constructor sin parametros
	public ColaImpresion() {
		inicio = null;
		termino = null;
	}

	// Metodo insertar
	public void insertar(ColaImpresiones dato) {
		NodoColaImpresion i = new NodoColaImpresion(dato);
		i.setNext(null);
		if (inicio == null & termino == null) {
			inicio = i;
			termino = i;
		}
		termino.setNext(i);
		termino = termino.getNext();
	}

	// Metodo extraer dato
	public ColaImpresiones extraer() {
		int contar = contar();
		 if (contar>0) {
			 ColaImpresiones dato = inicio.getDato();
			 inicio = inicio.getNext();
			return dato;
		 }
		return null;

	}

	ColaImpresiones extraers()
    {
        if (!estaVacia ())
        {
        	ColaImpresiones informacion = inicio.getDato();
            if (inicio == termino){
            	inicio = null;
            	termino = null;

            } else {
            	inicio = inicio.getNext();
            }
            return informacion;

        } else
            return null;
    }

	public ColaImpresiones obtener_primero() {
			ColaImpresiones dato = inicio.getDato();
			return dato;
	
	}
	
	public int obtener_primero_id_cliente() {
		ColaImpresiones dato = inicio.getDato();
		return dato.getIDCliente();

	}
	
	public int contar_pendientes(int id_cliente) {
		int contador = 0;
		NodoColaImpresion c = this.inicio;
		while (c != null) {
			if (c.getDato().getIDCliente()==id_cliente) {
				contador++;
			}
			c = c.getNext();
		}
		return contador;

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
		NodoColaImpresion c = this.inicio;
		while (c != null) {
			contador++;
			c = c.getNext();
		}
		
		return contador;
	}

	// Metodo toString
	public String toString(String impresora) {
		NodoColaImpresion c = this.inicio;
		String str_ = "";
		while (c != null) {
			str_ = str_ +"\"node_"+c.getDato().getIDCliente()+"_"+c.getDato().getIDImpresion()+"_"+impresora+"\""+ "[" +"label = \" Impresión "+c.getDato().getIDImpresion() + " Cliente "+c.getDato().getIDCliente()+"\"\r\n"
					+ "shape = \"record\"\r\n"
					+ "];"+"\n";
			c = c.getNext();
		}
		return str_;
	}
	
	public String unir_nodos_cola(String impresora, String Nodo_Impresora) {
		if (this.inicio!=null) {
			NodoColaImpresion c = this.inicio;
			String str_ = "";
				str_ = str_ +"\""+Nodo_Impresora+"\""+"-> "+"\"node_"+c.getDato().getIDCliente()+"_"+c.getDato().getIDImpresion()+"_"+impresora+"\""+"\n";
				while (c.getNext() != null) {
					str_ = str_ +"\"node_"+c.getDato().getIDCliente()+"_"+c.getDato().getIDImpresion()+"_"+impresora+"\""+"-> "+"\"node_"+c.getNext().getDato().getIDCliente()+"_"+c.getNext().getDato().getIDImpresion()+"_"+impresora+"\""+"\n";
					c = c.getNext();
				}
		
			return str_;
		}else {
			return "";
		}
		
	}
	
	public String toStrings() {
		NodoColaImpresion c = this.inicio;
		String s = "";
		while (c != null) {
			s = s + c.toString();
			c = c.getNext();
		}
		return s;
	}
}
