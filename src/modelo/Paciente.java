package modelo;

import general.Datos;

public class Paciente extends Persona/* implements Edad*/{
    String codigo;
    float pago;
    String direccion;
    String celular;
    String fechaVacunacion;
    boolean vacunado;
    String edad;
    String hospital;

    public Paciente(String codigo,String edad, String nombre, String apellidoP, String apellidoM,
                    String sexo, String correo, String numero, String tipo,
                    String direccion, String celular) throws Exception {
     
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numero, tipo);
        
        this.hospital=hospital;
        this.edad=edad;
        this.direccion = direccion;
        setCelular(celular);
        this.fechaVacunacion = fechaVacunacion;
    }
    /*
    public String Edad(String edad){
        return edad;
    }
    */
    public void setHospital(String hospital){
        this.hospital=hospital;
    }
    
    public String getHospital(String hospital){
        return hospital;
    }
    
     public void setCelular(String telefono) throws Exception{
        Datos.validarDatos(telefono, "9[0-9]{8}|01[0-9]", "Telefono incorrecto");
        this.celular = celular;
    }   

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public String getFechaVacunacion() {
        return fechaVacunacion;
    }

    public void setFechaVacunacion(String fechaVacunacion) {
        this.fechaVacunacion = fechaVacunacion;
    }
     
     
    
   
}
