
package metodonumerico;

import org.mariuszgromada.math.mxparser.*;
import java.util.*;
import Jama.*;


public abstract class Utilidad {
      
    static final String texto_Error_Funcion = "Error: La resolución de una función no devolvió un numero %n Se recomienda revisra si la función se ingresó correctamente";    
    
    public static Double funcionX(String stringFuncion, Double X){
        
        Function f = new Function(stringFuncion);
        Double resultado = f.calculate(X);
        
        if (resultado.isNaN() || resultado.isInfinite()) {
            System.out.println("FUNCIÓN -> " + stringFuncion);
            System.out.println("PARAMETRO -> " + X);
            System.out.printf(texto_Error_Funcion);
        }
       
        return resultado;
    }
    
    
    public static Double funcionXY(String stringFuncion, Double X, Double Y){
        
        Function f = new Function(stringFuncion);
        Double resultado = f.calculate(X,Y);
        
        if (resultado.isNaN() || resultado.isInfinite()) {
            System.out.println("FUNCIÓN -> " + stringFuncion);
            System.out.println("PARAMETRO X -> " + X);
            System.out.println("PARAMETRO Y -> " + Y);
            System.out.printf(texto_Error_Funcion);
        }
        
        return resultado;
    }
    
 
    // Evalua una funcion f en varios puntos a la vez
    public static Double[] funcionX(String stringFuncion, Double[] X){
        
        int cantidadParametros = X.length;
        Double[] resultados = new Double[cantidadParametros];
        
        for(int i=0; i < cantidadParametros; i++){
            Utilidad.funcionX(stringFuncion, X[i]);
        }
        
        return resultados;
    }

    
    
    
}
