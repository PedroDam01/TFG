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
import entidades.Binario;
import entidades.ArticuloFinal;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 * Clase que ejecuta la logica necesaria para la gestion de los articulos y su
 * renderizacion
 *
 * @author PedroFB
 */
public class ControlArticulos {

    //Objeto donde almacenamos los datos del articulo que seleccionemos en las listas renderizadas
    public static ArticuloFinal seleccionado;
    //coleccion de articulos que se rendelizaran en las listas
    public static ArrayList<ArticuloFinal> listadoArticuloFinal;

    /**
     * Metodo que retorna un array de objetos de la clase Articulo, los cuales
     * son todos los articulos existentes, del resto de usuarios, en la base de
     * datos
     *
     * @return articulos Articulo[]
     */
    public static Articulo[] listar() {
        //cadena json con los datos de los articulos
        String json = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_ARTICULOS);
        //objeto Gson
        Gson gson = new Gson();
        //serializacion del json a array de Articulo
        Articulo[] articulos = gson.fromJson(json, Articulo[].class);

        return articulos;

    }

    /**
     * Metodo que recupera de la base de datos las imagenes de los articulos
     * para completar los articulos que entran como parametro con sus imagenes e
     * incorporar los datos en un modelo de lista. Todo esto para cambiar el
     * modelo de lista actual por el nuevo
     *
     * @param lista JList
     * @param array Articulo[]
     */
    public static void completarArticulo(JList lista, Articulo[] array) {
        //inicializa variable local
        listadoArticuloFinal = new ArrayList<>();
        // objeto Gson
        Gson gson = new Gson();
        //iteraccion de array de articulos
        for (Articulo array1 : array) {
            //inicializar a nulo un array de Binario
            Binario[] binario = null;
            //cadena json donde se almacenan los datos de las imagenes 
            String cadenabinario = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_IMAGENES + "?id_articulo=" + array1.getId());
            //serializacion de json a array de Binario
            binario = gson.fromJson(cadenabinario, Binario[].class);
            //inicializar coleccion de ImageIcon
            ArrayList<ImageIcon> imagenes = new ArrayList<>();
            //comprobamos si el array de Binario tiene datos
            if (binario.length > 0) {
                //iteramos el array de Binario
                for (Binario binario1 : binario) {
                    //decodificamos los datos de la cadena de texto del atributo "String binario" de cada objeto a Base64
                    byte[] bytes = Base64.getDecoder().decode(binario1.getBinario());
                    //creamos un nuevo objeto ImageIcon con los bytes en base64
                    ImageIcon ii = new ImageIcon(bytes);
                    //añadimos el objeto a la coleccion local
                    imagenes.add(ii);
                }

            }
            //creamos un nuevo objeto Articulo final con los datos obtenidos
            ArticuloFinal galeria = new ArticuloFinal(array1, imagenes);
            //añadimos a la coleccion el nuevo objeto
            listadoArticuloFinal.add(galeria);

        }
        //inicializamos un nuevo modelo de lista
        DefaultListModel<ArticuloFinal> modelo = new DefaultListModel<>();
        //iteramos la coleccion de ArticuloFinal
        for (ArticuloFinal af : listadoArticuloFinal) {
            //añadimos los datos de los objetos al modelo
            modelo.addElement(af);

        }
        //cambiamos el modelo
        lista.setModel(modelo);
        //cambiamos el renderizador de celdas por uno customizado con el constructor de la clase ArticuloRendererList
        lista.setCellRenderer(new ArticuloRendererList());

    }

    /**
     * Metodo que guarda un nuevo registro de articulo y sus imagenes en la base
     * de datos
     *
     * @param galeria ArrayList byte[] 
     * @param titulo String
     * @param descripcion String
     * @param provincia int
     */
    public static void insertar(ArrayList<byte[]> galeria, String titulo, String descripcion, int provincia) {
        //cadenas de texto codificada para URL
        String tituloEncode = URLEncoder.encode(titulo);
        String descripcionEncode = URLEncoder.encode(descripcion);

        //cadena json con el id del articulo despues de haberlo guardado en la base de datos
        String id = HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR_ARTICULO + "?titulo=" + tituloEncode + "&descripcion=" + descripcionEncode + "&provincia=" + provincia + "&correo=" + Login.u.getEmail());
        //iteramos la coleccion de array de bytes que entra como parametro
        for (byte[] bs : galeria) {
            //cadena de texto donde almacenamos los bytes codificados a base64
            String s = Base64.getEncoder().encodeToString(bs);
            //cadena json para introducir los datos de la imagen que vamos  a insertar en la base de datos
            String json = "{\"id\":" + id + ", \"imgByte\":\"" + s + "\"}";
            //insertamos el nuevo registro de imagen en la base de datos
            HttpRequest.POST_REQUEST(Constantes.URL_INSERTAR_IMAGEN, json);
        }

    }

    /**
     * Metodo que retorna un objeto ImageIcon construida a partir de un array de
     * bytes
     *
     * @param bytes byte[]
     * @return img ImageIcon
     * @throws IOException
     */
    public static ImageIcon bytetoImg(byte[] bytes) throws IOException {
        //inicializamos un flujo de entrada de bytes
        InputStream in = new ByteArrayInputStream(bytes);
        //guardamos los datos de una imagen obtenidos del flujo de entrada de bytes
        BufferedImage image = ImageIO.read(in);
        //inicializamos una nueva imagen con los datos guardados
        ImageIcon img = new ImageIcon(image);
        //retornamos la imagen
        return img;

    }

}
