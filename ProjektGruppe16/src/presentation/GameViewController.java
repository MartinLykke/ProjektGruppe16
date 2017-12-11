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
import javafx.scene.control.ProgressBar;
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
    private Label health;
    @FXML
    private ProgressBar healthBar;
    
    @FXML
    private void useButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Ingen ting");   
    }
    
     @FXML    
    private void launchGame(ActionEvent event){
        game = new Game();
        game.play();
        label.setText(game.getText());
        //health.setText(game.getHealth());
    }  
    
    @FXML
    private void saveGame(ActionEvent event){
        game.save();
    }
    
    @FXML
    private void loadGame(ActionEvent event){
        game.load();
        label.setText(game.getText());
        //health.setText(game.getHealth());
    }
    
    @FXML
    private void goWest(ActionEvent event){
        game.goRoom("west");
        label.setText(game.getText());
    }
    
    @FXML
    private void goNorth(ActionEvent event){
        game.goRoom("north");
        label.setText(game.getText());
    }
    
    @FXML
    private void goEast(ActionEvent event){
        game.goRoom("east");
        label.setText(game.getText());
    }
    
    @FXML
    private void goSouth(ActionEvent event){
        game.goRoom("south");
        label.setText(game.getText());
    }
    
    @FXML
    private void attack(ActionEvent event){
        game.attack();
        label.setText(game.getText());
        health.setText(game.getHealth());
        //healthBar.setProgress(game.getHealth()*0.1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setText("");
        health.setText("");
    }    
    
}
