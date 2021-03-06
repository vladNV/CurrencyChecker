package controller;

import com.google.gson.reflect.TypeToken;
import model.Currency;
import model.Document;
import view.View;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

public class Controller {
    private Document document;
    private View view;

    public Controller(Document document, View view) {
        this.document = document;
        this.view = view;
    }

    public void currencyState(final JsonWorker worker) {
        view.msg(View.JSON);
        view.msg(View.STARTING);
        view.msg(View.NOW + LocalDateTime.now());
        try {
            document.setRate(worker.collectJson(worker.getJson(new URL(URLs.nationalBankJSON)),
                    new TypeToken<List<Currency>>(){}.getType()));
            document.getCurrencies("USD", "RUB", "EUR").forEach(System.out::println);
        } catch (MalformedURLException e) {
            throw new RuntimeException(View.CONNECTION_EXP, e);
        }
    }

    public void currencyState(XmlWorker worker) {
        view.msg(View.XML);
        view.msg(View.STARTING);
        view.msg(View.NOW + LocalDateTime.now());
        try {
            document.setRate(worker.getXml(new URL(URLs.nationalBankXML)).getCurrencies());
            document.getCurrencies("USD", "RUB", "EUR").forEach(System.out::println);
        } catch (MalformedURLException e) {
            throw new RuntimeException(View.CONNECTION_EXP, e);
        }
    }
}
