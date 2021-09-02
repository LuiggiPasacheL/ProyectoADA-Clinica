/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Credenciales;
import general.Datos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vista.FrmAdministrador;
import static vista.FrmDetalles.form;
import vista.FrmLogin;
import vista.FrmRecuperarDatos;
import vista.TextPrompt;

/**
 *
 * @author luigg
 */
public class CtrlLogin implements Serializable {

    FrmLogin vista;
    Credenciales credenciales = new Credenciales();

    public CtrlLogin(FrmLogin vista) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        this.vista = vista;
      
        
        
        this.vista.btnAcceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                credenciales.username = vista.txtUsername.getText();
                credenciales.guardar = vista.chkRecordar.isSelected();

                if (vista.txtUsername.getText().equals("") || vista.txtPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(vista, "Ingreso de Datos", "Falta completar campos", 2);
                    return;
                }
                for (int i = 0; i < Datos.usuarios.getTamaño(); i++) {
                    if (Datos.usuarios.getGenerico()[i].ingresar(vista.txtUsername.getText(),
                            vista.txtPassword.getText())) {

                        if (credenciales.guardar) {
                            credenciales.serializar();
                        }else{
                            credenciales.borrarSerial();
                        }
                        vista.dispose();
                        FrmAdministrador vista = new FrmAdministrador();
                        CtrlAdministrador controlador = new CtrlAdministrador(vista);
                        controlador.iniciar();

                        //     limpiar();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(vista, "vuelva a intentarlo");
                    }
                }

            }
        });

        this.vista.btnRecuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FrmRecuperarDatos vista = new FrmRecuperarDatos();
                CtrlFrmRecuperarDatos controlador;
                try {
                    controlador = new CtrlFrmRecuperarDatos(vista);
                    controlador.iniciar(); 
                } catch (Exception ex) {
                    Logger.getLogger(CtrlLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
    }
    
    public void properties(){
        
        /*TextPrompt t1 = new TextPrompt("USERNAME",vista.txtUsername);
        TextPrompt t2 = new TextPrompt("PASSWORD",vista.txtPassword);*/
    }

    public void iniciar() {
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        credenciales.deserializar();
        properties();
        if (credenciales.guardar) {
            this.vista.txtUsername.setText(credenciales.username);
            this.vista.chkRecordar.setSelected(credenciales.guardar);
            this.vista.txtUsername.transferFocus();
        }
    }

}
