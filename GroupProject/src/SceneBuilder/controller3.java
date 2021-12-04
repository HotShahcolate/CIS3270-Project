package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller3 implements Initializable{
	private Scene signup_cont;
	 @FXML private ImageView signup_image;
	 @FXML private StackPane signup_box;
	 

	public void setSignUp (Scene scene) {
		 signup_cont = scene;
	 }
	 
	 public void openSignUpCont(ActionEvent actionEvent) {
	        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	        stage.setScene(signup_cont);
			 
	    }
	 
	 public void setImage (Pane root) {
			signup_image.fitWidthProperty().bind(root.widthProperty());
			signup_image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			signup_box.prefWidthProperty().bind(root.widthProperty());
			signup_box.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 
	 

	@Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

}
