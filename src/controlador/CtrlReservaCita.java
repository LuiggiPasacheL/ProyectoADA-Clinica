package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Persona;
import vista.FrmInfoLugar;
import vista.FrmReservaCita;
import vista.Ticket;

public class CtrlReservaCita {

    FrmReservaCita vista;
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
                    Paciente paciente = new Paciente("codigo", Integer.valueOf(vista.txtEdad.getText()),
                             vista.txtNombres.getText(), vista.txtPaterno.getText(),
                            vista.txtMaterno.getText(), vista.cbxSexo.getSelectedItem().toString(),
                            vista.txtCorreo.getText(), vista.txtNumDocumento.getText(),
                            vista.cbxDocumento.getSelectedItem().toString(), vista.txtDireccion.getText(),
                            vista.txtCel.getText());

                    Datos.colaPrioridad.agregar(paciente, Integer.parseInt(vista.txtEdad.getText()));

                    String nombreClinica = (String) vista.CboClinicas.getSelectedItem();

                    if (nombreClinica == null) {
                        JOptionPane.showMessageDialog(vista, "No se selecciono ninguna clinica", "ERROR", 1);
                        return;
                    }

                    Datos.clinicas.añadirPaciente(nombreClinica, paciente);
                    //  JOptionPane.showMessageDialog(null, "Cita reservada");
                    vista.dispose();
                    Ticket ticket = new Ticket();
                    CtrlTicket cTicket = new CtrlTicket(paciente, nombreClinica, ticket);
                    cTicket.iniciar();
//                    FrmAdministrador fAdministrador = new FrmAdministrador();
//                    CtrlAdministrador cAdministrador = new CtrlAdministrador(fAdministrador);
//                    cAdministrador.iniciar();

                } catch (Exception ex) {
                    ex.printStackTrace();
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
        probarReserva();
    }

    public void CargarCombo() {
        String[] arreglo = {"DNI", "Pasaporte"},
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
        vista.txtEdad.setText("");
    }
    
    public void probarReserva(){ //TODO borrar luego de las pruebas
        vista.txtCel.setText("9873037194");
        vista.txtCorreo.setText("asd@gmail.com");
        vista.txtDireccion.setText("direccion de prueba");
        vista.txtNombres.setText("wasd wasd");
        vista.txtPaterno.setText("asd");
        vista.txtMaterno.setText("asdasd");
        vista.txtNumDocumento.setText("11236489");
        vista.txtEdad.setText("21");
    }
}
