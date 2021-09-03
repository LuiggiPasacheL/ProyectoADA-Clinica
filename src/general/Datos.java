package general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import util.Arreglo;
import modelo.HashTableClinica;
import modelo.Usuario;

public class Datos {  

    public static HashTableClinica clinicas = new HashTableClinica(10);
    public static Arreglo<Usuario> usuarios = new Arreglo<Usuario>();
    public static Usuario usuarioActivo = null;
    
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

    