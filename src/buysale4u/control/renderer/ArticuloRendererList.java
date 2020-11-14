/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control.renderer;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import entidades.ArticuloFinal;

import java.awt.Component;
import javax.swing.ImageIcon;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author PedroFB
 */
public class ArticuloRendererList extends JLabel implements ListCellRenderer<ArticuloFinal>{


    public ArticuloRendererList() {
        setOpaque(true);
    }

  

    @Override
    public Component getListCellRendererComponent(JList<? extends ArticuloFinal> list, ArticuloFinal value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getIdArticulo().getTitulo());
        if (value.getImagenes()!=null) {
            byte[] array= Base64.decode(value.getImagenes().get(0).getBinario());
            ImageIcon img=new ImageIcon(array);
            setIcon( img);
        }
       
       
        return this;
    }
    
}
