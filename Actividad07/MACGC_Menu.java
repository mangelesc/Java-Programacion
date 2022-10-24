package MACGC_Actividad07;

import static MACGC_Actividad07.Controles.MACGC_PedirDatos.pideEntero;
import static MACGC_Actividad07.Controles.MACGC_PedirDatos.pideString;
import MACGC_Actividad07.ExcepcionesPropias.*;
import MACGC_Actividad07.Persona.MACGC_Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MACGC_Menu {

    //------TRABAJADORES------    
    //Muestra el contenido de un HashMap
    public static void MostrarHashMapMACGC(HashMap<String, MACGC_Persona> hashMap_macgc, String texto) {
        System.out.println(texto);
        Iterator i = hashMap_macgc.entrySet().iterator();
        while (i.hasNext()) {
            HashMap.Entry e = (HashMap.Entry) i.next();
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    //Añade un elemento a un HashMap
    public static void AñadirAHashMapMACGC(HashMap<String, MACGC_Persona> hashMap_macgc, String texto) {
        System.out.println(texto);
        MACGC_Persona nuevoTrab = new MACGC_Persona();
        boolean DatoOK_macgc = false;
        //Introducimos un do/while para en el caso de que en el segundo/tercer paso salte una excepción no se salga al menú principal
        do {
            try {
                //Añadimos los datos a un nuevo objeto persona
                nuevoTrab.setNombre_macgc(pideString("Añade el nombre: "));
                nuevoTrab.setEdad_macgc(pideEntero("Añade la edad: "));
                nuevoTrab.setDni_macgc(pideString("Añade el dni: "));
                //Introducimos los datos en el Hashmap
                hashMap_macgc.put(nuevoTrab.getDni_macgc(), nuevoTrab);
                DatoOK_macgc = true;
                //Captamos las posibles excepciones
            } catch (NombreIncorrectoMACGC | EdadIncorrectaMACGC | DNIIncorrectoMACGC e) {
                e.printStackTrace(System.out);
            }
        } while (DatoOK_macgc != true);
    }

    //Elimina un elemento a un HashMap
    public static void QuitarAHashMapMACGC(HashMap<String, MACGC_Persona> hashMap_macgc, String texto) {
        System.out.println(texto);
        MACGC_Persona nuevoTrab = new MACGC_Persona();
        //
        try {
            nuevoTrab.setDni_macgc(pideString("Añade el dni del trabajador que quieres eliminar: "));
            //Comprobamos que el DNI introducido coincide con algún registro del hashMap y si lo hace, se elimina
            if (hashMap_macgc.containsKey(nuevoTrab.getDni_macgc())) {
                hashMap_macgc.remove(nuevoTrab.getDni_macgc());
                System.out.println("Se ha borrado correctamente el trabajador con DNI " + nuevoTrab.getDni_macgc());
            //Si no coincide saca un mensaje por pantalla
            } else {
                System.out.println("Ups! Ángeles no existe ningún DNI como el introducido");
            }
        //Capturamos la excepción 
        } catch (DNIIncorrectoMACGC e) {
            e.printStackTrace(System.out);
        }
    }

    //------GRUPO DE TRABAJO------
    //Muestra el contenido de un ArrayList        
    public static void MostrarArrayListMACGC(ArrayList<MACGC_Persona> array_macgc, String texto) {
        System.out.println(texto);
        for (int k = 0; k < array_macgc.size(); k++) {
            System.out.println(k + 1 + "-. " + array_macgc.get(k));
        }
    }

    //Añade un elemento a un ArrayList
    public static void AñadirAArrayList(ArrayList<MACGC_Persona> array_macgc, HashMap<String, MACGC_Persona> hashMap_macgc, String texto) throws DemasiadosObjetosMACGC {
        System.out.println(texto);
        MACGC_Persona nuevoTrab = new MACGC_Persona();
        //Lanzamos la excepción de que no puede haber más de dos personas en el arrayList, que se capturará en el main
        if (array_macgc.size() > 1) {
            throw new DemasiadosObjetosMACGC("Ups, el grupo de trabajo puede contener un máximo 2 personas");
        }
        try {
            nuevoTrab.setDni_macgc(pideString("Añade el dni del trabajador que quieres añadir al grupo de trabajo: "));
            //Si el dni introducido corresponde con un registro de HashMap, éste se añade al arrayList
            if (hashMap_macgc.containsKey(nuevoTrab.getDni_macgc())) {
                array_macgc.add(hashMap_macgc.get(nuevoTrab.getDni_macgc()));
            //Si no lo hace, saca un mensaje por consola
            } else {
                System.out.println("Ups! Ángeles no existe ningún DNI como el introducido");
            }
        //Capturamos las excepciones
        } catch (DNIIncorrectoMACGC e) {
            e.printStackTrace(System.out);
        }
    }

    //Elimina un elemento a un ArrayList
    public static void QuitarAArrayList(ArrayList<MACGC_Persona> array_macgc, String texto) throws PosicionIncorrectaMACGC {
        System.out.println(texto);
        int posicion_macgc = pideEntero("Ángeles, ¿qué posición quieres borrar?");
        //Si la posición introducida es menor que 0 o mayor a la posicion del arrayList, lanza una excepción, que se capturará en el main
        if (posicion_macgc < 1 || posicion_macgc > array_macgc.size()) {
            throw new PosicionIncorrectaMACGC();
        //Si no lo es, se elimina el registro del array
        } else {
            array_macgc.remove(posicion_macgc-1);
            System.out.println("Ángeles se ha eliminado a la persona del grupo de trabajo correctamente");
        }
    }
}
