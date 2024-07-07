package c_structural.facade;

public class WebHelperFacade {
    public static void generateReports(String explorer, String report, String test){
        Driver driver = null;
        switch (explorer){
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report){
                    case "html":
                        Firefox.generateHTMLReport(test,driver);
                        break;
                    case "junit":
                        Firefox.generateJUNITReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report){
                    case "html":
                        Chrome.generateHTMLReport(test,driver);
                        break;
                    case "junit":
                        Chrome.generateJUNITReport(test, driver);
                        break;
                }
                break;
        }
    }
}
