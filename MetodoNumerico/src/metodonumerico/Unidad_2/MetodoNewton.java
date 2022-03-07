
package metodonumerico.Unidad_2;

import java.util.*;
import metodonumerico.Mensajes;
import metodonumerico.Respuesta;
import metodonumerico.Utilidad;
import metodonumerico.Unidad_1.Error;

public class MetodoNewton {
    
    public static Respuesta calcularRaiz(String funcion, double X0, Double tolerancia, int iteracionesMax){
        
        Double x = Double.NaN; //Variable para el resultado
        Double xAnterior = Double.NaN;
        
        Double errorAproximado = Double.NaN;

        Respuesta RTA = new Respuesta();
            
        int iteraciones = 0; //Contador de iteraciones
        
        boolean condicion1 ;
        boolean condicion2 ;
        boolean condicion3 ;

        List<Double> respuestasIteraciones= new ArrayList<>();  
        
        Double derivadad_f_x0;
        Double f_x0;

        do{

            iteraciones++; 
            
            derivadad_f_x0 = Utilidad.derivadaFuncionX(funcion, X0);
            f_x0 = Utilidad.funcionX(funcion, X0);
            
            if (derivadad_f_x0 == 0) {
                RTA.fallo = true;
                break;
            } 
         
            x = X0 - (f_x0 / derivadad_f_x0);
            
            if (iteraciones != 1) {                    
                errorAproximado = Error.errorRelativoPorcentual(x, xAnterior);
            } else {
                errorAproximado = 100.0;
            }            

            xAnterior = x;

            respuestasIteraciones.add(x);

            X0 = x;

            condicion1 = Utilidad.funcionX(funcion, x) != 0;
            condicion2 = errorAproximado > tolerancia;
            condicion3 = iteraciones < iteracionesMax;

        } while(condicion1 && condicion2 && condicion3);
        
        if (RTA.fallo) {
            RTA.descripcionFallo = Mensajes.errorMetodoNewton;
        }
        
        RTA.resultadoFinal = x.toString();
        RTA.errorAproximado = errorAproximado;
        
        RTA.arrayDouble1 = respuestasIteraciones;
        
        String[] nombreColumnas = {"Calculo de la iteración"};
        RTA.nombresCamposTabla = nombreColumnas;
        
        return RTA;
        
    }   
    
}
