package my_app;

import java.io.*;
import java.net.*;

public class My_app {
    
    public static void main(String[] args) throws Exception {
        
        //OBTENER HTML
        URL yahoo = new URL("https://yande.re/post?tags=kantoku");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = "";
        String inLine = in.readLine();
        
        while (inLine != null){                         
            inputLine = inputLine + inLine + " ";
            inLine = in.readLine();
        }
        
        in.close();
        
        int index1 = inputLine.indexOf("https://yande.re/jpeg/");
        int index2 = inputLine.indexOf(".jpg",index1);
        System.out.println(index1);
        System.out.println(index2);
        
        
        String urlImage = inputLine.substring(index1, index2+4);
        
        System.out.println(urlImage);
        
        
        
        //DESCARGAR Y GUARDAR IMAGEN
        /*String urlImage = "https://yande.re/image/d18a950308e599c5f1ee01bc7fa49de2/yande.re%20235406%20kunihiro_hinata%20muririn%20nipples%20noble_works%20no_bra%20open_shirt%20pajama%20panty_pull%20yuzu-soft.jpg";
        String destinationFile = "D:/Imagenes/Anime/Tsukiko App/MSPN.jpg";
        saveImage(urlImage, destinationFile);*/
    }
    
    public static void saveImage(String urlImage, String destinationFile) throws IOException {
            URL url = new URL(urlImage);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[1024];
            int length;

            System.out.println("Downloading image, wait please...");
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            System.out.println("DONE!");
            is.close();
            os.close();
    }
}