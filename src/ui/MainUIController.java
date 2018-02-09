package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import ui.lookup.LookUpController;
import ui.start.RandomStartController;
import ui.start.StartController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable{
    @FXML private Tab orderTab=new Tab();
    @FXML private Tab randomTab=new Tab();
    @FXML private Tab lookUpTab=new Tab();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderTab.setContent(getStartPane(orderTab));
        randomTab.setContent(getRandomStartPane(randomTab));
        lookUpTab.setContent(getLookUpPane());
    }

    private AnchorPane getStartPane(Tab tab) {
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(StartController.class.getResource("Start.fxml"));
        try {
            pane = (AnchorPane) loader.load();
            StartController controller=loader.getController();
            controller.init(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }

    private AnchorPane getRandomStartPane(Tab tab) {
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(RandomStartController.class.getResource("RandomStart.fxml"));
        try {
            pane = (AnchorPane) loader.load();
            RandomStartController controller=loader.getController();
            controller.init(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }

    private AnchorPane getLookUpPane(){
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LookUpController.class.getResource("LookUp.fxml"));
        try {
            pane = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pane;
    }
}
