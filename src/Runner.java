import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import logic.Logic;
import ui.MainUIController;
import ui.order.OrderController;

import java.io.IOException;
import java.util.Optional;

public class Runner extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainUIController.class.getResource("MainUI.fxml"));
        try {
            pane = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setScene(new Scene(pane));

        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("是否保存当前测试进度");
                Optional<ButtonType> options=alert.showAndWait();
                if(options.get()==ButtonType.OK)
                    Logic.getInstance().saveIndex();
            }
        });

        window.show();
    }
}
