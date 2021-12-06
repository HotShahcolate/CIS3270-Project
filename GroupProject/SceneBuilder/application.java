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

import db.Main;


public class application extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{

		try {
			
			FXMLLoader load_Login = new FXMLLoader(getClass().getResource("Login_Page.fxml"));
			Pane root_Login = load_Login.load();
			Scene scene_Login = new Scene(root_Login,600,400);
			root_Login.prefWidthProperty().bind(root_Login.widthProperty());
			root_Login.prefHeightProperty().bind(root_Login.heightProperty());
					
			FXMLLoader Splash_Load = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
			Pane root_Splash = Splash_Load.load();
			Scene scene_Splash = new Scene(root_Splash,600,400);
			root_Splash.prefWidthProperty().bind(root_Splash.widthProperty());
			root_Splash.prefHeightProperty().bind(root_Splash.heightProperty());
			
			
			FXMLLoader load_Signup = new FXMLLoader(getClass().getResource("Sign Up Page.fxml"));
			Pane root_Signup = load_Signup.load();
			Scene scene_Signup = new Scene(root_Signup,600,400);
			root_Signup.prefWidthProperty().bind(root_Signup.widthProperty());
			root_Signup.prefHeightProperty().bind(root_Signup.heightProperty());
			
			
			
			
			FXMLLoader load_Forget = new FXMLLoader(getClass().getResource("Forget_Password.fxml"));
			Pane root_Forget = load_Forget.load();
			Scene scene_Forget = new Scene(root_Forget,600,400);
			root_Forget.prefWidthProperty().bind(root_Forget.widthProperty());
			root_Forget.prefHeightProperty().bind(root_Forget.heightProperty());
			
			FXMLLoader load_Main = new FXMLLoader(getClass().getResource("Main_Page.fxml"));
			Pane root_Main = load_Main.load();
			Scene scene_Main = new Scene(root_Main,600,400);
			root_Main.prefWidthProperty().bind(root_Main.widthProperty());
			root_Main.prefHeightProperty().bind(root_Main.heightProperty());
			
			FXMLLoader load_Profile = new FXMLLoader(getClass().getResource("Profile_Page.fxml"));
			Pane root_Profile = load_Profile.load();
			Scene scene_Profile = new Scene(root_Profile,600,400);
			root_Profile.prefWidthProperty().bind(root_Profile.widthProperty());
			root_Profile.prefHeightProperty().bind(root_Profile.heightProperty());
			
			controller loginLoader = (controller)Splash_Load.getController();
			loginLoader.setLogin(scene_Login);
			loginLoader.setImage(root_Splash);
					
			
			controller2 signupLoader = (controller2)load_Login.getController();
			signupLoader.setSignUpScene(scene_Signup);
			signupLoader.setImage(root_Login);
			signupLoader.setStack(root_Login);
			signupLoader.setForgetPassword(scene_Forget);
			signupLoader.setMain(scene_Main);
			
			
			controller3 signupContLoader = (controller3)load_Signup.getController();
			signupContLoader.setSignUp(scene_Login);
			signupContLoader.setImage(root_Signup);
			signupContLoader.setBox(root_Signup);
			
			
			
			controller5 forgetPassword = (controller5)load_Forget.getController();
			forgetPassword.setBox(root_Forget);
			forgetPassword.setImage(root_Forget);
			forgetPassword.comboBox1();
			forgetPassword.setLogin(scene_Login);
			
			controller6 mainLoader = (controller6)load_Main.getController();
			mainLoader.setImage(root_Main);
			mainLoader.setBox(root_Main);
			mainLoader.setProfileScene(scene_Profile);
			mainLoader.setLogin(scene_Login);
			
			controller7 profileLoader = (controller7)load_Profile.getController();
			profileLoader.setImage(root_Profile);
			profileLoader.setBox(root_Profile);
			profileLoader.setMainScene(scene_Main);
			
			
			
			primaryStage.setScene(scene_Splash);
			primaryStage.show();
		} catch (Exception e) {System.out.println(e);};
		
	}
	
	
	public static void main(String[] args) throws Exception{
		Main.getConnection();
		launch(args);
	}
}
