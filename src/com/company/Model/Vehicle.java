package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
  private VehicleType type;
  private Integer numberOfWheels;
  private Float enginePower;
  private final List<String> accessories = new ArrayList<>();

  public Vehicle() {
  }

  public Vehicle(VehicleType type, Integer numberOfWheels, Float enginePower) {
    this.type = type;
    this.numberOfWheels = numberOfWheels;
    this.enginePower = enginePower;
  }

  public Vehicle clone(Vehicle vehicle) {
    Vehicle clone = new Vehicle();
    clone.setEnginePower(vehicle.getEnginePower());
    clone.setNumberOfWheels(vehicle.getNumberOfWheels());
    clone.setType(vehicle.getType());
    vehicle.getAccessories().forEach(clone::addAccessory);

    return clone;
  }

  public VehicleType getType() {
    return type;
  }

  public void setType(VehicleType type) {
    this.type = type;
  }

  public Integer getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(Integer numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  public Float getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(Float enginePower) {
    this.enginePower = enginePower;
  }

  public void addAccessory(String accessory) {
    this.accessories.add(accessory);
  }

  public List<String> getAccessories() {
    return accessories;
  }
}
