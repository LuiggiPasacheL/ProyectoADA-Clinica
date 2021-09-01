/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import vista.FrmLugares;

/**
 *
 * @author nick paredes
 */
public class CtrlLugares {
    FrmLugares vista;
    
    public CtrlLugares(FrmLugares vista){
    
        this.vista = vista;
        
    }
    
    public void Iniciar(){        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}
