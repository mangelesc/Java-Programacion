package MACGC_Actividad07;

import MACGC_Actividad07.Controles.MACGC_PedirDatos;
import MACGC_Actividad07.ExcepcionesPropias.*;
import static MACGC_Actividad07.MACGC_Menu.*;
import MACGC_Actividad07.Persona.MACGC_Persona;
import java.util.ArrayList;
import java.util.HashMap;

public class MACGC_GestionaPersonas {

    public static void main(String[] args) throws DemasiadosObjetosMACGC {

        //Definimos un HashMap para almacenar un grupo de trabajadores según su DNI(String)
        HashMap<String, MACGC_Persona> trabajadores_macgc = new HashMap<>();
        //Definimos un ArrayList para almacenar las personas que formarán parte del grupo de trabajo.
        ArrayList<MACGC_Persona> grupoTrabajo_macgc = new ArrayList<>();

        //Añadimos dos personas a trabajadores_macgc, captando las posibles exceptions (previamente definidas), con un try/catch
        try {
            trabajadores_macgc.put("12345678A", new MACGC_Persona("Ángeles", 30, "12345678A"));
            trabajadores_macgc.put("87654321B", new MACGC_Persona("Daniel", 30, "87654321B"));
        } catch (NombreIncorrectoMACGC | EdadIncorrectaMACGC | DNIIncorrectoMACGC e) {
            e.printStackTrace();
        }

        int macgc_opcion;
        do {
            //Mostramos por pantalla las opciones del menú
            System.out.println("\nÁngeles, ¿qué acción quieres hacer?");
            System.out.println("1. Añadir una persona.");
            System.out.println("2. Quitar una persona.");
            System.out.println("3. Añadir una persona del grupo de trabajo.");
            System.out.println("4. Quitar una persona del grupo de trabajo.");
            System.out.println("0. Salir");

            macgc_opcion = MACGC_PedirDatos.pideMinMax(0, 4, "");

            //Usamos un swith para crear el menú
            switch (macgc_opcion) {

                case 1:
                    AñadirAHashMapMACGC(trabajadores_macgc, "\nNUEVA PERSONA A AÑADIR: ");
                    MostrarHashMapMACGC(trabajadores_macgc, "\nLISTADO DE TRABAJADORES:");
                    MostrarArrayListMACGC(grupoTrabajo_macgc, "\nLISTADO DEL GRUPO DE TRABAJO:");
                    break;
                case 2:
                    QuitarAHashMapMACGC(trabajadores_macgc, "\nPERSONA A ELIMINAR: ");
                    MostrarHashMapMACGC(trabajadores_macgc, "\nLISTADO DE TRABAJADORES:");
                    MostrarArrayListMACGC(grupoTrabajo_macgc, "\nLISTADO DEL GRUPO DE TRABAJO:");
                    break;
                case 3:
                    try {
                        AñadirAArrayList(grupoTrabajo_macgc, trabajadores_macgc, "\nPERSONA A AÑADIR EN GRUPO DE TRABAJO: ");
                    } catch (DemasiadosObjetosMACGC e) {
                        e.printStackTrace(System.out);
                    }
                    MostrarHashMapMACGC(trabajadores_macgc, "\nLISTADO DE TRABAJADORES:");
                    MostrarArrayListMACGC(grupoTrabajo_macgc, "\nLISTADO DEL GRUPO DE TRABAJO:");
                    break;
                case 4:
                    try {
                        QuitarAArrayList(grupoTrabajo_macgc, "\nPERSONA A ELIMINAR EN GRUPO DE TRABAJO: ");
                    } catch (PosicionIncorrectaMACGC e) {
                        e.printStackTrace(System.out);
                    }
                    MostrarHashMapMACGC(trabajadores_macgc, "\nLISTADO DE TRABAJADORES:");
                    MostrarArrayListMACGC(grupoTrabajo_macgc, "\nLISTADO DEL GRUPO DE TRABAJO:");
                break;
                case 0:
                    System.out.println("Ángeles, la gestión final de personas es:");
                    MostrarHashMapMACGC(trabajadores_macgc, "\nLISTADO DE TRABAJADORES:");
                    MostrarArrayListMACGC(grupoTrabajo_macgc, "\nLISTADO DEL GRUPO DE TRABAJO:");
                    System.out.println("Gracias, has salido correctamente del programa");
                    break;
            }
        } while (macgc_opcion != 0);

    }
}
