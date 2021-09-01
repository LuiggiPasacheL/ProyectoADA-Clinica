/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmAdministrador;
import vista.FrmReservaCita;
import vista.FrmTablaDePacientes;

/**
 *
 * @author luigg
 */
public class CtrlAdministrador {
    FrmAdministrador vista;

    public CtrlAdministrador(FrmAdministrador vista) {
       
        this.vista = vista;
        
        this.vista.btnReserCita.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
                vista.dispose();
                FrmReservaCita fReservaCita = new FrmReservaCita();
                CtrlReservaCita cReservaCita = new CtrlReservaCita(fReservaCita);
                cReservaCita.Iniciar();
            }
            
        });
        
        this.vista.btnTabla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                FrmTablaDePacientes fTablaDePacientes = new FrmTablaDePacientes();
                CtrlVerPaciente cVerPaciente = new CtrlVerPaciente(fTablaDePacientes);                
                cVerPaciente.Iniciar();
            }            
        });
    }
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
