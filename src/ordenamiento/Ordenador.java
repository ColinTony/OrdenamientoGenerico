package ordenamiento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author colin
 * @param <T> tipo generico
 */
public class Ordenador <T extends Comparable<T>>{   
    /**
     *
     * @param <T> Clase tipo generica
     * @param arr Array que debera ordenarse
     * @param izq Variable para reccorer de izquierda a derecha
     * @param der Variable para recorrer de derecha a irzquierda
     * @param contar Contador que llevara las operaciones realizadas
     */
    public <T extends Comparable<? super T>> void quickSort(List<T> arr, int izq, int der, Contador contar) {
        if (izq < der) { // mientras no se crucen
            contar.contar(2); // condicion y la suma entre dos 
            int i = izq, j = der;
            T x = arr.get((i+j)/2); // Obtenemos el pivote

            do {
                while (arr.get(i).compareTo(x) < 0){
                    i++;
                    contar.contar(2); // el while y la suma
                } // comparamos con compareTo
                while (x.compareTo(arr.get(j)) < 0){
                    j--; // el while y la resta j--
                    contar.contar(2);
                }// comparamos con compareTo

                if ( i <= j) { // si siguen sin cruzarse intercambiamos
                    contar.contar(4); // condicion , suma y resta y cambios
                    T tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                    i++;
                    j--;
                }

            } while (i <= j); // lo seguiremos haceinedo mientras nos se crucen
            
            // recursividad
            quickSort(arr, izq, j,contar); 
            quickSort(arr, i, der,contar);
        }
    }
    
    /**
     * Modificacion para el usar el algoritmo con tipo genericos
     * Espero que funciones xD
     * @param <T> Tipo generico
     * @param arr arreglo de tipo generico  
     * @param contar  nuestro contador llevara las operaciones realizadas
     */
    public <T extends Comparable<? super T>> void burbuja(List<T> arr,Contador contar) {
        boolean bandera = true;
        int superior = arr.size();
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
    }
    
    /**
     *
     * @param list lista de que contiene clase generica
     * Este meodo llama a el ordenamiento mergeSort
     * @param contar llevara las operaciones realizadass
     */
    public void mergeSort(List<T> list,Contador contar){
        mergeSort(0, list.size() - 1, list, new ArrayList<> (list),contar);
    }
    
    private void mergeSort(int menor, int mayor, List<T> list, List<T> aux,Contador contar) {
        if(menor < mayor){
            contar.contar(2); // condicion , operaciones
            int mid = menor + (mayor - menor) / 2;
            mergeSort(menor, mid, list, aux,contar); 
            mergeSort(mid+1, mayor, list, aux,contar);
            merge(menor, mid, mayor, list, aux,contar);
	}
    }

    private void merge(int menor, int mitad, int mayor, List<T> list, List<T> aux,Contador contar) {
        
        int left = menor;
	int right = mitad + 1; // operacion
        contar.contar(); // la operacion
        
        for(int i = menor; i <= mayor; i++){
            // cada evaluacion de la condicion
            contar.contar();
            aux.set(i, list.get(i));
	}
        while(left <= mitad && right <= mayor){ // mientras sean mnores que la mitad
            contar.contar(2); // se contara las veces que se pregunta la condicion
            // y la asignacion set
            list.set(menor++, aux.get(left).compareTo(aux.get(right)) < 0 
                    ? aux.get(left++) : aux.get(right++));
	}
        while(left <= mitad){
            list.set(menor++, aux.get(left++));
	}
    }
    
}
