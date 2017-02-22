package helper;

public class DateConvert {

	private DateConvert()
	{
		new DateConvert();
	}
	
	public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	
	public static java.util.Date convertSqlDateToJavaDate(java.sql.Date date) {
	    return new java.util.Date(date.getTime());
	}
	
}
