/**
 * @author Rachel, Thanks for Gabe A. for his contribution to this project, especially with the Card, Deck, and Hand Classes. 
 * This project is designed to create a poker hand from random numbers, Computer vs. Player, 5 cards each, analyze the hands,
 * and determine who won.*/
public class TejasHoldEm {
	static Deck d = new Deck();
	static Hand h = new Hand();
 	public static void main(String[] args) {
		d.shuffle(); 
		
		Card[] computer = d.draw(5);
		printHand(h.sort(computer));
		System.out.println("Computer: " + h.handType(computer));
		
		System.out.println();
		Card[] player = d.draw(5);
		printHand(h.sort(player));
		System.out.println("Player: " + h.handType(player));
		Game.compareHand(player, computer);
	}

	static void printHand(Card[] hand) {
		for (int i=0; i<hand.length; i++) {
			System.out.println(hand[i].toString());
		}
	}
} 

