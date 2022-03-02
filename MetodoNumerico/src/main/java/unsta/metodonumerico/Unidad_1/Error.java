
package unsta.metodonumerico.Unidad_1;


import java.util.*;

public abstract class Error {
    
    /* 
        Metodo para calcular el error´porcentual de un valor con respecto al valor dela iteración anterior.
        Este metodo sirve para determinar si un metodo iterativo se encuentra serca del estancamiento.
    */
    public static Double errorRelativoPorcentual(Double x0, Double x1){
        return Math.abs((x0 - x1)/x0) * 100;
    }
    
    
    public static Double errorTotalPorcentual(Double xVerdadero, Double xAproximado){
        return (xVerdadero - xAproximado) * 100;
    }
    
}
