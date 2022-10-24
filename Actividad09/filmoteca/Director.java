package macgc_actividad09.filmoteca;


class Director {
    
 //Añadimos los atributos necesarios la clase
    private int idDirector;
    private String nombre_macgc;
    private String apellidos_macgc;

    public Director(int idDirector, String nombre_macgc, String apellidos_macgc) {
        this.idDirector = idDirector;
        this.nombre_macgc = nombre_macgc;
        this.apellidos_macgc = apellidos_macgc;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre_macgc() {
        return nombre_macgc;
    }

    public void setNombre_macgc(String nombre_macgc) {
        this.nombre_macgc = nombre_macgc;
    }

    public String getApellidos_macgc() {
        return apellidos_macgc;
    }

    public void setApellidos_macgc(String apellidos_macgc) {
        this.apellidos_macgc = apellidos_macgc;
    }

    @Override
    public String toString() {
        return "DIRECTOR ID " + idDirector + ":  Nombre: " + nombre_macgc + " , Apellidos: " + apellidos_macgc;
    }
    
}
