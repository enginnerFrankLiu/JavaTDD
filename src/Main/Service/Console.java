package Main.Service;

import Main.Interface.IAction;
import Main.Model.ClassB;

public class Console {


    public void testInterface(){

        IAction action=new IAction() {
            @Override
            public void doAction() {
                System.out.println("you want to more stronger.the best way to acheive it is practice more.");
            }
        };
        // you can write implement here directly, because of anay class.
        action.doAction();

    }

    public void testA(){

        ClassB b=new ClassB();
        b.bar();
    }

}
