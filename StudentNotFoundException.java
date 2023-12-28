package CustomException;

// 6.custom exception

public class StudentNotFoundException extends RuntimeException  {

	private String message;

	public StudentNotFoundException (String message)
	{
		this.message=message;
	}
	public String getMessage()
	{
		return message;
	}

}
