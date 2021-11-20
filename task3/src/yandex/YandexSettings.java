package yandex;

import resources.ParserSettings;

public class YandexSettings extends ParserSettings
{
    public YandexSettings(int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://yandex.ru/images/search?text=cat";
        PREFIX = "p={CurrentId}";
    }
}

