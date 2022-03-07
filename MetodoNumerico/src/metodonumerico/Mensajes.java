
package metodonumerico;

public abstract class Mensajes {
    
    public static String errorMetodoCerrado1 = "ERROR: La función no presenta una raíz dentro del rango definido %n Puede que en el rango haya 2 raíces en lugar de uno.";
    public static String errorMetodoCerrado2 = "ERROR: La raíz de la función definida se encuentra en uno de los valores de X ingresados como límites de iteración.";
    public static String errorProcesadoFuncion = "ERROR: La resolución de una función no devolvió un numero %n Se recomienda revisar si la función se ingresó correctamente.";
    public static String errorMetodoNewton = "ERROR: La función analizada en cierto punto presenta una pendiente 0 (la función es constante), por lo que el método falla. %n Esto puede deberse a que el punto en el que el método procesó se encuentra en un máximo o un mínimo.";
    public static String errorMetodoSecante = "ERROR: La recta secante generada por el método presenta una pendiente 0 (es constante), %n por lo que nunca llega a cortar con el eje X y el método falla.";
    
}
