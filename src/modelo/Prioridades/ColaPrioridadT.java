
package modelo.Prioridades;


public class ColaPrioridadT {
    private Cola[] tabla;
    private int maxPrioridad;

    public ColaPrioridadT(int n) throws Exception {
        if (n < 1)
            throw new Exception("Error en prioridad: " + n);
        maxPrioridad = n;
        tabla = new Cola[maxPrioridad + 1];
        for (int i = 0; i < maxPrioridad; i++) {
            tabla[i] = new Cola();
        }
    }

    public void insertarPrioridad(Tarea t) throws Exception {
        int p = t.getPrioridad();

        if (p >= 0 && p <= maxPrioridad)
            tabla[p].push(t);
        else
            throw new Exception("Tarea con prioridad fuera de rango ");
    }

    public Tarea elementoMin() throws Exception {
        int i = 0;
        int indiceCola = -1;
        do {
            if (!tabla[i].esVacia()) {
                indiceCola = i;
                i = maxPrioridad + 1;
            } else
                i++;
        } while (i <= maxPrioridad);

        if (indiceCola != -1)
            return (Tarea) tabla[indiceCola].frenteCola();
        else
            throw new Exception("cola de prioridades vacia");
    }

    public void quitarMin() throws Exception {
        int i = 0;
        int indiceCola = -1;
        do {
            if (!tabla[i].esVacia()) {
                indiceCola = i;
                i = maxPrioridad + 1;
            } else
                i++;
        } while (i <= maxPrioridad);

        if (indiceCola != -1)
            tabla[indiceCola].borrarCola();
        else
            throw new Exception("cola de prioridades vacia");
    }

    public boolean colaPrioridadVacia() {

        int i = 0;
        while (tabla[i].esVacia() && i < maxPrioridad)
            i++;
        return tabla[i].esVacia();
    }

}
