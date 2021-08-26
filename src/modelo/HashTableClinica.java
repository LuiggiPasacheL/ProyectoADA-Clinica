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
    private Clinica[] dispersionClinicas;
    private int numClinicas;
    private int dimension;
    private int numColisiones;

    public HashTableClinica(int dimension) {
        this.dimension = dimension;
        this.numClinicas = 0;
        this.numColisiones = 0;
        dispersionClinicas = new Clinica[dimension];
    }

    public Clinica buscarCLinica(String Clinica) {
        Clinica result = null;
        int pos = funcionHash(Clinica);
        result = dispersionClinicas[pos];
        //TODO definir caso de colision
        return result;
    }

    public void imprimirClinicas() {
        for (int i = 0; i < dispersionClinicas.length; i++) {
            if (dispersionClinicas[i] != null)
                System.out.println(dispersionClinicas[i]);
        }
    }

    public boolean agregarClinica(Clinica clinica) {
        boolean result = false;
        int pos = funcionHash(clinica.getNombre());
        if (this.dispersionClinicas[pos] == null) {
            this.dispersionClinicas[pos] = clinica;
            this.numClinicas++;
            result = true;
        } else {
            int k = 0;
            this.numColisiones++;
            //Resolucion de colision lineal
            while (!result && this.dispersionClinicas[pos] != null && this.dimension >= k) {
                pos++;

                //System.out.println("valor de k: " + k);
                if (pos == dimension) {
                    pos = 0;
                }

                if (this.dispersionClinicas[pos] == null) {
                    dispersionClinicas[pos] = clinica;
                    result = true;
                    this.numClinicas++;
                }
                k++;
            }
        }
        return result;
    }


    private int funcionHash(String nombre) {
        int c = 0;
        for (int i = 0; i < nombre.length(); i++) {
            c += nombre.charAt(i);
        }
        return (int) (c * Math.E) % this.dimension;
    }

    public Clinica[] toArray() {
        Clinica[] clinicas = new Clinica[numClinicas];
        for (int i = 0; i < this.dispersionClinicas.length; i++) {
            if (dispersionClinicas[i] != null)
                clinicas[dispersionClinicas[i].getIdentificador() - 1] = dispersionClinicas[i];
        }
        return clinicas;
    }

    public Clinica[] getDispersionClinicas() {
        return dispersionClinicas;
    }

    public void setDispersionClinicas(Clinica[] dispersionClinicas) {
        this.dispersionClinicas = dispersionClinicas;
    }

    public int getNumClinicas() {
        return numClinicas;
    }

    public void setNumClinicas(int numClinicas) {
        this.numClinicas = numClinicas;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getNumColisiones() {
        return numColisiones;
    }

    public void setNumColisiones(int numColisiones) {
        this.numColisiones = numColisiones;
    }


}
