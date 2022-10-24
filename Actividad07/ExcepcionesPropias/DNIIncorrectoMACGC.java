package MACGC_Actividad07.ExcepcionesPropias;

//Creamos la clase DNIIncorrectoMACGC, que hereda de Exception, para crear una excepción propia
public class DNIIncorrectoMACGC extends Exception {

    //Creamos un constructor que lanza un mensaje.
    public DNIIncorrectoMACGC() {
        super("Ups! Ángeles el DNI ha de ser un String de 9 valores\n");
    }
}
