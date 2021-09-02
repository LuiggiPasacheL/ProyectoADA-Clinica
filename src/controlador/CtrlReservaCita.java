package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Persona;
import vista.FrmAdministrador;
import vista.FrmInfoLugar;
import vista.FrmReservaCita;
import vista.TextPrompt;
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
                    Paciente paciente = new Paciente(vista.txtNumDocumento.getText(), Integer.valueOf(vista.txtEdad.getText()),
                            vista.txtNombres.getText(), vista.txtPaterno.getText(),
                            vista.txtMaterno.getText(), vista.cbxSexo.getSelectedItem().toString(),
                            vista.txtCorreo.getText(), vista.txtNumDocumento.getText(),
                            vista.cbxDocumento.getSelectedItem().toString(), vista.txtDireccion.getText(),
                            vista.txtCel.getText(), (Clinica) vista.CboClinicas.getSelectedItem());

                    Datos.colaPrioridad.agregar(paciente, Integer.parseInt(vista.txtEdad.getText()));
                    Datos.clinicas.añadirPaciente(vista.CboClinicas.getSelectedItem().toString(), paciente);

                    //Datos.clinicas.añadirPaciente(nombreClinica, paciente);
                    Object row[] = {paciente.getCodigo(), paciente.getNombre(), paciente.getApellidoP() + " " + paciente.getApellidoM(), paciente.getEdad(), paciente.getSexo(), ""};
                    Datos.data.add(row);
                    Datos.pacientes.add(paciente);
                    Datos.serializar();

                    //  JOptionPane.showMessageDialog(null, "Cita reservada");
                    vista.dispose();
                    Ticket ticket = new Ticket();
                    CtrlTicket cTicket = new CtrlTicket(paciente, paciente.getClinica().getNombre(), ticket);
                    cTicket.iniciar();
//                    FrmAdministrador fAdministrador = new FrmAdministrador();
//                    CtrlAdministrador cAdministrador = new CtrlAdministrador(fAdministrador);
//                    cAdministrador.iniciar();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(vista, "llene todos los campos");
                }

            }
        });

        this.vista.btnMasInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nombreClinica = (String) vista.CboClinicas.getSelectedItem().toString();

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

        this.vista.btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();
                FrmAdministrador vista = new FrmAdministrador();
                CtrlAdministrador controlador = new CtrlAdministrador(vista);
                controlador.iniciar();
            }
        });

    }

    public void Iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

        /*TextPrompt t1 = new TextPrompt("CELULAR",vista.txtCel);
        TextPrompt t2 = new TextPrompt("CORREO ELECTRONICO",vista.txtCorreo);
        TextPrompt t3 = new TextPrompt("DIRECCION",vista.txtDireccion);
        TextPrompt t4 = new TextPrompt("EDAD",vista.txtEdad);
        TextPrompt t5 = new TextPrompt("APELLIDO MATERNO",vista.txtMaterno);
        TextPrompt t6 = new TextPrompt("NOMBRES",vista.txtNombres);
        TextPrompt t7 = new TextPrompt("DNI/PASAPORTE",vista.txtNumDocumento);
        TextPrompt t8 = new TextPrompt("APELLIDO PATERNO",vista.txtPaterno);*/
        CargarCombo();
    }

    public void CargarCombo() {
        String[] arreglo = {"DNI", "Pasaporte"},
                arreglo2 = modelo3.ListarSexo();
        Clinica[] arreglo3 = Datos.clinicas.getClinicasOrdenadas();

//        Clinica[] arreglo3 = Datos.clinicas.toArray();
        try {
            for (String a : arreglo) {
                this.vista.cbxDocumento.addItem(a);
            }
            for (String b : arreglo2) {
                this.vista.cbxSexo.addItem(b);
            }
            for( Clinica c: arreglo3){
                this.vista.CboClinicas.addItem(c);
            }

//            for (Clinica c : arreglo3) {
//                this.vista.CboClinicas.addItem(c);
//            }
        } catch (Exception ex) {
            System.out.println(ex);
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
