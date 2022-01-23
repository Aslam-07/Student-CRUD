import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StudentUpdate
{
	public static void main(String[] args) 
	{
		String value; int sno; String sname;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","System","Aslam123");
            
            Statement stmt=con.createStatement();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
          
               System.out.println("Enter Student_No:-");
               value=br.readLine();
                sno = Integer.parseInt(value);
               
               System.out.println("Enter New Student_Name:-");	
               value=br.readLine();
                sname=(value);
               
              
               
               int count=stmt.executeUpdate("update Student set STUDENT_NAME="+sname+" where STUDENT_NO="+sno+"");
               if(count>0)
            	   System.out.println(count+" record update");
               else
            	   System.out.println(count+"No record updated");
               
		}
        catch(Exception e)
		{
        	System.out.println(e);
		}

	}

}

