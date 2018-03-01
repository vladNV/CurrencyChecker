package controller;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import view.View;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;


public class JsonWorker {
    public JsonElement getJson(String path) {
        try {
            try {
                JsonReader reader = new JsonReader(
                        new BufferedReader(
                                new FileReader(
                                        new File(path))));
                return new JsonParser().parse(reader);
            } catch (JsonIOException e) {
                throw new RuntimeException(View.JSON_IO_EXP, e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(View.FILE_NO_EXISTS, e);
        }
    }

    public JsonElement getJson(URL url) {
        try (RequestWorker req = new RequestWorker();
            BufferedReader read = req.get(url)) {
            return new JsonParser().parse(read);
        } catch (IOException e) {
            throw new RuntimeException(View.CONNECTION_ERROR, e);
        }
    }

    public <T> T collectJson(JsonElement e, Type clazz) {
        return new Gson().fromJson(e, clazz);
    }
}
