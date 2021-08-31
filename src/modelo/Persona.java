package modelo;

import general.Datos;

public  class Persona {
    //abstract
    enum Sexo {
        M("M"), F("F");

        Sexo(String sexo) {
            this.sexo = sexo;
        }

        private String sexo;
    };

    String codigo;
    String nombre;
    String apellidoP;
    String apellidoM;
    Sexo sexo;
    String correo;
    Documento documento;
    String tipo;
    String numero;
    

    public Persona(String codigo, String nombre, String apellidoP, String apellidoM,
                   String sexo, String correo, String numero, String tipo) throws Exception {
        this.codigo = codigo;
        setNombres(nombre);
        setApellidoMaterno(apellidoM);
        setApellidoPaterno(apellidoP);
        this.sexo = Sexo.valueOf(sexo);
        setCorreo(correo);
        setDni(numero);
        this.documento = new Documento(numero, tipo);
        
    }
    
    public Persona(){}
    
    public String getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }

    

    public String getApellidoP() {
        return apellidoP;
    }

    

    public String getApellidoM() {
        return apellidoM;
    }

   

    public String getSexo() {
        return sexo.toString();
    }

    
    public String getCorreo() {
        return correo;
    }

    

    public Documento getDocumento() {
        return documento;
    }

    

    public String getTipo() {
        return tipo;
    }

   

    public String getNumero() {
        return numero;
    }

  
    
    public String[] ListarSexo(){
        String[] ls = {Sexo.F.toString(), Sexo.M.toString()};
        return ls;
    }
    
     
    

    public void setDni(String numero) throws Exception{
      //  Datos.validarDatos(numero, "[0-9]{8}", "DNI incorrecto");
        this.numero = numero;
    }


    public void setNombres(String nombre) throws Exception {
        Datos.validarDatos(nombre, "[a-zA-Z | \\s]+", "nombres incorrectos");
        this.nombre = nombre.toUpperCase();
    }

    public void setApellidoPaterno(String apellidoP) throws Exception {
        Datos.validarDatos(apellidoP, "[a-zA-Z | \\s]+", "Apellidos incorrectos");
        this.apellidoP = apellidoP.toUpperCase();
    }
    public void setApellidoMaterno(String apellidoM) throws Exception {
        Datos.validarDatos(apellidoM, "[a-zA-Z | \\s]+", "Apellidos incorrectos");
        this.apellidoM= apellidoM.toUpperCase();
    }

    public void setCorreo(String correo) throws Exception {
        Datos.validarDatos(correo, "[a-zA-Z0-9 | \\. ]+\\@[a-z]+.com", "Error en el correo");
        this.correo = correo;
    }
}
