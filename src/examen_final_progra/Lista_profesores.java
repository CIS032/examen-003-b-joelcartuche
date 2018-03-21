/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_final_progra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Cartuche
 */
public class Lista_profesores {

    private final String url = "jdbc:derby://localhost:1527/profesor";
    private final String usuario = "joel";
    private final String clave = "12345";
    private Connection conexion;

    public void Controlador_base() {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("error al establecer coneccion " + ex);
        }
    }

    public List visualizarporapellido(String profesor) {
        Controlador_base();
        List<Profesores> listita = new ArrayList<Profesores>();

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from profesor where apellido like '" + profesor + "%'");

            while (reg.next()) {
                
                String cedula = reg.getString("nombre");
                String nombre = reg.getString("nombre");
                String apellidob = reg.getString("apellido");
                String carrera = reg.getString("carrera");
                String tipo_profesor = reg.getString("tipo_profesor");
                String horas_clase = reg.getString("horas_clase");
                String horas_complementarias = reg.getString("horas_complementarias");

                Profesores nuevo = new Profesores(cedula, nombre, apellidob, Integer.parseInt(horas_clase), carrera, tipo_profesor, Integer.parseInt(horas_complementarias));
                listita.add(nuevo);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return listita;

    }

    public void grabar(Profesores profesores) {
        Controlador_base();
        int r = 0;
        boolean satisfac = true;
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from profesor");

            //while (reg.next()) {
            String sqlInsert = String.format("INSERT INTO profesor VALUES('%s','%s','%s','%s','%s','%s','%s')",
                    profesores.getCedula(),
                    profesores.getNombres(),
                    profesores.getSapellidos(),
                    profesores.getCarrera(),
                    profesores.getTipoProfesor(),
                    profesores.getHorasClase(),
                    profesores.getHoras_complementarias()
            );//insertando un nueva fila en la tabla
            r = sentencia.executeUpdate(sqlInsert);

            reg.close();
            sentencia.close();

        } catch (SQLException e) {
            System.out.println("error al enviar consulta: " + e);
            satisfac = false;
        }
        if (satisfac == true) {
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO INGRESADOS SATISFACTORIAMENTE");
        }

    }

}
