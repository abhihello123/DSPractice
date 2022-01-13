package test;

/**
 * Created by Abhishek on 26-Feb-20.
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse obj = new StringReverse();
        System.out.println(obj.reverse("Hello"));
    }

    private String reverse(String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        char[] outputArr = new char[inputArr.length];
        int j =0;
        for (int i=inputArr.length -1; i>=0; i--) {
            outputArr[j++] = inputArr[i];
        }
        return new String(outputArr);

    }


}
