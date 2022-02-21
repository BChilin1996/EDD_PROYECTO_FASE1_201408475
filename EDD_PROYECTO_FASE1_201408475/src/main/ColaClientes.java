package main;

import models.Clientes;
import nodos.NodoColaClientes;
import nodos.NodoColaClientesVentanilla;

public class ColaClientes {

	private NodoColaClientes inicio;
	private NodoColaClientes termino;

	// Constructor sin parametros
	public ColaClientes() {
		inicio = null;
		termino = null;
	}

	// Metodo insertar
	public void insertar(Clientes dato) {
		NodoColaClientes i = new NodoColaClientes(dato);
		i.setNext(null);
		if (inicio == null & termino == null) {
			inicio = i;
			termino = i;
		}
		termino.setNext(i);
		termino = termino.getNext();
	}
	
	
	public String ordenar_clientes_color() {
		NodoColaClientes c = this.inicio;
		int max_1=0;
		int max_2=0;
		int max_3=0;
		int max_4=0;
		int max_5=0;
		int id_max_1=0;
		int id_max_2=0;
		int id_max_3=0;
		int id_max_4=0;
		int id_max_5=0;
		String nombre_cliente_1 = "";
		String nombre_cliente_2 = "";
		String nombre_cliente_3 = "";
		String nombre_cliente_4 = "";
		String nombre_cliente_5 = "";
		
		while (c.getNext() != null) {
			
			if (c.getDato().getImgBw()>=max_1) {
				max_1 = c.getDato().getImgBw();
				id_max_1=c.getDato().getIDCliente();
				nombre_cliente_1=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgColor()>=max_2 && c.getDato().getImgColor()<=max_1 && id_max_1!=c.getDato().getIDCliente()) {
				max_2 = c.getDato().getImgColor();
				id_max_2=c.getDato().getIDCliente();
				nombre_cliente_2=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgColor()>=max_3 && c.getDato().getImgColor()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_2 && id_max_2!=c.getDato().getIDCliente()) {
				max_3 = c.getDato().getImgColor();
				id_max_3=c.getDato().getIDCliente();
				nombre_cliente_3=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgColor()>=max_4 && c.getDato().getImgColor()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_2 && id_max_2!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_3 && id_max_3!=c.getDato().getIDCliente()) {
				max_4 = c.getDato().getImgColor();
				id_max_4=c.getDato().getIDCliente();
				nombre_cliente_4=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgColor()>=max_5 && c.getDato().getImgColor()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_2 && id_max_2!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_3 && id_max_3!=c.getDato().getIDCliente()
					&& c.getDato().getImgColor()<=max_4 && id_max_4!=c.getDato().getIDCliente()) {
				max_5 = c.getDato().getImgColor();
				id_max_5=c.getDato().getIDCliente();
				nombre_cliente_5=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		System.out.println("El Cliente con mas Impresiones a Color es : " + nombre_cliente_1 + " Con: "+max_1);
		System.out.println("El Segundo Cliente con mas Impresiones a Color es : " + nombre_cliente_2 + " Con: "+max_2);
		System.out.println("El Tercero Cliente con mas Impresiones a Color es : " + nombre_cliente_3 + " Con: "+max_3);
		System.out.println("El Cuarto Cliente con mas Impresiones a Color es : " + nombre_cliente_4 + " Con: "+max_4);
		System.out.println("El Quinto Cliente con mas Impresiones a Colores : " + nombre_cliente_5 + " Con: "+max_5);
		return "";
	}
	
	public String ordenar_clientes_blanco_negro() {
		NodoColaClientes c = this.inicio;
		int max_1=0;
		int max_2=0;
		int max_3=0;
		int max_4=0;
		int max_5=0;
		int id_max_1=0;
		int id_max_2=0;
		int id_max_3=0;
		int id_max_4=0;
		int id_max_5=0;
		String nombre_cliente_1 = "";
		String nombre_cliente_2 = "";
		String nombre_cliente_3 = "";
		String nombre_cliente_4 = "";
		String nombre_cliente_5 = "";
		
		while (c.getNext() != null) {
			
			if (c.getDato().getImgBw()>=max_1) {
				max_1 = c.getDato().getImgBw();
				id_max_1=c.getDato().getIDCliente();
				nombre_cliente_1=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgBw()>=max_2 && c.getDato().getImgBw()<=max_1 && id_max_1!=c.getDato().getIDCliente()) {
				max_2 = c.getDato().getImgBw();
				id_max_2=c.getDato().getIDCliente();
				nombre_cliente_2=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgBw()>=max_3 && c.getDato().getImgBw()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_2 && id_max_2!=c.getDato().getIDCliente()) {
				max_3 = c.getDato().getImgBw();
				id_max_3=c.getDato().getIDCliente();
				nombre_cliente_3=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgBw()>=max_4 && c.getDato().getImgBw()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_2 && id_max_2!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_3 && id_max_3!=c.getDato().getIDCliente()) {
				max_4 = c.getDato().getImgBw();
				id_max_4=c.getDato().getIDCliente();
				nombre_cliente_4=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		c = this.inicio;
		
		while (c.getNext() != null) {
			if (c.getDato().getImgBw()>=max_5 && c.getDato().getImgBw()<=max_1 && id_max_1!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_2 && id_max_2!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_3 && id_max_3!=c.getDato().getIDCliente()
					&& c.getDato().getImgBw()<=max_4 && id_max_4!=c.getDato().getIDCliente()) {
				max_5 = c.getDato().getImgBw();
				id_max_5=c.getDato().getIDCliente();
				nombre_cliente_5=c.getDato().getNombreCliente();
			}
			c = c.getNext();
		}
		
		System.out.println("El Cliente con mas Impresiones Blanco y Negro es : " + nombre_cliente_1 + " Con: "+max_1);
		System.out.println("El Segundo Cliente con mas Impresiones Blanco y Negro es : " + nombre_cliente_2 + " Con: "+max_2);
		System.out.println("El Tercero Cliente con mas Impresiones Blanco y Negro es : " + nombre_cliente_3 + " Con: "+max_3);
		System.out.println("El Cuarto Cliente con mas Impresiones Blanco y Negro es : " + nombre_cliente_4 + " Con: "+max_4);
		System.out.println("El Quinto Cliente con mas Impresiones Blanco y Negro es : " + nombre_cliente_5 + " Con: "+max_5);
		return "";
	}
	

	// Metodo extraer dato
	public Clientes extraer() {
		Clientes dato = inicio.getDato();
		inicio = inicio.getNext();
		return dato;
	}

	public Clientes obtenerPrimero() {
		if (inicio == null & termino == null) {
			return null;
		} else {
			Clientes dato = inicio.getDato();
			return dato;
		}
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
		NodoColaClientes c = this.inicio;
		while (c != null) {
			contador++;
			c = c.getNext();
		}
		System.out.println("Numero de datos en la cola: " + contador);
		return contador;
	}

	
	public String buscar_cliente(int id_cliente) {
		String str_ ="";
		NodoColaClientes c = this.inicio;
		while (c != null) {
			if (c.getDato().getIDCliente()==id_cliente) {
				System.out.println("ID Cliente: " + c.getDato().getIDCliente());
				System.out.println("Nombre Cliente: " + c.getDato().getNombreCliente());
				System.out.println("Imagenes a Color Iniciales: " + c.getDato().getImgColor());
				System.out.println("Imagenes a Blanco y Negro Iniciales: " + c.getDato().getImgBw());
				System.out.println("Imagenes a Pendientes de Imprimir a Color: " + c.getDato().getImgColor_());
				System.out.println("Imagenes a Pendientes de Imprimir a Blanco y Negro: " + c.getDato().getImgBw_());
			}
			c = c.getNext();
		}
		return str_;
	}

	
	public String toString() {
		String str_ = "";
		NodoColaClientes c = this.inicio;
		while (c != null) {
			str_ = str_ +"\"node"+c.getDato().getIDCliente()+"\""+ "[" +"label = \""+c.getDato().getIDCliente() +"-"+c.getDato().getNombreCliente()+ "\"\r\n"
					+ "shape = \"record\"\r\n"
					+ "];"+"\n";
			c = c.getNext();
		}
		
		return str_;
	}
	
	public String apuntes_cola() {
		String str_ = "";
		NodoColaClientes c = this.inicio;
		while (c.getNext() != null) {
			str_ = str_ +"\"node"+c.getDato().getIDCliente()+"\"-> \"node"+c.getNext().getDato().getIDCliente()+"\"";
			c = c.getNext();
		}
		
		return str_;
	}
}
