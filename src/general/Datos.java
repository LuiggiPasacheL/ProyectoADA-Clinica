package general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Arreglo;
import modelo.Clinica;
import modelo.ColaPrioridad;
import modelo.HashTableClinica;
import modelo.Usuario;
import modelo.UsuarioArreglo;

public class Datos {   
    public static Arreglo <Usuario> usuarios = new Arreglo<Usuario>();
    public static String[] columnas = new String[]{"Código","Nombres","Apellidos","Edad","sexo","estado"};
    public static ColaPrioridad colaPrioridad = new ColaPrioridad();
    public static HashTableClinica clinicas = new HashTableClinica(6);
    
    public static void validarDatos(String value, String ReGex, String mensaje) throws Exception{
        Pattern er = Pattern.compile(ReGex);
        Matcher mat = er.matcher(value);
        if(!mat.matches()) {
            System.err.println(mensaje);
            JOptionPane.showMessageDialog(null, mensaje);
            throw new Exception();
        }
    }
    
    
}

    