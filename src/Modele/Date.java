package Modele;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
  public static final String date = "yyyy-MM-dd HH:mm:ss";

  public static java.util.Date now() {
  Calendar calendar = Calendar.getInstance();
  SimpleDateFormat dateFormat = new SimpleDateFormat(date);
  try {
	return dateFormat.parse(String.valueOf(calendar.getTime()));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return null;
}
  public static void  main(String arg[]) {
  System.out.println("Date and Time : " + Date.now());
  }
}
