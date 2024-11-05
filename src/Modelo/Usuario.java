package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.UUID;

public class Usuario {
    
    //Los parametros
    private String UUID_Usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String correo_usuario;
    private int edad_usuario;
    private String contra_usuario;
    
    //Getters y Setters
    public String getUUID_Usuario() {
        return UUID_Usuario;
    }
    
    public void setUUID_Usuario(String UUID_Usuario){
        this.UUID_Usuario = UUID_Usuario;
    }
    
    public String getnombre_usuario() {
        return nombre_usuario;
    }
    
    public void setnombre_usuario(String nombre_usuario){
        this.nombre_usuario = nombre_usuario;
    }
    
    public String getapellido_usuario() {
        return apellido_usuario;
    }
    
    public void setapellido_usuario(String apellido_usuario){
        this.apellido_usuario = apellido_usuario;
    }
    
    public String getcorreo_usuario() {
        return correo_usuario;
    }
    
    public void setcorreo_usuario(String correo_usuario){
        this.correo_usuario = correo_usuario;
    }
    
    public int getedad_usuario() {
        return edad_usuario;
    }
    
    public void setedad_usuario(int edad_usuario){
        this.edad_usuario = edad_usuario;
    }
    
    public String getcontra_usuario() {
        return contra_usuario;
    }
    
    public void setcontra_usuario(String contra_usuario){
        this.contra_usuario = contra_usuario;
    }
    
    //Metodos 
    
    public void GuardarUsuario(){
    
        Connection conexion = ClaseConexion.getConexion();
        try{
        
            PreparedStatement addRegistro = conexion.prepareStatement ("INSERT INTO tb_Usuario(UUID_Usuario, nombre_usuario, apellido_usuario, correo_usuario, contra_usuario, edad_usuario) VALUES (?, ?, ?, ?, ?, ?)");
            
            addRegistro.setString(1, UUID.randomUUID().toString());
            addRegistro.setString(2, getnombre_usuario()); 
            addRegistro.setString(3, getapellido_usuario()); 
            addRegistro.setString(4, getcorreo_usuario()); 
            addRegistro.setString(5, getcontra_usuario()); 
            addRegistro.setInt(6, getedad_usuario()); 
            
            addRegistro.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
    
    public boolean iniciarSesion(){
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;
        
        try{
            String sql = "SELECT * FROM tbUsuario WHERE correo_usuario = ? AND contra_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement (sql);
            statement.setString(1, getcorreo_usuario());
            statement.setString(2, getcontra_usuario());
            
            
            ResultSet resultSet = statement.executeQuery();
            
            //Si hay resultado
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
    
    //Contraseña encriptada
    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
    }
        }
        



    
 
    

