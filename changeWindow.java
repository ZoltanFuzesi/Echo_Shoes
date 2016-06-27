package EchoProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.commons.validator.EmailValidator;


public class changeWindow extends JFrame implements ActionListener
{
	private File imageToUpload = null;
	private DBConnect dbUser;
	private mainWindow mainW;
	private BufferedImage image = new BufferedImage(250, 150, BufferedImage.SCALE_FAST);//ImageIO.read(DatabaseGui.class.getClass().getResourceAsStream("/images/DataB.jpg"));
    private ImageIcon img =  new ImageIcon(image);  
    private JLabel labBack = new JLabel(img, SwingConstants.CENTER);
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
	private int returnVal;
	@SuppressWarnings("unused")
	private  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private  GridBagConstraints c = new GridBagConstraints();   
	private	Dimension dropDim = new Dimension(250,25);	
		//JPanels main structure
	private	JPanel mainTop = new JPanel(new GridLayout(2,4));
	private	JPanel mainBotton = new JPanel();
	private	JPanel mainBottonOne = new JPanel();
	private	JPanel mainBottonTwo = new JPanel();
	private	JPanel mainBottonThree = new JPanel();
	private	JPanel mainBottonFour = new JPanel();
	private	JPanel mainBottonFive = new JPanel();
	private	JPanel mainBottonSix = new JPanel();
	private	JPanel mainBottonSeven = new JPanel();
	private	JPanel mainBottonEigth = new JPanel();
	private	JPanel mainCenter = new JPanel();
	private	JPanel mainLeft = new JPanel();//gridlayout 3,1
	private	JPanel emptyOne = new JPanel();
	private	JPanel emptyTwo = new JPanel();
	private	JPanel emptyFour = new JPanel();
	private	JPanel emptyFive = new JPanel();
	private	JPanel emptySix = new JPanel();
	private	JPanel emptySeven = new JPanel();
	private	JPanel emptyEigth = new JPanel();
	private	JPanel emptyNine = new JPanel();
	private	JPanel emptyTen = new JPanel();
	private	JPanel emptyEleven = new JPanel();		
	private	JPanel leftOne = new JPanel();
	private	JPanel leftOneTop = new JPanel();
	private	JPanel leftOneBotton = new JPanel();
	private	JPanel leftTwo = new JPanel();
	private	JPanel leftThree = new JPanel();
	private	JPanel leftThreeTop = new JPanel();
	private	JPanel leftThreeBotton = new JPanel();
	private	JPanel innerCenter = new JPanel();//layout 12,1	
	private	JPanel innerOne = new JPanel();
	private	JPanel innerOne1 = new JPanel();
	private	JPanel innerOne2 = new JPanel();
	private	JPanel innerOne3 = new JPanel();	
	private	JPanel innerTwo = new JPanel();
	private	JPanel twoone = new JPanel();
	private	JPanel twoTwo = new JPanel();	
	private	JPanel innerThree = new JPanel();
	private	JPanel threeone = new JPanel();
	private	JPanel threeTwo = new JPanel();	
	private	JPanel innerFour = new JPanel();
	private	JPanel fourone = new JPanel();
	private	JPanel fourTwo = new JPanel();		
	private	JPanel innerFive = new JPanel();
	private	JPanel fiveone = new JPanel();
	private	JPanel fiveTwo = new JPanel();		
	private	JPanel innerSix = new JPanel();
	private	JPanel sixone = new JPanel();
	private	JPanel sixTwo = new JPanel();	
	private	JPanel innerSeven = new JPanel();
	private	JPanel sevenone = new JPanel();
	private	JPanel sevenTwo = new JPanel();	
	private	JPanel innerEigth = new JPanel();
	private	JPanel eigthone = new JPanel();
	private	JPanel eigthTwo = new JPanel();		
	private	JPanel innerNine = new JPanel();
	private	JPanel nineone = new JPanel();
	private	JPanel nineTwo = new JPanel();		
	private	JPanel innerTen = new JPanel();
	private	JPanel tenone = new JPanel();
	private	JPanel tenTwo = new JPanel();		
	private	JPanel innerEleven = new JPanel();
	private	JPanel elevenone = new JPanel();
	private	JPanel elevenTwo = new JPanel();		
	private	JPanel innerTwelve = new JPanel();
	private	JPanel innerTwelveOne = new JPanel();
	private	JPanel innerTwelveTwo = new JPanel();
	private	JPanel innerTwelveThree = new JPanel();
	private	JLabel adm = new JLabel("Admin Actions");
	private	JLabel sup = new JLabel("Supplier Actions");
	private	JLabel cus = new JLabel("Customer Actions");
	private	JLabel pro = new JLabel("Product Actions");
	private	JLabel locationLabel2 = new JLabel("");
	private	JLabel locationLabel3= new JLabel("");
	private	JLabel uploadImageLabel= new JLabel("Select image to product");
	private	JLabel pictureNameLabel= new JLabel("");
	private	JButton exit = new JButton("Exit");
	private	JButton action = new JButton("Action");
	private	JButton action1 = new JButton("Search.");
	private	JButton action2 = new JButton("Search..");
	private	JButton action3 = new JButton("Search...");
	private	JButton action4 = new JButton("Add.");
	private	JButton action5 = new JButton("Add..");
	private	JButton action6 = new JButton("Add...");
	private	JButton action7 = new JButton("Delete.");
	private	JButton action8 = new JButton("Delete..");
	private	JButton action9 = new JButton("Delete...");
	private	JButton action10 = new JButton("Add User");
	private	JButton action11= new JButton("Delete User");
	private	JButton action12 = new JButton("History");		
	private	JButton addPhoto = new JButton("Add Photo");
	private JButton passwordButton = new JButton("Change Password");
		//Button holder panels
	private	JPanel adminLabel = new JPanel();
	private	JPanel supplierLabel = new JPanel();
	private	JPanel customerLabel = new JPanel();
	private	JPanel productLabel = new JPanel();
	private	JPanel adminHolder = new JPanel();
	private	JPanel supplierHolder = new JPanel();
	private	JPanel customerHolder = new JPanel();
	private	JPanel productHolder = new JPanel();		
		//search bropdown boxes
	private	DefaultComboBoxModel searchByID = new DefaultComboBoxModel();	
	private	JComboBox searchByIdBox = new JComboBox(searchByID);	
	private	DefaultComboBoxModel searchByName = new DefaultComboBoxModel();	
	private	JComboBox searchByNameBox = new JComboBox(searchByName);			
		//Main action drop down boxes and label
	private	JLabel dropIdLabel = new JLabel("");		
	private	JTextField dropIDText  = new JTextField();		
	private	JLabel dropNameLabel = new JLabel("");
	//private	DefaultComboBoxModel Name = new DefaultComboBoxModel();	
	private	JTextField dropNameText  = new JTextField();		
	private	JLabel dropStreetLabel = new JLabel("");
	//private	DefaultComboBoxModel Street = new DefaultComboBoxModel();	
	private	JTextField dropStreetText  = new JTextField();		
	private	JLabel dropTownLabel = new JLabel("");
	private	JTextField dropTownText = new JTextField();
	private	JLabel dropCountyLabel = new JLabel("");
	private	JTextField dropCountyText = new JTextField();	
	private	JLabel dropCountryLabel = new JLabel("");
	private JTextField dropCountryText = new JTextField();		
	private	JLabel dropPostCodeLabel = new JLabel("");
	private	JTextField dropPostCodeText = new JTextField();		
	private	JLabel dropEmailLabel = new JLabel("");
	private	JTextField dropEmailText = new JTextField();		
	private JLabel dropContactLabel = new JLabel("");
	private JTextField dropContactText = new JTextField();		
	private	JLabel dropProductLabel = new JLabel("");
	private DefaultComboBoxModel Products = new DefaultComboBoxModel();	
	private	JComboBox dropProducts = new JComboBox(Products);
	private	JTextField dropProductsText = new JTextField();
	private history history;
	private int stateControll = 0;
	private int selectedSupplier;
	private String buyProductCustomer = "";
	private String imagename = "";
	private int index = 0;
	private int imageSelected = 0;
	Timestamp loginTime;
	
	public changeWindow(DBConnect user, Timestamp loginTime)
	{
		  super("Echo.Shoes");
		  this.loginTime = loginTime;
		    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
	        setLocation(0, 0);
	        setResizable(true);	               
	        createWorkingWindow(); 
	        dbUser = user;// connection object reference
	        history = new history(dbUser);
	       // sqlObjt = new sqlMethods(dbUser);
	}
	
