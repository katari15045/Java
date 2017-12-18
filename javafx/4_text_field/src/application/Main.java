package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application 
{
	private Label label;
	private TextField textField;
	private Button button;
	
	@Override
	public void start(Stage primaryStage) 
	{
		label = new Label();
		textField = new TextField();
		button = new Button();
		
		label.setText("Integer ");
		textField.setPromptText("Integer please...");
		button.setLineSpacing(90);
		button.setText("Submit");
		button.setOnAction( new MyHandler(textField) );
		
		try 
		{
			GridPane pane = new GridPane();
			pane.setAlignment( Pos.CENTER );
			pane.setPadding( new Insets(30, 30, 30, 30 ) );
			pane.add(label, 0, 0);
			pane.add(textField, 1, 0);
			pane.add(button, 0, 2);
			GridPane.setMargin(button, new Insets(30, 0, 0, 0));
			
			Scene scene = new Scene(pane,900,400);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Square of a number");
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
	private TextField textField;
	private Integer numEntered;
	
	public MyHandler(TextField inpTextField)
	{
		textField = inpTextField;
	}
	
	public void handle(ActionEvent event)
	{
		numEntered = Integer.valueOf( textField.getText() );
		alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Result");
		alert.setHeaderText("Square of the number");
		alert.setContentText( String.valueOf( numEntered*numEntered ) );
		alert.show();
	}
}










