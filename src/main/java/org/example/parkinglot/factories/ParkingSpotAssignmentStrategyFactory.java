package org.example.parkinglot.factories;

import org.example.parkinglot.models.ParkingSpotStrategyType;
import org.example.parkinglot.strategies.NearestSpotAssignmentStrategy;
import org.example.parkinglot.strategies.ParkingSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {
    public static ParkingSpotAssignmentStrategy getParkingLotStrategy(ParkingSpotStrategyType
                                                                              parkingSpotStrategyType) {
        if (parkingSpotStrategyType.equals(ParkingSpotStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        }
        return null;
    }
}
