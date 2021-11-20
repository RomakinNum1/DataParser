package yandex;

import interfaces.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class YandexParser implements Parser<ArrayList<String>> {
    public ArrayList<Article> Parse(Document document) throws IOException {
        ArrayList<Article> list = new ArrayList<>();
        for (Element el : document.getElementsByClass("serp-item")) {

            int origin = el.attr("data-bem").indexOf("origin");
            int url1 = el.attr("data-bem").indexOf("url", origin) + 6;
            int url2 = el.attr("data-bem").indexOf("\"", url1);

            String pathImage = el.attr("data-bem").substring(url1, url2);
            list.add(new Article(
                    pathImage
            ));
        }
        return list;
    }
}

