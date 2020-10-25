/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 * Clase referente a la entidad usada en la base de datos para designar a cada usuario
 * @author PedroFB
 */
public class Usuario {
    String nombre,apellidos,clave,email;

    public Usuario(String nombre, String apellidos, String clave, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
        this.email = email;
    }

    public String getContraseña() {
        return clave;
    }

   
    public String getNombre() {
        return nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

  

   
    
}
