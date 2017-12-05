package utility;

import java.security.SecureRandom;

public class GeneratePassword {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
 
	public String randomPassword( int len ){
	SecureRandom rnd = new SecureRandom();
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt(rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}
	
