package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;


public class Main extends Application 
{
	private CheckBox checkBoxOne;
	private CheckBox checkBoxTwo;
	private CheckBox checkBoxThree;
	private Button button;
	
	@Override
	public void start(Stage primaryStage) 
	{
		checkBoxOne = new CheckBox("Argentina");
		checkBoxTwo = new CheckBox("Venezuela");
		checkBoxThree = new CheckBox("Chile");
		button = new Button("Submit");
		button.setOnAction( new MyHandler(checkBoxOne, checkBoxTwo, checkBoxThree) );
		
		try 
		{
			GridPane pane = new GridPane();
			pane.add(checkBoxOne, 0, 0);
			pane.add(checkBoxTwo, 0, 1);
			pane.add(checkBoxThree, 0, 2);
			pane.add(button, 0, 3);
			pane.setAlignment(Pos.CENTER);
			pane.setPadding( new Insets(30, 30, 30, 30) );
			GridPane.setMargin(checkBoxTwo, new Insets(10, 0, 10, 0));
			GridPane.setMargin(button, new Insets(30, 0, 0, 0));
			
			Scene scene = new Scene(pane,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

class MyHandler implements EventHandler<ActionEvent>
{
	private CheckBox checkBoxOne;
	private CheckBox checkBoxTwo;
	private CheckBox checkBoxThree;
	private Alert alert;
	private String content;
	
	public MyHandler(CheckBox checkBoxOne, CheckBox checkBoxTwo, CheckBox checkBoxThree)
	{
		this.checkBoxOne = checkBoxOne;
		this.checkBoxTwo = checkBoxTwo;
		this.checkBoxThree = checkBoxThree;
	}
	
	public void handle(ActionEvent event)
	{
		content = new String();
		
		if( checkBoxOne.isSelected() )
		{
			content = "Argentina\n";
		}
		
		if( checkBoxTwo.isSelected() )
		{
			content = content + "Venezuela\n";
		}
		
		if( checkBoxThree.isSelected() )
		{
			content = content + "Chile\n";
		}
		
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Response");
		alert.setHeaderText("You've chosen");
		alert.setContentText(content);
		alert.show();
	}
}














