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
	private static Player currentPlayer = new Player
			(username, passwd, wins, extremeWins,
					fNRounds, nBJROunds, fFRounds, bJCount,
					creditsEarned, creditsLost, highestCredits,
					bankRuptcies, currency);
	private static ArrayList<Integer> scores = new ArrayList<>(10);

	public static void main(String[] args) 
			throws IOException, InterruptedException {

		ProjectFileIO_v2.readFile();
		logIn();
		while(!displayMenu());

	}

	static void logIn() throws IOException {

		System.out.print("\t\t\t\t\t\t\t\tAlias: ");
		username = input.next();
		currentPlayer.setName(username);
		System.out.print("\t\t\t\t\t\t\t\tPassword: ");
		passwd = input.next();
		checkPassword(username, passwd);
		currentPlayer.setPassword(passwd);
		isNewPlayer(username);

	}

	static void checkPassword(String user, String pass) throws IOException {

		for(Player x: ProjectFileIO_v2.getPlayerArrayList()) { 
			if(username.equals(x.getName()))
				while(!passwd.equals(x.getPassword())) {
					System.err.println("\t\t\t\t\t\t\t\tWrong password, try again, or press 'q' to change alias");
					if(passwd.equals(pressQ()))
						logIn();
					System.out.print("\t\t\t\t\t\t\t\tPassword: ");
					passwd = input.next();		

				}
		}
	}

	static void isNewPlayer(String user) throws IOException {

		if(ProjectFileIO_v2.addNewPlayer(currentPlayer)) {
			System.out.println("\t\t\t\t\t\t\t\tWelcome " + currentPlayer.getName());
			System.out.println("\t\t\t\t\t\t\t\tYour password: " + currentPlayer.getPassword());
			ProjectFileIO_v2.writeFile();

		}

		else {
			System.out.println("\t\t\t\t\t\t\t\tWelcome back " + 
					ProjectFileIO_v2.getPlayer(username, passwd).getName() + "!");
		}
	}

	static boolean displayMenu() throws IOException, InterruptedException {		
		boolean quit = false;
		System.out.printf("\t\t\t\t\t\t\t\t +----------------------------------------------------------------------------------+\n" +
				" \t\t\t\t\t\t\t\t|                                                                                  |\n" +
				" \t\t\t\t\t\t\t\t|        __       __                __       __                 __                 |\n" + 
				" \t\t\t\t\t\t\t\t|       |  |     |  |              |  |     (__)               |  |                |\n" +
				" \t\t\t\t\t\t\t\t|       |  |__   |  |  __ _    ___ |  | __   __   __  _    ___ |  | __   	   |\n" +
				" \t\t\t\t\t\t\t\t|       |  *   \\ |  |/  _` | /  __||  |/ /  |  |/  _ ` | /  __||  |/ /             |\n" +
				" \t\t\t\t\t\t\t\t|       |   |_) ||  |  (_| ||  (__ |    <   |  |  (_|  ||  (__ |    <              |\n" +
				" \t\t\t\t\t\t\t\t|       |__*__ / |__|\\ __'_| \\ ___||__|\\__\\ |  |\\ __ '_| \\ ___||__|\\__\\            |\n" +
				" \t\t\t\t\t\t\t\t|                                        __/   |                                   |\n" +
				" \t\t\t\t\t\t\t\t|                                       |_____/   	                           |\n" +
				" \t\t\t\t\t\t\t\t|                  _______   _____________ ________  ________                      | \n" + 
				" \t\t\t\t\t\t\t\t|	          |  ___\\ \\ / /_   _| ___ \\  ___|  \\/  |  ___|                     | \n" + 
				" \t\t\t\t\t\t\t\t|                 | |__  \\ V /  | | | |_/ / |__ | .  . | |__                       | \n" + 
				" \t\t\t\t\t\t\t\t|                 |  __| /   \\  | | |    /|  __|| |\\/| |  __|                      | \n" + 
				" \t\t\t\t\t\t\t\t|                 | |___/ /^\\ \\ | | | |\\ \\| |___| |  | | |___                      | \n" + 
				" \t\t\t\t\t\t\t\t|                 \\____/\\/   \\/ \\_/ \\_| \\_\\____/\\_|  |_|____/                      |\n" +
				" \t\t\t\t\t\t\t\t+==================================================================================+\n" +
				" \t\t\t\t\t\t\t\t|                                                                                  |\n" + 
				" \t\t\t\t\t\t\t\t|                                1. Play                                           |\n" +
				" \t\t\t\t\t\t\t\t|                                2. Settings                                       |\n" +
				" \t\t\t\t\t\t\t\t|                                3. Statistics                                     |\n" +
				" \t\t\t\t\t\t\t\t|                                4. Hall of Fame                                   |\n" +
				" \t\t\t\t\t\t\t\t|                                5. Credits                                        |\n" +
				" \t\t\t\t\t\t\t\t|                                6. Exit                                           |\n" +
				" \t\t\t\t\t\t\t\t| Enter 1 - 6 for selection                                                        |\n" +
				" \t\t\t\t\t\t\t\t+==================================================================================+");

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
			System.out.printf("\t\t\t\t\t\t\t\tEnter 1 - 6 and try again\n");
			displayMenu();
			quit = true;
			break;

		}
		return quit;
	}

	static void displayGame() {
	}


	static void displayPlay() throws IOException, InterruptedException {
		System.out.printf("\t\t\t\t\t\t\t\t\t%35s\n","Play");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t1. Extreme Blackjack!\n" +
				"\t\t\t\t\t\t\t\t\t\t\t\t2. Extras\n" +
				"\t\t\t\t\t\t\t\t\t\t\t\t3. Back");
		switch(getChoice()) {
		case 1:
			mainGame();
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
	private static void mainGame() throws IOException {
		double score = 1500;
		int lost = 0;
		double bet = 0;
		boolean run = true;
		int move;
		int numberDraws = 2;
		int drawFactor = 8; 
		int compHit = 16;
		int CARDGAMENUM = 21;
		boolean runTwo = true;
		while(runTwo) {
			Deck playingDeck = new Deck();
			Deck PlayerHand = new Deck();
			Deck CompHand = new Deck();
			playingDeck.createDeck();
			playingDeck.shuffle();
			CARDGAMENUM = IR4.getRandomNumber(21, 61);
			compHit = CARDGAMENUM - 6 ;
			System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\tMoney = "+score+"\n");
			printWiningscore(CARDGAMENUM);
			if(score <= 0) {
				runTwo = false;
				run = false;
				 bankRuptcies++;
				 ProjectFileIO_v2.writeFile();
				ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
			}
			if(score > 0) {
			bet = placeBets(score);
			}
			numberDraws = CARDGAMENUM /drawFactor;
			for(int i = 1; i<= numberDraws; i++) {
				PlayerHand.draw(playingDeck);
			}
			for(int i = 2; i< numberDraws; i++) {
				CompHand.draw(playingDeck);
			}
			CompHand.draw(playingDeck);
			if(score <= 0) {
				runTwo = false;
				run = false;
				 bankRuptcies++;
				 ProjectFileIO_v2.writeFile();
				ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
			}

			run = true;
			while(run) {
				dividers();
				System.out.printf("\t\t\t\t\t\t\t\t\t\t\tWin- "+ wins+"  Lost- "+lost+"\n");
				dividers();
				printdealerHand();
				dividers();
				System.out.println(CompHand.toString());
				dividers();

				printHand();
				System.out.printf(PlayerHand.toString());
				dividers();
				printSum();
				dividers();
				System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
				dividers();
				////////////////////////////////21/insta win////////////////////////////////////////////////
				if(PlayerHand.cardValue() == CARDGAMENUM) {
					System.out.println(CARDGAMENUM);
					dividers();
					printdealerHand();
					dividers();
					System.out.println(CompHand.toString());
					dividers();

					printHand();
					System.out.printf(PlayerHand.toString());
					dividers();
					printSum();
					dividers();
					System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
					dividers();
					WinningPrints();
					run = false;
				}

				move = getMove();
				////////////////////Quit Add Save Stuff Here?/////////////////////////////////////////////////////////
				if(move == 3) {
					run = false;
					runTwo = false;
					ProjectFileIO_v2.writeFile();
					ProjectFileIO_v2.getPlayer(username, passwd).setWins(wins);
					ProjectFileIO_v2.getPlayer(username, passwd).setCreditsEarned(creditsEarned);
					ProjectFileIO_v2.getPlayer(username, passwd).setCreditsLost(creditsLost);
					
					
				}

				////////////////////////////Hit/////////////////////////////////////////////////////////////////
				if(move == 1) {
					PlayerHand.draw(playingDeck);
					if(PlayerHand.cardValue() > CARDGAMENUM) {
						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						bustprint();
						dividers();
						lost = lost + 1;
						score = score - bet;
						creditsLost = (int) (creditsLost + bet);
						//System.out.println(score);
						run = false;
					}
					//////////////////////////////////////21////////////////////////////////////
					if(PlayerHand.cardValue() == CARDGAMENUM) {
						System.out.println(CARDGAMENUM);
						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						WinningPrints();
						score = score + bet;
						run = false;
					}
					if(CompHand.cardValue() > CARDGAMENUM) {
						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						dealerBust();
						dividers();
						WinningPrints();
						dividers();
						wins =  wins + 1;
						score = score + bet;
						creditsEarned = (int) (creditsEarned + bet);
						//System.out.println(score);
						run = false;
					}


				}
				/////////////////////////////////////////////Stand//////////////////////////////////////////////
				if(move == 2) {
					run = false;
					/////////////////////////////////////////////AI///////////////////////////////////////
					while(CompHand.cardValue() <= compHit) {
						CompHand.draw(playingDeck);
					}
					/////////////////////////////////////////Rest menu//////////////////
					dividers();
					printdealerHand();
					dividers();
					System.out.println(CompHand.toString());
					dividers();

					printHand();
					System.out.printf(PlayerHand.toString());
					dividers();
					printSum();
					dividers();
					System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
					dividers();
					WinningPrints();
					dividers();
					/////////////////////////////////////////////////Player wins//////////////////////////////////////////////////////////////////////////////////
					if(CompHand.cardValue() <= PlayerHand.cardValue()&& PlayerHand.cardValue() <= CARDGAMENUM) {

						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						WinningPrints();
						dividers();
						wins =  wins + 1;
						score =score  + bet;
						 creditsEarned = (int) (creditsEarned + bet);
						System.out.println(score);

					}
					////////////////////////////////////////////////////////AI wins////////////////////////////////////////////
					if(CompHand.cardValue() >= PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM) {
						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						printDealerwin();
						dividers();
						lost = lost + 1;
						score =score  - bet;
						System.out.println(score);
					}
					////////////////////////////AI Bust///////////////////////////////////
					if(CompHand.cardValue() >  CARDGAMENUM) {
						dividers();
						printdealerHand();
						dividers();
						System.out.println(CompHand.toString());
						dividers();

						printHand();
						System.out.printf(PlayerHand.toString());
						dividers();
						printSum();
						dividers();
						System.out.print("\t\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\n");
						dividers();
						dealerBust();
						dividers();
						WinningPrints();
						dividers();
						wins =  wins +1;
						score = score + bet;
						run = false;


					}
				}			
			}

		}
		try {
			displayMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printHand() {
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t _   _                 _ \n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| | | |               | |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| |_| | __ _ _ __   __| |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t|  _  |/ _` | '_ \\ / _` |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| | | | (_| | | | | (_| |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t\\_| |_/\\__,_|_| |_|\\__,_|\n");


	}

	private static void bustprint() {
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t______           _   _ _ _ _ \n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| ___ \\         | | | | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| |_/ /_   _ ___| |_| | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| ___ \\ | | / __| __| | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t| |_/ / |_| \\__ \\ |_|_|_|_|_|\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t\\____/ \\__,_|___/\\__(_|_|_|_)\n");

	}

	private static void dividers() {
		System.out.printf("\t\t\t\t\t\t\t\t***********************************************************************************\n");

	}

	private static void printSum() {
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t _____                 \n"
				+ "\t\t\t\t\t\t\t\t\t\t\t/  ___|                \n"
				+"\t\t\t\t\t\t\t\t\t\t\t\\ `--. _   _ _ __ ___  \n"
				+ "\t\t\t\t\t\t\t\t\t\t\t `--. \\ | | | '_ ` _ \\ \n"
				+ "\t\t\t\t\t\t\t\t\t\t\t/\\__/ / |_| | | | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t\t\t\\____/ \\__,_|_| |_| |_|\n");

	}

	private static void printdealerHand() {
		System.out.printf("\t\t\t\t\t\t\t\t\t______           _             _   _                 _ \n"
				+ "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | | | |               | |\n"
				+ "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |_| | __ _ _ __   __| |\n"
				+ "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| |  _  |/ _` | '_ \\ / _` |\n"
				+ "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    | | | | (_| | | | | (_| |\n"
				+ "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|    \\_| |_/\\__,_|_| |_|\\__,_|\n");

	}

	private static void printWiningscore(int cARDGAMENUM) {
		System.out.printf("\t\t\t\t\t\t\t\t\t _    _ _             _               _   _                 _ \n"
				+ "\t\t\t\t\t\t\t\t\t| |  | (_)           (_)             | | | |               | |\n"
				+ "\t\t\t\t\t\t\t\t\t| |  | |_ _ __  _ __  _ _ __   __ _  | |_| | __ _ _ __   __| |\n"
				+ "\t\t\t\t\t\t\t\t\t| |/\\| | | '_ \\| '_ \\| | '_ \\ / _` | |  _  |/ _` | '_ \\ / _` |\n"
				+ "\t\t\t\t\t\t\t\t\t\\  /\\  / | | | | | | | | | | | (_| | | | | | (_| | | | | (_| |\n"
				+ "\t\t\t\t\t\t\t\t\t \\/  \\/|_|_| |_|_| |_|_|_| |_|\\__, | \\_| |_/\\__,_|_| |_|\\__,_|\n"
				+ "\t\t\t\t\t\t\t\t\t                               __/ |                          \n"
				+ "\t\t\t\t\t\t\t\t\t                              |___/                           \n");
		dividers();
		NumberPrinter(cARDGAMENUM);
		dividers();
	}

	private static void NumberPrinter(int cARDGAMENUM) {
		/////////////////////////////////////////////////////////////////////////////
		int countStart = 1;
		int lines = 6;
		for(int i = 0; i < lines; i++) {
			System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t");
			if(String.valueOf(cARDGAMENUM).startsWith("1")) {
				if(countStart == 1) {
					System.out.printf("  __ ");
				}
				if(countStart == 2) {
					System.out.printf(" /_ |");
				}
				if(countStart == 3) {
					System.out.printf("  | |");
				}
				if(countStart == 4) {
					System.out.printf("  | |");
				}
				if(countStart == 5) {
					System.out.printf("  | |");
				}
				if(countStart == 6) {
					System.out.printf("  |_|");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("2")) {
				if(countStart == 1) {
					System.out.printf("  ___  ");
				}
				if(countStart == 2) {
					System.out.printf(" |__ \\ ");
				}
				if(countStart == 3) {
					System.out.printf("    ) |");
				}
				if(countStart == 4) {
					System.out.printf("   / / ");
				}
				if(countStart == 5) {
					System.out.printf("  / /_ ");
				}
				if(countStart == 6) {
					System.out.printf(" |____|");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("3")) {
				if(countStart == 1) {
					System.out.printf("  ____  ");
				}
				if(countStart == 2) {
					System.out.printf(" |___ \\ ");
				}
				if(countStart == 3) {
					System.out.printf("   __) |");
				}
				if(countStart == 4) {
					System.out.printf("  |__ < ");
				}
				if(countStart == 5) {
					System.out.printf("  ___) |");
				}
				if(countStart == 6) {
					System.out.printf(" |____/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("4")) {
				if(countStart == 1) {
					System.out.printf("  _  _   ");
				}
				if(countStart == 2) {
					System.out.printf(" | || |  ");
				}
				if(countStart == 3) {
					System.out.printf(" | || |_ ");
				}
				if(countStart == 4) {
					System.out.printf(" |__   _|");
				}
				if(countStart == 5) {
					System.out.printf("    | |  ");
				}
				if(countStart == 6) {
					System.out.printf("    |_|  ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("5")) {
				if(countStart == 1) {
					System.out.printf("  _____ ");
				}
				if(countStart == 2) {
					System.out.printf(" | ____|");
				}
				if(countStart == 3) {
					System.out.printf(" | |__  ");
				}
				if(countStart == 4) {
					System.out.printf(" |___ \\ ");
				}
				if(countStart == 5) {
					System.out.printf("  ___) |");
				}
				if(countStart == 6) {
					System.out.printf(" |____/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("6")) {
				if(countStart == 1) {
					System.out.printf("    __  ");
				}
				if(countStart == 2) {
					System.out.printf("   / /  ");
				}
				if(countStart == 3) {
					System.out.printf("  / /_  ");
				}
				if(countStart == 4) {
					System.out.printf(" | '_ \\ ");
				}
				if(countStart == 5) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("7")) {
				if(countStart == 1) {
					System.out.printf("  ______ ");
				}
				if(countStart == 2) {
					System.out.printf(" |____  |");
				}
				if(countStart == 3) {
					System.out.printf("     / / ");
				}
				if(countStart == 4) {
					System.out.printf("    / /  ");
				}
				if(countStart == 5) {
					System.out.printf("   / /   ");
				}
				if(countStart == 6) {
					System.out.printf("  /_/    ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("8")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 4) {
					System.out.printf("  > _ < ");
				}
				if(countStart == 5) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("9")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 4) {
					System.out.printf("  \\__, |");
				}
				if(countStart == 5) {
					System.out.printf("    / / ");
				}
				if(countStart == 6) {
					System.out.printf("   /_/  ");
				}
			}
			if(String.valueOf(cARDGAMENUM).startsWith("0")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | | | |");
				}
				if(countStart == 4) {
					System.out.printf(" | | | |");
				}
				if(countStart == 5) {
					System.out.printf(" | |_| |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			/////////////////////////////////////////////////////////////////////////
			if(String.valueOf(cARDGAMENUM).endsWith("1")) {
				if(countStart == 1) {
					System.out.printf("  __ ");
				}
				if(countStart == 2) {
					System.out.printf(" /_ |");
				}
				if(countStart == 3) {
					System.out.printf("  | |");
				}
				if(countStart == 4) {
					System.out.printf("  | |");
				}
				if(countStart == 5) {
					System.out.printf("  | |");
				}
				if(countStart == 6) {
					System.out.printf("  |_|");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("2")) {
				if(countStart == 1) {
					System.out.printf("  ___  ");
				}
				if(countStart == 2) {
					System.out.printf(" |__ \\ ");
				}
				if(countStart == 3) {
					System.out.printf("    ) |");
				}
				if(countStart == 4) {
					System.out.printf("   / / ");
				}
				if(countStart == 5) {
					System.out.printf("  / /_ ");
				}
				if(countStart == 6) {
					System.out.printf(" |____|");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("3")) {
				if(countStart == 1) {
					System.out.printf("  ____  ");
				}
				if(countStart == 2) {
					System.out.printf(" |___ \\ ");
				}
				if(countStart == 3) {
					System.out.printf("   __) |");
				}
				if(countStart == 4) {
					System.out.printf("  |__ < ");
				}
				if(countStart == 5) {
					System.out.printf("  ___) |");
				}
				if(countStart == 6) {
					System.out.printf(" |____/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("4")) {
				if(countStart == 1) {
					System.out.printf("  _  _   ");
				}
				if(countStart == 2) {
					System.out.printf(" | || |  ");
				}
				if(countStart == 3) {
					System.out.printf(" | || |_ ");
				}
				if(countStart == 4) {
					System.out.printf(" |__   _|");
				}
				if(countStart == 5) {
					System.out.printf("    | |  ");
				}
				if(countStart == 6) {
					System.out.printf("    |_|  ");
				}

			}
			if(String.valueOf(cARDGAMENUM).endsWith("5")) {
				if(countStart == 1) {
					System.out.printf("  _____ ");
				}
				if(countStart == 2) {
					System.out.printf(" | ____|");
				}
				if(countStart == 3) {
					System.out.printf(" | |__  ");
				}
				if(countStart == 4) {
					System.out.printf(" |___ \\ ");
				}
				if(countStart == 5) {
					System.out.printf("  ___) |");
				}
				if(countStart == 6) {
					System.out.printf(" |____/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("6")) {
				if(countStart == 1) {
					System.out.printf("    __  ");
				}
				if(countStart == 2) {
					System.out.printf("   / /  ");
				}
				if(countStart == 3) {
					System.out.printf("  / /_  ");
				}
				if(countStart == 4) {
					System.out.printf(" | '_ \\ ");
				}
				if(countStart == 5) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("7")) {
				if(countStart == 1) {
					System.out.printf("  ______ ");
				}
				if(countStart == 2) {
					System.out.printf(" |____  |");
				}
				if(countStart == 3) {
					System.out.printf("     / / ");
				}
				if(countStart == 4) {
					System.out.printf("    / /  ");
				}
				if(countStart == 5) {
					System.out.printf("   / /   ");
				}
				if(countStart == 6) {
					System.out.printf("  /_/    ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("8")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 4) {
					System.out.printf("  > _ < ");
				}
				if(countStart == 5) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("9")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | (_) |");
				}
				if(countStart == 4) {
					System.out.printf("  \\__, |");
				}
				if(countStart == 5) {
					System.out.printf("    / / ");
				}
				if(countStart == 6) {
					System.out.printf("   /_/  ");
				}
			}
			if(String.valueOf(cARDGAMENUM).endsWith("0")) {
				if(countStart == 1) {
					System.out.printf("   ___  ");
				}
				if(countStart == 2) {
					System.out.printf("  / _ \\ ");
				}
				if(countStart == 3) {
					System.out.printf(" | | | |");
				}
				if(countStart == 4) {
					System.out.printf(" | | | |");
				}
				if(countStart == 5) {
					System.out.printf(" | |_| |");
				}
				if(countStart == 6) {
					System.out.printf("  \\___/ ");
				}
			}
			System.out.println("");
			countStart++;	
		}
	}


	private static void dealerBust() {
		System.out.printf("\t\t\t\t\t\t\t\t\t______           _            ______           _   _ _ _ _ _ _ \n"
				+ "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | ___ \\         | | | | | | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |_/ /_   _ ___| |_| | | | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| | ___ \\ | | / __| __| | | | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    | |_/ / |_| \\__ \\ |_|_|_|_|_|_|_|\n"
				+ "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|    \\____/ \\__,_|___/\\__(_|_|_|_|_|_)\n"
				+ "");

	}

	private static void printDealerwin() {
		System.out.printf("\t\t\t\t\t\t\t\t\t______           _             _    _             \n"
				+ "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | |  | |            \n"
				+ "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |  | | ___  _ __  \n"
				+ "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| | |/\\| |/ _ \\| '_ \\ \n"
				+ "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    \\  /\\  / (_) | | | |\n"
				+ "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|     \\/  \\/ \\___/|_| |_|\n");

	}

	private static void WinningPrints() {
		int i = 1;
		i = IR4.getRandomNumber(1, 3);
		if (i == 1) {
			System.out.printf("\t\t\t\t\t\t\t\t\t\t         _________ _        _        _______  _______ \n\t\t\t\t\t\t\t\t\t\t|\\     /|\\__   __/( (    /|( (    /|(  ____ \\(  ____ )\n"
					+ "\t\t\t\t\t\t\t\t\t\t| )   ( |   ) (   |  \\  ( ||  \\  ( || (    \\/| (    )|\n\t\t\t\t\t\t\t\t\t\t| | _ | |   | |   |   \\ | ||   \\ | || (__    | (____)|\n"
					+ "\t\t\t\t\t\t\t\t\t\t| |( )| |   | |   | (\\ \\) || (\\ \\) ||  __)   |     __)\n"
					+ "\t\t\t\t\t\t\t\t\t\t| || || |   | |   | | \\   || | \\   || (      | (\\ (   \n"
					+ "\t\t\t\t\t\t\t\t\t\t| () () |___) (___| )  \\  || )  \\  || (____/\\| ) \\ \\__\n"
					+ "\t\t\t\t\t\t\t\t\t\t(_______)\\_______/|/    )_)|/    )_)(_______/|/   \\__/\n");
		}
		if (i == 2) {
			System.out.printf("\t\t\t\t\t\t\t\t\t      ___                       ___           ___           ___           ___     \n"
					+ "\t\t\t\t\t\t\t\t\t     /\\__\\          ___        /\\__\\         /\\__\\         /\\  \\         /\\  \\    \n"
					+ "\t\t\t\t\t\t\t\t\t    /:/ _/_        /\\  \\      /::|  |       /::|  |       /::\\  \\       /::\\  \\   \n"
					+ "\t\t\t\t\t\t\t\t\t   /:/ /\\__\\       \\:\\  \\    /:|:|  |      /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\  \n"
					+ "\t\t\t\t\t\t\t\t\t  /:/ /:/ _/_      /::\\__\\  /:/|:|  |__   /:/|:|  |__   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n"
					+ "\t\t\t\t\t\t\t\t\t /:/_/:/ /\\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/ |:| /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n"
					+ "\t\t\t\t\t\t\t\t\t \\:\\/:/ /:/  / /\\/:/  /    \\/__|:|/:/  / \\/__|:|/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n"
					+ "\t\t\t\t\t\t\t\t\t  \\::/_/:/  /  \\::/__/         |:/:/  /      |:/:/  /   \\:\\ \\:\\__\\      |:|::/  / \n"
					+ "\t\t\t\t\t\t\t\t\t   \\:\\/:/  /    \\:\\__\\         |::/  /       |::/  /     \\:\\ \\/__/      |:|\\/__/  \n"
					+ "\t\t\t\t\t\t\t\t\t    \\::/  /      \\/__/         /:/  /        /:/  /       \\:\\__\\        |:|  |    \n"
					+ "\t\t\t\t\t\t\t\t\t     \\/__/                     \\/__/         \\/__/         \\/__/         \\|__|    \n");

		}
		if (i == 3) {
			System.out.printf("\t\t\t\t\t\t\t\t\t\t.------..------..------..------..------..------.\n"
					+ "\t\t\t\t\t\t\t\t\t\t|W.--. ||I.--. ||N.--. ||N.--. ||E.--. ||R.--. |\n"
					+ "\t\t\t\t\t\t\t\t\t\t| :/\\: || (\\/) || :(): || :(): || (\\/) || :(): \n"
					+ "\t\t\t\t\t\t\t\t\t\t| :\\/: || :\\/: || ()() || ()() || :\\/: || ()() |\n"
					+ "\t\t\t\t\t\t\t\t\t\t| '--'W|| '--'I|| '--'N|| '--'N|| '--'E|| '--'R|\n"
					+ "\t\t\t\t\t\t\t\t\t\t`------'`------'`------'`------'`------'`------'\n");

		}
		/////////////////////////////////////////		

	}

	private static int getMove() {
		int move;
		boolean run = true;
		do{
			System.out.printf("\t\t\t\t\t\t\t\t1. Hit\n");
			System.out.printf("\t\t\t\t\t\t\t\t2. Stand\n");

			move = IR4.getInteger("3. Quit");
			if(move != 1 && move != 2 && move != 3) {
				System.out.printf("\t\t\t\t\t\t\t\tInvald input\n");
				run = true;
			}

		}while(!run);
		return move;
	}

	private static double placeBets(double score) {


		double temp = IR4.getDouble("Places Bets");
		boolean run = true;
		while(run) {
			if(temp <= score && temp > 0) {
				run = false;
				return temp;
			}
			else {
				System.out.printf("\t\t\t\t\t\t\t\tInvald input\n");
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
		System.out.printf("\t\t\t\t\t\t\t\t%35s\n", "Settings" );
		System.out.println("\t\t\t\t\t\t\t\t1. Change currency \n"+ 							 
				"\t\t\t\t\t\t\t\t2. Change Alias \n" +
				"\t\t\t\t\t\t\t\t3. Back");

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
		System.out.printf("\t\t\t\t\t\t\t\t%31s\n", "Change currency");
		System.out.println("\t\t\t\t\t\t\t\tCurrent currency: " + 
				ProjectFileIO_v2.getPlayer(username, passwd).getCurrency());
		System.out.println("\t\t\t\t\t\t\t\tEnter new currency name or enter 'q' to go back");
		String newCurrency = input.next();
		System.out.println();
		ProjectFileIO_v2.getPlayer(username, passwd).setCurrency(newCurrency);
		System.out.println("\t\t\t\t\t\t\t\tCurrency successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
	}

	static void changeAlias() throws IOException, InterruptedException {
		ProjectFileIO_v2.readFile();
		String newAlias = "";
		System.out.printf("%31s\n", "Change alias");
		System.out.println("Enter new name");
		newAlias = input.next();
		ProjectFileIO_v2.getPlayer(username, passwd).setName(newAlias);
		System.out.println("Alias successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
	}

	static void displayStats() throws IOException, InterruptedException {
		System.out.printf("\t\t\t\t\t\t\t\t%20s", "Statistics\n");
		System.out.println("\t\t\t\t\t\t\t\tWins: " + ProjectFileIO_v2.getPlayer(username, passwd).getWins() +"\n" + 
				"\t\t\t\t\t\t\t\tLoses: " + ProjectFileIO_v2.getPlayer(username, passwd).getWins() + "\n" +
				"\t\t\t\t\t\t\t\tExtreme rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getExtremeRounds() + "\n" +
				"\t\t\t\t\t\t\t\tFight Night rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getFnRounds() + "\n" +
				"\t\t\t\t\t\t\t\tNot BlackJack rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getnBJRounds() + "\n" +
				"\t\t\t\t\t\t\t\tFor Fire rounds: " + ProjectFileIO_v2.getPlayer(username, passwd).getFfRounds() + "\n" +
				"\t\t\t\t\t\t\t\tBlackjacks: " + ProjectFileIO_v2.getPlayer(username, passwd).getbJCount() + "\n" +
				"\t\t\t\t\t\t\t\tCredits earned: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsEarned() + "\n" +
				"\t\t\t\t\t\t\t\tCredits lost: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsLost() + "\n" +
				"\t\t\t\t\t\t\t\tCredits lost: " + ProjectFileIO_v2.getPlayer(username, passwd).getCreditsLost() + "\n" +
				"\t\t\t\t\t\t\t\tHighest credit : " + ProjectFileIO_v2.getPlayer(username, passwd).getHighestCredits() + "\n" +
				"\t\t\t\t\t\t\t\tBankruptcies: " + ProjectFileIO_v2.getPlayer(username, passwd).getBankRuptcies() + "\n" +
				"\t\t\t\t\t\t\t\tPress q to go back");
		if(pressQ().equals("q"))
			displayMenu();
	}

	static void displayHOF() {
		System.out.println("\t\t\t\t\t\t\t\t<=================== HALL OF FAME ===================>\n");
		System.out.printf("\t\t\t\t\t\t\t\t%-20s%33s\n", "Hustler:", "Wins:");
		System.out.printf("\t\t\t\t\t\t\t\t%-20s%27c%3s\n\n", "--------", ' ', "------");
		/*************************
		Things to add:
		Create a player int array[10]
		Call GetArrayList();
		Highest to lowest insertion sort
		Player.getWins();
		 *************************/
		for(Player x: ProjectFileIO_v2.getPlayerArrayList()) {
			scores.add(x.getWins());
			System.out.printf("\t\t\t\t\t\t\t\t"+x.getName() +"\t\t\t\t\t\t"+ x.getWins()+"\n");
		}

	}

	//	static Integer[] returnWins(ArrayList<Player> arr) {
	//		//Return an Integer Arraylist of scores
	//		Integer [] wins = new Integer[10];
	//		for(Player x: ProjectFileIO_v2.getPlayerArrayList()) { 
	//			//wins[] = 
	//			System.out.printf("%-50s%-5d\n", x.getName(), x.getWins());
	//		}
	//		return wins;
	//	}

	public static void sortHighScores(Integer [] arr) {
		Arrays.sort(arr, Collections.reverseOrder());

	}

	static void displayCredits() throws InterruptedException, IOException {

		System.out.println("\t\t\t\t\t\t\t\t***********************************");
		System.out.println("\t\t\t\t\t\t\t\tBlackjack Extreme " + "v" +ProjectFileIO_v2.getVersionNumber());
		System.out.println("\t\t\t\t\t\t\t\tAuthors:");
		System.out.println("\t\t\t\t\t\t\t\tLuis Gascon"); 
		System.out.println("\t\t\t\t\t\t\t\tAustin Connick");
		System.out.println("\t\t\t\t\t\t\t\t***********************************");
		Thread.sleep(6000); 
		displayMenu();

	}

	static void displayThanks() {
		//Displays a thank you message when user quits 
		//Create an ASCII art 
		System.out.println("\t\t\t\t\t\t\t\tThank you for playing :)");
	}


	static int getChoice() {
		int choice = input.nextInt();
		return choice;
	}

	static String pressQ() {
		String q = input.next();
		while(!q.equals("q")) {
			System.out.println("\t\t\t\t\t\t\t\tEnter q to quit");
			q = input.next();
		}
		return q;
	}

}