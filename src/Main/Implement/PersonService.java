package Main.Implement;

import Main.Interface.IPersonService;
import Main.Model.Car;
import Main.Model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PersonService implements IPersonService {

    @Override
    public void buyCar(Person person, List<Car> optionalCars) {
        if(person==null || person.getAccount()<0){
            return;
        }
        double mostCheaperCarPrice=optionalCars
                .stream()
                .map(x->x.getSalePrice())
                .min(Comparator.comparing(Function.identity()))
                .orElse(0.0);

        if(isAbilityToBuy(person,mostCheaperCarPrice)){
            Car car=chooseCar(person,optionalCars);
        }else{
            double borrowedMoney=borrowMoney(person.getAroundPerson());
            person.setAccount(person.getAccount()+borrowedMoney);
            if(isAbilityToBuy(person,mostCheaperCarPrice)){
                Car car=chooseCar(person,optionalCars);
            }
        }
    }

    @Override
    public Car chooseCar(Person person, List<Car> optionalCars) {
        return null;
    }

    @Override
    public boolean isAbilityToBuy(Person person, double lowPrice) {
        if(person==null)
            return false;
        double accountMoney=person.getAccount();
        if(accountMoney>=lowPrice){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double borrowMoney(List<Person> persons) {
        return 0;
    }

}
