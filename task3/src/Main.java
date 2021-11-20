import yandex.YandexParser;
import yandex.YandexSettings;
import resources.NewData;
import resources.ParserWorker;
import resources.Completed;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int start = 1, end = 2;
        YandexParser habr = new YandexParser();
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>();
        parser.setParser(habr);

        parser.setParserSettings(new YandexSettings(start, end));
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());

        parser.Start();

        parser.Abort();
    }
}
