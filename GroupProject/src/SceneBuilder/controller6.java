package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller6 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 
	    @FXML
	    private ComboBox departinglist;

	    @FXML
	    private ComboBox<?> goinglist;

	    @FXML
	    private ComboBox<?> leavinglist;
	 
	 private Scene profile;
	 private Scene login;
	 
	 public void setProfileScene (Scene scene) {
		 profile = scene;
	 }
	 
	 public void setLogin (Scene scene) {
		 login = scene;
	 }
	 
	 public void openLogin(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(login);
	    }
	 
	 public void setImage (Pane root) {
			image.fitWidthProperty().bind(root.widthProperty());
			image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			stack_pane.prefWidthProperty().bind(root.widthProperty());
			stack_pane.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void openProfile(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(profile);
	    }
	 
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        departinglist.setItems(FXCollections.observableArrayList("dog","cat","pig"));
    }    

}
