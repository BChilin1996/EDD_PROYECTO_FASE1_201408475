package main;

import nodos.NodoClientesAtendidos;

public class ListaSimpleClientesAtendidos {
	  private NodoClientesAtendidos primero;
	 private int numElem; 
	    
	public ListaSimpleClientesAtendidos(){ 
	    primero = null;
	    numElem = 0;
	}

	public void insertarPrimero (int elemento){
		NodoClientesAtendidos nuevo = new NodoClientesAtendidos (elemento, primero);
	    primero = nuevo;
	    numElem++;
	}

	public void insertarFinal (int elemento){ 
		NodoClientesAtendidos nuevo = new NodoClientesAtendidos(elemento, null);
	    if (primero == null){
	    primero = nuevo;
	    }
	    else {
	    	NodoClientesAtendidos actual = primero;
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
	        	NodoClientesAtendidos actual = primero;
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
	    
		NodoClientesAtendidos actual = primero;
	    while (actual.getSig()!= null){
	        System.out.println("Ventanilla No. "+actual.getElemento());
	        actual = actual.getSig();
	    
	    }
	    System.out.println("Ventanilla No. "+actual.getElemento());
	}
}
