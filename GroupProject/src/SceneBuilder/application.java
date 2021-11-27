package SceneBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.*;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;



public class application extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root_Login = (BorderPane)FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			Scene scene_Login = new Scene(root_Login,600,325, Color.WHITE);
			scene_Login.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			StackPane root_Splash = (StackPane)FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
			Scene scene_Splash = new Scene(root_Splash,600,325, Color.WHITE);
			scene_Splash.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene_Splash);
			primaryStage.show();
			
			scene_Splash.setOnMousePressed(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	primaryStage.setScene(scene_Login);
		        }
		    });
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
