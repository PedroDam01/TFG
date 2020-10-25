/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control.renderer;

import entidades.Articulo;

import java.awt.Component;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author PedroFB
 */
public class ArticuloRendererList extends JLabel implements ListCellRenderer<Articulo>{


    public ArticuloRendererList() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Articulo> list, Articulo value, int index, boolean isSelected, boolean cellHasFocus) {
        String texto= value.getTitulo();
        setText(texto);
        ImageIcon[]icono=value.getImagenes();
        setIcon(icono[0]);
        
                return this;
    }
    
}
