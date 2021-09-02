/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author nick paredes
 */
public class HashTableClinica {

    private HashTable<Clinica> clinicas;

    public HashTableClinica(int tamano) {
        clinicas = new HashTable<>(tamano);
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

    /*public Clinica[] getClinicas() {
        ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
        Clinica[] dispersion = this.clinicas.getArreglo();
        for(Clinica c: dispersion){
            if(c != null){
                clinicas.add(c);
            }
        }
        Clinica[] result = new Clinica[clinicas.size()];
        clinicas.toArray(result);
        Arrays.sort(result);
        return result;
    }*/
        
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

    public boolean añadirPaciente(String nombreClinica, Paciente paciente) {
        int indiceClinica = busquedaPruebaLineal(nombreClinica);
        if (indiceClinica >= clinicas.getTamanoMax()) {
            return false;
        }
        clinicas.get(indiceClinica).añadirPaciente(paciente);
        //TODO añadir paciente en el excel de pacientes
        String codigo = "codigo";
        String nombres = paciente.getNombre();
        String apellidos = paciente.getApellidoP() + " " + paciente.getApellidoM();
        String edad = String.valueOf(paciente.getEdad());
        String sexo = paciente.getSexo();
        String estado = "vacunado";

        String[] datos = {codigo, nombres, apellidos, edad, sexo, estado};
        Excel.añadirFilaAExcel(datos, "src/general/pacientes.xlsx");
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

    public Object[][] getPacientes() {
        int cantidadPacientes = 0;
        Clinica[] aux = (Clinica[]) clinicas.toArray();
        for (int i = 0; i < aux.length; i++) {
            cantidadPacientes += aux[i].getNumPacientes();
        }
        Object[][] pacientes = new Object[4][cantidadPacientes];

        return pacientes;
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
//
//    private Clinica[] dispersionClinicas;
//    private int numClinicas;
//    private int dimension;
//    private int numColisiones;
//
//    public HashTableClinica(int dimension) {
//        this.dimension = dimension;
//        this.numClinicas = 0;
//        this.numColisiones = 0;
//        dispersionClinicas = new Clinica[dimension];
//    }
//
//    public Clinica buscarCLinica(String Clinica) {
//        Clinica result = null;
//        int pos = funcionHash(Clinica);
//        result = dispersionClinicas[pos];
//        //TODO definir caso de colision
//        return result;
//    }
//
//    public void imprimirClinicas() {
//        for (int i = 0; i < dispersionClinicas.length; i++) {
//            if (dispersionClinicas[i] != null)
//                System.out.println(dispersionClinicas[i]);
//        }
//    }
//
//    public boolean agregarClinica(Clinica clinica) {
//        boolean result = false;
//        int pos = funcionHash(clinica.getNombre());
//        if (this.dispersionClinicas[pos] == null) {
//            this.dispersionClinicas[pos] = clinica;
//            this.numClinicas++;
//            result = true;
//        } else {
//            int k = 0;
//            this.numColisiones++;
//            //Resolucion de colision lineal
//            while (!result && this.dispersionClinicas[pos] != null && this.dimension >= k) {
//                pos++;
//
//                //System.out.println("valor de k: " + k);
//                if (pos == dimension) {
//                    pos = 0;
//                }
//
//                if (this.dispersionClinicas[pos] == null) {
//                    dispersionClinicas[pos] = clinica;
//                    result = true;
//                    this.numClinicas++;
//                }
//                k++;
//            }
//        }
//        return result;
//    }
//
//
//    private int funcionHash(String nombre) {
//        int c = 0;
//        for (int i = 0; i < nombre.length(); i++) {
//            c += nombre.charAt(i);
//        }
//        return (int) (c * Math.E) % this.dimension;
//    }
//
//    public Clinica[] toArray() {
//        Clinica[] clinicas = new Clinica[numClinicas];
//        for (int i = 0; i < this.dispersionClinicas.length; i++) {
//            if (dispersionClinicas[i] != null)
//                clinicas[dispersionClinicas[i].getIdentificador() - 1] = dispersionClinicas[i];
//        }
//        return clinicas;
//    }
//
//    public Clinica[] getDispersionClinicas() {
//        return dispersionClinicas;
//    }
//
//    public void setDispersionClinicas(Clinica[] dispersionClinicas) {
//        this.dispersionClinicas = dispersionClinicas;
//    }
//
//    public int getNumClinicas() {
//        return numClinicas;
//    }
//
//    public void setNumClinicas(int numClinicas) {
//        this.numClinicas = numClinicas;
//    }
//
//    public int getDimension() {
//        return dimension;
//    }
//
//    public void setDimension(int dimension) {
//        this.dimension = dimension;
//    }
//
//    public int getNumColisiones() {
//        return numColisiones;
//    }
//
//    public void setNumColisiones(int numColisiones) {
//        this.numColisiones = numColisiones;
//    }

}
