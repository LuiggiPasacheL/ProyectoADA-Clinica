/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.Usuario;
import modelo.UsuarioArreglo;
import vista.FrmAdministrador;
import vista.FrmLogin;

/**
 *
 * @author luigg
 */
public class CtrlLogin {
    
    FrmLogin vista;

    public CtrlLogin( FrmLogin vista) {
       
        
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
            
            } 
        this.vista = vista;
        this.vista.btnAcceder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                if(vista.txtUsername.getText().equals("") || vista.txtPassword.getText().equals("")){
                    JOptionPane.showMessageDialog(vista, "Ingreso de Datos","Falta completar campos" , 2);
                    return;
                }
                for(int i=0; i<Datos.usuarios.getTamaño();i++){
                   if(Datos.usuarios.getGenerico()[i].ingresar(vista.txtUsername.getText(),vista.txtPassword.getText())){
                       vista.dispose();
                       FrmAdministrador vista = new FrmAdministrador();
                       CtrlAdministrador controlador = new CtrlAdministrador(vista);
                       controlador.iniciar();
                       
                        //     limpiar();
                       break;
                   }else{
                       JOptionPane.showMessageDialog(vista, "vuelva a intentarlo");
                   }
               }
                
            }
        });
        
        this.vista.btnRecuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(vista, "recuperando", "recuperando", 1 );
            }
        });
    }
    
    
    
    public void iniciar(){
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
}
