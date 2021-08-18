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
public class Vacuna {
    private String codigoVacuna;
    private String descripcionVacuna;
    private String laboratorio;
    private int stock;
    private String fechaVencimiento;

    public Vacuna(String codigoVacuna, String descripcionVacuna, String laboratorio, int stock, String fechaVencimiento) {
        this.codigoVacuna = codigoVacuna;
        this.descripcionVacuna = descripcionVacuna;
        this.laboratorio = laboratorio;
        this.stock = stock;
        this.fechaVencimiento = fechaVencimiento;
    }

    
}
