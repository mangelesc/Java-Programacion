package MACGC_Actividad07.ExcepcionesPropias;

//Creamos la clase NombreIncorrectoMACGC, que hereda de Exception, para crear una excepción propia
public class NombreIncorrectoMACGC extends Exception {

    //Creamos un constructor que lanza un mensaje.
    public NombreIncorrectoMACGC(String texto) {
        super(texto);
    }
}
