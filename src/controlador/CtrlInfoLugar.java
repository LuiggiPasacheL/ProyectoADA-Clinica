/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Clinica;
import vista.FrmInfoLugar;
import vista.FrmReservaCita;


class CtrlInfoLugar {
    FrmInfoLugar vista;
    Clinica modelo;

    public CtrlInfoLugar(Clinica modelo, FrmInfoLugar vista, FrmReservaCita vistaAnterior) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();
                vistaAnterior.setVisible(true);
            }
        });
    }
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        vista.lblNombreClinica.setText("<html><h1>"+modelo.getNombre()+"</h1></html>");
        vista.jlbDocDis.setText(String.valueOf(modelo.getNumMedicos()));
        vista.jlbPacientesTotal.setText(String.valueOf(modelo.getNumPacientes()));
        vista.jlbPlazasDispo.setText(String.valueOf(modelo.getAforo() - modelo.getNumPacientes()));
    }
}
