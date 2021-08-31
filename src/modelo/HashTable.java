package modelo;

public class HashTable<E> {
    
    private Object[] arreglo;
    private int valorHash;
    private int cantidad;

    public HashTable(int tamano) {
        arreglo = new Object[tamano];
        valorHash = primoMasCercano(tamano);
        cantidad = 0;
    }

    public Object[] toArray() {
        Object[] resultado = new Object[cantidad];
        int j = 0;
        for (Object o : arreglo) {
            if (o != null) {
                resultado[j] = o;
                j++;
            }
        }
        return resultado;
    }

    public boolean agregar(E elemento, String clave) {
        int indice = hash(clave);
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[indice] == null) {
                arreglo[indice] = elemento;
                cantidad++;
                return true;
            }
            if (indice < arreglo.length - 1) {
                indice++;
            } else {
                indice = 0;
            }
        }
        return false; //arreglo lleno
    }

    public int hash(String username) {
        int hash = 0;
        for (int i = 0; i < username.length(); i++) {
            hash += username.charAt(i);
        }
        hash = hash % valorHash;
        return hash;
    }

    private int primoMasCercano(int valor) {
        if (esPrimo(valor)) {
            return valor;
        }

        int valor1;
        valor1 = valor;

        for (int i = valor; i > 2; i--) {
            valor1--;
            if (esPrimo(valor1)) {
                return valor1;
            }
        }

        return 2;
    }

    private boolean esPrimo(int valor) {
        for (int i = 2; i < valor; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Object[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(Object[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getTamanoMax(){return arreglo.length;}

    public E get(int i) {
        return (E) arreglo[i];
    }

    public int getValorHash() {
        return valorHash;
    }

    public void setValorHash(int valorHash) {
        this.valorHash = valorHash;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
