package b_creational.singleton;

//LAZY INITIALIZATION
public class Singleton2 {
    public static void main(String[] args) {
        Database2 d1 = Database2.getInstance();
        Database2 d2 = Database2.getInstance();
    }
}
class Database2{
    //We are creating the Database obj in the Singleton example even if it is not called.
    //If the Singleton class is heavy then we are wasting our memory.
    //So, In Database2, we create the obj when getInstance is called.
    private static Database2 Obj;
    private Database2(){
        System.out.println("Instance Created");
    }
    public static Database2 getInstance()
    {//If the static is already created then we will return that obj only.
        if(Obj==null)
        {
            Obj = new Database2(); //LAZY INITIALIZATION
        }
        return Obj;
    }
}