/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buysale4u.swing.articulos;

import buysale4u.control.ControlArticulos;
import com.google.gson.Gson;
import conexionWebService.Constantes;
import conexionWebService.HttpRequest;
import entidades.Provincia;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Interfaz grafica donde introducimos todos los datos para el nuevo articulo
 * que guardaremos en la base de datos
 *
 * @author PedroFB
 */
public class NuevoArticulo extends javax.swing.JDialog {

    //coleccion de array de bytes donde se almacenan, en binario, las imagenes del articulo
    ArrayList<byte[]> galeria;
//Coleccion de cadenas de texto donde almacenamos el nombre de la imagen que añadiremos al articulo
    ArrayList<String> elementos;
    //array de objetos de la clase Provincia 
    Provincia[] listaProvincias;
/**
 * Constructor 
 * @param parent
 * @param modal 
 */
    public NuevoArticulo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
//llamamos al metodo local para crear un modelo para el objeto JComboBox pasando como parametros dicho objeto
        modeloProvincias(provincia);
        //inicializamos las colecciones
        galeria = new ArrayList<>();
        elementos = new ArrayList<>();
    }

    /**
     * Metodo con el que añadimos las cadenas de texto con los nombres de las
     * provincias en un JComboBox
     *
     * @param jcb
     */
    private void modeloProvincias(JComboBox jcb) {
        //instanciamos un nuevo objeto DefaultComboBoxModel y lo inicializamos
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        //inicializamos una nueva cadena de texto con la cadena de texto que retorna del metodo GET_REQUEST
        String json = HttpRequest.GET_REQUEST(Constantes.URL_LISTA_PROVINCIAS);
        //inicializamos un nuevo objeto Gson
        Gson gson = new Gson();
        //usamos el objeto Gson para deserializar la cadena JSON en un array de Provincia local
        listaProvincias = gson.fromJson(json, Provincia[].class);
        // iniciamos un bucle iterando el anterior array
        for (Provincia listaProvincia : listaProvincias) {
            //añadimos elementos al modelo del JComboBox con la cadena de texto de las provincias
            modelo.addElement(listaProvincia.getNombre());
        }
        //cambiamos el modelo actual por el modelo creado anteriormente
        jcb.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        provincia = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Añadir Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        scroll.setViewportView(list);

        javax.swing.GroupLayout fileChooserLayout = new javax.swing.GroupLayout(fileChooser);
        fileChooser.setLayout(fileChooserLayout);
        fileChooserLayout.setHorizontalGroup(
            fileChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fileChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fileChooserLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        fileChooserLayout.setVerticalGroup(
            fileChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(fileChooser, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Titulo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Provincia");

        provincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //inicializamos un objeto JFileChooser donde elegiremos los archivos para el articulo
        JFileChooser fc = new JFileChooser();
        //Se crea el filtro. El primer parámetro es el mensaje que se muestra,
        //el segundo es la extensión de los ficheros que se van a mostrar      
        FileFilter filtro = new FileNameExtensionFilter("Imagen (.jpg)", "jpg");
        //Se le asigna al JFileChooser el filtro
        fc.setFileFilter(filtro);
        //recogemos un valor numerico que nos dira si realizamos una funcion valida en el objeto JFileChooser
        int valor = fc.showOpenDialog(fc);
//comprobamos el anterior valor para comparar si es una opcion valida
        if (valor == JFileChooser.APPROVE_OPTION) {

            try {
                //instanciamos un nuevo archivo con el archivo que hemos seleccionado 
                File f = fc.getSelectedFile();
                //extraemos el valor binario del archivo con el metodo extractBytes
                byte[] bytes = extractBytes(f);
                //añadimos a la coleccion galeria el valor binario anterior
                galeria.add(bytes);
                //llamamos al metodo actualizarLista
                actualizarLista(f);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(rootPane, "no has seleccionado un archivo");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "no has seleccionado un archivo valido");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //comparamos si los campos titulo(cadena de texto) y provincia (JComboBox) no estan vacios
        if (titulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "no has añadido titulo");
        } else if (provincia.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "selecciona una provincia");
        } else {
            //si no estan vacios llamamos al metodo insertar de ControlArticulos
            ControlArticulos.insertar(galeria, titulo.getText(), descripcion.getText(), listaProvincias[provincia.getSelectedIndex()].getId());
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Metodo que retorna un array de bytes con el valor binario del fichero
     * pasado por parametros
     *
     * @param imgPath File
     * @return imgB byte[]
     * @throws IOException 
     */
    public byte[] extractBytes(File imgPath) throws IOException {
        //Creamos un FileInputStream con el fichero pasado por parametros
        FileInputStream fr = new FileInputStream(imgPath);
        //creamos un nuevo array de bytes con la longitud de bytes del fichero
        byte imgB[] = new byte[(int) imgPath.length()];
        //extraemos los bytes del fichero con el objeto FileInputStream y añadimos los datos al array de bytes
        fr.read(imgB);
        //retornamos el array de bytes
        return imgB;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoArticulo dialog = new NuevoArticulo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descripcion;
    private javax.swing.JPanel fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JComboBox<String> provincia;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables

    /**
     * metodo con el que añadimos a un nuevo modelo de lista los datos de las
     * cadenas de texto almacenados en la coleccion elementos
     *
     * @param f File
     */
    private void actualizarLista(File f) {
        //instanciamos un nuevo DefaultListModel
        DefaultListModel<String> modelo = new DefaultListModel();
        //añadimos el nombre del fichero a la coleccion elementos
        elementos.add(f.getName());
        //iteramos la coleccion elementos
        for (String elemento : elementos) {
            //añadimos como elemento al modelo creado anteriormente las cadenas de texto de la coleccion
            modelo.addElement(elemento);
        }
        //sustituimos el modelo actual del JList por el creado en este metodo
        list.setModel(modelo);
    }
}