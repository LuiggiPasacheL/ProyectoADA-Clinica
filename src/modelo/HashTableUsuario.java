package modelo;

public class HashTableUsuario {
    HashTable<Usuario> usuarios;

    public HashTableUsuario(int tamano) {
        usuarios = new HashTable<>(tamano);
    }

    public boolean agregar(Usuario usuario) {
        return usuarios.agregar(usuario, usuario.getUsername());
    }

    public boolean cerrarSesion(String username) { //o trabajar por referencia al usuario

        int pos = buscarUsuario(username);

        if (pos != -1) {
            usuarios.get(pos).salir();
            return true;
        } else {
            return false;
        }
    }

    public boolean ingresarSesion(String username, String contrasena) {

        int pos = buscarUsuario(username);

        if (pos != -1 && usuarios.get(pos).ingresar(username, contrasena)) {
            return true;
        }
        return false;
    }

    public int buscarUsuario(String username){
        int pos = usuarios.hash(username);
        int posSgte;
        if (usuarios.get(pos) == null) {
            return -1;
        }
        if (usuarios.get(pos).esUsername(username)) {
            return pos;
        } else {
            posSgte = pos + 1;
            while (usuarios.get(posSgte) != null && !usuarios.get(posSgte).esUsername(username) && pos != posSgte) {
                posSgte++;
                if (posSgte == usuarios.getTamanoMax()) {
                    posSgte = 0;
                }
            }
            if (usuarios.get(posSgte) == null || pos == posSgte) {
                return -1;
            } else {
                return posSgte;
            }
        }
    }
}
