package stepdefinitions;

public class ReportAlreadyPulledException extends Exception{
	String s;
	ReportAlreadyPulledException(String b) {
	     s=b;
	     System.out.println(s);
	   }

}
