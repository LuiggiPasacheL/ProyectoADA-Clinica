/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * @author nick paredes
 */
public class HashTableClinica {
    private HashTable<Clinica> clinicas;

    public HashTableClinica(int tamano){
        clinicas = new HashTable<>(tamano);
    }

    public Clinica buscarClinica(String clinica){
        Clinica result = null;
        int pos = clinicas.hash(clinica);
        int posSgte;
        result = clinicas.get(pos);
        if(result.getNombre().equals(clinica))
            return result;
        else{
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
    
    public int busquedaPruebaLineal(String nombreClinica){
        Clinica result = null;
        int pos = clinicas.hash(nombreClinica);
        int posSgte;
        result = clinicas.get(pos);
        if(result.getNombre().equals(nombreClinica))
            return pos;
        else{
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
            if (clinicas.get(i) != null)
                System.out.println(clinicas.get(i));
        }
    }
    
    public String[] getStringClinicas(){
        String[] resultado = new String[clinicas.getCantidad()];
        int j = 0;
        for(int i = 0; i < clinicas.getTamanoMax(); i++){
            if(clinicas.get(i) != null){
                resultado[j] = clinicas.get(i).getNombre();
                j++;
            }
        }
        return resultado;
    }

    public boolean anadirClinica(Clinica clinica){
        return clinicas.agregar(clinica, clinica.getNombre());
    }

    public boolean añadirMedico(String nombreClinica, Medico medico){
        int indiceClinica = busquedaPruebaLineal(nombreClinica);
        if(indiceClinica >= clinicas.getTamanoMax()){
            return false;
        }
        clinicas.get(indiceClinica).añadirMedico(medico);
        return true;
    }

    public boolean añadirPaciente(String nombreClinica, Paciente paciente){
        int indiceClinica = busquedaPruebaLineal(nombreClinica);
        if(indiceClinica >= clinicas.getTamanoMax()){
            return false;
        }
        clinicas.get(indiceClinica).añadirPaciente(paciente);
        return true;
    }

    public Clinica[] toArray() {
        Clinica[] clinicas = new Clinica[this.clinicas.getTamanoMax()];
        for (int i = 0; i < this.clinicas.getTamanoMax(); i++) {
            if (this.clinicas.get(i) != null)
                clinicas[this.clinicas.get(i).getIdentificador() - 1] = this.clinicas.get(i);
        }
        return clinicas;
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