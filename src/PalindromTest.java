import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JSpinner.ListEditor;

public class PalindromTest {
	static String str; 
	//Z�hlervariable um die Datumspalindrome(yyyy-MM-dd) ohne f�hrender Null zu z�hlen
	static int zaehlen1;
	//Z�hlervariable um die Datumspalindrome(yyyy-MM-dd) mit f�hrender Null zu z�hlen
	static int zaehlen2;
	//Z�hlervariable um die Datumspalindrome(dd-MM-yyyy) ohne f�hrender Null zu z�hlen
	static int zaehlen3;
	//Z�hlervariable um die Datumspalindrome(dd-MM-yyyy) mit f�hrender Null zu z�hlen
	static int zaehlen4;
	//ArrayList um die Datumspalindrome(yyyy-MM-dd) ohne f�hrender Null auszugeben
	static ArrayList<String> liste1 = new ArrayList<>();
	//ArrayList um die Datumspalindrome(yyyy-MM-dd) mit f�hrender Null auszugeben
	static ArrayList<String> liste2 = new ArrayList<>();
	//Z�hlervariable um die Datumspalindrome(dd-MM-yyyy) ohne f�hrender Null auszugeben
	static ArrayList<String> liste3 = new ArrayList<>();
	//ArrayList um die Datumspalindrome(dd-MM-yyyy) mit f�hrender Null auszugeben
	static ArrayList<String> liste4 = new ArrayList<>();
	/**
	   * Methode spiegeln, welche den String umdreht.	
	   * @param str - Vom Benutzer eingegebener String
	   * @return - Es wird der gespiegelte String zur�ckgegeben
	   */
	  public static String spiegeln( String str )
	  {
		// Es wird ein String Object erstellt
	    String spiegelString = new String();

	    // Mittels for-Schleife wird der String durchgegangen (str.length-1, da bis Index 0 heruntergez�hlt wird wird zu z�hlen)
	    for ( int i = str.length()-1; i >= 0; i-- )
	    // String wird von hinten beginnend in Spiegelstring gespeichert	
	      spiegelString += str.charAt(i);
	    
	    return spiegelString;
	  }
	  /**
	   * Die Methode checkPalindrom �berpr�ft ob der gespiegelte String gleich dem Ursprungsstring ist und gibt dann den String zur�ck, wenn das der Fall ist
	   * @param str - Vom Benutzer gew�hlter String
	   * @return - Es wird der Palindrom String zur�ckgegeben
	   */
	  public static String checkPalindrom(String str)
	  {
		  //Kleingeschriebener String wird in str erneut hineingespeichert
		  str = str.toLowerCase();
		  
		  // �berpr�fe Ursprungsstring mit gespiegeltem String
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
	  
	  public static void checkDatumPalindrom() 
	  {
		  // String mit Stardatum wird erstellt
		  String start = "2000-01-01";
		  //sdf ist ein Objekt zum Erzeugen eines Datums aus einem String mit gewisser Formatierung
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  // In c wird ein bereits vorher erstellter Calendar hineingespeichert
		  Calendar c = Calendar.getInstance();
		  try {
				// setTime setzt Calendar auf das gesetzte Datumsobjekt von Startdatum (sdf.parse wandelt Startdatum in ein Datumsobjekt um)
			  c.setTime(sdf.parse(start));
			// Wenn der angebene Starstring nicht mit dem Datumsformat zusammenpasst wird eine Exception geworfen
		  } catch (ParseException e) {
				e.printStackTrace();
			}
		  System.out.println("Folgende Daten sind Palindrome(yyyy-MM-dd):");
		  String str;
		  String[] arr2;
		  String jahr;
		  String monat;
		  String tag;
		  String str2;
		  // 36525 sind alle Tage eines Jahrhundertes
		  for (int i = 0; i < 36525; i++) {
			  //aktuelle Datumumsobjekt wird in einen String umgewandelt
			  str = sdf.format(c.getTime());
			  //Datumstring wird in drei Teile aufgeteilt: yyyy MM dd
			  arr2 = str.split("-");
			  jahr = arr2[0];
			  monat = arr2[1];
			  tag = arr2[2];
			  //Falls an der 1.Stelle von Monat eine 0 ist wird nur die 2.Stelle als Monat verwendet
			  if(monat.charAt(0) == '0')
			  {
				  monat = monat.charAt(1)+"";
			  }
			//Falls an der 1.Stelle von Tag eine 0 ist wird nur die 2.Stelle als Tag verwendet
			  if(tag.charAt(0) == '0')
			  {
				  tag = tag.charAt(1)+"";
			  }	
			  //Jahr, Monat und Tag wird wieder zusammengesetzt ohne f�hrende Nullen
			  str2 = jahr + monat + tag;
			  str = str.replace("-", "");
			  //�berpr�ft Datum mit f�hrenden Nullen auf Palindrom 
			  if(checkPalindrom(str) != null)
					  {
				  			
				  			liste1.add(str);
					  } else{
						  
					  }
			//�berpr�ft Datum ohne f�hrenden Nullen auf Palindrom 
			  if(checkPalindrom(str2) != null)
			  {
				  liste2.add(str2);
			  } else{
				  
			  }
			  //Z�hlt immer einen Tag dazu
			  c.add(Calendar.DATE, 1);
		  }
		  System.out.println();
		  System.out.println("Ausgabe der Datumspalindrome(yyyy-MM-dd) mit f�hrenden Nullen:");
		  
	  //Arraylist  liste1 zur Ausgabe von Datumspalindromen(yyyy-MM-dd) mit f�hrenden Nullen
	  for(String i : liste1)
	  {
		  zaehlen1++;
		  System.out.println("Datumspalindrom mit f�hrender Null " + zaehlen1 + ": " + i);
	  }
	  System.out.println();
	  System.out.println("Ausgabe der Datumspalindrome(yyyy-MM-dd) ohne f�hrenden Nullen:");
	  
	  // Arraylist liste2 zur Ausgabe von Datumpalindromen(yyyy-MM-dd) ohne f�hrender Null
	  for(String j : liste2)
	  {
		  zaehlen2++;
		  System.out.println("Datumspalindrom ohne f�hrender Null " + zaehlen2 + ": " + j);
	  }
	  }
	  
	  public static void checkDatumPalindrom1() 
	  {
		  // String mit Stardatum wird erstellt
		  String start = "01-01-2000";
		  //sdf ist ein Objekt zum Erzeugen eines Datums aus einem String mit gewisser Formatierung
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		  // In c wird ein bereits vorher erstellter Calendar hineingespeichert
		  Calendar c = Calendar.getInstance();
		  try {
				// setTime setzt Calendar auf das gesetzte Datumsobjekt von Startdatum (sdf.parse wandelt Startdatum in ein Datumsobjekt um)
			  c.setTime(sdf.parse(start));
			// Wenn der angebene Starstring nicht mit dem Datumsformat zusammenpasst wird eine Exception geworfen
		  } catch (ParseException e) {
				e.printStackTrace();
			}
		  System.out.println("Folgende Daten sind Palindrome(dd-MM-yyyy):");
		  String str;
		  String[] arr2;
		  String jahr;
		  String monat;
		  String tag;
		  String str2;
		  // 36525 sind alle Tage eines Jahrhundertes
		  for (int i = 0; i < 36525; i++) {
			  //aktuelle Datumumsobjekt wird in einen String umgewandelt
			  str = sdf.format(c.getTime());
			  //Datumstring wird in drei Teile aufgeteilt: dd MM yyyy
			  arr2 = str.split("-");
			  monat = arr2[1];
			  tag = arr2[0];
			  jahr = arr2[2];
			  //Falls an der 1.Stelle von Monat eine 0 ist wird nur die 2.Stelle als Monat verwendet
			  if(monat.charAt(0) == '0')
			  {
				  monat = monat.charAt(1)+"";
			  }
			//Falls an der 1.Stelle von Tag eine 0 ist wird nur die 2.Stelle als Tag verwendet
			  if(tag.charAt(0) == '0')
			  {
				  tag = tag.charAt(1)+"";
			  }	
			  //Jahr, Monat und Tag wird wieder zusammengesetzt ohne f�hrende Nullen
			  str2 = tag + monat + jahr;   
			  str = str.replace("-", "");
			  //�berpr�ft Datum mit f�hrenden Nullen auf Palindrom 
			  if(checkPalindrom(str) != null)
					  {
				  			liste3.add(str);
					  } else{
						  
					  }
			//�berpr�ft Datum ohne f�hrenden Nullen auf Palindrom 
			  if(checkPalindrom(str2) != null)
			  {
		  			liste4.add(str2);
			  } else{
				  
			  }
			  //Z�hlt immer einen Tag dazu
			  c.add(Calendar.DATE, 1);
		  }
		  System.out.println();
		  System.out.println("Ausgabe der Datumspalindrome(dd-MM-yyyy) mit f�hrenden Nullen:");
		  
	  //Arraylist  liste3 zur Ausgabe von Datumspalindromen(dd-MM-yyyy) mit f�hrenden Nullen
	  for(String i : liste3)
	  {
		  zaehlen3++;
		  System.out.println("Datumspalindrom mit f�hrender Null " + zaehlen3 + ": " + i);
	  }
	  System.out.println();
	  System.out.println("Ausgabe der Datumspalindrome(dd-MM-yyyy) ohne f�hrenden Nullen:");
	  
	  // Arraylist liste2 zur Ausgabe von Datumpalindromen(dd-MM-yyyy) ohne f�hrender Null
	  for(String j : liste4)
	  {
		  zaehlen4++;
		  System.out.println("Datumspalindrom ohne f�hrender Null " + zaehlen4 + ": " + j);
	  }
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
	    
	    System.out.println();
	   
	    checkDatumPalindrom();
	    System.out.println();
	    checkDatumPalindrom1();
	    
	    int zaehlen5 = zaehlen1 + zaehlen2 + zaehlen3 + zaehlen4;
	    
	    System.out.println();
	    System.out.println("Es gibt " + zaehlen5 + " Datumspalindrome im 21. Jahrhundert!" );
}
}
