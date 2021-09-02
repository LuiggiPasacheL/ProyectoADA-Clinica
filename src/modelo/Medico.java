package modelo;

import java.io.Serializable;

public class Medico extends Persona implements Serializable{
    boolean disponible;

    public Medico(String codigo, String nombre, String apellidoP,
                  String apellidoM, String sexo, String correo,
                  String numeroDoc, String tipo) throws Exception {
        super(codigo, nombre, apellidoP, apellidoM, sexo, correo, numeroDoc, tipo);
        this.disponible = true;
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }


    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumero(String numero) {
        this.numeroDoc = numero;
    }

}
