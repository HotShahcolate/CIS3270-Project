package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import code.Customer;
import db.Main;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller implements Initializable{
	private Scene login;
	
	@FXML private ImageView splash;

    
	public void setImage (Pane root) {
		splash.fitWidthProperty().bind(root.widthProperty());
		splash.fitHeightProperty().bind(root.heightProperty());
	}
	 
	 public void setLogin (Scene scene) {
		 login = scene;
	 }
	 
	 public void openLogin(ActionEvent event) {
		 
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(login);
	 }
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}

