/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control.renderer;


import entidades.ArticuloFinal;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Base64;
import javax.swing.Icon;


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

        if (value.getImagenes().size()>0) {
            
            ImageIcon img=value.getImagenes().get(0);
            img.setImage(img.getImage().getScaledInstance(78, 78, Image.SCALE_SMOOTH));
            setIcon(img);
        }
        
       
        return this;
    }
    
}
