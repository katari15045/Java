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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;


public class Main extends Application
{
	private Label label;
	private ChoiceBox<String> choiceBox;
	private Button button;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding( new Insets(30, 30, 30, 30) );
			
			label = new Label();
			label.setText("Country	");
			pane.add(label, 0, 0);
			
			choiceBox = new ChoiceBox<>();
			choiceBox.getItems().add("Spain");
			choiceBox.getItems().add("Italy");
			choiceBox.getItems().add("Greece");
			choiceBox.getSelectionModel().selectFirst();
			pane.add(choiceBox, 1, 0);
			
			button = new Button();
			button.setText("Visit");
			button.setOnAction( new MyHandler(choiceBox) );
			pane.add(button, 0, 1);
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
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

class MyHandler implements EventHandler<ActionEvent>
{
	private ChoiceBox<String> choiceBox;
	private String country;
	private Alert alert;
	
	public MyHandler(ChoiceBox<String> inpChoiceBox)
	{
		choiceBox = inpChoiceBox;
	}
	
	public void handle(ActionEvent event)
	{
		country = choiceBox.getValue();
		
		alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Visitor");
		alert.setHeaderText("Passport & Visa verified.");
		alert.setContentText( "Welcome to " + country + "!!!" );
		alert.show();
	}
}












