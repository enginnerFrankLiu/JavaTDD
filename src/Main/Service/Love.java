package Main.Service;

import Main.Model.Node;

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

    public void selectMany(){

        List<Integer> PrimeNumbers = Arrays.asList(1, 2, 3);

        List<Integer> OddNumbers = Arrays.asList(4,5,6);

        List<Integer> EvenNumbers = Arrays.asList(7,8,9);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

     List<Integer> result= listOfListofInts
                .stream()
                .flatMap(x->x.stream())
                .collect(Collectors.toList());

        System.out.println(result);
    }

    public void selectManyA(){

        Node node=new Node();
        node.setId(1);
        node.setName("A");

        Node node1=new Node();
        node1.setId(2);
        node1.setName("B");

        Node node2=new Node();
        node2.setId(3);
        node2.setName("C");


        List<Node> nodes=new ArrayList<>();
        nodes.add(node);
        nodes.add(node1);
        nodes.add(node2);

        Node rootNdoe=new Node(0,"root_name",nodes);

        List<Node> allNodes=new ArrayList<>();
        allNodes.add(rootNdoe);
        allNodes.add(rootNdoe);





        List<Node> dd =allNodes
                .stream()
                .flatMap(x->x.getNodes().stream())
                .collect(Collectors.toList());

        System.out.println(dd);


        String allNames=allNodes
                .stream()
                .flatMap(x->x.getNodes().stream())
                .map(x->x.getName())
                .collect(Collectors.joining(","));

        System.out.println(allNames);
    }

}
