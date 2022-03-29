package exeception;

public class AccountsNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "No Books Found!!";
	}

	
}