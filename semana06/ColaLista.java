package semana06;
public class ColaLista {

    private Nodo frente;
    private Nodo final_;

    // Clase interna Nodo
    private class Nodo {

        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public ColaLista() {
        this.frente = null;
        this.final_ = null;
    }

    public void encolar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (frente == null) {
            frente = nuevo;
            final_ = nuevo;
        } else {
            final_.siguiente = nuevo;
            final_ = nuevo;
        }
        System.out.println(" Encolado: " + valor);
    }

    public int desencolar() {
        if (frente == null) {
            System.out.println(" Cola lista vacia");
            return -1;
        }
        int valor = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            final_ = null;
        }
        System.out.println(" Desencolado: " + valor);
        return valor;
    }

    public void mostrar() {
        if (frente == null) {
            System.out.println("Cola lista: vacia");
            return;
        }
        System.out.print("Cola lista: ");
        Nodo actual = frente;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
