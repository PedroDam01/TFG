/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import buysale4u.control.renderer.ArticuloRendererList;
import com.google.gson.Gson;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import entidades.Articulo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author PedroFB
 */
public class ControlArticulos {

    public static Articulo seleccionado;

    /**
     *
     * @param lista
     */
    public static void listar(JList lista) {
        String cadena = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_ARTICULOS);
        Gson gson = new Gson();
        Articulo[] array = gson.fromJson(cadena, Articulo[].class);
        DefaultListModel<Articulo> modelo = new DefaultListModel<>();
        for (Articulo art : array) {
            art.setImagenes((ImageIcon[]) imagenesArticulo(art).toArray());
            modelo.addElement(art);
        }

        lista.setModel(modelo);
        lista.setCellRenderer(new ArticuloRendererList());
    }

    /**
     *
     * @param articulo
     * @return
     */
    public static ArrayList<ImageIcon> imagenesArticulo(Articulo articulo) {
        try {
            ArrayList<byte[]> cadena = HttpRequest.GET_REQUEST_BINARY(Constantes.URL_LISTA_IMAGENES + "?id=" + articulo.getId());
            ArrayList<ImageIcon> iconos = new ArrayList<ImageIcon>();
            BufferedImage imagen = null;
            for (byte[] bs : cadena) {

                InputStream in = new ByteArrayInputStream(bs);

                imagen = ImageIO.read(in);
                ImageIcon img_final = new ImageIcon(imagen.getScaledInstance(60, 60, 0));
                iconos.add(img_final);
            }
            return iconos;
        } catch (IOException ex) {
            Logger.getLogger(ControlArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     *
     * @param img
     */
    public static void enviarImagen(File img) {

        try {

            BufferedImage bImage = ImageIO.read(img);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte[] data = bos.toByteArray();
            String byteArrayToString = new String(data);
            HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_IMAGEN + "?bytes=" + byteArrayToString);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControlArticulos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControlArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public static void insertar(ArrayList<byte[]> galeria, String titulo, String descripcion,int provincia) {
       String tituloEncode=URLEncoder.encode( titulo);
       String descripcionEncode=URLEncoder.encode(descripcion);
        String c=HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_ARTICULO+"?titulo="+tituloEncode+"&descripcion="+descripcionEncode+"&provincia="+provincia+"&correo="+Login.u.getEmail());
        System.out.println(c);
        galeria.forEach((bs) -> {
            HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_IMAGEN+"?binario="+bs.toString()+"&correo="+Login.u.getEmail());
        });
    }
}
