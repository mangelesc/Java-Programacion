package MACGC_Actividad06.Menu;

import static MACGC_Actividad06.Controles.MACGC_PedirDatos.pideMinMax;
import MACGC_Actividad06.vehiculos.MACGC_Alquilable;

public class MACGC_Menu {

    //Definimos una función para mostrar un array.
    /*En la clase main he definido los tres arrays de tipo MACGC_Alquilable, para poder reutilizar esta función en las tres opciones
    del menú que nos pide la actividad*/
    public static void Mostrar(MACGC_Alquilable[] array_macgc) {
        for (int k = 0; k < array_macgc.length; k++) {
            System.out.println(k + 1 + "-. " + array_macgc[k]);
        };
    }

    //Definimos una función para reiniciar el alquiler
    /*Esta opción inicia de nuevo un array con información que selecciona el usuario de otros dos arrays a parte. Muestra por pantalla
    las opciones hasta completar el tamaño del array que ha elegido el usuario.*/
    public static MACGC_Alquilable[] ReiniciarAlquiler(MACGC_Alquilable[] array1_macgc, MACGC_Alquilable[] array2_macgc,
            MACGC_Alquilable[] array3_macgc) {
        int totalAlquilar_macgc = pideMinMax(1, 5, "Ángeles, ¿cuántos vehículos y/o seguros quieres alquilar?");
        array3_macgc = new MACGC_Alquilable[totalAlquilar_macgc];
        int numAlquinados_macgc = 0;
        do {
            System.out.println("ALQUILER DE ÁNGELES (" + numAlquinados_macgc + " de " + totalAlquilar_macgc + " opciones elegidas)");
            int opc_macgc = pideMinMax(1, 2, "Ángeles, elige una de las siguientes opciones: \n1. Vehículo \n2. Seguro");
            switch (opc_macgc) {
                case 1:
                    System.out.println("\nFLOTA DE VEHÍCULOS DISPONIBLES:");
                    Mostrar(array1_macgc);
                    int nVehiculo_macgc = pideMinMax(1, array1_macgc.length, "¿Qué vehículo quieres añadir? Indica su número.");
                    array3_macgc[numAlquinados_macgc] = array1_macgc[nVehiculo_macgc - 1];
                    break;
                case 2:
                    System.out.println("\nFLOTA DE SEGUROS DISPONIBLES:");
                    Mostrar(array2_macgc);
                    int nSeguro_macgc = pideMinMax(1, array2_macgc.length, "¿Qué seguro quieres añadir? Indica su número.");
                    array3_macgc[numAlquinados_macgc] = array1_macgc[nSeguro_macgc - 1];
                    break;
            }
            numAlquinados_macgc++;

        } while (numAlquinados_macgc < totalAlquilar_macgc);

        System.out.println("Genial, ¡has completado el proceso de alquiler!");
        return array3_macgc;
    }

    /*Definimos una función para establecer los días de alquiler. Esta opción debe pedir al usuario un número entre 1 y 30 
    y establecer ése número de días de alquiler para todos los elementos del array */
    public static void EstablecerDiasAlquiler(MACGC_Alquilable[] array_macgc) {
        int numdias_macgc = pideMinMax(0, 30, "Ángeles, ¿para cuantos días quieres el alquiler?");
        for (int k = 0; k<array_macgc.length; k++) {
            array_macgc[k].setNumeroDias(numdias_macgc);
        }
        System.out.println("El periodo de alquiler se ha actualizado a " + numdias_macgc + ".");

    }

}
