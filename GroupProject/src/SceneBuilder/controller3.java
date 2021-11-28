package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller3 implements Initializable{
	private Scene signup_cont;
	 
	 public void setLogin (Scene scene) {
		 signup_cont = scene;
	 }
	 
	 public void openSignUpCont(ActionEvent actionEvent) {
	        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	        stage.setScene(signup_cont);
	    }
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
