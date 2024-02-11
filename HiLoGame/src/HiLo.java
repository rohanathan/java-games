import java.util.Scanner;
import java.util.InputMismatchException;
public class HiLo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String playAgain ="";
		do {
			//Creates a random number
			int theNumber = (int)(Math.random() * 100 + 1);
			//System.out.println( theNumber );
			int guess = 0;
			int numberOfTries = 0;
			while (guess != theNumber) {
				System.out.println("Guess a number between 1 and 100: ");
				//Handling exceptions
				try{
					guess = scan.nextInt();
					if (guess < 1 || guess > 100) {
						System.out.println("Please enter a number between 1 to 100 only.");
						continue;
					}
				}
				catch (InputMismatchException e) {
					// Clear the scanner's buffer
					scan.nextLine();
					System.out.println("Invalid input. Please enter a number.");
					continue; // Skip the rest of the loop and start again
				}
				if (guess < theNumber) {
					System.out.println(guess + " is too low. Try again.");
					numberOfTries++;
				}
				else if(guess > theNumber){
					System.out.println(guess + " is too high. Try again.");
					numberOfTries++;
				}
				else {
					System.out.println(guess +" is correct. YOU WIN!!!");
					System.out.println("It took " + numberOfTries + " tries. Good work!");
				}
			}
			System.out.println("Would you like to play again (y/n)?");
			playAgain = scan.next();
		}while (playAgain.equalsIgnoreCase("y"));
		
		if (playAgain.equalsIgnoreCase("n")) {
			System.out.println("Thanks for playing. Good-bye!");
		}
		scan.close();
	}
}
