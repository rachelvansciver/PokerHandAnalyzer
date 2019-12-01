import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	/**Creates a deck with functions shuffle, draw, and print */
	public static Card[] cards = new Card[52];
	static int index = 0;
	public Deck() {
		//adds new card of x suit, x value to deck
		int i = 0;
		for(int suit = 0; suit <= 3; suit++) {
			for(int value = 2; value <= 14; value++) {
				cards[i] = new Card(value, suit);
				i++;
			}
		}
	}
	public void shuffle() {
		//Shuffles the deck
		Random r = ThreadLocalRandom.current();
		
		for (int i = 51; i > 0; i--) {
			int j = r.nextInt(i + 1);
			
			Card tmp = cards[j];
			cards[j] = cards[i];
			cards[i] = tmp; 
		}
		index = 0;
	}
	
	
	public Card[] draw() {
		//Draws a card from the deck, defaults to one card
		return draw(1);
	}
	public Card[] draw(int count) {
		Card[] hand = new Card[count];
		for (int i=0; i<count; i++) {
			index++;
			//adds a card to hand and subtracts it from the deck
			hand[i] = cards[index-1];
		}
		return hand;
	}
	
	public static void printDeck() {
		//Prints the deck
		for (int i=0; i<cards.length; i++) {
			System.out.println(cards[i].toString());
		}
	}
}

