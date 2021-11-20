import leroymerlen.LeroyParser;
import leroymerlen.LeroySettings;
import resources.NewData;
import resources.ParserWorker;
import resources.Completed;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int start = 1, end = 2;
        LeroyParser habr = new LeroyParser();
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>();
        parser.setParser(habr);

        parser.setParserSettings(new LeroySettings(start, end));
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());

        parser.Start();

        parser.Abort();
    }
}
