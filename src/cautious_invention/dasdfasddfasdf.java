package cautious_invention;

import java.util.regex.Pattern;

public class dasdfasddfasdf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(validateEmail("camks12-@gmail.com"));
	}
	
	public static boolean validateEmail(String email) {
		return Pattern.compile("^[-a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[-a-zA-Z0-9.-]+$").matcher(email).matches();
		
	}

}
