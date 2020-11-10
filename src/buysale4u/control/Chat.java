/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import buysale4u.control.renderer.UsuarioRendererList;
import com.google.gson.Gson;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import entidades.Conversacion;
import entidades.Usuario;
import java.net.URLEncoder;
import javax.swing.DefaultListModel;

import javax.swing.JList;

/**
 * Esta clase ejecuta toda la logica necesaria para el funcionamiento del chat
 * dentro de la aplicacion
 *
 * @author PedroFB
 */
public class Chat {

    /**
     * este metodo crea e incorpora a la Jlist un modelo usando una lista de
     * usuarios obtenida del servidor
     *
     * @param lista
     */
    public static void listar(JList lista) {

       

        Usuario[] usuarios = lista_usuarios();

        DefaultListModel<Usuario> modelo = new DefaultListModel<>();
        for (Usuario usuario : usuarios) {
            modelo.addElement(usuario);
        }

        lista.setModel(modelo);
        lista.setVisible(true);
        lista.setCellRenderer(new UsuarioRendererList());

    }

    /**
     * obtiene una lista de usuarios con lo cual se ha establecido comunicacion
     *
     * @return
     */
    public static Usuario[] lista_usuarios() {

        String cadena = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_CHAT + "?correo=" + Login.u.getEmail());

        Gson gson = new Gson();
        Usuario[] array = gson.fromJson(cadena, Usuario[].class);

        return array;

    }

    /**
     * metodo que retorna una cadena con la conversacion guardada del cliente
     * con otro usuario
     *
     * @param u
     * @return
     */
    public static Conversacion[] insertarTexto(Usuario u) {

        String cadena = HttpRequest.GET_REQUEST(Constantes.URL_CONVERSACION + "?email1=" + Login.u.getEmail() + "&email2=" + u.getEmail());
        Gson gson = new Gson();
        
        Conversacion[] array = gson.fromJson(cadena, Conversacion[].class);
        
        return array;
    }

    /**
     * Metodo que envia un mensaje a un usuario seleccionado
     *
     * @param texto
     * @param mail
     */
    public static void enviar(String texto, String mail) {
       String encode= URLEncoder.encode(texto);
        String respuesta=HttpRequest.GET_REQUEST(Constantes.URL_ENVIAR_MENSAJE + "?texto=" + encode + "&email1=" + Login.u.getEmail() + "&email2=" + mail);
        System.out.println(respuesta);
    }

    /**
     * Metodo que elimina la conversacion con otro usuario
     *
     * @param email
     */
    public static void borrar(String email) {
        HttpRequest.GET_REQUEST(Constantes.URL_BORRAR_CONVERSACION + "?email1=" + Login.u.getEmail() + "&email2=" + email);
    }
}
