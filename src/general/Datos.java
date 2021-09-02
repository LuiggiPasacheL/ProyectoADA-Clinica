package general;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import util.Arreglo;
import modelo.HashTableClinica;
import modelo.Paciente;
import modelo.Usuario;

public class Datos {  
    public static ArrayList<Object[]> data = new ArrayList<Object[]>();
    public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    
    public static Arreglo<Usuario> usuarios = new Arreglo<Usuario>();
//    public static String[] columnas = new String[]{"Código","Nombres","Apellidos","Edad","sexo","estado"}; //TODO quitar esto de aca
//    public static ColaPrioridad colaPrioridad = new ColaPrioridad();
    public static HashTableClinica clinicas = new HashTableClinica(10);
    
    public static void validarDatos(String value, String ReGex, String mensaje) throws Exception{
        Pattern er = Pattern.compile(ReGex);
        Matcher mat = er.matcher(value);
        if(!mat.matches()) {
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(null, mensaje);
            throw new Exception();
        }
    }
    
    public static void serializar() throws FileNotFoundException, IOException{
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("cacheData")), 
                o1 = new ObjectOutputStream(new FileOutputStream("cachePacientes"));
        o.writeObject(data);
        o1.writeObject(pacientes);
        o.close();
        o1.close();
    }
    
    public static void deserializar() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream o = new ObjectInputStream(new FileInputStream("cacheData")), 
                o1 = new ObjectInputStream(new FileInputStream("cachePacientes"));
        data = (ArrayList<Object[]>) o.readObject();
        o.close();
        pacientes = (ArrayList<Paciente>) o1.readObject();
        
        o1.close();
    }
    
    
}

    