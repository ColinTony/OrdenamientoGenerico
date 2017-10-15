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
     * @param a Variable para reccorer de izquierda a derecha
     * @param b Variable para recorrer de derecha a irzquierda
     */
    public <T extends Comparable<? super T>> void quickSort(List<T> arr, int a, int b) {
        
        if (a < b) { // mientras no se crucen
            int i = a, j = b;
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
            quickSort(arr, a, j); 
            quickSort(arr, i, b);
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
    
    public void sort(List<T> values){
        mergeSort(0, values.size() - 1, values, new ArrayList<T>(values));
    }
    private void mergeSort(int low, int high, List<T> values, List<T> aux) {
        if(low < high){
            int mid = low + (high - low) / 2;
            mergeSort(low, mid, values, aux); 
            mergeSort(mid+1, high, values, aux);
            merge(low, mid, high, values, aux);
	}
    }

    private void merge(int low, int mid, int high, List<T> values, List<T> aux) {
        int left = low;
	int right = mid + 1;
        
        for(int i = low; i <= high; i++){
            aux.set(i, values.get(i));
	}
        while(left <= mid && right <= high){
            values.set(low++, aux.get(left).compareTo(aux.get(right)) < 0 ? aux.get(left++) : aux.get(right++));
	}

		while(left <= mid){
			values.set(low++, aux.get(left++));
		}
	}
    
}
