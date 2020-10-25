package Main.Service;

import Main.Implement.C;
import Main.Implement.Generic;
import Main.Interface.IAction;
import Main.Model.ClassB;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Console {


    public void testInterface() {

        IAction action = new IAction() {
            @Override
            public void doAction() {
                System.out.println("you want to more stronger.the best way to acheive it is practice more.");
            }
        };
        // you can write implement here directly, because of anay class.
        action.doAction();

    }

    public void testA() {

        ClassB b = new ClassB();
        b.bar();
    }

    public void testC() {

        C c = new C();
        c.all();
    }

    /**
     *
     */
    public void coCollection() {
        Stream<String> streamString = Stream.of("1", "2", "3");
        List<String> listOfString = streamString.collect(Collectors.toCollection(LinkedList::new));
        System.out.println(listOfString);

    }

    /**
     * you spend time to convert every element fo list string.
     */
    public void convertInfo() {
        String ids = "1,2,3,4,5,6,7";
        List<Integer> uerIds = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(uerIds);
    }

    /**
     *
     */
    public void toSet() {
        List<String> list = Arrays.asList("a", "b", "a");
        List<String> noDuplicateList = list
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(noDuplicateList);
    }

    private void printInfo(Generic<Number> obj){
        System.out.println(obj.getKey());
    }

    private void printInfoQ(Generic<?> obj){
        System.out.println(obj.getKey());
    }

    /**
     * test generic class
     *
     *
     */
    public void testGeneric(){

        Generic<Integer> intS=new Generic<>(2222);
        Generic<Number>  number=new Generic<>(3333);
        printInfo(number);
      //  printInfo(intS);
        System.out.println("use ? fro generic");
        printInfoQ(intS);
        printInfoQ(number);

    }
}
