package ordenamiento;

import java.util.List;

/**
 *
 * @author colin
 * @param <T> clase generica
 */ 
public class TablaResultados<T>{

    /**
     *
     * @param lista lista de objetos
     * @param contador este contador llevara la cuenta de operaciones realizadas
     */
    public void mostrarTabla(List<T> lista,Contador contador){
        
        for (Object a : lista){
            if(a instanceof Automovil){
                System.out.println("--------------------------------------------"+
                        "----------------------------");
                System.out.println("Automovil. ||convertible : "+ ((Automovil) a).isConvertible()+ 
                            " || Numero de puertas  : "+ ((Automovil) a).getNumPuertas()+
                            " || Color : " + ((Automovil) a).getColor());
            }else{
                if(a instanceof Marcador){
                    System.out.println("--------------------------------------------"+
                        "----------------------------");
                    System.out.println("Marcador. Tapa : "+ ((Marcador) a).isTapa()+ 
                            " Grosor : "+ ((Marcador) a).getGrosor()+
                            " Color : " + ((Marcador) a).color);
                }
            }
        }
        System.out.println("\n El contador es : " + contador.getCuenta());
        
    }
}
