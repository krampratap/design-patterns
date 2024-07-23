package b_Creational.singleton;

//PERFORMANCE ISSUE - DOUBLY Checked Locking
public class Singleton4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database4 d1 = Database4.getInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database4 d1 = Database4.getInstance();
            }
        });
        t1.start();
        t2.start();
    }
}
class Database4{
    private static Database4 Obj;
    private Database4(){
        System.out.println("Instance Created");
    }

    //To solve the above performance flow down problem we can add synchronized at obj creation level 
    // and add DOUBLE check blocking
    //This synchronized will reduce the performance by 5 to 6 times only
    public static synchronized Database4 getInstance()
    {
        if(Obj==null)
        {
            synchronized (Database.class)
            {
                if(Obj==null)
                    Obj = new Database4(); //LAZY INITIALIZATION
            }
        }
        return Obj;
    }
}