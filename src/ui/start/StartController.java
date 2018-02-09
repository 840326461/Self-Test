package ui.start;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import logic.Logic;
import ui.Util;

public class StartController {
    private Tab father;

    public void init(Tab tab){
        father=tab;
    }

    @FXML
    public void onStart(){
        Util tool=new Util();
        Logic.getInstance().reset();
        father.setContent(tool.getOrderPane());
    }

    @FXML
    public void onContinue(){
        Util tool=new Util();
        father.setContent(tool.getOrderPane());
    }
}
