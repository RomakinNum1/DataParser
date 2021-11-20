import negative.NegativeParser;
import negative.NegativeSettings;
import resources.NewData;
import resources.ParserWorker;
import resources.Completed;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int start = 2, end = 2;
        NegativeParser habr = new NegativeParser();
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>();
        parser.setParser(habr);

        parser.setParserSettings(new NegativeSettings(start, end));
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());

        parser.Start();

        parser.Abort();
    }
}
