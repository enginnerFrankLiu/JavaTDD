package Main;


import Main.Model.User;
import Main.Service.Console;
import Main.Service.Love;
import Main.Service.TestInfo;
import java.util.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 用户故事分析
 * as a normal person,i want to buy a car
 *
 * 1.optional car  benz-c bmw-3 auto-q3
 *
 * 2.person money *
 *
 * 3.
 *
 * we will try use new way to manage our package(jar).
 */
public class Main {

    static void testA(){
        TestInfo t=new TestInfo();
        t.testNewLambdaWayToCreate();
    }

    static void TestB(){
        TestInfo t =new TestInfo();
        t.testNewLambdaWayToCreate();
    }

    /**
     *
     */
    static void TestC(){
        TestInfo t =new TestInfo();
        t.Info();
    }

    /**
     *
     */
    static void TestD(){
        TestInfo t =new TestInfo();
        t.InfoA();
    }

    static void InfoM(){
        TestInfo t =new TestInfo();
        t.InfoM();
    }
    static void InfoN(){
        TestInfo t =new TestInfo();
        t.InfoN();
    }
    static void partitionByInfo(){
        TestInfo t =new TestInfo();
        t.partitionByInfo();
    }

     public static void run(){
         Love love=new Love();
         love.getMaxA();
         love.getMaxB();
         love.getMaxC();
         love.getMaxD();
         love.getSum();
     }

     public static void run1(){
         Love love=new Love();
         love.printInfo();
     }

     public static void fuckTheLife(){
         System.out.println("Fuck The Life. ");
     }

     public static void reduceInfo(){
         List<Integer> list= Arrays.asList(1,1,1,1,1);
        Integer sum= list.stream()
                 .collect(Collectors.reducing(100,(i,j)->i+j));

        System.out.println(sum);
     }

    /**
     * when list including some null value.
     * in case of nullPointer exception.
     * we should determine whether the value is empty.
     */
    public static void mapInfo(){

        List<String> list=Arrays.asList("a","b",null,"c","d");
        List<String> upperList=list
                .stream()
                .map(x->{
                    if(x==null){
                        return "";
                    }else{
                      return x.toUpperCase();
                    }
                })
                .collect(Collectors.toList());

        System.out.println(upperList);
     }

    /**
     * the right way to use tool/method,but original data is wrong.
     * this is very bad thing.
     */
    public static void changeLife(){

         List<String> listOfString=Arrays.asList("a","bbb","c","d");

         String maxLengthString=listOfString
                 .stream()
                 .collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
                  .orElse("");


         System.out.println(maxLengthString);

         List<Integer> listOfInt=Arrays.asList(1,1,8,1,1,100);

         Integer max=listOfInt
                 .stream()
                 .collect(Collectors.maxBy(Integer::compare))
                 .orElse(0);

         System.out.println(max);

         Integer maxVal= listOfInt
                 .stream()
                 .collect(Collectors.maxBy(Comparator.comparingInt(Integer::intValue)))
                 .orElse(0);

         System.out.println(maxVal);

         Integer number=100;
         System.out.println(number.intValue());
         System.out.println("there still fucking stupid way to do this.");

        long count= listOfInt.stream().count();
        long size=listOfInt.size();
        long countV2=listOfInt
                .stream()
                .collect(Collectors.counting());

        System.out.println("fuck the way....");
        System.out.println(count);
        System.out.println(size);
        System.out.println(countV2);

        System.out.println("fuck the way....");

        List<User> users=Arrays.asList(
                new User(1,"jack",18,null),
                new User(1,"tom",18,null),
                new User(1,"frank",28,null)
        );

         System.out.println("-----------------------------------------------------");
         User  maxAgeUser=users
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)))
                .orElse(new User(-1,"unkonw_User",-1,null));
       System.out.println(maxAgeUser.getName());
       System.out.println(maxAgeUser.getAge());

     }

    public static void getMaxLife(){

         List<User> users=Arrays.asList(
                 new User(1,"jack",18,null),
                 new User(1,"tom",18,null),
                 new User(1,"frank",28,null)
         );

         int maxVal=getMax(users);
         System.out.println(maxVal);
     }

    /**
     * 1.order by desc -> first element.
     * 2.for loop look up
     * @param list
     * @return
     */
     public static Integer getMax(List<User> list){
         Integer temp=list.get(0).getAge();
         for (int index=1;index<list.size();index++){
             Integer next=list.get(index).getAge();
             if(next>temp){
                 temp=next;
             }
         }
         return temp;
     }

     public void testInfoBB(){

         Love love=new Love();
         int userId=100;
         System.out.println(love.getUserAddress(userId));
         System.out.println(love.getUserAddressV2(userId));
         System.out.println(love.getUserAddressV3(userId));

         System.out.println("when no right user existed in bd according user id ");
         userId=-999;

         System.out.println(love.getUserAddress(userId));
         System.out.println(love.getUserAddressV2(userId));
         System.out.println(love.getUserAddressV3(userId));

     }

     static void tempA(){

         Love love=new Love();
//        love.compareTwoOptional();
//        System.out.println("over");

         // love.ms();
         love.testTryParseInt();
     }


    /**
     *
     * @param args
     */
    public static void main(String [] args){

        Console console=new Console();
        console.testA();

    }

}
