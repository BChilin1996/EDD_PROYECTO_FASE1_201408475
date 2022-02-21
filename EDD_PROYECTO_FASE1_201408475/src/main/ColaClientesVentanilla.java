package main;

import models.Clientes;
import models.ClientesVentanilla;
import models.ColaImpresiones;
import models.Impresoras;
import models.PasosClientes;
import nodos.NodoColaClientes;
import nodos.NodoColaClientesVentanilla;

public class ColaClientesVentanilla {
	private NodoColaClientesVentanilla inicio;
	private NodoColaClientesVentanilla termino;

	// Se crean las impresoras disponibles
	ColaImpresion cImpresionColor = new ColaImpresion();
	ColaPasosClientes cola_pasos = new ColaPasosClientes();
	ColaImpresion cImpresionBlancoNegro = new ColaImpresion();

	
	ListaDoblementeEnlazadaClienteEspera lista_doble_enlazada = new ListaDoblementeEnlazadaClienteEspera();
	// Se crea la lista de los clientes en espera

	// Constructor sin parametros
	public ColaClientesVentanilla() {
		inicio = null;
		termino = null;

	}

	// Metodo insertar
	public void insertar(ClientesVentanilla dato, PilaImagenes pila) {
		NodoColaClientesVentanilla i = new NodoColaClientesVentanilla(dato, pila);
		i.setNext(null);
		if (inicio == null & termino == null) {
			inicio = i;
			termino = i;
		}
		termino.setNext(i);
		termino = termino.getNext();
	}

	public String agregar_nodo_cliente(int id_cliente) {
		PasosClientes pasos = new PasosClientes(id_cliente,1);
		cola_pasos.insertar(pasos);
		return "";
	}
	
	public String imprimir_pasos() {
		String str_="";
		str_= cola_pasos.toString();
		return str_;
	}
	
	public int imprimir_con_mas_pasos() {
		int id_cliente_mas_pasos =0;
		id_cliente_mas_pasos = cola_pasos.toStringMasPasos();
		return id_cliente_mas_pasos;
	}
	
	public NodoColaClientesVentanilla buscar_cliente(int id_cliente) {
		NodoColaClientesVentanilla c = this.inicio;
		while (c != null) {
			if (c.getDato().getIDCliente() == id_cliente) {
				return c;
			}
			c = c.getNext();
		}
		return null;
	}

	public ClientesVentanilla buscar_cliente_modelo(int id_cliente) {

		NodoColaClientesVentanilla c = this.inicio;
		while (c != null) {
			if (c.getDato().getIDCliente() == id_cliente) {
				return c.getDato();
			}
			c = c.getNext();
		}
		return null;
	}

	
	
	public void insertar_pila(int id_cliente, int apilar_pila) {
		NodoColaClientesVentanilla cliente = buscar_cliente(id_cliente);
		if (cliente != null) {
			cliente.getPila().apilar(apilar_pila);
		} else {
			System.out.println("No existe registro");
		}
	}

	// Metodo extraer dato
	public ClientesVentanilla extraer() {
		ClientesVentanilla dato = inicio.getDato();
		inicio = inicio.getNext();
		return dato;
	}

	
	public String extraer_id_cliente(int id) {
		NodoColaClientesVentanilla c = this.inicio;
		while (c.getNext() != null) {
			if (c.getDato().getIDCliente()==id) {
				inicio = inicio.getNext();
			}
			c = c.getNext();
		}
		return "Lo Elimine";
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
		NodoColaClientesVentanilla c = this.inicio;
		while (c != null) {
			contador++;
			c = c.getNext();
		}
		System.out.println("Numero de datos en la cola: " + contador);
		return contador;
	}

	public ClientesVentanilla ObtenerPrimero() {
		ClientesVentanilla dato = inicio.getDato();
		return dato;
	}

	// Metodo toString
	public String toString() {
		NodoColaClientesVentanilla c = this.inicio;
		String s = "";
		while (c != null) {
			s = s + c.getDato().getIDCliente() + " ";
			s = s + c.getPila().listar(c.getDato().getIDCliente(),"") + "\n";
			c = c.getNext();
		}
		return s;
	}

