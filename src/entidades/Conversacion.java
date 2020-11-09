/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author PedroFB
 */
public class Conversacion {
    
    String mail,fechaHora,texto;

    public Conversacion(String texto, String fechaHora) {
     
        this.fechaHora = fechaHora;
        this.texto = texto;
    }

    public String getMail() {
        return mail;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return   "{"+fechaHora +"} : " + texto + '}';
    }
    
}
