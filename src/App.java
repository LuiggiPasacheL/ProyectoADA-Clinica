/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vista.FrmLogin;

/**
 * @author luigg
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //aca se combinan controlador vista y modelo
        FrmLogin vista = new FrmLogin();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

}
