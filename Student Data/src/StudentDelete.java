import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StudentDelete
{
	public static void main(String[] args) 
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","System","Aslam123");
            
            Statement stmt=con.createStatement();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
          
               System.out.println("Enter Delete Student_No:-");
               int sno=Integer.parseInt(br.readLine());
               
               
               int count=stmt.executeUpdate("Delete from Student where STUDENT_NO="+sno);
               if(count==1)
            	   System.out.println(count+"Rows Deleted");
               else
            	   System.out.println(count+"No record Deleted");
               
            
            
		}
        catch(Exception e)
		{
        	System.out.println(e);
		}

	}

}


