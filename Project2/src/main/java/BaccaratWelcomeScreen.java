import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class BaccaratWelcomeScreen extends Application {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    //feel free to remove the starter code from this method
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a VBox to hold the elements
        VBox vbox = new VBox();
        vbox.setSpacing(10); // Increase the spacing between elements
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#09340C"), CornerRadii.EMPTY, null)));
        vbox.setAlignment(Pos.CENTER);


        // Load the title image
        Image titleImage = new Image(getClass().getResourceAsStream("/Title.png"));
        ImageView titleImageView = new ImageView(titleImage);

        // Create buttons
        Button startGameButton = new Button("Start Game");
        Button loadGameButton = new Button("Load Game");
        Button settingsButton = new Button("Settings");

        // Set button styles for a circular shape and bigger size
        startGameButton.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-background-color: #336633;" + // Background color
                        "-fx-text-fill: white;" + // Text color
                        "-fx-background-radius: 50%;" + // Circular shape
                        "-fx-padding: 15 40 15 40;" // Increase padding for button size
        );

        loadGameButton.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-background-color: #336633;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 50%;" +
                        "-fx-padding: 15 40 15 40;"
        );

        settingsButton.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-background-color: #336633;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 50%;" +
                        "-fx-padding: 15 40 15 40;"
        );

        // Add elements to the VBox
        vbox.getChildren().addAll(titleImageView, startGameButton, loadGameButton, settingsButton);

        // Create a scene and set it on the stage
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Baccarat Game Welcome Screen");
        primaryStage.show();
    }
}
