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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Clinica;
import modelo.Paciente;
import util.Sort;
import vista.FrmAdministrador;
import vista.FrmDetalles;
import vista.FrmTablaDePacientes;

public class CtrlTablaDePacientes {

    FrmTablaDePacientes vista;
    Object[][] tablaVista;

    //HashTableClinica htc;
    public CtrlTablaDePacientes(FrmTablaDePacientes vista) {
        TableColumn columna;

        this.vista = vista;
        cargarTabla();
        cargarComponentes();

//        String[] columnas = {"Código", "Nombres", "Apellidos", "Edad", "sexo", "estado"};

        /*
        for(int i = 0;i<Datos.columnas.length;i++){
            modelo.addColumn(Datos.columnas[i]);
        }
        this.vista.Tabla.setModel(modelo);  
         */
 /*columna = vista.Tabla.getColumnModel().getColumn(0);
        columna.setPreferredWidth(50);
        columna.setMaxWidth(50);
        columna.setMinWidth(50);
        columna = vista.Tabla.getColumnModel().getColumn(3);
        columna.setPreferredWidth(50);
        columna.setMaxWidth(50);
        columna.setMinWidth(50);
        columna = vista.Tabla.getColumnModel().getColumn(4);
        columna.setPreferredWidth(50);
        columna.setMaxWidth(50);
        columna.setMinWidth(50);
        columna = vista.Tabla.getColumnModel().getColumn(5);
        columna.setPreferredWidth(90);
        columna.setMaxWidth(90);
        columna.setMinWidth(90);*/
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
                ArrayList<Paciente> encontrados = new ArrayList<Paciente>();
                String cod = vista.txtCodigoPaciente.getText();
                if (cod.length() != 0) {
                    for (Paciente p : Datos.pacientes) {
                        System.out.println(p.getCodigo().substring(0, cod.length() + 1));
                        if (p.getCodigo().substring(0, cod.length()).equals(cod)) {
                            encontrados.add(p);
                        }
                    }

                    Object[][] nuevo = new Object[encontrados.size()][6];
                    for (int i = 0; i < encontrados.size(); i++) {
                        Paciente p = encontrados.get(i);
                        nuevo[i][0] = p.getCodigo();
                        nuevo[i][1] = p.getNombre();
                        nuevo[i][2] = p.getApellidoP() + " " + p.getApellidoM();
                        nuevo[i][3] = p.getEdad();
                        nuevo[i][4] = p.getEdad();
                        nuevo[i][5] = "";
                    }
                    Object[] column = {"CODIGO", "NOMBRES", "APELLIDOS", "EDAD", "SEXO", "ESTADO"};
                    vista.Tabla.setModel(new DefaultTableModel(nuevo, column));
                } else {
                    cargarTabla();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                ArrayList<Paciente> encontrados = new ArrayList<Paciente>();
                String cod = vista.txtCodigoPaciente.getText();
                if (cod.length() != 0) {
                    for (Paciente p : Datos.pacientes) {
                        System.out.println(p.getCodigo().substring(0, cod.length() + 1));
                        if (p.getCodigo().substring(0, cod.length()).equals(cod)) {
                            encontrados.add(p);
                        }
                    }

                    Object[][] nuevo = new Object[encontrados.size()][6];
                    for (int i = 0; i < encontrados.size(); i++) {
                        Paciente p = encontrados.get(i);
                        nuevo[i][0] = p.getCodigo();
                        nuevo[i][1] = p.getNombre();
                        nuevo[i][2] = p.getApellidoP() + " " + p.getApellidoM();
                        nuevo[i][3] = p.getEdad();
                        nuevo[i][4] = p.getEdad();
                        nuevo[i][5] = "";
                    }
                    Object[] column = {"CODIGO", "NOMBRES", "APELLIDOS", "EDAD", "SEXO", "ESTADO"};
                    vista.Tabla.setModel(new DefaultTableModel(nuevo, column));
                } else {
                    cargarTabla();
                }
            }

        });

        vista.buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ArrayList<Paciente> encontrados = new ArrayList<Paciente>();
                Object[] column = {"CODIGO", "NOMBRES", "APELLIDOS", "EDAD", "SEXO", "DIRECCION"};

                if (vista.box.getSelectedIndex() == 0) {
                    Clinica c = Datos.clinicas.getClinicaListaPacientes();
                    Paciente[] encontrados = c.getPacientes();
                    Object[][] nuevo = new Object[encontrados.length][6];
                    for (int i = 0; i < encontrados.length; i++) {
                        Paciente p = encontrados[i];
                        nuevo[i][0] = p.getCodigo();
                        nuevo[i][1] = p.getNombre();
                        nuevo[i][2] = p.getApellidoP() + " " + p.getApellidoM();
                        nuevo[i][3] = p.getEdad();
                        nuevo[i][4] = p.getSexo();
                        nuevo[i][5] = p.getDireccion();
                    }
                    vista.Tabla.setModel(new DefaultTableModel(nuevo, column));
                } else {
                    Clinica c = (Clinica) vista.box.getSelectedItem();
                    Paciente[] encontrados = c.getPacientes();
//                for (Paciente p : Datos.pacientes) {
////                    System.out.println(p.getClinica() + "  |  " + c);
//                    if (p.getClinica().getNombre().equals(c.getNombre())) {
//                        System.out.println("Entramos");
//                        encontrados.add(p);
//                    }
//                }

                    Object[][] nuevo = new Object[encontrados.length][6];
                    for (int i = 0; i < encontrados.length; i++) {
                        Paciente p = encontrados[i];
                        nuevo[i][0] = p.getCodigo();
                        nuevo[i][1] = p.getNombre();
                        nuevo[i][2] = p.getApellidoP() + " " + p.getApellidoM();
                        nuevo[i][3] = p.getEdad();
                        nuevo[i][4] = p.getSexo();
                        nuevo[i][5] = p.getDireccion();
                    }
                    vista.Tabla.setModel(new DefaultTableModel(nuevo, column));
                }
            }

        });

        this.vista.btnDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlFrmDetalles ctrl = new CtrlFrmDetalles(new FrmDetalles());
            }

        });

    }

    public void Iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        //htc = new HashTableClinica(10);
    }

    /*public void insertar(Paciente registro) {
        Object[] fila = {registro.getApellidoM()};
        Datos.dt.addRow(fila);
        vista.Tabla.setModel(Datos.dt);
    }*/
    private void cargarTabla() {

        Paciente[] aux2 = Datos.clinicas.getClinicaListaPacientes().getPacientes();
        Object[] datos[] = new Object[aux2.length][6];
//        Paciente[] aux = new Paciente[Datos.pacientes.size()];
//        Datos.pacientes.toArray(aux);
//        Sort.heapSort(aux);

        for (int i = 0; i < /*Datos.pacientes.size()*/ aux2.length; i++) {
            datos[i][0] = aux2[i].getCodigo();
            datos[i][1] = aux2[i].getNombre();
            datos[i][2] = aux2[i].getApellidoP() + " " + aux2[i].getApellidoM();
            datos[i][3] = aux2[i].getEdad();
            datos[i][4] = aux2[i].getSexo();
            datos[i][5] = "";
        }
        Object[] column = {"CODIGO", "NOMBRES", "APELLIDOS", "EDAD", "SEXO", "ESTADO"};
        this.vista.Tabla.setModel(new DefaultTableModel(datos, column));

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
            eventos();
            funcionalidadTextArea();
            //     funcionalidadTextArea();
        }

        private void propiedades() {
            vs.setVisible(true);
            vs.setLocationRelativeTo(null);
            vs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        private void eventos() {

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
            for (Paciente p : Datos.pacientes) {
                if (p.getCodigo().equals(codigo)) {
                    return p;
                }
            }
            return null;
        }
    }

}
