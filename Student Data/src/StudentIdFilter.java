import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentIdFilter
{
	public static void main(String[] args) 
	{
	  
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","System","Aslam123");
            
            Statement stmt=con.createStatement();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter  Student_No:-");
            int sno=Integer.parseInt(br.readLine());
            
            ResultSet rs=stmt.executeQuery("Select * From Student where student_no="+sno+"");
            
            while(rs.next())
            {
                int sno1=rs.getInt(1);
            	String sname=rs.getString(2);
            	Date dob = rs.getDate(3);
            	Date doj = rs.getDate(4);
            	
            	System.out.println("Student no:"+ sno1);
            	System.out.println("Student name:"+ sname);
            	System.out.println("Student dob:"+ dob); 
            	System.out.println("Student doj:"+ doj);
            	
            	System.out.println();
            	
            }
            
		}
        catch(Exception e)
		{
        	System.out.println(e);
		}

	}

}



