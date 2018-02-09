package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import ui.order.OrderController;
import ui.random.RandomController;

import java.io.IOException;

public class Util {
    public AnchorPane getOrderPane(){
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(OrderController.class.getResource("Order.fxml"));
        try {
            pane = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }

    public AnchorPane getRandomPane(){
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RandomController.class.getResource("Random.fxml"));
        try {
            pane = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }
}
