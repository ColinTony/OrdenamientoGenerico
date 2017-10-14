package ordenamiento;

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
        Amarillo , Rojo , Azul;
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
    
    
    @Override
    public int compareTo(Marcador marcador) {
        return this.color.compareTo(marcador.getColor());
    }
    
}
