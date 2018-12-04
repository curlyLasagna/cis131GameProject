//package blackjackbuildone;
//
//import java.io.IOException;
//
//public class MainGame {
//	 private static void mainGame() throws IOException {
//		  double score = 1500;
//		  int lost = 0;
//		  double bet = 0;
//		  boolean run = true;
//		  int move;
//		  int numberDraws = 2;
//		  int drawFactor = 8; 
//		  int compHit = 16;
//		  int CARDGAMENUM = 21;
//		  boolean runTwo = true;
//		  while(runTwo) {
//		   Deck playingDeck = new Deck();
//		   Deck PlayerHand = new Deck();
//		   Deck CompHand = new Deck();
//		   playingDeck.createDeck();
//		   playingDeck.shuffle();
//		   CARDGAMENUM = IR4.getRandomNumber(21, 61);
//		   compHit = CARDGAMENUM - 6 ;
//		   System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\tMoney = "+score+"\n");
//		   printWiningscore(CARDGAMENUM);
//		   if(score <= 0) {
//		    runTwo = false;
//		    run = false;
//		     bankRuptcies++;
//		     ProjectFileIO_v2.writeFile();
//		    ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
//		   }
//		   if(score > 0) {
//		   bet = placeBets(score);
//		   }
//		   numberDraws = CARDGAMENUM /drawFactor;
//		   for(int i = 1; i<= numberDraws; i++) {
//		    PlayerHand.draw(playingDeck);
//		   }
//		   for(int i = 2; i< numberDraws; i++) {
//		    CompHand.draw(playingDeck);
//		   }
//		   CompHand.draw(playingDeck);
//		   if(score <= 0) {
//		    runTwo = false;
//		    run = false;
//		     bankRuptcies++;
//		     ProjectFileIO_v2.writeFile();
//		    ProjectFileIO_v2.getPlayer(username, passwd).setBankRuptcies(bankRuptcies);
//		   }
//
//		   run = true;
//		   while(run) {
//		    dividers();
//		    System.out.printf("\t\t\t\t\t\t\t\t\t\t\tWin- "+ wins+"  Lost- "+lost+"\n");
//		    dividers();
//		    printdealerHand();
//		    dividers();
//		    System.out.println(CompHand.toString());
//		    dividers();
//
//		    printHand();
//		    System.out.printf(PlayerHand.toString());
//		    dividers();
//		    printSum();
//		    dividers();
//		    System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		    dividers();
//		    if(PlayerHand.cardValue() > CARDGAMENUM) {
//		    	dividers();
//		        bustprint();
//		        dividers();
//		        lost = lost + 1;
//		        score = score - bet;
//		        creditsLost = (int) (creditsLost + bet);
//		    	run = false;
//		    	
//		    }
//		    ////////////////////////////////21/insta win////////////////////////////////////////////////
//		    if(PlayerHand.cardValue() == CARDGAMENUM) {
//		     System.out.println(CARDGAMENUM);
//		     dividers();
//		     printdealerHand();
//		     dividers();
//		     System.out.println(CompHand.toString());
//		     dividers();
//
//		     printHand();
//		     System.out.printf(PlayerHand.toString());
//		     dividers();
//		     printSum();
//		     dividers();
//		     System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		     dividers();
//		     WinningPrints();
//		     run = false;
//		    }
//
//		    move = getMove();
//		    ////////////////////Quit Add Save Stuff Here?/////////////////////////////////////////////////////////
//		    if(move == 3) {
//		     run = false;
//		     runTwo = false;
//		     ProjectFileIO_v2.writeFile();
//		     ProjectFileIO_v2.getPlayer(username, passwd).setWins(wins);
//		     ProjectFileIO_v2.getPlayer(username, passwd).setCreditsEarned(creditsEarned);
//		     ProjectFileIO_v2.getPlayer(username, passwd).setCreditsLost(creditsLost);
//		     
//		     
//		    }
//
//		    ////////////////////////////Hit/////////////////////////////////////////////////////////////////
//		    if(move == 1) {
//		     PlayerHand.draw(playingDeck);
//		     if(PlayerHand.cardValue() > CARDGAMENUM) {
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      bustprint();
//		      dividers();
//		      lost = lost + 1;
//		      score = score - bet;
//		      creditsLost = (int) (creditsLost + bet);
//		      //System.out.println(score);
//		      run = false;
//		     }
//		     //////////////////////////////////////21////////////////////////////////////
//		     if(PlayerHand.cardValue() == CARDGAMENUM) {
//		      System.out.println(CARDGAMENUM);
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      WinningPrints();
//		      score = score + bet;
//		      run = false;
//		     }
//		     if(CompHand.cardValue() > CARDGAMENUM) {
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      dealerBust();
//		      dividers();
//		      WinningPrints();
//		      dividers();
//		      wins =  wins + 1;
//		      score = score + bet;
//		      creditsEarned = (int) (creditsEarned + bet);
//		      //System.out.println(score);
//		      run = false;
//		     }
//
//
//		    }
//		    /////////////////////////////////////////////Stand//////////////////////////////////////////////
//		    if(move == 2) {
//		     run = false;
//		     /////////////////////////////////////////////AI///////////////////////////////////////
//		     while(CompHand.cardValue() <= compHit) {
//		      CompHand.draw(playingDeck);
//		     }
//		     /////////////////////////////////////////Rest menu//////////////////
//		     dividers();
//		     printdealerHand();
//		     dividers();
//		     System.out.println(CompHand.toString());
//		     dividers();
//
//		     printHand();
//		     System.out.printf(PlayerHand.toString());
//		     dividers();
//		     printSum();
//		     dividers();
//		     System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		     dividers();
//		     WinningPrints();
//		     dividers();
//		     /////////////////////////////////////////////////Player wins//////////////////////////////////////////////////////////////////////////////////
//		     if(CompHand.cardValue() <= PlayerHand.cardValue()&& PlayerHand.cardValue() <= CARDGAMENUM) {
//
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      WinningPrints();
//		      dividers();
//		      wins =  wins + 1;
//		      score =score  + bet;
//		       creditsEarned = (int) (creditsEarned + bet);
//		      System.out.println(score);
//
//		     }
//		     ////////////////////////////////////////////////////////AI wins////////////////////////////////////////////
//		     if(CompHand.cardValue() >= PlayerHand.cardValue() && CompHand.cardValue() <= CARDGAMENUM) {
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      printDealerwin();
//		      dividers();
//		      lost = lost + 1;
//		      score =score  - bet;
//		      System.out.println(score);
//		     }
//		     ////////////////////////////AI Bust///////////////////////////////////
//		     if(CompHand.cardValue() >  CARDGAMENUM) {
//		      dividers();
//		      printdealerHand();
//		      dividers();
//		      System.out.println(CompHand.toString());
//		      dividers();
//
//		      printHand();
//		      System.out.printf(PlayerHand.toString());
//		      dividers();
//		      printSum();
//		      dividers();
//		      System.out.print("\t\t\t\t\t\t\t\t\t\tComputer: "+CompHand.cardValue()+"     "+username + ": "+PlayerHand.cardValue()+"\t\tWinnig Number: "+ CARDGAMENUM +"\n");
//		      dividers();
//		      dealerBust();
//		      dividers();
//		      WinningPrints();
//		      dividers();
//		      wins =  wins +1;
//		      score = score + bet;
//		      run = false;
//
//
//		     }
//		    }   
//		   }
//
//		  }
//		  try {
//		   displayMenu();
//		  } catch (IOException e) {
//		   // TODO Auto-generated catch block
//		   e.printStackTrace();
//		  } catch (InterruptedException e) {
//		   // TODO Auto-generated catch block
//		   e.printStackTrace();
//		  }
//
//		 }
//
//		 private static void printHand() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t\t\t _   _                 _ \n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| | | |               | |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| |_| | __ _ _ __   __| |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t|  _  |/ _` | '_ \\ / _` |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| | | | (_| | | | | (_| |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t\\_| |_/\\__,_|_| |_|\\__,_|\n");
//
//
//		 }
//
//		 private static void bustprint() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t\t\t______           _   _ _ _ _ \n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| ___ \\         | | | | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| |_/ /_   _ ___| |_| | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| ___ \\ | | / __| __| | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t| |_/ / |_| \\__ \\ |_|_|_|_|_|\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t\\____/ \\__,_|___/\\__(_|_|_|_)\n");
//
//		 }
//
//		 private static void dividers() {
//		  System.out.printf("\t\t\t\t\t\t\t\t***********************************************************************************\n");
//
//		 }
//
//		 private static void printSum() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t\t\t _____                 \n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t/  ___|                \n"
//		    +"\t\t\t\t\t\t\t\t\t\t\t\\ `--. _   _ _ __ ___  \n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t `--. \\ | | | '_ ` _ \\ \n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t/\\__/ / |_| | | | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t\t\t\\____/ \\__,_|_| |_| |_|\n");
//
//		 }
//
//		 private static void printdealerHand() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t______           _             _   _                 _ \n"
//		    + "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | | | |               | |\n"
//		    + "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |_| | __ _ _ __   __| |\n"
//		    + "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| |  _  |/ _` | '_ \\ / _` |\n"
//		    + "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    | | | | (_| | | | | (_| |\n"
//		    + "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|    \\_| |_/\\__,_|_| |_|\\__,_|\n");
//
//		 }
//
//		 private static void printWiningscore(int cARDGAMENUM) {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t _    _ _             _               _   _                 _ \n"
//		    + "\t\t\t\t\t\t\t\t\t| |  | (_)           (_)             | | | |               | |\n"
//		    + "\t\t\t\t\t\t\t\t\t| |  | |_ _ __  _ __  _ _ __   __ _  | |_| | __ _ _ __   __| |\n"
//		    + "\t\t\t\t\t\t\t\t\t| |/\\| | | '_ \\| '_ \\| | '_ \\ / _` | |  _  |/ _` | '_ \\ / _` |\n"
//		    + "\t\t\t\t\t\t\t\t\t\\  /\\  / | | | | | | | | | | | (_| | | | | | (_| | | | | (_| |\n"
//		    + "\t\t\t\t\t\t\t\t\t \\/  \\/|_|_| |_|_| |_|_|_| |_|\\__, | \\_| |_/\\__,_|_| |_|\\__,_|\n"
//		    + "\t\t\t\t\t\t\t\t\t                               __/ |                          \n"
//		    + "\t\t\t\t\t\t\t\t\t                              |___/                           \n");
//		  dividers();
//		  NumberPrinter(cARDGAMENUM);
//		  dividers();
//		 }
//
//		 private static void NumberPrinter(int cARDGAMENUM) {
//		  /////////////////////////////////////////////////////////////////////////////
//		  int countStart = 1;
//		  int lines = 6;
//		  for(int i = 0; i < lines; i++) {
//		   System.out.printf("\t\t\t\t\t\t\t\t\t\t\t\t");
//		   if(String.valueOf(cARDGAMENUM).startsWith("1")) {
//		    if(countStart == 1) {
//		     System.out.printf("  __ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" /_ |");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  |_|");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("2")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |__ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("    ) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("   / / ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  / /_ ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____|");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("3")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ____  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |___ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("   __) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  |__ < ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  ___) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("4")) {
//		    if(countStart == 1) {
//		     System.out.printf("  _  _   ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" | || |  ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | || |_ ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" |__   _|");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("    | |  ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("    |_|  ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("5")) {
//		    if(countStart == 1) {
//		     System.out.printf("  _____ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" | ____|");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | |__  ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" |___ \\ ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  ___) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("6")) {
//		    if(countStart == 1) {
//		     System.out.printf("    __  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("   / /  ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("  / /_  ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" | '_ \\ ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("7")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ______ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |____  |");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("     / / ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("    / /  ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("   / /   ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  /_/    ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("8")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  > _ < ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("9")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  \\__, |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("    / / ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("   /_/  ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).startsWith("0")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | | | |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" | | | |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | |_| |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   /////////////////////////////////////////////////////////////////////////
//		   if(String.valueOf(cARDGAMENUM).endsWith("1")) {
//		    if(countStart == 1) {
//		     System.out.printf("  __ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" /_ |");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  | |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  |_|");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("2")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |__ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("    ) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("   / / ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  / /_ ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____|");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("3")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ____  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |___ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("   __) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  |__ < ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  ___) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("4")) {
//		    if(countStart == 1) {
//		     System.out.printf("  _  _   ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" | || |  ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | || |_ ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" |__   _|");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("    | |  ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("    |_|  ");
//		    }
//
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("5")) {
//		    if(countStart == 1) {
//		     System.out.printf("  _____ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" | ____|");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | |__  ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" |___ \\ ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("  ___) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf(" |____/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("6")) {
//		    if(countStart == 1) {
//		     System.out.printf("    __  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("   / /  ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("  / /_  ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" | '_ \\ ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("7")) {
//		    if(countStart == 1) {
//		     System.out.printf("  ______ ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf(" |____  |");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf("     / / ");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("    / /  ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("   / /   ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  /_/    ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("8")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  > _ < ");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("9")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | (_) |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf("  \\__, |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf("    / / ");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("   /_/  ");
//		    }
//		   }
//		   if(String.valueOf(cARDGAMENUM).endsWith("0")) {
//		    if(countStart == 1) {
//		     System.out.printf("   ___  ");
//		    }
//		    if(countStart == 2) {
//		     System.out.printf("  / _ \\ ");
//		    }
//		    if(countStart == 3) {
//		     System.out.printf(" | | | |");
//		    }
//		    if(countStart == 4) {
//		     System.out.printf(" | | | |");
//		    }
//		    if(countStart == 5) {
//		     System.out.printf(" | |_| |");
//		    }
//		    if(countStart == 6) {
//		     System.out.printf("  \\___/ ");
//		    }
//		   }
//		   System.out.println("");
//		   countStart++; 
//		  }
//		 }
//
//
//		 private static void dealerBust() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t______           _            ______           _   _ _ _ _ _ _ \n"
//		    + "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | ___ \\         | | | | | | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |_/ /_   _ ___| |_| | | | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| | ___ \\ | | / __| __| | | | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    | |_/ / |_| \\__ \\ |_|_|_|_|_|_|_|\n"
//		    + "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|    \\____/ \\__,_|___/\\__(_|_|_|_|_|_)\n"
//		    + "");
//
//		 }
//
//		 private static void printDealerwin() {
//		  System.out.printf("\t\t\t\t\t\t\t\t\t______           _             _    _             \n"
//		    + "\t\t\t\t\t\t\t\t\t|  _  \\         | |           | |  | |            \n"
//		    + "\t\t\t\t\t\t\t\t\t| | | |___  __ _| | ___ _ __  | |  | | ___  _ __  \n"
//		    + "\t\t\t\t\t\t\t\t\t| | | / _ \\/ _` | |/ _ \\ '__| | |/\\| |/ _ \\| '_ \\ \n"
//		    + "\t\t\t\t\t\t\t\t\t| |/ /  __/ (_| | |  __/ |    \\  /\\  / (_) | | | |\n"
//		    + "\t\t\t\t\t\t\t\t\t|___/ \\___|\\__,_|_|\\___|_|     \\/  \\/ \\___/|_| |_|\n");
//
//		 }
//
//		 private static void WinningPrints() {
//		  int i = 1;
//		  i = IR4.getRandomNumber(1, 3);
//		  if (i == 1) {
//		   System.out.printf("\t\t\t\t\t\t\t\t\t\t         _________ _        _        _______  _______ \n\t\t\t\t\t\t\t\t\t\t|\\     /|\\__   __/( (    /|( (    /|(  ____ \\(  ____ )\n"
//		     + "\t\t\t\t\t\t\t\t\t\t| )   ( |   ) (   |  \\  ( ||  \\  ( || (    \\/| (    )|\n\t\t\t\t\t\t\t\t\t\t| | _ | |   | |   |   \\ | ||   \\ | || (__    | (____)|\n"
//		     + "\t\t\t\t\t\t\t\t\t\t| |( )| |   | |   | (\\ \\) || (\\ \\) ||  __)   |     __)\n"
//		     + "\t\t\t\t\t\t\t\t\t\t| || || |   | |   | | \\   || | \\   || (      | (\\ (   \n"
//		     + "\t\t\t\t\t\t\t\t\t\t| () () |___) (___| )  \\  || )  \\  || (____/\\| ) \\ \\__\n"
//		     + "\t\t\t\t\t\t\t\t\t\t(_______)\\_______/|/    )_)|/    )_)(_______/|/   \\__/\n");
//		  }
//		  if (i == 2) {
//		   System.out.printf("\t\t\t\t\t\t\t\t\t      ___                       ___           ___           ___           ___     \n"
//		     + "\t\t\t\t\t\t\t\t\t     /\\__\\          ___        /\\__\\         /\\__\\         /\\  \\         /\\  \\    \n"
//		     + "\t\t\t\t\t\t\t\t\t    /:/ _/_        /\\  \\      /::|  |       /::|  |       /::\\  \\       /::\\  \\   \n"
//		     + "\t\t\t\t\t\t\t\t\t   /:/ /\\__\\       \\:\\  \\    /:|:|  |      /:|:|  |      /:/\\:\\  \\     /:/\\:\\  \\  \n"
//		     + "\t\t\t\t\t\t\t\t\t  /:/ /:/ _/_      /::\\__\\  /:/|:|  |__   /:/|:|  |__   /::\\~\\:\\  \\   /::\\~\\:\\  \\ \n"
//		     + "\t\t\t\t\t\t\t\t\t /:/_/:/ /\\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/ |:| /\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\\n"
//		     + "\t\t\t\t\t\t\t\t\t \\:\\/:/ /:/  / /\\/:/  /    \\/__|:|/:/  / \\/__|:|/:/  / \\:\\~\\:\\ \\/__/ \\/_|::\\/:/  /\n"
//		     + "\t\t\t\t\t\t\t\t\t  \\::/_/:/  /  \\::/__/         |:/:/  /      |:/:/  /   \\:\\ \\:\\__\\      |:|::/  / \n"
//		     + "\t\t\t\t\t\t\t\t\t   \\:\\/:/  /    \\:\\__\\         |::/  /       |::/  /     \\:\\ \\/__/      |:|\\/__/  \n"
//		     + "\t\t\t\t\t\t\t\t\t    \\::/  /      \\/__/         /:/  /        /:/  /       \\:\\__\\        |:|  |    \n"
//		     + "\t\t\t\t\t\t\t\t\t     \\/__/                     \\/__/         \\/__/         \\/__/         \\|__|    \n");
//
//		  }
//		  if (i == 3) {
//		   System.out.printf("\t\t\t\t\t\t\t\t\t\t.------..------..------..------..------..------.\n"
//		     + "\t\t\t\t\t\t\t\t\t\t|W.--. ||I.--. ||N.--. ||N.--. ||E.--. ||R.--. |\n"
//		     + "\t\t\t\t\t\t\t\t\t\t| :/\\: || (\\/) || :(): || :(): || (\\/) || :(): \n"
//		     + "\t\t\t\t\t\t\t\t\t\t| :\\/: || :\\/: || ()() || ()() || :\\/: || ()() |\n"
//		     + "\t\t\t\t\t\t\t\t\t\t| '--'W|| '--'I|| '--'N|| '--'N|| '--'E|| '--'R|\n"
//		     + "\t\t\t\t\t\t\t\t\t\t`------'`------'`------'`------'`------'`------'\n");
//
//		  }
//		  /////////////////////////////////////////  
//
//		 }
//
//		 private static int getMove() {
//		  int move;
//		  boolean run = true;
//		  do{
//		   System.out.printf("\t\t\t\t\t\t\t\t1. Hit\n");
//		   System.out.printf("\t\t\t\t\t\t\t\t2. Stand\n");
//
//		   move = IR4.getInteger("3. Quit");
//		   if(move != 1 && move != 2 && move != 3) {
//		    System.out.printf("\t\t\t\t\t\t\t\tInvald input\n");
//		    run = true;
//		   }
//
//		  }while(!run);
//		  return move;
//		 }
//
//		 private static double placeBets(double score) {
//
//
//		  double temp = IR4.getDouble("Places Bets");
//		  boolean run = true;
//		  while(run) {
//		   if(temp <= score && temp > 0) {
//		    run = false;
//		    return temp;
//		   }
//		   else {
//		    System.out.printf("\t\t\t\t\t\t\t\tInvald input\n");
//		    temp = IR4.getDouble("Places Bets");
//		    run = true;
//		   }
//		  }
//		  return temp;
//		 }
//
//
//}
