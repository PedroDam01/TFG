/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author PedroFB
 */
public class ArticuloFinal {

    Articulo articulo;
    ArrayList<ImageIcon> imagenes;

    public Articulo getIdArticulo() {
        return articulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.articulo = idArticulo;
    }

    public  ArrayList<ImageIcon> getImagenes() {
        return imagenes;
    }

    public void setImagenes( ArrayList<ImageIcon> imagenes) {
        this.imagenes = imagenes;
    }

    public ArticuloFinal(Articulo idArticulo, ArrayList<ImageIcon>imagenes) {
        this.articulo = idArticulo;
        this.imagenes = imagenes;
    }

}
