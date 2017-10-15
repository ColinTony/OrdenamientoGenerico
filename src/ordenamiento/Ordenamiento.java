package ordenamiento;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author colin
 */
public class Ordenamiento {

    public static void main(String[] args) {
        Contador contar = new Contador();
        Ordenador ordena = new Ordenador();
        TablaResultados resultados = new TablaResultados();
        List<Marcador> listaMarcadores = new ArrayList<>(100);
        //List<Automovil> listaAutomovil = new ArrayList<>(100);
        List<Marcador> listaMarcadores2 = new ArrayList<>(100);
        List<Marcador> listaMarcadores3 = new ArrayList<>(100);
        
        // generar 100 registros 
        for (int i = 0 ; i<100; i++){
            listaMarcadores.add(new Marcador());
            //listaAutomovil.add(new Automovil()); si se quiere probar con automovil
        }
        // Copiamos la lista en otras dos listas con el metodo estatico
        listaMarcadores2 = Marcador.copiaMarcador(listaMarcadores);
        listaMarcadores3 = Marcador.copiaMarcador(listaMarcadores2);
        
        
        //resultados.mostrarTabla(listaAutomovil);
         System.out.println("\n*********************LISTA NO ORDENADOS****************"
                 + "******************\n");
        resultados.mostrarTabla(listaMarcadores,contar);
         System.out.println("\n**********************COPIA 1 LISTA NO ORDENADOS*************"
                 + "***********************\n");
        resultados.mostrarTabla(listaMarcadores2,contar);
         System.out.println("\n**********************COPIA 2 LISTA NO ORDENADOS*************"
                 + "*******************\n");
        resultados.mostrarTabla(listaMarcadores3,contar);
        
        System.out.println("\n**********************LISTA DE MARCADORES ORDENADOS*************"
                + "*************************\n");
        
        System.out.println("\n**********************LISTA ORDENADOS CON ALGORITMO : QuickSort*************"
                + "*************************\n");
        // Reseteamos contador y ordenamos la Lista con el metodo QuickSort
        contar.resetear(); // reseteamos nuestro contador
        ordena.quickSort(listaMarcadores, 0, listaMarcadores.size()-1, contar);
        resultados.mostrarTabla(listaMarcadores,contar); // mostramos los resultados de la lista
        
        System.out.println("\n**********************COPIA 1 ORDENADOS CON ALGORITMO : Burbuja*************"
                + "*************************\n");
        // Resetemos el contador y ordenamos la lista 2 con el metodo Burbuja
        contar.resetear();
        ordena.burbuja(listaMarcadores2, contar); // enviamos una copia de la lista
        resultados.mostrarTabla(listaMarcadores, contar);
        System.out.println("\n**********************COPIA 2 ORDENADOS CON ALGORTIMO : MergeSort*************"
                + "*************************\n");
        // Reseteamos el contador y ordenamos la lista 3 con el metodo MergeSort
        contar.resetear();
        ordena.mergeSort(listaMarcadores3, contar);
        resultados.mostrarTabla(listaMarcadores, contar);
        
        
        // Para realizar con clase Automovil , se debera hacer el mismo procedimiento
        
        //ordena.mergeSort(listaAutomovil);
        //resultados.mostrarTabla(listaAutomovil);
        
    }
    
}
