/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.CtrlLogin;
import controlador.CtrlLugares;
import controlador.CtrlVerPaciente;
import vista.FrmLogin;
import general.Datos;
import modelo.Clinica;
import modelo.Usuario;
import modelo.UsuarioArreglo;
import vista.FrmLugares;
import vista.FrmTablaDePacientes;
/**
 *
 * @author luigg
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //aca se combinan controlador vista y modelo
        
        //creando usuarios
        Usuario usuario = new Usuario("19200114","nick" , "paredes","carranza", "M","nick.paredes@gmail.com","970385384","empleado", "1", "1", false);
        
        
        // creando clinicas 
        
       // Clinica clinica1 = new Clinica("clinica 1", "lima", 5, 4, 3, 100, 3, pacientes, 1);
        
        Datos.usuarios.agregar(usuario);
        
       /*
        FrmLogin vista = new FrmLogin();
        CtrlLogin login = new CtrlLogin(vista);
        login.iniciar();
         
        
        FrmTablaDePacientes fTablaDePacientes = new FrmTablaDePacientes();
        CtrlVerPaciente cVerPaciente = new CtrlVerPaciente(fTablaDePacientes);                
        cVerPaciente.Iniciar();
         */
       
        FrmLugares vistaLug = new FrmLugares();
        CtrlLugares controladorLug = new CtrlLugares(vistaLug);
        controladorLug.Iniciar();
                            
    }
    
}
