/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
    public boolean debeGuardar;

    public void serializar() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/persistencia/credencialesGuardadas"));
            os.writeObject(this);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deserializar() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/persistencia/credencialesGuardadas"));
            Credenciales aux = (Credenciales) is.readObject();
            username = aux.username;
            debeGuardar = aux.debeGuardar;
            is.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void borrarSerial() {
        try {
            this.username = "";
            this.debeGuardar = false;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/persistencia/credencialesGuardadas.dat"));
            os.writeObject(this);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
