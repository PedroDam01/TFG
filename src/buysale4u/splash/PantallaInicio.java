package buysale4u.splash;

import buysale4u.Ventanas.VentanaLogin;
import com.sun.awt.AWTUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase mostrara una pantalla de inicio que se desvanecera con el tiempo
 *
 * @author PedroFB
 */
public class PantallaInicio extends javax.swing.JFrame implements Runnable {
// creamos un nuevo hilo de ejecucion

    private Thread tiempo = null;

    /**
     * creando nueva ventana PantallaInicio
     */
    public PantallaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);

        AWTUtilities.setWindowOpaque(this, false);
        tiempo = new Thread(this);
        tiempo.start();
    }

    /**
     * este metodo inicializa los componentes de la ventana
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.PNG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args incio de hilo de ejecucion principal
     */
    public static void main(String args[]) {
        //Cambio de apariencia de la ventana 

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
  /**
     * ejecucion de hilo que controla el tiempo de la pantalla de carga
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        //comprueba que el hilo no sea nulo
        while (tiempo != null) {
            try {
                //para el hilo de ejecucion principal
                Thread.sleep(3000);
                //cierra esta ventana
                this.dispose();
                //inicializa un objeto VentanaLogin
                VentanaLogin log = new VentanaLogin();
                //hace visible la ventana 
                log.setVisible(true);
                //para el hilo 
                Thread.sleep(5000);
                //cambia el valor del hilo secundario a null
                tiempo = null;
            } catch (InterruptedException ex) {
                Logger.getLogger(PantallaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tiempo = null;
    }
}
