package modelo;

public class Paciente extends Persona{
    float pago;
    String direccion;
    String celular;
    String fechaVacunacion;
    boolean vacunado;

    public Paciente(String codigo, String nombre, String apellidoP, String apellidoM,
                    String sexo, String correo, int numero, String tipo, float pago,
                    String direccion, String celular, String fechaVacunacion, boolean vacunado) {
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero, tipo);
        this.pago = pago;
        this.direccion = direccion;
        this.celular = celular;
        this.fechaVacunacion = fechaVacunacion;
        this.vacunado = vacunado;
    }
}
