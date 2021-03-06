/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Datos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.Email;
import vista.FrmRecuperarDatos;
import vista.TextPrompt;

public class CtrlRecuperarDatos {

    FrmRecuperarDatos vista;

    public CtrlRecuperarDatos(FrmRecuperarDatos vista) throws Exception {
        this.vista = vista;
        Properties();

        this.vista.btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String correo = vista.txtRecuperar.getText();
                try {
                    Datos.validarDatos(correo, "[a-zA-Z0-9 | \\. ]+\\@[a-z]+.com", "Introduzca un correo valido");

                    boolean encontrado = false;
                    for (int i = 0; i < Datos.usuarios.getTamaño(); i++) {

                        if (correo.equals(Datos.usuarios.getGenerico()[i].getCorreo())) {
                            String mensaje = "Adjuntamos sus credenciales\n";
                            mensaje += "TRABAJADOR: " + Datos.usuarios.getGenerico()[i].getNombre() + " "
                                    + Datos.usuarios.getGenerico()[i].getApellidoP() + " "
                                    + Datos.usuarios.getGenerico()[i].getApellidoM() + "\nUsuario: " + Datos.usuarios.getGenerico()[i].getUsername() + "\nContraseña: "
                                    + Datos.usuarios.getGenerico()[i].getContrasena();

                            Email.enviarEmail(correo, "correo", mensaje);

                            encontrado = true;

                        }

                    }

                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "Sus credenciales se enviaron a su correo", "Correo enviado", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "El correo no está asociado a ningún trabajador", "No encontrado", 2);
                    }
                    vista.dispose();
                } catch (Exception ex) {

                }

            }
        });

    }

    public void Properties() {
        Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
        vista.setBounds(p.width * 60 / 200, p.height * 60 / 200, p.width * 30 / 100, p.height * 40 / 100);
        vista.setResizable(false);
        vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TextPrompt prueba2 = new TextPrompt("Digite el coorreo electrónico de recuperación", vista.txtRecuperar);

    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
