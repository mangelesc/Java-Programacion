package macgc_actividad09.tiendas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Empleado {
    
    @Id @GeneratedValue long id;
    private String nombre;
    private String apellidos;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellidos = apellido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    @Override
    public String toString() {
        return "Empleado id "+ id + ": Nombre: " + nombre +" , Apellidos: " + apellidos;
    }
    
}
