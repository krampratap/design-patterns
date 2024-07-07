package a_oops.c_ParkingLot;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class ParkingSystem {
    private ParkingGarage parkingGarage;
    private int hourlyRate;
    private Map<Integer, Integer> timeParked;    // map driverId to time that they parked

    public ParkingSystem(ParkingGarage parkingGarage, int hourlyRate) {
        this.parkingGarage = parkingGarage;
        this.hourlyRate = hourlyRate;
        this.timeParked = new HashMap<>();
    }

    public boolean parkVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        boolean isParked = this.parkingGarage.parkVehicle(driver.getVehicle());
        if (isParked) {
            this.timeParked.put(driver.getId(), currentHour);
        }
        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
        if (!this.timeParked.containsKey(driver.getId())) {
            return false;
        }
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int timeParked = (int) Math.ceil(currentHour - this.timeParked.get(driver.getId()));
        driver.charge(timeParked * this.hourlyRate);

        this.timeParked.remove(driver.getId());
        return this.parkingGarage.removeVehicle(driver.getVehicle());
    }
}
