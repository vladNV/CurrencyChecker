package model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class Document presents the official exchange rate of the hryvnia
 * against foreign currencies and banking metals.
 */
public class Document {
    private List<Currency> rate;

    public List<Currency> getRate() {
        return rate;
    }

    public void setRate(List<Currency> rate) {
        this.rate = rate;
    }

    public List<Currency> getCurrencies(String ... cc) {
        StringBuilder sbRegexp = new StringBuilder();
        for (String c : cc) { sbRegexp.append(c).append("|"); }
        String regexp = sbRegexp.substring(0, sbRegexp.length() - 1);
        return this.rate.stream().filter(currency -> currency.getCc()
                .matches(regexp)).collect(Collectors.toList());
    }
}
