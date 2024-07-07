package c_Structural.facade;

public class FacadeMain {
    /*
        If many classes are doing the same thing then we can use facade
     */
    public static void main(String[] args) {
        String test = "Testing Facade";

        WebHelperFacade.generateReports("firefox", "html", test);
        WebHelperFacade.generateReports("firefox", "junit", test);
        WebHelperFacade.generateReports("chrome", "html", test);
        WebHelperFacade.generateReports("chrome", "junit", test);
    }
}
