package EchoProject;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{

    		JOptionPane.showMessageDialog(null,"Please use the Exit buton to close the application");
       
    }
	
}