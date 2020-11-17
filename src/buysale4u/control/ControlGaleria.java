/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import buysale4u.control.renderer.GaleriaRendererList;
import com.google.gson.Gson;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import entidades.Binario;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author PedroFB
 */
public class ControlGaleria {
    
    public static void llenar_galeria(JList galeria){
        
        ArrayList<ImageIcon> fotos=lista_fotos();
        
        DefaultListModel<ImageIcon> modelo= new DefaultListModel<>();
        for (ImageIcon imagen : fotos) {
            modelo.addElement(imagen);
        }
                galeria.setModel(modelo);
           
                galeria.setCellRenderer(new GaleriaRendererList());
    }

    private static ArrayList<ImageIcon> lista_fotos() {
           Gson gson = new Gson();
        String cadena=HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES+"?id_articulo="+ControlArticulos.seleccionado.getIdArticulo().getId());
        Binario[] binario = gson.fromJson(cadena, Binario[].class);
            ArrayList<ImageIcon> imagenes = new ArrayList<>();
            if (binario.length > 0) {

               for (Binario binario1 : binario) {
                   byte[] bytes = Base64.getDecoder().decode(binario1.getBinario());
                   ImageIcon ii = new ImageIcon(bytes);
                   imagenes.add(ii);
               }

            }
        return imagenes;
    }

    public static void contactar(int vendedor, String text) {
        
       String encode= URLEncoder.encode(text);
        HttpRequest.GET_REQUEST(Constantes.URL_CONTACTAR + "?texto=" + encode + "&email1=" + Login.u.getEmail() + "&idVendedor=" + vendedor);
    }
            
}
