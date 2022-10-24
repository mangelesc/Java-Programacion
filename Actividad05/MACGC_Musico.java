package MACGC_Actividad05;

public class MACGC_Musico extends MACGC_Artista {

    private String macgc_web;
    private String macgc_tituloultimo;
    private String[] macgc_top10 = new String[10];

    //Generamos un constructor
    public MACGC_Musico(String macgc_dni, String macgc_nombre, int macgc_nacimiento, String macgc_sexo, String macgc_web, String macgc_tituloultimo) {
        super(macgc_dni, macgc_nombre, macgc_nacimiento, macgc_sexo);
        this.macgc_web = macgc_web;
        this.macgc_tituloultimo = macgc_tituloultimo;
    }
   
    
    //Añadimos un método muestraCanciones que muestra por consola las canciones del array macgc_top10
    public void muestraCanciones() {
        System.out.println("Top 10 canciones: ");
        for (int k = 0; k < macgc_top10.length; k++) { //k la utiliza como contador, por lo que la defino dentro del for
            if (macgc_top10[k] == null){
            System.out.println(k+1 + "-. " + "Ups! No se ha añadido ninguna canción en esta posición");
            } else {
            System.out.println(k+1 + "-. " + macgc_top10[k]);
            }
        }
        System.out.println();
    }
    
    //Añadimos un método setCancion que añade una canción en una cierta posición del array macgc_top10
    public void setCancion(String macgc_cancion, int macgc_posicionpedir) {
        //Creamos una variable que valga la posición menos 1, ya que el array empieza en 0
        int macgc_posicion = macgc_posicionpedir -1;
        try {
            //Controlamos los posibles errores con un if, en caso de que se introduzca un valor fuera del rango del array
            if (macgc_posicion > 9) {
                throw new ErrorTamano();
            } else if (macgc_posicion < 0) {
                throw new ErrorTamano();
            } else {
                macgc_top10[macgc_posicion]=macgc_cancion;
                System.out.println("La canción " + macgc_cancion + " se ha añadido correctamente a la posición " + macgc_posicionpedir + " de la lista.\n");
            }
        } catch (ErrorTamano error) {
            System.out.println("Ups, el número no puede ser mayor que 10\n");
        }

    }

    //Definimos la clase ErrorTamano, que hereda de Exception con un constructor vacio para hacer el control de error del metodo setCancion
    class ErrorTamano extends Exception {
        public ErrorTamano() {
            super();
        }
    }

    //Definimos los setters y los getters de la clase
    public void setWeb(String macgc_web) {
        this.macgc_web = macgc_web;
    }

    public void setTituloultimo(String macgc_tituloultimo) {
        this.macgc_tituloultimo = macgc_tituloultimo;
    }

    public String getWeb() {
        return macgc_web;
    }

    public String getTituloultimo() {
        return macgc_tituloultimo;
    }

    //Definimos un toString para devolver todos los datos
    @Override
    public String toString() {
        return super.toString() + "\nMÚSICO: " + "\n- Página Web: " + macgc_web + "\n- Título del último disco: " + macgc_tituloultimo + "\n";
    }

}
