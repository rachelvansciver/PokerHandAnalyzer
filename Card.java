
public class Card implements Comparable<Card> {
	/**This class creates a value 2..14 of suit S,D,H,& C. Gives a meaningful value to generated numbers.*/
	private int value; 
	// 1..14
	private int suit;
	// 0 - Clubs
	// 1 - Diamonds
	// 2 - Hearts
	// 3 - Spades
	public Card(int value, int suit) {
		this.suit = suit;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public int getSuit() {
		return suit;
	}
	
	public String toString() {
		//Returns ${value} of ${suit}
		String s = "";
		
		switch (value) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				s += value;
				break;
			case 11:
				s += "J";
				break; 
			case 12:
				s += "Q";
				break;
			case 13:
				s += "K";
				break;
			case 14:
				s += "A";
				break;
			default:
				s += " ";
				break;
		}
		s += " ";
		
		switch (suit) {
		// 0 - Clubs
		// 1 - Diamonds
		// 2 - Hearts
		// 3 - Spades
		case 0: 
			s += "\u2663";
			break;
		case 1: 
			s += "\u2666";
			break;
		case 2:
			s += "\u2665";
			break;
		case 3:
			s +=  "\u2660";
			break;
		default:
			s += "Nothing";
			break;
		}
		return s;
	}
	
	
	@Override
	public int compareTo(Card c) {
		return this.value - c.getValue();
	}
}
