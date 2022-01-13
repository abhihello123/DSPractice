package numbers;

/**
 * Created by Abhishek on 17-Nov-19.
 */
public class UnsortedArrayArrangePtiveNtive {

    public static void main(String[] args) {
        int[] arr = new int[] {-12,11,-13,-5,6,-7,5,-3,-6};
        //int[] arr = new int[] {-1,-2,10,5,6,-5,7,-8};
        int replacePostiveEle;
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] < 0)
                continue;
            replacePostiveEle = arr[i];
            for (int j=i+1; j<arr.length-1; j++) {
                if (arr[j]<0) {
                    arr[j-1] = arr[j];
                    continue;
                }
                    arr[j-1] = replacePostiveEle;
                    i=j-1;
            }
        }
        for (int i=0; i< arr.length; i++)
            System.out.print(arr[i]+" ");
    }

}