	public String AgregarImagenNodo(boolean ventanilla_llenas) {
		String s = "";
		if (ventanilla_llenas == true) {
			NodoColaClientesVentanilla c = this.inicio;
			while (c != null) {
				if (c.getDato().getImgBw() > 0) {
					insertar_pila(c.getDato().getIDCliente(), c.getDato().getImgBw()+1000);
					System.out.println("La ventanilla # " + c.getDato().getIdVentanilla() + " Recibió una Imágen en Blanco y Negro del Cliente "+c.getDato().getIDCliente());
					ClientesVentanilla cliente_ = buscar_cliente_modelo(c.getDato().getIDCliente());
					cliente_.setImgBw(c.getDato().getImgBw() - 1);
					cliente_.setPasosSistema(c.getDato().getPasosSistema()+1);
					cola_pasos.SumarPaso(c.getDato().getIDCliente());
					c.setDato(cliente_);
				} else {
					if (c.getDato().getImgColor() > 0) {
						insertar_pila(c.getDato().getIDCliente(), c.getDato().getImgColor()+2000);
						System.out.println("La ventanilla # " + c.getDato().getIdVentanilla() + " Recibió una Imágen a Color del Cliente "+c.getDato().getIDCliente());
						ClientesVentanilla cliente_ = buscar_cliente_modelo(c.getDato().getIDCliente());
						cliente_.setImgColor(c.getDato().getImgColor() - 1);
						cliente_.setPasosSistema(c.getDato().getPasosSistema()+1);
						cola_pasos.SumarPaso(c.getDato().getIDCliente());
						c.setDato(cliente_);
					}
				}
				c = c.getNext();
			}
			return s;
		} else {
			NodoColaClientesVentanilla c = this.inicio;
			while (c.getNext() != null) {
				if (c.getDato().getImgBw() > 0) {
					insertar_pila(c.getDato().getIDCliente(), c.getDato().getImgBw()+1000);
					System.out.println("La ventanilla # " + c.getDato().getIdVentanilla() + " Recibió una Imágen en Blanco y Negro del Cliente "+c.getDato().getIDCliente());
					ClientesVentanilla cliente_ = buscar_cliente_modelo(c.getDato().getIDCliente());
					cliente_.setImgBw(c.getDato().getImgBw() - 1);
					cola_pasos.SumarPaso(c.getDato().getIDCliente());
					c.setDato(cliente_);
				
				} else {
					if (c.getDato().getImgColor() > 0) {
						insertar_pila(c.getDato().getIDCliente(), c.getDato().getImgColor()+2000);
						System.out.println("La ventanilla # " + c.getDato().getIdVentanilla() + " Recibió una Imágen a Color del Cliente "+c.getDato().getIDCliente());
						ClientesVentanilla cliente_ = buscar_cliente_modelo(c.getDato().getIDCliente());
						cliente_.setImgColor(c.getDato().getImgColor() - 1);
						cola_pasos.SumarPaso(c.getDato().getIDCliente());
						c.setDato(cliente_);
						
					}
				}

				c = c.getNext();
			}
			return s;
		}
	}
	
	public String EnviarTrabajoImpresion() {
		String s = "";
			NodoColaClientesVentanilla c = this.inicio;
			while (c.getNext() != null) {
				if (c.getDato().getImgBw() == 0 && c.getDato().getImgColor()==0) {
					System.out.println("#### El Cliente "+c.getDato().getIDCliente()+"-"+c.getDato().getNombreCliente()+" Termino de Entregar Trabajos Impresion y el Cliente se Envió a la Lista de Espera #####");
					cola_pasos.SumarPaso(c.getDato().getIDCliente());
					for(int i = 1; i <= c.getDato().getImgBw_(); i = i+1)
					{
						ColaImpresiones cola_impresion_blanco = new ColaImpresiones(c.getDato().getIDCliente(),i);
						cImpresionBlancoNegro.insertar(cola_impresion_blanco);
					}
					for(int i = 1; i <= c.getDato().getImgColor_();i = i+1)
					{
						ColaImpresiones cola_impresion_color = new ColaImpresiones(c.getDato().getIDCliente(),i);
						cImpresionColor.insertar(cola_impresion_color);
					}
					PilaImagenes pila_cliente_espera = new PilaImagenes();
					Clientes clientes_espera = new Clientes(c.getDato().getIDCliente(),c.getDato().getNombreCliente(),
							c.getDato().getImgColor(),c.getDato().getImgBw(),c.getDato().getImgColor(),c.getDato().getImgBw(),0);
					lista_doble_enlazada.insertar(c.getDato().getIDCliente(), clientes_espera, pila_cliente_espera);
					
					extraer_id_cliente(c.getDato().getIDCliente());
					s = s+c.getDato().getIdVentanilla()+",";
				} 
				c = c.getNext();
			}
			if (s.length()>0) {
				s = s.substring(0, s.length()-1);
			}
			return s;
	}

