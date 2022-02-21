package nodos;

public class NodoClientesAtendidos {
	 private int elemento;
	private NodoClientesAtendidos siguiente;

	public NodoClientesAtendidos (int elem, NodoClientesAtendidos sig){
	    elemento = elem;
	    siguiente = sig;
	}
	
	public int getElemento(){
	    return elemento;
	}
	public NodoClientesAtendidos getSig(){
	    return siguiente;
	}
	public void setElemento(int elem){
	    elemento = elem;
	}
	public void setSig(NodoClientesAtendidos sig){
	    siguiente = sig;
	}
}
