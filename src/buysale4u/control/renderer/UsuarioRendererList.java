/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.control.renderer;

import entidades.Usuario;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *Esta clase renderiza cada celda del jlist que mostrara la lista de usuarios 
 * mostrando unicamente su email. Este constructor devuelve una etiqueta Jlabel 
 * que se usara de icono de celda.
 * @author PedroFB
 */
public class UsuarioRendererList extends JLabel implements ListCellRenderer<Usuario>{

    public UsuarioRendererList(){
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends Usuario> list, Usuario value, int index, boolean isSelected, boolean cellHasFocus) {
        String texto= value.getEmail();
        setText(texto);
        return this;
    }
    
}
