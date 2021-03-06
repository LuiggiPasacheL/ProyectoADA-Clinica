/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelo.Paciente;
import util.ExportarPDF;
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
                ExportarPDF pdf = new ExportarPDF();
                FrmAdministrador fAdministrador = new FrmAdministrador();
                CtrlAdministrador cAdministrador = new CtrlAdministrador(fAdministrador);
                pdf.generarPDF(vista.tHospital.getText().toString(), vista.tHora.getText().toString(), 
                        vista.tCodigoRegistro.getText().toString(), vista.txtNombre.getText().toString(),
                        vista.txtDNI.getText().toString());
                JOptionPane.showMessageDialog(vista, "Operacion exitosa");
                cAdministrador.iniciar();  
                vista.dispose();
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
        vista.tCodigoRegistro.setText(modelo.getNumeroDoc());
    }
    
    public String calcularHora(){
        LocalDateTime locaDate = LocalDateTime.now();
        int horas = locaDate.getHour();
        int minutos = locaDate.getMinute();
        int segundos = locaDate.getSecond();
        return horas  + ":"+ minutos +":"+ segundos;
    }

}
