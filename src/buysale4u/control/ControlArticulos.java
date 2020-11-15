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
import entidades.ArticuloFinal;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static ArrayList<ArticuloFinal> listadoArticuloFinal;

    /**
     *
     *
     * @return
     */
    public static Articulo[] listar() {
        String json = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_ARTICULOS);

        Gson gson = new Gson();

        Articulo[] articulos = gson.fromJson(json, Articulo[].class);
        return articulos;

    }

    /**
     *
     * @param lista
     * @param array
     */
    public static void completarArticulo(JList lista, Articulo[] array) {
        listadoArticuloFinal = new ArrayList<>();
 
        Gson gson = new Gson();
        for (Articulo array1 : array) {
            Binario[] binario =null;
            String cadenabinario = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES + "?id_articulo=" + array1.getId());
         
           binario= gson.fromJson(cadenabinario, Binario[].class);
            
            ArticuloFinal galeria = new ArticuloFinal(array1, binario);
            listadoArticuloFinal.add(galeria);
        }
      
        DefaultListModel<ArticuloFinal> modelo = new DefaultListModel<>();
        for (ArticuloFinal af:listadoArticuloFinal) {
            modelo.addElement(af);
            
            
           
        }
        

        lista.setModel(modelo);
        lista.setCellRenderer(new ArticuloRendererList());
      
    }

   

    public static void insertar(ArrayList<byte[]> galeria, String titulo, String descripcion, int provincia) {
        String tituloEncode = URLEncoder.encode(titulo);
        String descripcionEncode = URLEncoder.encode(descripcion);
        String id = HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_ARTICULO + "?titulo=" + tituloEncode + "&descripcion=" + descripcionEncode + "&provincia=" + provincia + "&correo=" + Login.u.getEmail());

        
            
        
        for (byte[] bs : galeria) {

            String s = new String(bs);
           
            String json = "{\"id\":" + id + ", \"imgByte\":\"" + s + "\"}";
            String c=HttpRequest.POST_REQUEST(Constantes.URL_INSERTAR_IMAGEN, json);
            System.out.println(c);
        }

    }

    public static ImageIcon bytetoImg(byte[] bytes) {
        try {
            InputStream in = new ByteArrayInputStream(bytes);
            BufferedImage image = ImageIO.read(in);
            ImageIcon img = new ImageIcon(image);
            return img;
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        return null;
    }

}
