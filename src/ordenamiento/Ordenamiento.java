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
        Marcador[] intArray = new Marcador[100];
        List<Marcador> listMarcadores = new ArrayList<>(100); // inicial capacidad
        
        // generar 100 registros 
        for (int i = 0 ; i<100; i++){
            intArray [i] = new Marcador();
        }
        
        
        
        System.out.println("**************Lista de marcadores no ordenados*************");
        
        for (Marcador marc : intArray){
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        }
        
        listMarcadores.forEach((marc) -> {
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        });
        
        System.out.println("**************Lista de marcadores ordenados*************");
        ordena.burbuja2(intArray);
        for (Marcador marc : intArray){
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        }
        
        
        /*
        Ordenador ordena = new Ordenador();
        ordena.burbuja(lista);
        for (int i = 0; i<lista.length; i++){
        System.out.println(lista[i]);
        }*/
        
    }
    
}
