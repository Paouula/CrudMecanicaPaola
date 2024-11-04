package Controlador;

import Modelo.crud;
import Vista.vistaCRUD;

/**
 *
 * @author Paola
 */
public class crtlCrud {
   private crud Modelo;
   private vistaCRUD Vista;
   
   public crtlCrud(crud Modelo, vistaCRUD Vista){
       this.Modelo = Modelo;
       this.Vista = Vista;
       
       Vista.btnAgregar.addMouseListener(this);
       Vista.btnActualizar.addMouseListener(this);
       Vista.btnEliminar.addMouseListener(this);
       Vista.btnLimpiar.addMouseListener(this);
       
   }
}
