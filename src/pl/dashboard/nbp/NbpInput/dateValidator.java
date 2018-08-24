package pl.dashboard.nbp.NbpInput;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
	
	boolean validateInputDate(String date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date result =  df.parse(date);
			return true;
		} catch (Exception e) {
			return false;  

		}
	}
}
