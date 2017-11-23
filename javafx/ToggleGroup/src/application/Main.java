package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;


public class Main extends Application 
{
	private RadioButton radioButtonOne;
	private RadioButton radioButtonTwo;
	private RadioButton radioButtonThree;
	private ToggleGroup toggleGroup;
	private Button button;
	
	@Override
	public void start(Stage primaryStage) 
	{
		radioButtonOne = new RadioButton("Positive");
		radioButtonTwo = new RadioButton("Negative");
		radioButtonThree = new RadioButton("Neutral");
		
		toggleGroup = new ToggleGroup();
		
		
		radioButtonOne.setToggleGroup(toggleGroup);
		radioButtonTwo.setToggleGroup(toggleGroup);
		radioButtonThree.setToggleGroup(toggleGroup);
		
		button = new Button("Submit");
		button.setOnAction( new MyHandler(toggleGroup) );
		
		try 
		{
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding( new Insets(30, 30, 30, 30) );
			pane.add(radioButtonOne, 0, 0);
			pane.add(radioButtonTwo, 0, 1);
			pane.add(radioButtonThree, 0, 2);
			pane.add(button, 0, 3);
			GridPane.setMargin(button, new Insets(30, 0, 0, 0));
			GridPane.setMargin(radioButtonTwo, new Insets(10, 0, 10, 0));
			
			Scene scene = new Scene(pane,400,400);
			primaryStage.setScene(scene);
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
	private Alert alert;
	private RadioButton radioButton;
	private ToggleGroup toggleGroup;
	
	public MyHandler(ToggleGroup inpToggleGroup)
	{
		toggleGroup = inpToggleGroup;
	}
	
	public void handle(ActionEvent event)
	{
		alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Response");
		alert.setHeaderText("Your choice");
		radioButton = (RadioButton) toggleGroup.getSelectedToggle();
		alert.setContentText( radioButton.getText() );
		alert.show();
	}
}












