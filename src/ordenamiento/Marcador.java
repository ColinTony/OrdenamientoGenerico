package ordenamiento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author colin
 */

public class Marcador implements Comparable<Marcador>{
    
    public Color color;
    public float grosor;
    public boolean tapa;
    private Random rnd;
    private Color[] colores;
    
    
    /**
     * constructor para generar datos aleatorios
     */
    public Marcador() {
        this.rnd = new Random();
        this.colores = Color.values();
        this.color = colores[rnd.nextInt(colores.length)];
        this.grosor = 1.0f + (5.0f - 1.0f) * rnd.nextFloat();
        this.tapa = rnd.nextBoolean();
    }

    /**
     * Generar copias del arreglo
     */
    public static List<Marcador> copiaMarcador(List <Marcador> lista){
        List<Marcador> copia = new ArrayList<>(100);
        for (int i = 0; i<100; i++ ){
            copia.add(i,lista.get(i));
        }
        return copia;
    }
    // constructor para especificar los datos

    /**
     *
     * @param color elegido del tipo enum
     * @param grosor seran definido aleatoriamente
     * @param tapa sea true o false 
     * 
     * Constructor para definir los datos de la clase marcador
     */
    public Marcador(Color color, float grosor, boolean tapa) {
        this.color = color;
        this.grosor = grosor;
        this.tapa = tapa;
    }
     /**
     * Posibles colores tipo enum
     */
    public enum Color{
        Amarillo , Azul , Rojo;
    }
    // getters y setters de atributos
    public Color getColor() {
        return color;
    }
 
    /**
     *
     * @param color detalla el color del marcador
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return Devuelve el grosor del marcador
     */
    public float getGrosor() {
        return grosor;
    }

    /**
     *
     * @param grosor espeficica el grosor del marcador
     */
    public void setGrosor(float grosor) {
        this.grosor = grosor;
    }

    /**
     *
     * @return devuelve true o false si tiene tapa
     */
    public boolean isTapa() {
        return tapa;
    }

    /**
     *
     * @param tapa especifica si el marcador cuenta con tapa
     */
    public void setTapa(boolean tapa) {
        this.tapa = tapa;
    }
    
    /**
     *
     * @param marcador objeto a comparar
     * @return devolvera un numero positivo , negativo o 0
     * Este metodo nos ayuda a ordenarlo por grosor
     */
    public int comparacionGrosor(Marcador marcador){
        float aux = this.grosor - marcador.getGrosor();
        if(aux > 0){
            return 1;
        }else{
            if(aux < 0){
             return -1;   
            }else{
                return 0;
            }
        }
    }

    /**
     *
     * @param marcador el objeto a comparar
     * @return devolvera numero mayor , menor o igual a cero
     * Esto nos ayudara para ordenarlo por Color
     */
    public int compareColor(Marcador marcador){
        return this.color.compareTo(marcador.getColor());
    }
    
    /**
     *
     * @param marcador objeto a comparar
     * @return regresa un numero mayor , menor o igual a cero 
     * Esto ayuda a ordenar por Tapa
     */
    public int compareTapa(Marcador marcador){
        if(marcador.isTapa() && !this.isTapa()){ // si tiene tapa y la otra no
            return 1; // el que tiene tapa va primero
        }else{
            if(this.isTapa() && !marcador.isTapa()){ // si tiene tapa y el otro no
                return -1;
            }else{
                return 0;
            }
        }
    }
    // Este compareTo , compara Si son amarillo con tapa van primero y se ordenaran
    // por tamaño del grosor ... Se seguiran con los azules con tapa y se ordenan de
    // igual forma por el grosor  , al final seran los maracadores rojos , poniendo
    // primero si son rojos con tapa y al mismo tiempo ordenados por grosor
    @Override
    public int compareTo(Marcador marcador) {
        int rptGrosor = comparacionGrosor(marcador); // valores de ordenamiento
        int rptTapa = compareTapa(marcador); // valor menor, mayor o igual a cero
        int rptColor = compareColor(marcador);// valor menor,mayor o igual a cero
        
        if(rptColor != 0){ // si el valor es diferente a cero
            return rptColor; // se devolvera un valor ya sea menor o mayor a cero
        }else{
            if(rptTapa !=0){ // de igual forma si el valor es diferente a cero con metodo de tapa
                return rptTapa;
            }else{
                if(rptGrosor != 0){ // si es diferente a cero en el compareTo de grosor
                    return rptGrosor;
                }else{
                    if(rptTapa !=0){ // si el valor del compareTo tapa es dif. a cero
                        return rptTapa;
                    }else{
                        return 0; // El valor es cero por lo tanto son guales
                    }
                }
            }
        }
    }
}
