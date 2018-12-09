//Austin 
//Luis

import java.io.IOException;
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
 static Deck playingDeck = new Deck();
 static Deck PlayerHand = new Deck();
 static Deck CompHand = new Deck();
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
    " |        __       __                __       __                 __                 |\n" + 
    " |       |  |     |  |              |  |     (__)               |  |                |\n" +
    " |       |  |__   |  |  __ _    ___ |  | __   __   __  _    ___ |  | __             |\n" +
    " |       |  *   \\ |  |/  _` | /  __||  |/ /  |  |/  _ ` | /  __||  |/ /             |\n" +
    " |       |   |_) ||  |  (_| ||  (__ |    <   |  |  (_|  ||  (__ |    <              |\n" +
    " |       |__*__ / |__|\\ __'_| \\ ___||__|\\__\\ |  |\\ __ '_| \\ ___||__|\\__\\            |\n" +
    " |                                        __/   |                                   |\n" +
    " |                                       |_____/                                    |\n" +
    " |                  _______   _____________ ________  ________                      | \n" + 
    " |                 |  ___\\ \\ / /_   _| ___ \\  ___|  \\/  |  ___|                     | \n" + 
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
   mainGame();
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



 static void displayGame() {

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
    "Blackjacks: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getbJCount() + "\n" +
    "Credits earned: " + ProjectFileIO_v2.getPlayer(currentPlayer.getName(), passwd).getCreditsEarned() + "\n" +
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
    "        ___/                 ");
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
 static void mainGame() throws IOException {


  int bet = 0;
  boolean run = true;
  int move = 0;
  int numberDraws = 2;
  int drawFactor = 9; 
  int compHit = 16;
  int CARDGAMENUM = 21;
  boolean runTwo = true;


  while(runTwo) {
   ProjectFileIO_v2.writeFile();
   creditsEarned = ProjectFileIO_v2.getPlayer(username, passwd).getCreditsEarned();
   wins =  ProjectFileIO_v2.getPlayer(username, passwd).getWins();
   loses =  ProjectFileIO_v2.getPlayer(username, passwd).getLoses();








   if(creditsEarned <= 0) {
    System.out.println("Thank you for your For playing  have 1500 on us");
    creditsEarned = 1500;
    updateplayer();

   }

   playingDeck.createDeck();
   playingDeck.shuffle();
   CARDGAMENUM = IR4.getRandomNumber(20, 45);
   compHit = CARDGAMENUM - 6 ;
   System.out.printf("Money = "+creditsEarned+"\n");
   Print.printWiningscore(CARDGAMENUM);
   if(creditsEarned <= 0) {
    runTwo = false;
    run = false;
    bankRuptcies++;
    ProjectFileIO_v2.writeFile();
    ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
   }
   if(creditsEarned > 0) {
    bet = placeBets(creditsEarned);
   }
   numberDraws = CARDGAMENUM /drawFactor;
   for(int i = 1; i<= numberDraws; i++) {
    PlayerHand.draw(playingDeck);
   }
   for(int i = 2; i< numberDraws; i++) {
    CompHand.draw(playingDeck);
   }
   CompHand.draw(playingDeck);
   if(creditsEarned <= 0) {
    runTwo = false;
    run = false;
    bankRuptcies++;
    ProjectFileIO_v2.writeFile();
    ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
   }
   if(bet == 0) {
	     runTwo = false;
	     updateplayer();


	    }
   run = true;
   while(run && bet != 0) {
	  
	   
    Print.dividers();
    System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");
    screenprint(CARDGAMENUM);
    //////////////////////////////////////bust//////////////////////////////////////
    if(PlayerHand.cardValue() > CARDGAMENUM) {
     Print.dividers();
     Print.bustprint();
     Print.dividers();
     loses = loses + 1;
     creditsEarned = (creditsEarned - bet);
     PlayerHand.reset(playingDeck);
     CompHand.reset(playingDeck);
     run = false;

     updateplayer();
    }
    ////////////////////////////////21/insta win////////////////////////////////////////////////
    if(PlayerHand.cardValue() == CARDGAMENUM) {
     Print.dividers();
     Print.WinningPrints();
     PlayerHand.reset(playingDeck);
     CompHand.reset(playingDeck);
     wins = wins + 1;
     creditsEarned = (creditsEarned + bet);
     run = false;
     updateplayer();
     bJCount++;
     ProjectFileIO_v2.getPlayer(username, passwd).setbJCount(bJCount);
    }
if(run != false) {
    move = getMove();
}
    ////////////////////Quit Add Save/////////////////////////////////////////////////////////
//    if(move == 3) {
//     run = false;
//     runTwo = false;
//     updateplayer();
//
//
//    }

    ////////////////////////////Hit/////////////////////////////////////////////////////////////////
    if(move == 1 && run != false) {
     PlayerHand.draw(playingDeck);
     //////////////////////////////////////bust/////////////////////////
     if(PlayerHand.cardValue() > CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

      screenprint(CARDGAMENUM);
      Print.bustprint();
      loses = loses + 1;
      creditsEarned = (creditsEarned - bet);
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      run = false;
      updateplayer();
     }
     //////////////////////////////////////21////////////////////////////////////
     if(PlayerHand.cardValue() == CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

      screenprint(CARDGAMENUM);
      Print.WinningPrints();
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      creditsEarned = (creditsEarned + bet);
      run = false;
      updateplayer();
      bJCount++;
      ProjectFileIO_v2.getPlayer(username, passwd).setbJCount(bJCount);
      
     }
     ////////////////////////////////comp Win///////////////////////////////
     if(CompHand.cardValue() > CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

      screenprint(CARDGAMENUM);
      Print.dealerBust();
      Print.dividers();
      Print.WinningPrints();
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      Print.dividers();
      wins =  wins + 1;

      creditsEarned = (creditsEarned + bet);
      //System.out.println(score);
      run = false;
      updateplayer();
     }


    }
    /////////////////////////////////////////////Stand//////////////////////////////////////////////
    if(move == 2 && run != false) {
     run = false;
     /////////////////////////////////////////////AI///////////////////////////////////////
     while(CompHand.cardValue() <= compHit) {
      CompHand.draw(playingDeck);
     }
     /////////////////////////////////////////Rest menu//////////////////
     //       screenprint(CARDGAMENUM);
     //      
     //       Print.dividers();
     /////////////////////////////////////////////////Player wins//////////////////////////////////////////////////////////////////////////////////
     if(CompHand.cardValue() < PlayerHand.cardValue()&& PlayerHand.cardValue() <= CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");


      screenprint(CARDGAMENUM);
      Print.WinningPrints();
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      Print.dividers();
      wins =  wins + 1;

      creditsEarned = (creditsEarned + bet);
      System.out.println(creditsEarned);
      run = false;
      updateplayer();

     }
   
     ////////////////////////////////////////////////////////AI wins////////////////////////////////////////////
     else if(CompHand.cardValue() > PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

      screenprint(CARDGAMENUM);
      Print.printDealerwin();
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      Print.dividers();
      loses = loses + 1;
      creditsEarned = (creditsEarned - bet);
      System.out.println(creditsEarned);
      run = false;
      updateplayer();
     }
     ////////////////////////////AI Bust///////////////////////////////////
     if(CompHand.cardValue() >  CARDGAMENUM) {
      Print.dividers();
      System.out.printf("Win- "+ wins+"  Lost- "+loses+"\n");

      screenprint(CARDGAMENUM);
      Print.dealerBust();
      Print.dividers();
      Print.WinningPrints();
      PlayerHand.reset(playingDeck);
      CompHand.reset(playingDeck);
      Print.dividers();
      wins =  wins +1;
      creditsEarned = creditsEarned + bet;
      run = false;
      updateplayer();


     }
     /////////////////////////////////////draw///////////////////////////////////////////////////////////////
     if(CompHand.cardValue() == PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM && PlayerHand.cardValue() <= CARDGAMENUM && run != false) {
    	 screenprint(CARDGAMENUM);
    	 Print.Draw();
    	 Print.dividers();
    	 PlayerHand.reset(playingDeck);
         CompHand.reset(playingDeck);
         run = false;

     }
    }   
   }

  }
  try {
   Main.displayMenu();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (InterruptedException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

 }
 private static void updateplayer() throws IOException {
  ProjectFileIO_v2.writeFile();
  ProjectFileIO_v2.getPlayer(username, passwd).setWins(wins);
  ProjectFileIO_v2.getPlayer(username, passwd).setLoses(loses);
  ProjectFileIO_v2.getPlayer(username, passwd).setCreditsEarned(creditsEarned);
  ProjectFileIO_v2.getPlayer(username, passwd).setCreditsLost(creditsLost);


 }

 private static void screenprint(int CARDGAMENUM) {

  Print.dividers();
  Print.printdealerHand();
  Print.dividers();
  System.out.println(CompHand.toString());
  Print.dividers();
  Print.printHand();
  System.out.printf(PlayerHand.toString());
  Print.dividers();
  Print.printSum();
  Print.dividers();
  System.out.print("Computer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinning Number: "+ CARDGAMENUM +"\n");
  Print.dividers();


 }
 private static int getMove() {
  int move;
  boolean run = true;
  do{
   System.out.printf("1. Hit\n");
   //System.out.printf("2. Stand\n");

   move = IR4.getInteger("2. Stand");
   if(move != 1 && move != 2) {
    System.out.printf("Invald input\n");
    run = true;
   }

  }while(!run);
  return move;
 }

 private static int placeBets(int score) {


  int temp = IR4.getInteger("Places Bets or 0 to Quit");
  boolean run = true;
  while(run) {
   if(temp <= score && temp > 0) {
    run = false;
    return temp;
   }
  if(temp == 0) {
	   run = false;
	   return temp;
	   
   }
   else {
    System.out.printf("Invald input\n");
    temp = IR4.getInteger("Places Bets");
    run = true;
   }
  }
  return temp;
 }

}