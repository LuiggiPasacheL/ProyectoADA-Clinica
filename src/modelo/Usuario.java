package modelo;

import java.util.Objects;

public class Usuario extends Persona {
    String contrasena;
    String username;
    boolean conectado;

    public Usuario(String codigo, String nombre, String apellidoP, String apellidoM,
                   String sexo, String correo, int numero, String tipo, String contrasena,
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

    public void ingresar() {
        this.conectado = true;
    }

    public void salir(){ this.conectado = false; }

    public boolean esUsername(String username){
        return this.username.equals(username);
    }

    public boolean validarDatos(String username, String contrasena){
        if(this.isConectado()){
            return false;
        }

        return this.username.equals(username) &&
            this.contrasena.equals(contrasena);
    }

}
