package modelo;

public class Administrador extends Usuario{

    public Administrador(String codigo, String nombre, String apellidoP, String apellidoM,
                         String sexo, String correo, int numero, String tipo, String contrasena,
                         String username, boolean conectado) {
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero,tipo , contrasena, username, conectado);
    }

    public Administrador(Usuario u){
        super(u.getCodigo(), u.getNombre(), u.getApellidoP(), u.getApellidoM(), u.getSexo(), u.getCorreo(), u.getNumero(), u.getTipo() 
                , u.getContrasena(), u.getUsername(), u.getConectado());
    }

    public Usuario crearUsuario(String codigo, String nombre, String apellidoP, String apellidoM,
                                String sexo, String correo, int numero, String tipo, String contrasena,
                                String username, boolean conectado){
        return new Usuario(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero, tipo,
                contrasena, username, conectado);
    }

    public Usuarioo crearUsuario(Usuario u){
        return u;
    }

}
