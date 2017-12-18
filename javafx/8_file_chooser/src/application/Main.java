// Tutorial -> https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm

package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application 
{
	Button button;
	
	@Override
	public void start(Stage stage) 
	{
		stage.setTitle("File Chooser");
		
		button = new Button();
		button.setText("Open");
		button.setOnAction( new MyHandler(stage) );
		
		StackPane root = new StackPane();
		root.getChildren().add(button);
		
		Scene scene = new Scene(root, 900, 400);
		stage.setScene(scene);
		stage.setTitle("Picture explorer");
		stage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

class MyHandler implements EventHandler<ActionEvent>
{
	Stage stage;
	FileChooser fileChooser;
	File file;
	
	public MyHandler(Stage inpStage) 
	{
		stage = inpStage;
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		fileChooser = new FileChooser();
		fileChooser.setTitle("Select a Picture!");
		fileChooser.setInitialDirectory( new File(System.getProperty("user.home")) );
		file = fileChooser.showOpenDialog(stage);
		
		if( file != null )
		{
			System.out.println("Got it!");
		}
	}
}
