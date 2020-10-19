package Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class Test4Fun {

//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

    /**
     * mock list
     */
    @Test
    public void testMock(){
        List mockedList = Mockito.mock(ArrayList.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three");
        mockedList.add("four");
        Assert.assertEquals(0,mockedList.size());

    }

    /**
     * spy
     * Spy works just like real instances, it will behave in the same way as a real instance does.
     * (When Mocks are created in Mockito, they are done from the class of a Type, not from the actual instance)
     */
    @Test
    public void testSpy(){
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("one");
        spyList.add("two");
        spyList.add("three");
        spyList.add("four");

        Assert.assertEquals(4,spyList.size());

    }

    /**
     *
     * a Spy is instrumented in a way that all interactions with it can be tracked, like a method call or value initialization.
     * this will be failed.
     * exceptions: Argument(s) are different! Wanted.
     */
    @Test
    public void testSpy1(){
        Map map=Mockito.spy(new HashMap());
        map.put("key","value");
        Mockito.verify(map).put("key","val");
        Assert.assertEquals(1,map.size());
    }

    /**
     *
     * a Spy is instrumented in a way that all interactions with it can be tracked, like a method call or value initialization.
     * this will pass the test -> green.
     */
    @Test
    public void testSpy2(){
        Map map=Mockito.spy(new HashMap());
        map.put("key","value");
        Mockito.verify(map).put("key","value");
        Assert.assertEquals(1,map.size());
    }

    /**
     *
     *Using stubbing, we can override the behavior of a method and modify its return values, just like what we do in Mocks.
     *
     */
    @Test
    public void testStubbingASpy(){
        Map map=Mockito.spy(new HashMap());
        Assert.assertEquals(0,map.size());
        Mockito.doReturn(5).when(map).size();
        Assert.assertEquals(5, map.size());
    }

    /**
     *
     */
    @Test
    public void testMockInfo(){

        List mockedList=Mockito.mock(ArrayList.class);
        mockedList.add("love");
        Mockito.verify(mockedList).add("love");
       Assert.assertEquals(0,mockedList.size());

        Mockito.when(mockedList.size()).thenReturn(10); // stubbing
        Assert.assertEquals(10,mockedList.size());

    }

    /**
     * when
     *  register user successful (save data into database)
     * then
     *  send email notification to end user.
     */
    @Test
    public void testSendEmail(){


    }

    private void testInfoSum(){
      /*  @Captor annotation to create an ArgumentCaptor instance.
          In the following example

           1.the most common test is to assert some result be equal to some excepted result.
           2.the second common test is to verify some behavior: such as  xxValidator will throw what kind of exception will throw.
           3.there is other thing,we should verify: whether some kind method is called when some condition are met. such as send email to end user.
           4.


           Test the common case of everything you can.

           Test the edge cases of a few unusually complex code that you think will probably have errors.

           Whenever you find a bug, write a test case to cover it before fixing it.

           It forces you to plan before you code

           user story -> user case -> write abstract test method/description(not implement it, just design test case ,function,method-> make sure it is clean,simple,single responsibility,)

           -> try to write testable code -> work-> test pass -> code refactor -> review and check it by self -> code review -> throw it to qa -> no bug ->  Done.


            test ssh

       */

    }
}
