import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException, SQLException{
		
		System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
		System.out.println("| WELCOME TO STUDENT MANAGEMENT APP |");
		System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("===================================");
			System.out.println(" PRESS 1 : TO ADD STUDENT");
			System.out.println(" PRESS 2 : TO DELETE STUDENT");
			System.out.println(" PRESS 3 : TO UPDATE STUDENT");
			System.out.println(" PRESS 4 : TO SEARCH STUDENT");
			System.out.println(" PRESS 5 : TO DISPLAY TABLE");
			System.out.println(" PRESS 6 : TO EXIT STUDENT-APP");
			System.out.println("===================================");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1)
			{
				// ADD STUDENT 
				System.out.println("ENTER USERNAME :");
				String name = br.readLine();
				
				System.out.println("ENTER MOBILE NO :");
				String phone = br.readLine();
				
				System.out.println("ENTER CITY :");
				String city = br.readLine();
				
				//CREATE STUDENT OBJ TO STORE STUDENT DATA
				Student st = new Student(name, phone, city);
				
				boolean add = StudentDao.insertStudentToDB(st);
				if(add)
				{
					System.out.println("=================================");
					System.out.println("| STUDENT IS SUCCESSFULLY ADDED |");
					System.out.println("=================================");
					System.out.println();
				}
				else
				{
					System.out.println("SOMETHING WENT WRONG TRY AGAIN...");
				}
				System.out.println(st);
				System.out.println();
			}
			else if(c == 2)
			{
				// DELETE STUDENT 
				System.out.println("ENTER STUDENT-ID TO DELETE :");
				
				int userId = Integer.parseInt(br.readLine());
				boolean del = StudentDao.DeleteStudentToDB(userId);
				
				if(del)
				{
					System.out.println("=================================");
					System.out.println("| STUDENT IS SUCCESSFULLY DELETED |");
					System.out.println("=================================");
					System.out.println();
				}
				else
				{
					System.out.println("SOMETHING WENT WRONG TRY AGAIN...");
				}
				
			}
			else if(c == 3)
			{
				// UPDATE STUDENT 
			
				System.out.println("ENTER STUDENT DETAIL TO UPDATE :");
				
				boolean up = StudentDao.UpdateStudentToDB();
				
				if(up)
				{
					System.out.println("==========================================");
					System.out.println("| STUDENT-DETAILS IS SUCCESSFULLY UPDATED |");
					System.out.println("==========================================");
					System.out.println();
				}
				else
				{
					System.out.println("SOMETHING WENT WRONG TRY AGAIN...");
				}
				
			}
			else if(c == 4)
			{
				// SEARCH STUDENT 
				StudentDao.DisplayStudentToDB();
			}
			else if(c == 5)
			{
				// DISPLAY TABLE 
				StudentDao.DisplayTableToDB();
			}
			else if(c == 6)
			{
				break;
				// EXIT STUDENT-APP 
			}
			else {
				
			}
			
		}
		System.out.println("============================");
		System.out.println("THANKYOU FOR USING MY APP");
		System.out.println("============================");
	}
}
