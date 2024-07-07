package a_ObjectOriented.c_ParkingLot;

import java.util.HashMap;
import java.util.Map;

class ParkingFloor {
    private int[] spots;
    private Map<Vehicle, int[]> vehicleMap;

    public ParkingFloor(int spotCount) {
        this.spots = new int[spotCount];
        this.vehicleMap = new HashMap<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int size = vehicle.getSpotSize();
        int l = 0, r = 0;
        while (r < this.spots.length) {
            if (this.spots[r] != 0) {
                l = r + 1;
            }
            if (r - l + 1 == size) {
                // we found enough spots, park the vehicle
                for (int k = l; k <= r; k++) {
                    this.spots[k] = 1;
                }
                this.vehicleMap.put(vehicle, new int[]{l, r});
                return true;
            }
            r++;
        }
        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        int[] startEnd = this.vehicleMap.get(vehicle);
        int start = startEnd[0], end = startEnd[1];
        for (int i = start; i <= end; i++) {
            this.spots[i] = 0;
        }
        this.vehicleMap.remove(vehicle);
    }

    public int[] getParkingSpots() {
        return this.spots;
    }

    public int[] getVehicleSpots(Vehicle vehicle) {
        return this.vehicleMap.get(vehicle);
    }
}
