package ui.start;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import logic.Logic;
import ui.Util;

public class RandomStartController {
    private Tab father;

    public void init(Tab tab){
        father=tab;
    }

    @FXML
    public void onStart(){
        Util tool=new Util();
        father.setContent(tool.getRandomPane());
    }
}
