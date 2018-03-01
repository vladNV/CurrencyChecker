package controller;

import com.thoughtworks.xstream.XStream;
import model.Exchange;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class XmlWorker {
    public Exchange getXml(URL url) {
        try (RequestWorker req = new RequestWorker();
             BufferedReader reader = req.get(url)){
            XStream stream = new XStream();
            stream.processAnnotations(Exchange.class);
            return (Exchange) stream.fromXML(reader);
        } catch (IOException e) {
            throw new RuntimeException(View.CONNECTION_ERROR, e);
        }
    }
}
