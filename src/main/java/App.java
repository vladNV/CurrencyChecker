import controller.Controller;
import model.Document;
import view.View;

public class App {

    public static void main(String[] args) {
        Controller controller = new Controller(new Document(), new View());
        controller.currencyState();
    }
}
