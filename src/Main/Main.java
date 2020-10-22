package Main;


import Main.Service.TestInfo;
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

    public static void main(String [] args){

        TestInfo t =new TestInfo();

        t.testDuplicate();

        System.out.println("application end.");


        //partitionByInfo();
        //InfoN();
        //InfoM();
       //TestD();
       //testA();
       //TestB();
    }

}
