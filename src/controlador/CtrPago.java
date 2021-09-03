/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Pago;
import vista.FrmPago;


public class CtrPago {
    static FrmPago vista;
    Pago pago;    
    
    double precio, monto;
    
    double cambio;
    double[] valor = {200,100,50,20,10,5,2,1,0.5,0.2,0.1};
    int[] suma = {0,0,0,0,0,0,0,0,0,0,0};

    public CtrPago(FrmPago vista) {
        this.vista = vista;       
        this.vista.btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                precio = Double.parseDouble(vista.txtPrecio.getText());
                monto = Double.parseDouble(vista.txtMonto.getText());                
                pedir(monto, precio, vista);
                
            }
            
        });
    } 
    
    
    
    public void pedir(double monto, double precio, FrmPago vistaPago){
        
        cambio = monto - precio;
        
        if(cambio == 0){
            JOptionPane.showMessageDialog(vistaPago, "¡Gracias por atenderse en la clínica!");
        }else if(cambio < 0){
            JOptionPane.showMessageDialog(vistaPago, "¡Monto insuficiente, vuelva a ingresar el monto a pagar!");
        }else if(cambio > 0){
            vista.lblVuelto.setText(String.valueOf(cambio));
            voraz(valor, suma, cambio);
            JOptionPane.showMessageDialog(vistaPago, "¡Gracias por atenderse en la clínica!");
            vista.dispose();
        }
    }

    public static void voraz(double[] v, int[] s, double c){
        int i = 0, n = 11;
        double x, suma = 0;
        while (suma < c && n>i){
            x = v[i];
            if(suma + x <= c){
                s[i] = s[i] + 1;
                suma = suma + x;
            }else{
                i++;
            }
        }
        for(int k=0; k<11;k++){
            if(s[k] != 0){
                vista.txAmejorOpcion.append(" " + v[k] + " soles --> " +s[k] + "\n");
            }                              
        }
    }
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
