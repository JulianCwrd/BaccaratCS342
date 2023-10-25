import java.util.ArrayList;

public class BaccaratGameLogic {
	
	private static final int HAND_TOTAL_MAX = 9;
	
	
	//The method whoWon will evaluate two hands at the end of the game and return a string depending on the winner: “Player”, “Banker”, “Draw”. 
	public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2) {
		int hand1Total = handTotal(hand1);//first hand to evaluate
		int hand2Total = handTotal(hand2);//second hand to evaluate
		//if the first hand is greater than the second return "player" and if less than return "Banker"
		  if (hand1Total > hand2Total) {
	            return "Player";
	        } 
		  	else if (hand2Total > hand1Total) {
	            return "Banker";
	        } 
		  //if equal return "Draw"
	        else {
	            return "Draw";
	        }
	}
	
	//The method handTotal will take a hand and return how many points that hand is worth
	public int handTotal(ArrayList<Card> hand) {
		int total = 0;
		 for (Card card : hand) {
	            total += card.getValue();	        }

	        // If the total is greater than 9, subtract 10.
	        if (total > HAND_TOTAL_MAX) {
	            total -= 10;
	        }

	        return total;
	}
	
	//The methods evaluateBankerDraw and evaluatePlayerDraw will return true if either one should be dealt a third card, otherwise return false.
	
	
	public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard) {
		//if the banker draws a card, return true
		int handTotal = handTotal(hand);
		
		//using the chart..
		//the banker must draw if their handTotal is 5 or less
		if(handTotal <= 5) {
			return true;
		}
		
		//if the player's third card is 6 or 7, the banker must draw a card if their handTotal is 7 or less
		if(playerCard.getValue() == 6 || playerCard.getValue() == 7) {
			return handTotal <= 7;
		}
		return false;
		
	}
	
	public boolean evaluatePlayerDraw(ArrayList<Card> hand) {
		//if player draws a card,return true
		int handTotal = handTotal(hand);
		// if hand totals to 5 or less, The Player gets one more card
		return handTotal <=5;
		
	}
}
