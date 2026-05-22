package javaapplication16;
public class ListaEnlazada {

    Nodo cabeza;

    // Insertar nodo
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {
        Nodo actual = cabeza;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    // Invertir lista
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente;

        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // Detectar ciclo (Floyd)
    public boolean tieneCiclo() {
        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    // Crear ciclo para prueba
    public void crearCiclo() {
        if (cabeza == null) {
            return;
        }

        Nodo actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = cabeza;
    }

    // Fusionar listas ordenadas
    public static ListaEnlazada fusionar(ListaEnlazada l1, ListaEnlazada l2) {

        ListaEnlazada resultado = new ListaEnlazada();

        Nodo n1 = l1.cabeza;
        Nodo n2 = l2.cabeza;

        while (n1 != null && n2 != null) {

            if (n1.dato < n2.dato) {
                resultado.insertar(n1.dato);
                n1 = n1.siguiente;
            } else {
                resultado.insertar(n2.dato);
                n2 = n2.siguiente;
            }
        }

        while (n1 != null) {
            resultado.insertar(n1.dato);
            n1 = n1.siguiente;
        }

        while (n2 != null) {
            resultado.insertar(n2.dato);
            n2 = n2.siguiente;
        }

        return resultado;
    }
}
