package stepdefinitions;
import java.sql.*; 
public class ScrubUser { 
	
	public static void main(String args[]){  
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@clu-dx-dal-scan.nonprod.edc.equifax.com:1521/DDXQGCSL_DAL","PET_APP","W1_ch3dd9r");  
	  
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
	  
	//step4 execute query  
	ResultSet rs=stmt.executeQuery("select * from dual");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	  
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	   
		
	}  
	}  



