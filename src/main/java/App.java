import controller.Controller;
import controller.JsonWorker;
import controller.RequestWorker;
import controller.XmlWorker;
import model.Document;
import view.View;

import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) {
        Controller controller = new Controller(new Document(), new View());
        controller.currencyState(new XmlWorker());
//        controller.currencyState(new JsonWorker());
    }
}