	public String ImprimirCola() {
		String s="";

		if (cImpresionBlancoNegro.contar()>1) {
			ColaImpresiones cliente_blanco_negro = cImpresionBlancoNegro.obtener_primero();
			System.out.println("Se Imprime una Imagen a Blanco y Negro del Cliente "+cliente_blanco_negro.getIDCliente());
			lista_doble_enlazada.insertar_pila(cliente_blanco_negro.getIDCliente(),cliente_blanco_negro.getIDImpresion());
			cImpresionBlancoNegro.extraer();
			cola_pasos.SumarPaso(cliente_blanco_negro.getIDCliente());
		
		}
		if (cImpresionColor.contar()>1) {
			ColaImpresiones cliente_color = cImpresionColor.obtener_primero();
			System.out.println("Se Imprime una Imagen a Color del Cliente "+cliente_color.getIDCliente());
			lista_doble_enlazada.insertar_pila(cliente_color.getIDCliente(),cliente_color.getIDImpresion());
			cImpresionColor.extraer();
			cola_pasos.SumarPaso(cliente_color.getIDCliente());
			
		}
		
		return s;
	}
	
	public String validar_impresiones_pendientes() {
		String lista_id_clientes_cola_espera = "";
		lista_id_clientes_cola_espera=lista_doble_enlazada.toString();
		if (lista_id_clientes_cola_espera.length()>0) {
			String[] parts = lista_id_clientes_cola_espera.split(",");
			  for (int i=0;i<parts.length;i++) {
				    int pendientes_color = 1000;
				    int pendientes_blanco_negro=1000;
				    pendientes_color = cImpresionColor.contar_pendientes(Integer.parseInt(parts[i]));
				    pendientes_blanco_negro = cImpresionBlancoNegro.contar_pendientes(Integer.parseInt(parts[i]));
				    if (pendientes_color==0 && pendientes_blanco_negro==0) {
				    	System.out.println("#### El Cliente  "+ parts[i] +" Termino sus impresiones #####");
				    	cola_pasos.SumarPaso(Integer.parseInt(parts[i]));
				    	lista_doble_enlazada.borrar(Integer.parseInt(parts[i]));
				    }
				    
			  }
		}
		
		return "";
	}
	public String imprimir_cola_impresion() {
		String s = "";
		s = s +"\"node_Impresora_Color\"[label = \" Impresora a Color\"\r\n"
				+ "shape = \"record\"\r\n"
				+ "];";
		
		s = s +cImpresionColor.toString("Color");
		s = s +cImpresionColor.unir_nodos_cola("Color","node_Impresora_Color");
		
		s = s +"\"node_Impresora_Blanco_Negro\"[label = \" Impresora en Blanco y Negro\"\r\n"
				+ "shape = \"record\"\r\n"
				+ "];";
		
		s = s + cImpresionBlancoNegro.toString("Blanco_Negro");
		s = s + cImpresionBlancoNegro.unir_nodos_cola("Blanco_Negro","node_Impresora_Blanco_Negro");
		
		
		
		return s;
	}
	
	public String nodos_grafo() {
		String str_ = "";
		String nodo_primer_ventanilla ="";
		NodoColaClientesVentanilla c = this.inicio;
		while (c != null) {
			str_ = str_ +"\"node"+c.getDato().getIDCliente()+"\""+ "[" +"label = \""+c.getDato().getNombreCliente() + "\"\r\n"
					+ "shape = \"record\"\r\n"
					+ "];"+"\n";
			
			str_ = str_ +"\"node_ventanilla_"+c.getDato().getIdVentanilla()+"\""+ "[" +"label = \"Ventanilla # "+c.getDato().getIdVentanilla() + "\"\r\n"
					+ "shape = \"record\"\r\n"
					+ "];"+"\n";
			nodo_primer_ventanilla ="node_ventanilla_"+c.getDato().getIdVentanilla();
			str_ = str_ +"\"node"+c.getDato().getIDCliente()+"\"-> \"node_ventanilla_"+c.getDato().getIdVentanilla()+"\"\n";
			str_ = str_ + c.getPila().listar(c.getDato().getIDCliente(),nodo_primer_ventanilla) + "\n";
			str_ = str_ + c.getPila().listar_nodos(c.getDato().getIDCliente(),nodo_primer_ventanilla) + "\n";
			c = c.getNext();
		}
		
		return str_;
	}
	
	public String apuntes_grafo() {
		String str_ = "";
		 NodoColaClientesVentanilla c = this.inicio;
		while (c.getNext() != null) {
			str_ = str_ +"\"node"+c.getDato().getIDCliente()+"\"-> \"node"+c.getNext().getDato().getIDCliente()+"\"\n";
			c = c.getNext();
		}
		
		return str_;
	}
	
	public String imprimir_lista_espera() {
		String s = "";
		if (lista_doble_enlazada.cantidad()>0) {
			s = s +lista_doble_enlazada.imprimir();
			s = s + lista_doble_enlazada.imprimir_nodos_pila();
			
		}

		return s;
	}
}
