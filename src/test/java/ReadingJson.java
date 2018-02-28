import com.google.gson.reflect.TypeToken;
import controller.JsonWorker;
import model.Currency;
import model.Document;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class ReadingJson {
    private final static String nationalBank =
            "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    public static void main(String[] args) throws MalformedURLException {
        JsonWorker jsonWorker = new JsonWorker();
        List<Currency> c = jsonWorker.collectJson(jsonWorker.getJson(new URL(nationalBank)),
                new TypeToken<List<Currency>>(){}.getType());
        Document document = new Document();
        document.setRate(c);
        document.getCurrencies("USD", "RUB", "EUR").forEach(System.out::println);
    }
}
