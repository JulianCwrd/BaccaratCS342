import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class BaccaratGUI extends Application {

	
	private BaccaratGame game;
	
	private Label PlayerCardsLabel;
	private Label BankerCardsLabel;
	private Button StartButton;
	private TextField betAmount;
	private ChoiceBox<String>  betType;
	private Label CurrentWinnings;
	private Label roundResults;
	
	public BaccaratGUI() {
		game = new BaccaratGame();

        PlayerCardsLabel = new Label("Player Cards");
        BankerCardsLabel = new Label("Banker Cards");
        StartButton = new Button("Start Round");
        betAmount = new TextField();
        betType = new ChoiceBox<>();
        betType.getItems().addAll("Player", "Banker", "Draw");
        CurrentWinnings = new Label("Current winnings: $" + game.getBankroll());
        roundResults = new Label("");
        
        
        
        StartButton.setOnAction(actionEvent-> {
        	//start a new game
        	game.startNewGame();
        	
        	// Place the user's bet.
            game.placeBet(Double.parseDouble(betAmount.getText()), betType.getValue());
            
            //deal the player and banker's cards
            game.dealCards();
            
  
        	
        	
        	
        


	
	
	public void start(Stage primaryStage) throws Exception {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
