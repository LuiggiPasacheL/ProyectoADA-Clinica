package modelo;

public class Medico extends Persona{
    boolean disponible;

    public Medico(String codigo, String nombre, String apellidoP,
                  String apellidoM, String sexo, String correo,
                  int numero, String tipo, boolean disponible) {
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero, tipo);
        this.disponible = disponible;
    }
}
