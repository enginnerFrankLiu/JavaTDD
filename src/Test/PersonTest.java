package Test;

import Main.Model.Car;
import org.junit.Test;

/**
 *
 * TDD
 * user story:
 * use simple empty method to describe user story.
 * user story:
 * person want to buy car
 * if have enough money,buy it by self.
 * if don't have enough money,try to borrow money from around person,then buy car.
 *
 * can understand it from different perspective.
 *
 * 1.prepare money.
 * 2.choice car.
 *
 * user story.
 *
 * code implement.
 *
 * function split -> simple,single responsibility function.UT
 *
 * this is main idea to buy car service;
 *
 *
 *
 * buyCar (person person,list<car> optionalCars)
 */
public class PersonTest {

    @Test
    public void helloTest() {

    }

    /**
     * when
     *  1.person don't have enough money to buy car.
     *  excepted result
     *  false (that means:cannot buy any car)
     */
    public void isAbilityToBuy_When_PersonDoNotHaveEnoughMoney_ThenNull() {
      boolean exceptedResult=false;


    }

    /**
     * when person can not buy some car by self's account money.
     * try to load some money from other way.
     *  excepted result
     */
    public void isAbilityToBuy_When_PersonAroundDoNotHaveEnoughMoney_ThenNull() {
        boolean exceptedResult=false;


    }

    /**
     * when
     * 1.your money is enough.
     * 2.you want to get respect from normal people.
     * excepted result
     * Ben-c class
     */
    public void chooseCar_When_YouWantToRespect_BENC() {

        Car exceptedCarBenC = new Car(0, "ben-c", 30, "");


    }

    /**
     * when
     * 1.your money is enough.
     * 2.you want to get more performance in operation.
     * excepted result
     * BMW-3
     */
    public void chooseCar_When_YouWantTopPerformance_ThenBMW() {

        Car exceptedCarBMW = new Car(0, "bmw-3", 30, "");

    }

    /**
     * when
     * 1.money is enough
     * 2.you want to get cost effective.
     * excepted result
     * audi-Q3
     */
    public void chooseCar_When_YouWantToCostEffective_ThenAuto() {
        Car exceptedCarAudiQ3 = new Car(0, "audi-q3", 30, "");


    }
}