	//********************************************************	LOAD DEFAULT PICTURE FOR IMAGE	****************************************
	private void clearPicture() throws IOException
	{
		//getResource
		image = ImageIO.read(ResourceLoader.load("Default.JPG"));
		//image = ImageIO.read(getClass().getResource("/resource/Default.jpg"));//working in eclipse
        int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
		BufferedImage resizeImageJpg = resizeImage(image, type);
        ImageIcon icon=new ImageIcon(resizeImageJpg); // ADDED
        labBack.setIcon(icon); // ADDED
        labBack.revalidate(); // ADDED
        labBack.repaint();
	}
	
	//******************************************************	GETTER FOR LOGIN TIME	************************************
	private Timestamp getLogInTime()
	{
		return loginTime;
	}
	
	//*******************************************************	GETTER FOR LOG OUT TIME		***************************************
	private Timestamp getActualTime()
	{
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		return currentTimestamp;
	}
	
	//***********************************************************************	SETTING SUPPLIER DETAILS IN FIELDS FROM ID		**********************************
	public void fillSupplierFieldFromID(String [] arr)
	{
		dropIDText.setText(arr[0]);
		dropNameText.setText(arr[1]);
		dropStreetText.setText(arr[2]);
		dropTownText.setText(arr[3]);
		dropCountyText.setText(arr[4]);
		dropCountryText.setText(arr[5]);
		dropPostCodeText.setText(arr[6]);
		dropEmailText.setText(arr[7]);
		dropContactText.setText(arr[8]);
	}
	
	//***********************************************************************	SETTING SUPPLIER DETAILS IN FIELDS FROM NAME		**********************************
	public void fillSupplierFieldFromName(String [] arr)
	{
		dropIDText.setText(arr[0]);
		dropNameText.setText(arr[1]);
		dropStreetText.setText(arr[2]);
		dropTownText.setText(arr[3]);
		dropCountyText.setText(arr[4]);
		dropCountryText.setText(arr[5]);
		dropPostCodeText.setText(arr[6]);
		dropEmailText.setText(arr[7]);
		dropContactText.setText(arr[8]);
	}
	
	//***********************************************************************	CHECK IMAGE NAME FOR WHITESPACE		**********************************
	private boolean checkImageName(String filename)
	{
		boolean ch = true;
		for(int i=0;i<filename.length();i++)
    	{
    		if(filename.charAt(i) == ' ')
    		{
    			ch = false;
    		}
    	}
		if(!ch)
			error("Please remove white space of image name !!");
		return ch;
	}
	
	//***********************************************************************	SETTER HELP TO MAKE DECISION IF IMAGE SELECTED		**********************************
	private void isImageSelected(int i)
	{
		imageSelected = i;
	}
	
	//***********************************************************************	GETTER HELP TO MAKE DECISION IF IMAGE SELECTED		**********************************
	private boolean getImageSelectedCheck()
	{
		return (imageSelected==0) ? false : true;
	}

	//***********************************************************************	CHECK FILE SIZE		**********************************
	private boolean checkFileSize(File file)
	{
		boolean check = false;
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		double megabytes = (kilobytes / 1024);
		if(megabytes<= 0.5)
		{
			check = true;
		}
		return check;
	}
	
