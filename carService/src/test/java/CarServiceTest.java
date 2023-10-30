import com.carServices.carService.carRepository.CarRepository;
import com.carServices.carService.entity.Car;
import com.carServices.carService.service.CarService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    public void testGetAllCars() {
        List<Car> cars = Arrays.asList(new Car(1L,"Toyota"),(new Car(2L,"Honda"));
        Mockito.when(carRepository.findAll()).thenReturn(cars);

        List<Car> result = carService.getAllCars();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetCarById() {

        Long carId = 1L;
        Car car = new Car(carId,"Toyota");

        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.of(car));

        Car result = carService.getCarById(carId);

        assertEquals(carId, result.getId());
        assertEquals("Toyota",result.getName());
    }

    @Test
    public void TestCreateCar()
    {
        Car car = new Car(1L, "Toyota");
        Mockito.when(carRepository.save(car)).thenReturn(car);
        Car result = carService.createCar(car);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Toyota", result.getName());
    }

    @Test
    public void testDeleteCar() {
        Long carId = 1L;
        carService.deleteCar(carId);
        Mockito.verify(carRepository).deleteById(carId);
    }

}
