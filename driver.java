package EchoProject;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class driver extends JFrame implements ActionListener
{
	private  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private Container contentPane;
	private JTextField userNameInput;
	private JPasswordField passwordInput;
	private mainWindow mainW;
	private changeWindow change;
	private Calendar calendar ;//= Calendar.getInstance();
	private Timestamp loginTime;// = new java.sql.Timestamp(calendar.getTime().getTime());

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new driver();
	}
	
	public driver(){
        super("Echo.Shoes - logIn");
        calendar = Calendar.getInstance();
        loginTime = new java.sql.Timestamp(calendar.getTime().getTime());
        setLayout(new GridLayout(4,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setMinimumSize(new Dimension(400,170));
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        contentPane=getContentPane();
        createLogin();
       
     }
	
	//********************************************		GETTER FOR LOGIN TIME	************************************
	public Timestamp getLoginTime()
	{
		return loginTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("Cancel"))
		{
			System.exit(0);
		}
		else if (command.equals("Log In"))
		{   
				//loginTime = new java.sql.Timestamp(calendar.getTime().getTime());
				String un = userNameInput.getText();
				String pass = passwordInput.getText();
				  DBConnect actualUser = new DBConnect(un,pass);
				  String UserAcces = actualUser.getPrivilages();
				  if(UserAcces.equalsIgnoreCase("No Access"))
				  {
					  System.out.println("not find " + UserAcces);
					  actualUser.setLog(loginTime,loginTime);
					  JOptionPane.showMessageDialog(null, UserAcces  + " Try again");
				  }
				  else{
					  dispose();
					  change = new changeWindow(actualUser, getLoginTime());
				  }
		}
	}
	
	//***********************************************************		CREATE LOGIN WINDOW		**************************************************
	public void createLogin()
	{
		JPanel top = new JPanel();
		JLabel echoLabel = new JLabel("Eco.Shoes login");
		top.add(echoLabel);
		JPanel logTop = new JPanel(new GridLayout(1,2));
		JPanel logTopLeft = new JPanel();
		JPanel logTopRigth = new JPanel();
		logTopLeft.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logTopRigth.setLayout(new FlowLayout(FlowLayout.LEFT));
		logTop.add(logTopLeft);
		logTop.add(logTopRigth);
		logTop.setBackground(Color.yellow);
		JPanel logBotton = new JPanel(new GridLayout(1,2));
		JPanel logBottonLeft = new JPanel();
		JPanel logBottonRigth = new JPanel();
		logBotton.add(logBottonLeft);
		logBotton.add(logBottonRigth);
		logBottonLeft.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logBottonRigth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel logButtons = new JPanel();
		JButton logCancel = new JButton("Cancel");
		logCancel.addActionListener(this);
		JButton logLogin = new JButton("Log In");
		logLogin.addActionListener(this);
		logButtons.add(logCancel);
		logButtons.add(logLogin);
		JLabel userNameLabel = new JLabel("User name :");
		JLabel passwordLabel = new JLabel("Password :");
		userNameInput = new JTextField();
		userNameInput.setColumns(10);
		passwordInput = new JPasswordField();
		passwordInput.setColumns(10);
		logTopLeft.add(userNameLabel);
		logTopRigth.add(userNameInput);
		logBottonLeft.add(passwordLabel);
		logBottonRigth.add(passwordInput);
		contentPane.add(top);
		contentPane.add(logTop);
		contentPane.add(logBotton);
		contentPane.add(logButtons);
		setVisible(true);
	}
	

}
