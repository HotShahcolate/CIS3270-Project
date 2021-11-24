package gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SplashScreen extends Application {
	Scene splash, login;
	public static void main (String[] args) {
		launch(args);
	}
	Button button;
	
	@Override
	public void start(Stage mainStage) {
		
		
		Pane pane = new Pane();
		
		Image logo = new Image ("https://i.imgur.com/wy1aFGR.png");
		splash = new Scene(pane, 500, 500);
		ImageView view = new ImageView(logo);
		
		pane.getChildren().add(view);
		
		
		mainStage.setTitle("Welcome to Vista Air");
		
		
		

		button = new Button();
		button.setText("Start");
		button.setLayoutX(225);
		button.setLayoutY(350);
		pane.getChildren().add(button);
		
		
		button.setOnAction(e -> mainStage.setScene(login));
		
		StackPane pane2 = new StackPane();
		login = new Scene(pane2, 500, 500);
		Label label2 = new Label("Log In To Continue Your Journey");
		pane2.getChildren().add(label2);
		
	
		mainStage.setScene(splash);
		mainStage.show();
		
	}

}



