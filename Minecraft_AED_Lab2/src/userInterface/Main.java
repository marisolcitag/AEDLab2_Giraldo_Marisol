package userInterface;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Maincraft.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Minecraft");
		// Create a Background Fill 
        BackgroundFill background_fill = new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY); 
        // Create Background 
        Background background = new Background(background_fill); 
        // Set Background 
        root.setBackground(background); 
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(new File("images/littlemen.jpeg").toURI().toString()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
