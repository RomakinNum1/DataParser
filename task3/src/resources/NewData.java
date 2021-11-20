package resources;

import interfaces.OnNewDataHandler;
import yandex.Article;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class NewData implements OnNewDataHandler<ArrayList<Article>>
{
    public void OnNewData(Object sender, ArrayList<Article> args) throws IOException {
        for (Article s : args) {
            try{ SaveImage(s.pathImage);}catch (Exception ignored){}
        }
    }

    private void SaveImage(String url) throws IOException
    {
        if(url.indexOf("?") >= 0)
        {
            url = url.substring(0, url.indexOf("?"));
        }

        URL URL = new URL(url);
        BufferedImage img = ImageIO.read(URL);
        File file = new File("E:\\Работа\\Практика\\Parser\\task3\\src\\Images\\" + url.substring(url.lastIndexOf('/')));
        ImageIO.write(img, "jpg", file);
    }
}

