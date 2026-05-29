package semana9;

// ListaDoblementeEnlazada.java
public class ListaDoblementeEnlazada<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamaño++;
        System.out.println("Elemento " + dato + " insertado al inicio");
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            cabeza = cola = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(cola);
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        tamaño++;
        System.out.println("Elemento " + dato + " insertado al final");
    }

    public boolean insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            System.out.println("Posición invalida");
            return false;
        }

        if (posicion == 0) {
            insertarInicio(dato);
        } else if (posicion == tamaño) {
            insertarFinal(dato);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(dato);
            Nodo<T> actual = cabeza;

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }

            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            actual.getSiguiente().setAnterior(nuevoNodo);
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

        T dato = cabeza.getDato();

        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
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

        T dato = cola.getDato();

        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamaño--;
        System.out.println("Elemento " + dato + " eliminado del final");
        return dato;
    }

    public boolean eliminarValor(T valor) {
        if (estaVacia()) {
            System.out.println("✗ Lista vacia");
            return false;
        }

        Nodo<T> actual = cabeza;

        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                if (actual == cabeza) {
                    eliminarInicio();
                } else if (actual == cola) {
                    eliminarFinal();
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                    tamaño--;
                    System.out.println("Elemento " + valor + " eliminado");
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Elemento " + valor + " no encontrado");
        return false;
    }

    public void recorrerAdelante() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        System.out.print("Recorrido hacia adelante: null ⇄ ");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " ⇄ ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public void recorrerAtras() {
        if (estaVacia()) {
            System.out.println("Lista vacia");
            return;
        }

        System.out.print("Recorrido hacia atras: null ⇄ ");
        Nodo<T> actual = cola;
        while (actual != null) {
            System.out.print(actual.getDato() + " ⇄ ");
            actual = actual.getAnterior();
        }
        System.out.println("null");
    }

    public void mostrarEstado() {
        if (estaVacia()) {
            System.out.println("Estado: Lista vacia");
        } else {
            System.out.println("Estado: Cabeza → " + cabeza.getDato()
                    + ", Cola → " + cola.getDato()
                    + ", Tamaño → " + tamaño);
        }
    }

    public T buscar(T valor) {
        Nodo<T> actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                System.out.println("Elemento " + valor + " encontrado en posicion " + posicion);
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        System.out.println("Elemento " + valor + " no encontrado");
        return null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        return tamaño;
    }
}
