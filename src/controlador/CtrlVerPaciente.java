/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import general.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Clinica;
import modelo.Excel;
import modelo.HashTableClinica;
import modelo.Paciente;
import modelo.UsuarioArreglo;
import vista.FrmAdministrador;
import vista.FrmTablaDePacientes;

public class CtrlVerPaciente {
    
    FrmTablaDePacientes vista;
    DefaultTableModel modelo;
    Object[][] tablaVista;
    
    
    //HashTableClinica htc;

    public CtrlVerPaciente(FrmTablaDePacientes vista) {
        TableColumn columna;
        
        this.vista = vista;
        cargarTabla();
     
        /*
        for(int i = 0;i<Datos.columnas.length;i++){
            modelo.addColumn(Datos.columnas[i]);
        }
        this.vista.Tabla.setModel(modelo);  
        */
        
        columna = vista.Tabla.getColumnModel().getColumn(0);
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
        columna.setMinWidth(90);
        
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
    
    public void Iniciar(){
         vista.setVisible(true);
         vista.setLocationRelativeTo(null);
         //htc = new HashTableClinica(10);
    }
    
    public void insertar(Paciente registro){
        Object[] fila = {registro.getApellidoM()};
        modelo.addRow(fila);
        vista.Tabla.setModel(modelo);
    }
    
    private void cargarTabla(){
        Object[][] matriz = Excel.cargarExcel("src/general/pacientes.xlsx");
        this.modelo = new DefaultTableModel(matriz,Datos.columnas){
            @Override
            public boolean isCellEditable(int filas, int columnas) {return false;};
        };
        this.vista.Tabla.setModel(modelo);
    }
    
    
}
