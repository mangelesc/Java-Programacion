package macgc_actividad09.tiendas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GestionaTiendas_MACGC {

    public static void main(final String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:tiendasDB.tmp;drop");
        final EntityManager em = emf.createEntityManager();

        try {
            final Empleado e1 = new Empleado("Ángeles", "Córdoba");
            final Empleado e2 = new Empleado("María", "García");
            final Empleado e3 = new Empleado("Jorge", "Fernández");

            final Tienda t1 = new Tienda("Calle Córdoba", 200, Arrays.asList(e1, e2));
            final Tienda t2 = new Tienda("Calle María", 50, Arrays.asList(e3, e1));
            final Tienda t3 = new Tienda("Calle Ángeles", 500, Arrays.asList(e3));

            em.getTransaction().begin();
            em.persist(t1);
            em.persist(t2);
            em.persist(t3);
            em.getTransaction().commit();

            int macgc_opcion;
            do {
                //Mostramos por pantalla las opciones del menú
                System.out.println("\nÁngeles, ¿qué acción quieres hacer?");
                System.out.println("1. Mostrar los empleados.");
                System.out.println("2. Mostrar las tiendas.");
                System.out.println("3. Mostrar las tiendas ordenadas por ventas.");
                System.out.println("4. Editar un empleado.");
                System.out.println("5. Crear una nueva tienda.");
                System.out.println("0. Salir");

                macgc_opcion = pideMinMax(0, 5, "");

                //Usamos un swith para crear el menú
                switch (macgc_opcion) {

                    case 1:
                        mostrarEmpleados(em);
                        break;
                    case 2:
                        mostrarTiendas(em);
                        break;
                    case 3:
                        mostrarTiendasVentas(em);
                        break;
                    case 4:
                        modificarEmpleado(em);
                        break;
                    case 5:
                        addTienda(em);
                        break;
                    case 0:
                        System.out.println("Ángeles, has salido correctamente del programa");
                        break;
                }
            } while (macgc_opcion != 0);
        } finally {
            em.close();
            emf.close();
        }
    }

    //---------------------------------
    //AÑADIMOS LAS FUNCIONES NECESARIAS
    //---------------------------------
    //1. Función para MOSTRAR EMPLEADOS    
    public static List<Empleado> mostrarEmpleados(final EntityManager em) {
        final TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        final List<Empleado> empleados = query.getResultList();
        empleados.forEach(e -> {
            System.out.println(e);
        });
        return empleados;
    }

    //3. Función para MOSTRAR TIENDAS 
    public static List<Tienda> mostrarTiendas(final EntityManager em) {
        final TypedQuery<Tienda> query = em.createQuery("SELECT t FROM Tienda t", Tienda.class);
        final List<Tienda> tiendas = query.getResultList();
        tiendas.forEach(t -> {
            System.out.println(t);
        });
        return tiendas;
    }

    //3. Función para MOSTRAR TIENDAS clasificadas por valor de ventas
    public static void mostrarTiendasVentas(final EntityManager em) {
        final int asc = pideEntero("Ángeles quieres ordenar las ventas de manera ascencente(pulsa 1) o descencente (pulsa 2)");
        TypedQuery<Tienda> query;
        if (asc == 1) {
            query = em.createQuery("SELECT t FROM Tienda t ORDER BY t.ventas ASC", Tienda.class);
        } else {
            query = em.createQuery("SELECT t FROM Tienda t ORDER BY t.ventas DESC", Tienda.class);
        }

        final List<Tienda> tiendas = query.getResultList();
        for (final Tienda t : tiendas) {
            System.out.println(t);
        }
    }

    //4. Funciones de MODIFICAR EMPLEADO
    public static void modificarEmpleado(final EntityManager em) {
        mostrarEmpleados(em);
        final int id = pideEntero("Indica el id del empleado que quieres modificar");
        em.getTransaction().begin();
        try {
            final TypedQuery<Empleado> query = em.createQuery("SELECT a FROM Empleado a WHERE id=:id", Empleado.class);
            query.setParameter("id", id);
            final Empleado empleado = query.getSingleResult();
            System.out.println("Has seleccionado a: " + empleado + ". ¿Que quiere modifinar?");
            final int opc = pideMinMax(0, 2, "1. Nombre 2. Apellido 0. Volver atras");
            switch (opc) {
                case 1:
                    final String nombre = pideString("Introduce el nuevo nombre");
                    empleado.setNombre(nombre);
                    break;
                case 2:
                    final String apellidos = pideString("Introduce los nuevos apellidos");
                    empleado.setApellido(apellidos);
                    break;
            }
            System.out.println("Ángeles se han guardado los nuevos datos del trabajador correctamente");
        } catch (final Exception e) {
            System.out.println("Ups, el id introducido es incorrecto");
        }
        em.getTransaction().commit();
    }

    //5. Función de AÑADIR TIENDA
    public static void addTienda(final EntityManager em) {
        final Tienda t = new Tienda(pideString("Añade la dirección de la tienda"),
                pideEntero("Añade el número de ventas"), null);
        final List<Empleado> empleados = mostrarEmpleados(em);
        final ArrayList<Empleado> empleadosTienda = new ArrayList<>();
        final int id = pideEntero("Indica el id del empleado que quieres añadir");
        int opc = 0;
        do {
            try {
                final TypedQuery<Empleado> query = em.createQuery("SELECT a FROM Empleado a WHERE id=:id", Empleado.class);
                query.setParameter("id", id);
                final Empleado empleado = query.getSingleResult();

                if (!empleadosTienda.contains(empleado)) {
                    empleadosTienda.add(empleado);
                    System.out.println("Ángeles, el empleado se ha añadido correctamente");
                } else {
                    System.out.println("Ups, el empleado ya está añadido en la tienda");
                }
                opc = pideMinMax(0, 1, "¿Quieres añadir otro empleado?\n SI pulsa 1 \nNO pulsa 0");
            } catch (final Exception e) {
                System.out.println("Ups, Ángeles ha habido un error al añadir el empleado.");
            }
        } while (opc != 0);
        t.setEmpleados(empleadosTienda);
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    //---------
    //CONTROLES 
    public static String pideString(String MACGC_pregunta) {
        String MACGC_string;
        do {
            //Imprimomos por pantalla la pregunta pedida por parámetro
            System.out.println(MACGC_pregunta);
            //Hacemos el control de errores
            try {
                BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
                MACGC_string = MACGC_br.readLine();
                break;
                //Hacemos el control de errores
            } catch (Exception e) {
                System.out.println("Ups! Ha habido un error");
            }
        } while (true);
        return MACGC_string;
    }

    //Creamos la función pideEntero para números enteros
    public static int pideEntero(String MACGC_pregunta) {
        int MACGC_numero = 0;
        do {
            //Imprimomos por pantalla la pregunta pedida por parámetro
            System.out.println(MACGC_pregunta);
            try {
                BufferedReader MACGC_br = new BufferedReader(new InputStreamReader(System.in));
                //Parseamos el caracter que introduce el usuario por pantalla a Int
                MACGC_numero = Integer.parseInt(MACGC_br.readLine());
                break;
                //Hacemos el control de errores
            } catch (Exception e) {
                System.out.println("Ups! Ángeles, no puede ser una letra");
            }
        } while (true);
        return MACGC_numero;
    }

    //Creamos una función para definir un valor máximo y mínimo del menú, mediante pideEntero
    public static int pideMinMax(int macgc_valorMin, int ValorMax, String MACGC_pregunta) {
        int macgc_valor = 0;
        //Imprimomos por pantalla la pregunta pedida por parámetro
        System.out.println(MACGC_pregunta);
        do {
            macgc_valor = pideEntero("Angeles, introduce un valor entre " + macgc_valorMin + " y " + ValorMax);
            if ((macgc_valor < macgc_valorMin) || (macgc_valor > ValorMax)) {
                System.out.println("Ups! El valor debe ser entre " + macgc_valorMin + " y " + ValorMax);
            }
        } while ((macgc_valor < macgc_valorMin) || (macgc_valor > ValorMax));
        return macgc_valor;
    }

}
