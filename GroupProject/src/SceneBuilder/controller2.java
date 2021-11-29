package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller2 implements Initializable{
	 @FXML private ImageView login_image;
	 @FXML private VBox login_box;
	 @FXML private VBox login_box1;
	 @FXML private HBox login_box2;
	 @FXML private VBox login_box3;
	 @FXML private HBox login_box4;
	 
	 private Scene signup;
	 
	 public void setSignUpScene (Scene scene) {
		 signup = scene;
	 }
	 
	 public void setImage (Pane root) {
			login_image.fitWidthProperty().bind(root.widthProperty());
			login_image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setLoginBox (Pane root) {
			login_box.prefWidthProperty().bind(root.widthProperty());
			login_box.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setVBox1 (Pane root) {
			login_box1.prefWidthProperty().bind(root.widthProperty());
			login_box1.prefHeightProperty().bind(root.heightProperty());
		}
	 public void setHBox1 (Pane root) {
			login_box2.prefWidthProperty().bind(root.widthProperty());
			login_box2.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setVBox2 (Pane root) {
			login_box3.prefWidthProperty().bind(root.widthProperty());
			login_box3.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setHBox2 (Pane root) {
			login_box4.prefWidthProperty().bind(root.widthProperty());
			login_box4.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void openSignUp(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(signup);
	    }
	 
	 
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	    }    
	 

}
