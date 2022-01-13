package numbers;

/**
 * Created by Abhishek on 16-Nov-19.
 */
public class PrimeFactors {

    public static void main(String[] args) {
        findPrime(150);
    }
//does not work
//    private static void findPrimeFactor(int n) {
//        if (n==1) {
//            System.out.print(n);
//            return;
//        }
//
//        boolean factorFound = false;
//        for (int i=2; i<=Math.sqrt(n);i++) {
//            while (n%i==0) {
//                factorFound = true;
//                System.out.print(i+" ");
//                n=n/i;
//            }
//        }
//        if(!factorFound)
//            System.out.print(n);
//
//    }

    private static void findPrime(int n) {
        if (n==1||n==2||n==3) {
            System.out.print(n);
            return;
        }
        boolean isPrime = true;
        if (n%2==0) isPrime = false;
        double end = Math.sqrt(n);
        for (int i=3; i<= end;i+=2) {
            if (n%i==0)
                isPrime = false;
        }

        if (isPrime) {
            System.out.print(n);
            return;
        }
        while (n%2==0) {
            System.out.print("2 ");
            n /= 2;
        }
        for (int i=3; i<=end;i+=2) {
            while (n%i==0) {
                System.out.print(i+" ");
                n /= i;
            }
        }


    }

}
