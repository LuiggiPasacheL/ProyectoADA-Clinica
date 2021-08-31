/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.CtrlLogin;
import controlador.CtrlVerPaciente;
import vista.FrmLogin;
import general.Datos;
import modelo.Usuario;
import modelo.UsuarioArreglo;
import vista.FrmTablaDePacientes;
/**
 *
 * @author luigg
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //aca se combinan controlador vista y modelo
        
        Usuario usuario = new Usuario("19200114","nick" , "paredes","carranza", "M","nick.paredes@unmsm.edu.pe","977302181","empleado", "1", "1", false);
        Datos.usuarios.agregar(usuario);
        
       
        FrmLogin vista = new FrmLogin();
        CtrlLogin login = new CtrlLogin(vista);
        login.iniciar();
         /*
        
        FrmTablaDePacientes fTablaDePacientes = new FrmTablaDePacientes();
        CtrlVerPaciente cVerPaciente = new CtrlVerPaciente(fTablaDePacientes);                
        cVerPaciente.Iniciar();
         */
    }
    
}
