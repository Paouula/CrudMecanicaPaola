/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paola
 */
public class crud {
    
     private String uuid_repaVehiculo;
    private String nombre_cliente;
    private String apellido_cliente;
    private String telefono;
    private String marca;
    private String modelo;
    private int ano_vehiculo;
    private String problemas_Vehiculo;
    private String estado_prob_vehiculos;

    public String getUuid_repaVehiculo() {
        return uuid_repaVehiculo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno_vehiculo() {
        return ano_vehiculo;
    }

    public String getProblemas_Vehiculo() {
        return problemas_Vehiculo;
    }

    public String getEstado_prob_vehiculos() {
        return estado_prob_vehiculos;
    }

    public void setUuid_repaVehiculo(String uuid_repaVehiculo) {
        this.uuid_repaVehiculo = uuid_repaVehiculo;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno_vehiculo(int ano_vehiculo) {
        this.ano_vehiculo = ano_vehiculo;
    }

    public void setProblemas_Vehiculo(String problemas_Vehiculo) {
        this.problemas_Vehiculo = problemas_Vehiculo;
    }

    public void setEstado_prob_vehiculos(String estado_prob_vehiculos) {
        this.estado_prob_vehiculos = estado_prob_vehiculos;
    }
    
    //Guardar
    
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbinfoVehiculo(uuid_repaVehiculo,  nombre_cliente, apellido_cliente, telefono_cliente, marca, modelo, ano_vehiculo, problemas_vehiculos, estado_prob_vehiculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getnombre_cliente());
            addProducto.setString(3, getTelefono());
            addProducto.setString(4, getMarca());
            addProducto.setString(5, getModelo());
            addProducto.setInt(6, getAno_vehiculo());
            addProducto.setString(7, getProblemas_Vehiculo());
            addProducto.setString(8, getestado_prob_vehiculos());
            //Ejecutar la consulta
            addProducto.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    private String getnombre_cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getapellido_cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getestado_prob_vehiculos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
     //Metodo de mostrar
       public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID_paciente", "Nombre", "Edad", "Especialidad"});
        try {
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbinfoVehiculo(uuid_repaVehiculo,  nombre_cliente, apellido_cliente, telefono_cliente, marca, modelo, ano_vehiculo, problemas_vehiculos, estado_prob_vehiculo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getnombre_cliente());
            addProducto.setString(3, getTelefono());
            addProducto.setString(4, getMarca());
            addProducto.setString(5, getModelo());
            addProducto.setInt(6, getAno_vehiculo());
            addProducto.setString(7, getProblemas_Vehiculo());
            addProducto.setString(8, getestado_prob_vehiculos());
            //Ejecutar la consulta
            addProducto.executeUpdate();
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
       
       
       //Metodo de borrar
           public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("delete from tbVisitas where uuid_repaVehiculo = ?");
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
           
           //Metodo de cargar 
           
           public void cargarDatosTabla(frmVisitas vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbPaciente.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbCoso.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbCoso.getValueAt(filaSeleccionada, 1).toString();
            String ApellidoDeTb = vista.jtbCoso.getValueAt(filaSeleccionada, 2).toString();
            String TB = vista.jtbCoso.getValueAt(filaSeleccionada, 3).toString();
 
            // Establece los valores en los campos de texto
            vista.txtNombre.setText(NombreDeTB);
            vista.txtEdad.setText(EdadDeTb);
            vista.txtEspecialidad.setText(EspecialidadDeTB);
        }
    }
           
           //Metodo de actualizar
           
           public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update tbVisitas set nombre= ?, edad = ?, especialidad = ? where UUID_paciente = ?");
 
                updateUser.setString(1, getNombre());
                updateUser.setInt(2, getEdad());
                updateUser.setString(3, getEspecialidad());
                updateUser.setString(4, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
     
}
