package b_Creational.builder;

public class Shop {
    public static void main(String[] args) {
        // You have to pass all the parameters
        // You have to maintain the order.
        Phone p = new Phone("Andoid","Qualcomm", 6.5,1000,2);
        System.out.println(p);

        PhoneBuilder p1 = new PhoneBuilder().setOs("Iphone").setBattery(10); //You can concatenate the set Methods as we are returning " this "
        Phone p2 = p1.getPhone();
        System.out.println(p2);
    }
}
