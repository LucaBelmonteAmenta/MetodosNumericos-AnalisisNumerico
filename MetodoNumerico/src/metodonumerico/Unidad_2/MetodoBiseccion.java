
package metodonumerico.Unidad_2;

import java.util.*;
import metodonumerico.Mensajes;
import metodonumerico.Respuesta;
import metodonumerico.Utilidad;
import metodonumerico.Unidad_1.Error;


public abstract class MetodoBiseccion {
    
    public static Respuesta calcularRaiz(String funcion, double X0, double X1, Double tolerancia, int iteracionesMax){
                       
        Respuesta RTA = new Respuesta();

        // Se verifica si existe una raiz en la funcion dentro de la iteración delimitada por X0 y X1
        if( Utilidad.raizEnIteracion(funcion, X0, X1) ){
            
            Double x = Double.NaN; //Variable que almacenará el resultado aproximado obtenisdo de cada iteración 
            Double xAnterior = Double.NaN;
                        
            Double errorAproximado;
               
            int iteraciones = 0; //Contador de iteraciones realizadas
            
            boolean condicion1 ;
            boolean condicion2 ;
            boolean condicion3 ;
        
            List<Double> X0s = new ArrayList<>();
            List<Double> X1s = new ArrayList<>();
            List<Double> respuestasIteraciones = new ArrayList<>();    
                 
            do{
                
                iteraciones++; 
                
                x = (X0 + X1) / 2;
                
                if (iteraciones != 1) {                    
                    errorAproximado = Error.errorRelativoPorcentual(x, xAnterior);
                } else {
                    errorAproximado = 100.0;
                }
                
                xAnterior = x;
                
                X0s.add(X0);
                X1s.add(X1);
                respuestasIteraciones.add(x);
                
                if( Utilidad.raizEnIteracion(funcion, X0, x) ){
                    X1 = x;
                }
                else{
                    X0 = x;
                }
                
                condicion1 = Utilidad.funcionX(funcion, x) != 0;
                condicion2 = errorAproximado > tolerancia;
                condicion3 = iteraciones < iteracionesMax;

            } while(condicion1 && condicion2 && condicion3);
            
            
            String[] nombreColumnas = {"X0", "X1", "Calculo de la iteración"};
            
            RTA.resultadoFinal = x.toString();
            RTA.errorAproximado = errorAproximado;
            
            RTA.arrayDouble1 = X0s;
            RTA.arrayDouble2 = X1s;
            RTA.arrayDouble3 = respuestasIteraciones;
            
            RTA.nombresCamposTabla = nombreColumnas;
            
        } else if ( (Utilidad.funcionX(funcion, X0) * Utilidad.funcionX(funcion, X1)) != 0 ) {
        
            RTA.fallo = true;
            RTA.descripcionFallo = Mensajes.errorMetodoCerrado1;
            
        } else { 
        
            RTA.fallo = true;
            RTA.descripcionFallo = Mensajes.errorMetodoCerrado2;
            
        }
        
        return RTA;
        
    } 
    
    
}

