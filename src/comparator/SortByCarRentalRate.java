package comparator;

import com.narola.carrental.model.CarDetails;

import java.util.Comparator;

public class SortByCarRentalRate implements Comparator<CarDetails> {
    @Override
    public int compare(CarDetails car1, CarDetails car2) {
        return car2.getChargePerDay() - car1.getChargePerDay();
    }

}

