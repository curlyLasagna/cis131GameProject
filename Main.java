//Austin 
//Luis
package blackjackbuildone;
import java.io.IOException;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/****
 * <3 = hearts
 * <> = diamond
 * $$ = Spade
 * ** = Club 
 */

public class Main {

	private static Scanner input = new Scanner(System.in);
	private static String username;
	private static String passwd;
	private static int wins;
	private static int loses;
	private static int extremeWins;
	private static int fNRounds;
	private static int nBJROunds;
	private static int fFRounds;
	private static int bJCount;
	private static int creditsEarned;
	private static int creditsLost; 
	private static int highestCredits;
	private static int bankRuptcies;
	private static String currency = "credits";
	private static Player currentPlayer = new Player
	(username, passwd, wins, loses, extremeWins,
	fNRounds, nBJROunds, fFRounds, bJCount,
	creditsEarned, creditsLost, highestCredits,
	bankRuptcies, currency);
	
	public static void main(String[] args) 
	throws IOException, InterruptedException {
		
		ProjectFileIO_v2.readFile();
		System.out.println("Welcome to BlackJack Extreme\nPlease log in :)\n");
		logIn();
		while(!displayMenu());
		
	}
	
	static void logIn() throws IOException {

		username = IR4.getString("Alias: ");
		currentPlayer.setName(username);
		passwd = IR4.getString("Password: ");
		checkPassword(username, passwd);
		currentPlayer.setPassword(passwd);
		isNewPlayer(username);

	}
	
