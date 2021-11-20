package resources;

import interfaces.OnNewDataHandler;
import leroymerlen.Article;

import java.io.IOException;
import java.util.ArrayList;

public class NewData implements OnNewDataHandler<ArrayList<Article>>
{
    public void OnNewData(Object sender, ArrayList<Article> args) throws IOException {
        for (Article s : args) {
            System.out.println(s.product);
            System.out.println(s.name);
            System.out.println(s.plus);
            System.out.println(s.minus);
            System.out.println(s.message);
            System.out.println();
            //try{ SaveImage(s.pathImage);}catch (Exception ignored){}
        }
    }

    /*private void SaveImage(String url) throws IOException
    {
        URL URL = new URL(url);
        BufferedImage img = ImageIO.read(URL);
        File file = new File("E:\\Работа\\Java\\лаб 3\\ParseLib\\src\\Image\\" + url.substring(url.lastIndexOf('/')));
        ImageIO.write(img, "jpg", file);
    }*/
}

