/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control.renderer;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Clase que se encarga de renderizar los Galeria de JList
 *
 * @author PedroFB
 */
public class GaleriaRendererList extends JLabel implements ListCellRenderer<ImageIcon> {

    public GaleriaRendererList() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ImageIcon> list, ImageIcon value, int index, boolean isSelected, boolean cellHasFocus) {

        //imagen origen
        Image img = value.getImage();
//escala imagen
        Image newimg = img.getScaledInstance(78, 78, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);

        setIcon(imageIcon);
        return this;
    }
}
