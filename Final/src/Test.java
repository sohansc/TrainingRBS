import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import rbs.module.transaction.dao.DaoCreateImplementation;
import rbs.module.transaction.dao.DaoImplementation;

public class Test {

	public static void main(String[] args) throws ParseException {
		DaoImplementation d = new DaoImplementation();
		
				
		//System.out.println(d.getTransactions(stringToDate("18-08-2016")));
		DaoCreateImplementation akshay = new DaoCreateImplementation();
		//LocalDate ldt = LocalDate.now();
		//String mydate = ldt.toString();
		//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    //SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
	    //java.util.Date date = format1.parse(mydate);
	    //String newdate = format2.format(date);
	    //System.out.println(newdate);
	    
		
		
		akshay.CreateTransactions(1000, "withdrawal", 1, "deposit", 1);

	//  	System.out.println(d.getTransactions(stringToDate("18-08-2016"),stringToDate("20-08-2016")));
	//	System.out.println(d.getTransactions("FX"));
	//	System.out.println(d.getTransactions(1));
	}
	
	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}
}