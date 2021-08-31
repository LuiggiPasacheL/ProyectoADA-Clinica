package general;

import modelo.Arreglo;
import modelo.Usuario;
import modelo.UsuarioArreglo;

public class Datos {   
    //TODO definir valores globales para la aplicacion
    public static Arreglo <Usuario> usuarios = new Arreglo<Usuario>();
    public static String[] columnas = new String[]{"Código","Nombres","Apellidos","Edad","sexo","estado"};
}
