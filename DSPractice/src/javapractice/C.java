package javapractice;

/**
 * Created by Abhishek on 19-Aug-19.
 */
public interface C extends A {
    void method3();
    default void method1(){
        System.out.println("This is default C");
    }
}
