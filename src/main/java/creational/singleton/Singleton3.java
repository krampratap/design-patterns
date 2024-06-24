package creational.singleton;

//CONCURRENT ISSUE
public class Singleton3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database3 d1 = Database3.getInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database3 d1 = Database3.getInstance();
            }
        });
        //Earlier example only one main method (one thread). So only one instance.
        //If two threads access the getInstance simultaneously then we will have two objects. NOT SINGLETON.
        //Un comment and Run the code.
        t1.start();
        t2.start();
    }
}
class Database3{
    private static Database3 Obj;
    private Database3(){
        System.out.println("Instance Created");
    }

/*    public static Database3 getInstance()
    {
        if(Obj==null)
        {
            Obj = new Database3(); //LAZY INITIALIZATION
        }
        return Obj;
    }*/

    //To solve the above concurrent call problem we can add synchronized
    //This synchronized will reduce the performance by 100 times of the application as it will lock
    // once called and unlock after the call is done
    public static synchronized Database3 getInstance()
    {
        if(Obj==null)
        {
            Obj = new Database3(); //LAZY INITIALIZATION
        }
        return Obj;
    }
}