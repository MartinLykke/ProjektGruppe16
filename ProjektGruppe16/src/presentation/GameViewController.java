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
    private ImageView beach;
    @FXML
    private ImageView jungle;
    @FXML
    private ImageView jungle2;
    @FXML
    private ImageView cave;
    @FXML
    private Label label;
    @FXML
    private Label health;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button south;
    @FXML
    private Button west;
    @FXML
    private Button save;
    @FXML
    private Button load;
    @FXML
    private Button attack;
    @FXML
    private Button use;
    @FXML
    private Button talk;
    @FXML
    private Button drop;
    @FXML
    private Button pickup;
    
    
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
        
        north.setVisible(true);
        east.setVisible(true);
        south.setVisible(true);
        west.setVisible(true);
        save.setVisible(true);
        load.setVisible(true);
        attack.setVisible(true);
        use.setVisible(true);
        drop.setVisible(true);
        pickup.setVisible(true);
        talk.setVisible(true);
        
        checkRoom();
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
        checkRoom();
        //health.setText(game.getHealth());
    }
    
    @FXML
    private void goWest(ActionEvent event){
        game.goRoom("west");
        checkRoom();
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goNorth(ActionEvent event){
        game.goRoom("north");
        checkRoom();
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goEast(ActionEvent event){
        game.goRoom("east");
        checkRoom();
        game.getTime();
        label.setText(game.getText());
    }
    
    @FXML
    private void goSouth(ActionEvent event){
        game.goRoom("south");
        checkRoom();
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
        
        north.setVisible(false);
        east.setVisible(false);
        south.setVisible(false);
        west.setVisible(false);
        save.setVisible(false);
        load.setVisible(false);
        attack.setVisible(false);
        use.setVisible(false);
        drop.setVisible(false);
        pickup.setVisible(false);
        talk.setVisible(false);
        beach.setVisible(false);
        jungle.setVisible(false);
        jungle2.setVisible(false);
        cave.setVisible(false);
        
        //image.setImage( new Image(getClass().getResource("../assets/Beach.jpg").toExternalForm()) );
    }    
    
    private void checkRoom(){
        switch(game.getLocation()){
            case "beach": 
                beach.setVisible(true);
                jungle.setVisible(false);
                jungle2.setVisible(false);
                cave.setVisible(false);
                break;
            case "jungle":
                beach.setVisible(false);
                jungle.setVisible(true);
                jungle2.setVisible(false);
                cave.setVisible(false);
                break;
            case "jungle2":
                beach.setVisible(false);
                jungle.setVisible(false);
                jungle2.setVisible(true);
                cave.setVisible(false);
                break;
            case "cave":
                beach.setVisible(false);
                jungle.setVisible(false);
                jungle2.setVisible(false);
                cave.setVisible(true);
                break;
            default:
                beach.setVisible(true);
                jungle.setVisible(false);
                jungle2.setVisible(false);
                cave.setVisible(false);
                break;
        }
    }
    
}
