package MACGC_Actividad06.Controles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Reutilizamos el código de la actividad anterior para crear las funciones que usaremos para introducir datos
public class MACGC_PedirDatos {

    //Creamos la función pideString para números con decimales
    public static String pideString(String MACGC_pregunta) {
        String MACGC_string;
        do {
            //Imprimomos por pantalla la pregunta pedida por parámetro
            System.out.println(MACGC_pregunta);
            //Hacemos el control de errores
            try {
                BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
                MACGC_string = MACGC_br.readLine();
                break;
                //Hacemos el control de errores
            } catch (Exception e) {
                System.out.println("Ups! Ha habido un error");
            }
        } while (true);
        return MACGC_string;
    }

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

    //Creamos una función para definir un valor máximo y mínimo del menú, mediante pideEntero
    public static int pideMinMax(int macgc_valorMin, int ValorMax, String MACGC_pregunta) {
        int macgc_valor = 0;
        //Imprimomos por pantalla la pregunta pedida por parámetro
        System.out.println(MACGC_pregunta);
        do {
            macgc_valor = pideEntero("Angeles, introduce un valor entre " + macgc_valorMin + " y " + ValorMax);
            if ((macgc_valor < macgc_valorMin) || (macgc_valor > ValorMax)) {
                System.out.println("Ups! El valor debe ser entre " + macgc_valorMin + " y " + ValorMax);
            }
        } while ((macgc_valor < macgc_valorMin) || (macgc_valor > ValorMax));
        return macgc_valor;
    }

}
