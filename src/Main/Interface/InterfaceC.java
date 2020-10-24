package Main.Interface;

public interface InterfaceC {
    default void foo(){
        System.out.println("interface c foo");
    }

    default void bar(){
        System.out.println("interface c bar");
    }
}
