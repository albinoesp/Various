package ReadURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordInURL {

    public static final String TAG = WordInURL.class.getSimpleName();

    public static final Logger LOG = Logger.getLogger(TAG);


    //public static final String THE_URL = "http://www.gutenberg.org/cache/epub/29640/";
    public static final String THE_URL = "https://es.wikipedia.org/wiki/Wikipedia:Portada";



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;

        URL webPage = null;
        try {
            webPage = new URL(THE_URL);
        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        }

        // Crear un flujo para leer datos del URL
        BufferedReader htmlReader = null;
        try {
            htmlReader = new BufferedReader(
                    new InputStreamReader(webPage.openStream()));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }


        //ManejadorEtiquetas(word);
        ProcesaHTML wordin = new ProcesaHTML();
        wordin.procesa(htmlReader);

        /*try {
            while ((htmlLine = htmlReader.readLine()) != null) {
                if (htmlLine.toLowerCase().contains("<br")) {
                    System.out.println(htmlLine);

                } else {
                }
            }
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        } finally {
            try {
                if (htmlReader != null) {
                    htmlReader.close();
                }
            } catch (IOException ex) {
                LOG.severe(ex.getMessage());
            }
        }*/

    }
}