	//***********************************************************************	ERROR POPUP WINDOW		**********************************
	private void error(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	
	//***********************************************************************	FILL USER FIELDS FROM ID		**********************************
	private void fillUserFieldFromID(String [] arr)
	{
		dropIDText.setText(arr[0]);
		dropNameText.setText(arr[1]);
	}
	
	//***********************************************************************	GET DETAILS BY ID SUUPLIER, CUSTOMER, PRODUCT		**********************************
	public void getDetailsById(int index) throws SQLException, MalformedURLException, IOException
	{
		if(stateControll == 1)//supplier
		{
			fillSupplierFieldFromID(dbUser.supplierIdDetails(index));
		}
		else if(stateControll == 2)//customer
		{
			fillSupplierFieldFromID(dbUser.customerIdDetails(index));
		}
		else if(stateControll == 3)//product
		{
			fillSupplierFieldFromID(dbUser.productIdDetails(index));
		}
		else if(stateControll == 4)//user
		{
			String [] arr = {"Access", "Denied"};
			if(dbUser.getActualUser().equals("zoltan"))
				fillUserFieldFromID(dbUser.getUserDetails(index));
			else
				fillUserFieldFromID(arr);
		}
		
	}
	
	//***********************************************************************	GET DETAILS BY NAME SUUPLIER, CUSTOMER, PRODUCT		**********************************
	public void getDetailsByName(String name) throws SQLException, MalformedURLException, IOException
	{
		if(stateControll == 1)//supplier
		{
			fillSupplierFieldFromName(dbUser.supplierNameDetails(name));
		}
		else if(stateControll == 2)//customer
		{
			fillSupplierFieldFromName(dbUser.customerNameDetails(name));
		}
		else if(stateControll == 3)//product
		{
			fillSupplierFieldFromName(dbUser.productNameDetails(name));
		}
		else if(stateControll == 4)//user
		{
			String [] arr = {"Access", "Denied"};
			if(dbUser.getActualUser().equals("zoltan"))
				fillUserFieldFromID(dbUser.getUserDetails(index));
			else
				fillUserFieldFromID(arr);
		}
		
		
	}
	//***************************************************************	PRODUCT IMAGE	 ************************************************************************
	public void setProductImage() throws IOException
	{
		image = dbUser.getImageName();
		int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
		BufferedImage resizeImageJpg = resizeImage(image, type);
	    img =  new ImageIcon(resizeImageJpg);  
        labBack.setIcon(img); // ADDED
        labBack.setMaximumSize(new Dimension(250,150));
        labBack.revalidate(); // ADDED
        labBack.repaint(); // ADDED
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(250, 150, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 250, 150, null);
		g.dispose();
			
		return resizedImage;
	    }
	
	private void setIndex(int ind)
	{
		index = ind;
	}

	
	//********************************************************************	FILL SUPPLIER JComboBox	**************************************
	public void fillSupplierDropBox()
	{
		searchByID.removeAllElements();
		searchByName.removeAllElements();
		String[] arrId = null;
		String[] arrName = null;
		try {
			arrId = dbUser.supplierIdDropBox();
			arrName = dbUser.supplierNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arrId ) {
			searchByID.addElement( newRow );
		}
		for( String newRow : arrName ) {
			searchByName.addElement( newRow );
		}
	
		searchByIdBox.setModel(searchByID);
		searchByNameBox.setModel(searchByName);
	}
	
	//*******************************************************************	FILL CUSTOMER  JComboBox	**************************************
	public void fillCustomerDropBox()
	{
		searchByID.removeAllElements();
		searchByName.removeAllElements();
		String[] arrId = null;
		String[] arrName = null;
		try {
			arrId = dbUser.customerIdDropBox();
			arrName = dbUser.customerNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arrId ) {
			searchByID.addElement( newRow );
		}
		for( String newRow : arrName ) {
			searchByName.addElement( newRow );
		}
	
		searchByIdBox.setModel(searchByID);
		searchByNameBox.setModel(searchByName);
	}

	//*****************************************************************	FILL PRODUCT JComboBox	**************************************
	public void fillProductDropBox() throws MalformedURLException, IOException
	{
		searchByID.removeAllElements();
		searchByName.removeAllElements();
		String[] arrId = null;
		String[] arrName = null;
		try {
			arrId = dbUser.productIdDropBox();
			arrName = dbUser.productNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arrId ) {
			searchByID.addElement( newRow );
		}
		for( String newRow : arrName ) {
			searchByName.addElement( newRow );
		}
	
		searchByIdBox.setModel(searchByID);
		searchByNameBox.setModel(searchByName);
	}
	
	//********************************************************	FILL CUSTOMER FOR SELECT PRODUCT TO BUYING JComboBox	**************************************
	public void fillBuyProductDropDown()
	{
		Products.removeAllElements();
		String[] arr = null;
		try {
			arr = dbUser.productNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Products.addElement(" ");
		for( String newRow : arr ) {
			Products.addElement( newRow );
		}
		dropProducts.setModel(Products);
	}
	
	//******************************************************	FILL SUPPLIER TO ADD PRODUCT JComboBox	**************************************
	public void addSupplierToProduct()
	{
		searchByName.removeAllElements();
		String[] arr = null;
		try {
			arr = dbUser.supplierNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arr ) {
			searchByName.addElement( newRow );
		}
		searchByNameBox.setModel(searchByName);
	}
	
	//*************************************************************	FILL PRODUCT FOR SUPPLIER JComboBox	**************************************
	public void fillProConnectedDropBox(int index)
	{
		Products.removeAllElements();
		String[] arr = null;
		try {
			arr = dbUser.productConnectedDropBox(index);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arr ) {
			Products.addElement( newRow );
		}
		dropProducts.setModel(Products);
	}

	//*********************************************************	FILL CUSTOMER BUYING JComboBox	**************************************
	public void fillCustomerConnectedDropBox(int index)
	{
		Products.removeAllElements();
		String[] arr = null;
		try {
			arr = dbUser.customerConnectedDropBox(index);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arr ) {
			Products.addElement( newRow );
		}
		dropProducts.setModel(Products);
	}
	
	//***************************************************	FILL DELETE USER JComboBox	**************************************
	private void fillDeleteUserDropDownBoxes()
	{
		searchByID.removeAllElements();
		searchByName.removeAllElements();
		String[] arrId = null;
		String[] arrName = null;
		try {
			arrId = dbUser.usersIDDropBox();
			arrName = dbUser.usersNameDropBox();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for( String newRow : arrId ) {
			searchByID.addElement( newRow );
		}
		for( String newRow : arrName ) {
			searchByName.addElement( newRow );
		}
	
		searchByIdBox.setModel(searchByID);
		searchByNameBox.setModel(searchByName);
	}
	
	
	//**********************************************************	CHECH INPUT FOR NUMBER	**************************************
	private boolean checkNumberInput(String str)
	{
		boolean ch = true;
		try
		{
			int i = Integer.parseInt(str);
		}catch(NumberFormatException e){
			ch = false;
		}
		
		return ch;
	}
	
	
	//********************************************************	DELETE SUPPLIER*****************************************
	public void deleteSupplier(String name)
	{
		locationLabel2.setText(dbUser.deleteSupplier(name));
		clearAllField();
		fillSupplierDropBox();
		
	}
	
	//********************************************************	DELETE CUSTOMER*****************************************
	public void deleteCustomer(String name)
	{
		locationLabel2.setText(dbUser.deleteCustomer(name));
		clearAllField();
		fillCustomerDropBox();	
	}
	
	//********************************************************	DELETE PRODUCT	*****************************************
	public void deleteProduct(String name) throws MalformedURLException, IOException
	{
		locationLabel2.setText(dbUser.deleteProduct(name));
		clearAllField();
		fillProductDropBox();	
	}
	
	//********************************************************	ADD SUPPLIER	*****************************************
	public void addSupplierToDatabase() throws ClassNotFoundException, SQLException 
	{
		 String name =  dropNameText.getText().toString();
		 String street = dropStreetText.getText();
		 String town = dropTownText.getText();
		 String county = dropCountyText.getText();
		 String country = dropCountryText.getText();
		 String postCode = dropPostCodeText.getText();
		 String email = dropEmailText.getText();
		 String contact = dropContactText.getText();
		 
		 if(name.length()>0&&street.length()>0&&town.length()>0&&county.length()>0&&country.length()>0&&postCode.length()>0&&email.length()>0&&contact.length()>0)
		 {
			 if(checkNumberInput(contact)&&isValidEmail(email))
			 {
			 
				 System.out.println("Adding supplier name " + name);
				 dbUser.setSupplierName(name);
				if(dbUser.addSupplier(name,street ,town ,county ,country ,postCode ,email ,contact))
				{
					locationLabel2.setText("The Supplier was inserted");
					hideAll();
				}
				else
				{
					locationLabel2.setText("Error occured");
				}
			 }
			 else
			 {
				 if(!isValidEmail(email))
					 error("Incorrect email format");
				 else if(!checkNumberInput(contact))
					error("Wrong contact input use number");
			 }
		 }
		 else
		 {
			 error("Empty fields");
		 }
	
	}
	
	//********************************************************	ADD CUSTOMER	*****************************************
	public void addCustomerToDatabase() throws ClassNotFoundException, SQLException 
	{
		 String name =  dropNameText.getText().toString();
		 String street = dropStreetText.getText();
		 String town = dropTownText.getText();
		 String county = dropCountyText.getText();
		 String country = dropCountryText.getText();
		 String postCode = dropPostCodeText.getText();
		 String email = dropEmailText.getText();
		 String contact = dropContactText.getText();
		 
		 if(checkNumberInput(contact)&&isValidEmail(email))
		 {
			 if(name.length()>0&&street.length()>0&&town.length()>0&&county.length()>0&&country.length()>0&&postCode.length()>0&&email.length()>0&&email.length()>0&&contact.length()>0)
			 {
				 dbUser.setCustomerName(name);
				locationLabel2.setText(dbUser.addCustomer(name,street ,town ,county ,country ,postCode ,email ,contact));
				clearAllField();
				hideAll();
			 }
			 else
			 {
				 error("Empty fields");
			 }
		 }
		 else
		 {
			 if(!isValidEmail(email))
				 error("Incorrect email format");
			 else if(!checkNumberInput(contact))
				error("Wrong contact input use number");
		 }
	
	}
	
	//********************************************************	ADD PRODUCT	*****************************************
	public void addProductToDatabase() throws ClassNotFoundException, SQLException, IOException
	{
		
		 String desc =  dropNameText.getText().toString();
		 String supID = dropStreetText.getText();
		 String gender = dropTownText.getText();
		 String size = dropCountyText.getText();
		 String priceString = dropCountryText.getText();
		 String colour = dropPostCodeText.getText();
		 String stockString = dropEmailText.getText();
		 if(desc.length()>0&&supID.length()>0&&gender.length()>0&&size.length()>0&&priceString.length()>0&&colour.length()>0&&stockString.length()>0)
		 {
			 if(getImageSelectedCheck()&&checkNumberInput(priceString)&&checkNumberInput(stockString)&&checkNumberInput(size))
			 {
				 dbUser.setProduct(desc);
				double price = Double.parseDouble(dropCountryText.getText());
				int stock = Integer.parseInt(dropEmailText.getText());
				locationLabel2.setText(dbUser.addProduct(desc,supID ,gender ,size ,price ,colour ,stock ,  "picture_library/"+getImageName(),  getSelectedImage(), getImageName()));
				clearAllField();
				addPhoto.setVisible(false);
				isImageSelected(0);
				clearPicture();
				hideAll();
			 }
			 else
			 {
				 locationLabel2.setText("Please check inputs");
				 if(!checkNumberInput(size))
					 error("Wrong size input use number");
				 else if(!checkNumberInput(priceString))
					 error("Wrong price input use number");
				 else if(!checkNumberInput(stockString))
					 error("Wrong stock input use number");
				 else if(!getImageSelectedCheck())
					 error("Please select a picture");
			 }
		 }
		 else
		 {
			 error("Empty fields or Empty picture");
			
		 }
	}
	
	//********************************************************************	SETTERS	*********************************************************************
	private void setSelectedImage(File image)
	{
		imageToUpload = image;
	}
	
	private File getSelectedImage()
	{
		return imageToUpload;
	}
	
	private void setImageNameToUpload(String imgName)
	{
		imagename = imgName;
	}
	
	public String getImageName()
	{
		return imagename;
	}
	

	//*******************************************************************************	DELETING SUPPLIER, CUSTOMER, PRODUCT	*********************************************
	public void deletePopup() throws MalformedURLException, IOException
	{
		String str = "";
		if(stateControll==1){
			str = "Supplier";
		}
		else if(stateControll==2){
			str = "Customer";
		}
		else if(stateControll==3){
			str = "Product";
		}
		int dialogButton = JOptionPane.showConfirmDialog (null, "Delete "+ str +" " + dropNameText.getText() + "?","WARNING",JOptionPane.YES_NO_OPTION);

    	if(dialogButton == JOptionPane.YES_OPTION&&stateControll==1)
    	{
    		deleteSupplier(dropIDText.getText());
    		hideAll();
    	}
    	else if(dialogButton == JOptionPane.YES_OPTION&&stateControll==2)
    	{
    		deleteCustomer(dropIDText.getText());
    		hideAll();
    	}
    	if(dialogButton == JOptionPane.YES_OPTION&&stateControll==3)
    	{
    		deleteProduct(dropIDText.getText());
    		hideAll();
    	}

	}
	
	//**********************************************************************	ADD USER CHANGE DETAILS DELETE	********************************************************
	
	private String[] getUserDetails()
	{
		String[]fields = new String[7];
		
		fields[0] = dropIDText.getText();
		fields[1] = dropNameText.getText();
		fields[2] = dropStreetText.getText();
		fields[3] = dropTownText.getText();
		
		return fields;
	}
	
	//**********************************************************************	CHANGE DETAILS FOR SUPPLIER, CUSTOMER, PRODUCT	***********************************************************
	
	private String[] getFieldsToChange()
	{
		String[]fields = new String[7];
		
		fields[0] = dropStreetText.getText();
		fields[1] = dropTownText.getText();
		fields[2] = dropCountyText.getText();
		fields[3] = dropCountryText.getText();
		fields[4] = dropPostCodeText.getText();
		fields[5] = dropEmailText.getText();
		fields[6] = dropContactText.getText();
		return fields;
	}
	
	//**********************************************************************	EMAIL VALIDATION	***********************************************************

	public  boolean isValidEmail(String email) {
		EmailValidator validator = EmailValidator.getInstance();
		if (validator.isValid(email)) {
			return true;
		} else {
			return false;
		}
	}

	//**********************************************************************	CREATE NEW ADMIN USER TO LOGIN	***********************************************************************
	
	private void addUserToDatabase()
	{
	  String arr[] = getUserDetails();
	  if(arr[0].equalsIgnoreCase("")||arr[1].equalsIgnoreCase("")||arr[2].equalsIgnoreCase("")||arr[3].equalsIgnoreCase("")||!isValidEmail(arr[3]))
	  {
		 error("Empty field(s)! or invalid Email");
	  }
	  else
	  {
		  if(arr[1].equalsIgnoreCase(arr[2]))
		  {
			  dbUser.setAddedUser(arr[0]);
			  if(dbUser.addUser(arr[0],arr[1],arr[3]))
			  {
				  locationLabel2.setText("User added succesfuly");
				  hideAll();
			  }
		  }
		  else
		  {
			  error("The passwords are not same");
		  }
	  }
	}
	
	//delete user can use only main admin "zoltan"
	private void deleteUserFromDatabase()
	{
		
	}
	
	//**********************************************************************	CHANGE PASSWORD FOR ADMIN USER	***********************************************************************
	private void changeUserPassword()
	{
		String arr[] = getUserDetails();
		//-0-1-2
		if(arr[0].length()>0&&arr[1].length()>0&&arr[2].length()>0)
		{
			//check for password and repeat password input are same
			if(arr[1].equals(arr[2]))
			{
				//check for user name if user exist and same as a logged in user change password OR if default user change password to user
				if(dbUser.getActualUser().equals(arr[0])||dbUser.getActualUser().equals("zoltan"))
				{
					if(dbUser.changePassword(arr[2],arr[0]))
					{
						locationLabel2.setText("Password has change");
						hideAll();
					}
				}
				else
				{
					error("Acces Denied!");
				}
			}
			else
			{
				error("The passwords are not same!");
			}	
		}
		else
		{
			if(arr[0].length()==0)
				error("User name is empty");
			else if(arr[1].length()==0)
				error("Password field is empty");
			else if(arr[2].length()==0)
				error("Repeat password field is empty");
		}
	}
	//**********************************************************************	METHODS FINISH	**********************************************************************
	
	

	//**********************************************************************	ACTION LISTENERS	***********************************************************************
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String command = e.getActionCommand();
		
		if (command.equals("Exit"))
		{
			int dialogButton = JOptionPane.showConfirmDialog (null, "Close application ? " + dbUser.getActualUser() + " : " + getActualTime(),"WARNING",JOptionPane.YES_NO_OPTION);

	    	if(dialogButton == JOptionPane.YES_OPTION)
	    	{
	    		dbUser.setLog(getLogInTime(), getActualTime());
	    		history.closeHistory();
				System.exit(0);
	    	}	
		}
		else if(command.equals("Add User"))
		{
			clearAllField();
			setVisibleFalse();
			passwordButton.setVisible(true);
			addUser();
			
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		}
		else if(command.equals("Delete User"))
		{
			stateControll = 4;
			clearAllField();
			setVisibleFalse();
			deleteUser();
			
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if(command.equals("Change Password"))
		{
			clearAllField();
			setVisibleFalse();
			changePassword();
			
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		else if(command.equals("History"))
		{
			history.showHistoryWindow();	
		}
		else if(command.equals("Search."))
		{
			stateControll = 1;
			searchSupplier();
			setVisibleTrue();
			addPhoto.setVisible(false);
			fillSupplierDropBox();
			
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		else if(command.equals("Search.."))
		{
			stateControll = 2;
			searchCustomer();
			setVisibleTrue();
			dropProductsText.setVisible(false);
			addPhoto.setVisible(false);
			fillCustomerDropBox();
			
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if(command.equals("Search..."))
		{
			clearAllField();
			stateControll = 3;
			setVisibleTrue();
			searchProduct();
			dropEmailLabel.setText("Stock level");
			dropContactLabel.setVisible(false);
			dropProducts.setVisible(false);
			dropContactText.setVisible(false);
			addPhoto.setVisible(false);
			
				try {
					clearPicture();
					fillProductDropBox();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		else if(command.equals("Add."))
		{
			clearAllField();
			stateControll = 1;
			
				try {
					clearPicture();
					dropIDText.setText(dbUser.getNextSupplierID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			addSupplier();
			setVisibleTrue();
			dropProducts.setVisible(false);
			locationLabel3.setVisible(false);
			addPhoto.setVisible(false);
		
				
			
		}
		else if(command.equals("Add Supplier"))
		{
			try {
				clearPicture();
				addSupplierToDatabase();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(command.equals("Delete Supplier"))
		{	
				try {
					clearPicture();
					deletePopup();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
		}
		else if(command.equals("Add Customer"))
		{
			try {
				clearPicture();
				addCustomerToDatabase();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(command.equals("Delete Customer"))
		{
			try {
				deletePopup();
				//hideAll();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(command.equals("Delete Product"))
		{
			try {
				deletePopup();
				clearPicture();
				//hideAll();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(command.equals("Add.."))
		{
			clearAllField();
			stateControll = 2;
			
				try {
					clearPicture();
					dropIDText.setText(dbUser.getNextCustomerID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			addCustomer();
			setVisibleTrue();
			dropProductLabel.setText("");
			dropProducts.setVisible(false);
			locationLabel3.setVisible(false);
			addPhoto.setVisible(false);
		}
		else if(command.equals("Add..."))
		{
			clearAllField();
			setImageNameToUpload("");
			
				try {
					clearPicture();
					dropIDText.setText(dbUser.getNextProductID());
				} catch (IOException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			
			stateControll = 20;//? need?
			addSupplierToProduct();
			setVisibleTrue();
			addProduct();
			dropIDText.setBackground(Color.LIGHT_GRAY);
			dropStreetText.setEditable(false);
			dropStreetText.setBackground(Color.lightGray);
			dropEmailLabel.setText("Stock level");
			dropContactLabel.setVisible(false);
			dropProducts.setVisible(false);
			dropContactText.setVisible(false);
			locationLabel3.setVisible(true);
			searchByNameBox.setVisible(true);
		}
		else if(command.equals("Delete."))
		{
				try {
					clearPicture();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			stateControll = 1;
			deleteSupplier();
			setVisibleTrue();
			dropProducts.setVisible(false);
			addPhoto.setVisible(false);
			fillSupplierDropBox();
		}
		else if(command.equals("Create User"))
		{
			addUserToDatabase();
		}
		else if(command.equals("Delete.."))
		{
			try {
				clearPicture();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			stateControll = 2;
			deleteCustomer();
			setVisibleTrue();
			dropProducts.setVisible(false);
			addPhoto.setVisible(false);
			fillCustomerDropBox();
		}
		else if(command.equals("Delete..."))
		{
			stateControll = 3;
			setVisibleTrue();
			deleteProduct();
			dropEmailLabel.setText("Stock level");
			dropContactLabel.setVisible(false);
			dropProducts.setVisible(false);
			dropContactText.setVisible(false);
			addPhoto.setVisible(false);
			
				try {
					clearPicture();
					fillProductDropBox();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		else if(command.equals("Change Supplier Details"))
		{
			setEditableTrue();
			dropProductLabel.setVisible(false);
			dropProducts.setVisible(false);
			dropNameText.setEditable(false);
			dropNameText.setBackground(Color.lightGray);
			action.setText("Save Changes");
			addPhoto.setVisible(false);
		}
		else if(command.equals("Change Customer Details"))
		{
			setEditableTrue();
			dropProductLabel.setText("Buying product");
			dropNameText.setEditable(false);
			dropNameText.setBackground(Color.lightGray);
			action.setText("Save Changes");
			addPhoto.setVisible(false);
			searchByIdBox.setVisible(false);
			searchByNameBox.setVisible(false);
			locationLabel3.setVisible(false);
			fillBuyProductDropDown();
		}
		else if(command.equals("Save Changes"))
		{
			String[]fields = getFieldsToChange();
			if(stateControll==1)//for supplier
			{	if(checkNumberInput(fields[6])&&isValidEmail(fields[5]))
				{
					if(fields[0].length()>0&&fields[1].length()>0&&fields[2].length()>0&&fields[3].length()>0&&fields[4].length()>0&&fields[5].length()>0&&fields[6].length()>0)
					{
						dbUser.setSupplierName(dropNameText.getText());
						//get the text from fields send to method - call line 1394
						if(dbUser.changeSupplierDetails(index,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]))
						{
							locationLabel2.setText("The Supplier details was updated");
							hideAll();
						}
						else
						{
							locationLabel2.setText("Error occured the details wasn't updated");
						}
					}
					else
					{
						error("Empty fields!");
					}
				}
				else
				{
					 if(!isValidEmail(fields[5]))
						error("Incorrect email format");
					 else if(!checkNumberInput(fields[6]))
						error("Wrong input use number");
				}
			}
			else if(stateControll==2)//for customer
			{
				
				//get the text from fields send to method - call line 1394
				if(checkNumberInput(fields[6])&&isValidEmail(fields[5]))
				{
					if(fields[0].length()>0&&fields[1].length()>0&&fields[2].length()>0&&fields[3].length()>0&&fields[4].length()>0&&fields[5].length()>0&&fields[6].length()>0)
					{
						dbUser.setCustomerName(dropNameText.getText());
						if(dbUser.changeCustomerDetails(index,fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6])&&dbUser.insertBuying(String.valueOf(dropProducts.getSelectedItem()),index))
						{
							locationLabel2.setText("The Customer details was updated");
							hideAll();
						}
						else
						{
							locationLabel2.setText("Error occured the details wasn't updated");
						}
					}
					else
					{
						error("Empty fields!");
					}
				}
				else
				{
					 if(!isValidEmail(fields[5]))
						error("Incorrect email format");
					 else if(!checkNumberInput(fields[6]))
						error("Wrong input use number");
				}
			}
			else if(stateControll==3)//for product
			{
				if(checkNumberInput(fields[2])&&checkNumberInput(fields[3])&&checkNumberInput(fields[5]))
				{
					if(fields[1].length()>0&&fields[2].length()>0&&fields[3].length()>0&&fields[4].length()>0&&fields[5].length()>0)
					{
						//get the text from fields send to method - call line 1394
						dbUser.setProduct(dropNameText.getText());
						if(dbUser.changeProductDetails(index,fields[1],fields[2],fields[3],fields[4],fields[5]))
						{
							locationLabel2.setText("The Product details was updated");
							hideAll();
						}
						else
						{
							locationLabel2.setText("Error occured the details wasn't updated");
						}
					}
					else
					{
						error("Empty fields!");
					}
				}
				else
				{
					// locationLabel2.setText("Please check inputs");
					 if(!checkNumberInput(fields[2]))
						 error("Wrong size input use number");
					 else if(!checkNumberInput(fields[3]))
						 error("Wrong price input use number");
					 else if(!checkNumberInput(fields[5]))
						 error("Wrong stock input use number");

				}
			}
		}
		else if(command.equals("Change Product Details"))
		{
			setEditableTrue();
			dropProductLabel.setVisible(false);
			dropProducts.setVisible(false);
			dropNameText.setEditable(false);
			dropNameText.setBackground(Color.lightGray);
			dropStreetText.setEditable(false);
			dropStreetText.setBackground(Color.lightGray);
			action.setText("Save Changes");
			addPhoto.setVisible(false);
		}
		else if(command.equals("Delete User from database"))
		{
			deleteUserFromDatabase();
		}
		else if(command.equals("Add Product"))
		{
			try {
				addProductToDatabase();
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(command.equals("Change"))
		{
			changeUserPassword();
		}
		else if (command.equals("Add Photo")){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter=new FileNameExtensionFilter("images", "jpg","gif","png");
            fileChooser.setFileFilter(filter);
            returnVal=fileChooser.showOpenDialog(null);
            File selectedFile=fileChooser.getSelectedFile();

            String fileName = selectedFile.getName().toString();
            
            // check if the picture in the server already
            try {
				if(dbUser.isImageInServer(fileName))
				{
					error("The image already in the library! Please select different picture or rename it!");
				}
				else
				{
					if(returnVal==JFileChooser.APPROVE_OPTION){
					//check file format and size before upload
						if(checkImageName(fileName)&&checkFileSize(selectedFile)&&selectedFile.getName().endsWith(".JPG")||selectedFile.getName().endsWith(".jpg")||selectedFile.getName().endsWith(".png"))
						{
				    	
							try {
				            	setSelectedImage(selectedFile);
				            	
				                image=ImageIO.read(selectedFile);
				                int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
				        		BufferedImage resizeImageJpg = resizeImage(image, type);
				                ImageIcon icon=new ImageIcon(resizeImageJpg); // ADDED
				                labBack.setIcon(icon); // ADDED
				                labBack.revalidate(); // ADDED
				                labBack.repaint(); // ADDED
				                pictureNameLabel.setText("File name : " + fileName );
				                
				                setImageNameToUpload(fileName);
				                isImageSelected(1);
							}
							catch(IOException e1) {}
						}
				    
				    else{
				        error("Please select .jpg or .png or smaller file");
				    }
      }else if(returnVal == JFileChooser.CANCEL_OPTION){				//JFileChoser cancel button called out
				error("you closed without selecting file");
      }
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	
	}
	
	
	//***************************************************************** BUILD AND Changing GUI components ***************************************************************************
	
		public void createWorkingWindow()
		{
			
		//anonymous item state change listeners	
			//Search by id use only number for reeferencing
			searchByIdBox.addItemListener(new ItemListener() {		
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==1)
					{
							String x = String.valueOf(searchByIdBox.getSelectedItem());
						 try
						 {
							 index = Integer.parseInt(x);
							 if(stateControll == 1)
							 {
								 fillProConnectedDropBox(index);
								 getDetailsById(index);
							 }
							 else if(stateControll == 2)
							 {
								 getDetailsById(index);
								 fillCustomerConnectedDropBox(index);
							 }
							 else if(stateControll == 3)
							 {
								 getDetailsById(index);
								 setProductImage();
							 }
							 else if(stateControll == 4)
							 {
								 getDetailsById(index);
								 
							 }
							 
						 }catch(NumberFormatException | SQLException ex){
							 error("Hoops! ID Something went wrong");
						 } catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 			
					}			
				}
			});
			
			//Search by name use only string for referencing
			searchByNameBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(e.getStateChange()==1)
					{
						 String x = String.valueOf(searchByNameBox.getSelectedItem());
						 if(stateControll == 20)
						 {
							 dropStreetText.setText(x);
						 }
						 try
						 {
							 
							 if(stateControll == 1)
							 {
								 fillProConnectedDropBox(dbUser.getsupplierID(x));
								 setIndex(dbUser.getsupplierID(x));
								 getDetailsByName(x);
							 }
							 else if(stateControll == 2)
							 {
								 fillCustomerConnectedDropBox(dbUser.getcustomerID(x));
								 setIndex(dbUser.getcustomerID(x));
								 getDetailsByName(x);
							 }
							 else if(stateControll == 3){	 
								 getDetailsByName(x);
								 setIndex(dbUser.getProductID(x));
							    setProductImage();
							 }
							 else if(stateControll == 3){	 
								 getDetailsByName(x);
								 setIndex(dbUser.getProductID(x));
							 }
							 else if(stateControll == 4){	 				
								 setIndex(dbUser.getUsertID(x));
								 getDetailsByName(x);
							 }
							 
						 }catch(NumberFormatException | SQLException ex){
							 error("Hoops! Name Something went wrong");
						 } catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 			
					}
							
				}
				
			});
			//Search product use only string for referencing
			dropProducts.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					 buyProductCustomer = String.valueOf(dropProducts.getSelectedItem());
				}
			});
			//******************************************************************	ITEM STATE LISTENERS FINISH	******************************************************
			passwordButton.setVisible(false);
			setLayout(new BorderLayout());
			c.anchor = GridBagConstraints.CENTER;
			c.insets = new Insets(2, 2, 2, 2);
			//empty.setBackground(Color.BLUE);
			searchByIdBox.setPreferredSize(dropDim);
			searchByNameBox.setPreferredSize(dropDim);
			dropIDText.setPreferredSize(dropDim);
			dropNameText.setPreferredSize(dropDim);
			dropStreetText.setPreferredSize(dropDim);
			dropTownText.setPreferredSize(dropDim);
			dropCountyText.setPreferredSize(dropDim);
			dropCountryText.setPreferredSize(dropDim);
			dropPostCodeText.setPreferredSize(dropDim);
			dropEmailText.setPreferredSize(dropDim);
			dropContactText.setPreferredSize(dropDim);
			dropProductsText.setPreferredSize(dropDim);
			dropProducts.setPreferredSize(dropDim);
			
			mainCenter.setLayout(new BorderLayout());
			JPanel centerTop = new JPanel();
			mainCenter.add(centerTop, BorderLayout.NORTH);
			innerCenter.setLayout(new GridLayout(12,1));
			//*****
			innerOne.setLayout(new GridLayout(1,3));
			innerOne.add(innerOne1);
			innerOne2.add(locationLabel2);
			innerOne.add(innerOne2);
			innerOne3.add(locationLabel3);
			innerOne.add(innerOne3);
			innerCenter.add(innerOne);
			//******
			innerTwo.setLayout(new GridLayout(1,3));
			twoone.setLayout(new BorderLayout());
			twoone.add(dropIdLabel, BorderLayout.EAST);
			innerTwo.add(twoone);
			twoTwo.add(dropIDText);
			innerTwo.add(twoTwo);
			searchByIdBox.setVisible(false);
			emptyOne.add(searchByIdBox);
			innerTwo.add(emptyOne);
			innerCenter.add(innerTwo);
			//***********
			innerThree.setLayout(new GridLayout(1, 3));
			threeone.setLayout(new BorderLayout());
			threeone.add(dropNameLabel, BorderLayout.EAST);
			innerThree.add(threeone);
			dropNameText.setPreferredSize(dropDim);
			threeTwo.add(dropNameText);
			innerThree.add(threeTwo);
			searchByNameBox.setVisible(false);
			emptyTwo.add(searchByNameBox);
			innerThree.add(emptyTwo);
			innerCenter.add(innerThree);
			//***********
			innerFour.setLayout(new GridLayout(1,3));
			fourone.setLayout(new BorderLayout());
			fourone.add(dropStreetLabel, BorderLayout.EAST);
			innerFour.add(fourone);
			fourTwo.add(dropStreetText);
			innerFour.add(fourTwo);
			innerFour.add(emptyFour);
			innerCenter.add(innerFour);
			
			//**********
			innerFive.setLayout(new GridLayout(1,3));
			fiveone.setLayout(new BorderLayout());
			fiveone.add(dropTownLabel, BorderLayout.EAST);
			innerFive.add(fiveone);
			fiveTwo.add(dropTownText);
			innerFive.add(fiveTwo);
			innerFive.add(emptyFive);
			innerCenter.add(innerFive);
			//********
			innerSix.setLayout(new GridLayout(1,2));
			sixone.setLayout(new BorderLayout());
			sixone.add(dropCountyLabel, BorderLayout.EAST);
			innerSix.add(sixone);
			sixTwo.add(dropCountyText);
			innerSix.add(sixTwo);
			innerSix.add(emptySix);
			innerCenter.add(innerSix);
			//**********
			innerSeven.setLayout(new GridLayout(1,3));
			sevenone.setLayout(new BorderLayout());
			sevenone.add(dropCountryLabel, BorderLayout.EAST);
			innerSeven.add(sevenone);
			sevenTwo.add(dropCountryText);
			innerSeven.add(sevenTwo);
			innerSeven.add(emptySeven);
			innerCenter.add(innerSeven);
			//***********
			innerEigth.setLayout(new GridLayout(1,3));
			eigthone.setLayout(new BorderLayout());
			eigthone.add(dropPostCodeLabel, BorderLayout.EAST);
			innerEigth.add(eigthone);
			eigthTwo.add(dropPostCodeText);
			innerEigth.add(eigthTwo);
			innerEigth.add(emptyEigth);
			innerCenter.add(innerEigth);
			//*********
			innerNine.setLayout(new GridLayout(1,3));
			nineone.setLayout(new BorderLayout());
			nineone.add(dropEmailLabel, BorderLayout.EAST);
			innerNine.add(nineone);
			nineTwo.add(dropEmailText);
			innerNine.add(nineTwo);
			innerNine.add(emptyNine);
			innerCenter.add(innerNine);
			//************
			innerTen.setLayout(new GridLayout(1,3));
			tenone.setLayout(new BorderLayout());
			tenone.add(dropContactLabel, BorderLayout.EAST);
			innerTen.add(tenone);
			tenTwo.add(dropContactText);
			innerTen.add(tenTwo);
			innerTen.add(emptyTen);
			innerCenter.add(innerTen);
			//**************
			innerEleven.setLayout(new GridLayout(1,3));
			elevenone.setLayout(new BorderLayout());
			elevenone.add(dropProductLabel, BorderLayout.EAST);
			innerEleven.add(elevenone);
			elevenTwo.add(dropProducts);
			innerEleven.add(elevenTwo);
			innerEleven.add(emptyEleven);
			innerCenter.add(innerEleven);

			//*************USED FOR CHANGE BUTTON
			innerTwelve.setLayout(new GridLayout(1,3));
			innerTwelve.add(innerTwelveOne);
			passwordButton.addActionListener(this);
			innerTwelveOne.add(passwordButton);
			innerTwelve.add(innerTwelveTwo);
			innerTwelve.add(innerTwelveThree);
			innerTwelveTwo.add(action);
			action.addActionListener(this);
			innerCenter.add(innerTwelve);
			mainCenter.add(innerCenter);
			
			//Closing window control
			addWindowListener(new MyWindowListener());

			adminLabel.add(adm);
			mainTop.add(adminLabel);
			supplierLabel.add(sup);
			mainTop.add(supplierLabel);
			customerLabel.add(cus);
			mainTop.add(customerLabel);
			productLabel.add(pro);
			mainTop.add(productLabel);
			adminHolder.setBorder(BorderFactory.createMatteBorder(2,1,1,1, Color.black));
			mainTop.add(adminHolder);
			adminHolder.add(action10);
			action10.addActionListener(this);
			adminHolder.add(action11);
			action11.addActionListener(this);
			adminHolder.add(action12);
			action12.addActionListener(this);
			supplierHolder.setBorder(BorderFactory.createMatteBorder(2,1,1,1, Color.black));
			mainTop.add(supplierHolder);
			supplierHolder.add(action1);
			action1.addActionListener(this);
			supplierHolder.add(action4);
			action4.addActionListener(this);
			supplierHolder.add(action7);
			action7.addActionListener(this);
			customerHolder.setBorder(BorderFactory.createMatteBorder(2,1,1,1, Color.black));
			mainTop.add(customerHolder);
			customerHolder.add(action2);
			action2.addActionListener(this);
			customerHolder.add(action5);
			action5.addActionListener(this);
			customerHolder.add(action8);
			action8.addActionListener(this);
			productHolder.setBorder(BorderFactory.createMatteBorder(2,1,1,1, Color.black));
			mainTop.add(productHolder);
			productHolder.add(action3);
			action3.addActionListener(this);
			productHolder.add(action6);
			action6.addActionListener(this);
			productHolder.add(action9);
			action9.addActionListener(this);
			mainLeft.setLayout(new GridLayout(3,1));
			leftOne.setLayout(new GridLayout(2,1));
			leftOne.add(leftOneTop);
			leftOneBotton.add(uploadImageLabel);
			leftOne.add(leftOneBotton);
			mainLeft.add(leftOne);
			mainLeft.add(leftTwo);
			labBack.setOpaque(true);
			labBack.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
			leftTwo.add(labBack);
			addPhoto.setVisible(false);
			addPhoto.addActionListener(this);
			leftThree.setLayout(new GridLayout(2,1));
			leftThreeTop.add(addPhoto);
			leftThree.add(leftThreeTop);
			leftThreeBotton.add(pictureNameLabel);
			leftThree.add(leftThreeBotton);
			leftThree.setBackground(Color.black);
			mainLeft.add(leftThree);
			mainLeft.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.black));
			mainBotton.setLayout(new GridLayout(1,7));
			mainBottonFour.add(exit);
			exit.addActionListener(this);
			mainBotton.add(mainBottonOne);
			mainBotton.add(mainBottonTwo);
			mainBotton.add(mainBottonThree);
			mainBotton.add(mainBottonFour);
			mainBotton.add(mainBottonFive);
			mainBotton.add(mainBottonSix);
			mainBotton.add(mainBottonSeven);
			mainBotton.setBackground(Color.black);
			mainBotton.setBorder(BorderFactory.createLineBorder(Color.black));
			mainCenter.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.black));		
			setMinimumSize(new Dimension((int)width,(int)height));
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setResizable(false);
			dropIdLabel.setVisible(false);
			dropIDText.setVisible(false);
			dropNameLabel.setVisible(false);
			dropNameText.setVisible(false);
			dropStreetLabel.setVisible(false);
			dropStreetText.setVisible(false);
			dropTownLabel.setVisible(false);
			dropTownText.setVisible(false);
			dropCountyLabel.setVisible(false);
			dropCountyText.setVisible(false);
			dropCountryLabel.setVisible(false);
			dropCountryText.setVisible(false);
			dropPostCodeLabel.setVisible(false);
			dropPostCodeText.setVisible(false);
			dropEmailLabel.setVisible(false);
			dropEmailText.setVisible(false);
			dropContactLabel.setVisible(false);
			dropContactText.setVisible(false);
			dropPostCodeLabel.setVisible(false);
			dropPostCodeText.setVisible(false);
			dropContactLabel.setVisible(false);
			dropContactText.setVisible(false);
			dropProductLabel.setVisible(false);
			dropProducts.setVisible(false);
			action.setVisible(false);
			getContentPane().add(mainLeft, BorderLayout.WEST);
			getContentPane().add(mainTop, BorderLayout.NORTH);
			getContentPane().add(mainBotton, BorderLayout.SOUTH);
			getContentPane().add(mainCenter, BorderLayout.CENTER);
			try {
				clearPicture();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(true);
		}
		
		public void changePassword()
		{
			setEditableUser();
			addPhoto.setVisible(false);
			locationLabel2.setText("Change Password");
			searchByIdBox.setVisible(false);
			searchByNameBox.setVisible(false);
			locationLabel3.setVisible(false);
			dropIdLabel.setText("User name");
			dropIdLabel.setVisible(true);
			dropIDText.setVisible(true);
			dropNameLabel.setText("New Password");
			dropNameLabel.setVisible(true);
			dropNameText.setVisible(true);
			dropStreetLabel.setText("Repeat password");
			dropStreetLabel.setVisible(true);
			dropStreetText.setVisible(true);
			action.setText("Change");
			action.setVisible(true);
		}
	
	public void home()
	{
		
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
		
	}
	
	public void addUser()
	{
		setEditableUser();
		addPhoto.setVisible(false);
		locationLabel2.setText("Add User");
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
		dropIdLabel.setText("User name");
		dropIdLabel.setVisible(true);
		dropIDText.setVisible(true);
		dropNameLabel.setText("Create Password");
		dropNameLabel.setVisible(true);
		dropNameText.setVisible(true);
		dropStreetLabel.setText("Repeat password");
		dropStreetLabel.setVisible(true);
		dropStreetText.setVisible(true);
		dropTownLabel.setText("Email");
		dropTownLabel.setVisible(true);
		dropTownText.setVisible(true);
		action.setText("Create User");
		action.setVisible(true);
	}
	
	public void deleteUser()
	{
		
		locationLabel2.setText("Delete User");
		locationLabel3.setText("Search by Id,Name ");
		dropIdLabel.setText("User name");
		dropIdLabel.setVisible(true);
		dropIDText.setVisible(true);
		dropNameLabel.setText("Password");
		dropNameLabel.setVisible(true);
		dropNameText.setVisible(true);
		action.setText("Delete User from database");
		action.setVisible(true);
		setUnEditableUser();
		fillDeleteUserDropDownBoxes();
	}
	
	
	public void searchSupplier()
	{
		locationLabel2.setText("Search Supplier");
		locationLabel3.setText("Search by Id,Name ");
		dropIdLabel.setText("Supplier ID");
		action.setText("Change Supplier Details");
		action.setVisible(true);
		changeComponentsToJtext();
		dropNameLabel.setText("Supplier Name");
		dropProductLabel.setText("Products");
		changeBackLabels();
		setEditableFalse();
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	public void addSupplier()
	{
		locationLabel2.setText("Add Supplier");
		//locationLabel3.setText("Search by Id,Name ");
		dropIdLabel.setText("Supplier ID");
		action.setText("Add Supplier");
		action.setVisible(true);
		dropNameLabel.setText("Supplier Name");		
		dropProductLabel.setText("");
		changeBackLabels();
		setEditableTrue();
		changeComponentsToJtext();
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
		
	}
	

	public void deleteSupplier()
	{
		locationLabel2.setText("Delete Supplier");
		locationLabel3.setText("Search by Id,Name ");
		dropIdLabel.setText("Supplier ID");
		dropNameLabel.setText("Supplier Name");
		action.setText("Delete Supplier");
		action.setVisible(true);
		dropProductLabel.setText("");
		changeComponentsToJtext();
		changeBackLabels();
		setEditableFalse();
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	//customer
	public void searchCustomer()
	{
		locationLabel2.setText("Search Customer");
		locationLabel3.setText("Search by Id,Name ");
		dropNameLabel.setText("Customer Name");
		dropIdLabel.setText("Customer ID");
		dropProductLabel.setText("Bougth Products");
		action.setText("Change Customer Details");
		action.setVisible(true);
		changeComponentsToJtext();
		changeBackLabels();
		setEditableFalse();
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	public void addCustomer()
	{
		locationLabel2.setText("Add Customer");
		//locationLabel3.setText("Search by Id,Name ");
		dropNameLabel.setText("Customer Name");
		dropIdLabel.setText("Customer ID");
		action.setText("Add Customer");
		action.setVisible(true);
		changeBackLabels();
		setEditableTrue();
		dropProductLabel.setText("Products");
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
	}
	
	public void deleteCustomer()
	{
		locationLabel2.setText("Delete Customer");
		locationLabel3.setText("Search by Id,Name ");
		dropNameLabel.setText("Customer Name");
		dropIdLabel.setText("Customer ID");
		action.setText("Delete Customer");
		dropProductLabel.setText("");
		action.setVisible(true);
		changeBackLabels();
		setEditableFalse();
		dropProducts.setVisible(false);
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	public void searchProduct()
	{
		locationLabel2.setText("Search Product");
		locationLabel3.setText("Search by Id,Name ");
		dropNameLabel.setText("Product Name");
		dropIdLabel.setText("Product ID");
		action.setText("Change Product Details");
		action.setVisible(true);
		dropProductLabel.setVisible(false);
		dropProductsText.setVisible(false);
		changeComponentsToJtext();
		changeProductLabels();
		setEditableFalse();
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	public void addProduct()
	{
		locationLabel2.setText("Add Product");
		locationLabel3.setText("Select Supplier to product ");
		dropNameLabel.setText("Product Name");
		dropIdLabel.setText("Product ID");
		action.setText("Add Product");
		action.setVisible(true);
		dropProductLabel.setVisible(false);
		dropProductsText.setVisible(false);
		changeComponentsToJbox();
		changeProductLabels();
		setEditableTrue();
		addPhoto.setVisible(true);
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
	}
	
	public void deleteProduct()
	{
		locationLabel2.setText("Delete Product");
		locationLabel3.setText("Search by Id,Name ");
		dropNameLabel.setText("Product Name");
		dropIdLabel.setText("Product ID");
		action.setText("Delete Product");
		action.setVisible(true);
		dropProductLabel.setVisible(false);
		dropProductsText.setVisible(false);
		changeComponentsToJtext();
		changeProductLabels();
		setEditableFalse();
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
	}
	
	public void changeProductLabels()
	{
		dropStreetLabel.setText("Supplier");
		dropTownLabel.setText("Type");
		dropCountyLabel.setText("Size");
		dropCountryLabel.setText("Price");
		dropPostCodeLabel.setText("Colour");
		dropEmailLabel.setText("Contact");
		dropContactLabel.setText("");
	}
	
	public void changeBackLabels()
	{
		dropStreetLabel.setText("Street");
		dropTownLabel.setText("Town");
		dropCountyLabel.setText("County");
		dropCountryLabel.setText("Country");
		dropPostCodeLabel.setText("Post Code");
		dropEmailLabel.setText("Email");
		dropContactLabel.setText("Contact");
	}
	
	
	
	public void setVisibleFalse()
	{
		dropIdLabel.setVisible(false);
		dropIDText.setVisible(false);
		dropNameLabel.setVisible(false);
		dropNameText.setVisible(false);
		dropStreetLabel.setVisible(false);
		dropStreetText.setVisible(false);
		dropTownLabel.setVisible(false);
		dropTownText.setVisible(false);
		dropCountyLabel.setVisible(false);
		dropCountyText.setVisible(false);
		dropCountryLabel.setVisible(false);
		dropCountryText.setVisible(false);
		dropPostCodeLabel.setVisible(false);
		dropPostCodeText.setVisible(false);
		dropEmailLabel.setVisible(false);
		dropEmailText.setVisible(false);
		dropContactLabel.setVisible(false);
		dropContactText.setVisible(false);
		dropPostCodeLabel.setVisible(false);
		dropContactText.setVisible(false);
		dropProductLabel.setVisible(false);
		dropProducts.setVisible(false);
		passwordButton.setVisible(false);
		action.setVisible(false);
	}
	
	public void setVisibleTrue()
	{
		locationLabel2.setVisible(true);
		locationLabel3.setVisible(true);
		dropIdLabel.setVisible(true);
		dropIDText.setVisible(true);
		dropNameLabel.setVisible(true);
		dropNameText.setVisible(true);
		dropStreetLabel.setVisible(true);
		dropStreetText.setVisible(true);
		dropTownLabel.setVisible(true);
		dropTownText.setVisible(true);
		dropCountyLabel.setVisible(true);
		dropCountyText.setVisible(true);
		dropCountryLabel.setVisible(true);
		dropCountryText.setVisible(true);
		dropPostCodeLabel.setVisible(true);
		dropPostCodeText.setVisible(true);
		dropEmailLabel.setVisible(true);
		dropEmailText.setVisible(true);
		dropContactLabel.setVisible(true);
		dropContactText.setVisible(true);
		dropPostCodeLabel.setVisible(true);
		dropContactText.setVisible(true);
		dropProductLabel.setVisible(true);
		dropProducts.setVisible(true);	
		passwordButton.setVisible(false);
	}
	
	public void changeComponentsToJbox()
	{
		if(dropStreetText.isShowing())
		{
			dropIDText.setPreferredSize(dropDim);
			dropNameText.setPreferredSize(dropDim);
			dropStreetLabel.setText("Supplier");
			dropIDText.setEditable(false);
		}
		
	}
	
	public void changeComponentsToJtext()
	{
		if(dropStreetText.isShowing())
		{ 
			dropStreetLabel.setText("Street");
		}
	}
	
	public void setEditableTrue()
	{
		dropNameText.setEditable(true);
		dropNameText.setBackground(Color.WHITE);
		
		dropStreetText.setEditable(true);
		dropStreetText.setBackground(Color.WHITE);
		
		dropTownText.setEditable(true);
		dropTownText.setBackground(Color.WHITE);
		
		dropCountyText.setEditable(true);
		dropCountyText.setBackground(Color.WHITE);
		
		dropCountryText.setEditable(true);
		dropCountryText.setBackground(Color.WHITE);
		
		dropPostCodeText.setEditable(true);
		dropPostCodeText.setBackground(Color.WHITE);
		
		dropEmailText.setEditable(true);
		dropEmailText.setBackground(Color.WHITE);
		
		dropContactText.setEditable(true);
		dropContactText.setBackground(Color.WHITE);
	}
	
	public void setEditableFalse()
	{
		dropIDText.setEditable(false);
		dropIDText.setBackground(Color.lightGray);
		
		dropNameText.setEditable(false);
		dropNameText.setBackground(Color.lightGray);
		
		dropStreetText.setEditable(false);
		dropStreetText.setBackground(Color.lightGray);
		
		dropTownText.setEditable(false);
		dropTownText.setBackground(Color.lightGray);
		
		dropCountyText.setEditable(false);
		dropCountyText.setBackground(Color.lightGray);
		
		dropCountryText.setEditable(false);
		dropCountryText.setBackground(Color.lightGray);
		
		dropPostCodeText.setEditable(false);
		dropPostCodeText.setBackground(Color.lightGray);
		
		dropEmailText.setEditable(false);
		dropEmailText.setBackground(Color.lightGray);
		
		dropContactText.setEditable(false);
		dropContactText.setBackground(Color.lightGray);
		
		dropProductsText.setEditable(false);
		dropProductsText.setBackground(Color.lightGray);
		
		
	}
	
	public void allComponentsNotVisible()
	{
		dropIdLabel.setVisible(false);
		dropIDText.setVisible(false);
		dropNameLabel.setVisible(false);
		dropNameText.setVisible(false);
		dropStreetLabel.setVisible(false);
		dropStreetText.setVisible(false);
		dropTownLabel.setVisible(false);
		dropTownText.setVisible(false);
		dropCountyLabel.setVisible(false);
		dropCountyText.setVisible(false);
		dropCountryLabel.setVisible(false);
		dropCountryText.setVisible(false);
		dropPostCodeLabel.setVisible(false);
		dropPostCodeText.setVisible(false);
		dropEmailLabel.setVisible(false);
		dropEmailText.setVisible(false);
		dropContactLabel.setVisible(false);
		dropContactText.setVisible(false);
		dropPostCodeLabel.setVisible(false);
		dropPostCodeText.setVisible(false);
		dropContactLabel.setVisible(false);
		dropContactText.setVisible(false);
		dropProductLabel.setVisible(false);
		dropProducts.setVisible(false);
		action.setVisible(false);
	}
	
	public void setEditableUser()
	{
		dropIDText.setEditable(true);
		dropIDText.setBackground(Color.WHITE);
		dropNameText.setEditable(true);
		dropNameText.setBackground(Color.WHITE);
		dropStreetText.setEditable(true);
		dropStreetText.setBackground(Color.WHITE);
		dropTownText.setEditable(true);
		dropTownText.setBackground(Color.WHITE);
	}
		
	public void setUnEditableUser()
	{
		locationLabel3.setVisible(true);
		searchByIdBox.setVisible(true);
		searchByNameBox.setVisible(true);
		dropIDText.setEditable(false);
		dropIDText.setBackground(Color.lightGray);
		dropNameText.setEditable(false);
		dropNameText.setBackground(Color.lightGray);
		
	}
	
	
	private void hideAll()
	{
		dropIdLabel.setVisible(false);
		dropIDText.setVisible(false);
		dropNameLabel.setVisible(false);
		dropNameText.setVisible(false);
		dropStreetLabel.setVisible(false);
		dropStreetText.setVisible(false);
		dropTownLabel.setVisible(false);
		dropTownText.setVisible(false);
		dropCountyLabel.setVisible(false);
		dropCountyText.setVisible(false);
		dropCountryLabel.setVisible(false);
		dropCountryText.setVisible(false);
		dropPostCodeLabel.setVisible(false);
		dropPostCodeText.setVisible(false);
		dropEmailLabel.setVisible(false);
		dropEmailText.setVisible(false);
		dropContactLabel.setVisible(false);
		dropContactText.setVisible(false);
		dropProductLabel.setVisible(false);
		dropProducts.setVisible(false);
		action.setVisible(false);
		searchByIdBox.setVisible(false);
		searchByNameBox.setVisible(false);
		locationLabel3.setVisible(false);
	}
	
	public void clearAllField()
	{
		dropIDText.setText("");
		dropNameText.setText("");
		dropStreetText.setText("");
		dropTownText.setText("");
		dropCountyText.setText("");
		dropCountryText.setText("");
		dropPostCodeText.setText("");
		dropEmailText.setText("");
		dropContactText.setText("");
		dropProductsText.setText("");
	}
	
}
