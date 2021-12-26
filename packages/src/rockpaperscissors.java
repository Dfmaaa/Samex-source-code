import java.util.Scanner;
import java.util.Random;
public class rockpaperscissors{
    static int gen(){
        Random r = new Random();
        int n = r.nextInt(3);
        return n;
    }
    public static void rockpaper(){
     
    }
    public static void meth(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Rock, Paper, Scissors!");
        while(true){
        System.out.println("Enter your choice: ");
        String choice = input.nextLine().toLowerCase();
        int n = gen();  //generates random number
        if(choice.equals("rock")){
            if(n == 0){
                System.out.println("You chose rock, computer chose rock, it's a tie!");
            }
            else if(n == 1){
                System.out.println("You chose rock, computer chose paper, you lose!");
            }
            else{
                System.out.println("You chose rock, computer chose scissors, you win!");
            }
        }
        else if(choice.equals("paper")){
            if(n == 0){
                System.out.println("You chose paper, computer chose rock, you win!");
            }
            else if(n == 1){
                System.out.println("You chose paper, computer chose paper, it's a tie!");
            }
            else{
                System.out.println("You chose paper, computer chose scissors, you lose!");
            }
        }
        else if(choice.equals("scissors")){
            if(n == 0){
                System.out.println("You chose scissors, computer chose rock, you lose!");
            }
            else if(n == 1){
                System.out.println("You chose scissors, computer chose paper, you win!");
            }
            else{
                System.out.println("You chose scissors, computer chose scissors, it's a tie!");
            }
        }
        else{
            System.out.println("Invalid input, try again!");
        }
    }
    }
    public static void main(String[] args){
        meth();
    }
}