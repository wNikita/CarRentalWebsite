package comparator;

import com.narola.carrental.model.CarDetails;

import java.util.Comparator;

public class SortByFuelType implements Comparator<CarDetails> {
    @Override
    public int compare(CarDetails car1, CarDetails car2) {
        return car2.getFuelType().compareTo(car1.getFuelType());
    }

}
