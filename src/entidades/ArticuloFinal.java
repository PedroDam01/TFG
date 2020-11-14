/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author PedroFB
 */
public class ArticuloFinal {

    Articulo articulo;
    ArrayList<Binario> imagenes;

    public Articulo getIdArticulo() {
        return articulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.articulo = idArticulo;
    }

    public ArrayList<Binario> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<Binario> imagenes) {
        this.imagenes = imagenes;
    }

    public ArticuloFinal(Articulo idArticulo, ArrayList<Binario> imagenes) {
        this.articulo = idArticulo;
        this.imagenes = imagenes;
    }

}
