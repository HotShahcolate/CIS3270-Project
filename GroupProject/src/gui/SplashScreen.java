package gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class SplashScreen extends Application implements EventHandler <ActionEvent> {
	public static void main (String[] args) {
		launch(args);
	}
	Button button;
	
	@Override
	public void start(Stage mainStage) {
		
		
		Pane pane = new Pane();
		
		Image logo = new Image ("https://i.imgur.com/wy1aFGR.png");
		Scene scene = new Scene(pane, 500, 500);
		ImageView view = new ImageView(logo);
		
		pane.getChildren().add(view);
		
		
		mainStage.setTitle("Welcome to Vista Air");
		
		mainStage.setScene(scene);
		

		button = new Button();
		button.setText("Start");
		button.setLayoutX(225);
		button.setLayoutY(350);
		
		
		button.setOnAction(this);
		
		
		pane.getChildren().add(button);
		mainStage.show();
		
	}
	public void handle (ActionEvent event) {
		if(event.getSource()== button) {
			
		}
	}
	
	
	
}



