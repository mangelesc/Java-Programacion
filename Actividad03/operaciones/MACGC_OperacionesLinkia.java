package MACGCactividad03.operaciones;

//importamos los packages necesarios
import static MACGCactividad03.introduceDatos.MACGC_Pregunta.pideDouble;

public class MACGC_OperacionesLinkia {
    
    //utilizamos un void, ya que no devuelve ningún valor
    public static void convertirLinkiaCoins()  {
        double MACGC_valor = pideDouble ("Angeles, introduce el valor que quieres convertir a Linkia Coins");
        //Sacamos por pantalla el valor que introduce el ususario, multiplicado por el valor de los LinkiaCoins
        System.out.println("La conversión a Linkia coins del valor introducido es : " + MACGC_valor*1.5);
    }
    
}


