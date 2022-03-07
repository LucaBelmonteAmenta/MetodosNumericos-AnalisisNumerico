
package metodonumerico;

import org.mariuszgromada.math.mxparser.*;
import java.util.*;
import Jama.*;


public abstract class Utilidad {
      
    
    public static Double funcionX(String stringFuncion, Double X){
        
        Function f = new Function(stringFuncion);
        Double resultado = f.calculate(X);
        
        if (resultado.isNaN() || resultado.isInfinite()) {
            System.out.println("FUNCIÓN -> " + stringFuncion);
            System.out.println("PARAMETRO -> " + X);
            System.out.printf(Mensajes.errorProcesadoFuncion);
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
            System.out.printf(Mensajes.errorProcesadoFuncion);
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
