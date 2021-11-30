package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller2 implements Initializable{
	 private Scene signup;
	 @FXML private ImageView login_image;
	 @FXML private StackPane stack_pane;
	
	 
	 public void setSignUpScene (Scene scene) {
		 signup = scene;
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
	 
	 
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	    }    
	 

}
