package util;

import java.io.Serializable;
import modelo.Paciente;

public class ColaPrioridad implements Serializable {

    private Nodo primero;
    private Nodo ultimo;
    private int cantidad = 0;

    public void agregar(Paciente paciente, int prioridad) {
        Nodo nuevo = new Nodo(paciente, prioridad);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            cantidad++;
        } else {
            Nodo aux = primero;
            Nodo ant = null;

            if (prioridad >= aux.prioridad && ant == null) {
                nuevo.siguiente = aux;
                primero = nuevo;
                System.out.println("agregando correctamente");
                cantidad++;
                return;
            }

            while (aux.siguiente != null) {
                if (prioridad >= aux.prioridad) {
                    nuevo.siguiente = aux;
                    ant.siguiente = nuevo;
                    System.out.println("agregando correctamente");

                    cantidad++;
                    return;
                }
                ant = aux;
                aux = aux.siguiente;
            }

            if (aux.siguiente == null && prioridad >= aux.prioridad) {
                nuevo.siguiente = aux;
                ant.siguiente = nuevo;
                System.out.println("agregando correctamente");

                cantidad++;
            } else {
                aux.siguiente = nuevo;
                System.out.println("agregando correctamente");
                cantidad++;
            }
        }
    }

    public void imprimir() {
        Nodo aux = primero;
        while (aux != null) {
            System.out.println("  Prioridad: " + aux.prioridad);
            aux = aux.siguiente;

        }
    }

    public Paciente[] toArray() {
        Paciente[] resultado = new Paciente[cantidad];
        Nodo aux = primero;
        int i = 0;
        while (aux != null) {
            resultado[i] = aux.paciente;
            aux = aux.siguiente;
            i++;
        }
        return resultado;
    }

    public static void main(String[] args) {
        ColaPrioridad c = new ColaPrioridad();
        c.agregar(null, 21);
        c.agregar(null, 50);
        c.agregar(null, 0);
        c.agregar(null, 45);
        c.agregar(null, 1);
        c.agregar(null, 2);
        c.agregar(null, 5);
        c.agregar(null, 0);
        c.imprimir();
    }

    class Nodo implements Serializable {

        Paciente paciente;
        int prioridad;
        Nodo siguiente;

        public Nodo(Paciente paciente, int prioridad) {
            this.paciente = paciente;
            this.prioridad = prioridad;
            siguiente = null;
        }
    }
}
