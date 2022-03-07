
package metodonumerico;

import java.util.List;


public class Respuesta {
    
    public Respuesta () { 
        this.fallo = false;
    }
    
    public String resultadoFinal;
    
    public Double errorAproximado;
    
    public int numeroIteraciones;
    
    public List<Double> arrayDouble1;
    public List<Double> arrayDouble2;
    public List<Double> arrayDouble3;
    
    public String[] arrayString1;
    public String[] arrayString2;   
    public String[] arrayString3;
    
    public Double[][] matriz1;
    public Double[][] matriz2;
    public Double[][] matriz3;
    
    public String[] nombresCamposTabla;
    
    /* Si fallo == true, entonces se presento un fallo en el
    metodo que devuelve el objeto de la clase Respuesta */
    public boolean fallo;
    
    public String descripcionFallo;
    
}