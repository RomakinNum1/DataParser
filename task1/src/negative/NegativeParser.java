package negative;

import interfaces.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class NegativeParser implements Parser<ArrayList<String>>
{
    public ArrayList<Article> Parse(Document document) throws IOException {

        ArrayList<Article> list = new ArrayList<>();
        for (Element el: document.getElementsByClass("find-list-box"))
        {
            String href = el.getElementsByClass("ss").attr("href");

            Document doc = Jsoup.connect("https://nanegative.ru" + href).get();

            for (Element element: doc.getElementsByClass("reviewers-box"))
            {
                list.add(new Article(
                        element.getElementsByTag("tbody").get(0).getElementsByTag("tr").get(0).text(),
                        element.getElementsByTag("tbody").get(0).getElementsByTag("tr").get(1).text(),
                        element.getElementsByTag("tbody").get(0).getElementsByTag("tr").get(2).text(),
                        element.getElementsByAttributeValue("itemprop", "author").text(),
                        element.getElementsByAttributeValue("itemprop", "name").attr("content")
                ));
            }
        }
        return list;
    }
}

