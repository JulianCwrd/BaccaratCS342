import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class BaccaratGame {

	
	 private ArrayList<Card> playerHand;
	 private ArrayList<Card> bankerHand;
	 private BaccaratDealer theDealer;
	 private BaccaratGameLogic gameLogic;
	 private double currentBet;
	 private double totalWinnings;
	 
	 
	 public BaccaratGame() { //constructor
		 playerHand = new ArrayList<>();
		 bankerHand = new ArrayList<>();
		 theDealer = new BaccaratDealer();
		 gameLogic = new BaccaratGameLogic();
		 currentBet = 0;
		 totalWinnings = 0;
	 }
	 
	 
	// public double evaluateWinnings() {}
	 
	 //to start new game clear both hands
	 public void startNewGame() {
		 playerHand.clear();
		 bankerHand.clear();
	 }
	 
	 //this allows the user to place a bet once the game begins
	 public void placeBet(double betAmount, String betType) {
		 this.currentBet = betAmount;
		 //this.betType = betType;
	 }
	 
	 
	 public void dealCards() {
		 theDealer.dealHand();
	 }
	 
	 
	 
	 public void hit() {
		 theDealer.hit(playerHand);
	 }
	 
	 
	 public void stand() {
		 theDealer.stand(bankerHand);
	 }
	 
	 
	 public double getBankroll() {
	        return totalWinnings;
	    }
	 
	 public void whoWon() {
		gameLogic.whoWon(playerHand, bankerHand);
	 }
	 
	 public double evaluateWinnings() {
		 String outcome = gameLogic.whoWon(playerHand, bankerHand);
		
			  if (outcome.equals("Player")) {
			      return currentBet;
			   } else if (outcome.equals("Banker")) {
				   return -currentBet;
			   } else {
				   return 0;
			   }
	 }
	 
	 
}




























































//
//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	launch(args);
//}
//
////feel free to remove the starter code from this method
////@Override
////public void start(Stage primaryStage) throws Exception {
////	// TODO Auto-generated method stub
////	primaryStage.setTitle("Welcome to Baccarat Game");
//	
////	 Rectangle rect = new Rectangle (100, 40, 100, 100);
////     rect.setArcHeight(50);
////     rect.setArcWidth(50);
////     rect.setFill(Color.VIOLET);
////
////     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
////     rt.setByAngle(270);
////     rt.setCycleCount(4);
////     rt.setAutoReverse(true);
////     SequentialTransition seqTransition = new SequentialTransition (
////         new PauseTransition(Duration.millis(500)),
////         rt
////     );
////     seqTransition.play();
////     
////     FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
////     ft.setFromValue(1.0);
////     ft.setToValue(0.3);
////     ft.setCycleCount(4);
////     ft.setAutoReverse(true);
////
////     ft.play();
////     BorderPane root = new BorderPane();
////     root.setCenter(rect);
////     
////     Scene scene = new Scene(root, 700,700);
////		primaryStage.setScene(scene);
////		primaryStage.show();
////	
//			
//	
//}