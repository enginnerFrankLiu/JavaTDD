package Main.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Love {

    public void getMaxA() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0);

        System.out.println(max);
    }

    public void getMaxB() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = Collections.max(listOfIntegers);
        System.out.println(max);
    }

    /**
     *
     */
    public void getMaxC() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers
                .stream()
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max);

    }

    public void getMaxD() {

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers
                .stream()
                .collect(Collectors.maxBy(Integer::compare))
                .orElse(0);
        System.out.println(max);
    }

    /**
     * 先这样写这吧；
     */
    public void getSum(){

        List<Integer> listOfIntegers = Arrays.asList(1, 1, 1, 1,1);
        Long sum=listOfIntegers
                .stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getSum();

         System.out.println(sum);

    }

    public void printInfo(){
        Class<?> class1=new ArrayList<String>().getClass();
        Class<?> class2=new ArrayList<Integer>().getClass();
        System.out.println(class1);		//class java.util.ArrayList
        System.out.println(class2);		//class java.util.ArrayList
        System.out.println(class1.equals(class2));	//true

    }

}
