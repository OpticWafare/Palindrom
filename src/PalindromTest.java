import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PalindromTest {
	static String str;  
	
	/**
	   * Methode spiegeln, welche den String umdreht.	
	   * @param str - Vom Benutzer eingegebener String
	   * @return - Es wird der gespiegelte String zurückgegeben
	   */
	  public static String spiegeln( String str )
	  {
		// Es wird ein String Object erstellt
	    String spiegelString = new String();

	    // Mittels for-Schleife wird der String durchgegangen (str.length-1, da bis Index 0 heruntergezählt wird wird zu zählen)
	    for ( int i = str.length()-1; i >= 0; i-- )
	    // String wird von hinten beginnend in Spiegelstring gespeichert	
	      spiegelString += str.charAt(i);
	    
	    return spiegelString;
	  }
	  /**
	   * Die Methode checkPalindrom überprüft ob der gespiegelte String gleich dem Ursprungsstring ist und gibt dann den String zurück, wenn das der Fall ist
	   * @param str - Vom Benutzer gewählter String
	   * @return - Es wird der Palindrom String zurückgegeben
	   */
	  public static String checkPalindrom(String str)
	  {
		  //Kleingeschriebener String wird in str erneut hineingespeichert
		  str = str.toLowerCase();
		  
		  // Überprüfe Ursprungsstring mit gespiegeltem String
		  if(str.equals((spiegeln(str)))){
			return str;
		}
		  return null;
	  }
	  
	  public static String checkSatzpalindrom(String str)
	  {
		  // Es werden vom Ursprungsstring Satzzeichen entfernt
		  str = str.replace(" ", "");
		  str = str.replace(",", "");
		  str = str.replace(":", "");
		  str = str.replace(";", "");
		  str = str.replace("!", "");
		  str = str.replace("?", "");
		  str = str.replace(".", "");
		  
//		  System.out.println(str);
		  
		  return checkPalindrom(str);
	  }
	  
	  public static void main ( String[] args )
	  {
	    String str2 = "Rentner";
	    if(checkPalindrom(str2) != null)
	    {
	    	System.out.println("Das Wort " + str2 + " ist ein Palindrom!");
	    } else if(checkPalindrom(str2) == null)
	    {
	    	 System.out.println("Das Wort " + str2 + " ergibt kein Palindrom!");
	    }
	    
	    String str3 = "Die Liebe ist Sieger; stets rege ist sie bei Leid.";
	    if(checkSatzpalindrom(str3) != null)
	    {
	    	System.out.println("Der Satz " + str3 + " ergibt ein Satzpalindrom!");
	    } else if(checkPalindrom(str3) == null)
	    {
	    	System.out.println("Der Satz " + str3 + " ergibt kein Satzpalindrom!");
	    }
	   
}
}
