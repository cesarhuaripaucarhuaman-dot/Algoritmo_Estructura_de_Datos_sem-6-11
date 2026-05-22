package semana8;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insertar elementos");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Invertir lista");
            System.out.println("4. Detectar ciclo");
            System.out.println("5. Crear ciclo");
            System.out.println("6. Fusionar listas ordenadas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese número: ");
                    int dato = sc.nextInt();

                    lista.insertar(dato);

                    System.out.println("Elemento insertado.");
                    break;

                case 2:

                    System.out.println("Lista:");
                    lista.mostrar();
                    break;

                case 3:

                    lista.invertir();

                    System.out.println("Lista invertida.");
                    lista.mostrar();
                    break;

                case 4:

                    if (lista.tieneCiclo()) {
                        System.out.println("La lista TIENE ciclo.");
                    } else {
                        System.out.println("La lista NO tiene ciclo.");
                    }

                    break;

                case 5:

                    lista.crearCiclo();

                    System.out.println("Ciclo creado.");
                    break;

                case 6:

                    ListaEnlazada l1 = new ListaEnlazada();
                    ListaEnlazada l2 = new ListaEnlazada();

                    // Lista 1
                    l1.insertar(1);
                    l1.insertar(3);
                    l1.insertar(5);

                    // Lista 2
                    l2.insertar(2);
                    l2.insertar(4);
                    l2.insertar(6);

                    ListaEnlazada fusionada
                            = ListaEnlazada.fusionar(l1, l2);

                    System.out.println("Lista fusionada:");
                    fusionada.mostrar();

                    break;

                case 0:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
