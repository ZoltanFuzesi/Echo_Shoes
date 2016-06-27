package EchoProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import com.mysql.jdbc.PreparedStatement;;

public class DBConnect implements connect
{
	private BufferedImage imageLoad = null;
	private String host = "???";
	private String uName = "???";
	private String uPass = "???";
	private String server = "???";
	private String user = "???";
	private String privilages;
	private ResultSet rs;
	private String actualUser;
	private String actualPassword;
	private String addedUser;
	private Connection con;
	private String imageLocationToDelete ="";
	private String product = "";
	private String supplier = "";
	private String customer = "";
	
	public DBConnect(String userN, String userP)
	{
		actualUser = userN;
		actualPassword = userP;
		try{
			con = DriverManager.getConnection(host,uName,uPass);
			connectToAndQueryDatabase(uName,uPass,userN, userP);
		}catch(SQLException err){
			JOptionPane.showMessageDialog(null, err.getMessage());
			System.exit(0);
		}
	}
	
	//********************************************************Log in  - Log out  - log records*****************************************
	public void setLog(Timestamp login, Timestamp logOut)
	{
		String accesLog = "";
		int actualUserID = 0;
		if(login == logOut)
		{
			actualUserID = 0;
			accesLog = "Access-Denied";
		}
		else
		{
			try {
				accesLog = "Access-Granted";
				actualUserID = getUsertID(getActualUser());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    try {
	    	con = DriverManager.getConnection(host,uName,uPass);
	        String sql = "INSERT INTO Log (UserName, UserID, LogIn, LogOut, AccessDenied) values (?, ?, ?, ?, ?)";
	        java.sql.PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, getActualUser());
	        statement.setInt(2, actualUserID);
	        statement.setTimestamp(3, login);
	        statement.setTimestamp(4, logOut);
	        statement.setString(5, accesLog);
  
	        int row = statement.executeUpdate();
	        	if (row > 0) {        }
	        statement.close();
	        con.close();
	    } catch (SQLException ex) {
	    	error("SQL Exception!");
	    } 
	}
	//********************************************************	GETTERS	 *****************************************
	private Timestamp getTime()
	{
		Calendar calendar = Calendar.getInstance();
		Timestamp time = new java.sql.Timestamp(calendar.getTime().getTime());
		return time;
	}
	
	public String getActualUser()
	{
		return actualUser;
	}
	public void setImage(BufferedImage image)
	{
		imageLoad = image;
	}
	
	public BufferedImage getImageName()
	{
		return imageLoad;
	}
	
	public String getPrivilages()
	{
		return privilages;
	}
	
	public void setPrivilages(String privilages)
	{
		this.privilages = privilages;
	}
	
	//********************************************************	LOGIN CHECK FOR PRIVILAGES	****************************************************
	public void connectToAndQueryDatabase(String username, String password,String userN, String userP) throws SQLException {
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT UserID, UserName, Password, Email FROM Users");
	    boolean loop = true;
	    while (rs.next()&&loop) {
	        int id = rs.getInt("UserID");
	        String Un = rs.getString("UserName");
	        String Ps = rs.getString("Password");
	        String Em = rs.getString("Email");
	        
		        if(Un.equalsIgnoreCase(userN)&&Ps.equalsIgnoreCase(userP))
		        {
		        	actualUser = Un;
		        	actualPassword = Ps;
		        	setPrivilages("Access");
		        	loop = false;
		        }
		        else
		        {
		        	setPrivilages("No Access");
		        }
	    }
	    stmt.close();
        con.close();
	}
	//********************************************************	GET SUPPLIER ID BY SUPPLIER NAME	*****************************************
	
	public int getsupplierID(String name) throws SQLException {
		int id = 0;
		con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery("SELECT SupplierID  FROM Supplier WHERE SupplierName = '" + name + "'");
		 
			 while (rs.next())
			 {
				 id = rs.getInt("SupplierID");
			 }
			 
		 stmt.close();
	        con.close();
		return id;
	}
	
	public String getsupplierName(int name) throws SQLException {
		String supName ="";
		con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery("SELECT SupplierName  FROM Supplier WHERE SupplierID = '" + name + "'");
		 
			 while (rs.next())
			 {
				 supName = rs.getString("SupplierName");
			 }
			 
		 stmt.close();
	        con.close();
		return supName;
	}
	
	//********************************************************	GET CUSTOMER ID BY CUSTOMER NAME	*****************************************
	public int getcustomerID(String name) throws SQLException {
		int id = 0;
		con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery("SELECT CustomerID  FROM Customer WHERE CustomerName = '" + name + "'");
		 
			 while (rs.next())
			 {
				 id = rs.getInt("CustomerID");
			 }
			 
		 stmt.close();
	     con.close();
		return id;
	}
	
	//********************************************************	GET PRODUCT ID BY SUPPLIER NAME	****************************************
	public int getProductID(String name) throws SQLException {
		int id = 0;
		con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery("SELECT ProductID  FROM Product WHERE ProductDesc = '" + name + "'");
		 
			 while (rs.next())
			 {
				 id = rs.getInt("ProductID");
			 }
			 
		 stmt.close();
	     con.close();
		return id;
	}
	
	//********************************************************	GET PRODUCTS CONNECTED WITH SUPPLIER	*****************************************
	public String[] productConnectedDropBox(int index) throws SQLException {
		con = DriverManager.getConnection(host,uName,uPass);
		ArrayList<String>names= new ArrayList<>();			
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ProductDesc  FROM Product WHERE SupplierID = '" + index + "'");
	    
		    while (rs.next())
		    {
		        String name = rs.getString("ProductDesc");
		        names.add(name);
		    }
	    
	    stmt.close();
        con.close();
	    String[]arr = new String[names.size()];
	    
		    for(int i = 0 ; i < names.size();i++)
		    {
		    	arr[i] = names.get(i);
		    }
		    
	    return arr;
	}
	
	//********************************************************	GET PRODUCT WHAT CUSTOMER BOUGTH	************************************** 
	public String[] customerConnectedDropBox(int index) throws SQLException {

		 ArrayList<String>names= new ArrayList<>();		
		 con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ProductDesc  FROM Buying WHERE CustomerID = '" + index + "'");
	    
		    while (rs.next())
		    {
		        String name = rs.getString("ProductDesc");
		        names.add(name);
		    }
	    
	    stmt.close();
        con.close();
           
	    String[]arr = new String[names.size()];
	    
		    for(int i = 0 ; i < names.size();i++)
		    {
		    	arr[i] = names.get(i);
		    }
	    return arr;
	}
	
	//********************************************************	GET SUPPLIER ID'S FOR JCOMBOBOX	**************************************
	public String[] supplierNameDropBox() throws SQLException {

		 ArrayList<String>names= new ArrayList<>();	
		 con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT SupplierName  FROM Supplier");
	    
		    while (rs.next()) 
		    {
		        String name = rs.getString("SupplierName");
		        names.add(name);
		    }
	    
	    stmt.close();
	    con.close();
	    String[]arr = new String[names.size()];
	    
		    for(int i = 0 ; i < names.size();i++)
		    {
		    	arr[i] = names.get(i);
		    }
		    
	    return arr;
	}

	//********************************************************	GET SUPPLIER ID'S FOR JCOMBOBOX	**************************************
	public String[] supplierIdDropBox() throws SQLException {

		ArrayList<String>ids= new ArrayList<>();
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT SupplierID  FROM Supplier");
	    
		    while (rs.next())
		    {
		        String id = rs.getString("SupplierID");
		        ids.add(id);
		    }
	    
	    con.close();
	    String[]arr = new String[ids.size()];
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
		    
	    return arr;
	}
	//********************************************************	GET CUSTOMER NAMES JCOMBOBOX	**************************************
	public String[] customerNameDropBox() throws SQLException {
	
		ArrayList<String>names= new ArrayList<>();	
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT CustomerName  FROM Customer");
	    
		    while (rs.next())
		    {
		        String name = rs.getString("CustomerName");
		        names.add(name);
		    }
	    
	    con.close();
	    String[]arr = new String[names.size()];
	    
		    for(int i = 0 ; i < names.size();i++)
		    {
		    	arr[i] = names.get(i);
		    }
	    
	    return arr;
	}
	//********************************************************	GET CUSTOMER ID'S FOR JCOMBOBOX	**************************************
	public String[] customerIdDropBox() throws SQLException {

		ArrayList<String>ids= new ArrayList<>();	
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT CustomerID  FROM Customer");
	    
		    while (rs.next()) 
		    {
		        String id = rs.getString("CustomerID");
		        ids.add(id);
		    }
	    
	    con.close();
	    String[]arr = new String[ids.size()];
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}

	//********************************************************	GET PRODUCT NAMES FOR JCOMBOBOX	*****************************************
	public String[] productNameDropBox() throws SQLException {

		ArrayList<String>names= new ArrayList<>();	
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ProductDesc  FROM Product");
	    
		    while (rs.next())
		    {
		        String name = rs.getString("ProductDesc");
		        names.add(name);
		    }
	    
	    con.close();
	    String[]arr = new String[names.size()];
	    
		    for(int i = 0 ; i < names.size();i++)
		    {
		    	arr[i] = names.get(i);
		    }
	    
	    return arr;
	}
	
	//********************************************************	GET PRODUCT ID'S FOR JCOMBOBOX	*****************************************
	public String[] productIdDropBox() throws SQLException {

		 ArrayList<String>ids= new ArrayList<>();	
		 con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ProductID  FROM Product");
	    
		    while (rs.next())
		    {
		        String id = rs.getString("ProductID");
		        ids.add(id);
		    }
	    
	    con.close();
	    String[]arr = new String[ids.size()];
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
		    
	    return arr;
	}
	
	//********************************************************	GET USER ID'S FOR JCOMBOBOX	*****************************************
	public String[] usersIDDropBox() throws SQLException {
	
		 ArrayList<String>ids= new ArrayList<>();	
		 con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT UserID  FROM Users");
	    
		    while (rs.next())
		    {
		        String id = rs.getString("UserID");
		        ids.add(id);
		    }
		    
	    con.close();
	    String[]arr = new String[ids.size()];
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
		    
	    return arr;
	}
	
	//******************************************************** GET LOGIN USERS DETAILS ONLY FOR MAIN ADMINISTRATOR	**************************************
	public String[] getUserDetails(int index)
	{
		String[]arr = new String[2];
		
		try {
			con = DriverManager.getConnection(host,uName,uPass);
		    Statement stmt = con.createStatement();
		    rs = stmt.executeQuery("SELECT UserName, Password  FROM Users WHERE UserID = '" + index + "'");
	    
		    while (rs.next())
		    {
		        arr[0] = rs.getString("UserName");
		        arr[1] = rs.getString("Password");
		        
		    }
	    
		    con.close();
		} catch (SQLException e) {
			error("SQL Exception!");
		}
	   
		
	    return arr;
	}
	//********************************************************	GET USER ID'S FOR JCOMBOBOX	*****************************************
	public int getUsertID(String name) throws SQLException {
		int id = 0;
		con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
		 rs = stmt.executeQuery("SELECT UserID  FROM Users WHERE UserName = '" + name + "'");
		 
			 while (rs.next()) 
			 {
				 id = rs.getInt("UserID");
			 }
			 
		 con.close();

		return id;
	}
	
	//********************************************************	GET USER NAMES FOR JCOMBOBOX	*****************************************
	public String[] usersNameDropBox() throws SQLException {

		 ArrayList<String>ids= new ArrayList<>();
		 con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT UserName  FROM Users");
	    
		    while (rs.next())
		    {
		        String id = rs.getString("UserName");
		        ids.add(id);
		    }
	    
	    con.close();
	    String[]arr = new String[ids.size()];
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}
	
	//********************************************************	GET USER ACTIONS FOR JCOMBOBOX	*****************************************
	public String[] getUserActions(int index, String user) throws SQLException {

		 ArrayList<String>ids= new ArrayList<>();
		 con = DriverManager.getConnection(host,uName,uPass);
		 Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT Action, T, Name , Date  FROM History WHERE UserID = '" + index + "' ORDER BY Date desc");
	    
		    while (rs.next()) 
		    {
		        String action = rs.getString("Action");
		        String does = rs.getString("T");
		        String with = rs.getString("Name");
		        Timestamp when = rs.getTimestamp("Date");
		        String row = user + ", " + action + ", " + does + ", " + with + "," + when;
		        ids.add(row);
		    }
	    
	    String[]arr = new String[ids.size()];
	    con.close();
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}
	
	//********************************************************	 GET BOUGTH PRODUCTS FOR CUSTOMER FOR JCOMBOBOX	************************************
	public String[] bougthProducts(int index, String customer) throws SQLException {
	
		ArrayList<String>ids= new ArrayList<>();
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ProductID, ProductDesc, Time  FROM Buying WHERE CustomerID = '" + index + "' ORDER BY Time desc");
	    
		    while (rs.next())
		    {
		        String productName = rs.getString("ProductDesc");
		        String id = rs.getString("ProductID");
		        String time = rs.getString("Time");
		        String row = customer + " : bougth product ; " + productName + " -Product  ID " + id + " : @ " + time;
		        ids.add(row);
		    }
	    
	    String[]arr = new String[ids.size()];
	    con.close();
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}
	
	//********************************************************	GET USER LOG'S FOR JCOMBOBOX 	***************************************
	public String[] getUserLog(int index, String user) throws SQLException {

		ArrayList<String>ids= new ArrayList<>();
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT LogIn, LogOut, AccessDenied FROM Log WHERE UserID = '" + index + "' ORDER BY LogIn desc");
		    
		    while (rs.next())
		    {
		        String LogIn = rs.getString("LogIn");
		        String LogOut = rs.getString("LogOut");
		        String AccessDenied = rs.getString("AccessDenied");
		        String row = user + ", " + LogIn + ", " + ", " + LogOut + ", " + AccessDenied;
		        ids.add(row);
		    }
		    
	    String[]arr = new String[ids.size()];
	    con.close();
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}
	
	
	//********************************************************	 ALL LOG RECORDS FOR JCOMBOBOX	****************************************
	public String[] getAllOtherLog() throws SQLException {
	
		ArrayList<String>ids= new ArrayList<>();
		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT * FROM Log ORDER BY LogIn desc");
	    
		    while (rs.next()) 
		    {
		    	String username = rs.getString("UserName");
		    	String userid = rs.getString("UserID");
		        String LogIn = rs.getString("LogIn");
		        String LogOut = rs.getString("LogOut");
		        String AccessDenied = rs.getString("AccessDenied");
		        String row = username + " : " + LogIn + ", " + ", " + LogOut + ", " + AccessDenied;
		        ids.add(row);
		    }
		    
	    String[]arr = new String[ids.size()];
	    con.close();
	    
		    for(int i = 0 ; i < ids.size();i++)
		    {
		    	arr[i] = ids.get(i);
		    }
	    
	    return arr;
	}
	
	//************************************************		SUPPLIER DETAILS FROM ID	*********************************
	public String[] supplierIdDetails(int index) throws SQLException {
	
		 String[]arr = new String[9];
		    int id = 0;
		    String name = "";
		    String street="",town="",county="",country="",postCode="",email="",contactNumber="";
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT *  FROM Supplier WHERE SupplierID ='"+ index + "' ORDER BY SupplierName");	
		   
			    while (rs.next())
			    {
			    	id = rs.getInt("SupplierID");
			        name = rs.getString("SupplierName");
			        street = rs.getString("Street");
			        town = rs.getString("Town");
			        county = rs.getString("County");
			        country = rs.getString("Country");
			        postCode = rs.getString("PostCode");
			        email = rs.getString("Email");
			        contactNumber = rs.getString("ContactNumber");
			    }
			    
			    stmt.close();
			    con.close();
		
			} catch (SQLException e) {
				error("SQL Exception!");
			}
		
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = street;
		    arr[3] = town;
		    arr[4] = county;
		    arr[5] = country;
		    arr[6] = postCode;
		    arr[7] = email;
		    arr[8] = contactNumber;
		    
	    return arr;
	}
	
