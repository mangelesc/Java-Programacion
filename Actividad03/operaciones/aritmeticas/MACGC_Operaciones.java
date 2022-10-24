package MACGCactividad03.operaciones.aritmeticas;

//importamos los packages necesarios
import static MACGCactividad03.introduceDatos.MACGC_Pregunta.pideDouble;

public class MACGC_Operaciones {

    //Función con la que mostramos por pantalla el logaritmo en base E del parámetro.
    public static void muestraLogaritmo() {
        double MACGC_valor = pideDouble ("Ángeles, introduce el valor para calcular el Logaritmo");
        System.out.println("El valor del logaritmo es_ " + Math.log(MACGC_valor));
    }
    
    /*Función para muestre por pantalla el resultado de elevar el primer parámetro  
    al segundo utilizando la función pow de la clase Math*/
    public static void calculaPotencia() {
        double MACGC_parametro1 = pideDouble ("Ángeles, introduce el valor que quieras elevar");
        double MACGC_parametro2 = pideDouble ("Ángeles, ¿a qué valor quieres elever el número anteriormente introducido?");
        System.out.println("El resultado de la operación es: " + Math.pow(MACGC_parametro1, MACGC_parametro2));
    }
    
}
