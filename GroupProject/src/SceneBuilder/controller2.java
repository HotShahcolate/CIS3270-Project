package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller2 implements Initializable{
	 @FXML private Button Login;
	 
	 private Scene signup;
	 
	 public void openSignUp(ActionEvent actionEvent) {
	        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	        Login.setOnAction(e -> stage.setScene(signup));
	    }
	 
	 
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	    }    
	 

}
