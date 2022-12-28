package com.student.manage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException,SQLException {
		
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			
			System.out.println("Press 4 to Exit App");
			int c=Integer.parseInt(br.readLine());
			
			
			if(c==1)
			{
				//Add Student..
				System.out.println("Enter User Name:");
				String Name=br.readLine();
				
				System.out.println("Enter User Phone Number:");
				String Phone=br.readLine();
				
				System.out.println("Enter User City");
				String City=br.readLine();
				
				//create student object to store student
				Student st=new Student(Name,Phone,City);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student is added Successfully...");
				}
				else
				{
					System.out.println("Something went wrong try again...");
				}
				
				System.out.println(st);
				
			}
			else if(c==2)
			{
				//Delete Student
				System.out.println("Enter the Student User-Id to Delete");
				int Userid=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(Userid);
				if(f)
				{
					System.out.println("Deleted....");
					
				}
				else
				{
					System.out.println("Something went wrong....");
				}
				
			}
			else if(c==3)
			{
				//Display Student
				StudentDao.showAllStudent();
			}
			
			else if(c==4)
			{
				//Exit
				break;
			}
			else
			{
				
			}
			
		}
		System.out.println("Thank you for using my application....");
		System.out.println("See you soon...bye bye");

	}

}
