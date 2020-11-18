package conexionWebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase HttpRequest: permite enviar (INSERT,DELETE,UPDATE) y recibir (SELECT)
 * datos del WebService
 *
 *
 * @author PedroFB
 *
 */
public final class HttpRequest {

    /**
     * Enviar peticiones mediante post al webservice y retornar una cadena de
     * texto json con los valores que se requieren en otras operaciones
     *
     * @param url String
     * @param values String
     * @return String
     */
    public static String POST_REQUEST(String url, String values) {
        try {
            //inicializamos un constructor de cadenas de texto
            StringBuilder result = new StringBuilder();
            //inicializamos un objeto URL con la cadena de texto obtenida url
            URL url2 = new URL(url);
            //creamos una conexion con la url anterior
            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
            //cambiamos el metodo de peticion a post
            conn.setRequestMethod("POST");
            //cambiamos la configuracion de los encabezados http
            conn.setRequestProperty("Content-Type", "application/json");
            //
            conn.setDoOutput(true);
            //creamos un flujo de salida 
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            //almacenamos la cadena json llamada values en ese flujo de salida 
            wr.write(values);
            wr.flush();
            //creamos un buffer de lectura de datos con un nuevo flujo de entrada de datos
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //inicializamos una cadena de texto
            String line;
            //iniciamos un bucle que termina cuando no quedan mas datos en el buffer de lectura
            while ((line = rd.readLine()) != null) {
                //añadimos esos datos del buffer de lectura al constructor de cadenas de texto
                result.append(line);
            }
            //cerramos los flujos de entrada y salida
            wr.close();
            rd.close();
            //retornamos los datos del constructor
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

    /**
     * Enviar peticiones mediante get al webservice y retornar una cadena de
     * texto json con los valores que se requieren en otras operaciones
     *
     * @param url String
     *
     * @return String
     */
    public static String GET_REQUEST(String url) {
        try {
            //inicializamos un constructor de cadenas de texto
            StringBuilder result = new StringBuilder();
            // inicializamos un objeto URL pasando al constructor el parametro url            
            URL obj = new URL(url);
            //creamos la conexion http mediante la URL anterior
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // creamos un buffer de lectura con un flujo de entrada de datos
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            //creamos una cadena de texto
            String inputLine;
            //iniciamos un bucle que termina si el flujo de entrada es nulo
            while ((inputLine = in.readLine()) != null) {
                //añadimos al constructur de cadenas de texto los datos del flujo de entrada
                result.append(inputLine);
            }
            //retornamos los datos del constructor de cadenas de texto
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

}
