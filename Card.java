package blackjackbuildone;

public class Card {
	private String suit;
	private String value;
	public Card(String suit, String value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		

//		String top1 = " .-------.";
//        String top2 = " |       |";
//        String top3 = " |       |";
//        String top4 = " |       |";
//        String top5 = " |       |";
//        String top6 = " ._______.";
//
//        int[] personDice = new int[7];
//
//        for (int i = 0; i < personDice.length; i++) {
//            personDice[i] = i;
//
//        }
//        
//        for (int i = 0; i < 7; i++) {
//            for (int k = 0; k < 1; k++) {
//                if (i == 0) {
//                    System.out.print(top1 + "\t");
//                }
//                if(i == 1) {
//                	 String face;
//                             face = " |"+value+"     |";
//                             System.out.print(face + "\t");
//                }
//                if (i == 2) {
//                    System.out.print(top2 + "\t");
//                }
//                if (i == 3) {
//                    System.out.print(top3 + "\t");
//                }
//                if (i == 4) {
//                    System.out.print(top4 + "\t");
//                }
//                
//                if (i == 5) {
//                	 String face;
//                     face = " |     "+suit+"|";
//                     System.out.print(face + "\t");
//                }
//                if (i == 6) {
//                    System.out.print(top6 + "\t");
//                }
//            }
//            if (i != 7) {
//                System.out.println("");
//            }
//        }



    

    
     

	   	return " |"+value+"     |";

	}
}