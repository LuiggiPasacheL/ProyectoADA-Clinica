package general;

import modelo.HashTableClinica;
import modelo.HashTableUsuario;
import modelo.Usuario;

public class Datos {
    //TODO definir valores globales para la aplicacion
    public static HashTableUsuario usuarios = new HashTableUsuario(20);
    public static HashTableClinica clinicas = new HashTableClinica(20);

    public static Usuario usuarioActivo = null;
}
