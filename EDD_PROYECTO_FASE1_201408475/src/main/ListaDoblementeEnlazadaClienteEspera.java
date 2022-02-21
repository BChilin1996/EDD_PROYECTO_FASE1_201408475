package main;

import models.Clientes;
import models.ClientesVentanilla;
import nodos.NodoColaClientesVentanilla;

public class ListaDoblementeEnlazadaClienteEspera {
	    
	 class Nodo {
	        Clientes dato;
	        Nodo ant,sig;
	        private PilaImagenes pila;
	        
	    	public PilaImagenes getPila() {
				return pila;
			}
	    }
	    
	    private Nodo raiz;
	    
	    public ListaDoblementeEnlazadaClienteEspera () {
	        raiz=null;
	    }
	      
	    void insertar (int pos, Clientes cliente, PilaImagenes pila)
	    {
	        if (pos <= cantidad () + 1)    {
	            Nodo nuevo = new Nodo ();
	            nuevo.dato = cliente;
	            nuevo.pila = pila;
	            if (pos == 1){
	                nuevo.sig = raiz;
	                if (raiz!=null)
	                    raiz.ant=nuevo;
	                raiz = nuevo;
	            } else
	                if (pos == cantidad () + 1)    {
	                    Nodo reco = raiz;
	                    while (reco.sig != null) {
	                        reco = reco.sig;
	                    }
	                    reco.sig = nuevo;
	                    nuevo.ant=reco;
	                    nuevo.sig = null;
	                } else {
	                    Nodo reco = raiz;
	                    for (int f = 1 ; f <= pos - 2 ; f++)
	                        reco = reco.sig;
	                    Nodo siguiente = reco.sig;
	                    reco.sig = nuevo;
	                    nuevo.ant=reco;
	                    nuevo.sig = siguiente;
	                    siguiente.ant=nuevo;
	                }
	        }
	    }

	    public Clientes extraer (int pos) {
	        if (pos <= cantidad ())    {
	            Clientes informacion;
	            if (pos == 1) {
	                informacion = raiz.dato;
	                raiz = raiz.sig;
	                if (raiz!=null)
	                    raiz.ant=null;
	            } else {
	                Nodo reco;
	                reco = raiz;
	                for (int f = 1 ; f <= pos - 2 ; f++)
	                    reco = reco.sig;
	                Nodo prox = reco.sig;
	                reco.sig = prox.sig;
	                Nodo siguiente=prox.sig;
	                if (siguiente!=null)
	                    siguiente.ant=reco;
	                informacion = prox.dato;
	            }
	            return informacion;
	        }
	        else
	            return null;
	    }

	    public void borrar (int pos)
	    {
	        if (pos <= cantidad ())    {
	            if (pos == 1) {
	                raiz = raiz.sig;
	                if (raiz!=null)
	                    raiz.ant=null;
	            } else {
	                Nodo reco;
	                reco = raiz;
	                for (int f = 1 ; f <= pos - 2 ; f++)
	                    reco = reco.sig;
	                Nodo prox = reco.sig;
	                prox=prox.sig;
	                reco.sig = prox;
	                if (prox!=null)
	                    prox.ant=reco;
	            }
	        }
	    }
	    
	    public void intercambiar (int pos1, int pos2) {
	        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
	            Nodo reco1 = raiz;
	            for (int f = 1 ; f < pos1 ; f++)
	                reco1 = reco1.sig;
	            Nodo reco2 = raiz;
	            for (int f = 1 ; f < pos2 ; f++)
	                reco2 = reco2.sig;
	            Clientes aux = reco1.dato;
	            reco1.dato = reco2.dato;
	            reco2.dato = aux;
	        }
	    }
	    
	  

	    public int cantidad ()
	    {
	        int cant = 0;
	        Nodo reco = raiz;
	        while (reco != null) {
	            reco = reco.sig;
	            cant++;
	        }
	        return cant;
	    }
	    

	    public boolean existe(Clientes x) {
	        Nodo reco=raiz;
	        while (reco!=null) {
	            if (reco.dato.getIDCliente()==x.getIDCliente())
	                return true;
	            reco=reco.sig;
	        }
	        return false;
	    }
	    
	    public Nodo buscar_cliente_cola_espera(int x) {
	        Nodo reco=raiz;
	        while (reco!=null) {
	            if (reco.dato.getIDCliente()==x)
	             return reco;
	            reco=reco.sig;
	        }
	        return null;
	    }
	    
	
		
	    
		public void insertar_pila(int id_cliente, int apilar_pila) {
			Nodo cliente = buscar_cliente_cola_espera(id_cliente);
			if (cliente != null) {
				cliente.getPila().apilar(apilar_pila);
			} else {
				System.out.println("No existe registro");
			}
		}
		
	    public String imprimir_nodos_pila() {
	    	  Nodo reco = raiz;
	    	  String str_="";
		        while (reco != null) {
		        	str_=str_+reco.getPila().lista_epera(reco.dato.getIDCliente());
		            reco = reco.sig;
		        }
		        return str_;
	    }
		
	    public boolean vacia ()
	    {
	        if (raiz == null)
	            return true;
	        else
	            return false;
	    }
	    
	    public String toString()
	    {
	    	String str_="";
	    	  Nodo reco = raiz;
		        while (reco != null) {
					str_ = str_ +reco.dato.getIDCliente()+",";
		            reco = reco.sig;
		        }
		        if (str_.length()>0) {
		    		str_ = str_.substring(0, str_.length()-1);
				}
		        return str_;
	    }
	    public String imprimir ()
	    {
	    	
	    	String str_="";
	        Nodo reco = raiz;
	        while (reco != null) {
				str_ = str_ +"\"node"+reco.dato.getIDCliente()+"\""+ "[" +"label = \""+reco.dato.getNombreCliente() + "\"\r\n"
						+ "shape = \"record\"\r\n"
						+ "];"+"\n";
	            reco = reco.sig;
	        }
	        
	        reco = raiz;
	        while (reco.sig != null) {
	        	  str_ = str_ +"\"node"+reco.dato.getIDCliente()+"\"-> \"node"+reco.sig.dato.getIDCliente()+"\"\n";
	            reco = reco.sig;
	        }

	        
	        return str_;
	    }
}
