/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Vista.vistaLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Paola
 */
public class crtlLogin implements MouseListener{

   Usuario Modelo;
   vistaLogin Vista;

    //2-Constructor 
    public crtlLogin(Usuario Modelo, vistaLogin Vista) {
        this.Modelo = Modelo;
        this.Vista = Vista;

        Vista.btnIngresar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource() == Vista.btnIngresar) {
            Modelo.setcorreo_usuario(Vista.txtCorreoLogin.getText());
            Modelo.setcontra_usuario(Modelo.convertirSHA256(Vista.txtContraLogin.getText()));

                      
            boolean comprobar = Modelo.iniciarSesion();

            if (comprobar == true) {
                JOptionPane.showMessageDialog(Vista,"Inicio de sesión realizada con exito");
            } else {
                JOptionPane.showMessageDialog(Vista, "Usuario no encontrado");

            }
            
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

    

