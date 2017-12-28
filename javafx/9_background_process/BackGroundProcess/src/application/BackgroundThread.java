package application;

import javafx.concurrent.Task;
import javafx.scene.control.Button;

public class BackgroundThread extends Task<Boolean>
{	
	private Button button = null;
	
	public BackgroundThread(Button button) 
	{
		this.button = button;
	} 
	
	@Override
	public Boolean call()
	{
		Integer count = 0;
		
		updateMessage("Processing...");
		
		while( count < 999999999 )
		{
			count = count + 1;
		}
		
		button.setDisable(false);
		updateProgress(1.0, 1.0); // https://docs.oracle.com/javafx/2/ui_controls/progress.htm#CHDJJCFD
		updateMessage("Process Completed!");
		
		return true;
	}
	
	@Override
	protected void updateProgress(double workDone, double max) 
	{
		super.updateProgress(workDone, max);
	}
	
	@Override
	protected void updateMessage(String message) 
	{
		super.updateMessage(message);
	}
}
