package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomException.InvalidChoiceException;
import CustomException.StudentNotFoundException;
import customSorting.SortStudentByAge;
import customSorting.SortStudentById;
import customSorting.SortStudentByMarks;
import customSorting.SortStudentByName;

// implementation class 
public class StudentManagementSystemImpl implements StudentManagementSystem {


	Scanner scan= new Scanner(System.in);


	// we are using collection as our database --> MAP--interface
	// key --> Student id; ---> id in string fromate bec alphanumarics "JSP101" and
	// values --> Student Object .

	Map<String,Student> db =new LinkedHashMap<String,Student>();

	@Override
	public void addStudent()
	{

		// Accepting the AGE
		System.out.println("ENTER THE STUDENT AGE");
		int age=scan.nextInt();

		// Accepting the NAME
		System.out.println(" ENTER THE STUDENT NAME");
		String name=scan.next();

		// Accepting the MARKS
		System.out.println("ENETER THE STUDENT MARKS");
		int marks=scan.nextInt();

		//CREATE A STUDENT INTANCE (OBJECT)
		Student std=new Student (age, name,marks);

		//adding Entry inside DATEBASE (MAP)
		db.put(std.getId(),std);   // --> adding key and value into map interface
		// std.getid() ---> it will get id from autogeneration and age,name,marks from student object

		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student ID is"+std.getId());
	}
	@Override
	public void displayStudent()
	{

		// Accepting the Student ID and Converting into Uppercase

		System.out.println(" ENTER THE STUDENT ID :");
		String id = scan.next();               //-->  JSP101 [OK] ,jsP101 [NOT OK] so use input Uppsercase()

		id =id.toUpperCase(); 
		// checking the id is present in the Data base or not 

		if(db.containsKey(id))
		{
			Student std=db.get(id);   // getting the value (STUDENT OBJECT)
			System.out.println("ID :"+std.getId());
			System.out.println("AGE :"+std.getAge());
			System.out.println("NAME :"+std.getName());
			System.out.println("MARKS :"+std.getMarks());
			//	System.out.println(std);  //--> overridden in toString in STUDENT CLASS 
		}
		else {
			try {
				String message ="Student with the ID :"+id+" is Not Found";
				throw new StudentNotFoundException(message);
			}
			catch( Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllStudents()
	{

		if(!db.isEmpty())
		{
			System.out.println("Student Details are as follows : ");
			System.out.println("------------------------------------------");

			// converting the map into set using keySet()
			Set<String>	setOfKeys=db.keySet();

			// travers keys (Student id's
			for(String key : setOfKeys )
			{
				System.out.println(db.get(key)); // getting values (Student object)
			}
		}
		else {
			// to get custom exception 
			try {
				String message= " NO Student Records found to Display!....";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeStudent()
	{
		System.out.println("Enter your Id");
		String id=scan.next().toUpperCase();
		//id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found");
			System.out.println(db.get(id));//getting student object
			db.remove(id);
			System.out.println("Student Record Deleted Sucessfully");
		}
		else
		{
			try {
				String message="Student with the ID"+id+"is not Found";
				throw new StudentNotFoundException(message);
			}catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents()
	{
		if(!db.isEmpty()) {
			System.out.println("No of Student Records : "+db.size());
			db.clear();
			System.out.println(" All the Student Details are Deleted Successfully");
		}	
		else{
			try {
				String message= " NO Student Records found to Delete! ....";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}

		}
	}
	@Override
	public void updateStudent() 
	{
		System.out.println("Enter your Id");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std = db.get(id);//getting Student Object

			//Menu Driven Program
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks\n Enter Choice");

			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				std.setAge(age);//std.setAge(scan.nextInt())
				System.out.println("Age Updated Successfully");
				break;

			case 2:
				System.out.println("Enter Name");
				String name=scan.next();
				std.SetName(name);//std.setName(scan.nextInt())
				System.out.println("Name Updated Successfully");
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=scan.nextInt();
				std.SetMarks(marks);//std.setMarks(scan.nextInt())
				System.out.println("Marks Updated Successfully");
				break;

			default:
				try {
					String message="Invallid choice, kindly Enter Valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try {
				String message="No Student Record Found";
				throw new StudentNotFoundException(message);
			}catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void countStudents()
	{
		System.out.println("Number of Student Records : "+db.size());
	}

	@Override
	public void sortStudents() 
	{

		//Reference of List & Object of ArrayList Storing Student Objects
		List<Student> list=new ArrayList<Student>();

		//Converting Map into Set using keySet()
		Set<String> keys=db.keySet();

		//Traverse keys
		for(String key:keys)
		{
			Student std=db.get(key);//getting student object
			list.add(std);//adding student object into list
		}

		System.out.println("1:Sort Student By ID\n2:Sort StudentBy AGE");
		System.out.println("3:Sort Student By NAME\n4:Sort StudentBy MARKS");
		System.out.println("Enter Choice");

		int choice =scan.nextInt();

		switch(choice) {
		case 1: 
			Collections.sort(list,new SortStudentById());
			for(Student s : list) {
				System.out.println(s);
			}
			break;
		case 2: 
			Collections.sort(list,new SortStudentByAge());
			for(Student s : list) {
				System.out.println(s);
			}
			break;
		case 3: 
			Collections.sort(list,new SortStudentByName());
			for(Student s : list) {
				System.out.println(s);
			}
			break;
		case 4: 
			Collections.sort(list,new SortStudentByMarks());
			for(Student s : list) {
				System.out.println(s);
			}
			break;	
		}
	}
	@Override
	public void getStudentWithHighestMarks()
	{

		List<Student> list=new ArrayList<Student>();
		Set<String> keys = db.keySet();
		for(String key : keys)
		{
			Student std = db.get(key);    // getting Student Object 
			list.add(std);               // Adding Student Object into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with Highest Marks:");
		System.out.println(list.get(list.size()-1));
	}
	@Override
	public void getStudentWithLowestMarks() 
	{

		List<Student> list=new ArrayList<Student>();
		Set<String> keys = db.keySet();
		for(String key : keys)
		{
			Student std = db.get(key);    // getting Student Object 
			list.add(std);               // Adding Student Object into list
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Student with Lowest Marks:");
		System.out.println(list.get(0));
	}

}
