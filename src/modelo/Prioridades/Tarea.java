/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Prioridades;

/**
 * @author nick paredes
 */
public class Tarea implements Comparador {
    private Object item;
    private int prioridad;

    public Tarea(Object item, int prioridad) {
        this.item = item;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean igualQue(Object q) {
        Tarea n = (Tarea) q;
        return prioridad == n.prioridad;
    }


    public boolean menorQue(Object q) {
        Tarea n = (Tarea) q;
        return prioridad > n.prioridad;
    }


    public boolean mayorQue(Object q) {
        Tarea n = (Tarea) q;
        return prioridad < n.prioridad;
    }


    public boolean menorIgualQue(Object q) {
        Tarea n = (Tarea) q;
        return prioridad >= n.prioridad;
    }


    public boolean mayorIgualQue(Object q) {
        Tarea n = (Tarea) q;
        return prioridad <= n.prioridad;
    }

}
