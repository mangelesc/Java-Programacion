package MACGC_Actividad06.vehiculos;

import static MACGC_Actividad06.Controles.MACGC_PedirDatos.pideString;

public class MACGC_Coche extends MACGC_Vehiculo {

    private String gama_macgc;

    //Definimos un constructor
    public MACGC_Coche(String matricula_macgc, String modelo_macgc, int numplazas_macgc, int numdias_macgc, String gama_macgc) {
        super(matricula_macgc, modelo_macgc, numplazas_macgc, numdias_macgc);
        this.gama_macgc = gama_macgc;
    }

    //Definimos los setters y los getters correspondientes
    public String getGama_macgc() {
        return gama_macgc;
    }

    public void setGama_macgc(String gama_macgc) {
        this.gama_macgc = gama_macgc;
    }

    /*Definimos un método getPrecioTotalAlquilerPorDias() que sobrescriba la función heredada de Vehiculo 
    y retorne el precio del alquiler teniendo presente que al precio base se le suma la cantidad de 1.5 € por plaza y día.*/
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return super.preciobase_macgc + (1.5 * super.getNumplazas_macgc()) * super.getNumdias_macgc();
    }

    //Añadimos un método pideDatos que sobrescribe a la de la madre que pida y establezca los datos del coche
    @Override
    public void PideDatos() {
        System.out.println("Ángeles introduce: ");
        super.PideDatos();
        this.gama_macgc = pideString("Gama: ");
    }

    //Añadimos un método toString que retorna toda la información de la clase, incluido el precio total y que sobrescribe al de la madre
    @Override
    public String toString() {
        return "COCHE" + super.toString() + "Gama: " + this.gama_macgc + "\n";
    }

}
