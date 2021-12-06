package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import code.Customer;
import code.Exceptions;
import db.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller3 implements Initializable{
	private Scene signup_cont;
    @FXML
    private TextField email;
    @FXML
    private Label error;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox securityquestion;
    @FXML
    private StackPane signup_box;
    @FXML
    private ImageView signup_image;
    @FXML
    private PasswordField ssn;
    @FXML
    private TextField state;
    @FXML
    private TextField streetaddress;
    @FXML
    private TextField username;
    @FXML
    private TextField zipcode;
    @FXML
    private PasswordField securityquestionanswer;
	 

	public void setSignUp (Scene scene) {
		 signup_cont = scene;
	 }
	 
	 public void openSignUpCont(ActionEvent actionEvent) {
		 try {
			checkForError();
			Customer co = new Customer();
			 co.setEmail(email.getText());
			 co.setFirstname(firstname.getText());
			 co.setLastname(lastname.getText());
			 co.setPassword(password.getText());
			 co.setSsn(ssn.getText());
			 co.setState(state.getText());
			 co.setAddress(streetaddress.getText());
			 co.setUsername(username.getText());
			 co.setZip(zipcode.getText());
			 co.setAnswer(securityquestionanswer.getText());
			 Main.register(co);
			Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		    stage.setScene(signup_cont);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			error.setText(e1.getMessage());
		}
	 }
	 
	 public void setImage (Pane root) {
			signup_image.fitWidthProperty().bind(root.widthProperty());
			signup_image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			signup_box.prefWidthProperty().bind(root.widthProperty());
			signup_box.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 void checkForError() throws Exceptions {
			if(email.getText().isEmpty() || firstname.getText().isEmpty() || lastname.getText().isEmpty()|| password.getText().isEmpty()|| ssn.getText().isEmpty()|| state.getText().isEmpty()|| streetaddress.getText().isEmpty()|| username.getText().isEmpty()|| zipcode.getText().isEmpty()|| securityquestionanswer.getText().isEmpty()) {
				error.setText("Error: a field is empty");
				throw new code.Exceptions("Error: a field is empty");
			}
			error.setText("");
		}
	 

	@Override
    public void initialize(URL url, ResourceBundle rb) {
		ObservableList<String> securityQuestions = FXCollections.observableArrayList("What is your mother's maiden name?");
		securityquestion.setItems(securityQuestions);
    }    

}
