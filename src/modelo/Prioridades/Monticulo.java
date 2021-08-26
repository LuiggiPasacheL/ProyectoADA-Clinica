package modelo.Prioridades;


public class Monticulo {
    static final int TAMANI = 20;
    private int numElement;
    private Comparador[] v;

    public Monticulo() {
        numElement = 0;
        v = new Comparador[TAMANI];
    }

    public static int padre(int i) {
        return (i - 1) / 2;
    }

    public static int hijoIzq(int i) {
        return (2 * i + 1);
    }

    public static int hijoDer(int i) {
        return (2 * i + 2);
    }

    private void flotar(int i) {

        Comparador nuevaClave = v[i];

        while ((i > 0) && (v[padre(i)].mayorQue(nuevaClave))) {
            v[i] = v[padre(i)];
            i = padre(i);
        }
        v[i] = nuevaClave;
    }

    private boolean monticuloLleno() {
        return (numElement == v.length);
    }

    private void ampliar() {
        Comparador[] anteriorV = v;
        v = new Comparador[numElement + TAMANI];
        for (int j = 0; j < numElement; j++) {
            v[j] = anteriorV[j];
        }
    }

    private void insertar(Comparador clave) {
        if (monticuloLleno())
            ampliar();
        v[numElement] = clave;
        flotar(numElement);
        numElement++;
    }

    public Comparador buscarMinimo() throws Exception {
        if (numElement == 0)
            throw new Exception("monticulo vacio");
        return v[0];
    }

    public void criba(int raiz) {

        boolean esMonticulo = false;
        ;
        int hijo;

        while ((raiz < numElement / 2) && !esMonticulo) {
            if (hijoIzq(raiz) == (numElement - 1)) {
                hijo = hijoIzq(raiz);
            } else {
                if (v[hijoIzq(raiz)].menorQue(v[hijoDer(raiz)]))
                    hijo = hijoIzq(raiz);
                else
                    hijo = hijoDer(raiz);
            }

            if (v[hijo].menorQue(v[raiz])) {
                Comparador t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo;
            } else {
                esMonticulo = true;
            }

        }
    }

    public Comparador eliminarMinimo() throws Exception {
        if (numElement == 0) {
            throw new Exception("Acceso a montículo vacío");
        }
        Comparador menor;
        menor = v[0];
        v[0] = v[numElement - 1];
        criba(0);
        numElement--;
        return menor;
    }

    public boolean esVacio() {
        return numElement == 0;
    }

    public static void criba2(Comparador v[], int raiz, int ultimo) {
        boolean esMonticulo;
        int hijo;
        int numElem = ultimo + 1;
        esMonticulo = false;
        while ((raiz < numElem / 2) && !esMonticulo) {
            if (Monticulo.hijoIzq(raiz) == (numElem - 1))
                hijo = Monticulo.hijoIzq(raiz);
            else {
                if (v[Monticulo.hijoIzq(raiz)].mayorQue(v[Monticulo.hijoDer(raiz)]))
                    hijo = Monticulo.hijoIzq(raiz);
                else
                    hijo = Monticulo.hijoDer(raiz);
            }

            if (v[hijo].mayorQue(v[raiz])) {
                Comparador t = v[raiz];
                v[raiz] = v[hijo];
                v[hijo] = t;
                raiz = hijo;
            } else
                esMonticulo = true;
        }
    }

    public static void ordenacionMonticulo(Comparador v[], int n) {
        int j;
        for (j = n / 2; j >= 0; j--) {
            criba2(v, j, n - 1);
        }

        for (j = n - 1; j >= 1; j--) {
            Comparador t;
            t = v[0];
            v[0] = v[j];
            v[j] = t;
            criba2(v, 0, j - 1);
        }
    }
}
