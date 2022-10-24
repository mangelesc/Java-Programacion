package macgc_actividad09.filmoteca;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class GestionBDD_MACGC {

    private static String datosConexion = "jdbc:mysql://localhost/";
    private static String baseDatos = "Filmoteca";
    private static String usuario = "root";
    private static String password = "";
    private Connection con;

    public GestionBDD_MACGC() {
        try {
            con = DriverManager.getConnection(datosConexion + "?userSSL=true", usuario, password);
            try {
                //usamos los métodos que definimos más adelante para crear la DBB y las tablas, si no existen
                crearBDD();
                crearTablaDirector();
                crearTablaPelicula();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    //Creamos un método para crear la BDD si no existe
    private void crearBDD() throws Exception {
        String query = "create database if not exists " + baseDatos + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            con = DriverManager.getConnection(datosConexion + baseDatos + "?userSSL=true", usuario, password);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

    //Creamos un método para crear una tabla DIRECTOR si no existe previamente
    private void crearTablaDirector() throws Exception {
        String query = "create table if not exists DIRECTOR("
                + "idDirector int auto_increment primary key, "
                + "nombre varchar(100), "
                + "apellidos varchar(120));";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

    //Creamos un método para crear una tabla PELICULAS si no existe previamente
    private void crearTablaPelicula() throws Exception {
        String query = "create table if not exists PELICULAS("
                + "idFilms int auto_increment primary key,"
                + "titulo varchar(100),"
                + "idDirector int,"
                + "pais varchar(100),"
                + "duracion int,"
                + "genero varchar(100), "
                + "foreign key(idDirector) references DIRECTOR(idDirector));";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

    //Creamos un método para insertar nuevos directores en la tabla DIRECTOR
    public void insertarDirector(String nombre, String apellidos) throws Exception {
        String query = "insert into DIRECTOR(nombre,apellidos) values ("
                + "'" + nombre + "','" + apellidos + "');";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

    //Creamos un método para actualizar datos en la tabla DIRECTOR
    public void actualizarDirector(int id, String nombre, String apellidos) throws Exception {
        String query = "update DIRECTOR set "
                + "nombre = '" + nombre + "',"
                + "apellidos = '" + apellidos + "' "
                + "where idDirector=" + id + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

    //Creamos un método para eliminar registros en la tabla DIRECTOR
        public void eliminarDirector(int id) throws Exception {
        String query = "delete from DIRECTOR "
                + "where idDirector=" + id + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            stmt.close();
        }
    }

//Creamos un método para mostrar registros en la tabla DIRECTOR
public Director mostrarDirector(int id) throws Exception {
        Director director = null;
        String query = "select * from DIRECTOR "
                + "where idDirector=" + id + ";";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                director = new Director(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            rs.close();
            stmt.close();
        }
        return director;
    }
    
    //Creamos un método para listar los datos de la tabla DIRECTOR dentro de un arrayList de Director
    public ArrayList<Director> listarDirector() throws Exception {
        ArrayList<Director> listaDirectores = new ArrayList<>();
        String query = "select * from DIRECTOR";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listaDirectores.add(new Director (rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            rs.close();
            stmt.close();
        }
        return listaDirectores;
    }
    
//    //Creamos un método para listar los datos de la tabla DIRECTOR dentro de un arrayList de Director
//    private ArrayList<Director> listarDirectorSINpeliculas() throws Exception {
//        ArrayList<Director> listaDirectores = new ArrayList<>();
//        String query = "select * from DIRECTOR"
//                + "where idDirector not in (select distint(idDirector) from PELICULA);";
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                listaDirectores.add(new Director (rs.getInt(1), rs.getString(2), rs.getString(3)));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(System.out);
//        } finally {
//            rs.close();
//            stmt.close();
//        }
//        return listaDirectores;
//    }

}
