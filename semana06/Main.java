package semana06;
import java.util.Scanner;
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ColaCircular colaCircular;
    private static ColaLista colaLista;
    private static ColaPrioridad colaPrioridad;

    public static void main(String[] args) {
        System.out.print("Capacidad de la cola circular: ");
        int cap = sc.nextInt();

        colaCircular = new ColaCircular(cap);
        colaLista = new ColaLista();
        colaPrioridad = new ColaPrioridad();

        int opcion;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Encolar Circular");
            System.out.println("2. Desencolar Circular");
            System.out.println("3. Encolar Lista");
            System.out.println("4. Desencolar Lista");
            System.out.println("5. Encolar Prioridad");
            System.out.println("6. Desencolar Prioridad");
            System.out.println("7. Mostrar todo");
            System.out.println("8. Prueba automática");
            System.out.println("9. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Valor: ");
                    colaCircular.encolar(sc.nextInt());
                    break;
                case 2:
                    colaCircular.desencolar();
                    break;
                case 3:
                    System.out.print("Valor: ");
                    colaLista.encolar(sc.nextInt());
                    break;
                case 4:
                    colaLista.desencolar();
                    break;
                case 5:
                    System.out.print("Valor: ");
                    int v = sc.nextInt();
                    System.out.print("Prioridad (1=alta, 10=baja): ");
                    int p = sc.nextInt();
                    colaPrioridad.encolar(v, p);
                    break;
                case 6:
                    colaPrioridad.desencolar();
                    break;
                case 7:
                    System.out.println("\n--- ESTADO ---");
                    colaCircular.mostrar();
                    colaLista.mostrar();
                    colaPrioridad.mostrar();
                    break;
                case 8:
                    pruebaAutomatica();
                    break;
                case 9:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        } while (opcion != 9);

        sc.close();
    }

    private static void pruebaAutomatica() {
        System.out.println("\n=== PRUEBA ===");

        // Probar cola circular
        System.out.println("\n--- Circular ---");
        colaCircular.encolar(10);
        colaCircular.encolar(20);
        colaCircular.mostrar();
        colaCircular.desencolar();
        colaCircular.mostrar();

        // Probar cola lista
        System.out.println("\n--- Lista ---");
        colaLista.encolar(100);
        colaLista.encolar(200);
        colaLista.mostrar();
        colaLista.desencolar();
        colaLista.mostrar();

        // Probar cola prioridad
        System.out.println("\n--- Prioridad ---");
        colaPrioridad.encolar(30, 3);
        colaPrioridad.encolar(10, 1);
        colaPrioridad.encolar(20, 2);
        colaPrioridad.mostrar();
        colaPrioridad.desencolar();
        colaPrioridad.mostrar();

        System.out.println("\n Prueba completada");
    }
}
