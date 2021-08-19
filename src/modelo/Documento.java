package modelo;

public class Documento {
    enum TipoDocumento {
        DNI, pasaporte;
    }
    int numero;
    TipoDocumento tipo;

    public Documento(int numero, String tipo) {
        this.numero = numero;
        this.tipo = TipoDocumento.valueOf(tipo);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = TipoDocumento.valueOf(tipo);
    }
}
