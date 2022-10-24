package MACGC_Actividad07.ExcepcionesPropias;

//Creamos la clase DemasiadosObjetosMACGC, que hereda de Exception, para crear una excepción propia
public class DemasiadosObjetosMACGC extends Exception {
    
    //Creamos un constructor con un texto que le pasamos por parámetro.
    public DemasiadosObjetosMACGC (String texto) {
        super(texto);
    }
}
