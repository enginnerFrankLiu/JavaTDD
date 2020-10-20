package Main.Service;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import javax.print.DocFlavor;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

}