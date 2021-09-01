/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author luigg
 */
public class Credenciales implements Serializable {

    public String username;
    public boolean guardar;

    public void serializar() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("credencialesGuardadas.dat"));
            os.writeObject(this);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deserializar() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("credencialesGuardadas.dat"));
            Credenciales aux = (Credenciales) is.readObject();
            username = aux.username;
            guardar = aux.guardar;
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void borrarSerial(){
        try {
            this.username = "";
            this.guardar = false;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("credencialesGuardadas.dat"));
            os.writeObject(this);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
