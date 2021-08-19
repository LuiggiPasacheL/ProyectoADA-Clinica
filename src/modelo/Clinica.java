package modelo;

import java.util.Arrays;

public class Clinica {
    String nombre;
    String ubicacion;
    int numPacientes;
    int numDoctores;
    int numEnfermeros;
    int aforo;
    Medico[] medicos; //mejorar
    Paciente[] pacientes;

    public Clinica(String nombre, String ubicacion, int numPacientes, int numDoctores, int numEnfermeros, int aforo,
                   int totalMedicos, Paciente[] pacientes) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numPacientes = numPacientes;
        this.numDoctores = numDoctores;
        this.numEnfermeros = numEnfermeros;
        this.aforo = aforo;
        this.medicos = new Medico[totalMedicos];
        this.pacientes = pacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumPacientes() {
        return numPacientes;
    }

    public void setNumPacientes(int numPacientes) {
        this.numPacientes = numPacientes;
    }

    public int getNumDoctores() {
        return numDoctores;
    }

    public void setNumDoctores(int numDoctores) {
        this.numDoctores = numDoctores;
    }

    public int getNumEnfermeros() {
        return numEnfermeros;
    }

    public void setNumEnfermeros(int numEnfermeros) {
        this.numEnfermeros = numEnfermeros;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

}
