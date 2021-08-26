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
    int identificador;

    public Clinica(String nombre, String ubicacion, int numPacientes, int numDoctores, int numEnfermeros, int aforo,
                   int totalMedicos, Paciente[] pacientes, int identificador) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numPacientes = numPacientes;
        this.numDoctores = numDoctores;
        this.numEnfermeros = numEnfermeros;
        this.aforo = aforo;
        this.medicos = new Medico[totalMedicos];
        this.pacientes = pacientes;
        this.identificador = identificador;
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

    public Medico[] getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico[] medicos) {
        this.medicos = medicos;
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

}
