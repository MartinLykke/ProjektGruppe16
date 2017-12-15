package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Game;
import logic.GameInterface;

/**
 *
 * @author marti
 */
public class GameViewController implements Initializable {

    private GameInterface game;
    protected ListProperty<String> inventoryList = new SimpleListProperty<>();
        
    @FXML
    private ImageView friend;
    @FXML
    private ImageView enemy;
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
    private Label inventoryLabel;
    @FXML
    private ListView inventoryListView;
   
    
    
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
        
        // Sets the GUI back to visible when the game is launched.
        north.setVisible(true);
        east.setVisible(true);
        south.setVisible(true);
        west.setVisible(true);
        save.setVisible(true);
        load.setVisible(true);
        attack.setVisible(false);
        use.setVisible(true);
        drop.setVisible(true);
        pickup.setVisible(true);
        talk.setVisible(false);
        inventoryLabel.setVisible(true);
        inventoryListView.setVisible(true);
        updateInventoryList();
        checkEnemy();
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
        checkEnemy();
        updateInventoryList();
        //health.setText(game.getHealth());
    }
    
    @FXML
    private void goWest(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.goRoom("west");
        checkRoom();
        checkEnemy();
        updateInventoryList();
        label.setText(game.getText());
        checkIfButtonsAreNeeded();
    }
    
    @FXML
    private void goNorth(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.goRoom("north");
        checkRoom();
        checkEnemy();
        updateInventoryList();
        label.setText(game.getText());
        checkIfButtonsAreNeeded();
    }
    
    @FXML
    private void goEast(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.goRoom("east");
        checkRoom();
        checkEnemy();
        updateInventoryList();
        label.setText(game.getText());
        checkIfButtonsAreNeeded();
    }
    
    @FXML
    private void goSouth(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.goRoom("south");
        checkRoom();
        checkEnemy();
        updateInventoryList();
        label.setText(game.getText());
        checkIfButtonsAreNeeded();
    }
    
    @FXML
    private void attack(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.attack();
        checkEnemy();
        updateInventoryList();
        label.setText(game.getText());
        health.setText(game.getHealth());
        //healthBar.setProgress(game.getHealth()*0.1);
    }
    
    @FXML
    private void pickup(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.pickup();
        updateInventoryList();
        label.setText(game.getText());
    }
    
    
    @FXML
    private void use (ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.getItems();
        //game.use();
        updateInventoryList();
        label.setText(game.getText());
    }
    
    @FXML
    private void drop (ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.drop();
        updateInventoryList();
        label.setText(game.getText());
    }
    
    @FXML
    private void talk (ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.talk();
        updateInventoryList();
        label.setText(game.getText());
    }
    
    @FXML
    private void eat(ActionEvent event){
        if(game.getLoseCondition()){
            label.setText(game.getText());
            return;
        }
        game.eat();
        updateInventoryList();
        label.setText(game.getText());
        health.setText(game.getHealth());
    }
    @FXML
    private void template (ActionEvent event){
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        label.setText("");
        health.setText("");
        healthBar.setVisible(false);
       
        // Most of the GUI is set to be invisible. This is to force the user to press the start button, so that the game launches.
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
        enemy.setVisible(false);
        friend.setVisible(false);
        inventoryLabel.setVisible(false);
        inventoryListView.setVisible(false);
        
        inventoryListView.itemsProperty().bind(inventoryList);
        
        //image.setImage( new Image(getClass().getResource("../assets/Beach.jpg").toExternalForm()) );
    }    
    // Checks which room the player is in. This method is used to change the image in the GUI.
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
   
    private void checkEnemy(){       // FLET METODE MED CHECKIFBUTTONSARENEEDED
        if(game.getEnemyStatus()){
            enemy.setVisible(true);
        } else {
            enemy.setVisible(false);
        }
    }
    
     private void checkFriend(){     // Not used
        if(game.getFriendStatus()){
            enemy.setVisible(true);
        } else {
            enemy.setVisible(false);
        }
    }
     // Disables buttons if they have no use, to make GUI less messy
     private void checkIfButtonsAreNeeded(){
         if(game.getFriendStatus()){
            talk.setVisible(true);
            friend.setVisible(true);
        } else {
            talk.setVisible(false);
            friend.setVisible(false);
        }
        if(game.getEnemyStatus()){
            attack.setVisible(true);
        } else {
            attack.setVisible(false);
        }
     }
     
     private void updateInventoryList(){
         inventoryList.set(FXCollections.observableArrayList(game.getItems()));
     }
}
