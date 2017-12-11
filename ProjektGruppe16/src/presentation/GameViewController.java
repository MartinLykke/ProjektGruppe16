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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Game;

/**
 *
 * @author marti
 */
public class GameViewController implements Initializable {
    
    private Game game;
    
    @FXML
    private ImageView image;
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
        health.setText(game.getHealth());
    }  
    
    @FXML
    private void saveGame(ActionEvent event){
        game.save();
    }
    
    @FXML
    private void loadGame(ActionEvent event){
        game.load();
        label.setText(game.getText());
        health.setText(game.getHealth());
        //health.setText(game.getHealth());
    }
    
    @FXML
    private void goWest(ActionEvent event){
        game.goRoom("west");
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goNorth(ActionEvent event){
        game.goRoom("north");
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goEast(ActionEvent event){
        game.goRoom("east");
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goSouth(ActionEvent event){
        game.goRoom("south");
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void attack(ActionEvent event){
        game.attack();
        game.getTime();
        label.setText(game.getText());
        health.setText(game.getHealth());
        //healthBar.setProgress(game.getHealth()*0.1);
    }
    
     @FXML
    private void Pickup(ActionEvent event){
    
        
    }
    
    
      @FXML
    private void Use (ActionEvent event){
    
    }
    
      @FXML
    private void Drop (ActionEvent event){
    
    }
    
      @FXML
    private void Template (ActionEvent event){
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setText("");
        health.setText("");
        healthBar.setVisible(false);
        //image.setImage( new Image(getClass().getResource("../assets/Beach.jpg").toExternalForm()) );
    }    
    
}
