
import java.util.Scanner;
import java.io.IOException;
public class Highscore {
    public static void main(String[] args) throws IOException {

        java.io.File file = new java.io.File("Highscore.txt");
        Scanner input = new Scanner(file);
        int[][] myList = new int[10][2];
        for (int i = 0; i < myList.length; i++) {
            myList[i][0] = input.nextInt();
            myList[i][1] = input.nextInt();
        }

        System.out.println("Current highscore:");

        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i][0] + "\t" + myList[i][1]);
        }

        Scanner input2 = new Scanner(System.in);
            System.out.print("Enter your score: ");
            int newScore = input2.nextInt();

        for (int i = 0; i < myList.length; i++) {
            if (newScore > myList[i][1]) {
                for (int j = myList.length - 1; j > i; j--) {
                    myList[j][1] = myList[j - 1][1];
                }
                myList[i][1] = newScore;
                break;
            }
        }

        System.out.println("New highscore:");
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i][0] + "\t" + myList[i][1]);
        }

        java.io.PrintWriter output = new java.io.PrintWriter(file);

        for (int i = 0; i < myList.length; i++) {
            output.println(myList[i][0] + "\t" + myList[i][1]);
        }
        output.close();
    }
}