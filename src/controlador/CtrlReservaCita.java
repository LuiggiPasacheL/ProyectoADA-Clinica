
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Documento;
import modelo.Persona;
import modelo.UsuarioArreglo;
import vista.FrmReservaCita;


public class CtrlReservaCita {
     UsuarioArreglo modelo;
     FrmReservaCita vista;
     Documento modelo2 = new Documento();
     Persona modelo3= new Persona();
     // = new Persona();

    public CtrlReservaCita(UsuarioArreglo modelo, FrmReservaCita vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LimpiarControles();
            }
            
        });
    }     

    public void Iniciar(){        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        CargarCombo();
    }
    
    public void CargarCombo(){
        String[] arreglo={}, arreglo2={};
        try{
            arreglo = modelo2.TiposDeDocumentos();
            arreglo2 = modelo3.ListarSexo();
            for(String a : arreglo)
                this.vista.cbxDocumento.addItem(a);
            for(String b : arreglo2)
                this.vista.cbxSexo.addItem(b);
        }catch (Exception ex){
             System.out.println(ex);
        }
    }
    
    public void LimpiarControles(){        
        vista.txtCel.setText("");
        vista.txtCorreo.setText("");
        vista.txtDireccion.setText("");
        vista.txtNombres.setText("");
        vista.txtPaterno.setText("");
        vista.txtMaterno.setText("");
    }
}
