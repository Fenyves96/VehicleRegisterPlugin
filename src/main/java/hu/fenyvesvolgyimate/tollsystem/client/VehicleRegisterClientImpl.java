package hu.fenyvesvolgyimate.tollsystem.client;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.validation.VehicleValidator;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleReader;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;
import org.json.JSONException;
import org.json.JSONObject;

public class VehicleRegisterClientImpl implements VehicleRegisterClient, VehiclePresenter {
    public void setVehicleReader(VehicleReader vehicleReader) {
        this.vehicleReader = vehicleReader;
    }

    VehicleReader vehicleReader;
    VehicleValidator vehicleValidator = new VehicleValidator();
    VehicleJsonParser vehicleJsonParser = new VehicleJsonParser();

    Vehicle vehicleResult;

    @Override
    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", registrationNumber);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        vehicleReader.getVehicleByRegisterNumber(jsonObject.toString());
        return vehicleResult;
    }

    @Override
    public void displayVehicle(String vehicleJson) {
        vehicleValidator.validateVehicleJsonResponse(vehicleJson);
        vehicleResult = vehicleJsonParser.parseJsonToVehicle(vehicleJson);
    }

    @Override
    public void displayMessage(String s) {
        throw new IllegalStateException();
    }
}
