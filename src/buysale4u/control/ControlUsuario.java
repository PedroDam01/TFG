/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import conexionWebService.Constantes;
import conexionWebService.HttpRequest;

/**
 *Clase que almacena la logica para sobreescribir los datos de los usuarios
 * @author PedroFB
 */
public class ControlUsuario {
/**
 * Metodo utilizado para cambiar la contraseña de los usuarios
 * @param text String
 */
    public static void actualizar_contraseña(String text) {
        HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_CONTRASEÑA+"?pass="+text+"&email="+Login.u.getEmail());
    }
/**
 * Metodo utilizado para cambiar los apellidos de los usuarios
 * @param text String
 */
    public static void actualizar_apellidos(String text) {
           HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_APELLIDO+"?apellido="+text+"&email="+Login.u.getEmail());
    }
/**
 * Metodo utilizado para cambiar el nombre de los usuarios
 * @param text String
 */
    public static void actualizar_nombre(String text) {
            HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_NOMBRE+"?nombre="+text+"&email="+Login.u.getEmail());
    }
    
}
