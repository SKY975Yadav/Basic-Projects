import jdk.jfr.Label;

import java.util.Random;
import java.util.Scanner;
class GuessTheNumber{
    int OGNumber;
    int inputNumber;

    public GuessTheNumber(){
        Random rm = new Random();
        OGNumber = rm.nextInt(100);
    }

    public void isCorrectNumber(){
        int chances = 10, attempts =1;
        boolean win = false;
        
        while (chances>0){
            if (chances==1) System.out.println("Last chance");
            inputNumber = takeUserInput();

            if (isValid(inputNumber)) {System.out.println("Invalid number make sure the number is between 0 to 100");continue;}

            if (inputNumber==OGNumber){win = true;break;}
            else if (inputNumber<OGNumber)
                System.out.println("Your guess is wrong , enter greater number");
            else
                System.out.println("Yor guess is wrong , enter lesser number");

            chances--;
            attempts++;
        }
        resultMessage(win,attempts);
    }

    public int takeUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number: ");
        return sc.nextInt();
    }

    private String Ranking(int attempts){
        if (attempts==1 || attempts==2) return "Grade - A";
        else if (attempts==3 ||attempts==4 || attempts==5) return "Grade - B";
        else if (attempts==6||attempts==7||attempts==8) return "Grade - C";
        else return "Grade - D";
    }

    private boolean isValid(int inputNumber){
        return inputNumber > 100 || inputNumber <= 0;
    }

    private void resultMessage(boolean win,int attempts){
        if (win){
            System.out.println("Congratulation , Your guess is correct ");
            System.out.println("You guessed the number in " + attempts + " attempts");
            System.out.println(Ranking(attempts));
        }
        else {
            System.out.println("You loss the game the correct number is : "+OGNumber+" , better luck next time");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        GuessTheNumber gs = new GuessTheNumber();
        System.out.println("---------------------------WELCOME TO GUESS THE NUMBER GAME---------------------------- ");
        System.out.println("Instructions :");
        System.out.println("Enter number only from 1 to 100 \nYou have only 10 choices\nYou will get a grade from A to D based on your performance\n");
        gs.isCorrectNumber();
        System.out.println("End of the game");

    }
}