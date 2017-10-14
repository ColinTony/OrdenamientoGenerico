package ordenamiento;

import java.math.BigInteger;

/**
 * @author Millan Reyes Yael
 * @author Velasco Antunez Melanie
 * @version 1.0
 */

public class Contador {
    private BigInteger cuenta;
    
    // constructor 
    public Contador() {
        this.cuenta = BigInteger.ZERO;
    }
    
    public BigInteger getCuenta (){
        return this.cuenta;
    }
    public void contar(){
        this.cuenta = this.cuenta.add(BigInteger.ONE);
    }
    public void contar(int numero){
        this.cuenta = this.cuenta.add(BigInteger.valueOf(numero));
    }
    public void resetear(){
        System.out.println("El contador se reseteo");
        this.cuenta = BigInteger.ZERO;
    }   
}
