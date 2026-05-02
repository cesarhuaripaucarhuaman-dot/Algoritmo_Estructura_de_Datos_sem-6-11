package arreglos_dinamicos_estaticos;

public class ArregloEstatico 
{
    public static void main(String[] args) 
    {
        int[] arreglo = new int[5];
        arreglo[0] = 10;
        arreglo[1] = 20;
        arreglo[2] = 30;
        arreglo[3] = 40;
        arreglo[4] = 50;
        for(int i=0; i<arreglo.length; i++)
        {
            System.out.println(arreglo[i]);
        }
    }
}
