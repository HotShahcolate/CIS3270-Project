package SceneBuilder;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.beans.binding.Bindings; 



public class application extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
	
			FXMLLoader load_Login = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
			Pane root_Login = load_Login.load();
			Scene scene_Login = new Scene(root_Login);
			root_Login.prefWidthProperty().bind(root_Login.widthProperty());
			root_Login.prefHeightProperty().bind(root_Login.heightProperty());
			
			
			FXMLLoader Splash_Load = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
			Pane root_Splash = Splash_Load.load();
			Scene scene_Splash = new Scene(root_Splash);
			root_Splash.prefWidthProperty().bind(root_Splash.widthProperty());
			root_Splash.prefHeightProperty().bind(root_Splash.heightProperty());
			
			
			FXMLLoader load_Signup = new FXMLLoader(getClass().getResource("Sign Up Page.fxml"));
			Pane root_Signup = load_Signup.load();
			Scene scene_Signup = new Scene(root_Signup);
			root_Signup.prefWidthProperty().bind(root_Signup.widthProperty());
			root_Signup.prefHeightProperty().bind(root_Signup.heightProperty());
			
			FXMLLoader load_Signup_Cont = new FXMLLoader(getClass().getResource("SignUp Cont.fxml"));
			Pane root_Signup_Cont = load_Signup_Cont.load();
			Scene scene_Signup_Cont = new Scene(root_Signup_Cont);
			root_Signup_Cont.prefWidthProperty().bind(root_Signup_Cont.widthProperty());
			root_Signup_Cont.prefHeightProperty().bind(root_Signup_Cont.heightProperty());
			
			controller2 signupLoader = (controller2)load_Login.getController();
			signupLoader.setSignUpScene(scene_Signup);
			signupLoader.setImage(root_Login);
			signupLoader.setLoginBox(root_Login);
			signupLoader.setVBox1(root_Login);
			signupLoader.setVBox2(root_Login);
			signupLoader.setHBox1(root_Login);
			signupLoader.setHBox2(root_Login);
			
			controller loginLoader = (controller)Splash_Load.getController();
			loginLoader.setLogin(scene_Login);
			loginLoader.setImage(root_Splash);
			
			controller3 signupContLoader = (controller3)load_Signup.getController();
			signupContLoader.setLogin(scene_Signup_Cont);
			
			
			
			primaryStage.setScene(scene_Splash);
			primaryStage.setMaximized(true);
			primaryStage.show();
			
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
