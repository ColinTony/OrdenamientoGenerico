package ordenamiento;

import java.util.Random;

/**
 *
 * @author colin
 */
public class Automovil implements Comparable<Automovil> {
    /*
        En dado caso que tuvieramos una clase llamada automovil. 
        Mientras esta clase implemente la clase Comparable y 
        ademas sea sobreescrito el metodo comparableTo.
        
        Se podra usar la lcase ordenador para ordenar dependiendo 
        el criterio.
    */
    private Random rnd;
    private int numPuertas;
    private Color color;
    private Color [] colores;
    private boolean convertible;

    /**
     * Crear un automovil con valores aleatorios
     */
    public Automovil() {
        this.rnd = new Random();
        this.colores = Color.values();
        this.color = colores[rnd.nextInt(colores.length)];
        this.numPuertas = 2 + rnd.nextInt(5-2);
        this.convertible = rnd.nextBoolean();
    }
    // Getters and Setters
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }
    
    /**
     *
     * @param auto objeto a comparar
     * @return
     */
    public int compareToConvertible(Automovil auto){
        if(auto.isConvertible() && !this.isConvertible()){ // si es convertible y el otro no
            return 1; // primero los convertibles
        }else{
            if(!auto.isConvertible() && this.isConvertible()){ // si no es conv. y el otro si
                return -1; // devolvemos que el objeto que es convertible va primero
            }else{
                return 0; // son iguales
            }
        }
    }
    
    /**
     *
     * @param auto objeto a comparar
     * @return devolvera un numero entero mayor , menor o igual a cero
     */
    public int compareToColor(Automovil auto){
        return this.color.compareTo(auto.getColor()); 
    }

    /**
     *
     * @param auto objeto automovil a comparar
     * @return Devuelve un numero entero mayor , menor o igual a cero
     */
    public int comparePuertas(Automovil auto){
        return this.numPuertas - auto.getNumPuertas();
    }
    @Override
    public int compareTo(Automovil automovil) {
        int rptPuertas = comparePuertas(automovil); // valores de ordenamiento
        int rptConvertible = compareToConvertible(automovil); // valor menor, mayor o igual a cero
        int rptColor = compareToColor(automovil);// valor menor,mayor o igual a cero
        
        if(rptColor != 0){ // si el valor es diferente a cero
            return rptColor; // se devolvera un valor ya sea menor o mayor a cero
        }else{
            if(rptConvertible !=0){ // de igual forma si el valor es diferente a cero con metodo de tapa
                return rptConvertible;
            }else{
                if(rptPuertas != 0){ // si es diferente a cero en el compareTo de grosor
                    return rptPuertas;
                }else{
                    if(rptConvertible !=0){ // si el valor del compareTo tapa es dif. a cero
                        return rptConvertible;
                    }else{
                        return 0; // El valor es cero por lo tanto son guales
                    }
                }
            }
        }
    }
    
    
    
    
    public enum Color{
        Azul , Blanco , Rojo;
    }
}
