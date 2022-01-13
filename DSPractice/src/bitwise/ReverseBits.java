package bitwise;

/**
 * Leetcode 190
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 */
public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        int num = 3;
        int rev = obj.reverseBits(num);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(rev);
        System.out.println(Integer.toBinaryString(rev));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int num) {
        int rev = 0;
        int temp = 1;
        for (int i=1; i<=32; i++) {
            if ((num & temp) == temp) {
                rev |= temp << (32 - i);
            }
            temp <<= 1;
        }
        return rev;
    }



}
