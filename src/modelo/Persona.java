package modelo;

public abstract class Persona {
    enum Sexo{
        MASCULINO("M"), FEMENINO("F");
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

    public Persona(String codigo, String nombre, String apellidoP, String apellidoM,
                   String sexo, String correo, int numero, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.sexo = Sexo.valueOf(sexo);
        this.correo = correo;
        this.documento = new Documento(numero,tipo);
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

    public String getSexo() {
        return sexo.toString();
    }

    public void setSexo(String sexo) {
        this.sexo = Sexo.valueOf(sexo);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
