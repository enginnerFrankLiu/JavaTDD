package Main.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.function map
 * 2.predict any match.
 *
 * 3.supplier
 * 4.consumer
 *
 */
public class TestInfo {

    /**
     * old way(anonymity) to override. new implement.
     */
    public void testOriginalWayToCreate(){

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("this new thread console write info.");
            }
        });
        thread.start();
        System.out.println("this is main thread console write info.");

    }

    /**
     * lambda way
     */
    public void testNewLambdaWayToCreate(){
        Thread thread=new Thread(()->System.out.println("this lambda way create new thread."));
        thread.start();
        System.out.println("this is main thread console write info.");
    }

    public void Info(){
        List<String> list=new ArrayList<String>(){
            {
                add("A");
                add("B");
                add("C");
            }
        };
       String result=list
                .stream()
                .collect(Collectors.joining(","));

               System.out.println(result);
    }

    /**
     * 方法先执行了一个归纳操作，然后再对归纳的结果进行 Function 函数处理输出一个新的结果
     * 总体来说，效果还是可以的；
     */
    public void InfoA(){
        List<String> list=new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
            }
        };

        String result=list.stream().collect(Collectors.collectingAndThen(
                Collectors.joining(","),
                String::toUpperCase
        ));

        System.out.println(result);
    }

    /**
     * Info
     * this just split list into different list according to string length;
     * but it didn't remove duplicate value.
     * the first is count;
     * the second is values;
     */
    public void InfoM(){

        List<String> list=new ArrayList<String>(){
            {
                add("a");
                add("a");
                add("bb");
                add("cc");
                add("dd");
            }
        };

        System.out.println("group by string length");

        Map<Integer,List<String>> map=list
                .stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(map);

    }

    /**
     * in this way,we still can convert it sets;(that will remove duplicate values)
     * this way,wo can remove duplicate value;
     */
    public void InfoN(){

        List<String> list=new ArrayList<String>(){
            {
                add("bb");
                add("bb");
                add("bb");
                add("a");
                add("a");
                add("a");
                add("CCC");

            }
        };

        System.out.println("group by string length and covert it into set,in order to remove duplicate code.");

        Map<Integer, Set<String>> map=list
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));

        map.forEach((index,sets)->{
            System.out.println(index);
            System.out.println(sets);
        });

    }

    public void partitionByInfo(){

        Stream<Integer> stream= Stream.of(1,2,3,4,5,6,7,8);

        Map<Boolean,List<Integer>> map= stream.collect(
          Collectors.partitioningBy(num->num>3)
        );

        //split it into two part
        // one part meet requirments -true
        //other part not, false.

        System.out.println(map);

    }

    public void count(){

        List<Integer> list= Arrays.asList(16,15,14,13,12,11);

//        Integer max=list
//                .stream()
//                .collect(Collectors.maxBy(Integer::max))
//                .orElse(0);
//
//        System.out.println("max value of list->"+max);
//
//        Integer min=list
//                .stream()
//                .collect(Collectors.minBy(Integer::min))
//                .orElse(0);

//        System.out.println("min value of list ->"+min);

//
//        Integer dw=list
//                .stream()
//                .collect(Collectors.minBy((a,b)->a-b))
//                .orElse(0);
//
//        System.out.println("min value of list ->"+dw);
//
//        Integer dwc=list
//                .stream()
//                .collect(Collectors.minBy((a,b)->b-a))
//                .orElse(0);
//
//        System.out.println("min value of list ->"+dwc);

       int max= Collections.max(list);
       int min=Collections.min(list);

       System.out.println("the max value of list is "+max);
       System.out.println("the min value of list is "+min);

    }
    public void maxInfo(){
        int a=10;
        int b=20;
       int result= Math.max(a,b);
       System.out.println(result);
    }

    /**
     * the order of list.
     */
    public void mappingInfo() {
//        List<Integer> list= Arrays.asList(36,25,14,13,92,11);
//        Integer max = list
//                .stream()
//                .collect(Collectors.maxBy(Comparator
//                        .reverseOrder()))
//                .orElse(0);
//
//        System.out.println(max);
//
//        List<Integer> list1= Arrays.asList(16,15,14,13,12,11);
//
//        List<Integer> list2= Arrays.asList(11,12,13,14,15,16);

        /**
         * this seem to no relative to order of list.
         */
//        Integer val0=list1
//                .stream()
//                .collect(Collectors.maxBy((a,b)->a-b))
//                .get();
//
//        Integer val1=list2
//                .stream()
//                .collect(Collectors.maxBy((a,b)->a-b))
//                .get();
//
//        System.out.println(val0);
//        System.out.println(val1);

        List<String> fruits = Arrays.asList("orange", "pear", "apple", "grapes");
        Optional<String> minElement = fruits.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minElement);

    }

    /**
     *
     */
    public void testMinMaxBy(){

        List<Integer> list= Arrays.asList(13,15,14,113,12,11);

        Integer val=list
                .stream()
                .collect(Collectors.maxBy(Integer::max))
                .orElse(-1);
        System.out.println(val);
        System.out.println(list);


    }

    public void testMinMax(){
//        // Get Min or Max Number
//        Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
//                .max(Comparator.comparing(Integer::valueOf))
//                .get();
//
//        Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
//                .min(Comparator.comparing(Integer::valueOf))
//                .get();
//
//        System.out.println("maxNumber = " + maxNumber);
//        System.out.println("minNumber = " + minNumber);
    }

    public void testDuplicate(){

        Set<String> sets=new HashSet<>() ;
        sets.add("a");
        sets.add("A");
        System.out.println(sets);
    }

}
