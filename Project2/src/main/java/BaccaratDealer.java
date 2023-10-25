import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.application.Application;


public class BaccaratDealer {
	private ArrayList<Card> deck;
	
	 public BaccaratDealer() {
	        this.deck = new ArrayList<>();
	    }
	
	//generate a new standard 52 card deck where each card is an instance of the Card class in the ArrayList<Card> deck.
	public void generateDeck() {
		for (String suit : new String[] {"Spades", "Hearts", "Clubs", "Diamonds"}) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(suit, value));
            }
        } 
	}
	
	//dealHand will deal two cards and return them in an ArrayList<Card>
	public ArrayList<Card> dealHand(){
		ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            hand.add(drawOne());
        }
        return hand;
	}
	
	//drawOne will deal a single card and return it
	public Card drawOne() {
		int index = (int) (Math.random() * deck.size());
	    Card card = deck.remove(index);
	    return card;
	}
	
	//shuffleDeck will create a new deck of 52 cards and “shuffle”
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	//deckSize will just return how many cards are in this.deck at any given time.
	public int deckSize() {
		return deck.size();
	}
	
	//A card is draw from the deck and added to the player's hand
	public void hit(ArrayList<Card> hand) {
		hand.add(drawOne());
	}
	
	//
	public void stand(ArrayList<Card> hand) {
		//do nothing
	}

	
}
