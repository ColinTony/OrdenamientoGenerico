package ordenamiento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author colin
 * @param <T> tipo generico
 */
public class Ordenador <T extends Comparable<T>>{
    private Contador contar = new Contador();
    
    /**
     *
     * @param <T> Clase tipo generica
     * @param arr Array que debera ordenarse
     * @param izq Variable para reccorer de izquierda a derecha
     * @param der Variable para recorrer de derecha a irzquierda
     */
    public <T extends Comparable<? super T>> void quickSort(List<T> arr, int izq, int der) {
        
        if (izq < der) { // mientras no se crucen
            int i = izq, j = der;
            T x = arr.get((i+j)/2); // Obtenemos el pivote

            do {
                while (arr.get(i).compareTo(x) < 0) i++; // comparamos con compareTo
                while (x.compareTo(arr.get(j)) < 0) j--;// comparamos con compareTo

                if ( i <= j) { // si siguen sin cruzarse intercambiamos
                    T tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                    i++;
                    j--;
                }

            } while (i <= j); // lo seguiremos haceinedo mientras nos se crucen
            
            // recursividad
            quickSort(arr, izq, j); 
            quickSort(arr, i, der);
        }
    }
    
    /**
     * Modificacion para el usar el algoritmo con tipo genericos
     * Espero que funciones xD
     * @param <T> Tipo generico
     * @param arr arreglo de tipo generico  
     */
    public <T extends Comparable<? super T>> void burbuja(List<T> arr) {
        boolean bandera = true;
        int superior = arr.size();
        contar.resetear();
        while (bandera) {
            bandera = false;
            superior--;
            contar.contar(); // superior menos uno
            for (int i = 0; i < superior; i++) {
                if (arr.get(i).compareTo(arr.get(i+1))>0) {
                    // comparacion del if y del for
                    contar.contar(2);
                    T temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    bandera = true;
                }
            }
        }
        System.out.println("El contador de ordenamiento burbuja es : "+ contar.getCuenta());
    }
    
    /**
     *
     * @param list lista de que contiene clase generica
     */
    public void mergeSort(List<T> list){
        contar.resetear();
        mergeSort(0, list.size() - 1, list, new ArrayList<> (list));
    }
    
    private void mergeSort(int menor, int mayor, List<T> list, List<T> aux) {
        if(menor < mayor){
            contar.contar(2); // condicion , operaciones
            int mid = menor + (mayor - menor) / 2;
            mergeSort(menor, mid, list, aux); 
            mergeSort(mid+1, mayor, list, aux);
            merge(menor, mid, mayor, list, aux);
	}
    }

    private void merge(int menor, int mitad, int mayor, List<T> list, List<T> aux) {
        
        int left = menor;
	int right = mitad + 1;
        
        for(int i = menor; i <= mayor; i++){
            aux.set(i, list.get(i));
	}
        while(left <= mitad && right <= mayor){ // mientras sean mnores que la mitad
            contar.contar(); // se contara las veces que se pregunta la condicion
            list.set(menor++, aux.get(left).compareTo(aux.get(right)) < 0 
                    ? aux.get(left++) : aux.get(right++));
	}
        while(left <= mitad){
            list.set(menor++, aux.get(left++));
	}
    }
    
}
