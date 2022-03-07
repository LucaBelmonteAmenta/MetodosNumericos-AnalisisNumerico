
package metodonumerico.Unidad_2;


import java.util.*;
import metodonumerico.Mensajes;
import metodonumerico.Respuesta;
import metodonumerico.Utilidad;
import metodonumerico.Unidad_1.Error;


public class MetodoSecante {
    
    public static Respuesta calcularRaiz(String funcion, double X0, double X1, Double tolerancia, int iteracionesMax){
                
        Double x = Double.NaN; //Variable para el resultado
        Double xAnterior = Double.NaN;

        Respuesta RTA = new Respuesta();
            
        int iteraciones = 0; //Contador de iteraciones
        
        boolean condicion1 ;
        boolean condicion2 ;
        boolean condicion3 ;

        List<Double> X0s= new ArrayList<>();
        List<Double> X1s= new ArrayList<>();
        List<Double> respuestasIteraciones= new ArrayList<>();    
        
        Double f_x0 ;
        Double f_x1 ;

        do{

            iteraciones++; 
            
            f_x0 = Utilidad.funcionX(funcion, X0);
            f_x1 = Utilidad.funcionX(funcion, X1);     
            
            if (f_x0 == f_x1) {
                RTA.fallo = true;
                break;                
            }

            x = X1 - (  (f_x1 * (X1-X0)) 
                     / (f_x1 - f_x0)  );

            RTA.errorAproximado = Error.errorRelativoPorcentual(xAnterior, x);
            xAnterior = x;

            X0s.add(X0);
            X1s.add(X1);
            respuestasIteraciones.add(x);

            X0 = X1;
            X1 = x;

            condicion1 = Utilidad.funcionX(funcion, x) != 0;
            condicion2 = RTA.errorAproximado > tolerancia;
            condicion3 = iteraciones < iteracionesMax;

        } while(condicion1 && condicion2 && condicion3);
        
        if (RTA.fallo) {
            RTA.descripcionFallo = Mensajes.errorMetodoSecante;
        }

        RTA.resultadoFinal = x.toString();
        RTA.arrayDouble1 = X0s;
        RTA.arrayDouble2 = X1s;
        RTA.arrayDouble3 = respuestasIteraciones;
        String[] nombreColumnas = {"X0", "X1", "Calculo de la iteración"};
        RTA.nombresCamposTabla = nombreColumnas;
        
        return RTA;
        
    } 
     
}
