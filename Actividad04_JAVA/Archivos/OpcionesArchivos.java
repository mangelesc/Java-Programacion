package MACGCactividad04.Archivos;

import static MACGCactividad04.IntroDatos.MACGC_PedirDatos.pideMinMax;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import static java.lang.System.in;
import java.util.Arrays;

public class OpcionesArchivos {

    static String separador_macgc = File.separator; //Defino el separador para poder usarlo en las todas las funciones de abajo

    public static String DefRuta() { //Defino una función para definir la ruta y que me la devuelva en un string
        String rutaProyecto_macgc = System.getProperty("user.dir"); //Función que nos devuelve una ruta absoluta del proyecto
        String rutaCarpeta_macgc = rutaProyecto_macgc + separador_macgc + "Archivos MACGC"; //Dentro de la ruta del proyecto, guardardaré los archivos en la carpeta "Archivos MACGC"
        File CarpetaFor_macgc = new File(rutaCarpeta_macgc);

//Hacemos comprobación
        if (!CarpetaFor_macgc.exists()) {
            CarpetaFor_macgc.mkdir(); //Crea la carpeta si no existe
            System.out.println("Ángeles, se ha creado la carpeta Archivos MACGC");
        } else {
            System.out.println("Ángeles, no se necesita crear la carpeta Archivos MACGC, ya existe");
        }
        return rutaCarpeta_macgc;
    }

    public static File CarpetaFile() { //Defino una función para definir la ruta de la carpeta y que me la devuelva en un File
        String rutaProyecto_macgc = System.getProperty("user.dir"); //Función que nos devuelve una ruta absoluta del proyecto
        String rutaCarpeta_macgc = rutaProyecto_macgc + separador_macgc + "Archivos MACGC"; //Dentro de la ruta del proyecto, guardardaré los archivos en la carpeta "Archivos MACGC"
        File CarpetaFor_macgc = new File(rutaCarpeta_macgc);

        //Hacemos comprobación
        if (!CarpetaFor_macgc.exists()) {
            CarpetaFor_macgc.mkdir(); //Crea la carpeta si no existe
            System.out.println("Ángeles, se ha creado la carpeta Archivos MACGC");
        } else {
            System.out.println("Ángeles, no se necesita crear la carpeta Archivos MACGC, ya existe");
        }
        return CarpetaFor_macgc;
    }

    public static void nuevoArchivo() throws IOException {
        String rutaCarpeta_macgc = DefRuta();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        FileWriter fw;

        System.out.println("Angeles, introduce el nombre del archivo que quieres crear");
        String nombre_macgc = br.readLine();

        System.out.println("Introduce texto que quieres añadir en el archivo:");
        String texto_macgc = br.readLine();

        fw = new FileWriter(rutaCarpeta_macgc + separador_macgc + nombre_macgc); //fw apunta a la ruta para poder escribir en el directorio

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(texto_macgc); //Guardo el texto que introduce el usuario en el buffer

        bw.flush();//Volcamos lo que está en memoria buffer hacia disco

        bw.close();

        System.out.println("Ángeles, ¡se ha creado el archivo correctamente!");
    }

    public static String[] listarArchivos() {
        File Carpeta_macgc = CarpetaFile();
        String[] archivos_macgc = Carpeta_macgc.list();
        int posicion_macgc = 0; //Defino variable para definar la posicion del array archivosFile 
        //Defino un nuevo array de strings para guardar la lista de archivos tipo file, al que le resto 1
        String[] archivosFile_macgc = new String[archivos_macgc.length - 1];

        //Hacemos una repetición con for, si está vacía no entrará        
        for (int k = 0; k < archivos_macgc.length; k++) { //k la utiliza como contador, por lo que la defino dentro del for
            File f = new File(Carpeta_macgc + separador_macgc + archivos_macgc[k]);
            if (f.isFile()) { //
                System.out.println(posicion_macgc + ".- " + archivos_macgc[k]);
                archivosFile_macgc[posicion_macgc] = archivos_macgc[k]; //Guardo en el array los archivos de tipo file 
                posicion_macgc = posicion_macgc + 1; //Aunmento en 1 el valor de posición
            }
        }
        //Redimensiono lo que hay en el propio array, restandole las posiciones que no son archivos, para eliminar los nulls y así 
        //conseguir controlar los errores en las funciones en las que llamaré a la función listarArchivos
        Arrays.copyOf(archivosFile_macgc, archivosFile_macgc.length - (archivos_macgc.length - posicion_macgc));
        return archivosFile_macgc; //Guardo el resultado en la variable, para usarla en otras funciones
    }

