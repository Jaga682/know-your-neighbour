package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Model.Userbean;

public class Userdao implements UserService{

	public void addUserdata(Userbean userbean) {
	
		try {
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/know neighbours","root","root");
			System.out.println("con");
			System.out.println("connection value is "+con);
			Statement stmt=con.createStatement();
			System.out.println("Request arrived="+userbean.getName());
//			String query="INSERT INTO `know neighbours`.`cred`(`name`, `mobile`,`password`,`address`,`city`,`state `,`country`)VALUES('"+userbean.getName()+"','"+userbean.getMobile()+"','"+userbean.getPassword()+"','"+userbean.getAddress()+"','"+userbean.getCity()+"','"+userbean.getState()+"','"+userbean.getCountry()+"')";
			String query = "INSERT INTO `know neighbours`.`cred` (`id`, `Name`, `Mobile`, `password`, `Conpassword`, `address`, `city`, `state`, `country`) VALUES ('"+userbean.getId()+"', 'xyz', '12345', '12345', '12345', 'xyx', 'xyx', 'xyx', 'xyx')";
			stmt.executeUpdate(query);
			System.out.println("Data uploaded");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Fail");
		}
		
	}

	@Override
	public boolean loginuser(Userbean userbean) {
		// TODO Auto-generated method stub
		return false;
	}

}
