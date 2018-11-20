package blackJackExtreme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static String username;
	private static String passwd;
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
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		logIn();
		while(!displayMenu());
	}
	
	static void logIn() throws IOException {
		/*************************
		Things to add:
		If(objName = inputName)
			if(objPassWord != inputPass)
			while(inputPass != objPassWord)
			print "password incorrect" 
		*************************/
		System.out.println("");
		System.out.print("Alias: ");
		username = input.nextLine();
		System.out.print("Password: ");
		passwd = input.next();
		Player currentPlayer = new Player(username, passwd, wins, extremeWins,
										fNRounds, nBJROunds, fFRounds, bJCount,
										creditsEarned, creditsLost, highestCredits,
										bankRuptcies, currency);
		
		if(ProjectFileIO_v2.addNewPlayer(currentPlayer)) {
			System.out.println("Welcome " + currentPlayer.getName());
			System.out.println("Your password: " + currentPlayer.getPassword());
			ProjectFileIO_v2.writeFile();
		}
		else {
			System.out.println("Welcome back " + ProjectFileIO_v2.getPlayer(username,
			passwd).getName());
		}
	}
	
	
	static boolean displayMenu() throws IOException, InterruptedException {		
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
			quit = true;
			break;
		case 2:
			//Settings menu
			displaySetting();
			quit = true;
			break;
		case 3:
			//Player statistics 
			displayStats();
			quit = true;
			break;
		case 4:
			break;
		case 5:
			displayCredits();
			quit = true;
			break;
		case 6:
			//Quits the game
			displayThanks();
			quit = true;
			break;
		default:
			System.out.printf("Enter 1 - 6 and try again\n");
			displayMenu();
			quit = true;
			break;
			
		}
		return quit;
	}
	
	static void displayGame() {
		
	}
	
	static void displayPlay() throws IOException, InterruptedException {
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
	
	static void displayExtreme() throws IOException, InterruptedException {
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
	static void displayExtraRules() throws IOException, InterruptedException {
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
		
		if(pressQ().equals("q"))
			displayExtreme();		
	}
	
	
	static void displaySetting() throws IOException, InterruptedException {
		System.out.printf("%35s\n", "Settings" );
		System.out.println("1. Change currency \n"+ 							 
	                       "2. Change Alias \n" +
						   "3. Back");
		
		switch(getChoice()) {
		case 1:
			changeCurrency();
			break;
		case 2:
			changeAlias();
			break;
		case 3:
			displayMenu();
			break;
		}
		
	}
	
	static void changeCurrency() throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		System.out.printf("%31s\n", "Change currency");
		System.out.println(ProjectFileIO_v2.getPlayer(username, passwd).getCurrency());
		System.out.println("Enter new currency name or enter 'q' to go back");
		String newCurrency = input.next();
		ProjectFileIO_v2.getPlayer(username, passwd).setCurrency(newCurrency);
		System.out.println("Currency successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
		}
	
	static void changeAlias() throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		System.out.printf("%31s\n", "Change alias");
		System.out.println("Enter new name");
		String newAlias = input.next();
		ProjectFileIO_v2.getPlayer(username, passwd).setName(newAlias);
		System.out.println("Alias successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
	}
	
	static void displayStats() throws IOException, InterruptedException {
		System.out.printf("%20s", "Statistics\n");
		System.out.println("Wins: " + ProjectFileIO_v2.getPlayer(username, passwd).getWins() +"\n" + 
							"Loses: " + ProjectFileIO_v2.getPlayer(username, passwd).getWins() + "\n" +
							"Extreme rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getExtremeRounds() + "\n" +
							"Fight Night rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getFnRounds() + "\n" +
							"Not BlackJack rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getnBJRounds() + "\n" +
							"For Fire rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getFfRounds() + "\n" +
							"Blackjacks: " + ProjectFileIO_v2.getPlayer(username, passwd).getbJCount() + "\n" +
							"Credits earned: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsEarned() + "\n" +
							"Credits lost: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsLost() + "\n" +
							"Credits lost: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsLost() + "\n" +
							"Highest credit : " + ProjectFileIO_v2.getPlayer(username, passwd).getHighestCredits() + "\n" +
							"Bankruptcies: " + ProjectFileIO_v2.getPlayer(username, passwd).getBankRuptcies() + "\n" +
							"Press q to go back");
							if(pressQ().equals("q"))
								displayMenu();
	}
	
	static void displayHOF() {
		System.out.println("<=================== HALL OF FAME ===================>\n");
		System.out.printf("%-20s%5s", "Hustler:", "Wins:");
		/*************************
		Things to add:
		Create a player arraylist
		Call GetArrayList();
		Highest to lowest insertion sort
		Player.getWins();
		*************************/
		
	}
	
	static void displayCredits() throws InterruptedException, IOException {
		
		System.out.println("***********************************");
	    System.out.println("Blackjack Extreme " + "v" +ProjectFileIO_v2.getVersionNumber());
	    System.out.println("Authors: Luis Gascon & Austin Connick");
	    System.out.println("***********************************");
	    Thread.sleep(6000); 
	    displayMenu();
	}
	
	static void displayThanks() {
		//Displays a thank you message when user quits 
		System.out.println("Thank you for playing :)");
	}
	
	static int getChoice() {
		int choice = input.nextInt();
		return choice;
	}
	
	static String pressQ() {
		String q = input.next();
		while(!q.equals("q")) {
			System.out.println("Enter q to quit");
			q = input.next();
		}
		return q;
	}
	
}
