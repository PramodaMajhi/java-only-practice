
public class TestOptionalParam {
	
public static void loGin(String username, String password, String ...zipCode) {
		
		System.out.println("Username " + username);
		System.out.println("Password " + password);
		
		System.out.println("ZipCode length  " + zipCode.length);		
		
		
		if(zipCode.length > 0) {
	     	String actualzipCode =  zipCode[0];
	     	System.out.println("Executed and actual zipcode  " + actualzipCode);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     loGin("Pramod","password");
		 loGin("Anand", "password2", "94538","94536", "95391"); 
		
	
	}

	
	
}
