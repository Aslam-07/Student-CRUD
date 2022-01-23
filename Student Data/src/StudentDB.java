import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDB 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","System","Aslam123");
            
            Statement stmt=con.createStatement();
            stmt.executeUpdate("create table STUDENT(STUDENT_NO number(3),STUDENT_NAME varchar(30),STUDENT_DOB DATE, STUDENT_DOJ DATE)");
            
            System.out.println("Table Created Successfully...");
            con.close();
		}
        catch(Exception e)
		{
        	System.out.println(e);
		}

	}

}
