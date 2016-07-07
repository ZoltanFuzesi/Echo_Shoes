package EchoProject;

import java.awt.BorderLayout;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class mainWindow extends JFrame implements connect
{
	private changeWindow changeW;
	
	
	public mainWindow() {
		    super("Echo.Shoes");
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        setLocation(0, 0);
	        setResizable(true);	        
	       // changeW = new changeWindow();       
	        changeW.createWorkingWindow(); 
	        //MyWindowListener n= new MyWindowListener(this);
	}
	
	
	
	

}
