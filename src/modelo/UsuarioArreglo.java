package modelo;

public class UsuarioArreglo {

    private Usuario[] usuarios;
    private int valorHash;
    private final int tamano;

    public UsuarioArreglo(int tamano) {
        this.tamano = tamano;
        usuarios = new Usuario[tamano];
        valorHash = primoMasCercano(tamano);
    }

    public boolean agregar(Usuario usuario) {
        int indice = hash(usuario.getUsername());
        for (int i = 0; i < tamano; i++) {
            if (usuarios[indice] != null) {
                usuarios[indice] = usuario;
            }
            if (indice < tamano) {
                indice++;
            } else {
                indice = 0;
            }
        }
        return false;
    }

    public boolean cerrarSesion(String username){ //o trabajar por referencia al usuario
        int pos = busquedaPruebaLineal(username);

        if(pos != -1){
            usuarios[pos].salir();
            return true;
        }else{
            return false;
        }
    }


    public boolean ingresarSesion(String username, String contrasena) {

        int pos = busquedaPruebaLineal(username);

        if (pos != -1 && usuarios[pos].validarDatos(username, contrasena)) {
            usuarios[pos].ingresar(); //cambio de booleano a false
            return true;
        }
        return false;
    }

    private int busquedaPruebaLineal(String username) {
        int pos = hash(username);
        int posSgte;
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
            hash += username.charAt(i) - 'a';
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
            valor2++;
            if (esPrimo(valor1)) {
                return valor1;
            }
            if (esPrimo(valor2)) {
                return valor2;
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