    public static void mostrarArchivo() throws FileNotFoundException, IOException {
        String[] mArchivos_macgc = listarArchivos(); //Llamamos a la función y guardo el return en una variable local

        System.out.println("Ángeles, ¿qué archivo quieres que muestre?");
        System.out.println("Inserta el valor de la posición del archivo deseado:");

        int valorArchivos_macgc = pideMinMax(0, mArchivos_macgc.length - 1);

        FileReader fr = new FileReader(DefRuta() + separador_macgc + mArchivos_macgc[valorArchivos_macgc]);
        BufferedReader br = new BufferedReader(fr);

        System.out.println("Archivo: " + mArchivos_macgc[valorArchivos_macgc]);
        String linea_macgc = br.readLine(); //Leemos la primera línea del texto del archivo seleccionado
        while (linea_macgc != null) {
            System.out.println(linea_macgc);
            linea_macgc = br.readLine();
        }
        br.close();
    }

    public static void borrarArchivo() throws FileNotFoundException, IOException {
        String[] mArchivos_macgc = listarArchivos();

        System.out.println("Ángeles, ¿qué archivo quieres borrar?");
        System.out.println("Inserta el valor de la posición del archivo deseado:");
        int valorArchivos_macgc = pideMinMax(0, mArchivos_macgc.length - 1);

        //Defino la variable para guardar la ruta del archivo que el usuario quuiere borrar, llamando a DefRuta
        File borrarFile_macgc = new File(DefRuta() + separador_macgc + mArchivos_macgc[valorArchivos_macgc]);
        //Defino el control de error con if-else
        if (borrarFile_macgc.delete()) {
            System.out.println("Ángeles, el archivo " + mArchivos_macgc[valorArchivos_macgc] + " se ha borrado correctamente");
        } else {
            System.out.println("Ups! Ángeles, el archivo " + mArchivos_macgc[valorArchivos_macgc] + " no ha podido ser borrado");
        }
    }

    public static void renombrarArchivo() throws IOException {
        String[] mArchivos_macgc = listarArchivos();

        System.out.println("Ángeles, ¿qué archivo quieres renombrar?");
        System.out.println("Inserta el valor de la posición del archivo deseado:");
        int valorArchivos_macgc = pideMinMax(0, mArchivos_macgc.length - 1);

        File renombrarFile_macgc = new File(DefRuta() + separador_macgc + mArchivos_macgc[valorArchivos_macgc]);

        System.out.println("Ángeles, ¿cómo quieres renombrar el archivo " + mArchivos_macgc[valorArchivos_macgc] +" ?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nuevoNombre_macgc = br.readLine();
        File renombrar_macgc = new File(DefRuta() + separador_macgc + nuevoNombre_macgc);
        
        if (renombrarFile_macgc.renameTo(renombrar_macgc)) {
            System.out.println("Ángeles, el archivo " + mArchivos_macgc[valorArchivos_macgc] + " se ha renombrado correctamente por: " + nuevoNombre_macgc);
        } else {
            System.out.println("Ups! Ángeles, el archivo " + mArchivos_macgc[valorArchivos_macgc] + " no ha podido ser renombrado");
        }

    }

    public static void reemplazarCaracteres() throws IOException {
        String[] mArchivos_macgc = listarArchivos();

        System.out.println("Ángeles, ¿qué archivo quieres modificar?");
        System.out.println("Inserta el valor de la posición del archivo deseado:");
        int valorArchivos_macgc = pideMinMax(0, mArchivos_macgc.length - 1);

        File reFile_macgc = new File(DefRuta() + separador_macgc + mArchivos_macgc[valorArchivos_macgc]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String caracter_macgc = null;
        String caracterNuevo_macgc;
        do { //Definimos un do/while para controlar errores, y que sólo se ejecute cuando el usuario introduce un caracter
            System.out.println("Ángeles, indica el carácter que quieres reemplazar (Sólo uno):");
            caracter_macgc = br.readLine();
        } while (caracter_macgc.length() != 1);

        do {
            System.out.println("Ángeles, indica el nuevo carácter (Sólo uno):");
            caracterNuevo_macgc = br.readLine();
        } while (caracterNuevo_macgc.length() != 1);

        RandomAccessFile raf = new RandomAccessFile(reFile_macgc, "rw"); //Defino la variable raf 

        while (raf.getFilePointer() < raf.length()) { //Hacemos un bucle para recorrer la variable raf
            Character chr_macgc = (char) raf.readByte(); //
            if (chr_macgc.toString().compareTo(caracter_macgc) == 0) {  //convertivos chr a String y lo queremos comparar con caracter
                raf.seek(raf.getFilePointer() - 1);
                raf.writeBytes(caracterNuevo_macgc); //Voy a la posición donde estoy y la reescribo
            }
        }
        raf.close();
    }
}
