package sdbms;

public class Student {


	private String id;
	private static int count=101;

	private int age;
	private String name;
	private Integer marks;

	Student ( int age, String name, int marks)
	{
		this.id="JSP"+count;
		count++;
		this.age=age;
		this.name=name;
		this.marks=marks;
	}
	public String getId()
	{
		return id;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public void SetName(String name)
	{
		this.name=name;
	}
	public int getMarks()
	{
		return marks;
	}
	public void SetMarks(int marks)
	{
		this.marks=marks;
	}
	@Override
	public String toString()
	{
		return " Student ID:"+id+" AGE:"+age+" NAME:"+name+" MARKS: "+marks;
	}
}
