package data;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for keeping a highscore
 * @author Kasper
 */
public class Highscore {

    private int totalScore = 0;
    private ArrayList<String> text;
    
    /**
     * Adds 100 points to the total score
     */
    public void addPointsToScore(){
        totalScore = totalScore + 100;
    }
    
    /**
     * Returns the current total score
     * @return totalScore which is an int representing the total score of the current game
     */
    public int getScore(){
        return totalScore;
    }
    
    /**
     * Opens a file containing the highscore and then updates the file with the new score and saves the highscore in an ArrayList of strings for use in the GUI
     * @throws IOException 
     */
    public void highscore() throws IOException {
        text = new ArrayList<>();
        java.io.File file = new java.io.File("Highscore.txt");
        Scanner input = new Scanner(file);
        int[][] myList = new int[10][2];
        for (int i = 0; i < myList.length; i++) {
            myList[i][0] = input.nextInt();
            myList[i][1] = input.nextInt();
        }
        
        int newScore = getScore();

        for (int i = 0; i < myList.length; i++) {
            if (newScore > myList[i][1]) {
                for (int j = myList.length - 1; j > i; j--) {
                    myList[j][1] = myList[j - 1][1];
                }
                myList[i][1] = newScore;
                break;
            }
        }

        text.add("New highscore:");
        for (int i = 0; i < myList.length; i++) {
            text.add(myList[i][0] + "\t" + myList[i][1]);
        }

        java.io.PrintWriter output = new java.io.PrintWriter(file);

        for (int i = 0; i < myList.length; i++) {
            output.println(myList[i][0] + "\t" + myList[i][1]);
        }
        output.close();
    }
    
    /**
     * Method for returning the ArrayList of strings containing the highscore
     * @return ArrayList of Strings
     */
    public ArrayList<String> getList(){
        return text;
    }
}