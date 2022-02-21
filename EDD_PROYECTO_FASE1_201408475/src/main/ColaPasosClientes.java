package main;

import models.Clientes;
import models.PasosClientes;
import nodos.NodoPasosClientes;

public class ColaPasosClientes {
	// Declaración de atributos
	private NodoPasosClientes inicio;
	private NodoPasosClientes termino;

	// Constructor sin parametros
	public ColaPasosClientes() {
		inicio = null;
		termino = null;
	}

	// Metodo insertar
	public void insertar(PasosClientes dato) {
		NodoPasosClientes i = new NodoPasosClientes(dato);
		i.setNext(null);
		if (inicio == null & termino == null) {
			inicio = i;
			termino = i;
		}
		termino.setNext(i);
		termino = termino.getNext();
	}

	// Metodo extraer dato
	public PasosClientes extraer() {
		PasosClientes dato = inicio.getDato();
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
		NodoPasosClientes c = this.inicio;
		while (c != null) {
			contador++;
			c = c.getNext();
		}
		System.out.println("Numero de datos en la cola: " + contador);
		return contador;
	}

	// Metodo toString
	public String toString() {
		NodoPasosClientes c = this.inicio;
		String s = "";
		while (c != null) {
			s = s + c.toString();
			c = c.getNext();
		}
		return s;
	}
	
	public int toStringMasPasos() {
		NodoPasosClientes c = this.inicio;
		int id_cliente_mas_pasos=0;
		int id_cantidad_pasos=0;
		 id_cliente_mas_pasos=c.getDato().getIDCliente();
		 id_cantidad_pasos = c.getDato().getCantidadPasos();
		while (c != null) {
			if (c.getDato().getCantidadPasos()>id_cantidad_pasos) {
				id_cliente_mas_pasos=c.getDato().getIDCliente();
				id_cantidad_pasos=c.getDato().getCantidadPasos();
			}
			c = c.getNext();
		}
		System.out.print("El Cliente con Mas Pasos es "+ id_cliente_mas_pasos + " Con "+id_cantidad_pasos+" Pasos \n");
		return id_cliente_mas_pasos;
	}
	
	// Metodo toString
	public int SumarPaso(int id_cliente) {
		NodoPasosClientes c = this.inicio;
		int cantidad_pasos=0;
		String s = "";
		while (c != null) {
			if (c.getDato().getIDCliente()==id_cliente) {
				c.getDato().setCantidadPasos(c.getDato().getCantidadPasos()+1);
				cantidad_pasos=c.getDato().getCantidadPasos();
			}
			c = c.getNext();
		}
		return cantidad_pasos;
	}
}
