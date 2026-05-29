package semana9;

// ListaCircularSimple.java
public class ListaCircularSimple<T> {

    private NodoCircular<T> ultimo;
    private int tamaño;

    public ListaCircularSimple() {
        this.ultimo = null;
        this.tamaño = 0;
    }

    public void insertarInicio(T dato) {
        NodoCircular<T> nuevoNodo = new NodoCircular<>(dato);

        if (estaVacia()) {
            ultimo = nuevoNodo;
            ultimo.setSiguiente(ultimo);
        } else {
            nuevoNodo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevoNodo);
        }
        tamaño++;
        System.out.println("Elemento " + dato + " insertado al inicio");
    }

    public void insertarFinal(T dato) {
        NodoCircular<T> nuevoNodo = new NodoCircular<>(dato);

        if (estaVacia()) {
            ultimo = nuevoNodo;
            ultimo.setSiguiente(ultimo);
        } else {
            nuevoNodo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        tamaño++;
        System.out.println("Elemento " + dato + " insertado al final");
    }

    public boolean insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            System.out.println("Posicion invalida");
            return false;
        }

        if (posicion == 0) {
            insertarInicio(dato);
        } else if (posicion == tamaño) {
            insertarFinal(dato);
        } else {
            NodoCircular<T> nuevoNodo = new NodoCircular<>(dato);
            NodoCircular<T> actual = ultimo.getSiguiente();

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            tamaño++;
            System.out.println("Elemento " + dato + " insertado en posicion " + posicion);
        }
        return true;
    }

    public T eliminarInicio() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return null;
        }

        T dato = ultimo.getSiguiente().getDato();

        if (ultimo == ultimo.getSiguiente()) {
            ultimo = null;
        } else {
            ultimo.setSiguiente(ultimo.getSiguiente().getSiguiente());
        }
        tamaño--;
        System.out.println("Elemento " + dato + " eliminado del inicio");
        return dato;
    }

    public T eliminarFinal() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return null;
        }

        T dato = ultimo.getDato();

        if (ultimo == ultimo.getSiguiente()) {
            ultimo = null;
        } else {
            NodoCircular<T> actual = ultimo.getSiguiente();
            while (actual.getSiguiente() != ultimo) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(ultimo.getSiguiente());
            ultimo = actual;
        }
        tamaño--;
        System.out.println("Elemento " + dato + " eliminado del final");
        return dato;
    }

    public boolean eliminarValor(T valor) {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return false;
        }

        NodoCircular<T> actual = ultimo.getSiguiente();
        NodoCircular<T> anterior = ultimo;

        do {
            if (actual.getDato().equals(valor)) {
                if (actual == ultimo.getSiguiente()) {
                    eliminarInicio();
                } else if (actual == ultimo) {
                    eliminarFinal();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    tamaño--;
                    System.out.println("Elemento " + valor + " eliminado");
                }
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != ultimo.getSiguiente());

        System.out.println("Elemento " + valor + " no encontrado");
        return false;
    }

    public void recorrer() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        System.out.print("Recorrido lista circular: ");
        NodoCircular<T> actual = ultimo.getSiguiente();

        do {
            System.out.print(actual.getDato() + " → ");
            actual = actual.getSiguiente();
        } while (actual != ultimo.getSiguiente());

        System.out.println("(vuelve a " + ultimo.getSiguiente().getDato() + ")");
    }

    public void mostrarEstado() {
        if (estaVacia()) {
            System.out.println("Estado: Lista vacia");
        } else {
            System.out.println("Estado: Ultimo → " + ultimo.getDato()
                    + ", Primero → " + ultimo.getSiguiente().getDato()
                    + ", Tamaño → " + tamaño);
        }
    }

    public boolean contiene(T valor) {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return false;
        }

        NodoCircular<T> actual = ultimo.getSiguiente();
        int posicion = 0;
        do {
            if (actual.getDato().equals(valor)) {
                System.out.println("Elemento " + valor + " encontrado en posicion " + posicion);
                return true;
            }
            actual = actual.getSiguiente();
            posicion++;
        } while (actual != ultimo.getSiguiente());

        System.out.println("Elemento " + valor + " no encontrado");
        return false;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public int getTamaño() {
        return tamaño;
    }
}
