package ParkingLot.models;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private List<VehicleType> vehicleType;
    private ParkingLotStatus parkingLotStatus;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<VehicleType> vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public FeesCalculatorStrategyType getFeesCalculatorStrategyType() {
        return feesCalculatorStrategyType;
    }

    public void setFeesCalculatorStrategyType(FeesCalculatorStrategyType feesCalculatorStrategyType) {
        this.feesCalculatorStrategyType = feesCalculatorStrategyType;
    }
}
