package ordenamiento;

import java.util.List;

/**
 *
 * @author colin
 */ 
public class TablaResultados{
    public void mostrarTabla(List<Marcador> lista){
        System.out.println("----------------------------------------------------"
                + "------------------------------------------------------");
        lista.forEach(marcador -> {
            System.out.println("Marcador. Tapa : "+ marcador.isTapa()+ 
                    " Grosor : "+ marcador.getGrosor()+
                    " Color : " + marcador.getColor());
        });
        System.out.println("----------------------------------------------------"
                + "------------------------------------------------------");
    }
}
