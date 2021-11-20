package leroymerlen;

import resources.ParserSettings;

public class LeroySettings extends ParserSettings
{
    public LeroySettings(int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://leroymerlin.ru/catalogue/vygodnaya-pokupka/";
        PREFIX = "page={CurrentId}";
    }
}

