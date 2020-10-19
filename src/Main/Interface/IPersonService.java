package Main.Interface;

import Main.Model.Car;
import Main.Model.Person;

import java.util.List;

public interface IPersonService {

    /**
     * choose which one car is suitable.
     * @param person
     * @param optionalCars
     * @return
     */
   Car chooseCar(Person person, List<Car> optionalCars);
    /**
     *
     * @param person
     * person who want to buy some cars.
     * @param optionalCars
     * some optional cars
     * @return
     */
    void buyCar(Person person, List<Car> optionalCars);

    /**
     * some person whether it have ability to buy some car.
     * @return
     */
    boolean isAbilityToBuy(Person person,double lowPrice);

    /**
     * borrow money from other people.
     * @param persons
     * @return
     */
    double borrowMoney(List<Person> persons);
}
