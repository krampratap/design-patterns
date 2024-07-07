package a_ObjectOriented.c_ParkingLot;

class ParkingGarage {
    private ParkingFloor[] parkingFloors;

    public ParkingGarage(int floorCount, int spotsPerFloor) {
        this.parkingFloors = new ParkingFloor[floorCount];
        for (int i = 0; i < floorCount; i++) {
            this.parkingFloors[i] = new ParkingFloor(spotsPerFloor);
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : this.parkingFloors) {
            if (floor.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : this.parkingFloors) {
            if (floor.getVehicleSpots(vehicle) != null) {
                floor.removeVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
}
