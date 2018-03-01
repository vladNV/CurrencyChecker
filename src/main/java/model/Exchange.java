package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("exchange")
public class Exchange {
    @XStreamImplicit(itemFieldName = "currency")
    private List<Currency> currencies = new ArrayList<>();

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
