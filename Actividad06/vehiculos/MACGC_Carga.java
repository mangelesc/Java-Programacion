package MACGC_Actividad06.vehiculos;

import static MACGC_Actividad06.Controles.MACGC_PedirDatos.pideDouble;

public class MACGC_Carga extends MACGC_Vehiculo {

    private double PMA_macgc;

    //Definimos un constructor
    public MACGC_Carga(String matricula_macgc, String modelo_macgc, int numplazas_macgc, int numdias_macgc, double PMA_macgc) {
        super(matricula_macgc, modelo_macgc, numplazas_macgc, numdias_macgc);
        this.PMA_macgc = PMA_macgc;
    }

    //Definimos los setters y los getters correspondientes
    public double getPMA_macgc() {
        return PMA_macgc;
    }

    public void setPMA_macgc(double PMA_macgc) {
        this.PMA_macgc = PMA_macgc;
    }

    /*Definimos un método getPrecioTotalAlquilerPorDias() que sobrescriba la función heredada de Vehiculo 
    y retorne el precio del alquiler teniendo presente que al precio base se le suma  1.5 € * PMA*/
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return super.getNumdias_macgc() * (super.preciobase_macgc + (1.5 * PMA_macgc));
    }

    //Añadimos un método pideDatos que sobrescribe al de la madre que pida y establezca los datos de la carga
    @Override
    public void PideDatos() {
        System.out.println("Ángeles introduce: ");
        super.PideDatos();
        this.PMA_macgc = pideDouble("Gama: ");
    }

    //Añadimos un método toString que retorna toda la información de la clase, incluido el precio total y que sobrescribe al de la madre
    @Override
    public String toString() {
        return "CARGA" + super.toString() + "PMA: " + this.PMA_macgc + "\n";
    }
}
