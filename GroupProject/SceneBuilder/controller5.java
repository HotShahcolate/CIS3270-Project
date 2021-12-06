package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import code.Customer;
import code.Exceptions;
import db.Main;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller5 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 @FXML private ComboBox<String> choice1;
	 

	    @FXML
	    private TextField username;
	    
	    @FXML
	    private TextField answer;
	    
	    @FXML
	    private Label password;
	
	 
	 private Scene login;
	 
	 
	 public void comboBox1 () {
		 choice1.getItems().addAll ("What is your mother's maiden name?");
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
	 
	 @FXML
	    void retrievePassword(ActionEvent event) throws Exceptions {
		 Customer co = new Customer();
		 co.setUsername(username.getText());
		 co.setAnswer(answer.getText());
		 checkForError();
		 	
		 	try {
				password.setText("Your password is: " + Main.retrievePassword(co));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				password.setText("Error: invalid username/password");
				e.printStackTrace();
			}
	    }
	
	 void checkForError() throws Exceptions {
			if(username.getText().isEmpty() || answer.getText().isEmpty()) {
				password.setText("Error: a field is empty");
				throw new code.Exceptions("Error: a field is empty");
			}
			password.setText("");
		}
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
