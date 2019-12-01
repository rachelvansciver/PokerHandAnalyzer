import java.util.Arrays;

public class Game {
	
/**This class deals with game logic, IE which hand wins against another hand.*/
	public static void compareHand(Card[] player, Card[] computer) {
		int[] playerTally = Hand.tallyValues(player);
		int[] computerTally = Hand.tallyValues(computer);
		switch (Hand.handType(computer)) {
		/**Comparing the hand of the computer to the hand of the player.*/
		case "High Card":
			switch(Hand.handType(player)) {
				case "High Card":
					/**In the event of a tie: Highest card wins, and if necessary, the second-highest, 
					 * third-highest, fourth-highest and smallest card can be used to break the tie.*/
					compareTopCard(player, computer, 1);	
					break;
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "One Pair":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
					/**In the event of a tie: Highest pair wins. If players have the same pair, the highest side card wins, and if necessary,
					 * the second-highest and third-highest side card can be used to break the tie.*/
					compareTopCard(player,computer, 2);
					break;
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Two Pair":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
					/**In the event of a tie: Highest pair wins. If players have the same highest pair, highest second pair wins.
					 *  If both players have two identical pairs, highest side card wins.*/
					compareTopCard(player,computer,2);
					break;
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Three of a Kind":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
					/**In the event of a tie: Highest ranking three of a kind wins. In community card games where players have the same three of a kind,
					 * the highest side card, and if necessary, the second-highest side card wins.*/
					compareTopCard(player,computer,3);
					break;
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Straight":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
					/**In the event of a tie: Highest ranking card at the top of the sequence wins.*/
					compareTopCard(player,computer,1);
					break;
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Flush":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
					/**In the event of a tie: The player holding the highest ranked card wins. 
					 * If necessary, the second-highest, third-highest, fourth-highest, and fifth-highest cards 
					 * can be used to break the tie. If all five cards are the same ranks, the pot is split. 
					 * The suit itself is never used to break a tie in poker.*/
					compareTopCard(player,computer,1);
					break;
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Full House":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
					/**In the event of a tie: Highest three matching cards wins the pot. 
					 * In community card games where players have the same three matching cards, 
					 * the highest value of the two matching cards wins.*/
					compareTopCard(player,computer,3);
					break;
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Four of a Kind":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
					/**In the event of a tie: Highest four of a kind wins. 
					 * In community card games where players have the same four of a kind, 
					 * the highest fifth side card ('kicker') wins. */
					compareTopCard(player,computer,4);
					break;
				case "Straight Flush":
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Straight Flush":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
					/**In the event of a tie: Highest rank at the top of the sequence wins.*/
					compareTopCard(player,computer,1);
					break;
				case "Royal Flush":
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			break;
		case "Royal Flush":
			switch(Hand.handType(player)) {
				case "High Card":
				case "One Pair":
				case "Two Pair":
				case "Three of a Kind":	
				case "Straight":
				case "Flush":
				case "Full House":
				case "Four of a Kind":
				case "Straight Flush":
				case "Royal Flush":
					/**The best possible straight flush is known as a royal flush, 
					 * which consists of the ace, king, queen, jack and ten of a suit. 
					 * A royal flush is an unbeatable hand.*/
					System.out.println("You got " + Hand.handType(player)+  ", and the Computer got " +  Hand.handType(computer)+ ". You win");
					break;
			}
			 System.out.println( "Computer has a royal flush. Computer wins!");
		break;	
		}
	}
	public static void compareTopCard(Card[] player, Card[] computer, int value) {
		/**This method uses the tally of the number of each card stored in an array. It searches the array backwards,
		 * and if it finds a tie (both players have the same card) it keeps searching until it finds a tie breaker.
		 * This method works about 99% of the time, sometimes it's wrong.*/
		int playerCount = 0;
		int compCount = 0;
		int[] playerList = Hand.tallyValues(player);
		int[] computerList = Hand.tallyValues(computer);
		for(int i = playerList.length; i > 0 ; i--) {
			for(int j = computerList.length; j > 0 ; j--) {
				if(playerList[i-1] == value) {
					//adds the index at i to a count
					playerCount += i;
				} 
				if (computerList[j-1] == value) {
					//adds the index at j to a count
					compCount += j;
				}
				if(playerList[i-1] == value && computerList[j-1] == value) {
					//if they have the same card keep searching
					continue;
				}	
			}
		}
		if(playerCount > compCount) {
			//if a player has a higher count, he/she has more cards at a high index and therefore won and vice versa
			System.out.println("Player had " + Arrays.toString(player) + ". Player won");
		}
		if(compCount > playerCount) {
			System.out.println("Computer had " + Arrays.toString(computer) + ". Computer won");
		}
	}
}