package Main.Model;

import Main.Interface.InterfaceB;
import Main.Interface.InterfaceC;

public class ClassB implements InterfaceB, InterfaceC {
    @Override
    public void bar(){
//        InterfaceB.super.bar();
//        InterfaceC.super.bar();
        System.out.println("class b bar.");
    }

}
