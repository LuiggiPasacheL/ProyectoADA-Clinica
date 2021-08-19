/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.FrmLogin;

/**
 *
 * @author luigg
 */
public class ControladorEjemplo {

    String modelo;
    FrmLogin vista;

    public ControladorEjemplo(String modelo, FrmLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    //agregar mas metodos aca
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
