import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class StudentInsert
{
	public static void main(String[] args) 
	{
		try  
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","System","Aslam123");
            
            PreparedStatement pstmt=con.prepareStatement("insert into Student values (?,?,?,?)");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            while(true)
            {
               System.out.println("Enter Student_No:-");	
               int sno=Integer.parseInt(br.readLine());
               
               System.out.println("Enter Student_Name:-");	
               String sname=br.readLine();
               
               System.out.println("Enter Student_DOB:-");	
               String dob=(br.readLine()); 

               System.out.println("Enter Student_DOJ:-");	
               String doj=(br.readLine());              
               
               pstmt.setInt(1,sno);
               pstmt.setString(2,sname);
               pstmt.setString(3,dob);
               pstmt.setString(4,doj);
               
               int count=pstmt.executeUpdate();
               if(count>0)
            	   System.out.println(count+"record inserted");
               else
            	   System.out.println(count+"No record inserted");
               
               System.out.println("Do you wants to more records [yes/no]");
               
               String ch=br.readLine();
               if(ch.equalsIgnoreCase("no"))
            	   break;
            }
            
		}
        catch(Exception e)
		{
        	System.out.println(e);
		}

	}
}
	