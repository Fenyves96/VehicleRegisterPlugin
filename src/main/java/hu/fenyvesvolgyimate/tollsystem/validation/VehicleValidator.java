package hu.fenyvesvolgyimate.tollsystem.validation;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.exception.InvalidVehicleResponse;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;

public class VehicleValidator {
    private VehicleJsonParser parser = new VehicleJsonParser();

    public void validateVehicleJsonResponse(String jsonResponse){
        Vehicle vehicle =  parser.parseJsonToVehicle(jsonResponse);
        if(
                vehicle.getVehicleCategory() == null ||
                        vehicle.getMake() == null ||
                        vehicle.getRegistrationNumber() == null ||
                        vehicle.getMaxTransportablePassengers() == 0){
            throw new InvalidVehicleResponse();
        }
    }
}
