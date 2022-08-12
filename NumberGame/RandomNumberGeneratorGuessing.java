package NumberGame;
import java.util.Random;
import java.util.*;

// Creating a random class for generating the random number between 1-100

class RandomNumberGenerator{
	int randomNumber = 0;
	
//	using Random class for generating the random number
	RandomNumberGenerator(){
		Random random = new Random();
		randomNumber = random.nextInt(101);
	}	
}



public class RandomNumberGeneratorGuessing {
		
	public static int numberGuessing(int randomNumber) {
		int numberOfGuesses = 0;
		Scanner sc = new Scanner(System.in);
		
		while(numberOfGuesses < 5) {
			System.out.print("Enter the number: ");
			int number = sc.nextInt();
			
			
			if(number == randomNumber) {
				return numberOfGuesses;
			}
			
			else if (number > randomNumber) {
				if(number - randomNumber > 15){
					System.out.println("Guessed Number is Extremely High");
					numberOfGuesses++;
				}else if ((number - randomNumber <= 15) && (number - randomNumber >= 5)){
					System.out.println("Guessed Number is Very High");
					numberOfGuesses++;
				}
				else if((number - randomNumber < 5) && (number - randomNumber > 0)) {
					System.out.println("Alomst there but try for smaller one");
					numberOfGuesses++;
				}
			}
			else {
				if(randomNumber - number > 15){
					System.out.println("Guessed Number is Extremely Low");
					numberOfGuesses++;
				}else if((randomNumber - number >= 5) && (randomNumber - number <= 15)){
					System.out.println("Gueesed number is very low");
					numberOfGuesses++;
				}else if((randomNumber - number < 5) && (randomNumber - number > 0)) {
					System.out.println("Almost there try for a bigger number");
					numberOfGuesses++;
				}
			}
			System.out.println();
		}
		return numberOfGuesses;
	}
	
	public static void countingScore(int guesses, int randomNumber) {
		if(guesses == 0) {
			System.out.println("Your Score is: 100");
			System.out.println();
		}
		else if(guesses == 1) {
			System.out.println("Your Score is: 80");
			System.out.println();
		}
		else if(guesses == 2) {
			System.out.println("Your Score is: 60");
			System.out.println();
		}
		else if(guesses == 3) {
			System.out.println("Your Score is: 40");
			System.out.println();
		}
		else if(guesses == 4) {
			System.out.println("Your Score is: 20");
			System.out.println();
		}
		else if(guesses == 5) {
			System.out.print("Your Score is: 0 ");
			System.out.println("and the number was : "+randomNumber);
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		
//		user has given 5 changes to guess the number
		int guesses = 0;
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("Press 1 to Play");
			System.out.println("Press any number to exit");
			int play = sc.nextInt();
			if(play == 1) {
				RandomNumberGenerator randomObject = new RandomNumberGenerator();
				int randomNumber = randomObject.randomNumber;
				guesses = numberGuessing(randomNumber);
				countingScore(guesses, randomNumber);
			}else {
				System.out.println("Thank You");
				break;
			}
		}
		sc.close();
	}

}
