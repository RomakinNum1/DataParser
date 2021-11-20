package leroymerlen;

import interfaces.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class LeroyParser implements Parser<ArrayList<String>>
{
    public ArrayList<Article> Parse(Document document) throws IOException {

        ArrayList<Article> list = new ArrayList<>();
        for (Element el: document.getElementsByClass("phytpj4_plp largeCard"))
        {
            String href = el.getElementsByClass("bex6mjh_plp b1f5t594_plp p5y548z_plp pblwt5z_plp nf842wf_plp").attr("href");
            String product = el.getElementsByClass("t9jup0e_plp p1h8lbu4_plp").text();

            Document doc = Jsoup.connect("https://leroymerlin.ru" + href).get();

            for (Element element: doc.getElementsByAttributeValue("itemprop", "review"))
            {
                try {
                    list.add(new Article(
                            element.getElementsByTag("uc-prp-term-group").get(0).text(),
                            element.getElementsByTag("uc-prp-term-group").get(1).text(),
                            element.getElementsByAttributeValue("itemprop", "description").text(),
                            element.getElementsByAttributeValue("itemprop", "name").text(),
                            product
                    ));
                }
                catch(Exception ignored){}
            }
        }
        return list;
    }
}

