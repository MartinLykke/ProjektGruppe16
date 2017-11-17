/**
 *
 * @author emrearikan
 */
public class SaveandLoad {
    
    int[] saveInfo = {Game.Hp, Game.Inventory, 
                    Game.HighScore, Game.Location };
    
    
                    Game.Hp = saveInfo[0];
                    Game.Inventory = saveInfo[1];
                    Game.HighScore = saveInfo[2];
                    Game.Location = saveInfo[3];
   
                    
 public Save() {
                readPlayer("saveFile.txt");
                savePlayer("saveFile.txt");   
                
                
       private void readPlayer(String filePath) {
                 File inputFile;
                BufferedReader inputReader; 
                    
}
