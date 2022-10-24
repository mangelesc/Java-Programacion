package MACGC_Actividad07.ExcepcionesPropias;

//Creamos la clase EdadIncorrecaMACGC, que hereda de Exception, para crear una excepción propia
public class EdadIncorrectaMACGC extends Exception {

    //Creamos un constructor que lanza un mensaje.
    public EdadIncorrectaMACGC() {
        super("Ups! Ángeles, la edad debe ser entre 1 y 110\n");
    }
}
