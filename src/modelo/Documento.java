package modelo;

public class Documento {
    enum TipoDocumento {
        DNI, pasaporte;
    }

    String numero;
    TipoDocumento tipo;

    public Documento(String numero, String tipo) {
        this.numero = numero;
        this.tipo = TipoDocumento.valueOf(tipo);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoDocumento.valueOf(tipo);
    }
}
