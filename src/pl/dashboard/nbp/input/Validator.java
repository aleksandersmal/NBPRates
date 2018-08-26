package pl.dashboard.nbp.input;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pl.dashboard.nbp.exceptions.TooMuchArgsException;
import pl.dashboard.nbp.util.Consts;

public class Validator {

	boolean validateInputDate(String date) {
		DateFormat dateFormatter = new SimpleDateFormat(Consts.DATE_FORMAT);
		Calendar today = Calendar.getInstance();
		try {
			Date dateToCheck = dateFormatter.parse(date);
			Date minimumDate = dateFormatter.parse(Consts.MINIMUM_DATE);
			if (minimumDate.getTime() > dateToCheck.getTime()) {
				System.out.println(Consts.EARLY_DATE_ERROR);
				return false;
			} else if (dateToCheck.getTime() <= today.getTime().getTime()) {
				return true;
			} else {
				System.out.println(Consts.LATER_DATE_ERROR);
				return false;
			}
		} 
		catch (ParseException e) {
			System.out.println(Consts.WRONG_DATE_FORMAT);
			return false;

		}
	}

	boolean validateArgsTable(String[] args) throws TooMuchArgsException{
		if (args.length <= 1) {
			return true;
		} else {
			throw new TooMuchArgsException(args.length);
		}
	}
}
