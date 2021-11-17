package gui;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class SplashScreen extends Application {
	@Override
	public void start(Stage mainStage) {
		StackPane pane = new StackPane();
		//pane.setPadding(new Insets(5, 5, 5, 5));
		Image logo = new Image ("Vista.com.png");
		ImageView view = new ImageView(logo);
		pane.getChildren().add(view);
		view.setFitHeight(100);
		view.setFitWidth(100);
		
		Scene scene = new Scene(pane);
		mainStage.setTitle("Vista Air");
		mainStage.setScene(scene);
		mainStage.show();
	}
}

