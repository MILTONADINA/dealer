package dealerDAO;

import dealerPD.Car;
import dealerPD.Dealer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarDAOTest {

    @BeforeAll
    public static void setUpClass() {
        emDAO.initEM();
    }

    @AfterAll
    public static void tearDownClass() {
        emDAO.close();
    }

    @Test
    public void testAddAndFindCar() {
        Dealer dealer = new Dealer("Test Dealer", "123 Main St", "Test City", "NY", "10001");
        DealerDAO.addDealer(dealer);

        Car car = new Car("SN123", "Toyota", "Camry", "2023", "1/1/2023", "25000.00");
        car.setDealer(dealer);

        CarDAO.addCar(car);

        assertNotNull(car.getCarID());

        Car retrievedCar = CarDAO.findCarById((int) car.getCarID());
        assertNotNull(retrievedCar);
        assertEquals("Toyota", retrievedCar.getMake());
        assertEquals("Camry", retrievedCar.getModel());
        assertEquals(0, new BigDecimal("25000.00").compareTo(retrievedCar.getPrice()));
    }
}
