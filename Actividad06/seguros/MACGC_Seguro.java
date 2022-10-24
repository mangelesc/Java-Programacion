package MACGC_Actividad06.seguros;

import MACGC_Actividad06.vehiculos.MACGC_Alquilable;

public class MACGC_Seguro implements MACGC_Alquilable {

    //Añadimos los atributos necesarios la clase
    private String nombreSeguro_macgc;
    private String descripcionSeguro_macgc;
    final double precioxDia_macgc = 10.5;
    int NumeroDias_macgc = 1;

    //Añadimos un constructor
    public MACGC_Seguro(String nombreSeguro_macgc, String descripcionSeguro_macgc, int NumeroDias_macgc) {
        this.nombreSeguro_macgc = nombreSeguro_macgc;
        this.descripcionSeguro_macgc = descripcionSeguro_macgc;
        this.NumeroDias_macgc = NumeroDias_macgc;
    }
    
    
    //Añadimos los setter y getters
    public String getNombreSeguro_macgc() {
        return nombreSeguro_macgc;
    }

    public void setNombreSeguro_macgc(String nombreSeguro_macgc) {
        this.nombreSeguro_macgc = nombreSeguro_macgc;
    }

    public String getDescripcionSeguro_macgc() {
        return descripcionSeguro_macgc;
    }

    public void setDescripcionSeguro_macgc(String descripcionSeguro_macgc) {
        this.descripcionSeguro_macgc = descripcionSeguro_macgc;
    }

    public double getsetNumeroDias_macgc() {
        return NumeroDias_macgc;
    }

    //Implementamos los métosdos, sobreescribiendo los anteriores, del interfaz Alquilable que hemos creamos anteriormente
    @Override
    public void setNumeroDias(int NumeroDias_macgc) {
        this.NumeroDias_macgc = NumeroDias_macgc;
    }

    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return precioxDia_macgc*NumeroDias_macgc;
    }

    //Añadimos un método toString, sobreescribiendo el anterior, que retorna toda la información de la clase, incluido el precio total.
    @Override
    public String toString() {
        return "\nSEGURO\nNombre: " + this.nombreSeguro_macgc + 
                "\nDescripción: " + this.descripcionSeguro_macgc + "\nPrecio por día: " + this.precioxDia_macgc + 
                "\nNúmero de días: " + this.NumeroDias_macgc + "\nTotal contratado: " + getPrecioTotalAlquilerPorDias() +"€\n";
    }

}
