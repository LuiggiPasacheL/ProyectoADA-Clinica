package modelo.Prioridades;

public class Nodo {
    private Object dato;
    private Nodo siguiente;

    public Nodo(Object dato) {
        this.dato = dato;
        siguiente = null;
    }

    public Nodo(Object dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo cima) {
        this.siguiente = cima;
    }

}
