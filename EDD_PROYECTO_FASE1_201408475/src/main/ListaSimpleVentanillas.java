package main;

import nodos.NodoColaClientes;
import nodos.NodoListaVentanillas;

public class ListaSimpleVentanillas {
	  private NodoListaVentanillas primero;
	    private int numElem; 
	    
	public ListaSimpleVentanillas(){ 
	    primero = null;
	    numElem = 0;
	}

	public void insertarPrimero (int elemento){
		NodoListaVentanillas nuevo = new NodoListaVentanillas (elemento, primero);
	    primero = nuevo;
	    numElem++;
	}

	public void insertarFinal (int elemento){ 
		NodoListaVentanillas nuevo = new NodoListaVentanillas(elemento, null);
	    if (primero == null){
	    primero = nuevo;
	    }
	    else {
	    	NodoListaVentanillas actual = primero;
	        while (actual.getSig()!= null){
	            actual = actual.getSig();
	            
	        }
	        actual.setSig(nuevo);
	        numElem++;
	    }
	System.out.println("Final");
	}
	
	public void borrar (int elem){
	    if (primero == null) 
	        System.out.println("lista vacía");
	    else
	        if (primero.getElemento()== elem){
	        primero = primero.getSig();
	        numElem--;
	        }
	        else {
	        	NodoListaVentanillas actual = primero;
	            while (actual.getSig()!=null && actual.getSig().getElemento() != elem)
	                actual = actual.getSig();
	                if (actual.getSig()== null )
	                    System.out.println ("elemento "+elem+" no esta en la lista");
	                else{
	                    actual.setSig(actual.getSig().getSig());
	                    numElem--;
	                }
	        }
	} 
	
	public void listar(){
		NodoListaVentanillas actual = primero;
	    while (actual.getSig()!= null){
	        System.out.println("Ventanilla No. "+actual.getElemento());
	        actual = actual.getSig();
	    
	    }
	    System.out.println("Ventanilla No. "+actual.getElemento());
	}
	
	public int obtenerPrimerVentanilla(){
		  if (primero == null) {
		    	return -1;
		    }
		  else {
		NodoListaVentanillas actual = primero;
	    while (actual.getSig()!= null){
	        actual = actual.getSig();
	    
	    }
	    return actual.getElemento();
	}
	   }
	public int contar(){
		int contador = 0;
	    if (primero == null) {
	    	return contador;
	    }
	    else {
	    	NodoListaVentanillas actual = primero;
		    while (actual.getSig()!= null){
		    	contador++;
		        actual = actual.getSig();
		    }
		    contador=contador++;
		    return contador;
	    }
		
	}
	
	public String toString() {
		String str_ = "";
		  if (primero == null) {
		    	return str_;
		    }
		    else {
		    	NodoListaVentanillas actual = primero;
			    while (actual.getSig()!= null){
			    	str_ = str_ +"\"node"+actual.getElemento()+"\""+ "[" +"label = \"Ventanilla #"+actual.getElemento() + "\"\r\n"
							+ "shape = \"record\"\r\n"
							+ "];"+"\n";
			        actual = actual.getSig();
			    }
			    
			    str_ = str_ +"\"node"+actual.getElemento()+"\""+ "[" +"label = \"Ventanilla #"+actual.getElemento() + "\"\r\n"
						+ "shape = \"record\"\r\n"
						+ "];"+"\n";
			    return str_;
		    }
	}
	
	
	public String apuntes_ventanilla() {
		String str_ = "";
		  if (primero == null) {
		    	return str_;
		    }
		    else {
		    	NodoListaVentanillas actual = primero;
			    while (actual.getSig()!= null){
			    	str_ = str_ +"\"node"+actual.getElemento()+"\"-> \"node"+actual.getSig().getElemento()+"\" \n";
			        actual = actual.getSig();
			    }
			    return str_;
		    }
	}

}
