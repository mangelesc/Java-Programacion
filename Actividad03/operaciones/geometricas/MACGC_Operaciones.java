package MACGCactividad03.operaciones.geometricas;

//importamos los packages necesarios
import static MACGCactividad03.introduceDatos.MACGC_Pregunta.pideDouble;


public class MACGC_Operaciones {
    
    //Función con la que llamamos a pideDouble para obtener un número con decimales y muestre su seno
    public static void muestraSeno() {
        double MACGC_valor = pideDouble ("Ángeles, introduce el valor de un ángulo (0-360)");
        System.out.println("El seno de un ángulo de " + MACGC_valor + "º es " + Math.sin(MACGC_valor));
    }

    //Función con la que llamamos a pideDouble para obtener un número con decimales y muestre su coseno
    public static void muestraCoseno() {
        double MACGC_valor = pideDouble ("Ángeles, introduce el valor de un ángulo (0-360)");
        System.out.println("El coseno de un ángulo de " + MACGC_valor + "º es " + Math.cos(MACGC_valor));
    }
}
