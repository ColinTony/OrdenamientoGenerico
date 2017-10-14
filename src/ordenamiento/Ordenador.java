package ordenamiento;

import java.util.List;

/**
 *
 * @author colin
 */
public class Ordenador <T>{
       
    /*public void quickSort(T[] a) {
        
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
    }*/
    
    
    
   public void burbuja (int lista[]){
       int cuentaintercambios=0;
       //Usamos un for aniadado, saldra cuando este ordenado el array
       for (boolean ordenado=false;!ordenado;){
           for (int i=0;i<lista.length-1;i++){
               if (lista[i]>lista[i+1]){
                   //Intercambiamos valores
                   int variableauxiliar=lista[i];
                   lista[i]=lista[i+1];
                   lista[i+1]=variableauxiliar;
                   //indicamos que hay un cambio
                   cuentaintercambios++;
               }
             
        }
        //Si no hay intercambios, es que esta ordenado.
        if (cuentaintercambios==0){
            ordenado=true;
        }
            //Inicializamos la variable de nuevo para que empiece a contar de nuevo
            cuentaintercambios=0;
        }
    }
   
    /**
     * Modificacion para el usar el algoritmo con tipo genericos
     * Espero que funciones xD
     * @param <T> Tipo generico
     * @param v arreglo de tipo generico  
     */
    public <T extends Comparable<T>> void burbuja2(T[] v) {
        boolean bandera = true;
        int superior = v.length;
        while (bandera) {
            bandera = false;
            superior--;
            for (int i = 0; i < superior; i++) {
                if (v[i].compareTo(v[i + 1]) > 0) {
                    T temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    bandera = true;
                }
            }
        }
    }
    
}
