package Modele;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Date {
  public static final String date = "yyyy-MM-dd HH:mm:ss";

  public static String now() {
  Calendar calendar = Calendar.getInstance();
  SimpleDateFormat dateFormat = new SimpleDateFormat(date);
  return dateFormat.format(calendar.getTime());
}
  public static void  main(String arg[]) {
  System.out.println("Date and Time : " + Date.now());
  }
}
