
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {


	
	 private BaccaratGameLogic gameLogic = new BaccaratGameLogic();
	 private BaccaratDealer dealer = new BaccaratDealer();
	 private BaccaratGame game = new BaccaratGame();
	 //private Card card =  new Card()
//---------------------------------------------------------BaccaratGameLogic test cases-----------------------------//	
	@Test
	public void whoWonTest1() { // Test case1:if the player wins
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("HEARTS",10));
        playerHand.add(new Card("SPADES",7));

        ArrayList<Card> bankerHand = new ArrayList<>();
        bankerHand.add(new Card("HEARTS",5));
        bankerHand.add(new Card("SPADES",6));

        String winner = gameLogic.whoWon(playerHand, bankerHand);
        assertEquals("Player", winner);
        
	}
	
	
	@Test
	public void whoWonTest2() {//Test case2: when there is a draw
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("HEARTS",10));
        playerHand.add(new Card("SPADES",7));

        ArrayList<Card> bankerHand = new ArrayList<>();
        bankerHand.add(new Card("HEARTS",10));
        bankerHand.add(new Card("SPADES",7));

        String winner = gameLogic.whoWon(playerHand, bankerHand);
        assertEquals("Draw", winner);
	}
	

	@Test
	public void whoWonTest3() {//Test case3; if the banker wins
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("HEARTS",1));
        playerHand.add(new Card("SPADES",2));

        ArrayList<Card> bankerHand = new ArrayList<>();
        bankerHand.add(new Card("HEARTS",5));
        bankerHand.add(new Card("SPADES",3));

        String winner = gameLogic.whoWon(playerHand, bankerHand);
        assertEquals("Banker", winner);
	}
	
	
	@Test
	public void handTotalTest1() {
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("HEARTS",10));
        playerHand.add(new Card("SPADES",7));
        
        int total = gameLogic.handTotal(playerHand);
        equals(7);
	}
	
	
	@Test
	public void handTotalTest2() {
		ArrayList<Card> bankerHand = new ArrayList<>();
		bankerHand.add(new Card("HEARTS",9));
        bankerHand.add(new Card("SPADES",6));
        
        int total = gameLogic.handTotal(bankerHand);
        equals(5);
	}
	
	
	@Test
	public void evalauateBankerDrawTest1() {
		ArrayList<Card> bankerHand = new ArrayList<>();
		bankerHand.add(new Card("HEARTS",6));
        bankerHand.add(new Card("SPADES",7));
        
        Card playerCard = new Card("DIAMONDS",8);
        boolean drawCard =  gameLogic.evaluateBankerDraw(bankerHand, playerCard);
        assertTrue(drawCard);
    }
        
	@Test
	public void evalauateBankerDrawTest2() {
		ArrayList<Card> bankerHand = new ArrayList<>();
		bankerHand.add(new Card("HEARTS",7));
        bankerHand.add(new Card("SPADES",9));
        
        Card playerCard = new Card("DIAMONDS",8);
        boolean drawCard =  gameLogic.evaluateBankerDraw(bankerHand, playerCard);
        assertFalse(drawCard);
    }
         
        
    @Test
    public void evaluatePlayerDrawTest1() {
    	ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("HEARTS",9));
        playerHand.add(new Card("SPADES",6));
        
        boolean drawCard = gameLogic.evaluatePlayerDraw(playerHand);
        assertTrue(drawCard);
    }
	
    @Test
    public void evaluatePlayerDrawTest2() {
    	ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("SPADES",9));
        playerHand.add(new Card("SPADES",9));
        
        boolean drawCard = gameLogic.evaluatePlayerDraw(playerHand);
        assertFalse(drawCard);
    }

  //----------------------------------------------------------------BaccaratDealer test cases--------------------------//
	
    @Test
    public void generateDeckTest1() {//test case1: should generate a deck of 52 cards
    	dealer.generateDeck();
    	assertEquals(52,dealer.deckSize());
    }
	
	@Test
	public void generateDeckTest2() {//test case2; should generate deck where each card is an instance of the Card class in the ArrayList<Card> deck.
		//ArrayList<Card> deck;
		for(Card card: dealer.deck) {
			assertTrue(card instanceof Card);
		}
	}
	
	
	@Test
	public void dealHandTest1() {//Test case : should only return 2 cards
		dealer.generateDeck();
		ArrayList<Card> hand = dealer.dealHand();
		assertEquals(2,hand.size());
	}
	
	public void dealHandTest2() {//Test case : 2 cards should be different
		dealer.generateDeck();
		ArrayList<Card> hand = dealer.dealHand();
		assertFalse((hand.get(0)).equals(hand.get(1)));
	}
	
	
	@Test
	public void drawOneTest1() {//test case 1; card should be an instance of card class
		dealer.generateDeck();
		Card card = dealer.drawOne();
		assertTrue(card instanceof Card);
	}
	
