package view;

public class View {
    // JsonWorker
    public static final String FILE_NO_EXISTS = "File doesn't exist";
    public static final String JSON_IO_EXP = "JSON I/O exception";
    public static final String GET_REQUEST_ERR = "Get request error!";
    public static final String CONNECTION_EXP = "Server isn't responding, 503 ERROR";

    // Controller
    public static final String STARTING = "App starting";
    public static final String NOW = "Today is ";

    public void msg(String s) {
        System.out.println(s);
    }

}
