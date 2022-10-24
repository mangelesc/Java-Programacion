package MACGC_Actividad07.ExcepcionesPropias;

//Creamos la clase EdadIncorrecaMACGC, que hereda de Exception, para crear una excepción propia
public class PosicionIncorrectaMACGC extends Exception {

    //Creamos un constructor que lanza un mensaje.
    public PosicionIncorrectaMACGC() {
        super("Ups! Ángeles, la posición indicada no existe\n");
    }
}