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
        Marcador[] listMarc = new Marcador[100];
        
        // generar 100 registros 
        for (int i = 0 ; i<100; i++){
            listMarc [i] = new Marcador();
        }
        
        
        
        System.out.println("**************Lista de marcadores no ordenados*************");
        
        for (Marcador marc : listMarc){
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        }
                
        System.out.println("**************Lista de marcadores ordenados*************");
        ordena.burbuja2(listMarc);
        for (Marcador marc : listMarc){
            System.out.println("Marcador. Tapa : "+ marc.isTapa()+ 
                    " Grosor : "+ marc.getGrosor()+
                    " Color : " + marc.getColor());
        }
        
    }
    
}
