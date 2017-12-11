package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import logic.Game;

/**
 *
 * @author marti
 */
public class GameViewController implements Initializable {
    
    private Game game;
    
    @FXML
    private ImageView west;
    @FXML
    private Button use;
    @FXML
    private Label label;
    
    @FXML
    private void useButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Ingen ting");   
    }
    
     @FXML    
    private void launchGame(ActionEvent event){
        game = new Game();
        game.play();
        label.setText(game.printWelcome());
    }  
    
    @FXML
    private void loadGame(ActionEvent event){
        game.load();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
