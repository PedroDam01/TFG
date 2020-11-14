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
public class Binario {
    String binario;
    int idArticulo;
    public Binario( String binario,int idArticulo) {
        this.binario = binario;
        this.idArticulo=idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    

    public int getIdArticulo() {
        return idArticulo;
    }

    public  String getBinario() {
        return binario;
    }

    public void setBinario( String binario) {
        this.binario = binario;
    }
   
    
}
