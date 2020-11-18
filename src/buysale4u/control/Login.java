/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import com.google.gson.Gson;
import entidades.Usuario;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 * Esta clase controla la funcionalidad de la ventana de inicio de sesion
 *
 * @author PedroFB
 */
public class Login {

    public static Usuario u = null;

    /**
     * Metodo para comprobar si existe o no un usuario en la base de datos
     *
     * @param correo String
     * @return retorno Usuario 
     */

    public static Usuario extraer(String correo) {
        //inicializamos una cadena de texto con el valor "correo" codificado como parte de URL
        String encode = URLEncoder.encode(correo);
        //cadena json con los datos del usuario
        String usu = HttpRequest.GET_REQUEST(Constantes.URL_EXISTE + "?correo=" + encode);
        //objeto Gson
        Gson gson = new Gson();
        //serializacion de la cadena json a un array de objetos de la clase Usuario
        Usuario[] usuario = gson.fromJson(usu, Usuario[].class);
        //iteramos el array
        for (Usuario retorno : usuario) {
            //comprobamos si el valor del campo email es igual a la cadena de texto pasada por parametro
            if (retorno.getEmail().equals(correo)) {
                //retornamos el objeto Usuario
                return retorno;
            }
        }
        //retornamos null en caso de que no exista el usuario
        return null;
    }

    /**
     * Metodo para registrar un usuario y guardarlo en la base de datos
     *
     * @param usuario Usuario
     *
     */
    public static void registrar(Usuario usuario) {
        //Comprobamos si el campo email del usuario que extraemos sea nulo
        if (extraer(usuario.getEmail()) == null) {
            //codificamos como parte de URL las cadenas de texto con los datos necesarios para la insercion
            String encode_nombre = URLEncoder.encode(usuario.getNombre());
            String encode_apell = URLEncoder.encode(usuario.getApellidos());
            String encode_con = URLEncoder.encode(usuario.getContraseña());
            String encode_email = URLEncoder.encode(usuario.getEmail());
            // accedemos al archivo php encargado de insertar un nuevo registro de usuario pasando los datos de dicho usuario en la url
            HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR + "?nombre=" + encode_nombre + "&apellidos=" + encode_apell + "&email=" + encode_email + "&pass=" + encode_con);

        } else {
            new JOptionPane("el email ya pertenece a un usuario existente").show();
        }

    }
}
