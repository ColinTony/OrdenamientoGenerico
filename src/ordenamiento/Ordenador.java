package ordenamiento;

import java.util.List;

/**
 *
 * @author colin
 * @param <T> tipo generico
 */
public class Ordenador <T>{
    private Contador contar = new Contador();
       
    public void quickSort(T[] a) {
        
        int pivote= a.length; // pivote
        int i=0; // i búsqueda de izquierda a derecha
        int j=a.length; // j búsqueda de derecha a izquierda
        int aux; // variable auxiliar para intercambio
        
        // mientras no se crucen las búsquedas
        while(i<j){ 
           while(a[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
           while(a[j]>pivote) j--;         // busca elemento menor que pivote
           if (i<j) { // si no se han cruzado                      
               aux= a[i];// los intercambia
               a[i]=a[j];
               a[j]=aux;
           }
         }
         a[izq]=a[j]; // se coloca el pivote en su lugar de forma que tendremos
         a[j]=pivote; // los menores a su izquierda y los mayores a su derecha
         
         if(izq<j-1)
            quickSort(a,izq,j-1); // ordenamos subarray izquierdo
         if(j+1 <der)
            quickSort(a,j+1,der); // ordenamos subarray derecho
    }
    
    /**
     * Modificacion para el usar el algoritmo con tipo genericos
     * Espero que funciones xD
     * @param <T> Tipo generico
     * @param v arreglo de tipo generico  
     */
    public <T extends Comparable<? super T>> void burbuja2(T[] v) {
        boolean bandera = true;
        int superior = v.length;
        contar.resetear();
        while (bandera) {
            bandera = false;
            superior--;
            contar.contar(); // superior menos uno
            for (int i = 0; i < superior; i++) {
                if (v[i].compareTo(v[i + 1]) > 0) {
                    // comparacion del if y del for
                    contar.contar(2);
                    T temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    bandera = true;
                }
            }
        }
        System.out.println("El contador de ordenamiento burbuja es : "+ contar.getCuenta());
    }
    
}
