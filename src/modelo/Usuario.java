package modelo;

import java.util.Objects;

public class Usuario extends Persona {
    String contrasena;
    String username;
    boolean conectado;

    //para busquedas de usuarios
    public Usuario(String username) {
        super(null, null, null, null, null, null, null, null);
        this.username = username;
    }

    public Usuario(String codigo, String nombre, String apellidoP, String apellidoM,
                   String sexo, String correo, String numero, String tipo, String contrasena,
                   String username, boolean conectado) {
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero, tipo);
        this.contrasena = contrasena;
        this.username = username;
        this.conectado = conectado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isConectado() {
        return conectado;
    }

    public boolean esUsername(String username) {
        return this.username.equals(username);
    }

    public boolean ingresar(String username, String password) {
        if (this.isConectado()) {
            return false;
        }

        boolean result = false;

        if (this.username.equals(username) &&
                this.contrasena.equals(password)) {
            this.conectado = Boolean.TRUE;
            result = true;
        }

        return result;
    }

    public boolean salir() {
        if (this.conectado) {
            this.conectado = false;
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(username, usuario.username);
    }

}
