package pl.dashboard.nbp.util;

public final class Consts {

	public static final String MINIMUM_DATE = "2004-12-13";
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String TOO_MUCH_ARGS = "You entered too much arguments:";
	public static final String LATER_DATE_ERROR = "Date You entered is later date than today.";
	public static final String EARLY_DATE_ERROR = "Date You entered is earlier than minimum date: " + MINIMUM_DATE;
	public static final String DOWNLOAD_NBP_ERROR = "Cannot download data from NBP Server for that date. Please enter another date";
	public static final String FILE_NOT_FOUND = "File could not be downloaded";
	
	public static final String TABLE_URL = "http://api.nbp.pl/api/exchangerates/tables/c/";
	public static final String WRONG_DATE_FORMAT = "Date You entered is not valid. Proper date Input: " + DATE_FORMAT;
	public static final String XML_FORMAT = "?format=xml";
	public static final String JSON_FORMAT = "?format=json";

	
	public static final String CODE = "Code";
	public static final String BID = "Bid";
	public static final String ASK = "Ask";
	public static final String CURRENCY = "Currency";

	public static final class Currencies {
		public static final String EUR = "EUR";
		public static final String USD = "USD";
		public static final String CHF = "CHF";
		public static final String GBP = "GBP";
	}

	public static final class TableBuilders {
		public static final String TITLE = "Currency = Bid; Ask";
		public static final String NEW_LINE = "\n";
		public static final String DATE = "Date: ";

	}

}
