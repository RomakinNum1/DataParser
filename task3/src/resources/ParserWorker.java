package resources;

import interfaces.OnCompleted;
import interfaces.OnNewDataHandler;
import interfaces.Parser;
import yandex.Article;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ParserWorker<T>
{
    Parser<T> parser;
    ParserSettings parserSettings;
    HtmlLoader loader;
    boolean isActive;
    public ArrayList<OnNewDataHandler> onNewDataList = new ArrayList<>();
    public ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public Parser<T> getParser()
    {
        return parser;
    }

    public ParserSettings getParserSettings()
    {
        return parserSettings;
    }

    public void setParser(Parser<T> parser)
    {
        this.parser = parser;
    }

    public void setParserSettings(ParserSettings parserSettings)
    {
        this.parserSettings = parserSettings;
        loader = new HtmlLoader(parserSettings);
    }

    public void Start() throws IOException
    {
        isActive = true;
        Worker();
    }

    public void Abort() {
        isActive = false;
    }

    private void Worker() throws IOException {
        for (int i = parserSettings.getStartPoint(); i <= parserSettings.getEndPoint(); i++) {
            if (!isActive) {
                onCompletedList.get(0).OnCompleted(this);
                return;
            }
            Document document = loader.GetSourceByPageId(i);
            ArrayList<Article> result = parser.Parse(document);
            onNewDataList.get(0).OnNewData(this,result);
        }
        onCompletedList.get(0).OnCompleted(this);
        isActive = false;
    }
}
