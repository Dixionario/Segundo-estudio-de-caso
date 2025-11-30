public class AVL {
    private NodoAVL raiz;

    public AVL() {
        this.raiz = null;
    }

    // Búsqueda
    public boolean buscar(int clave) {
        return buscarRec(raiz, clave);
    }

    private boolean buscarRec(NodoAVL nodo, int clave) {
        if (nodo == null) return false;
        if (clave == nodo.clave) return true;
        if (clave < nodo.clave)
            return buscarRec(nodo.izq, clave);
        else
            return buscarRec(nodo.der, clave);
    }

    // Inserción
    public void insertar(int clave) {
        raiz = insertarRec(raiz, clave);
    }

    private NodoAVL insertarRec(NodoAVL nodo, int clave) {
        // 1. Inserción normal
        if (nodo == null) return new NodoAVL(clave);

        if (clave < nodo.clave) {
            nodo.izq = insertarRec(nodo.izq, clave);
        } else if (clave > nodo.clave) {
            nodo.der = insertarRec(nodo.der, clave);
        } else {
            return nodo;
        }

        // 2. Actualizar altura
        nodo.altura = Math.max(NodoAVL.altura(nodo.izq), NodoAVL.altura(nodo.der)) + 1;

        // 3. Calcular factor de balance
        int fb = NodoAVL.obtenerFactorBalance(nodo);

        // 4. Rebalancear si es necesario
        // Caso LL
        if (fb < -1 && clave < nodo.izq.clave) {
            return NodoAVL.rotarDerecha(nodo);
        }
        // Caso RR
        if (fb > 1 && clave > nodo.der.clave) {
            return NodoAVL.rotarIzquierda(nodo);
        }
        // Caso LR
        if (fb < -1 && clave > nodo.izq.clave) {
            return NodoAVL.rotarIzquierdaDerecha(nodo);
        }
        // Caso RL
        if (fb > 1 && clave < nodo.der.clave) {
            return NodoAVL.rotarDerechaIzquierda(nodo);
        }
        return nodo;
    }

    // Eliminación
    public void eliminar(int clave) {
        raiz = eliminarRec(raiz, clave);
    }

    private NodoAVL eliminarRec(NodoAVL nodo, int clave) {
        // 1. Eliminación normal
        if (nodo == null) return null;

        if (clave < nodo.clave) {
            nodo.izq = eliminarRec(nodo.izq, clave);
        } else if (clave > nodo.clave) {
            nodo.der = eliminarRec(nodo.der, clave);
        } else {
            // Nodo a eliminar es encontrado
            if (nodo.izq == null || nodo.der == null) {
                nodo = (nodo.izq != null) ? nodo.izq : nodo.der;
            } else {
                NodoAVL sucesor = minValorNodo(nodo.der);
                nodo.clave = sucesor.clave;
                nodo.der = eliminarRec(nodo.der, sucesor.clave);
            }
        }

        if (nodo == null) return null;

        // 2. Actualizar altura
        nodo.altura = Math.max(NodoAVL.altura(nodo.izq), NodoAVL.altura(nodo.der)) + 1;

        // 3. Factor de balance
        int fb = NodoAVL.obtenerFactorBalance(nodo);

        // 4. Rebalancear
        // Caso LL
        if (fb < -1 && NodoAVL.obtenerFactorBalance(nodo.izq) <= 0) {
            return NodoAVL.rotarDerecha(nodo);
        }
        // Caso LR
        if (fb < -1 && NodoAVL.obtenerFactorBalance(nodo.izq) > 0) {
            return NodoAVL.rotarIzquierdaDerecha(nodo);
        }
        // Caso RR
        if (fb > 1 && NodoAVL.obtenerFactorBalance(nodo.der) >= 0) {
            return NodoAVL.rotarIzquierda(nodo);
        }
        // Caso RL
        if (fb > 1 && NodoAVL.obtenerFactorBalance(nodo.der) < 0) {
            return NodoAVL.rotarDerechaIzquierda(nodo);
        }

        return nodo;
    }

    // encontrar nodo con menor valor
    private NodoAVL minValorNodo(NodoAVL nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    // Mostrar en orden
    public void mostrarEnOrden() {
        System.out.print("Árbol en orden: ");
        if (raiz == null) {
            System.out.println("vacío");
            return;
        }
        mostrarEnOrdenRec(raiz);
        System.out.println();
    }

    private void mostrarEnOrdenRec(NodoAVL nodo) {
        if (nodo != null) {
            mostrarEnOrdenRec(nodo.izq);
            System.out.print(nodo.clave + " ");
            mostrarEnOrdenRec(nodo.der);
        }
    }
}