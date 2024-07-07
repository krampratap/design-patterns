package b_Creational.factory;

import b_Creational.factory.phone.OS;
import b_Creational.factory.phone.OperatingSystemFactory;
import b_Creational.factory.phone.Windows;

public class Factory {
    //Suppose you have multiple OS
    //Depending

    public static void main(String[] args) {

        //This will expose which OS is defined to the user
        OS obj = new Windows();
        obj.spec();

        OperatingSystemFactory osf = new OperatingSystemFactory(); //Factory Object
        //If you have additional classes in future.. it will change the factory class (OperatingSystemFactory)
        //and not the client application i.e main method
        OS obj1 = osf.getInstance("Secure");
        obj1.spec();
    }
}
