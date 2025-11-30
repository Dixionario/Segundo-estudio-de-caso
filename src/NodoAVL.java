public class NodoAVL {
    int clave;
    NodoAVL izq, der;
    int altura;

    public NodoAVL(int clave) {
        this.clave = clave;
        this.izq = null;
        this.der = null;
        this.altura = 0;
    }

    public static NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.der;
        NodoAVL T2 = y.izq;

        y.izq = x;
        x.der = T2;

        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;
        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;

        return y;
    }

    public static NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izq;
        NodoAVL T2 = x.der;

        x.der = y;
        y.izq = T2;

        y.altura = Math.max(altura(y.izq), altura(y.der)) + 1;
        x.altura = Math.max(altura(x.izq), altura(x.der)) + 1;

        return x;
    }

    public static NodoAVL rotarIzquierdaDerecha(NodoAVL z) {
        z.izq = rotarIzquierda(z.izq);
        return rotarDerecha(z);
    }

    public static NodoAVL rotarDerechaIzquierda(NodoAVL z) {
        z.der = rotarDerecha(z.der);
        return rotarIzquierda(z);
    }


    public static int altura(NodoAVL nodo) {
        return (nodo == null) ? -1 : nodo.altura;
    }

    public static int obtenerFactorBalance(NodoAVL nodo) {
        if (nodo == null) return 0;
        return altura(nodo.der) - altura(nodo.izq);
    }
}
