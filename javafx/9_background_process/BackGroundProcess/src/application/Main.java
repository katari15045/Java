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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;


public class Main extends Application 
{
	private GridPane gridPane= null; 
	private Scene scene = null;
	
	private ProgressIndicator progressIndicator = null;
	private Label label = null;
	private Button button = null;
	
	private BackgroundThread backgroundThread = null;
	private Thread thread = null;
	
	@Override
	public void start(Stage stage) 
	{
		progressIndicator = new ProgressIndicator();
		progressIndicator.setProgress(-1.0);	// https://docs.oracle.com/javafx/2/ui_controls/progress.htm#CHDJJCFD
		label = new Label();
		button = new Button();
		button.setText("Next step");
		button.setOnAction( new MyHandler(stage) );
		button.setDisable(true);
		
		gridPane = new GridPane();
		gridPane.add(progressIndicator, 0, 0);
		gridPane.add(label, 0, 1);
		gridPane.add(button, 0, 2);
		gridPane.setAlignment(Pos.CENTER);
		GridPane.setMargin(label, new Insets(20, 0, 0, 0));
		GridPane.setMargin(button, new Insets(60, 0, 0, 0));
		
		scene = new Scene(gridPane, 400, 200);
		stage.setScene(scene);
		stage.show();
		
		backgroundThread = new BackgroundThread(button);
		progressIndicator.progressProperty().bind( backgroundThread.progressProperty() );
		label.textProperty().bind( backgroundThread.messageProperty() );
		
		thread = new Thread(backgroundThread);
		thread.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


class MyHandler implements EventHandler<ActionEvent>
{
	private Label label = null;
	private GridPane gridPane = null;
	private Scene scene = null;
	private Stage stage = null;
	
	public MyHandler(Stage stage)
	{
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		label = new Label();
		label.setText("WOW!!!");
		
		gridPane = new GridPane();
		gridPane.add(label, 0, 0);
		gridPane.setAlignment(Pos.CENTER);
		
		scene = new Scene(gridPane, 600, 400);
		stage.setScene(scene);
		stage.show();
	}
}














