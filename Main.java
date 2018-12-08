package blackjackbuildone;
//Austin 
//Luis

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
		}
		return quit;
	}
	
	static void displayPlay() throws IOException, InterruptedException {
		System.out.printf("%35s\n","Play");
		System.out.println("1. Extreme Blackjack!\n" +
						   "2. Back");
		switch(IR4.getIntegerBetweenLowAndHigh("", 1, 2, "Invalid input, try again")) {
		case 1:
			mainGame();
			break;
		case 2:
			displayMenu();
			break;
		}
	}
	
	static void displayGame() {
		
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
		if(newCurrency.equalsIgnoreCase("q"))
			displaySetting();
		else
		System.out.println();
		ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setCurrency(newCurrency);
		System.out.println("Currency successfully changed");
		ProjectFileIO_v2.writeFile();
		displaySetting();
	}
	
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

				if(newAlias.equalsIgnoreCase("q")) {
					displaySetting();
					break;
					}
				else {
					ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).setName(newAlias);
					currentPlayer.setName(newAlias);
					System.out.println("Alias successfully changed");
					ProjectFileIO_v2.writeFile();
					displaySetting();
					}
				}
			}
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
			System.out.printf("%-25s%27d\n",users[x] , scores[x]);
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
	
	static String pressQ() {
		String q = input.next();
		while(!q.equals("q")) {
			System.out.println("Enter q to quit");
			q = input.next();
		}
		return q;
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
   System.out.printf("Money = "+score+"\n");
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
    System.out.printf("Win- "+ wins+"  Lost- "+lost+"\n");
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
    System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
    dividers();
    if(PlayerHand.cardValue() > CARDGAMENUM) {
     dividers();
     bustprint();
     dividers();
     lost = lost + 1;
     score = score - bet;
     creditsLost = (int) (creditsLost + bet);
     run = false;

    }
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
     System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
      dividers();
      WinningPrints();
      score = score + bet;
      run = false;
     }
     ////////////////////////////////comp Win///////////////////////////////
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
     System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
      System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
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
   System.err.printf(" _   _                 _ \n"
    + "| | | |               | |\n"
    + "| |_| | __ _ _ __   __| |\n"
    + "|  _  |/ _` | '_ \\ / _` |\n"
    + "| | | | (_| | | | | (_| |\n"
    + "\\_| |_/\\__,_|_| |_|\\__,_|\n");


 }

 private static void bustprint() {
  System.err.printf("______           _   _ _ _ _ \n"
    + "| ___ \\         | | | | | | |\n"
    + "| |_/ /_   _ ___| |_| | | | |\n"
    + "| ___ \\ | | / __| __| | | | |\n"
    + "| |_/ / |_| \\__ \\ |_|_|_|_|_|\n"
    + "\\____/ \\__,_|___/\\__(_|_|_|_)\n");

 }

 private static void dividers() {
  System.out.printf("***********************************************************************************\n");

 }

 private static void printSum() {
   System.err.printf(" _____                 \n"
    + "/  ___|                \n"
    +"\\ `--. _   _ _ __ ___  \n"
    + " `--. \\ | | | '_ ` _ \\ \n"
    + "/\\__/ / |_| | | | | | |\n"
    + "\\____/ \\__,_|_| |_| |_|\n");

 }

 private static void printdealerHand() {
  System.err.printf("______           _             _   _                 _ \n"
    + "|  _  \\         | |           | | | |               | |\n"
    + "| | | |___  __ _| | ___ _ __  | |_| | __ _ _ __   __| |\n"
    + "| | | / _ \\/ _` | |/ _ \\ '__| |  _  |/ _` | '_ \\ / _` |\n"
    + "| |/ /  __/ (_| | |  __/ |    | | | | (_| | | | | (_| |\n"
    + "|___/ \\___|\\__,_|_|\\___|_|    \\_| |_/\\__,_|_| |_|\\__,_|\n");

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
  dividers();
  NumberPrinter(cARDGAMENUM);
  dividers();
 }

 private static void NumberPrinter(int cARDGAMENUM) {
  /////////////////////////////////////////////////////////////////////////////
  int countStart = 1;
  int lines = 6;
  for(int i = 0; i < lines; i++) {
   System.out.printf("");
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
  do{
   System.out.printf("1. Hit\n");
   System.out.printf("2. Stand\n");

   move = IR4.getInteger("3. Quit");
   if(move != 1 && move != 2 && move != 3) {
    System.out.printf("Invald input\n");
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
    System.out.printf("Invald input\n");
    temp = IR4.getDouble("Places Bets");
    run = true;
   }
  }
  return temp;
 }
}

