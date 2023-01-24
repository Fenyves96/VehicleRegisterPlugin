package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.dto.VignettesRequestDTO;
import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;

public class VehicleJsonParser {
    private JsonParser jsonParser = new JsonParser();

    public VignettesRequestDTO parseRegistrationNumberFromJson(String json){
        VignettesRequestDTO requestDTO = new VignettesRequestDTO();
        requestDTO.registrationNumber = jsonParser.parseStringValueFromJsonStringByKey(json ,"registrationNumber");
        return requestDTO;
    }

    public Vehicle parseJsonToVehicle(String vehicleJson) {
        Vehicle vehicle = new Vehicle();
        String registrationNumber = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "registrationNumber");
        String make = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "make");
        String vehicleCategory = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "type");
        int maxTransportablePassengers  = jsonParser.parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");

        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setCategory(vehicleCategory);
        vehicle.setMaxTransportablePassengers(maxTransportablePassengers);
        return vehicle;
    }
}
