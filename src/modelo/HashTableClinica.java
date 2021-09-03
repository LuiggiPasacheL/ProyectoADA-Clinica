/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import util.HashTable;
import util.Excel;

/**
 * @author nick paredes
 */
public class HashTableClinica implements Serializable{

    private HashTable<Clinica> clinicas;
    private Clinica listaPacientes;

    public HashTableClinica(int tamano) {
        clinicas = new HashTable<>(tamano);
        listaPacientes = new Clinica("Todos los pacientes", "", 0, 0, 0, 0, 0);
    }

    public Clinica buscarClinica(String clinica) {
        Clinica result = null;
        int pos = clinicas.hash(clinica);
        int posSgte;
        result = clinicas.get(pos);
        if (result.getNombre().equals(clinica)) {
            return result;
        } else {
            posSgte = pos + 1;
            while (clinicas.get(posSgte) != null && !clinicas.get(posSgte).getNombre().equals(clinica)
                    && pos != posSgte) {
                posSgte++;
                if (posSgte == clinicas.getTamanoMax()) {
                    posSgte = 0;
                }
            }
            if (clinicas.get(posSgte) == null || pos == posSgte) {
                return null;
            } else {
                return clinicas.get(posSgte);
            }
        }
    }

    public int busquedaPruebaLineal(String nombreClinica) {
        Clinica result = null;
        int pos = clinicas.hash(nombreClinica);
        int posSgte;
        result = clinicas.get(pos);
        if (result.getNombre().equals(nombreClinica)) {
            return pos;
        } else {
            posSgte = pos + 1;
            while (clinicas.get(posSgte) != null && !clinicas.get(posSgte).getNombre().equals(nombreClinica)
                    && pos != posSgte) {
                posSgte++;
                if (posSgte == clinicas.getTamanoMax()) {
                    posSgte = 0;
                }
            }
            if (clinicas.get(posSgte) == null || pos == posSgte) {
                return -1;
            } else {
                return (posSgte);
            }
        }
    }

    public void imprimirClinicas() {
        for (int i = 0; i < clinicas.getTamanoMax(); i++) {
            if (clinicas.get(i) != null) {
                System.out.println(clinicas.get(i));
            }
        }
    }
    
    public void serializarPacientes(){
        //serializar listadepacientes
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/persistencia/pacientes"));
            os.writeObject(listaPacientes);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deserializarPacientes(){
        //usar metodo añadir paciente
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/persistencia/pacientes"));
            Clinica aux = (Clinica) is.readObject();
            Paciente[] pacientes = aux.getPacientes();
            for(Paciente p : pacientes){
                añadirPaciente(p);
                System.out.println(p.getClinica().getNombre());
            }
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean anadirClinica(Clinica clinica) {
        return clinicas.agregar(clinica, clinica.getNombre());
    }

    public boolean añadirMedico(String nombreClinica, Medico medico) {
        int indiceClinica = busquedaPruebaLineal(nombreClinica);
        if (indiceClinica >= clinicas.getTamanoMax() || indiceClinica == -1) {
            return false;
        }
        clinicas.get(indiceClinica).añadirMedico(medico);
        return true;
    }

    public boolean añadirPaciente(Paciente paciente) {
        String nombreClinica = paciente.getClinica().getNombre();
        Clinica clinicaAñadir = buscarClinica(nombreClinica);
        listaPacientes.añadirPaciente(paciente);
        clinicaAñadir.añadirPaciente(paciente);

        String codigo = paciente.getNumeroDoc();
        String nombres = paciente.getNombre();
        String apellidos = paciente.getApellidoP() + " " + paciente.getApellidoM();
        String edad = String.valueOf(paciente.getEdad());
        String sexo = paciente.getSexo();
        String estado = "vacunado";

        String[] datos = {codigo, nombres, apellidos, edad, sexo, estado};
        Excel.añadirFilaAExcel(datos, "src/persistencia/pacientes.xlsx");
        return true;
    }

    public void añadirAExcel(String[] informacion, String path) {
        Object[][] matrizAnterior = Excel.cargarExcel(path);
        Object[][] matriz = new Object[matrizAnterior.length + 1][matrizAnterior[0].length];
        int i, j;
        for (i = 0; i < matrizAnterior.length; i++) {
            for (j = 0; j < matrizAnterior[0].length + 1; j++) {
                matriz[i][j] = matrizAnterior[i][j];
            }
        }
        matriz[i] = informacion;
    }

    public Clinica[] toArray() {
        Clinica[] clinicas = new Clinica[this.clinicas.getCantidad()];
        int j = 0;
        for (int i = 0; i < this.clinicas.getTamanoMax(); i++) {
            if (this.clinicas.get(i) != null) {
                clinicas[j] = this.clinicas.get(i);
                j++;
            }
        }
        return clinicas;
    }

    public int getTamanoMax() {
        return clinicas.getTamanoMax();
    }

    public int getCantidadClinicas() {
        return clinicas.getCantidad();
    }

    public int getCantidadPacientes() {
        int totalPacientes = 0;
        for (Clinica c : toArray()) {
            totalPacientes += c.getNumPacientes();
        }
        return totalPacientes;
    }

    public Clinica[] getClinicasOrdenadas() {
        Clinica[] clinicas = toArray();
        //ordenamiento de clinicas segun coeficiente
        quicksort(clinicas, 0, clinicas.length - 1);

        return clinicas;
    }

    private void quicksort(Clinica A[], int izq, int der) {
        Clinica pivote = A[izq];
        int i = izq;
        int j = der;
        Clinica aux;

        while (i < j) {
            while (A[i].calcularCoeficiente() <= pivote.calcularCoeficiente() && i < j) {
                i++;
            }
            while (A[j].calcularCoeficiente() > pivote.calcularCoeficiente()) {
                j--;
            }
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];
        A[j] = pivote;

        if (izq < j - 1) {
            quicksort(A, izq, j - 1);
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der);
        }
    }
    
    public Clinica getClinicaListaPacientes(){
        return listaPacientes;
    }

}
