package MACGC_Actividad07.Persona;

import MACGC_Actividad07.ExcepcionesPropias.*;

public class MACGC_Persona {

    //Añadimos los atributos necesarios la clase
    private String nombre_macgc;
    private int edad_macgc;
    private String dni_macgc;

    //Creamos un constructor
    public MACGC_Persona(String nombre_macgc, int edad_macgc, String dni_macgc) throws NombreIncorrectoMACGC, EdadIncorrectaMACGC, DNIIncorrectoMACGC {
        setNombre_macgc(nombre_macgc);
        setEdad_macgc(edad_macgc);
        setDni_macgc(dni_macgc);
    }

    public MACGC_Persona() {
    }

    //Añadimos los setter y getters
    public String getNombre_macgc() {
        return nombre_macgc;
    }

    public void setNombre_macgc(String nombre_macgc) throws NombreIncorrectoMACGC {
        //Añadimos una excepcion en caso de que la longitud del string pasado por parámetro sea menos a 3. 
        //Si se lanza esta excepción, no se llegaría a lanzar la siguiente.
        if (nombre_macgc.length() < 3) {
            throw new NombreIncorrectoMACGC("Ups! Ángeles, el nombre debe tener al menos 3 letras\n");
        }
        //Añadimos una excepcion en caso de que el String pasado por parámetro contenga un dígito.
        if (nombre_macgc.matches(".*[0-9].*")) {
            throw new NombreIncorrectoMACGC("Ups! Ángeles, el nombre no puede contener dígitos\n");
        }
        this.nombre_macgc = nombre_macgc;
    }

    public int getEdad_macgc() {
        return edad_macgc;
    }

    public void setEdad_macgc(int edad_macgc) throws EdadIncorrectaMACGC {
        //Añadimos una excepcion en caso de que el int pasado por parámetro sea menor a 1 o mayor a 110.
        if (edad_macgc < 1 || edad_macgc > 110) {
            throw new EdadIncorrectaMACGC();
        }
        this.edad_macgc = edad_macgc;
    }

    public String getDni_macgc() {
        return dni_macgc;
    }

    public void setDni_macgc(String dni_macgc) throws DNIIncorrectoMACGC {
        //Añadimos una excepcion en caso de que la longitud del String pasado por parámetro no sea igual a 9.
        if (dni_macgc.length() != 9) {
            throw new DNIIncorrectoMACGC();
        }
        this.dni_macgc = dni_macgc;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre_macgc + " , edad: " + edad_macgc + " , dni: " + dni_macgc; 
    }

    
}
