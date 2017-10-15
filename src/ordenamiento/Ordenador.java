package ordenamiento;

import java.util.List;

/**
 *
 * @author colin
 * @param <T> tipo generico
 */
public class Ordenador <T>{
    private Contador contar = new Contador();
    
    public <T extends Comparable<T>> void quickSort(T[] arr, int a, int b) {
        
        if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];

            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quickSort(arr, a, j);
            quickSort(arr, i, b);
        }
    }
    /*   
    public arroid quickSort(T[] a) {
           
        
         a[izq]=a[j]; // se coloca el piarrote en su lugar de forma que tendremos
         a[j]=piarrote; // los menores a su izquierda y los mayores a su derecha
         
         if(izq<j-1)
            quickSort(a,izq,j-1); // ordenamos subarray izquierdo
         if(j+1 <der)
            quickSort(a,j+1,der); // ordenamos subarray derecho
    }*/
    
    /**
     * Modificacion para el usar el algoritmo con tipo genericos
     * Espero que funciones xD
     * @param <T> Tipo generico
     * @param arr arreglo de tipo generico  
     */
    public <T extends Comparable<? super T>> void burbuja2(T[] arr) {
        boolean bandera = true;
        int superior = arr.length;
        contar.resetear();
        while (bandera) {
            bandera = false;
            superior--;
            contar.contar(); // superior menos uno
            for (int i = 0; i < superior; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    // comparacion del if y del for
                    contar.contar(2);
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    bandera = true;
                }
            }
        }
        System.out.println("El contador de ordenamiento burbuja es : "+ contar.getCuenta());
    }
    
}
