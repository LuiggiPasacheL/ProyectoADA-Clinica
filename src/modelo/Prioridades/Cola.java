package modelo.Prioridades;

public class Cola {
    private Nodo frente, fin;

    public Cola() {
        frente = fin = null;
    }

    public boolean esVacia() {
        return (frente == null);
    }

    public void push(Object elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (esVacia()) {
            frente = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Object pop() throws Exception {
        if (esVacia()) {
            throw new Exception("La cola esta vacia");
        } else {
            Object aux;
            aux = frente.getDato();

            frente = frente.getSiguiente();
            return aux;
        }
    }

    public void borrarCola() {
        while (frente != null) {
            frente = frente.getSiguiente();
        }
    }

    public Object frenteCola() throws Exception {
        if (esVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (frente.getDato());
    }

    public void Imprimir() {
        if (esVacia()) {
            System.out.println("Esta vacia");
        } else {
            Nodo aux = frente;
            while (aux != fin) {
                System.out.println(aux.getDato());
                aux = aux.getSiguiente();
            }
            System.out.println(aux.getDato());
        }
    }

}
