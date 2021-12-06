package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import code.Customer;
import db.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import SceneBuilder.controller3;

public class controller2 implements Initializable{
	 private Scene signup;
	 private Scene forgetPassword;
	 private Scene main;
	 
	 @FXML private ImageView login_image;
	 @FXML private StackPane stack_pane;
	 @FXML private TextField usernamefield;
	 @FXML private PasswordField passwordfield;
	 @FXML private Label error;
	 
	 public void setSignUpScene (Scene scene1) {
		 signup = scene1;
	 }
	 
	 public void setForgetPassword (Scene scene2) {
		 forgetPassword = scene2;
	 }
	 
	 public void setImage (Pane root) {
			login_image.fitWidthProperty().bind(root.widthProperty());
			login_image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setStack (Pane root) {
			stack_pane.prefWidthProperty().bind(root.widthProperty());
			stack_pane.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 
	 public void openSignUp(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(signup);
	    }
	 
	 public void openForgetPassword(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(forgetPassword);
	    }
	 
	 public void setMain (Scene scene3) {
		 main = scene3;
	 }
	 
	 public void openMain(ActionEvent actionEvent) {
		 Customer co = new Customer(usernamefield.getText(),passwordfield.getText());
		 try {
			Main.login(co);
			//sets stage to next screen and saves the customer object in userdata
			Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			stage.setUserData(co);
			stage.setScene(main);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    error.setText("Error: invalid username/password");
		}
		 
	    }
	        

	@Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	    }    
	 

}
