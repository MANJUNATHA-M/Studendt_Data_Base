
package sdbms;

import java.util.Scanner;

public class StudentSolution {

	public static void main(String[] args) {


		System.out.println("welcome to Student DataBase Project");
		System.out.println("--------------------------------------------");

		Scanner scan=new Scanner(System.in);

		//UPCASTING TO ACHIVE ABTRACTION
		StudentManagementSystem sms= new StudentManagementSystemImpl ();

		//INFINITE LOOP
		while(true)
		{

			// MENU DRIVEN PROGRAM

			System.out.println(" 1:add Student Details\n 2:display Student Details\n 3:display All Students");
			System.out.println(" 4:removeStudent\n 5:removeAllStudents\n 6:updateStudent");
			System.out.println(" 7:countStudents\n 8:sortStudents\n 9:getStudentWithHighestMarks");
			System.out.println(" 10:getStudentWithLowestMarks\n 11:EXIT\nEnter Choics");

			int choice =scan.nextInt();

			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;

			case 2:
				sms.displayStudent();
				break;

			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("THANK YOU....!");
				System.exit(0);

			default:
				try {
					String message ="INVALID CHOICE ... KINDLY ENTER THE VALID CHOICE";
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}


			} // end of switch

			System.out.println("------------------------");

		} // end of while loop

	}// end of main()

}//end of class
