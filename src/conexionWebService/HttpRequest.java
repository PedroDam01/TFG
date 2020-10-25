package conexionWebService;



import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Clase HttpRequest: permite enviar (INSERT,DELETE,UPDATE) y recibir (SELECT) datos del WebService
 * 
 * 
 * @author PedroFB
 *
 */

public final class HttpRequest {

	/**
	 * Enviar peticiones de ACTUALIZACIÓN
	 * @param url
	 * @param values
	 * @return
	 */
    public static String POST_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            URL url2 = new URL(url);
            URLConnection conn = url2.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(values);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            wr.close();
            rd.close();
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

    /**
     * Solicitar la ejecución de consultas 
     * 
     * @param url
     * 
     * @return
     */
    public static String GET_REQUEST(String url) {
        try {
            StringBuilder result = new StringBuilder();
            String URL = url ;
            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
    /**
     * ejecucion de consultas que devuelbe valor binario
     * @param url
     * @return 
     */
     public static ArrayList<byte[]> GET_REQUEST_BINARY(String url) {
       
        try {
            ArrayList<byte[]> result=new ArrayList<byte[]>();
            String URL = url ;
            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                byte[] binario = inputLine.getBytes();
                result.add(binario);
                
            }
            return result;
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        
        
    }
   
}