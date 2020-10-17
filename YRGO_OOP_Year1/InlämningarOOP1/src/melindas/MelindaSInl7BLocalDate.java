package melindas;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Locale;

public class MelindaSInl7BLocalDate {

	Calendar c = Calendar.getInstance();
	private String language;
	private String country;

	public MelindaSInl7BLocalDate() {		
	}
	
	public String getLanguage() 
	{
		return language;
	}

	public void setLanguage(String language) 
	{
		this.language = language;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public PrintStream returnDate() 
	{
	    return System.out.format(new Locale (language, country),"%tc%nSpråkkod: %s%n", c, language);
	}
//	%tc = skriv ut nuvarande tid etc, t ex: Tue Oct 09 21:19:29 CEST 2018
}