package c_structural.facade;

public class Firefox {
    public static Driver getFirefoxDriver(){
        return null;
    }
    public static void generateHTMLReport(String test, Driver driver){
        System.out.println("Generating HTML report for Firefox driver");
    }
    public static void generateJUNITReport(String test, Driver driver){
        System.out.println("Generating JUNIT report for Firefox driver");
    }
}
