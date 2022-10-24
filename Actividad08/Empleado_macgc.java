package macgc_actividad08;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//Creamos una clase serializable
public class Empleado_macgc implements Serializable {

    //Definimos los atributos
    private String nombre_macgc;
    private String edad_macgc;
    private String sexo_macgc;
    private ArrayList<String> aficiones_macgc = new ArrayList<>();

    //Creamos un constructor 
    public Empleado_macgc(String nombre_macgc, String edad_macgc, String sexo_macgc, ArrayList<String> aficiones_macgc) {
        super();
        this.nombre_macgc = nombre_macgc;
        this.edad_macgc = edad_macgc;
        this.sexo_macgc = sexo_macgc;
        this.aficiones_macgc = aficiones_macgc;
    }

    //Definimos los setters y los getters
    public String getNombre_macgc() {
        return nombre_macgc;
    }

    public void setNombre_macgc(String nombre_macgc) {
        this.nombre_macgc = nombre_macgc;
    }

    public String getEdad_macgc() {
        return edad_macgc;
    }

    public void setEdad_macgc(String edad_macgc) {
        this.edad_macgc = edad_macgc;
    }

    public String getSexo_macgc() {
        return sexo_macgc;
    }

    public void setSexo_macgc(String sexo_macgc) {
        this.sexo_macgc = sexo_macgc;
    }

    public ArrayList<String> getAficiones_macgc() {
        return aficiones_macgc;
    }

    public void setAficiones_macgc(ArrayList<String> aficiones_macgc) {
        this.aficiones_macgc = aficiones_macgc;
    }

    //Definimos un toString
    @Override
    public String toString() {
        //Leemos el HashMap usando un Iterator
        String aficiones_texto_macgc = " ";
        for (int k = 0; k < aficiones_macgc.size(); k++) {
            aficiones_texto_macgc += aficiones_macgc.get(k) + ", ";
        }
        aficiones_texto_macgc = aficiones_texto_macgc.substring(0, aficiones_texto_macgc.length()-2);
        return "NOMBRE: " + nombre_macgc + ", EDAD: " + edad_macgc + ", SEXO: " + sexo_macgc + ", AFICIONES: " + aficiones_texto_macgc + ".";
    }

}
