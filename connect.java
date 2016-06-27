package EchoProject;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public interface connect
{
	
	
	//Container contentPane;
	
	/*JFileChooser fileChooser = new JFileChooser();
	
	GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
   
    GridBagConstraints b = new GridBagConstraints();
    
    Container contentPane = null;
    
	Dimension dropDim = new Dimension(250,25);
	//JPanels main structure
	JPanel mainTop = new JPanel(new GridLayout(2,4));
	JPanel mainBotton = new JPanel();
	JPanel mainCenter = new JPanel();
	JPanel mainLeft = new JPanel();//gridlayout 3,1
	
	
	JPanel empty = new JPanel();
	//Inner JPanels
	JPanel emptyOne = new JPanel();
	JPanel emptyTwo = new JPanel();
	JPanel emptyThree = new JPanel();
	JPanel emptyFour = new JPanel();
	JPanel emptyFive = new JPanel();
	JPanel emptySix = new JPanel();
	JPanel emptySeven = new JPanel();
	JPanel emptyEigth = new JPanel();
	JPanel emptyNine = new JPanel();
	JPanel emptyTen = new JPanel();
	JPanel emptyEleven = new JPanel();
	JPanel emptyTwelve = new JPanel();
	
	JPanel leftOne = new JPanel();
	JPanel leftTwo = new JPanel();
	JPanel leftThree = new JPanel();
	JPanel innerCenter = new JPanel();//layout 12,1
	
	JPanel innerOne = new JPanel();
	JPanel innerOne1 = new JPanel();
	JPanel innerOne2 = new JPanel();
	JPanel innerOne3 = new JPanel();
	JPanel oneone = new JPanel();
	JPanel oneTwo = new JPanel();
	
	
	JPanel innerTwo = new JPanel();
	JPanel twoone = new JPanel();
	JPanel twoTwo = new JPanel();
	
	JPanel innerThree = new JPanel();
	JPanel threeone = new JPanel();
	JPanel threeTwo = new JPanel();
	
	
	JPanel innerFour = new JPanel();
	JPanel fourone = new JPanel();
	JPanel fourTwo = new JPanel();
	
	JPanel innerFive = new JPanel();
	JPanel fiveone = new JPanel();
	JPanel fiveTwo = new JPanel();
	
	JPanel innerSix = new JPanel();
	JPanel sixone = new JPanel();
	JPanel sixTwo = new JPanel();
	
	JPanel innerSeven = new JPanel();
	JPanel sevenone = new JPanel();
	JPanel sevenTwo = new JPanel();
	
	JPanel innerEigth = new JPanel();
	JPanel eigthone = new JPanel();
	JPanel eigthTwo = new JPanel();
	
	JPanel innerNine = new JPanel();
	JPanel nineone = new JPanel();
	JPanel nineTwo = new JPanel();
	
	JPanel innerTen = new JPanel();
	JPanel tenone = new JPanel();
	JPanel tenTwo = new JPanel();
	
	JPanel innerEleven = new JPanel();
	JPanel elevenone = new JPanel();
	JPanel elevenTwo = new JPanel();
	
	JPanel innerTwelve = new JPanel();
	JPanel twelveone = new JPanel();
	JPanel twelveTwo = new JPanel();
	
	//connection to database
	
	
	//Labels
	JLabel adm = new JLabel("Admin Actions");
	JLabel sup = new JLabel("Supplier Actions");
	JLabel cus = new JLabel("Customer Actions");
	JLabel pro = new JLabel("Product Actions");
	
	JLabel coverLabel = new JLabel("");
	
	JLabel locationLabel1 = new JLabel("");
	JLabel locationLabel2 = new JLabel("");
	JLabel locationLabel3= new JLabel("");
	
	//JLabel ID= new JLabel("by ID");
	//JLabel name= new JLabel("Name");
	
	//Buttons
	JButton exit = new JButton("Exit");
	JButton action = new JButton("Action");
	JButton action1 = new JButton("Search.");
	JButton action2 = new JButton("Search..");
	JButton action3 = new JButton("Search...");
	JButton action4 = new JButton("Add.");
	JButton action5 = new JButton("Add..");
	JButton action6 = new JButton("Add...");
	JButton action7 = new JButton("Delete.");
	JButton action8 = new JButton("Delete..");
	JButton action9 = new JButton("Delete...");
	JButton action10 = new JButton("Add User");
	JButton action11= new JButton("Delete User");
	JButton action12 = new JButton("History");
	
	JButton addPhoto = new JButton("Add Photo");
	//Button holder panels
	JPanel adminLabel = new JPanel();
	JPanel supplierLabel = new JPanel();
	JPanel customerLabel = new JPanel();
	JPanel productLabel = new JPanel();
	JPanel adminHolder = new JPanel();
	JPanel supplierHolder = new JPanel();
	JPanel customerHolder = new JPanel();
	JPanel productHolder = new JPanel();
	
	
	//drop down for main navigation
/*	String [] homeList =  {"Admin" , "Home", "Add User", "Delete User","History"};
	DefaultComboBoxModel HomeModel = new DefaultComboBoxModel(homeList);
	JComboBox home = new JComboBox(homeList);
	
	
	String [] supplierList =  {"Supplier ", "Supplier : Search", "Supplier : Add","Supplier : Delete"};
	DefaultComboBoxModel SupplierModel = new DefaultComboBoxModel(supplierList);
	JComboBox supplier = new JComboBox(SupplierModel);
	
	String [] customerList =  {"Customer ", "Customer : Search", "Customer : Add","Customer : Delete"};
	DefaultComboBoxModel CustomerModel = new DefaultComboBoxModel(customerList);	
	JComboBox customer = new JComboBox(CustomerModel);
	
	String [] productList =  {"Product" ,"Product : Search", "Product : Add","Product : Delete"};
	DefaultComboBoxModel ProductModel = new DefaultComboBoxModel(productList);
	JComboBox product = new JComboBox(ProductModel);*/
	
	//search bropdown boxes
	/*DefaultComboBoxModel searchByID = new DefaultComboBoxModel();	
	JComboBox searchByIdBox = new JComboBox(searchByID);
	
	DefaultComboBoxModel searchByName = new DefaultComboBoxModel();	
	JComboBox searchByNameBox = new JComboBox(searchByName);
	
	
	
	//Main action drop down boxes and label
	JLabel dropIdLabel = new JLabel("");
	
	JTextField dropIDText  = new JTextField();
	
	JLabel dropNameLabel = new JLabel("");
	DefaultComboBoxModel Name = new DefaultComboBoxModel();	
	//JComboBox dropName = new JComboBox(Name);
	JTextField dropNameText  = new JTextField();
	
	JLabel dropStreetLabel = new JLabel("");
	DefaultComboBoxModel Street = new DefaultComboBoxModel();	
	//JComboBox dropStreetBox = new JComboBox(Street);
	JTextField dropStreetText  = new JTextField();
	
	JLabel dropTownLabel = new JLabel("");
	//DefaultComboBoxModel Town = new DefaultComboBoxModel();	
	//JComboBox dropTown = new JComboBox(Town);
	JTextField dropTownText = new JTextField();
	
	JLabel dropCountyLabel = new JLabel("");
	//DefaultComboBoxModel County = new DefaultComboBoxModel();	
	//JComboBox dropCounty = new JComboBox(County);
	JTextField dropCountyText = new JTextField();
	
	JLabel dropCountryLabel = new JLabel("");
	//DefaultComboBoxModel Country = new DefaultComboBoxModel();	
	//JComboBox dropCountry = new JComboBox(Country);
	JTextField dropCountryText = new JTextField();
	
	JLabel dropPostCodeLabel = new JLabel("");
	//DefaultComboBoxModel PostCode = new DefaultComboBoxModel();	
	//JComboBox dropPostCode = new JComboBox(PostCode);
	JTextField dropPostCodeText = new JTextField();
	
	JLabel dropEmailLabel = new JLabel("");
	//DefaultComboBoxModel Email = new DefaultComboBoxModel();	
	//JComboBox dropEmail = new JComboBox(Email);
	JTextField dropEmailText = new JTextField();
	
	JLabel dropContactLabel = new JLabel("");
	//DefaultComboBoxModel Contact = new DefaultComboBoxModel();	
	//JComboBox dropContact = new JComboBox(Contact);
	JTextField dropContactText = new JTextField();
	
	JLabel dropProductLabel = new JLabel("");
	DefaultComboBoxModel Products = new DefaultComboBoxModel();	
	JComboBox dropProducts = new JComboBox(Products);
	JTextField dropProductsText = new JTextField();
	
	
	
	
	
	
	
	//Image show
	/*BufferedImage image = new BufferedImage(250, 150, BufferedImage.TYPE_INT_RGB);//ImageIO.read(DatabaseGui.class.getClass().getResourceAsStream("/images/DataB.jpg"));
    ImageIcon img =  new ImageIcon(image);  
    JLabel labBack = new JLabel(img, SwingConstants.CENTER);*/
   // panel.add(labBack);

}
