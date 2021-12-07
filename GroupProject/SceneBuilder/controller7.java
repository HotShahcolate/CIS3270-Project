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
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import code.Customer;
import code.Exceptions;
import db.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class controller7 implements Initializable{
	 @FXML private ImageView image;
	 @FXML private StackPane stack_pane;
	 
	    @FXML
	    private ComboBox bookedFlights;
	    
	    @FXML
	    private Label error;
	 
	 private Scene main;
	 
	 private int selectedFlightIndex;
	 
	 ResultSet yourTrips;
	 
	 
	 public void setMainScene (Scene scene) {
		 main = scene;
	 }
	 
	 	 
	 public void setImage (Pane root) {
			image.fitWidthProperty().bind(root.widthProperty());
			image.fitHeightProperty().bind(root.heightProperty());
		}
	 
	 public void setBox (Pane root) {
			stack_pane.prefWidthProperty().bind(root.widthProperty());
			stack_pane.prefHeightProperty().bind(root.heightProperty());
		}
	 
	 public void openMain(MouseEvent event) {
	        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(main);
		 
		
	    }
	 
	 @FXML
	 void loadTrips(ActionEvent event) {
		 
		ObservableList<String> yourTripsStrings = FXCollections.observableArrayList();

		//retrieve saved customer
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Customer co = (Customer) stage.getUserData();
		try {
			//set the id of the logged in user from the database
			co.setId(Main.retrieveCustomerID(co));
			//load your flights 
			yourTrips = Main.loadYourFlights(co);
			while (yourTrips.next()) {
				yourTripsStrings.add(yourTrips.getString("from") + " to " + yourTrips.getString("to") + " on " + yourTrips.getString("date"));
			}
			error.setText("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error.setText("You have not booked any flights");
		}
		bookedFlights.setItems(yourTripsStrings);
	 }
	 
	@FXML
	void selectedFlight(ActionEvent event) {
		selectedFlightIndex = bookedFlights.getSelectionModel().getSelectedIndex();
	}
	 
	@FXML
	void deleteFlight(ActionEvent event) throws Exceptions {
		 try {
			 //moves cursor for resultset to the selected flight's index in the combobox
			 yourTrips.absolute(selectedFlightIndex+1);
			 //deletes this flight from the database
			Main.deleteYourFlight(yourTrips.getInt("idcustomers"), yourTrips.getInt("idflights"));
			//delete this flight from the combobox
			bookedFlights.getItems().remove(selectedFlightIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error.setText("No flight selected.");
			throw new code.Exceptions("No flight selected.");
		}
	}
	 
	@Override
    public void initialize(URL url, ResourceBundle rb) {
		
		ObservableList<String> bookedFlightsStrings = FXCollections.observableArrayList();        
    }    
}
