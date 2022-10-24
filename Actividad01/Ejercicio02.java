package MACGC_Actividad02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MACGC_Ejercicio02 {

    public static void main(String[] args) throws IOException {
        //Declaramos las variables
        int i, j, MACGC_opcion;
        String[][] MACGC_puntuaciones = new String[4][4];
        BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
        
        // Intruducimos valores en el array bidimensional
        MACGC_puntuaciones[0][0] = "M01";
        MACGC_puntuaciones[0][1] = "8";
        MACGC_puntuaciones[0][2] = "5";
        MACGC_puntuaciones[0][3] = "10";
        MACGC_puntuaciones[1][0] = "M02";
        MACGC_puntuaciones[1][1] = "3";
        MACGC_puntuaciones[1][2] = "8";
        MACGC_puntuaciones[1][3] = "9";
        MACGC_puntuaciones[2][0] = "M03";
        MACGC_puntuaciones[2][1] = "9";
        MACGC_puntuaciones[2][2] = "7";
        MACGC_puntuaciones[2][3] = "6";
        MACGC_puntuaciones[3][0] = "M04";
        MACGC_puntuaciones[3][1] = "10";
        MACGC_puntuaciones[3][2] = "4";
        MACGC_puntuaciones[3][3] = "9";
        
        //Sacamos los valores por pantalalla. Para ello usamos un bucle for para las dos posiciones del array                                        
        System.out.println("Ángeles, los valores del array bidimensional son:");
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                System.out.print(MACGC_puntuaciones[i][j] + "   ");
            }
            System.out.println("");
        }
        //Sacamos por pantalla información sobre las opciones del menú
        do {
            System.out.print("\n Ángeles, introduce una opción: \n" + "1. Mostrar el nombre de las asignaturas.\n" + 
            "2. Mostrar la puntuación mayor de cada uno de las asignaturas.\n" + "3. Modificar la puntuación de una asignatura.\n" 
            + "4. Mostrar todos los valores del array bidimensional.\n" + "0. Salir. \n");
            //Controlamos los posibles "errores" de introduccion por teclado (valores que no corresponden a ninguna opción)
            try {
                MACGC_opcion = Integer.parseInt(MACGC_br.readLine());
            } catch (Exception e) {
                MACGC_opcion = -1;
            }
            
            //Escribimos las diferentes opciones con un switch
            switch (MACGC_opcion) {
                
                case 0:
                    System.out.println("Ángeles, has salido del programa.");
                    break;
                
                case 1:
                    System.out.println("Ángeles, las asignaturas introducidas son: ");
                    for (i = 0; i < 4; i++) {
                        System.out.print(MACGC_puntuaciones[i][0] + "   ");
                    }
                    break;
                
                case 2:
                    //Declaramos variable locales
                    Double MACGC_valormax = 0.0;
                    //Usamos un bucle for para calcular la mayor puntuación, comparando los valores de las posiciones
                    for (j = 0; j < 4; j++) {
                        MACGC_valormax = Double.parseDouble(MACGC_puntuaciones[j][1]);
                        for (i = 2; i < 4; i++) {
                            if (MACGC_valormax < Double.parseDouble(MACGC_puntuaciones[j][i])) {
                                MACGC_valormax = Double.parseDouble(MACGC_puntuaciones[j][i]);
                            }
                        }
                        System.out.println("Ángeles, el valor máximo de " + MACGC_puntuaciones[j][0] + " es: " + MACGC_valormax);
                    }
                    break;

                case 3:
                    //Declaramos variable locales
                    int asignatura,
                     posicion_puntuacion,
                     n_puntuacion;
                    // Indicamos el número de la asignatura
                    // Controlamos los posibles "errores" de introduccion por teclado (valores que no corresponden a ninguna opción)
                    do {
                        System.out.println("Indica el número de asignatura (entre 0 y 3) de la que quieres cambiar un valor");
                        //En caso de que se introducca un valos no numérico
                        try {
                            asignatura = Integer.parseInt(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            asignatura = -1;
                        }
                        //En caso de que se introduzca un valor numérico fuera de rango
                        if ((asignatura < 0) || (asignatura > 3)) {
                            System.out.println("Ups! El valor debe ser entre 0 y 3");
                        }
                    } while ((asignatura < 0) || (asignatura > 3));

                    //Indicamos la posición de la puntuación (entre 1 y 3 que quieres cambiar)
                    do {
                        System.out.println("Introduce la posición de la puntuación que quieres cambiar (entre 1 y 3).");
                        try {
                            posicion_puntuacion = Integer.parseInt(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            posicion_puntuacion = -1;
                        }
                        if ((posicion_puntuacion < 1) || (posicion_puntuacion > 3)) {
                            System.out.println("Ups! El valor debe ser entre 1 y 3");
                        }
                    } while ((posicion_puntuacion < 1) || (posicion_puntuacion > 3));
                    System.out.println("El valor actual de la posición " + asignatura + "," + posicion_puntuacion + " es " + MACGC_puntuaciones[asignatura][posicion_puntuacion] + "   ");

                    //Indicamos el valor de la nueva puntuación
                    do {
                        System.out.println("Indica el valor de la nueva puntuación (entre 0 y 10)");
                        try {
                            n_puntuacion = Integer.parseInt(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            n_puntuacion = -1;
                        }
                        if ((n_puntuacion < 0) || (n_puntuacion > 10)) {
                            System.out.println("Ups! El valor debe ser entre 0 y 10");
                        }
                    } while ((n_puntuacion < 0) || (n_puntuacion > 10));
                    
                    //Asignamos el nuevo valor e imprimimos por pantalla la información
                    MACGC_puntuaciones[asignatura][posicion_puntuacion] = Integer.toString(n_puntuacion);
                    System.out.print("Ángeles, los nuevos valores de " + MACGC_puntuaciones[asignatura][0] + " son ");
                    for (i = 1; i < 4; i++) {
                        System.out.print(MACGC_puntuaciones[asignatura][i] + "  ");
                    }
                    break;
                
                //Mostramos los valores del array bidimensional
                case 4:
                    System.out.println("Ángeles, los valores del array bidimensional son: ");
                    for (i = 0; i < 4; i++) {
                        for (j = 0; j < 4; j++) {
                            System.out.print(MACGC_puntuaciones[i][j] + "   ");
                        }
                        System.out.println("");
                    }
                    break;
                
                default:
                    System.out.println("Ups! Has introducido un valor no válido");
            }
        } while (MACGC_opcion != 0);
    }
}