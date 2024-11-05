package Controlador;

import Modelo.Usuario;
import Vista.vistaLogin;
import Vista.vistaRegistro;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class crtlRegistro implements MouseListener{
    
    Usuario Modelo;
    vistaRegistro Vista;
    
    //Constructor
    public crtlRegistro(Usuario Modelo, vistaRegistro Vista){
        this.Modelo = Modelo;
        this.Vista = Vista;
        
        Vista.btnRegistrar.addMouseListener(this);
        Vista.btnLogin.addMouseListener(this);
        
         
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == Vista.btnRegistrar){
            Modelo.setnombre_usuario(Vista.txtNombreRegistro.getText());
            Modelo.setapellido_usuario(Vista.txtApellidoRegistro.getText());
            Modelo.setcorreo_usuario(Vista.txtCorreoRegistro.getText());
            Modelo.setedad_usuario(Integer.parseInt(Vista.txtEdadRegistro.getText()));
            Modelo.setcontra_usuario(Modelo.convertirSHA256(Vista.txtContraRegistro.getText()));
            
            Modelo.GuardarUsuario();
            
            //Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(Vista, "El usuario se registro correctamente");
        }
        
        
         if (e.getSource()== Vista.btnLogin) {
        //mandamos a llamar la funcion init del formulario al que queremos ir 
         Vista.initvistaLogin();
           Vista.dispose();
            
              }

        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
