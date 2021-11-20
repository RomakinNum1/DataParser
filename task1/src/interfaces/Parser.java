package interfaces;

import negative.Article;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public interface Parser<T> {
    ArrayList<Article> Parse(Document document) throws IOException;
}