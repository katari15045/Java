package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
			button.setText("Speak!");
			button.setOnAction( new MyHandler() );
			
			StackPane root = new StackPane();
			root.getChildren().add(button);
			Scene scene = new Scene(root,900,400);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Home");
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
	@Override
	public void handle(ActionEvent event)
	{
		System.out.println("Hello World!");
	}
}
