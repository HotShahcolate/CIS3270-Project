package SceneBuilder;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller4 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 @FXML private ChoiceBox<String> choice1;
	 @FXML private ChoiceBox choice2;
	 
	 
	 public void choiceBox1 () {
		 choice1.getItems().addAll ("What is your mom's maiden name?", "What is your first pet's name?", 
				 "What is the name of your high school?");
		 choice1.setValue("What is your mom's maiden name?");
	 }
	 
	 public void choiceBox2 () {
		 choice1.getItems().addAll ("What was the first company that you worked for?", "", 
				 "What is the name of your middle school");
		 choice1.setValue("What was the first company that you worked for?");
	 }
	 
	
	 public void setImage (Pane root) {
			image.fitWidthProperty().bind(root.widthProperty());
			image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			stack_pane.prefWidthProperty().bind(root.widthProperty());
			stack_pane.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 
	
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}
