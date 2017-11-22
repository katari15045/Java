package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Button button = new Button();
			button.setText("Go");
			button.setOnAction( new MyHandler() );
			
			StackPane root = new StackPane();
			root.getChildren().add(button);
			
			Scene scene = new Scene(root,900,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Explore");
			primaryStage.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

class MyHandler implements EventHandler<ActionEvent>
{
	public void handle(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Destination");
		alert.setHeaderText("Reached!");
		alert.setContentText("Welcome to Bahamas!");
		alert.show();
	}
}











