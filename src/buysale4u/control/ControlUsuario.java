/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control;

import conexionWebService.Constantes;
import conexionWebService.HttpRequest;

/**
 *
 * @author PedroFB
 */
public class ControlUsuario {

    public static void actualizar_contraseña(String text) {
        HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_CONTRASEÑA+"?nuevo="+text+"&email="+Login.u.getEmail());
    }

    public static void actualizar_apellidos(String text) {
           HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_APELLIDO+"?nuevo="+text+"&email="+Login.u.getEmail());
    }

    public static void actualizar_nombre(String text) {
            HttpRequest.GET_REQUEST(Constantes.URL_ACTUALIZAR_NOMBRE+"?nuevo="+text+"&email="+Login.u.getEmail());
    }
    
}
