/**
 *
 * @author emrearikan
 */
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
   
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
                
 }
       private void readPlayer(String filePath) {
                 File inputFile;
                BufferedReader inputReader; 
                    
                
                try            {
                inputFile = new file(filePath);
                intput Reader = new BufferedReader(new FileReader(inputFile));
                
                    Game.Hp = saveInfo[0];
                    Game.Inventory = saveInfo[1];
                    Game.HighScore = saveInfo[2];
                    Game.Location = saveInfo[3];
                    
        for (int i = 0; i< saveInfo.length; i++) {
            SaveInfo[i] = Integer.parseInt(inputReader.readLine());
                    }
        inputReader.close():
        } catch (Exception e) {
                        e.printStackTrace();
                }
 
           private void savePlayer(String filePath) {
                File outputFile;
                BufferedWriter outputWriter;
               
                try {
                        outputFile = new File(filePath);
                       
                        outputWriter = new BufferedWriter(new FileWriter(outputFile));
                       
                    Game.Hp = saveInfo[0];
                    Game.Inventory = saveInfo[1];
                    Game.HighScore = saveInfo[2];
                    Game.Location = saveInfo[3];
                    
                        for(int i = 0; i < saveInfo.length; i++){
                                outputWriter.write(Integer.toString(saveInfo[i]) + "\n");
                        }
                        outputWriter.close();
                       
                } catch (IOException e) {
                }
        }
}