package modelo;

public class UsuarioArreglo {

    private Usuario[] usuarios;
    private int valorHash;
    private final int tamano;
    private int numeroUsuarios;

    public UsuarioArreglo(int tamano) {
        this.tamano = tamano;
        usuarios = new Usuario[tamano];
        valorHash = primoMasCercano(tamano);
        numeroUsuarios = 0;
    }

    public Usuario[] toArray(){
        Usuario[] resultado = new Usuario[numeroUsuarios];
        int j = 0;
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i] != null){
                resultado[j] = usuarios[i];
                j++;
            }
        }
        return resultado;
    }

    public boolean agregar(Usuario usuario) {
        int indice = hash(usuario.getUsername());
        for (int i = 0; i < tamano; i++) {
            if (usuarios[indice] == null) {
                usuarios[indice] = usuario;
                numeroUsuarios++;
                return true;
            }
            if (indice < tamano - 1) {
                indice++;
            } else {
                indice = 0;
            }
        }
        return false; //arreglo lleno
    }

    public boolean cerrarSesion(String username) { //o trabajar por referencia al usuario
        int pos = busquedaPruebaLineal(username);

        if (pos != -1) {
            usuarios[pos].salir();
            return true;
        } else {
            return false;
        }
    }


    public boolean ingresarSesion(String username, String contrasena) {

        int pos = busquedaPruebaLineal(username);

        if (pos != -1 && usuarios[pos].ingresar(username, contrasena)) {
            return true;
        }
        return false;
    }

    private int busquedaPruebaLineal(String username) {
        int pos = hash(username);
        int posSgte;
        if(usuarios[pos] == null){
            return -1;
        }
        if (usuarios[pos].esUsername(username)) {
            return pos;
        } else {
            posSgte = pos + 1;
            while (usuarios[posSgte] != null && !usuarios[posSgte].esUsername(username) && pos != posSgte) {
                posSgte++;
                if (posSgte == usuarios.length) {
                    posSgte = 0;
                }
            }
            if (usuarios[posSgte] == null || pos == posSgte) {
                return -1;
            } else {
                return posSgte;
            }
        }
    }

    private int hash(String username) {
        int hash = 0;
        for (int i = 0; i < username.length(); i++) {
            hash += username.charAt(i);
        }
        hash = hash % valorHash;
        return hash;
    }

    private int primoMasCercano(int valor) {
        if (esPrimo(valor)) {
            return valor;
        }

        int valor1;
        int valor2;
        valor1 = valor2 = valor;

        for (int i = valor; i > 2; i--) {
            valor1--;
            if (esPrimo(valor1)) {
                return valor1;
            }
        }

        return 2;
    }

    private boolean esPrimo(int valor) {
        for (int i = 2; i < valor; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }
}