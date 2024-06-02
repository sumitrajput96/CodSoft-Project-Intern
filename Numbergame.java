import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chances = 5;
        int finals = 0;
        boolean playAgain = true;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + chances + " chances to guess the number between 0 and 100.");

        while (playAgain) {
            int rand = getrandN(0, 100);
            boolean guess = false;

            for (int i = 0; i < chances; i++) {
                System.out.println("Chance " + (i + 1) + ": Enter your guess: ");
                int user = sc.nextInt();

                if (user == rand) {
                    guess = true;
                    finals++;
                    System.out.println("Congratulations! You guessed it right.");
                    break;
                } else if (user < rand) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }
            }

            if (!guess) {
                System.out.println("Sorry, you lost all chances. The number was: " + rand);
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playChoice = sc.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your score: " + finals);
    }

    public static int getrandN(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
