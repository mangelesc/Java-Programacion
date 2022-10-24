package MACGCactividad03.introduceDatos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MACGC_Pregunta {

    //Creamos la función pideEntero para números enteros
    public static int pideEntero(String MACGC_pregunta) {
        int MACGC_numero = 0;
        do {
            //Imprimomos por pantalla la pregunta pedida por parámetro
            System.out.println(MACGC_pregunta);
            try {
                BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
                //Parseamos el caracter que introduce el usuario por pantalla a Int
                MACGC_numero = Integer.parseInt(MACGC_br.readLine());
                break;
            //Hacemos el control de errores
            } catch (Exception e) {
                System.out.println("Ups! Ángeles, no puede ser una letra");
            }
        } while (true);
        return MACGC_numero;
    }

    //Creamos la función pideDouble para números con decimales
    public static double pideDouble(String MACGC_pregunta) {
        double MACGC_numero = 0;
        do {
            //Imprimomos por pantalla la pregunta pedida por parámetro
            System.out.println(MACGC_pregunta);
            //Hacemos el control de errores
            try {
                BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
                //Parseamos el caracter que introduce el usuario por pantalla a Double
                MACGC_numero = Double.parseDouble(MACGC_br.readLine());
                break;
            //Hacemos el control de errores
            } catch (Exception e) {
                System.out.println("Ups! Ángeles, no puede ser una letra");
            }
        } while (true);
        return MACGC_numero;
    }
}


