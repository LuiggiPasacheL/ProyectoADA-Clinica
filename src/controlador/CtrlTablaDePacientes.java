/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.Clinica;
import modelo.Paciente;
import util.ExportarPDF;
import vista.FrmAdministrador;
import vista.FrmDetalles;
import vista.FrmTablaDePacientes;

public class CtrlTablaDePacientes {

    FrmTablaDePacientes vista;
    Object[][] tablaVista;
    Paciente[] todosLosPacientes;
    Clinica c;

    public CtrlTablaDePacientes(FrmTablaDePacientes vista) {
        c = Datos.clinicas.getClinicaListaPacientes();
        todosLosPacientes = c.getPacientes();
        this.vista = vista;
        cargarComponentes();

        this.vista.btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vista.dispose();
                FrmAdministrador vista = new FrmAdministrador();
                CtrlAdministrador controlador = new CtrlAdministrador(vista);
                controlador.iniciar();
            }
        });

        vista.txtCodigoPaciente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Clinica c = (Clinica) vista.box.getSelectedItem();
                Paciente[] pacientes = c.getPacientes();
                Paciente[] encontrados = new Paciente[pacientes.length];
                String cod = vista.txtCodigoPaciente.getText();
                if (cod.length() != 0) {
                    int j = 0;
                    for (Paciente p : pacientes) {
                        System.out.println(p.getCodigo().substring(0, cod.length() + 1));
                        if (p.getCodigo().substring(0, cod.length()).equals(cod)) {
                            encontrados[j] = (p);
                            j++;
                        }
                    }
                    cargarTabla(encontrados, j);
                } else {
                    cargarTabla(pacientes, pacientes.length);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Clinica c = (Clinica) vista.box.getSelectedItem();
                Paciente[] pacientes = c.getPacientes();
                Paciente[] encontrados = new Paciente[pacientes.length];

                String cod = vista.txtCodigoPaciente.getText();
                if (cod.length() != 0) {
                    int j = 0;
                    for (Paciente p : pacientes) {
                        System.out.println(p.getCodigo().substring(0, cod.length() + 1));
                        if (p.getCodigo().substring(0, cod.length()).equals(cod)) {
                            encontrados[j] = (p);
                            j++;
                        }
                    }
                    cargarTabla(encontrados, c.getNumPacientes());
                } else {
                    cargarTabla(pacientes, pacientes.length);
                }
            }

        });

        this.vista.box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Paciente[] encontrados;
                if (vista.box.getSelectedIndex() == 0) {
                    cargarTabla(todosLosPacientes, todosLosPacientes.length);
                } else {
                    Clinica c = (Clinica) vista.box.getSelectedItem();
                    encontrados = c.getPacientes();
                    cargarTabla(encontrados, c.getNumPacientes());
                }
            }
        });

//        vista.buscar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Paciente[] encontrados;
//                if (vista.box.getSelectedIndex() == 0) {
//                    cargarTabla(todosLosPacientes, todosLosPacientes.length);
//                } else {
//                    Clinica c = (Clinica) vista.box.getSelectedItem();
//                    encontrados = c.getPacientes();
//                    cargarTabla(encontrados, c.getNumPacientes());
//                }
//
//            }
//
//        });
        this.vista.btnDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.Tabla.getSelectedRow() < 0) {
                    return;
                }
                CtrlFrmDetalles ctrl = new CtrlFrmDetalles(new FrmDetalles());
            }

        });

    }

    public void Iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        cargarTabla(todosLosPacientes, todosLosPacientes.length);
    }

    private void cargarTabla(Paciente[] cargar, int numeroDatos) {
        Object[] datos[] = new Object[numeroDatos][6];
        for (int i = 0; i < numeroDatos; i++) {
            if (cargar[i] != null) {
                datos[i][0] = cargar[i].getCodigo();
                datos[i][1] = cargar[i].getNombre();
                datos[i][2] = cargar[i].getApellidoP() + " " + cargar[i].getApellidoM();
                datos[i][3] = cargar[i].getEdad();
                datos[i][4] = cargar[i].getSexo();
                datos[i][5] = cargar[i].getClinica().getNombre();
            }
        }
        Object[] column = {"CODIGO", "NOMBRES", "APELLIDOS", "EDAD", "SEXO", "CLINICA"};
        DefaultTableModel tabla = new DefaultTableModel(datos, column) {
            public boolean isCellEditable(int rowm, int column) {
                return false;
            }
        };
//        this.vista.Tabla.setModel(new DefaultTableModel(datos, column));
        this.vista.Tabla.setModel(tabla);

    }

    private void cargarComponentes() {
        Clinica[] c = Datos.clinicas.toArray();
        this.vista.box.addItem(Datos.clinicas.getClinicaListaPacientes());
        for (Clinica clinica : c) {
            this.vista.box.addItem(clinica);
        }
    }

    public class CtrlFrmDetalles {

        private boolean isAbierto = false;
        private FrmDetalles vs;
        private Paciente paciente;

        public CtrlFrmDetalles(FrmDetalles vs) {
            this.vs = vs;
            this.paciente = obtenerPaciente((String) vista.Tabla.getValueAt(vista.Tabla.getSelectedRow(), 0));
            propiedades();
            funcionalidadTextArea();
            vs.btnAtras.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Date date = new Date();
                    ExportarPDF ePDF = new ExportarPDF();
                    ePDF.generarInforme(paciente.getNombre() + " " + paciente.getApellidoP() + " " + paciente.getApellidoM(), paciente.getEdad(), paciente.getSexo(),
                            paciente.getCodigo(), paciente.getCorreo(), paciente.getTipo(), paciente.getNumeroDoc(), paciente.getDireccion(),
                            paciente.getCelular(), String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(date) + " - " + new SimpleDateFormat("HH:mm:ss").format(date)));
                }
            });
        }

        private void propiedades() {
            vs.setVisible(true);
            vs.setLocationRelativeTo(null);
            vs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        private void funcionalidadTextArea() {
            Date date = new Date();
            vs.txtAreaDetalles.setText("\t\tREPORTE DEL PACIENTE\n\nPciente: " + paciente.getNombre() + " " + paciente.getApellidoP() + " " + paciente.getApellidoM()
                    + "\nEdad: " + paciente.getEdad() + "\nSexo: " + paciente.getSexo() + "\n"
                    + "\nCódigo: " + paciente.getCodigo() + "\nCorreo: " + paciente.getCorreo() + "\n"
                    + "\nTipo: " + paciente.getTipo() + "\nNumero: " + paciente.getNumeroDoc() + "\n"
                    + "\nDireccion: " + paciente.getTipo() + "\nCelular: " + paciente.getNumeroDoc() + "\n"
                    + new SimpleDateFormat("dd/MM/yyyy").format(date) + " - " + new SimpleDateFormat("HH:mm:ss").format(date));
        }

        public void iniciar() {
            this.vs.setVisible(true);
            this.vs.setLocationRelativeTo(null);
        }

        private Paciente obtenerPaciente(String codigo) {
            for (Paciente p : todosLosPacientes) {
                if (p.getCodigo().equals(codigo)) {
                    return p;
                }
            }
            return null;
        }
    }

}
