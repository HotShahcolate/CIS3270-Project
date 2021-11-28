package SceneBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.beans.binding.Bindings; 



public class application extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
	
			FXMLLoader load_Login = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
			Parent root_Login = load_Login.load();
			Scene scene_Login = new Scene(root_Login);
			
			
			FXMLLoader Splash_Load = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
			Parent root_Splash = Splash_Load.load();
			Scene scene_Splash = new Scene(root_Splash);
			
			
			FXMLLoader load_Signup = FXMLLoader.load(getClass().getResource("Sign Up Page.fxml"));
			Parent root_Signup = load_Signup.load();
			Scene scene_Signup = new Scene(root_Signup);
			
			controller2 signupLoader = (controller2)load_Login.getController();
			
			
			
			primaryStage.setScene(scene_Splash);
			primaryStage.show();
			
			
			scene_Splash.setOnMousePressed(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	primaryStage.setScene(scene_Login);
		        }
		    });
			
			
			
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
