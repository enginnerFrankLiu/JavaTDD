package Main.Service;

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

}
