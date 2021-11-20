package negative;

import resources.ParserSettings;

public class NegativeSettings extends ParserSettings
{
    public NegativeSettings(int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://nanegative.ru/internet-magaziny";
        PREFIX = "page={CurrentId}";
    }
}

