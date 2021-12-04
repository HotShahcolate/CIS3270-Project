package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller5 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 @FXML private ComboBox<String> choice1;
	
	 
	 private Scene login;
	 
	 
	 public void comboBox1 () {
		 choice1.getItems().addAll ("What is your mom's maiden name?", "What is your first pet's name?", 
				 "What is the name of your high school?");
	 }
	 
	 	 
	
	 public void setImage (Pane root) {
			image.fitWidthProperty().bind(root.widthProperty());
			image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			stack_pane.prefWidthProperty().bind(root.widthProperty());
			stack_pane.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setLogin (Scene scene) {
		 login = scene;
	 }
	 
	 public void openLogin(ActionEvent actionEvent) {
	        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	        stage.setScene(login);
	    }
	 
	 
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
