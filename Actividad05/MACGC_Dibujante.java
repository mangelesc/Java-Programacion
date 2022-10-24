package MACGC_Actividad05;

public class MACGC_Dibujante extends MACGC_Artista {

    private int macgc_ultimaexpo;
    private String macgc_dibujocaro;
    private int macgc_preciodibujocaro;

    //Definimos un constructor con todos los atributos
    public MACGC_Dibujante(String macgc_dni, String macgc_nombre, int macgc_nacimiento, String macgc_sexo, int macgc_ultimaexpo, String macgc_dibujocaro, int macgc_preciodibujocaro) {
        super(macgc_dni, macgc_nombre, macgc_nacimiento, macgc_sexo);
        this.macgc_ultimaexpo = macgc_ultimaexpo;
        this.macgc_dibujocaro = macgc_dibujocaro;
        this.macgc_preciodibujocaro = macgc_preciodibujocaro;
    }

    //Definimos los setters y los getters de la clase
    public void setUltimaexpo(int macgc_ultimaexpo) {
        this.macgc_ultimaexpo = macgc_ultimaexpo;
    }

    public void setDibujocaro(String macgc_dibujocaro) {
        this.macgc_dibujocaro = macgc_dibujocaro;
    }

    public void setPreciodibujocaro(int macgc_preciodibujocaro) {
        this.macgc_preciodibujocaro = macgc_preciodibujocaro;
    }

    public int getUltimaexpo() {
        return macgc_ultimaexpo;
    }

    public String getDibujocaro() {
        return macgc_dibujocaro;
    }

    public int getPreciodibujocaro() {
        return macgc_preciodibujocaro;
    }

    //Definimos un toString para devolver todos los datos
    @Override
    public String toString() {
        return super.toString() + "\nDIBUJANTE: " + "\n- Año de la última exposición: " + macgc_ultimaexpo + "\n- Nombre del dibujo más caro: " + macgc_dibujocaro
                + "\n- Precio de dibujo más caro: " + macgc_preciodibujocaro + "€\n";
    }

}
