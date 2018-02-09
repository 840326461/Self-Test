package ui.lookup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import logic.Logic;

import java.net.URL;
import java.util.ResourceBundle;

public class LookUpController implements Initializable{
    @FXML private JFXTextField textField;
    @FXML private JFXButton lookUp;
    @FXML private TextArea textArea;
    @FXML private Button clear;

    private Logic logic;

    @FXML
    public void onLookUp(){
        String word=textField.getText();
        if(word.trim().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("输入为空");
            alert.showAndWait();
            return;
        }
        if(word.contains(" ")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("输入包含空格");
            alert.showAndWait();
            return;
        }
        String result=logic.find(word);
        textArea.setText(result);
    }

    @FXML
    public void onClear(){
        textArea.clear();
        textField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logic=Logic.getInstance();
    }
}
