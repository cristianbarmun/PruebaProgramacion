/*
 * FASE 3
La clase contenedora de nuestras colecciones tendrá el método de simularDia().
El método simular día lo que hará será procesar la colección de infectables y en el proceso de recorrido, por
cada posición de la colección, ejecutaremos el método visitarSuper(), visitarTrabajo(), visitarTransporte()
que determinarán si la persona se ha infectado o no. Si al entrar en algún sitio se infecta, en los demás no
habrá la necesidad de hacer la operación.
Sería muy interesante que no todas las personas ejecutaran los tres métodos y que también aleatoriamente,
una persona tenga la opción de ejecutar los tres métodos o solo uno. Si no se consigue un método para
hacer esto último haremos que todas las personas ejecuten los tres métodos.
Solo habrá la posibilidad de crear una enfermera y será la primera que se recupere de la colección al
procesar que será la última enfermera que se haya metido en la estructura. Esta hará una primera pasada
con su método vacunar y el parámetro colección y una segunda utilizando el método vacunar con el
parámetro infectable. La enfermera vacuna en la primera pasada a 2 de cada 5 infectados. Y en la segunda
pasada a 1 de cada 5.
Al final de esta fase, la colección de pacientes debe de estar ya con los infectados fijos del día.
 */
package bbdd;

import VO.PersonasVO;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pruebaprogramacionfase3.Paciente;

/**
 *
 * @author crist
 */
public class Operaciones {

    private static Connection conexion;
    private static Statement st;
    private static Scanner lector;
    private static Collection miColeccion;
    private static PersonasVO personas;
    
    private static Logger logger = LogManager.getLogger(Operaciones.class);
    
    public static void main(String[] args) {
    	
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("Properties\\log4j.properties");
		PropertyConfigurator.configure(url);
    	
        int idCiudad;

        //preguntamos el id de la ciudad para ver sus usuarios
        lector = new Scanner(System.in);
        System.out.println("Diga el id de la ciudad para ver sus usuarios: ");
        idCiudad = lector.nextInt();

        conexion = Conexion.getConexion();
        try {

            if (conexion != null) {

                st = conexion.createStatement();

                consultar(idCiudad);

                simularDia();

            } else {
            	logger.error("Conexion no realizada");
            }
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                st.close();
            } catch (SQLException ex) {
            	logger.error("Error "+ex.getMessage());
            }
            lector.close();
            Conexion.desconectar();
            logger.info("Conexi�n cerrada");
        }
    }

    /**
     * recuperar todos los usuarios de una ciudad
     */
    public static Collection<PersonasVO> consultar(int id_ciudad) throws SQLException {
        System.out.println("*** Usuarios en ciudad ***");
        String query = "SELECT Nombre, Tipo, Infectado FROM personas WHERE id_ciudad = " + id_ciudad;
        // System.out.println(query);
        ResultSet rs = st.executeQuery(query);

        personas = new PersonasVO();
        miColeccion = new HashSet<PersonasVO>();

        // Columnas de la tabla: nombre, tipo e infectado
        while (rs.next()) {
            String nombre = rs.getString(1);
            String tipo = rs.getString(2);
            int infectado = rs.getInt(3);

            //insertamos en la coleccion las personas
            miColeccion.add(personas);

            System.out.println("\t" + nombre + " * " + tipo + " * " + infectado);
        }
        rs.close();
        logger.info("ResultSet cerrado correctamente.");
        return miColeccion;
    }

    /**
     * procesamos la colección de infectables
     */
    public static void simularDia() {
        Paciente pac = new Paciente();
        Collection<Infectable> miColeccion = new HashSet<>();

        //por cada posicion se ejecutan los metodos para ver si se ha infectado
        for (int i = 0; i < miColeccion.size(); i++) {
            //si alguno de los metodos es igual a true, es que se ha infectado. 
            //por lo cual no se ejecutaran el resto
            if (pac.visitarSuper() == true) {

            } else if (pac.visitarTrabajo() == true) {

            } else if (pac.cogerTransporte() == true) {

            }
        }

    }
}
