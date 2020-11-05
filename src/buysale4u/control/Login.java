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
import javax.swing.JOptionPane;




/**
 *Esta clase controla la funcionalidad de la ventana de inicio de sesion
 * 
 * @author PedroFB
 */
public class Login {
     public static Usuario u=null;
    /**
     * Metodo para comprobar si existe o no un usuario en la base de datos
     * 
     * @param correo
     * @return 
     */
   
    public static Usuario extraer(String correo){
        String usu= HttpRequest.GET_REQUEST(Constantes.URL_EXISTE+"?correo="+correo);
       
         Gson gson=new Gson();
         Usuario[] usuario=gson.fromJson(usu,Usuario[].class);
         for (Usuario retorno : usuario) {
             if (retorno.getEmail().equals(correo)) {
                 return retorno;
             }
        }
     return null;
    }
    /**
     * Metodo para registrar un usuario y guardarlo en la base de datos
     * 
     * @param usuario 
     *   
     */
    public static void registrar(Usuario usuario){
    
        if (extraer(usuario.getEmail())==null) {
                  // accedemos al archivo php encargado de insertar un nuevo registro de usuario pasando los datos de dicho usuario en la url
        String respuesta=HttpRequest.GET_REQUEST(Constantes.URL_INSERTAR+"?nombre="+usuario.getNombre()+"&apellidos="+usuario.getApellidos()+"&email="+usuario.getEmail()+"&pass="+usuario.getContraseña());
            
        }else{
            new JOptionPane("el email ya pertenece a un usuario existente").show();
        }
        
    }
}
