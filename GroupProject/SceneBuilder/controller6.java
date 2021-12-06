package SceneBuilder;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import code.Customer;
import code.Exceptions;
import db.Main;
import SceneBuilder.controller2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller6 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 
	    @FXML
	    private ComboBox departinglist;

	    @FXML
	    private ComboBox goinglist;

	    @FXML
	    private ComboBox leavinglist;
	    
	    @FXML
	    private Label error;
	 
	 private Scene profile;
	 private Scene login;
	 
	 private String departingFlight;
	 private String goingToFlight;
	 private String departingDate;
	 
	    @FXML
	    private Text your_trip;


	 
	 public void setProfileScene (Scene scene) {
		 profile = scene;
	 }
	 
	 public void setLogin (Scene scene) {
		 login = scene;
	 }
	 
	 public void openLogin(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(login);
	        System.out.println("logged out");
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
	        System.out.println("your trips");
	    }
	 
	//selected departing date 
	@FXML
	void selectDeparting(ActionEvent event) {
		departingDate = departinglist.getSelectionModel().getSelectedItem().toString();
	}

	//selected "going to" city
	@FXML
	void selectGoing(ActionEvent event) {
			goingToFlight = goinglist.getSelectionModel().getSelectedItem().toString();
	}

	//selected "leaving from" city
	@FXML
	void selectLeaving(ActionEvent event) {
		departingFlight = leavinglist.getSelectionModel().getSelectedItem().toString();
	}
	 
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		ResultSet flights;
		ObservableList<String> flightsStrings = FXCollections.observableArrayList();
		
		ResultSet dates;
		ObservableList<String> datesStrings = FXCollections.observableArrayList();
		

		
		try {
			flights = Main.loadMainMenuFlights();
			dates = Main.loadMainMenuDates();
			while (flights.next()) {
				flightsStrings.add(flights.getString("from"));
			}
			while (dates.next()) {
				datesStrings.add(dates.getString("date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error.setText("The specified username already exists.");
		}
        goinglist.setItems(flightsStrings);
        leavinglist.setItems(flightsStrings);
        departinglist.setItems(datesStrings);
    }    
	
	void checkForError() throws Exceptions {
		if(departingFlight==null || goingToFlight==null || departingDate==null) {
			error.setText("Error: a field is empty");
			throw new code.Exceptions("Error: a field is empty");
		}
		else if(departingFlight.equals(goingToFlight)) {
			error.setText("Error: departing flight location cannot be same as arriving location");
			throw new code.Exceptions("Error: departing flight location cannot be same as arriving location");
		}else if(dateConflict()) {
			
		}
		error.setText("");
	}
	
    private boolean dateConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	@FXML
    void addTrip(ActionEvent event) {
    	try {
			checkForError();
			//retrieve saved customer
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			Customer co = (Customer) stage.getUserData();
			
		} catch (Exceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void saveUsername(String username) {
		//co.setUsername(username);
		your_trip.setText(username);
	}

}
