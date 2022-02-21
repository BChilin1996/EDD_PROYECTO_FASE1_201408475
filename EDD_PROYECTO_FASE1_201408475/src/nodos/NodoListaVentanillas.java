package nodos;

public class NodoListaVentanillas {
	 private int elemento;
	    private NodoListaVentanillas siguiente;

	public NodoListaVentanillas (int elem, NodoListaVentanillas sig){
	    elemento = elem;
	    siguiente = sig;
	}
	
	public int getElemento(){
	    return elemento;
	}
	public NodoListaVentanillas getSig(){
	    return siguiente;
	}
	public void setElemento(int elem){
	    elemento = elem;
	}
	public void setSig(NodoListaVentanillas sig){
	    siguiente = sig;
	}
}
