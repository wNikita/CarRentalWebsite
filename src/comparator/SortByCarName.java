package comparator;

import com.narola.carrental.model.CarDetails;

import java.util.Comparator;

public class SortByCarName implements Comparator<CarDetails> {
    @Override
    public int compare(CarDetails car1, CarDetails car2) {
        return car2.getName().compareTo(car1.getName());
    }

}

