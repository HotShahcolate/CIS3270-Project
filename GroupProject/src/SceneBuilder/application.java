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
	
			FXMLLoader load_Login = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
			Parent root_Login = load_Login.load();
			Scene scene_Login = new Scene(root_Login,600,400);
			
			
			FXMLLoader Splash_Load = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
			Parent root_Splash = Splash_Load.load();
			Scene scene_Splash = new Scene(root_Splash,600,400);
			
			
			FXMLLoader load_Signup = new FXMLLoader(getClass().getResource("Sign Up Page.fxml"));
			Parent root_Signup = load_Signup.load();
			Scene scene_Signup = new Scene(root_Signup,600,400);
			
			FXMLLoader load_Signup_Cont = new FXMLLoader(getClass().getResource("SignUp Cont.fxml"));
			Parent root_Signup_Cont = load_Signup_Cont.load();
			Scene scene_Signup_Cont = new Scene(root_Signup_Cont,600,400);
			
			controller2 signupLoader = (controller2)load_Login.getController();
			signupLoader.setSignUpScene(scene_Signup);
			
			controller loginLoader = (controller)Splash_Load.getController();
			loginLoader.setLogin(scene_Login);
			
			controller3 signupContLoader = (controller3)load_Signup.getController();
			signupContLoader.setLogin(scene_Signup_Cont);
			
			
			
			primaryStage.setScene(scene_Splash);
			primaryStage.show();
			
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
