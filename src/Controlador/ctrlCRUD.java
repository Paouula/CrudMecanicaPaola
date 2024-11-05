package Controlador;

import Modelo.crud;
import Vista.frmCRUD;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlCRUD implements MouseListener, keyListener{
    
    private crud Modelo;
    private frmCRUD Vista;
    
    public ctrlCRUD (crud Modelo, frmCRUD Vista){
    this.Modelo = Modelo;
    this.Vista = Vista;
    
    Vista.btnAgregar.addMouseListener(this);
    modelo.Mostrar(vista.jtbPaciente);
        Vista.btnEliminar.addMouseListener(this);
        Vista.jtbCoso.addMouseListener(this);
        Vista.btnActualizar.addMouseListener(this);
        Vista.btnLimpiar.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
