package MACGCactividad04.main;

//importamos los packages necesarios
import static MACGCactividad04.Archivos.OpcionesArchivos.*;
import MACGCactividad04.IntroDatos.MACGC_PedirDatos;
import java.io.IOException;

public class MACGC_Ejercicio01 {

    public static void main(String[] args) throws IOException {
        //Creamos la variable, que luego usaremos en el switch para seleccionar la opción que elija el usuario 
        int macgc_opcion;
        do {
            //Mostramos por pantalla las opciones del menú
            System.out.println("Ángeles, ¿qué acción quieres hacer?");
            System.out.println("1. Nuevo archivo");
            System.out.println("2. Listar archivos ");
            System.out.println("3. Mostrar un archivo ");
            System.out.println("4. Borrar un archivo");
            System.out.println("5. Renombrar un archivo");
            System.out.println("6. Reemplazar caracteresde un archivo");
            System.out.println("0. Salir");

            macgc_opcion = MACGC_PedirDatos.pideMinMax(0, 6);

            //Usamos un swith para crear el menú
            switch (macgc_opcion) {

                //Llamamos a las funciones que ya hemos creado anteriormente en el package "Archivos"
                case 1:
                    nuevoArchivo();
                    break;
                case 2:
                    listarArchivos();
                    break;
                case 3:
                    mostrarArchivo();
                    break;
                case 4:
                    borrarArchivo();
                    break;
                case 5:
                    renombrarArchivo();
                    break;
                case 6:
                    reemplazarCaracteres();
                    break;
                case 0:
                    System.out.println("Ángeles, has salido correctamente del programa");
                    break;
            }
        } while (macgc_opcion != 0);
    }
}
