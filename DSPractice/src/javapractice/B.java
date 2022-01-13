package javapractice;

/**
 * Created by Abhishek on 19-Aug-19.
 */
public interface B extends A {
    void method2();
    default void method1() { System.out.println("hello from B"); }
}
