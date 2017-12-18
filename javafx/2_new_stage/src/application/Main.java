package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class Main extends Application
{
	private Button button;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			StackPane pane = new StackPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding( new Insets(30, 30, 30, 30) );
			
			button = new Button();
			button.setText("Go");
			button.setOnAction( new MyHandler() );
			pane.getChildren().add(button);
			
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
	private Stage stage;
	private Scene scene;
	private StackPane pane;
	private Label label;
	
	
	public void handle(ActionEvent event)
	{
		pane = new StackPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding( new Insets(30, 30, 30, 30) );
		
		label = new Label();
		label.setText("New country!");
		pane.getChildren().add(label);
		
		scene = new Scene(pane, 400, 400);
		
		stage = new Stage();
		stage.setTitle("New Country!");
		stage.setScene(scene);
		stage.show();
	}
}











