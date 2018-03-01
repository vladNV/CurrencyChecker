package model;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("currency")
public class Currency {
    @XStreamAlias("r030")
    private int r030;
    @XStreamAlias("txt")
    private String txt;
    @XStreamAlias("rate")
    private double rate;
    @XStreamAlias("cc")
    private String cc;
    @XStreamAlias("exchangedate")
    private String exchangedate;

    public Currency setR030(int r030) {
        this.r030 = r030;
        return this;
    }

    public Currency setTxt(String txt) {
        this.txt = txt;
        return this;
    }

    public Currency setRate(double rate) {
        this.rate = rate;
        return this;
    }

    public Currency setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public Currency setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
        return this;
    }

    public int getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public double getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    @Override
    public String toString() {

        return "r030: " + r030 + ", txt: " + txt + ", rate: " + rate
                + ", cc: " + cc + ", exchangedate: " + exchangedate;
    }
}
