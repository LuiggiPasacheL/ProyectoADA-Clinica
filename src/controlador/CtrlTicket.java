/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import modelo.Paciente;
import vista.FrmAdministrador;
import vista.Ticket;

public class CtrlTicket {

    String nombreClinica;
    Paciente modelo;
    Ticket vista;

    public CtrlTicket(Paciente modelo, String nombreClinica, Ticket vista) {
        this.nombreClinica = nombreClinica;
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();
                FrmAdministrador fAdministrador = new FrmAdministrador();
                CtrlAdministrador cAdministrador = new CtrlAdministrador(fAdministrador);
                cAdministrador.iniciar();
            }
        });
    }

    public void iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        agregarDatos();
    }

    public void agregarDatos() {
        String nombreCompleto = modelo.getNombre();
        String apellidos = modelo.getApellidoP() + " " + modelo.getApellidoM();
        String horaActual = calcularHora();
        
        vista.tHospital.setText(nombreClinica);
        vista.txtNombre.setText(nombreCompleto + " " + apellidos);
        vista.txtDNI.setText(modelo.getNumeroDoc());
        vista.tTipoDoc.setText(modelo.getTipo()+":");
        vista.tHora.setText(horaActual);
        vista.tCodigoRegistro.setText("------");
    }
    
    public String calcularHora(){
        LocalDateTime locaDate = LocalDateTime.now();
        int horas = locaDate.getHour();
        int minutos = locaDate.getMinute();
        int segundos = locaDate.getSecond();
        return horas  + ":"+ minutos +":"+ segundos;
    }

}
