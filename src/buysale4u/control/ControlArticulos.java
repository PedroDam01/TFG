/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import buysale4u.control.renderer.ArticuloRendererList;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import entidades.Articulo;
import entidades.Binario;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
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
     * 
     */
    public static Articulo[] listar() {
        String cadena = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_ARTICULOS);
        Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaringClass().equals(Articulo.class);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
        }).create();
        Articulo[] array = gson.fromJson(cadena, Articulo[].class);
       
      return array;
    }
    /**
     * 
     * @param lista
     * @param array 
     */
public static void completarArticulo(JList lista,Articulo[]array){
    System.out.println(array.length);
             Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaringClass().equals(Binario.class);
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
        }).create();

      for (int i = 0; i < array.length; i++) {
            ImageIcon[] imagenes = null;
            String cadenabinario = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES + "?id_articulo=" + array[i].getId());
            Binario[] binario = gson.fromJson(cadenabinario, Binario[].class);
            for (int x = 0; x < binario.length; x++) {
                if (binario[x]!=null) {
                    imagenes[x] = new ImageIcon(binario[x].getBinario());
                }
                
            }

            array[i].setImagenes(imagenes);
        }
        DefaultListModel<Articulo> modelo = new DefaultListModel<>();

        lista.setModel(modelo);
        lista.setCellRenderer(new ArticuloRendererList());
    
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

    public static void insertar(ArrayList<byte[]> galeria, String titulo, String descripcion, int provincia) {
        String tituloEncode = URLEncoder.encode(titulo);
        String descripcionEncode = URLEncoder.encode(descripcion);
        String id = HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_ARTICULO + "?titulo=" + tituloEncode + "&descripcion=" + descripcionEncode + "&provincia=" + provincia + "&correo=" + Login.u.getEmail());

        for (byte[] bs : galeria) {

            String s = Base64.getEncoder().encodeToString(bs);
            String json = "{\"id\":" + id + ", \"imgByte\":\"" + s + "\"}";
            HttpRequest.POST_REQUEST(Constantes.URL_INSERTAR_IMAGEN, json);
        }

    }

    public static ImageIcon bytetoImg(byte[] bytes) {
        try {
            InputStream in = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(in);
            ImageIcon img = new ImageIcon(image);
            return img;
        } catch (IOException ex) {
            Logger.getLogger(ControlArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
