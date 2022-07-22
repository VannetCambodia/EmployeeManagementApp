package ems.management.Util.exception;

public class NotFoundException extends RuntimeException{

	public NotFoundException(int id) {
		super("Employee doesn't exit " + id);
	}

	public NotFoundException(String string) {
		super(string);
	}	
}
