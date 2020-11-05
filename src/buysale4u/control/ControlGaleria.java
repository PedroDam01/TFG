/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import buysale4u.control.renderer.GaleriaRendererList;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author PedroFB
 */
public class ControlGaleria {
    
    public static void llenar_galeria(JList galeria){
        
        ImageIcon[] fotos=lista_fotos();
        
        DefaultListModel<ImageIcon> modelo= new DefaultListModel<>();
        for (ImageIcon imagen : fotos) {
            modelo.addElement(imagen);
        }
                galeria.setModel(modelo);
                galeria.setVisible(true);
                galeria.setCellRenderer(new GaleriaRendererList());
    }

    private static ImageIcon[] lista_fotos() {
        String cadena=HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES+"?id="+ControlArticulos.seleccionado.getId());
        return null;
    }
            
}
