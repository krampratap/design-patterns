package b_Creational.prototype;

public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop sapna = new BookShop();
        sapna.setShopName("Sapna book stall");
        sapna.getBooksFromDataBase();


        BookShop newSapna = new BookShop();
        newSapna.setShopName("New Sapna book stall");
        //Again we have to load data from database
        newSapna.getBooksFromDataBase();
        //But we can use clone to get the book list from first object instead of DB
        //Before using .clone().. we have to implement Cloneable on BookShop
        //and override clone method.. the default override will give SHALLOW cloning.. referencing to same Address

        BookShop newSapnaWithClone = (BookShop)sapna.clone(); //Add CloneNotSupportedException to the main
                                                              // clone() returns Object.. so typecast is required
        newSapnaWithClone.setShopName("New Clone Sapne book stall");

        sapna.getBooksList().remove(1);
        System.out.println(sapna);
        System.out.println(newSapnaWithClone);

        //If we want to achieve deep cloning.. Modify the clone override method

    }
}
