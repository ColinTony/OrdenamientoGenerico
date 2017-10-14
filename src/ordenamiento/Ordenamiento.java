package ordenamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 *
 * @author colin
 */
public class Ordenamiento {

    public static void main(String[] args) {
        Ordenador ordena = new Ordenador();
        List<Marcador> listMarcadores = new ArrayList<>(100); // inicial capacidad
        for (int i = 0 ; i<100; i++){
            listMarcadores.add(new Marcador());
        }
        System.out.println("**************Lista de marcadores no ordenados*************");
        
        listMarcadores.forEach((marc) -> {
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        });
        
        System.out.println("**************Lista de marcadores ordenados*************");
        
        listMarcadores.forEach((marc) -> {
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        });
        
        
        /*
        Ordenador ordena = new Ordenador();
        ordena.burbuja(lista);
        for (int i = 0; i<lista.length; i++){
        System.out.println(lista[i]);
        }*/
        
    }
    
}
