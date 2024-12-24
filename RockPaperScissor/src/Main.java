import java.util.Scanner;
import java.util.Random;

class RockPaperScissor{
    private static final Random random = new Random();
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        int j = 1;
        do {
            // User Input
            System.out.println("0.Rock  1.Paper  2.Scissor");
            int x = sc.nextInt();

            //Valid user input
            if (!isValid(x)) {
                System.out.println("Invalid Choice");
                return;
            }
            // computer choice
            int y = random.nextInt(3);
            if(results(x,y)) continue; // if both choose same

            System.out.println("If you want to play again press 1 else press any other key");
            try {
                j= sc.nextInt();
            }catch (Exception e){
                break;
            }
        }while (j==1);
        System.out.println("Thanks for playing! Have a nice day");
    }

    private boolean results(int x, int y){
        if (x == y) {
            System.out.print("You = "+value(x));
            System.out.println(", Computer = "+value(y));
            System.out.println("Both are you chosen same object .So Try once again");
            return true;
        }
        else {
            System.out.print("You = "+value(x));
            System.out.println(", Computer = " + value(y));
            if ((x == 0 && y == 2) || (x == 1 && y == 0) || (x == 2 && y == 1)) {
                System.out.println("You won the game");
            }
            else {
                System.out.println("Computer won the game");
            }
            return false;
        }

    }
    private String value(int n){
        if (n == 0) return  "Rock";
        else if (n == 1) return  "Paper";
        else return  "Scissor";
    }
    private boolean isValid(int n){
        return n == 0 || n == 1 || n == 2;
    }
}
public class Main {
    public static void main(String[] args) {
        RockPaperScissor rps = new RockPaperScissor();
        rps.startGame();
    }
}
