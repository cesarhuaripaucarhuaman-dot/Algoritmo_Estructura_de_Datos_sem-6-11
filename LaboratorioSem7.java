package javaapplication15;

import java.util.Scanner;

// Lista enlazada simple en Java
class Nodo 
{

    int dato;
    Nodo siguiente;

    public Nodo(int dato)
    {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada
{

    Nodo inicio;

    // Crear lista vacía
    public ListaEnlazada() 
    {
        inicio = null;
    }

    // Insertar al final
    public void insertar(int dato)
    {
        Nodo nuevo = new Nodo(dato);

        if (inicio == null) 
        {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;

            while (aux.siguiente != null) 
            {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }

        System.out.println("Dato insertado");
    }

    // Eliminar nodo
    public void eliminar(int dato) 
    {

        if (inicio == null)
        {
            System.out.println("La lista está vacía");
            return;
        }

        if (inicio.dato == dato)
        {
            inicio = inicio.siguiente;
            System.out.println("Dato eliminado");
            return;
        }

        Nodo aux = inicio;

        while (aux.siguiente != null && aux.siguiente.dato != dato) 
        {
            aux = aux.siguiente;
        }

        if (aux.siguiente != null)
        {
            aux.siguiente = aux.siguiente.siguiente;
            System.out.println("Dato eliminado");
        } else {
            System.out.println("Dato no encontrado");
        }
    }

    // Mostrar lista
    public void mostrar()
    {

        if (inicio == null) 
        {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo aux = inicio;

        while (aux != null) 
        {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }
}

public class Main
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion, dato;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Mostrar");
            System.out.println("4. Salir");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();

            switch (opcion) 
            {

                case 1:
                    System.out.print("Ingrese dato: ");
                    dato = sc.nextInt();
                    lista.insertar(dato);
                    break;

                case 2:
                    System.out.print("Ingrese dato a eliminar: ");
                    dato = sc.nextInt();
                    lista.eliminar(dato);
                    break;

                case 3:
                    lista.mostrar();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcion != 4);
        sc.close();
    }
}
