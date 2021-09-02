package modelo;

import general.Datos;
import java.io.Serializable;

public class Paciente extends Persona/* implements Edad*/ implements Serializable, Comparable{
    
    private float pago;
    private String direccion;
    private String celular;
    private String fechaVacunacion;
    private boolean vacunado;
    private int edad;
    private Clinica clinica;
    
    public Paciente(String nombre, int edad){
        this.edad = edad;
        this.nombre = nombre;
    }

    public Paciente(String codigo,int edad, String nombre, String apellidoP, String apellidoM,
                    String sexo, String correo, String numero, String tipo,
                    String direccion, String celular, Clinica hospital) throws Exception {
     
        super(codigo, nombre.toUpperCase(), apellidoP.toUpperCase(), apellidoM.toUpperCase(), sexo.toUpperCase(), correo.toUpperCase(), numero.toUpperCase(), tipo);
        
        this.clinica=hospital;
        this.edad=edad;
        this.direccion = direccion.toUpperCase();
        setCelular(celular);
        this.fechaVacunacion = fechaVacunacion;
    }
    /*
    public String Edad(String edad){
        return edad;
    }
    */

    
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
     
    public int getEdad(){
        return edad;
    }

 
    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public Clinica getClinica() {
        return clinica;
    }

    @Override
    public int compareTo(Object o) {
        Paciente p = (Paciente) o;
        return this.edad > p.edad ? -1 : this.edad == p.edad ? 0 : 1;
    }
    
    public String toString(){
        return "Nombre: " + this.nombre + " Edad: " + this.edad;
    }

  

   
 

    
    
   
}
