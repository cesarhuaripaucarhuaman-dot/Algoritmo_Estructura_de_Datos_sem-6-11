package semana9;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion(1, 3);

            switch (opcion) {
                case 1:
                    menuListaDoble();
                    break;
                case 2:
                    menuListaCircular();
                    break;
                case 3:
                    System.out.println("\n ¡Gracias por usar el programa! Hasta luego.");
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println(" SISTEMA DE LISTAS ENLAZADAS");
        System.out.println("1.Lista Doblemente Enlazada");
        System.out.println("2.Lista Circular Simple");
        System.out.println("3.Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void menuListaDoble() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();

        while (true) {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("LISTA DOBLEMENTE ENLAZADA");
            System.out.println("1.Insertar al inicio");
            System.out.println("2.Insertar al final");
            System.out.println("3.Insertar en posicion");
            System.out.println("4.Eliminar del inicio");
            System.out.println("5.Eliminar del final");
            System.out.println("6.Eliminar por valor");
            System.out.println("7.Buscar elemento");
            System.out.println("8.Recorrer hacia adelante");
            System.out.println("9.Recorrer hacia atrás");
            System.out.println("10.Mostrar estado");
            System.out.println("11.Volver al menu principal");
            System.out.println("─".repeat(50));
            System.out.print("Opcion: ");

            int opcion = leerOpcion(1, 11);

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor (entero): ");
                    int valorInicio = scanner.nextInt();
                    lista.insertarInicio(valorInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el valor (entero): ");
                    int valorFinal = scanner.nextInt();
                    lista.insertarFinal(valorFinal);
                    break;
                case 3:
                    System.out.print("Ingrese el valor (entero): ");
                    int valorPos = scanner.nextInt();
                    System.out.print("Ingrese la posicion: ");
                    int posicion = scanner.nextInt();
                    lista.insertarEnPosicion(valorPos, posicion);
                    break;
                case 4:
                    lista.eliminarInicio();
                    break;
                case 5:
                    lista.eliminarFinal();
                    break;
                case 6:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int valorEliminar = scanner.nextInt();
                    lista.eliminarValor(valorEliminar);
                    break;
                case 7:
                    System.out.print("Ingrese el valor a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    lista.buscar(valorBuscar);
                    break;
                case 8:
                    lista.recorrerAdelante();
                    break;
                case 9:
                    lista.recorrerAtras();
                    break;
                case 10:
                    lista.mostrarEstado();
                    break;
                case 11:
                    return;
            }
        }
    }

    private static void menuListaCircular() {
        ListaCircularSimple<String> lista = new ListaCircularSimple<>();

        while (true) {
            System.out.println("\n" + "─".repeat(50));
            System.out.println("LISTA CIRCULAR SIMPLE");
            System.out.println("1.Insertar al inicio");
            System.out.println("2.Insertar al final");
            System.out.println("3.Insertar en posicion");
            System.out.println("4.Eliminar del inicio");
            System.out.println("5.Eliminar del final");
            System.out.println("6.Eliminar por valor");
            System.out.println("7.Verificar existencia");
            System.out.println("8.Recorrer lista");
            System.out.println("9.Mostrar estado");
            System.out.println("10.Volver al menu principal");
            System.out.print("Opcion: ");

            int opcion = leerOpcion(1, 10);

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor (texto): ");
                    String valorInicio = scanner.next();
                    lista.insertarInicio(valorInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el valor (texto): ");
                    String valorFinal = scanner.next();
                    lista.insertarFinal(valorFinal);
                    break;
                case 3:
                    System.out.print("Ingrese el valor (texto): ");
                    String valorPos = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    int posicion = scanner.nextInt();
                    lista.insertarEnPosicion(valorPos, posicion);
                    break;
                case 4:
                    lista.eliminarInicio();
                    break;
                case 5:
                    lista.eliminarFinal();
                    break;
                case 6:
                    System.out.print("Ingrese el valor a eliminar: ");
                    String valorEliminar = scanner.next();
                    lista.eliminarValor(valorEliminar);
                    break;
                case 7:
                    System.out.print("Ingrese el valor a buscar: ");
                    String valorBuscar = scanner.next();
                    lista.contiene(valorBuscar);
                    break;
                case 8:
                    lista.recorrer();
                    break;
                case 9:
                    lista.mostrarEstado();
                    break;
                case 10:
                    return;
            }
        }
    }

    private static int leerOpcion(int min, int max) {
        while (true) {
            try {
                int opcion = scanner.nextInt();
                if (opcion >= min && opcion <= max) {
                    return opcion;
                } else {
                    System.out.print("Opción invalida. Intente nuevamente (" + min + "-" + max + "): ");
                }
            } catch (Exception e) {
                System.out.print("Entrada invalida. Ingrese un numero: ");
                scanner.next();
            }
        }
    }
}
