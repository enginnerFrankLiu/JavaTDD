package Main.Service;

import Main.Implement.Apple;
import Main.Implement.Fruit;
import Main.Implement.GreenApple;
import Main.Model.Node;
import org.mockito.internal.matchers.Null;

import java.util.*;

public class Client {

    private PersonService personService;

    public Client() {
    }

    public Client(PersonService personService) {
        this.personService = personService;
    }

    public void consume() {

        //消费该方法的对象，只能被动的消费内部的方法；无法将内部的实现，保罗在外部；
        //让消费方法的自己定义具体的实现；
        personService.loveJava(1);

    }

    public  void doSomething(){
        List<Apple> listOfApple= Arrays.asList(
                new Apple(),
                new Apple(),
                new Apple()
        );

        List<Apple> listOfGreenApple=Arrays.asList(
                new GreenApple(),
                new GreenApple(),
                new GreenApple()
        );

        displayFruit(listOfApple);
        displayFruit(listOfGreenApple);
    }


    /**
     * only can loop/iterator/display list;
     * can not modify/add/ the list;
     * that is way to limited generic.
     *
     * @param apples
     */
    public void displayFruit(List<? extends Apple> apples) {

        //we can call any of method apple own(that means sub class will own)
        //when we pass some object into list, the compiler will make sure, all object is extend apple.

        for (Apple apple : apples) {

            System.out.println(apple.hashCode());
        }

        // but why we cannot add some elements into list.
        // because even we hold the reference of apple,
        // we cannot make sure passed list is list<apple> or list<greenApple>
        // if we pass list<apple> it work.
        // but if caller pass list<greenApple>, there is some risk of we put new apple into greenApple
        // that is illegal.

//         apples.add(new Apple());
//         apples.add(new Fruit());
//         apples.add(new GreenApple());

        //id you add some apple, green apple ( or some class extend apple)
        // ,
    }


    public void loveLife(){

        List<Fruit> fruits=Arrays.asList(

                new Fruit(),
                new Fruit(),
                new Fruit()
        );

        List<Apple> apples=Arrays.asList(
                new Apple(),
                new Apple(),
                new Apple()
        );

        collectFruits(fruits);
        collectFruits(apples);
    }


    /**
     * passed object that super that apple
     *
     *
     * @param applesSupers
     */
    public void collectFruits(List<? super Apple> applesSupers){

        //we can not iterator this list, apple is base class,
        //passed list all them is super class of apple
//        for (Apple apple: applesSupers) {
//
        //if we call apple.showAppleInfo()
        // but apple supper class may not have this method, application will throw error.

//        }

        for (Object applesSuper : applesSupers) {

        }

      //  applesSupers.add(new Fruit());
        applesSupers.add(new Apple());
        applesSupers.add(new GreenApple());


    }

    public void doMs(){

        Object [] objs=new Integer[100];
        objs[0]="love";
        objs[1]=100;
        objs[2]=new Apple();

    }

    public void LoveCode(){

        Node nodeX=new Node(1,"A", new ArrayList<>());

        Node nodeY=new Node(1,"A",new ArrayList<>());

        boolean result=nodeX.equals(nodeY);

        System.out.println(result);

        System.out.println("put node into map.");

        Map<Node,String > map=new HashMap<>();
        map.put(nodeX,"0");
        map.put(nodeY,"1");

        System.out.println(map);

    }


}
