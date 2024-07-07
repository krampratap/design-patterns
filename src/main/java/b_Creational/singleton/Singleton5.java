package b_Creational.singleton;

//ENUM will work on JAVA version > 1.5
public class Singleton5 {
    public static void main(String[] args) {
        Database5 obj1 = Database5.INSTANCE;
        obj1.i = 5;
        obj1.show();

        Database5 obj2 = Database5.INSTANCE;
        obj2.i = 6;

        obj1.show();
    }
}
//Enum is a special type of class which in itself is a thread safe design pattern
enum Database5
{
    INSTANCE; //By default creates a private constructor
    int i;
    public void show()
    {
        System.out.println(i);
    }
}
