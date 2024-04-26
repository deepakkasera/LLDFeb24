package org.example.parkinglot.strategies;

import org.example.parkinglot.models.ParkingLot;
import org.example.parkinglot.models.ParkingSpot;
import org.example.parkinglot.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
