package modelo;

import util.ColaPrioridad;
import java.io.Serializable;

public class Clinica implements Comparable, Serializable{

    String nombre;
    String ubicacion;
    int numMedicos = 0;
    int numEnfermeros = 0;
    int aforo;
    Medico[] medicos;
    ColaPrioridad pacientes;
    int numPacientes = 0;
    int identificador;

    public Clinica(String nombre, String ubicacion, int numEnfermeros, int aforo,
            int totalMedicos, int totalPacientes, int identificador) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numPacientes = 0;
        this.numMedicos = 0;
        this.numEnfermeros = numEnfermeros;
        this.aforo = aforo;
        this.medicos = new Medico[totalMedicos];
        this.identificador = identificador;
        pacientes = new ColaPrioridad();
    }

    public boolean añadirMedico(Medico medico) {
        if (numMedicos >= medicos.length) {
            return false;
        }
        medicos[numMedicos] = medico;
        numMedicos++;
        return true;
    }

    public boolean añadirPaciente(Paciente paciente) {
        pacientes.agregar(paciente, paciente.getEdad());
        numPacientes++;
        return true;
    }
    
    public float calcularCoeficiente(){
        return (float) ((float)numPacientes / (float)numEnfermeros);
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

    public int getNumMedicos() {
        return numMedicos;
    }

    public void setNumMedicos(int numDoctores) {
        this.numMedicos = numDoctores;
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

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Paciente[] getPacientes(){
        return pacientes.toArray();
    }
    
    public String toString(){
        return nombre;
    }
    
    @Override
    public int compareTo(Object o) {
        Clinica c = (Clinica) o;
        return this.identificador > c.identificador ? 1 : this.identificador == c.identificador ? 0 : -1;
    }
}