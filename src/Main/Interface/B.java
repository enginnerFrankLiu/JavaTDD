package Main.Interface;

public interface B extends A {
    default void all(){
        System.out.println("b->all");
    }
}
