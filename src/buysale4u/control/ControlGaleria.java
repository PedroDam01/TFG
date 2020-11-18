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
 * Clase que ejecuta la logica necesaria para la gestion de la galeria de
 * imagenes y su renderizacion
 *
 * @author PedroFB
 */
public class ControlGaleria {

    /**
     * Metodo utilizado para reasignar los datos de un modelo de lista y su
     * renderizacion de celdas
     *
     * @param galeria JList
     */
    public static void llenar_galeria(JList galeria) {
        //inicializamos una coleccion de ImageIcon con los datos obtenidos del metodo lista_fotos
        ArrayList<ImageIcon> fotos = lista_fotos();
        //inicializamos, con el constructor por defecto, un nuevo modelo de lista
        DefaultListModel<ImageIcon> modelo = new DefaultListModel<>();
        //iteramos la coleccion de imagenes
        for (ImageIcon imagen : fotos) {
            //añadimos esas imagenes al nuevo modelo
            modelo.addElement(imagen);
        }
        //sustituimos el modelo actual de la lista que entra como parametro
        galeria.setModel(modelo);
        //sustituimos el renderizador de celdas por uno customizado
        galeria.setCellRenderer(new GaleriaRendererList());
    }

    /**
     * Metodo que consige de la base de datos los datos de las imagenes y los
     * devuelve en una coleccion de ImageIcon
     *
     * @return imagenes  ArrayList<ImageIcon>
     */
    private static ArrayList<ImageIcon> lista_fotos() {
        //objeto Gson
        Gson gson = new Gson();
        //cadena json con los datos de las imagenes
        String cadena = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES + "?id_articulo=" + ControlArticulos.seleccionado.getIdArticulo().getId());
        //serializacion del json a array de objetos Binario
        Binario[] binario = gson.fromJson(cadena, Binario[].class);
        //inicializamos una nueva coleccion con el constructor por defecto
        ArrayList<ImageIcon> imagenes = new ArrayList<>();
        //comprobamos si el array de Binario tiene datos
        if (binario.length > 0) {
            //iteramos el array
            for (Binario binario1 : binario) {
                //decodificamos en array de bytes el campo "String binario" de los objetos Binario
                byte[] bytes = Base64.getDecoder().decode(binario1.getBinario());
                //incializamos un objeto ImageIcon con los bytes obtenidos
                ImageIcon ii = new ImageIcon(bytes);
                //añadimos este objeto a la coleccion local
                imagenes.add(ii);
            }

        }
        //retornamos la coleccion de ImageIcon
        return imagenes;
    }

    /**
     * Metodo similar al utilizado para enviar un mensaje en la clase Chat.java
     * con la diferencia de que se envia a un usuario predefinido
     *
     * @param vendedor int
     * @param text String
     */
    public static void contactar(int vendedor, String text) {

        String encode = URLEncoder.encode(text);
        HttpRequest.GET_REQUEST(Constantes.URL_CONTACTAR + "?texto=" + encode + "&email1=" + Login.u.getEmail() + "&idVendedor=" + vendedor);
    }

}
