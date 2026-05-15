package semana06;
import java.util.ArrayList;
public class ColaPrioridad {

    private ArrayList<Integer> valores;
    private ArrayList<Integer> prioridades;

    public ColaPrioridad() {
        valores = new ArrayList<>();
        prioridades = new ArrayList<>();
    }

    public void encolar(int valor, int prioridad) {
        // Buscar posición según prioridad (menor número = mayor prioridad)
        int posicion = 0;
        while (posicion < prioridades.size() && prioridades.get(posicion) <= prioridad) {
            posicion++;
        }

        valores.add(posicion, valor);
        prioridades.add(posicion, prioridad);
        System.out.println(" Encolado: " + valor + " (prioridad: " + prioridad + ")");
    }

    public int desencolar() {
        if (valores.isEmpty()) {
            System.out.println(" Cola prioridad vacia");
            return -1;
        }
        int valor = valores.remove(0);
        prioridades.remove(0);
        System.out.println(" Desencolado: " + valor);
        return valor;
    }

    public void mostrar() {
        if (valores.isEmpty()) {
            System.out.println("Cola prioridad: vacia");
            return;
        }
        System.out.print("Cola prioridad: ");
        for (int i = 0; i < valores.size(); i++) {
            System.out.print(valores.get(i) + "(p:" + prioridades.get(i) + ") ");
        }
        System.out.println();
    }
}
