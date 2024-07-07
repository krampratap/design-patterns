package b_creational.builder;

public class Phone {
    private String OS;
    private String processor;
    private double screenSize;
    private int battery;
    private int camera;

    public Phone(String OS,String processor, double screenSize, int battery, int camera)
    {
        this.OS = OS;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone (OS = "+ OS + " processor = " + processor
                + " screenSize = "+screenSize +" battery = "+battery + " camera = " +camera + ")";
    }

}
