package ordenamiento;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author colin
 */
public class Ordenamiento {

    public static void main(String[] args) {
        Ordenador ordena = new Ordenador();
        TablaResultados resultados = new TablaResultados();
        List<Marcador> listaMarcadores = new ArrayList<Marcador>(100);
        Marcador[] listMarc = new Marcador[100];
        
        // generar 100 registros 
        for (int i = 0 ; i<100; i++){
            listMarc [i] = new Marcador();
            listaMarcadores.add(new Marcador());
        }
        resultados.mostrarTabla(listaMarcadores);
        
        
        System.out.println("**************Lista de marcadores no ordenados*************");
        resultados.mostrarTabla(listaMarcadores);
        System.out.println("**************Lista de marcadores ordenados*************");
        ordena.sort(listaMarcadores);
        resultados.mostrarTabla(listaMarcadores);
        
    }
    
}
