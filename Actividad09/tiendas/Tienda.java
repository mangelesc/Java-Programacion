
package macgc_actividad09.tiendas;

import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tienda {
    
    @Id @GeneratedValue long id;
    private String calle;
    private int ventas;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Empleado> empleados = Arrays.asList();

    public Tienda(String calle, int ventas, List<Empleado> empleados) {
        this.calle = calle;
        this.ventas = ventas;
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Tienda id: " + id + ", calle: " + calle + ", nº ventas:" + ventas + ", empleados: " + empleados;
    }   
    
}
