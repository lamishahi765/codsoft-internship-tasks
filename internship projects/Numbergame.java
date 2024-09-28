import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chances = 4;
        int finals = 0;
        boolean playAgain = true;
        System.out.println("Welcome to Game!..");
        System.out.println(" You have only" + chances + "to win !!");
        while (playAgain) {
            int rand = getrandN(1, 100);

            boolean guess = false;
            for (int i = 0; i < chances; i++) {
                System.out.println("chances : " + (i + 1) + "Enter your number :");
                int user = sc.nextInt();
                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("you won.");
                    break;
                } else if (user > rand) {
                    System.out.println("Too high..");
                } else {
                    System.out.println("Too Low..");
                }
            }
            if (guess == false) {
                System.out.println("Sorry you loose the game. The number is" + rand);
            }
            System.out.println("Play Again ..you will win");
            String pA = sc.next();
            playAgain = pA.equalsIgnoreCase("y");

        }
        System.out.println("Thats it! Hope you enjoed..");
        System.out.println("Here is your Score." + finals);
    }

    public static int getrandN(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}


