package company.Model;

import com.company.Model.Vehicle;
import com.company.Model.VehicleType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VehicleTest {

  @Order(3)
  @Test
  @DisplayName("Tests clone method")
  void testClone() {
    Vehicle mockVehicle = new Vehicle(VehicleType.LAND_VEHICLE, 2, 2f);
    mockVehicle.addAccessory("mockAccessory1");
    mockVehicle.addAccessory("mockAccessory2");

    Vehicle result = mockVehicle.clone(mockVehicle);
    assertNotEquals(mockVehicle, result);
    assertDeepEquals(mockVehicle, result);
  }

  @Order(4)
  @Test
  @DisplayName("Tests accessories list")
  void accessoriesList() {
    Vehicle mockVehicle = new Vehicle();

    assertEquals(0, mockVehicle.getAccessories().size());

    mockVehicle.addAccessory("test1");

    assertEquals(1, mockVehicle.getAccessories().size());
    assertEquals("test1", mockVehicle.getAccessories().get(0));

    mockVehicle.addAccessory("test2");

    assertEquals(2, mockVehicle.getAccessories().size());
    assertEquals("test2", mockVehicle.getAccessories().get(1));

  }

  @Order(0)
  @ParameterizedTest
  @EnumSource(VehicleType.class)
  @DisplayName("Tests type getter/setter")
  void getSetType(VehicleType type) {
    Vehicle mockVehicle = new Vehicle();
    mockVehicle.setType(type);

    assertEquals(type, mockVehicle.getType());
  }

  @Order(1)
  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
  @DisplayName("Tests numberOfWheels getter/setter")
  void getSetNumberOfWheels(int numberOfWheels) {
    Vehicle mockVehicle = new Vehicle();
    mockVehicle.setNumberOfWheels(numberOfWheels);

    assertEquals(numberOfWheels, mockVehicle.getNumberOfWheels());
  }

  @Order(2)
  @ParameterizedTest
  @ValueSource(floats = {1f, 3f, 5f, 15f, Float.MAX_VALUE})
  @DisplayName("Tests enginePower getter/setter")
  void getSetEnginePower(float enginePower) {
    Vehicle mockVehicle = new Vehicle();
    mockVehicle.setEnginePower(enginePower);

    assertEquals(enginePower, mockVehicle.getEnginePower());
  }

  private void assertDeepEquals(Vehicle mockVehicle, Vehicle result) {
    assertEquals(mockVehicle.getType(), result.getType());
    assertEquals(mockVehicle.getEnginePower(), result.getEnginePower());
    assertEquals(mockVehicle.getNumberOfWheels(), result.getNumberOfWheels());
    assertEquals(mockVehicle.getAccessories().size(), result.getAccessories().size());
    for (int i = 0; i < mockVehicle.getAccessories().size(); i++) {
      assertEquals(mockVehicle.getAccessories().get(i), result.getAccessories().get(i));
    }
  }
}