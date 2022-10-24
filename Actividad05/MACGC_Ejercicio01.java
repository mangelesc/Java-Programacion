package MACGC_Actividad05;

import java.io.IOException;

public class MACGC_Ejercicio01 {

    public static void main(String[] args) throws IOException {

        //------ Ejercicio 6.1.------- 
        //Creamos las variables de tipo Artista con un constructor vacio
        MACGC_Artista artistaMA = new MACGC_Artista();

        //Rellenamos los atributos con los setters
        artistaMA.setDni("12345678A");
        artistaMA.setNacimiento(1991);
        artistaMA.setNombre("Angeles Cordoba (Artista)");
        artistaMA.setSexo("Mujer");

        //------ Ejercicio 6.2.------- 
        //Mostramos los datos del artista por pantalla 
        System.out.println(artistaMA);

        //------ Ejercicio 6.3.------- 
        //Creamos una variable de tipo Dibujante, estableciendo sus valores con un constructor
        MACGC_Dibujante dibujanteMA = new MACGC_Dibujante("12345678B", "MAngeles Cordoba (Dibujante)", 1991, "Mujer", 2020, "Programación M03", 1000);

        //Mostramos por pantalla los datos del dibujante que hemos creado
        System.out.println(dibujanteMA);

        //------ Ejercicio 6.4.------- 
        //Creamos una variable de tipo musico con un constructor que recibe y establece el nombre, año de nacimiento, sexo, dni, último disco y el sitio web
        MACGC_Musico musicoMA = new MACGC_Musico("12345678C", "MAngeles Cordoba (Músico)", 1991, "Mujer", "www.macgc.com", "Mi último disco");

        //------ Ejercicio 6.5.------- 
        //Utilizamos el método setCanción para añadir 3 canciones en el top
        musicoMA.setCancion("Lego House", 1);
        musicoMA.setCancion("Hearts don't break around here", 2);
        musicoMA.setCancion("Bad Habits", 3);

        //Mostramos por pantalla los datos de musicoMA
        System.out.println(musicoMA);

        //Utilizamos muestraCanciones para mostrar las canciones añadidas
        musicoMA.muestraCanciones();
    }

}
