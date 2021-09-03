package modelo;


public class Pago {
    double cambio;
    double[] valor = {200,100,50,20,10,5,2,1,0.5,0.2,0.1};
    int[] suma = {0,0,0,0,0,0,0,0,0,0,0};

    
    public Pago(double cambio) {
        this.cambio = cambio;
    }  
    
    
    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public double[] getValor() {
        return valor;
    }

    public void setValor(double[] valor) {
        this.valor = valor;
    }

    public int[] getSuma() {
        return suma;
    }

    public void setSuma(int[] suma) {
        this.suma = suma;
    }   
    
}
