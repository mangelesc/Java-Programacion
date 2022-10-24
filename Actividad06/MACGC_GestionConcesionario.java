package MACGC_Actividad06;

import MACGC_Actividad06.Controles.MACGC_PedirDatos;
import static MACGC_Actividad06.Menu.MACGC_Menu.*;
import MACGC_Actividad06.seguros.MACGC_Seguro;
import MACGC_Actividad06.vehiculos.MACGC_Alquilable;
import MACGC_Actividad06.vehiculos.MACGC_Carga;
import MACGC_Actividad06.vehiculos.MACGC_Coche;
import MACGC_Actividad06.vehiculos.MACGC_Vehiculo;

import java.io.IOException;

public class MACGC_GestionConcesionario {

    public static void main(String[] args) throws IOException {
        //Creamos los objetos de seguro, coche y carga
        MACGC_Seguro seguroMA1 = new MACGC_Seguro("Seguro a todo riesgo", "Cubre todo tipo de daños", 5);
        MACGC_Seguro seguroMA2 = new MACGC_Seguro("Seguro a terceros", "Cubre daños causados por terceros", 7);

        MACGC_Coche cocheMA1 = new MACGC_Coche("MACGC01", "Seat Ibiza", 2, 12, "A");
        MACGC_Coche cocheMA2 = new MACGC_Coche("MACGC02", "Ford Fiesta", 5, 17, "C");

        MACGC_Carga cargaMA1 = new MACGC_Carga("MACGC03", "Citroen Berlingo", 7, 30, 12);
        MACGC_Carga cargaMA2 = new MACGC_Carga("MACGC04", "Ford Tourneo", 8, 20, 45);

        //Definimos los arrays, de tipo MACGC_Alquilable, de manera que sólo necesito usar una función para las opciones 1, 2 y 5 del menu
        MACGC_Alquilable[] seguros_macgc = new MACGC_Alquilable[2];
        seguros_macgc[0] = seguroMA1;
        seguros_macgc[1] = seguroMA2;

        MACGC_Alquilable[] flota_macgc = new MACGC_Alquilable[4];
        flota_macgc[0] = cocheMA1;
        flota_macgc[1] = cocheMA2;
        flota_macgc[2] = cargaMA1;
        flota_macgc[3] = cargaMA2;

        MACGC_Alquilable[] alquiler_macgc = new MACGC_Alquilable[5];

        int macgc_opcion;
        do {
            //Mostramos por pantalla las opciones del menú
            System.out.println("\nÁngeles, ¿qué acción quieres hacer?");
            System.out.println("1. Mostrar la información de la flota.");
            System.out.println("2. Mostrar la información de los seguros disponible.");
            System.out.println("3. Reiniciar el alquiler indicando el total de vehículos y seguros que se quiere alquilar (entre 1 y 5).");
            System.out.println("4. Establecer el número de días del alquiler.");
            System.out.println("5. Mostrar el alquiler.");
            System.out.println("0. Salir");

            macgc_opcion = MACGC_PedirDatos.pideMinMax(0, 5, "");

            //Usamos un swith para crear el menú
            switch (macgc_opcion) {

                case 1:
                    System.out.println("\nFLOTA DE VEHÍCULOS DISPONIBLES:");
                    Mostrar(flota_macgc);
                    break;
                case 2:
                    System.out.println("\nFLOTA DE SEGUROS DISPONIBLES:");
                    Mostrar(seguros_macgc);
                    break;
                case 3:
                    alquiler_macgc = ReiniciarAlquiler(flota_macgc, seguros_macgc, alquiler_macgc);
                    break;
                case 4:
                    EstablecerDiasAlquiler(alquiler_macgc);
                    break;
                case 5:
                    System.out.println("\nÁNGELES, ESTE ES EL ESTADO ACTUAL DE TU ALQUILER:");
                    Mostrar(alquiler_macgc);
                    break;
                case 0:
                    System.out.println("Ángeles, has salido correctamente del programa");
                    break;
            }
        } while (macgc_opcion != 0);
    }
}
