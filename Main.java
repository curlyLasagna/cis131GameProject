package blackJackExtreme;

import java.util.Scanner;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static int wins;
	private static int extremeWins;
	private static int fNRounds;
	private static int nBJROunds;
	private static int fFRounds;
	private static int bJCount;
	private static int creditsEarned;
	private static int creditsLost; 
	private static int highestCredits;
	private static int bankRuptcies;
	private static String currency;
	
	public static void main(String[] args) {
		logIn();
		while(!displayMenu());
	}
	
	static void logIn() {
		String userName = "";
		String passwd = "";
		System.out.print("Alias: ");
		userName = input.next();
		System.out.print("Password: ");
		passwd = input.next();
		Player currentPlayer = new Player(userName, passwd, wins, extremeWins,
										fNRounds, nBJROunds, fFRounds, bJCount,
										creditsEarned, creditsLost, highestCredits,
										bankRuptcies, "credits");
	
		if(ProjectFileIO_v2.addNewPlayer(currentPlayer)) {
			//ProjectFileIO_v2.updatePlayer(currentPlayer);
			System.out.println("Welcome " + userName);
		}
		
	}
	
	
	static boolean displayMenu() {		
		boolean quit = false;
		System.out.println(" +----------------------------------------------------------------------------------+\n" +
				" |                                                                                  |\n" +
			    " |        __       __                __       __                 __         	    |\n" + 
			    " |       |  |     |  |              |  |     (__)               |  |                |\n" +
			    " |       |  |__   |  |  __ _    ___ |  | __   __   __  _    ___ |  | __   	    |\n" +
			    " |       |  *   \\ |  |/  _` | /  __||  |/ /  |  |/  _ ` | /  __||  |/ /             |\n" +
			    " |       |   |_) ||  |  (_| ||  (__ |    <   |  |  (_|  ||  (__ |    <              |\n" +
			    " |       |__*__ / |__|\\ __'_| \\ ___||__|\\__\\ |  |\\ __ '_| \\ ___||__|\\__\\            |\n" +
			    " |                                        __/   |                                   |\n" +
			    " |                                       |_____/   	                            |\n" +
			    " |                  _______   _____________ ________  ________                      | \n" + 
			    " |	           |  ___\\ \\ / /_   _| ___ \\  ___|  \\/  |  ___|                     | \n" + 
			    " |                 | |__  \\ V /  | | | |_/ / |__ | .  . | |__                       | \n" + 
			    " |                 |  __| /   \\  | | |    /|  __|| |\\/| |  __|                      | \n" + 
			    " |                 | |___/ /^\\ \\ | | | |\\ \\| |___| |  | | |___                      | \n" + 
			    " |                 \\____/\\/   \\/ \\_/ \\_| \\_\\____/\\_|  |_|____/                      |\n" +
			    " +==================================================================================+\n" +
				" |                                                                                  |\n" + 
			    " |                                1. Play                                           |\n" +
				" |                                2. Settings                                       |\n" +
			    " |                                3. Statistics                                     |\n" +
				" |                                4. Hall of Fame                                   |\n" +
			    " |                                5. Credits                                        |\n" +
				" |                                6. Exit                                           |\n" +
			    " | Enter 1 - 6 for selection                                                        |\n" +
				" +==================================================================================+");
		
		switch(getChoice()) {
		case 1:
			//Play menu
			displayPlay();
			break;
		case 2:
			//Settings menu
			displaySetting();
			break;
		case 6:
			//Quits the game
			displayThanks();
			quit = true;
			break;			
		}
		return quit;
	}
	
	static void displayGame() {
		
	}
	
	static void displayPlay() {
		System.out.printf("%35s\n","Play");
		System.out.println("1. Extreme Blackjack!\n" +
						   "2. Extras\n" +
						   "3. Back");
		switch(getChoice()) {
		case 1:
			break;
		case 2:
			displayExtreme();
			break;
		case 3:
			displayMenu();
			break;
		}
	}
	
	static void displayExtreme() {
		System.out.printf("%25s\n", "Extras");
		System.out.println("1. Fight Night\n" +
						   "2. Not BlackJack\n" +
				 		   "3. Fire\n" + 
						   "4. Rules\n" +
				 		   "5. Back");
		
		switch(getChoice()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			displayExtraRules();
			break;
		case 5:
			displayPlay();
			break;
		}
	}
	//Enter number for prompt to the user
	static void displayExtraRules() {
		System.out.println("Fight Night\n" +
						   ">Betting is set to your max credits\n" + 
						   ">Minimum of 5 rounds\n" +
						   ">After 5 rounds, you may quit\n" +
						   ">0 credits will cause to lose\n");
		System.out.println("Not BlackJack\n" +
						   ">If either dealer or user hits a blackjack, they lose\n" + 
						   ">If dealer wins, your bet is tripled and you\n" +
						   "lost that amount from your stack\n" +
						   "If you win, your bet is tripled and you're awarded the amount\n");
		System.out.println("For Fire\n" +
						   ">If you win 4 rounds in a row, you're awarded twice the\n" +
						   "amount of your total bets in those 4 rounds\n" +
						   "If you lose 4 rounds in a row, you're total credits are\n" +
						   "reduced twice the amount of your total bets in those 4 rounds\n");
		System.out.println("press q to go back");
		String q = input.next();
		if(q.startsWith("q"))
			displayExtreme();		
	}
	
	
	static void displaySetting() {
		System.out.printf("%35s\n", "Settings" );
		System.out.println("1. Change currency (default: credits)\n" +	   
						   "2. Save settings\n" +
						   "3. Load settings\n" +
						   "4. Back");
		
		switch(getChoice()) {
		case 1:
			changeCurrency();
			break;
		case 2:
			
		case 4:
			displayMenu();
			break;
		}
		
	}
	
	static String changeCurrency() {
		String newCurrency = "";
		System.out.printf("%31s\n", "Change currency");
		System.out.println("Enter new currency name or enter 'q' to go back");
		System.out.println();
		newCurrency = input.next();
		if(newCurrency.startsWith("q"))
			displaySetting();
		while(newCurrency.isEmpty()) {
			System.out.println("Changes not saved");
			System.out.println("Enter 'q' if you'd like to go back");
		}
		return newCurrency;
	}
	
	static void displayStats() {
		System.out.printf("%20s", "Statistics");
		System.out.println("Wins: " + "\n" +
							"Loses: " + "\n" +
							"Extreme rounds: " + "\n" +
							"Fight Night rounds: " + "\n" +
							"Not BlackJack rounds: " + "\n" +
							"For Fire rounds: " + "\n" +
							"Blackjacks: " + "\n" +
							"Credits earned: " + "\n" +
							"Credits lost: " + "\n" +
							"Credits lost: " + "\n" +
							"Highest credit : " + "\n" +
							"Bankruptcies: ");
	}
	
	static void displayHOF() {
		System.out.println("<=================== HALL OF FAME ===================>\n");
		System.out.printf("%-20s%5s", "Hustler:", "Credits:");
		
	}
	
	static void displayThanks() {
		//Displays a thank you message when user quits 
		System.out.println();
	}
	
	static int getChoice() {
		int choice = input.nextInt();
		return choice;
	}
	
	static char pressQ() {
		char q = input.next().charAt(0);
		while(q != 'q')
			System.out.println("Enter q to quit");
			q = input.next().charAt(0);
		return q;
	}
	
}
