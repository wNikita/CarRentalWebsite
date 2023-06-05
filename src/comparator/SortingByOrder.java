package comparator;

import com.narola.carrental.model.CarDetails;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingByOrder {

    public void ascendingName(List<CarDetails> carDetails) {
        Collections.sort(carDetails, Comparator.comparing(CarDetails::getName));
    }

    public void descName(List<CarDetails> carDetails) {
        {
            Collections.sort(carDetails, new SortByCarName());
        }
    }

    public void highestPrize(List<CarDetails> carDetails) {
        Collections.sort(carDetails, Comparator.comparing(CarDetails::getChargePerDay));
    }

    public void lowestPrize(List<CarDetails> carDetails) {
        Collections.sort(carDetails, new SortByCarRentalRate());
    }

    public void fuelTypePetrol(List<CarDetails> carDetails) {

        Collections.sort(carDetails, new SortByFuelType());
    }

    public void fuelTypeDiesel(List<CarDetails> carDetails) {
        Collections.sort(carDetails, Comparator.comparing(CarDetails::getFuelType));
    }
}
