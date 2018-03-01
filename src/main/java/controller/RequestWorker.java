package controller;

import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestWorker implements AutoCloseable {

    private HttpURLConnection connect;

    public final BufferedReader get(URL url) {
       try {
           connect = (HttpURLConnection) url.openConnection();
           connect.setRequestMethod("GET");
           return new BufferedReader(
               new InputStreamReader(
                       connect.getInputStream()));
       } catch (IOException e) {
           throw new RuntimeException(View.GET_REQUEST_ERR, e);
       }
    }

    @Override
    public void close() {
        try {
            connect.disconnect();
            connect = null;
        } catch (Exception e) {
            throw new RuntimeException(View.DISCONNECT_ERROR, e);
        }
    }
}
