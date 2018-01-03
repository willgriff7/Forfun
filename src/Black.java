import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Black {

	int turnCounter;
	ArrayList<Card> deck = new ArrayList<Card>();
	int HouseSum;
	int PlayerSum;
	String Count1 = "";
	String Count2 = ""; 

	public void shuffle() {
		deck.clear();
		deck.add(new Two("Heart"));
		deck.add(new Three("Heart"));
		deck.add(new Four("Heart"));
		deck.add(new Five("Heart"));
		deck.add(new Six("Heart"));
		deck.add(new Seven("Heart"));
		deck.add(new Eight("Heart"));
		deck.add(new Nine("Heart"));
		deck.add(new Ten("Heart"));
		deck.add(new Jack("Heart"));
		deck.add(new Queen("Heart"));
		deck.add(new King("Heart"));
		deck.add(new Ace("Heart"));

		deck.add(new Two("Diamond"));
		deck.add(new Three("Diamond"));
		deck.add(new Four("Diamond"));
		deck.add(new Five("Diamond"));
		deck.add(new Six("Diamond"));
		deck.add(new Seven("Diamond"));
		deck.add(new Eight("Diamond"));
		deck.add(new Nine("Diamond"));
		deck.add(new Ten("Diamond"));
		deck.add(new Jack("Diamond"));
		deck.add(new Queen("Diamond"));
		deck.add(new King("Diamond"));
		deck.add(new Ace("Diamond"));

		deck.add(new Two("Club"));
		deck.add(new Three("Club"));
		deck.add(new Four("Club"));
		deck.add(new Five("Club"));
		deck.add(new Six("Club"));
		deck.add(new Seven("Club"));
		deck.add(new Eight("Club"));
		deck.add(new Nine("Club"));
		deck.add(new Ten("Club"));
		deck.add(new Jack("Club"));
		deck.add(new Queen("Club"));
		deck.add(new King("Club"));
		deck.add(new Ace("Club"));

		deck.add(new Two("Spade"));
		deck.add(new Three("Spade"));
		deck.add(new Four("Spade"));
		deck.add(new Five("Spade"));
		deck.add(new Six("Spade"));
		deck.add(new Seven("Spade"));
		deck.add(new Eight("Spade"));
		deck.add(new Nine("Spade"));
		deck.add(new Ten("Spade"));
		deck.add(new Jack("Spade"));
		deck.add(new Queen("Spade"));
		deck.add(new King("Spade"));
		deck.add(new Ace("Spade"));
	}

	public int askAce(){
		String input ="";
		
		while(!input.equals("1") || !input.equals("11")){
			System.out.println("Do you want your Ace at a 1 or an 11");
			Scanner scan = new Scanner(System.in);
			input = scan.nextLine();
			
			if(input.equals("1")){
				scan.close();
				return 1;
			}else if(input.equals("11")){
				scan.close();
				return 11;
			}else{
				System.out.println("Please type either 1 or 11");
				continue;
			}
		}
		return -1;
	}

	public void intro(){
		System.out.println();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println();

		System.out.println(
				"Hello There, this is BlackJack. Please press r reset(or start), press e to end, press h to hit, and s to stay");
	}
	
	public void outcome(){
		if (HouseSum > 21) {
			System.out.println("House Busts! Please hit e to exit or r to reset.");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (HouseSum == 21) {
			System.out.println("Looks like the house hit Blackjack. Try again next time.");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (PlayerSum == 21) {
			System.out.println("Whoa! Good job! You just got Blackjack and won!");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (PlayerSum > 21) {
			System.out.println("You busted! Better luck next time");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (PlayerSum > HouseSum) {
			System.out.println("GoodJob! Looks like you beat the House Score");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (HouseSum > PlayerSum) {
			System.out.println("Looks like the House wins! Better Luck next time");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else if (HouseSum == PlayerSum) {
			System.out.println("Smells like a push to me");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		} else {
			System.out.println("Press r again to reset and e to exit");
			Count1 = "House Sum is "+Integer.toString(HouseSum);
			Count2 = "Player Sum is "+Integer.toString(PlayerSum);
			System.out.println(Count1);
			System.out.println(Count2);
		}
	}
	
	public void play() {
		
		
		intro();

		String input = "";

		Scanner scan = new Scanner(System.in);
		
		while (!input.equals("e")) {

			input = scan.nextLine();

			String Output1 = "";
			String Output2 = "";
			Count1 = "";
			Count2 = "";

			if (input.equals("r")) {
				
				deck.clear();
				shuffle();
				Collections.shuffle(deck);
				Card card1 = deck.remove(0);
				Card card2 = deck.remove(0);
				Card card3 = deck.remove(0);

				HouseSum = card1.getValue() + card2.getValue();
				PlayerSum = card3.getValue();

				Output1 = "The House has a " + card1.getType() + " " + card1.getName() + " at value " + card1.getValue()
						+ " and a " + card2.getType() + " " + card2.getName() + " at value " + card2.getValue();
				Output2 = "You have a " + card3.getType() + " " + card3.getName() + " at value " + card3.getValue();
				System.out.println();
				
				Count1 = "House Sum is "+Integer.toString(HouseSum);
				Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
				
				while (HouseSum < 21 && PlayerSum < 21) {

					System.out.println(Output1);
					System.out.println(Output2);
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);

					scan = new Scanner(System.in);
					input = scan.nextLine();

					if (input.equals("r")) {
						break;

					} else if (input.equals("h")) {

						Card cardM = deck.remove(0);
						Output2 = Output2 + " and " + cardM.getType() + " " + cardM.getName() + " at value "
								+ cardM.getValue();
						PlayerSum += cardM.getValue();

					} else if (input.equals("s")) {
						while (HouseSum < 21 || HouseSum < PlayerSum) {
							Card cardM = deck.remove(0);
							Output1 = Output1 + " and " + cardM.getType() + " " + cardM.getName() + " at value "
									+ cardM.getValue();
							System.out.println(Output1);
							System.out.println(HouseSum);
							System.out.println();
							HouseSum += cardM.getValue();
						}

					} else if (input.equals("e")) {
						System.exit(1);
					} else {
						System.out.println("Please Type either e (exit), r(reset), s(stay), or h(hit)");
					}

				}
				if (HouseSum > 21) {
					System.out.println("House Busts! Please hit e to exit or r to reset.");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (HouseSum == 21) {
					System.out.println("Looks like the house hit Blackjack. Try again next time.");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (PlayerSum == 21) {
					System.out.println("Whoa! Good job! You just got Blackjack and won!");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (PlayerSum > 21) {
					System.out.println("You busted! Better luck next time");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (PlayerSum > HouseSum) {
					System.out.println("GoodJob! Looks like you beat the House Score");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (HouseSum > PlayerSum) {
					System.out.println("Looks like the House wins! Better Luck next time");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else if (HouseSum == PlayerSum) {
					System.out.println("Smells like a push to me");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum  is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				} else {
					System.out.println("Press r again to reset and e to exit");
					Count1 = "House Sum is "+Integer.toString(HouseSum);
					Count2 = "Player Sum is "+Integer.toString(PlayerSum);
					System.out.println(Count1);
					System.out.println(Count2);
				}

			}

		}
		scan.close();

	}

	public static void main(String[] args) {
		Black b = new Black();
		b.shuffle();
		b.play();
		System.out.println("Closed...");
		
	}

}
