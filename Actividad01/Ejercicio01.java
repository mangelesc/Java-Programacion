package MACGC_Actividad02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MACGC_Ejercicio01 {

    public static void main(String[] args) throws IOException {
        //Declaramos las variables
        int i,MACGC_opcion, MACGC_posicion;
        double MACGC_valor, MACGC_total;
        double[] MACGC_recipientes = new double[5];
        BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
     
        //Imprimimos por pantalla los valores iniciales
        System.out.println("Ángeles, los valores iniciales son:");
        for(i=0; i<5; i++){
            MACGC_recipientes[i]= 0;
        }
        for(i=0; i<5; i++){
            System.out.println("El recipiente " + i + " contiene: " + MACGC_recipientes[i] + "litros");
        }
        
        //Imprimimos por pantalla las opciones del menú
        do {
            System.out.println("\n Ángeles, introduce una opción: \n" + "1. Añadir refresco a un recipiente.\n" + 
            "2. Quitar refresco de un recipiente.\n" + "3. Calcular el total de refresco.\n" + "0. Salir. \n");
            try {
                MACGC_opcion = Integer.parseInt(MACGC_br.readLine());
            //Captamos las excepciones
            }catch (Exception e){
                MACGC_opcion=-1;
            }
            //Usamos un switch para crear el menú
            switch (MACGC_opcion) {
                case 0:
                    System.out.println("Ángeles, has salido del programa.");
                    break;
                case 1:
                    do {
                        System.out.println("Ángeles, introduce el número de recipiente (entre 0 y 4)");
                        try {
                            MACGC_posicion = Integer.parseInt(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            MACGC_posicion = -1;
                        }
                        if ((MACGC_posicion < 0) || (MACGC_posicion > 4)) {
                            System.out.println("Ups! El valor debe ser entre 0 y 4");
                        }
                    } while ((MACGC_posicion < 0) || (MACGC_posicion > 4));
                    //Pedir valor y sus controles
                    do {
                        System.out.println("Introduce la cantidad a ingresar en el recipiente " + MACGC_recipientes[MACGC_posicion] + " :");
                        try {
                            MACGC_valor = Double.parseDouble(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            MACGC_valor = -1;
                        }
                    if (( MACGC_valor) < 0) {
                        System.out.println("Ups! El valor debe mayor que 0");
                    }
                    } while (( MACGC_valor) < 0);
                    
                    //Asignamos
                    MACGC_recipientes[MACGC_posicion] += MACGC_valor;
                    for(i=0; i<5; i++){
                    System.out.println("El nuevo valor de la posición " + i + " es: " + MACGC_recipientes[i] + "litros");
                    }
                    break; 
                            
                case 2: 
                    do {
                        System.out.println("Ángeles, introduce el número de recipiente (entre 0 y 4)");
                        try {
                            MACGC_posicion = Integer.parseInt(MACGC_br.readLine());
                        } catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            MACGC_posicion = -1;
                        }
                        if ((MACGC_posicion < 0) || (MACGC_posicion > 4)) {
                            System.out.println("Ups! El valor debe ser entre 0 y 4");
                        }
                    } while ((MACGC_posicion < 0) || (MACGC_posicion > 4));
                    
                    //Pedimos el valor y sus controles
                    do {
                        System.out.println("Introduce la cantidad a retirar del recipiente " + MACGC_posicion);
                        try {
                            MACGC_valor = Double.parseDouble(MACGC_br.readLine());
                        }catch (Exception e) {
                            System.out.println("Ups! El valor debe ser numérico");
                            MACGC_valor = -1;
                        }
                        if (( MACGC_valor) < 0) {
                        System.out.println("Ups! El valor no puede ser negativo");
                        }
                        if ((MACGC_recipientes[MACGC_posicion]-MACGC_valor)<0) {
                        System.out.println("Ups! El valor total del recipientes no puede ser negativo");
                        }
                    } while (( (MACGC_valor) < 0) || (MACGC_recipientes[MACGC_posicion]-MACGC_valor)<0);
                    
                    //Asignamos el nuevo valor y sacamos por pantalla
                    MACGC_recipientes[MACGC_posicion] -= MACGC_valor;
                    for(i=0; i<5; i++){
                        System.out.println("El valor actual del recipiente de la posición " + i + " es: " + MACGC_recipientes[i] + "litros");
                    }
                    break; 
                
                case 3: 
                    MACGC_total = 0;
                    for(i=0; i<5; i++){
                        MACGC_total = MACGC_total + MACGC_recipientes[i];
                    }
                    System.out.println("Ángeles, el estado actual  de recipientes es " + MACGC_total + "litros");
                    break;
                    
                default:
                    System.out.println("Ups, has introducido un valor no válido");
            }
        }while (MACGC_opcion != 0);
    }
}