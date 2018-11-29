package blackjackbuildone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Deck{
	private List<Card>cards = new ArrayList<Card>();
	private String[] Suits = {"<3","<>","**","$$"};
	private String[] Value = {"2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ", "10" ,"A ","K ", "Q ","J "};
	public void createDeck() {

		for(int i=0;i<(Suits.length);i++){
			for(int j=0;j<(Value.length);j++){
				this.cards.add(new Card(Suits[i],Value[j])) ;
			}
		}
	}
	public void shuffle() {
		ArrayList<Card>Temp = new ArrayList<Card>();

		int randCard = 0;
		Random random = new Random();
		int size = this.cards.size();
		for(int i = 0; i<size;i++) {
			randCard = random.nextInt((this.cards.size()-1-0)+1)+0;
			Temp.add(this.cards.get(randCard));
			this.cards.remove(randCard);
		}
		this.cards = Temp;

	}


	public void removecard(int i) {
		this.cards.remove(i);
	}
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	public void draw(Deck From) {
		this.cards.add(From.getCard(0));
		From.removecard(0);
	}
	public int cardValue() {
		int totalValue = 0;
		int aces = 0;

		for(Card aCard : this.cards) {
			switch(aCard.getValue()) {
			case "2 " : totalValue += 2;break;
			case "3 " : totalValue += 3;break;
			case "4 " : totalValue += 4;break;
			case "5 " : totalValue += 5;break;
			case "6 " : totalValue += 6;break;
			case "7 " : totalValue += 7;break;
			case "8 " : totalValue += 8;break;
			case "9 " : totalValue += 9;break;
			case "10" : totalValue += 10;break;
			case "K " : totalValue += 10;break;
			case "Q " : totalValue += 10;break;
			case "J " : totalValue += 10;break;
			case "A " : totalValue += 1;break;

			}
		}
		for(int i = 0 ; i < aces; i++) {
			if(totalValue > 10) {
				totalValue += 1;
			}
			else {
				totalValue +=11;
			}
		}
		return totalValue;
	}


	@Override
	public String toString() {
		String CardDisplay = "";
		int counter = 0;
		String top1 = " .-------.";
		String top2 = " |       |";
		String top3 = " |       |";
		String top4 = " |       |";
		String top5 = " |       |";
		String top6 = " ._______.";

		for(Card aCard : this.cards) {
			counter = counter +1;	
		}
		System.out.printf("\t\t\t\t\t\t\t\t");
		if(counter < 5) {
			for(int i = 1; i <= counter; i++) {
				System.out.printf(""+top1+"\t");

			}

			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			///////////////////problem one
			for(int i = 0; i < counter; i++) {
				System.out.printf(cards.get(i)+"\t");
			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= counter; i++) {
				System.out.printf(top2+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= counter; i++) {
				System.out.printf(top3+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= counter; i++) {
				System.out.printf(top4+"\t");

			}

			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= counter; i++) {
				System.out.printf(top5+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= counter; i++) {
				System.out.printf(top6+"\t");

			}
			System.out.println("");
		}
		if(counter >= 5 && counter < 10) {
			int countertwo;
			
			countertwo = counter - 5;
			int rows = 5;
			System.out.println("");

			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(""+top1+"\t");

			}
			System.out.println("");

			System.out.printf("\t\t\t\t\t\t\t\t");
			/////////////////////////////problem
			for(int i = 0; i < rows; i++) {
				System.out.printf(cards.get(i)+"\t");
			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(top2+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(top3+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(top4+"\t");

			}

			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(top5+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= rows; i++) {
				System.out.printf(top6+"\t");

			}


			
			System.out.println("");

			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(""+top1+"\t");

			}

			
			System.out.println("");

			System.out.printf("\t\t\t\t\t\t\t\t");
			/////////////////////problem two
			for(int i = 0; i < countertwo; i++) {
				System.out.printf(cards.get(i+5)+"\t");
			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(top2+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(top3+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(top4+"\t");

			}

			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(top5+"\t");

			}
			System.out.println("");
			System.out.printf("\t\t\t\t\t\t\t\t");
			for(int i = 1; i <= countertwo; i++) {
				System.out.printf(top6+"\t");

			}
		}
			System.out.println("");
			if(counter >= 10 ) {
				int countertwo;
				int counterthree;
				countertwo = counter - 5;
				counterthree = counter -10;
				int rows = 5;
				System.out.println("");

				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(""+top1+"\t");

				}
				System.out.println("");

				System.out.printf("\t\t\t\t\t\t\t\t");
				/////////////////////////////problem
				for(int i = 0; i < rows; i++) {
					System.out.printf(cards.get(i)+"\t");
				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top2+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top3+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top4+"\t");

				}

				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top5+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top6+"\t");

				}


				
				System.out.println("");

				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(""+top1+"\t");

				}

				
				System.out.println("");

				System.out.printf("\t\t\t\t\t\t\t\t");
				/////////////////////problem two
				for(int i = 0; i < rows; i++) {
					System.out.printf(cards.get(i+5)+"\t");
				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top2+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top3+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top4+"\t");

				}

				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top5+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= rows; i++) {
					System.out.printf(top6+"\t");

				}
				System.out.println("");
				

				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(""+top1+"\t");

				}

				
				System.out.println("");

				System.out.printf("\t\t\t\t\t\t\t\t");
				/////////////////////problem two
				for(int i = 0; i < counterthree; i++) {
					System.out.printf(cards.get(i+10)+"\t");
				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(top2+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(top3+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(top4+"\t");

				}

				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(top5+"\t");

				}
				System.out.println("");
				System.out.printf("\t\t\t\t\t\t\t\t");
				for(int i = 1; i <= counterthree; i++) {
					System.out.printf(top6+"\t");

				}
				System.out.println("");
		}



		return " ";	
	}
}