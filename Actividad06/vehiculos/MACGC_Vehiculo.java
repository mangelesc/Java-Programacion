package MACGC_Actividad06.vehiculos;

import static MACGC_Actividad06.Controles.MACGC_PedirDatos.*;

public abstract class MACGC_Vehiculo implements MACGC_Alquilable {

    private String matricula_macgc;
    private String modelo_macgc;
    private int numplazas_macgc;
    private int numdias_macgc = 0;
    final double preciobase_macgc = 50;

    //Añadimos un constructor 
    public MACGC_Vehiculo() {
        super();
    }

    public MACGC_Vehiculo(String matricula_macgc, String modelo_macgc, int numplazas_macgc, int numdias_macgc) {
        this.matricula_macgc = matricula_macgc;
        this.modelo_macgc = modelo_macgc;
        this.numplazas_macgc = numplazas_macgc;
        this.numdias_macgc = numdias_macgc;
    }
    
    

    //Añadimos los setter y getters
    public String getMatricula_macgc() {
        return matricula_macgc;
    }

    public void setMatricula_macgc(String matricula_macgc) {
        this.matricula_macgc = matricula_macgc;
    }

    public String getModelo_macgc() {
        return modelo_macgc;
    }

    public void setModelo_macgc(String modelo_macgc) {
        this.modelo_macgc = modelo_macgc;
    }

    public int getNumplazas_macgc() {
        return numplazas_macgc;
    }

    public void setNumplazas_macgc(int numplazas_macgc) {
        this.numplazas_macgc = numplazas_macgc;
    }

    public int getNumdias_macgc() {
        return numdias_macgc;
    }


    //Implementamos los métodos del interfaz Alquilable que hemos creamos anteriormente
    @Override
    public void setNumeroDias(int numdias_macgc) {
        this.numdias_macgc = numdias_macgc;
    }

    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return preciobase_macgc * numdias_macgc;
    }

    //Añadimos un método pideDatos que pida y establezca los datos del vehículo
    public void PideDatos() {
        System.out.println("Ángeles introduce: ");
        this.matricula_macgc = pideString("Matrícula:");
        this.modelo_macgc = pideString("Modelo:");
        this.numplazas_macgc = pideMinMax(1, 50, "Número de plazas:"); 
        this.numdias_macgc = pideMinMax(1, 360, "Días de alquiler:");
    }

    //Añadimos un método toString que retorna toda la información de la clase, incluido el precio total y que sobrescribe al de la madre
    @Override
    public String toString() {
        return "\nMatrícula: " + this.matricula_macgc + "\nModelo: " + this.modelo_macgc + "\nNúmero de plazas: " + this.numplazas_macgc
                + "\nNúmero de días: " + this.numdias_macgc + "\nPrecio Base: " + this.preciobase_macgc + "€" + 
                "\nPrecio total: " + getPrecioTotalAlquilerPorDias() + "€\n";
    }
}
