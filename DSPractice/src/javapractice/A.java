package javapractice;

/**
 * Created by Abhishek on 19-Aug-19.
 */
public interface A {
    default void method1(){
        System.out.println("This is default A");
    }
}
