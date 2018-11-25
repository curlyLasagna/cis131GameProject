package blackjackbuildone;

public class hand{
	public String Card;

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}
	public void CardDisplayCard() {
		String top1 = " .-------.";
        String top2 = " |       |";
        String top3 = " |_______|";

        int[] personDice = new int[5];

        for (int i = 0; i < personDice.length; i++) {
            personDice[i] = (int) (Math.random() * 6) + 1;

        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 5; k++) {
                if (i == 0) {
                    System.out.print(top1 + "\t");
                }
                if (i == 1) {
                    System.out.print(top2 + "\t");
                }
                if (i == 2) {
                    System.out.print(top3 + "\t");
                }
            }
            if (i != 3) {
                System.out.println("");
            }
        }

        decideFaceRowFour(personDice);

    }

    public static void decideFaceRowFour(int[] hand) {
        String face; 
        
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 1){
                face = "|       | |";
                System.out.print(face + "\t");
            }
            if(hand[i] == 2){
                face = "| o     | |";
                System.out.print(face + "\t");
            }
            if(hand[i] == 3){
                face = "| o     | |";
                System.out.print(face + "\t");
            }
            if(hand[i] == 4){
                face = "| o   o | |";
                System.out.print(face + "\t");
            }
            if(hand[i] == 5){
                face = "| o   o | |";
                System.out.print(face + "\t");
            }
            if(hand[i] == 6){
                face = "| o   o | |";
                System.out.print(face + "\t");
            }            
        }
    }
	}
