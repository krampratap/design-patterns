package a_ObjectOriented.c_ParkingLot;

class Driver {
    private int id;
    private Vehicle vehicle;
    private int paymentDue;

    public Driver(int id, Vehicle vehicle) {
        this.id = id;
        this.vehicle = vehicle;
        this.paymentDue = 0;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public int getId() {
        return this.id;
    }

    public void charge(int amount) {
        this.paymentDue += amount;
    }
}
