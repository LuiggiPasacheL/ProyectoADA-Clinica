package modelo;

public class ColaPrioridad {

    private Nodo primero;
    private Nodo ultimo;
    private int cantidad = 0;
    
    public void agregar(Paciente paciente, int prioridad) {
        Nodo nuevo = new Nodo(paciente, prioridad);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            Nodo aux = primero;

            while (aux != null) {
                if (prioridad >= aux.prioridad && aux.siguiente == null) {
                    ultimo.siguiente = nuevo;
                    ultimo = nuevo;
                    break;
                } else if (prioridad >= aux.prioridad && prioridad < aux.siguiente.prioridad) {
                    nuevo.siguiente = aux.siguiente;
                    aux.siguiente = nuevo;

                    break;
                }
                aux = aux.siguiente;

            }
        }
        cantidad++;
    }

    public void imprimir() {
        Nodo aux = primero;
        while (aux != null) {
            System.out.println(aux.paciente + "  Prioridad: " + aux.prioridad);
            aux = aux.siguiente;

        }
    }

    public Paciente[] toArray(){
        Paciente[] resultado = new Paciente[cantidad];
        Nodo aux = primero;
        int i = 0;
        while(aux != null){
            resultado[i] = aux.paciente;
            aux = aux.siguiente;
            i++;
        }
        return resultado;
    }
    /*
    public static void main(String[] args){
        ColaPrioridad c = new ColaPrioridad();
        c.agregar(1, 0);
        c.agregar(2, 0);
        c.agregar(3, 0);
        c.agregar(6, 3);
        c.agregar(4, 1);
        c.agregar(5, 2);
        c.agregar(8, 5);
        c.agregar(100, 0);
        c.imprimir();
    }
     */

    class Nodo {

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