	static void checkPassword(String user, String pass) throws IOException {
		
		//Surprised this mess works
		for(Player x: ProjectFileIO_v2.getPlayerArrayList()) { 
			if(username.equals(x.getName())) {
				while(!passwd.equals(x.getPassword())) {
					System.err.println("Wrong password, try again, or press 'q' to change alias");
					System.out.print("Password: ");
					passwd = input.next();		
					if(passwd.equals("q")) {
						logIn();
						break;
					}
				}
			}
		}
	}
	
	
	static void isNewPlayer(String user) throws IOException {

		if(ProjectFileIO_v2.addNewPlayer(currentPlayer)) {
			System.out.println("Welcome to the club " + currentPlayer.getName());
			ProjectFileIO_v2.writeFile();
		}
		
		else {
			System.out.println("Welcome back " + 
		ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getName() + "!");
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
		
		switch(IR4.getIntegerBetweenLowAndHigh("", 1, 6, "Invalid input, try again")) {
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
			displayHOF();
			quit = true;
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
		switch(IR4.getIntegerBetweenLowAndHigh("", 1, 3, "Invalid input, try again")) {
		case 1:
			mainGame();
			break;
		case 2:
			displayExtreme();
			break;
		case 3:
			displayMenu();
			break;
		default:
			
		}
	}
	
	static void displayExtreme() throws IOException, InterruptedException {
		System.out.printf("%25s\n", "Extras");
		System.out.println("1. Fight Night\n" +
						   "2. Not BlackJack\n" +
				 		   "3. Fire\n" + 
						   "4. Rules\n" +
				 		   "5. Back");
		
		switch(IR4.getIntegerBetweenLowAndHigh("", 1, 5, "Invalid input, try again")) {
		
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
		default:
			System.err.println("Enter 1 - 5 and try again");
			displayExtreme();
			break;
		}
	}
	private static void mainGame() {
		double score = 1500;
		int lost = 0;
		double bet;
		boolean run = true;
		int move;
		int numberDraws = 2;
		int drawFactor = 8; 
		int compHit = 16;
		int CARDGAMENUM = 21;
		while(score >= 0) {
			Deck playingDeck = new Deck();
			Deck PlayerHand = new Deck();
			Deck CompHand = new Deck();
			playingDeck.createDeck();
			playingDeck.shuffle();
			//Winning number 
			CARDGAMENUM = IR4.getRandomNumber(21, 61);
			//Tells the AI how many times to hit 
			compHit = CARDGAMENUM - 4 ;
			System.out.println("Money = "+score);
			System.out.println("Winnig Number: "+ CARDGAMENUM);
			printWiningscore(CARDGAMENUM);

			bet = placeBets(score);
			numberDraws = CARDGAMENUM /drawFactor;
			//Draw for player
			for(int i = 1; i<= numberDraws; i++) {
				PlayerHand.draw(playingDeck);
			}
			
			//Draw for House 
			for(int i = 2; i< numberDraws; i++) {
				CompHand.draw(playingDeck);
			}
			
			CompHand.draw(playingDeck);
			
			run = true;
			while(run) {
				System.out.println("*******************************");
				System.out.println("Win- "+ wins+"  Lost- "+lost);
				System.out.println("*******************************");
				System.out.println("Hand- "+username);
				System.out.println(PlayerHand.toString());
				System.out.println("Sum ");
				System.out.println(PlayerHand.cardValue());
				System.out.println("*******************************");
				System.out.println("Dealer hand ");
				System.out.println(CompHand.toString());
				System.out.println("Sum ");
				System.out.println(CompHand.cardValue());
				System.out.println("*******************************");
				while(CompHand.cardValue() <= compHit) {
					CompHand.draw(playingDeck);
				}
				move = getMove();


				if(move == 1) {
					PlayerHand.draw(playingDeck);
					if(PlayerHand.cardValue() > CARDGAMENUM) {
						System.out.println("*******************************");
						System.out.println("Hand- "+username);
						System.out.println(PlayerHand.toString());
						System.out.println("Sum ");
						System.out.println(PlayerHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Dealer hand ");
						System.out.println(CompHand.toString());
						System.out.println("Sum ");
						System.out.println(CompHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Bust!!!!!!");
						lost = lost - 1;
						score = score - bet;
						//System.out.println(score);
						run = false;
					}
					if(PlayerHand.cardValue() == CARDGAMENUM) {
						System.out.println(CARDGAMENUM);
						WinningPrints();
						run = false;
					}
					if(CompHand.cardValue() > CARDGAMENUM) {
						System.out.println("*******************************");
						System.out.println("Hand- "+username);
						System.out.println(PlayerHand.toString());
						System.out.println("Sum ");
						System.out.println(PlayerHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Dealer hand ");
						System.out.println(CompHand.toString());
						System.out.println("Sum ");
						System.out.println(CompHand.cardValue());
						System.out.println("*******************************");
						dealerBust();
						WinningPrints();
						 wins =  wins + 1;
						score = score + bet;
						//System.out.println(score);
						run = false;
					}


				}
				if(move == 2) {
					run = false;

					if(CompHand.cardValue() <= PlayerHand.cardValue()&& PlayerHand.cardValue() <= CARDGAMENUM) {
						System.out.println("*******************************");
						System.out.println("Hand- "+username);
						System.out.println(PlayerHand.toString());
						System.out.println("Sum ");
						System.out.println(PlayerHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Dealer hand ");
						System.out.println(CompHand.toString());
						System.out.println("Sum ");
						System.out.println(CompHand.cardValue());
						System.out.println("*******************************");
						WinningPrints();
						 wins =  wins +1;
						score =score  + bet;
						System.out.println(score);

					}
					if(CompHand.cardValue() >= PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM) {
						System.out.println("*******************************");
						System.out.println("Hand- "+username);
						System.out.println(PlayerHand.toString());
						System.out.println("Sum ");
						System.out.println(PlayerHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Dealer hand ");
						System.out.println(CompHand.toString());
						System.out.println("Sum ");
						System.out.println(CompHand.cardValue());
						System.out.println("*******************************");
						printDealerwin();
						lost = lost - 1;
						score =score  - bet;
						System.out.println(score);
					}
					if(CompHand.cardValue() >  CARDGAMENUM) {
						System.out.println("*******************************");
						System.out.println("Hand- "+username);
						System.out.println(PlayerHand.toString());
						System.out.println("Sum ");
						System.out.println(PlayerHand.cardValue());
						System.out.println("*******************************");
						System.out.println("Dealer hand ");
						System.out.println(CompHand.toString());
						System.out.println("Sum ");
						System.out.println(CompHand.cardValue());
						System.out.println("*******************************");
						dealerBust();
						WinningPrints();
						 wins =  wins +1;
						run = false;

					}
				}			
			}
		}
	}

	private static void printWiningscore(int cARDGAMENUM) {
		System.out.printf(" _    _ _             _               _   _                 _ \n"
				+ "| |  | (_)           (_)             | | | |               | |\n"
				+ "| |  | |_ _ __  _ __  _ _ __   __ _  | |_| | __ _ _ __   __| |\n"
				+ "| |/\\| | | '_ \\| '_ \\| | '_ \\ / _` | |  _  |/ _` | '_ \\ / _` |\n"
				+ "\\  /\\  / | | | | | | | | | | | (_| | | | | | (_| | | | | (_| |\n"
				+ " \\/  \\/|_|_| |_|_| |_|_|_| |_|\\__, | \\_| |_/\\__,_|_| |_|\\__,_|\n"
				+ "                               __/ |                          \n"
				+ "                              |___/                           \n");
	NumberPrinter(cARDGAMENUM);	
	}

	private static void NumberPrinter(int cARDGAMENUM) {
		if(String.valueOf(cARDGAMENUM).contains("1")) {
			System.out.printf("");
			}
			if(String.valueOf(cARDGAMENUM).contains("2")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("3")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("4")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("5")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("6")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("7")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("8")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("9")) {
				System.out.printf("");
				}
			if(String.valueOf(cARDGAMENUM).contains("0")) {
				System.out.printf("");
				}
			
			
		}
		

	private static void dealerBust() {
		System.out.printf("______           _            ______           _   _ _ _ _ _ _ \n"
				+ "|  _  \\         | |           | ___ \\         | | | | | | | | |\n"
				+ "| | | |___  __ _| | ___ _ __  | |_/ /_   _ ___| |_| | | | | | |\n"
				+ "| | | / _ \\/ _` | |/ _ \\ '__| | ___ \\ | | / __| __| | | | | | |\n"
				+ "| |/ /  __/ (_| | |  __/ |    | |_/ / |_| \\__ \\ |_|_|_|_|_|_|_|\n"
				+ "|___/ \\___|\\__,_|_|\\___|_|    \\____/ \\__,_|___/\\__(_|_|_|_|_|_)\n"
				+ "");
		
	}

	private static void printDealerwin() {
		System.out.printf("______           _             _    _             \n"
				+ "|  _  \\         | |           | |  | |            \n"
				+ "| | | |___  __ _| | ___ _ __  | |  | | ___  _ __  \n"
				+ "| | | / _ \\/ _` | |/ _ \\ '__| | |/\\| |/ _ \\| '_ \\ \n"
				+ "| |/ /  __/ (_| | |  __/ |    \\  /\\  / (_) | | | |\n"
				+ "|___/ \\___|\\__,_|_|\\___|_|     \\/  \\/ \\___/|_| |_|\n");
		
	}

	private static void WinningPrints() {
		int i = 1;
		i = IR4.getRandomNumber(1, 3);
		if (i == 1) {
			System.out.printf("         _________ _        _        _______  _______ \n|\\     /|\\__   __/( (    /|( (    /|(  ____ \\(  ____ )\n"
					+ "| )   ( |   ) (   |  \\  ( ||  \\  ( || (    \\/| (    )|\n| | _ | |   | |   |   \\ | ||   \\ | || (__    | (____)|\n"
					+ "| |( )| |   | |   | (\\ \\) || (\\ \\) ||  __)   |     __)\n"
					+ "| || || |   | |   | | \\   || | \\   || (      | (\\ (   \n"
					+ "| () () |___) (___| )  \\  || )  \\  || (____/\\| ) \\ \\__\n"
					+ "(_______)\\_______/|/    )_)|/    )_)(_______/|/   \\__/\n");
		}
		if (i == 2) {
			System.out.printf("      ___                       ___           ___           ___           ___     \n"
					+ "     /\\__\\          ___        /\\__\\         /\\__\\         /\\  \\         /\\  \\    \n"
					+ "    /:/ _/_        /\\  \\      /::|  |       /::|  |       /::\\  \\       /::\\  \\   \n"
					+ "   /:/ /\\__\\       \\:\\  \\    /:|:|  |      /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\  \n"
					+ "  /:/ /:/ _/_      /::\\__\\  /:/|:|  |__   /:/|:|  |__   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n"
					+ " /:/_/:/ /\\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/ |:| /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n"
					+ " \\:\\/:/ /:/  / /\\/:/  /    \\/__|:|/:/  / \\/__|:|/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n"
					+ "  \\::/_/:/  /  \\::/__/         |:/:/  /      |:/:/  /   \\:\\ \\:\\__\\      |:|::/  / \n"
					+ "   \\:\\/:/  /    \\:\\__\\         |::/  /       |::/  /     \\:\\ \\/__/      |:|\\/__/  \n"
					+ "    \\::/  /      \\/__/         /:/  /        /:/  /       \\:\\__\\        |:|  |    \n"
					+ "     \\/__/                     \\/__/         \\/__/         \\/__/         \\|__|    \n");
			
		}
		if (i == 3) {
			System.out.printf(".------..------..------..------..------..------.\n"
					+ "|W.--. ||I.--. ||N.--. ||N.--. ||E.--. ||R.--. |\n"
					+ "| :/\\: || (\\/) || :(): || :(): || (\\/) || :(): \n"
					+ "| :\\/: || :\\/: || ()() || ()() || :\\/: || ()() |\n"
					+ "| '--'W|| '--'I|| '--'N|| '--'N|| '--'E|| '--'R|\n"
					+ "`------'`------'`------'`------'`------'`------'\n");
	
}
/////////////////////////////////////////		
		
	}

	private static int getMove() {
		int move;
		boolean run = true;
		do {
			System.out.println("1. Hit");

			move = IR4.getInteger("2. Stand");
			if(move != 1 && move != 2) {
				System.out.println("Invald input");
				run = true;
			}

		} while(!run);
			return move;
	}

	private static double placeBets(double score) {


		double temp = IR4.getDouble("Places Bets, or bet 0 to quit ");
		boolean run = true;
		while(run) {
			if(temp <= score && temp > 0) {
				run = false;
				return temp;
			}
			else if(temp == 0) 
				displayGame();
			
			else {
				System.out.println("Invald input");
				temp = IR4.getDouble("Places Bets");
				run = true;
			}
		}
		return temp;
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
		System.out.printf("%42s\n", "Settings" );
		System.out.println("1. Change currency \n"+ 							 
	                       "2. Change Alias \n" +
						   "3. Back");
		
		switch(IR4.getIntegerBetweenLowAndHigh("", 1, 3, "Invalid input, try again")) {
		
		case 1:
			changeCurrency();
			break;
		case 2:
			changeAlias();
			break;
		case 3:
			displayMenu();
			break;
		default:
			System.err.println("Enter 1 - 3 and try again");	
		}
	}
	
	static void changeCurrency() throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		System.out.printf("%31s\n", "Change currency");
		System.out.println("Current currency: " + 
		ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCurrency());
		System.out.println("Enter new currency name or enter 'q' to go back");
		String newCurrency = input.next();
		if(newCurrency.equals("q"))
			displaySetting();
		else
		System.out.println();
		//NullPointerException on getPlayer method if alias has been changed
		ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setCurrency(newCurrency);
		System.out.println("Currency successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
	}
	
//	Under construction
	static void changeAlias() throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		String newAlias = "";
		System.out.printf("%31s\n", "Change alias");
		System.out.println("Enter new name");
		newAlias = input.next();
		for(Player x: ProjectFileIO_v2.getPlayerArrayList()) {
			while(newAlias.equals(x.getName())) {
				System.err.println("Alias already taken, choose another one");
				System.out.println("Enter new name");
				newAlias = input.next();
			}
		}
		if(newAlias.equals("q"))
			displaySetting();
		else 
			
		ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setName(newAlias);
		currentPlayer.setName(newAlias);
		System.out.println("Alias successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
		}
	
	
	static void displayStats() throws IOException, InterruptedException {
		System.out.printf("%20s", "Statistics\n");
		System.out.println("Wins: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getWins() +"\n" + 
							"Loses: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getLoses() + "\n" +
							"Extreme rounds: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getExtremeRounds() + "\n" +
							"Fight Night rounds: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getFnRounds() + "\n" +
							"Not BlackJack rounds: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getnBJRounds() + "\n" +
							"For Fire rounds: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getFfRounds() + "\n" +
							"Blackjacks: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getbJCount() + "\n" +
							"Credits earned: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsEarned() + "\n" +
							"Credits lost: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsLost() + "\n" +
							"Credits lost: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsLost() + "\n" +
							"Highest credit : " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getHighestCredits() + "\n" +
							"Bankruptcies: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getBankRuptcies() + "\n" +
							"Press q to go back");
							if(pressQ().equals("q"))
								displayMenu();
	}
	
	static void displayHOF() throws IOException, InterruptedException {
		System.out.println("<=================== HALL OF FAME ===================>\n");
		System.out.printf("%-20s%33s\n", "Hustler:", "Wins:");
		System.out.printf("%-20s%27c%3s\n", "--------", ' ', "------");
		
		int playerSize = ProjectFileIO_v2.getPlayerArrayList().size();
		int[] scores = new int[playerSize];
		String [] users = new String[playerSize];
		int count = 0;
		for(Player player: ProjectFileIO_v2.getPlayerArrayList()) {
				scores[count] = player.getWins();
				users[count] = player.getName();
				count++;
			}	
		
		sortHighScores(scores, users);
		
		for(int x=0;x<playerSize;x++) {
			System.out.printf("%-25s%25d\n",users[x] , scores[x]);
		}
		
		 System.out.println("Press q to go back");
		 if(pressQ().equals("q"))
			 displayMenu();
		}

	
	public static void sortHighScores(int [] arr, String [] arra) {
		int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] < arr[j+1]) 
                { 
                    int temp = arr[j]; 
                    String tempura = arra[j];
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    arra[j] = arra[j+1];
                    arra[j+1] = tempura;
                } 
	}
	
	static void displayCredits() throws InterruptedException, IOException {
		
		System.out.println("***********************************");
	    System.out.println("Blackjack Extreme " + "v" +ProjectFileIO_v2.getVersionNumber());
	    System.out.println("Authors:");
	    System.out.println("Luis Gascon"); 
	    System.out.println("Austin Connick");
	    System.out.println("***********************************");
	    Thread.sleep(3000); 
	    displayMenu();

	}
	
	static void displayThanks() {
		//Displays a thank you message when user quits 
		//Create an ASCII art 
		System.out.println(" _______ _                 _                          _ \n" +
						  "|__   __| |               | |                        | |\n" +
						  "  |  | |__   __ _ _ __ | | __  _   _  ___  _   _  | |\n" +
						  "  |  | '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | | | |\n" +
						  "  |  | | | | (_| | | | |   <  | |_| | (_) | |_| | |_|\n" +
						  "  |  |_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_| (_)\n" +
						  "                                __/ |                \n" +
                          "								___/                 ");
		System.out.println("Thank you for playing :)");
	}
	
	
//	static Integer getChoice(int low, int high) {
//		String choice = input.next();
//		Integer selection = 0;
//		while(!choice.matches("\\d{1}")) {
//			System.err.println("Invalid input, try again");
//			choice = input.next();
//			selection = Integer.valueOf(choice);
//
//		while(selection > high || selection < low) {
//			System.err.println("Enter " + low + "-" + high + " and try again");
//			choice = input.next();
//			selection = Integer.valueOf(choice);
//			}
//		}
//		return selection;
//	}
	
	static String pressQ() {
		String q = input.next();
		while(!q.equals("q")) {
			System.out.println("Enter q to quit");
			q = input.next();
		}
		return q;
	}
}
