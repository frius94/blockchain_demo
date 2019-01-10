package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import static sample.Main.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private JFXButton genesisButton;
    @FXML
    private JFXButton blockButton;
    @FXML
    private JFXTextArea genesisTextArea;
    @FXML
    private JFXTextArea blockTextArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        blockButton.setDisable(true);
        blockTextArea.setDisable(true);
    }

    public void createGenesisBlock() {
        if (!genesisTextArea.getText().equals("")) {
            String genesisTransaction = genesisTextArea.getText();

            blockchain.add(new Block(0, genesisTransaction));
            blockchain.get(0).drawBlock(canvas);
            genesisTextArea.clear();
            genesisTextArea.setDisable(true);
            genesisButton.setDisable(true);
            blockTextArea.setDisable(false);
            blockButton.setDisable(false);
        }
    }

    public void createBlock() {
        if (!blockTextArea.getText().equals("")) {
            String blockTransaction = blockTextArea.getText();

            blockchain.add(new Block(blockchain.get(blockchain.size() - 1).getBlockHash(), blockTransaction));
            blockchain.get(blockchain.size()-1).drawBlock(canvas);
            blockTextArea.clear();
        }
    }

}
