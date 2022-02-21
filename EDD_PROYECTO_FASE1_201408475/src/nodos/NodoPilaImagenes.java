package nodos;

public class NodoPilaImagenes {
	 // Variable en la cual se va a guardar el valor.
    private int valor;
    // Variable para enlazar los nodos.
    private NodoPilaImagenes siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void NodoPilaImagenes(){
        this.valor = 0;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoPilaImagenes getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPilaImagenes siguiente) {
        this.siguiente = siguiente;
    }   
}
