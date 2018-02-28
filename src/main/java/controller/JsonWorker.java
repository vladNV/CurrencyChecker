package controller;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import view.View;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonWorker {
    public JsonElement getJson(String path) {
        try {
            JsonReader reader = new JsonReader(
                    new BufferedReader(
                            new FileReader(
                                    new File(path))));
            return new JsonParser().parse(reader);
        } catch (FileNotFoundException e) {
            System.out.println(new File(path).getAbsolutePath());
            throw new RuntimeException(View.FILE_NO_EXISTS, e);
        }
    }

    public JsonElement getJson(URL url) {
        try {
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            connect.getInputStream()
                    ))){
                return new JsonParser().parse(reader);
            } catch (JsonIOException e) {
                throw new RuntimeException(View.JSON_IO_EXP, e);
            }
        } catch (IOException e) {
            throw new RuntimeException(View.GET_REQUEST_ERR, e);
        }
    }

    public <T> T collectJson(JsonElement e, Type clazz) {
        return new Gson().fromJson(e, clazz);
    }
}
