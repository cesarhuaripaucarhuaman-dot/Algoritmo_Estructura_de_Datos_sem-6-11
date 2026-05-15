package semana06;

public class ColaCircular {

    private int[] cola;
    private int frente;
    private int final_;
    private int tamaño;
    private int capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.cola = new int[capacidad];
        this.frente = 0;
        this.final_ = -1;
        this.tamaño = 0;
    }

    public void encolar(int valor) {
        if (tamaño == capacidad) {
            System.out.println(" Cola circular llena");
            return;
        }
        final_ = (final_ + 1) % capacidad;
        cola[final_] = valor;
        tamaño++;
        System.out.println(" Encolado: " + valor);
    }

    public int desencolar() {
        if (tamaño == 0) {
            System.out.println(" Cola circular vacia");
            return -1;
        }
        int valor = cola[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        System.out.println(" Desencolado: " + valor);
        return valor;
    }

    public void mostrar() {
        if (tamaño == 0) {
            System.out.println("Cola circular: vacia");
            return;
        }
        System.out.print("Cola circular: ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(cola[(frente + i) % capacidad] + " ");
        }
        System.out.println();
    }
}
