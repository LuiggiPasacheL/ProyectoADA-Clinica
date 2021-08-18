/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author luigg
 */
public class Cita {
    
    private String codigoCita;

    public Cita(String codigoCita) {
        this.codigoCita = codigoCita;
    }
    
    public boolean validarDosis(){
       return false; 
    }
    
    public boolean validarFecha(){
        return false;
    }
    
    public boolean validarLocal(){
        return false;
    }
}
