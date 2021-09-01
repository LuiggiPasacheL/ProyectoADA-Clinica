package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Clinica;
import modelo.Documento;
import modelo.Paciente;
import modelo.Persona;
import vista.FrmInfoLugar;
import vista.FrmLugares;
import vista.FrmReservaCita;

public class CtrlReservaCita {

    FrmReservaCita vista;
    Documento modelo2 = new Documento();
    Persona modelo3 = new Persona();
    // = new Persona();

    public CtrlReservaCita(FrmReservaCita vista) {
        this.vista = vista;

        this.vista.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LimpiarControles();
            }

        });
        this.vista.btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Paciente paciente = new Paciente("codigo", vista.txtEdad.getText(), vista.txtNombres.getText(),
                            vista.txtPaterno.getText(), vista.txtMaterno.getText(), vista.cbxSexo.getSelectedItem().toString(),
                            vista.txtCorreo.getText(), vista.txtNumDocumento.getText(),
                            vista.cbxDocumento.getSelectedItem().toString(), vista.txtDireccion.getText(),
                            vista.txtCel.getText(), false);
                    Datos.colaPrioridad.agregar(paciente, Integer.valueOf(vista.txtEdad.getText()));

                    String nombreClinica = (String) vista.CboClinicas.getSelectedItem();

                    if (nombreClinica == null) {
                        JOptionPane.showMessageDialog(vista, "No se selecciono ninguna clinica", "ERROR", 1);
                        return;
                    }

                    Datos.clinicas.añadirPaciente(nombreClinica, paciente);
                    //  JOptionPane.showMessageDialog(null, "Cita reservada");
                    vista.dispose();

                    FrmLugares vistaLug = new FrmLugares();
                    CtrlLugares controladorLug = new CtrlLugares(vistaLug);
                    controladorLug.Iniciar();

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });

        this.vista.btnMasInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombreClinica = (String) vista.CboClinicas.getSelectedItem();

                if (nombreClinica == null) {
                    JOptionPane.showMessageDialog(vista, "No se selecciono ninguna clinica", "ERROR", 1);
                    return;
                }
                
                Clinica infoClinica = Datos.clinicas.buscarClinica(nombreClinica);
                
                vista.setVisible(false);
                FrmInfoLugar fInfoLugar = new FrmInfoLugar();
                CtrlInfoLugar cInfoLugar = new CtrlInfoLugar(infoClinica, fInfoLugar, vista);
                cInfoLugar.iniciar();
            }
        });
    }

    public void Iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        CargarCombo();
    }

    public void CargarCombo() {
        String[] arreglo = modelo2.TiposDeDocumentos(),
                arreglo2 = modelo3.ListarSexo(), arreglo3 = Datos.clinicas.getStringClinicas();
        try {
            for (String a : arreglo) {
                this.vista.cbxDocumento.addItem(a);
            }
            for (String b : arreglo2) {
                this.vista.cbxSexo.addItem(b);
            }
            for (String c : arreglo3) {
                this.vista.CboClinicas.addItem(c);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void CargarComboClinicas() {
        String[] arreglo3 = Datos.clinicas.getStringClinicas();
        for (String c : arreglo3) {
            this.vista.CboClinicas.addItem(c);
        }
    }

    public void LimpiarControles() {
        vista.txtCel.setText("");
        vista.txtCorreo.setText("");
        vista.txtDireccion.setText("");
        vista.txtNombres.setText("");
        vista.txtPaterno.setText("");
        vista.txtMaterno.setText("");
        vista.txtNumDocumento.setText("");
    }
}
