package MACGCactividad03.operaciones;

//importamos los packages necesarios
import static MACGCactividad03.introduceDatos.MACGC_Pregunta.*;

public class MACGC_Valores {

//utilizamos voids, ya que las funciones no devuelven ningún valor
    public static void muestraPI() {
        //LLamamos a la función PI de la clase Math para sacar por pantalla el valor de PI
        System.out.println("El valor de PI es: " + Math.PI);
    }

    public static void muestraValorAbsoluto() {
        double MACGC_valor = pideDouble("Introduce un valor para calcular su valor absoluto");
        //Llamamos a la función abs de la clase Math
        double MACGC_vabsoluto = Math.abs(MACGC_valor);
        //Imprimimos por pantalla
        System.out.println("El valor absoluto de " + MACGC_valor + " es: " + MACGC_vabsoluto);
    }

    public static void muestraValorAleatorio() {
        //Llamamos a la función pideEntero, que hemos creado anteriormente
        int MACGC_valor = pideEntero("Introduce el valor máximo deseado para mostrar un número aleatorio");
        /*La función Math.random saca valores entre 0 y 1, por lo que la multiplicamos por el valor introducido
        por el usuario para conseguir un valor entre 0 y ese valor*/
        double MACGC_aleatorio = Math.random() * MACGC_valor;
        //Convertimos el double a int, para que saque por pantalla un número entero
        int MACGC_valorint = (int) MACGC_aleatorio;
        //Imprimimos por pantalla
        System.out.println("Un número aletorio entre 0 y " + MACGC_valor + " es: " + MACGC_valorint);
    }
    
}