	//********************************************************	GET SUPPLIER NAMES 	*****************************************
	public String[] supplierNameDetails(String nameSql) throws SQLException {
	
		 String[]arr = new String[9];
		    int id = 0;
		    String name = "";
		    String street="",town="",county="",country="",postCode="",email="",contactNumber="";
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT *  FROM Supplier WHERE SupplierName ='"+ nameSql + "'");	
		   
			    while (rs.next())
			    {
			    	id = rs.getInt("SupplierID");
			        name = rs.getString("SupplierName");
			        street = rs.getString("Street");
			        town = rs.getString("Town");
			        county = rs.getString("County");
			        country = rs.getString("Country");
			        postCode = rs.getString("PostCode");
			        email = rs.getString("Email");
			        contactNumber = rs.getString("ContactNumber");
			    }
		    stmt.close();
		    con.close();
		
			} catch (SQLException e) {	
				error("SQL Exception!");
			}
	
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = street;
		    arr[3] = town;
		    arr[4] = county;
		    arr[5] = country;
		    arr[6] = postCode;
		    arr[7] = email;
		    arr[8] = contactNumber;
	 
	    return arr;
	}
	//***************************************************	PRODUCT DETAILS FROM ID	*******************************************
	public String[] productIdDetails(int index) throws SQLException, MalformedURLException, IOException {
	
		 String sName ="";
		 String[]arr = new String[9];
		    int id = 0, supID = 0;
		    String name = "";
		    String gender="",size="",price="",colour="",stock="",imgLocation ="";
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT *  FROM Product WHERE ProductID ='"+ index + "'");	
		   
			    while (rs.next())
			    {
			    	id = rs.getInt("ProductID");
			        name = rs.getString("ProductDesc");
			        supID = rs.getInt("SupplierID");
			        gender = rs.getString("Gender");
			        size = rs.getString("Size");
			        price = rs.getString("Price");
			        colour = rs.getString("Colour");
			        stock = rs.getString("StockLevel");
			        imgLocation = rs.getString("ImgLocation");
			    }
		    
			    sName = getsupplierName(supID);
			    stmt.close();
			    con.close();
			} catch (SQLException e) {	
				error("SQL Exception!");
			}
			
			getPictureFromServer(imgLocation);
		 
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = sName;
		    arr[3] = gender;
		    arr[4] = size;
		    arr[5] = price;
		    arr[6] = colour;
		    arr[7] = stock;
		    arr[8] = imgLocation;
	    return arr;
	}
	
	
	//********************************************************	GET PRODUCT NAME 	*****************************************
	public String[] productNameDetails(String names) throws SQLException, MalformedURLException, IOException {
	
		String sName ="";
		 String[]arr = new String[9];
		    int id = 0, supID = 0;
		    String name = "";
		    String gender="",size="",price="",colour="",stock="",imgLocation ="";
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
			    Statement stmt = con.createStatement();
			    rs = stmt.executeQuery("SELECT *  FROM Product WHERE ProductDesc ='"+ names + "'");	
			   
			    while (rs.next())
			    {
			    	id = rs.getInt("ProductID");
			        name = rs.getString("ProductDesc");
			        supID = rs.getInt("SupplierID");
			        gender = rs.getString("Gender");
			        size = rs.getString("Size");
			        price = rs.getString("Price");
			        colour = rs.getString("Colour");
			        stock = rs.getString("StockLevel");
			        imgLocation = rs.getString("ImgLocation");
			    }
			    
		    stmt.close();
		    con.close();
		
			} catch (SQLException e) {
				error("SQL Exception!");
			}
		
			getPictureFromServer(imgLocation);
			sName = getsupplierName(supID);
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = sName;
		    arr[3] = gender;
		    arr[4] = size;
		    arr[5] = price;
		    arr[6] = colour;
		    arr[7] = stock;
		    arr[8] = imgLocation;
	
	    return arr;
	}
	
	//*******************************************	GET PICTURE FROM SERVER		***************************************************************
	public void getPictureFromServer(String imgLocation)
	{ 
	    String imgName = imgLocation.substring(16, imgLocation.length());
		BufferedImage image = null;
	    try {  

	    	imageLocationToDelete = "http://www.project.serversite.info/"+imgLocation;
	        URL url = new URL("http://www.project.serversite.info/"+imgLocation);
	        image = ImageIO.read(url);
	        setImage(image);     
	        
	    } catch (IOException e) {
	    	error("I/O Exception!");
	    	//e.printStackTrace();
	    }
	}
	
	//****************************************************************	CUSTOMER DETAILS FROM ID	*********************************************
	public String[] customerIdDetails(int index) throws SQLException {
	
		 String[]arr = new String[9];
		    int id = 0;
		    String name = "";
		    String street="",town="",county="",country="",postCode="",email="",contactNumber="";
		    
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT *  FROM Customer WHERE CustomerID ='"+ index + "' ORDER BY CustomerName");
		    
			    while (rs.next())
			    {
			    	id = rs.getInt("CustomerID");
			        name = rs.getString("CustomerName");
			        street = rs.getString("Street");
			        town = rs.getString("Town");
			        county = rs.getString("County");
			        country = rs.getString("Country");
			        postCode = rs.getString("PostCode");
			        email = rs.getString("Email");
			        contactNumber = rs.getString("ContactNumber");
			    }
			    stmt.close();
			    con.close();
			} catch (SQLException e) {	
				error("SQL Exception!");
			}
			
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = street;
		    arr[3] = town;
		    arr[4] = county;
		    arr[5] = country;
		    arr[6] = postCode;
		    arr[7] = email;
		    arr[8] = contactNumber;
	    return arr;
	}
	
	//********************************************************		GET CUSTOMER DETAILS	*****************************************
	public String[] customerNameDetails(String nameSql) throws SQLException {
		
		 String[]arr = new String[9];
		    int id = 0;
		    String name = "";
		    String street="",town="",county="",country="",postCode="",email="",contactNumber="";
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT *  FROM Customer WHERE CustomerName ='"+ nameSql + "'");	  
		    
			    while (rs.next())
			    {
			    	id = rs.getInt("CustomerID");
			        name = rs.getString("CustomerName");
			        street = rs.getString("Street");
			        town = rs.getString("Town");
			        county = rs.getString("County");
			        country = rs.getString("Country");
			        postCode = rs.getString("PostCode");
			        email = rs.getString("Email");
			        contactNumber = rs.getString("ContactNumber");
			    }
			    
		    stmt.close();
		    con.close();
		
			} catch (SQLException e) {
				error("SQL Exception!");
			}
	
		    String sId = " " + id;
		    arr[0] = sId;
		    arr[1] = name;
		    arr[2] = street;
		    arr[3] = town;
		    arr[4] = county;
		    arr[5] = country;
		    arr[6] = postCode;
		    arr[7] = email;
		    arr[8] = contactNumber;
	 
	    return arr;
	}
	//****************************************		CUSTOMER AUTO INCREMENT 	*************************************
	public String getNextCustomerID() throws SQLException
	{
		String nextid = "";
	
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'Customer'");
				rs.next();
				nextid = rs.getString("Auto_increment");
				stmt.close();
			    con.close();
			} catch (SQLException e) {
				error("SQL Exception!");
			}
		return nextid;
	}
	
	
	//*****************************************	SUPPLIER AUTO INCREMENT	**********************************
	public String getNextSupplierID() throws SQLException
	{
		String nextid = "";
		
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'Supplier'");
				rs.next();
				nextid = rs.getString("Auto_increment");
				stmt.close();
			    con.close();
			} catch (SQLException e) {
				error("SQL Exception!");
			}
		return nextid;
	}
	//******************************************	PRODUCT AUTO INCREMENT	*************************************
	
	public String getNextProductID() throws SQLException
	{
		String nextid = "";
	
			try  {
				con = DriverManager.getConnection(host,uName,uPass);
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'Product'");
				rs.next();
				nextid = rs.getString("Auto_increment");
				stmt.close();
			    con.close();
			} catch (SQLException e) {
				error("SQL Exception!");
			}
		return nextid;
	}
	
	//********************************************************	ADD SUPPLIER	*****************************************
		
	public boolean addSupplier(String name, String street, String town, String county, String country,String postCode,String email, String contact) throws SQLException, ClassNotFoundException
	{
		boolean ans = false;
		
	    try {
	        Connection conn = DriverManager.getConnection(host, uName, uPass);
	
	        String sql = "INSERT INTO Supplier (SupplierName, Street, Town, County, Country, PostCode, Email, ContactNumber) values (?, ?, ?, ?, ?, ?, ?, ? )";
	        java.sql.PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, name);
	        statement.setString(2, street);
	        statement.setString(3, town);
	        statement.setString(4, county);
	        statement.setString(5, county);
	        statement.setString(6, postCode);
	        statement.setString(7, email);
	        statement.setString(8, contact);
	  
	        int row = statement.executeUpdate();
		        if (row > 0) 
		        {
		        	ans = true;
		        	insertHistory("Add", "Supplier");//HISTORY
		        }
		        
	        statement.close();
	        conn.close();
	    } catch (SQLException ex) {
	    	error("SQL Exception!");
	    	// ex.printStackTrace();
	    } 
	    
		return ans;
	}
	//********************************************************	ADD CUSTOMER	*****************************************
	public String addCustomer(String name, String street, String town, String county, String country,String postCode,String email, String contact) throws SQLException, ClassNotFoundException
	{
	
		String message = "";
	    try {

	    	con = DriverManager.getConnection(host,uName,uPass);
	        String sql = "INSERT INTO Customer (CustomerName, Street, Town, County, Country, PostCode, Email, ContactNumber) values (?, ?, ?, ?, ?, ?, ?, ? )";
	        java.sql.PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, name);
	        statement.setString(2, street);
	        statement.setString(3, town);
	        statement.setString(4, county);
	        statement.setString(5, county);
	        statement.setString(6, postCode);
	        statement.setString(7, email);
	        statement.setString(8, contact);
	   
	        int row = statement.executeUpdate();
		        if (row > 0) 
		        {
		            message = "The Customer was inserted";
		            insertHistory("Add", "Customer");//HISTORY
		        }
	        statement.close();
	        con.close();
	    } catch (SQLException ex) {
	    	error("SQL Exception!");
	    	// ex.printStackTrace();
	    } 
		return message;
	}
	//********************************************************	ADD PRODUCT	*****************************************
	public String addProduct(String desc, String supID, String gender, String size, double price,String colour,int stock, String imgLocation,File imageToUplad,String fileName) throws SQLException, ClassNotFoundException
	{
		uploadImage(imageToUplad,fileName);
		String message = "";
		int id = 0;

	    try {
	    	
	        id = getsupplierID(supID);
	        con = DriverManager.getConnection(host,uName,uPass);
	        String sql = "INSERT INTO Product (ProductDesc, SupplierID, Gender, Size, Price, Colour, StockLevel, ImgLocation ) values (?, ?, ?, ?, ?, ?, ?, ? )";
	        java.sql.PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, desc);
	        statement.setInt(2, id);
	        statement.setString(3, gender);
	        statement.setString(4, size);
	        statement.setDouble(5, price);//double
	        statement.setString(6, colour);
	        statement.setInt(7, stock);//int
	        statement.setString(8, imgLocation);
	   
	        int row = statement.executeUpdate();
		        if (row > 0)
		        {
		            message = "The Product was inserted";
		            insertHistory("Add", "Product");//HISTORY
		        }
		        
	        statement.close();
	        con.close();
	    } catch (SQLException ex) {
	    	error("SQL Exception!");
	    	// ex.printStackTrace();
	    } 
		return message;
	}
	
	//********************************************************	DELETE SUPPLIER	****************************************
	public String deleteSupplier(String name)
	{
		String message = "";

	    try {
	    		con = DriverManager.getConnection(host,uName,uPass);
		        PreparedStatement st = (PreparedStatement) con.prepareStatement("DELETE FROM Supplier WHERE SupplierID = '" + name + "';");
		         
		        int row = st.executeUpdate();
		        if (row > 0) {
		            message = "The Supplier was deleted";
		            insertHistory("Delete", "Supplier");//HISTORY
		        }
		        st.close();
		        con.close();
	    	}
	        catch(Exception e)
	        {
	        	error("Exception!");
	        }
	    return message;
	    }
	
	//********************************************************	DELETE CUSTOMER 	****************************************
	public String deleteCustomer(String name)
	{
		String message = "";
	
	    try {
	    	con = DriverManager.getConnection(host,uName,uPass);
		        PreparedStatement st = (PreparedStatement) con.prepareStatement("DELETE FROM Customer WHERE CustomerID = '" + name + "';");
		         
		        int row = st.executeUpdate();
		        if (row > 0) {
		            message = "The Customer was deleted";
		            insertHistory("Delete ", "Customer");//HISTORY
		        }
		        st.close();
		        con.close();
	    	}
	        catch(Exception e)
	        {
	        	error("Exception!");
	        }
	    return message;
	    }
	
	//*******************************************************	CHECK FOR IMAGE IS ON THE SERVER ALREADY	******************************
	public boolean isImageInServer(String filename) throws SQLException 
	{
		boolean ans = false;

		con = DriverManager.getConnection(host,uName,uPass);
	    Statement stmt = con.createStatement();
	    rs = stmt.executeQuery("SELECT ImgLocation FROM Product");
	    boolean loop = true;
	    
		    while (rs.next()&&loop)
		    {
		        String imglocation = rs.getString("ImgLocation");
		        String str = imglocation.substring(16, imglocation.length());

		        if(str.equalsIgnoreCase(filename))
		        {
		        	ans = true;
		        	loop = false;
		        }
		        else
		        {
		        	ans = false;
		        }
		    }
		    
	    stmt.close();
	    con.close();
	    
		return ans;
	}
	
	//********************************************************	DELETE PRODUCT AND IMAGE FROM SERVER AND DATABASE	*****************************************
	public String deleteProduct(String name)
	{
		String message = "";
		String fileone = "/webspace/httpdocs/project.serversite.info/picture_library/" + imageLocationToDelete.substring(51, imageLocationToDelete.length());
		 // String server = "www.project.serversite.info";
	      int port = 21;
	     // String server = "78.153.213.252";
	      
	      FTPClient ftpClient = new FTPClient();
	      try {
	
	          ftpClient.connect(server, port);
	
	          int replyCode = ftpClient.getReplyCode();
		          if (!FTPReply.isPositiveCompletion(replyCode)) 
		          {
		              return "Connection Failed";
		          }
	
	          boolean success = ftpClient.login(user, uPass);
	
		          if (!success) 
		          {
		              return"Could not login to the server";
		          }
		          
	          String fileToDelete = fileone;
	
	          boolean deleted = ftpClient.deleteFile(fileToDelete);
	          
		          if (deleted)
		          {
		              try {
		            		con = DriverManager.getConnection(host,uName,uPass);
		            		PreparedStatement st = (PreparedStatement) con.prepareStatement("DELETE FROM Product WHERE ProductID = '" + name + "';");
		  		         
		            		int row = st.executeUpdate();
		            		if (row > 0) {
		            			message = "The Product was deleted";
		            			insertHistory("Delete", "Product");//HISTORY
		            		}
		  		    	}
		  		        catch(Exception e)
		  		        {
		  		        	message = "There was an error while deleting product";
		  		        }
		          } else {
		        	  		//some information ******************** can't delete
		          }
	
	      } catch (IOException ex) {
	          // some eroor message *****          "Oh no, there was an error: " + ex.getMessage());
	       //   ex.printStackTrace();
	    	  error("I/O Exception!");
	      } finally {
	          // logs out and disconnects from server
	          try {
	              if (ftpClient.isConnected()) {
	                  ftpClient.logout();
	                  ftpClient.disconnect();
	              }
	          } catch (IOException ex) {
	             // ex.printStackTrace();
	        	  error("I/O Exception!");
	          }
	      }
		
			 return message;
			}
	
	//********************************************************	ADD LOGIN USER	*****************************************
	public boolean addUser(String userName, String password,  String email)
	{
		setAddedUser(userName);
		boolean ans = false;
		boolean loop = true;
		try {

			con = DriverManager.getConnection(host,uName,uPass);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT UserName FROM Users");
	    
		    while (rs.next()&&loop)
		    {
		        String name = rs.getString("UserName");
		        if(name.equalsIgnoreCase(userName))
		        {
		        	loop = false;
		        	JOptionPane.showMessageDialog(null,"User " + name + " already in database");
		        }
		    }
		    
	    stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			error("SQL Exception!");
		}
			
		if(!loop)
		{
			//do nothing if no product selected
			ans = false;
		}
		else
		{
			
			    try {
			        String sql = "INSERT INTO Users (UserName, Password,Email) values (?, ?, ? )";
			        java.sql.PreparedStatement statement = con.prepareStatement(sql);
			        statement.setString(1, userName);
			        statement.setString(2, password);
			        statement.setString(3, email);
			   
			        int row = statement.executeUpdate();
				        if (row > 0) 
				        {
				        	ans = true;
				        	insertHistory("Create", "User");//HISTORY
				        }
			        statement.close();
			        con.close();
			    } catch (SQLException ex) {
			    	error("SQL Exception!");
			    	// ex.printStackTrace();
			    } 
		}
	    return ans;	
	}
	
	//********************************************************	CHANGE LOGIN USER PASSWORD	*****************************************
	public boolean changePassword(String newPassword, String username)
	{
		boolean ans = false;
		Connection conn;
		try {
				con = DriverManager.getConnection(host,uName,uPass);
		      PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE Users set  Password = '" + newPassword +"' WHERE UserName = '" + username + "';");
		      int row = st.executeUpdate();
		      
			        if (row > 0)
			        {
			        	ans = true;
			        }
			        
		        st.close();
		        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			error("SQL Exception!");
			//e.printStackTrace();
		}
		
		return ans;
	     
	}
	
	//************************************************************************	INSERT TO HISTORY 	*******************************************
	public void insertHistory(String action,String with)
	{
		String name ="";
		Connection conn;
		if(with.equalsIgnoreCase("Supplier"))
		{
			name = getSupplierName();
		}
		else if(with.equalsIgnoreCase("Customer"))
		{
			name = getCustomerName();
		}
		else if(with.equalsIgnoreCase("Product"))
		{
			name = getProductName();
		}
		else if(with.equalsIgnoreCase("User"))
		{
			name = getAddedUser();
		}
		try {
			con = DriverManager.getConnection(host,uName,uPass);
	        String sql = "INSERT INTO 	History (UserID, Action, T, Name, Date) values (?, ?, ?, ?, ?)";
	        java.sql.PreparedStatement statement = con.prepareStatement(sql);
	        statement.setInt(1, getUsertID(getActualUser()));
	        statement.setString(2, action);
	        statement.setString(3, with);
	        statement.setString(4, name);
	        statement.setTimestamp(5, getTime());

	        int rows = statement.executeUpdate();
	        	if (rows > 0)
	        	{ 
	        		statement.close();
	    	        con.close();
	        		//error("History"); 
	        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//*******************************************************	Utility Methods and Setters for history		**************************************
	public void setAddedUser(String addedUser)
	{
		this.addedUser = addedUser;
	}
	
	private String getAddedUser()
	{
		return addedUser;
	}
	public void setCustomerName(String product)
	{
		this.customer = product;
	}
	
	private String getCustomerName()
	{
		return customer;
	}
	
	public void setProduct(String product)
	{
		this.product = product;
	}
	
	private String getProductName()
	{
		return product;
	}
	
	public void setSupplierName(String product)
	{
		this.supplier = product;
	}
	
	private String getSupplierName()
	{
		return supplier;
	}

	//**********************************************************	FINISH HISTORY	*****************************************************************************
    	
    	
   //********************************************************	CHANGE SUPPLIER DETAILS OK	*************************************************************
	public boolean changeSupplierDetails(int index, String street, String town, String county, String country, String postCode, String email, String contact)
	{
		boolean ans = false;

	    try {
	    	con = DriverManager.getConnection(host,uName,uPass);
	        PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE Supplier set  Street = '" + street +"', Town = '" + town +"' , County = '" + county +"' "
	        		+ ", Country = '" + country +"' , PostCode = '" + postCode +"', Email = '" + email +"', ContactNumber = '" + contact +"' WHERE SupplierID = '" + index + "';");
	         
	        int row = st.executeUpdate();
	        
		        if (row > 0)
		        {
		        	ans = true;
		        	insertHistory("Change", "Supplier");//HISTORY
		        }
	        st.close();
	        con.close();
	    }
	        catch(Exception e)
	        {
	        	error("Connection !");
	        }
	    return ans;
	}
	
	//********************************************************	CHANGE CUSTOMER DETAILS	OK	***********************************
	
	public boolean changeCustomerDetails(int index, String street, String town, String county, String country, String postCode, String email, String contact)
	{
	
		boolean ans = false;
	
	    try {
	    	con = DriverManager.getConnection(host,uName,uPass);
	        PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE Customer set  Street = '" + street +"', Town = '" + town +"' , County = '" + county +"' "
	        		+ ", Country = '" + country +"' , PostCode = '" + postCode +"', Email = '" + email +"', ContactNumber = '" + contact +"' WHERE CustomerID = '" + index + "';");
	         
	        int row = st.executeUpdate();
		        if (row > 0)
		        {
		        	ans = true;
		        	insertHistory("Change", "Customer");//HISTORY
		        }
	        st.close();
	        con.close();
	    }
	        catch(Exception e)
	        {
	        	error("Connection !");
	        }
	    return ans;
	}
	
	//********************************************************	INSERT IF CUSTOMER BUYING OK	*****************************************
	public boolean insertBuying(String productName, int index)
	{

			boolean ans = false;
			if(productName.equalsIgnoreCase(" "))
			{
				ans = true;
			}
			else
			{
					Calendar calendar = Calendar.getInstance();
					Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
				    try {
				    	con = DriverManager.getConnection(host,uName,uPass);
				        int id = getProductID(productName);
				        String sql = "INSERT INTO Buying (CustomerID, ProductID,ProductDesc, Time ) values (?, ?, ?, ? )";
				        java.sql.PreparedStatement statement = con.prepareStatement(sql);
				        statement.setInt(1, index);
				        statement.setInt(2, id);
				        statement.setString(3, productName);
				        statement.setTimestamp(4, currentTimestamp);
				        
				   
				        int row = statement.executeUpdate();
					        if (row > 0) 
					        {
					        	ans = true;
					        	
					        }
					        
				        statement.close();
				        con.close();
				    } catch (SQLException ex) {
				    	error("SQL exception");
				    	// ex.printStackTrace();
				    } 
			}
		    return ans;	
	}
	
	//******************************************************** 	CHANGE PRODUCT DETAILS OK 	****************************************

	
	public boolean changeProductDetails(int index, String type, String size, String price, String colour, String stock)
	{

		boolean ans = false;
	    try {
	    	con = DriverManager.getConnection(host,uName,uPass);
	        PreparedStatement st = (PreparedStatement) con.prepareStatement("UPDATE Product set  Gender = '" + type +"', Size = '" + size +"' , Price = '" + price +"' "
	        		+ ", Colour = '" + colour +"' , StockLevel = '" + stock +"' WHERE ProductID = '" + index + "';");
	         
	        int row = st.executeUpdate();
		        if (row > 0)
		        {
		        	ans = true;
		        	insertHistory("Change", "Product");//HISTORY
		        }
	        st.close();
	        con.close();
	    }
	        catch(Exception e)
	        {
	        	error("Exception");
	        }
	    return ans;
	}
	
	//********************************************************	UPLOAD IMAGE	*****************************************
	public void uploadImage(File file,String fileName)
	{
		String message = "";
	     int port = 21;
	
	     FTPClient ftpClient = new FTPClient();
	     try {
	
	         ftpClient.connect(server, port);
	         ftpClient.login(user, uPass);
	         ftpClient.enterLocalPassiveMode();
	
	         ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	         String secondRemoteFile = "/webspace/httpdocs/project.serversite.info/picture_library/" + fileName;
	         InputStream inputStream = new FileInputStream(file);

	         OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
	         byte[] bytesIn = new byte[4096];
	         int read = 0;
	
		         while ((read = inputStream.read(bytesIn)) != -1)
		         {
		             outputStream.write(bytesIn, 0, read);
		         }
		         
	         inputStream.close();
	         outputStream.close();
	
	         boolean completed = ftpClient.completePendingCommand();
		         if (completed)
		         {
		             //some information
		         }
	
	     } catch (IOException ex) {

	       //  ex.printStackTrace();
	     } finally {
	         try {
	             if (ftpClient.isConnected()) {
	                 ftpClient.logout();
	                 ftpClient.disconnect();
	             }
	         } catch (IOException ex) {
	            error("I/O exception");
	            		//ex.printStackTrace());
	         }
	     }
	
	}
	private void error(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}

}


