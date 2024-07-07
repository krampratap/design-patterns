package b_Creational.singleton;

//Eager Initialization
public class Singleton {
    public static void main(String[] args) {
        //Singleton patterns allows to use single instance in the whole application.
        //The below code gives us errors as constructor is private
        //Database a = new Database();
        //Database b = new Database();
        Database d1 = Database.getInstance();
        Database d2 = Database.getInstance();
        //Both return the same object;
    }
}

class Database {
    //This is static because we are using it in getInstance which is a static method
    // 1. Create a private static object of the class
    static Database obj = new Database(); //EAGER Creation
    // 2. Make the no args constructor as private. So that new objects are not created
    private Database(){
        System.out.println("Eager initialization: Initialization before Database is called");
    }
    //3. Create a method with any name which returns the same static object of the class.
    public static Database getInstance()
    {
        return obj;
    }
}
