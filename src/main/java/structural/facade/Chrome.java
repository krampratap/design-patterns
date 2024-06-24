package structural.facade;

public class Chrome {
    public static Driver getChromeDriver(){
        return null;
    }
    public static void generateHTMLReport(String test, Driver driver){
        System.out.println("Generating HTML report for Chrome driver");
    }
    public static void generateJUNITReport(String test, Driver driver){
        System.out.println("Generating JUNIT report for Chrome driver");
    }
}
