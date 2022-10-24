package MACGC_Actividad05;

public class MACGC_Artista {

    private String macgc_dni;
    private String macgc_nombre;
    private int macgc_nacimiento;
    private String macgc_sexo;

//Definimos un constructor vacio
    public MACGC_Artista() {
    }

    public MACGC_Artista(String macgc_dni, String macgc_nombre, int macgc_nacimiento, String macgc_sexo) {
        this.macgc_dni = macgc_dni;
        this.macgc_nombre = macgc_nombre;
        this.macgc_nacimiento = macgc_nacimiento;
        this.macgc_sexo = macgc_sexo;
    }

//Definimos los setters y los getters de la clase
    public void setDni(String macgc_dni) {
        this.macgc_dni = macgc_dni;
    }

    public void setNombre(String macgc_nombre) {
        this.macgc_nombre = macgc_nombre;
    }

    public void setNacimiento(int macgc_nacimiento) {
        this.macgc_nacimiento = macgc_nacimiento;
    }

    public void setSexo(String macgc_sexo) {
        this.macgc_sexo = macgc_sexo;
    }

    public String getDni() {
        return macgc_dni;
    }

    public String getNombre() {
        return macgc_nombre;
    }

    public int getNacimiento() {
        return macgc_nacimiento;
    }

    public String getSexo() {
        return macgc_sexo;
    }

    //Definimos un toString para devolver todos los datos
    @Override
    public String toString() {
        return "\nARTISTA: " + "\n- Dni: " + macgc_dni + "\n- Nombre: " + macgc_nombre + "\n- Nacimiento: " + macgc_nacimiento + "\n- Sexo: " + macgc_sexo;
    }

}