//	@Test
//	public void drawOneTest2() {
//		
//	}
//	
	@Test
	public void shuffleDeckTest1() {//Test1: checks if the shuffled deck and original card are the same 
		dealer.generateDeck();
		dealer.shuffleDeck();
	    
        List<Card> originalDeck = new ArrayList<>(dealer.deck);

        Collections.shuffle(originalDeck);

        assertNotEquals(originalDeck, dealer.deck);
	}
	
	@Test
	public void deckSizeTest1() {//Test1; checks if deck size is correct after drawing one card
		dealer.generateDeck();
		dealer.drawOne();
    	assertEquals(51,dealer.deckSize());
	}
	
	@Test
	public void deckSizeTest2() {// Test2:  checks if initial deck size is 52
		dealer.generateDeck();
    	assertEquals(52,dealer.deckSize());
	}
	
	@Test
	public void hitTest1() {
		dealer.generateDeck();
		ArrayList<Card> hand = new ArrayList<>();
		dealer.hit(hand);
		assertEquals(51,dealer.deckSize());	
	}
	
	@Test
	public void hitTest2() {
		dealer.generateDeck();
		ArrayList<Card> hand = new ArrayList<>();
		dealer.hit(hand);
		assertEquals(1,hand.size());	
	}
	
	@Test
	public void standTest() {//Test: shows that no new cards were adding
		dealer.generateDeck();
		ArrayList<Card> hand = new ArrayList<>();
		dealer.stand(hand);
		assertEquals(0,hand.size());
	}
	
	//----------------------------------------------------------BaccaratGame tests---------------------//
	@Test
	public void startNewGameTest1() {//test 1; check if both player and banker are empty
		game.startNewGame();
		assertTrue(game.playerHand.isEmpty());
		assertTrue(game.bankerHand.isEmpty());
		
	}
	
	@Test
	public void startNewGameTest2() {//test2: check that the hand size is 0
		ArrayList<Card> hand = new ArrayList<>();
		game.startNewGame();
		assertEquals(0,hand.size());
		
	}
	
	//@Test
//	public void dealCardsTest1() {
//		game.dealCards();
//		//assertEquals(1,game.playerHand.size());
//		//assertEquals(2,game.bankerHand.size());
//		assertTrue(game.playerHand.stream().distinct().count() == 2);
//        assertTrue(game.bankerHand.stream().distinct().count() == 2);
//	}
	
	public void EvaluateWinningsTest1() {//Test1: deals hands where player winsChecks the players winnings are equal to the bet 
	    game.playerHand.add(new Card("SPADES", 10));
	    game.playerHand.add(new Card("HEARTS", 7));

	    game.bankerHand.add(new Card("DIAMONDS", 5));
	    game.bankerHand.add(new Card("CLUBS", 6));

	    double winnings = game.evaluateWinnings();    
	    assertEquals(game.currentBet, winnings);
	}
	
	
	public void EvaluateWinningsTest2() {//Test 2 : delas hands where banker wins, checks if the player winnings are equal to the bet
		 game.playerHand.add(new Card("SPADES", 1));
		 game.playerHand.add(new Card("HEARTS", 2));

		 game.bankerHand.add(new Card("DIAMONDS", 5));
		 game.bankerHand.add(new Card("CLUBS",3));
		 
		 double winnings = game.evaluateWinnings();    
		 assertEquals(game.currentBet, winnings);
		 //check
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	

