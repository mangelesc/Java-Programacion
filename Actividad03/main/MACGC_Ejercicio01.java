package MACGCactividad03.main;

//importamos los packages necesarios
import MACGCactividad03.introduceDatos.MACGC_Pregunta;
import static MACGCactividad03.operaciones.MACGC_OperacionesLinkia.*;
import static MACGCactividad03.operaciones.MACGC_Valores.*;
import static MACGCactividad03.operaciones.aritmeticas.MACGC_Operaciones.*;
import static MACGCactividad03.operaciones.geometricas.MACGC_Operaciones.*;

public class MACGC_Ejercicio01 {

    //Creamos el main, ya que será un class ejecutable
    public static void main(String[] args) {
        //Creamos la variable, que luego usaremos en el switch para 
        int MACGC_opcion;
        do {
            //Mostramos por pantalla las opciones del menú
            System.out.println("Ángeles, ¿qué acción quieres hacer?");
            System.out.println("1 - Convertir un valor a Linkia Coins");
            System.out.println("2 - Mostrar el valor de PI");
            System.out.println("3 - Calcular el valor absoluto de una cantidad");
            System.out.println("4 - Generar un valor aletario introduciendo cantidad máxima");
            System.out.println("5 - Mostrar logaritmo de un valor");
            System.out.println("6 - Carcular potencia. Primero valor elevado al segundo valor");
            System.out.println("7 - Carcular el seno de un valor");
            System.out.println("8 - Carcular el coseno de un valor");
            System.out.println("0 - Salir");
            
            MACGC_opcion = MACGC_Pregunta.pideEntero("Ángeles, introduce el número de de la accion que deseas realizar");

            //Usamos un swith para crear el menú
            switch (MACGC_opcion) {
                
                //Llamamos a las funciones que ya hemos creado anteriormente
                case 1:
                    convertirLinkiaCoins();
                    break;
                case 2:
                    muestraPI();
                    break;
                case 3:
                    muestraValorAbsoluto();
                    break;
                case 4:
                    muestraValorAleatorio();
                    break;
                case 5:
                    muestraLogaritmo();
                    break;
                case 6:
                    calculaPotencia();
                    break;
                case 7:
                    muestraSeno();
                    break;
                case 8:
                    muestraCoseno();
                    break;
                case 0:
                    System.out.println("Ángeles, has salido correctamente del programa");
                    break;
            }

        } while (MACGC_opcion != 0);
    }
}


