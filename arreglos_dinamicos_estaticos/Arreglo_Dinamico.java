package arreglos_dinamicos_estaticos;
import java.util.ArrayList;
public class Arreglo_Dinamico 
{
    public static void main(String[] args)
    {
        //Creo un arreglo de string
        ArrayList<String> nombres = new ArrayList<>();
        //Agrego elemtos al Array List
        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("Pablo");
        nombres.add("Cesar");
        //Accedo a un elemento
        System.out.println("Primer nombre:" + nombres.get(0));   
        //Recorrer ArrayList
        for(String nombre:nombres)
        {
            System.out.println(nombre);        
        }
        //Tamaño actual del Array
        System.out.println("Cantidad de elementos: " + nombres.size());
    }
}
