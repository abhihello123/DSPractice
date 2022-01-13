package threading;

public class OddEvenThreads {

    static int counter = 1;

    public static void main(String[] args) {
        int n=10;
        Object lock = new Object();
        Thread tOdd = new Thread(new PrintOdd(n, lock));
        Thread tEven = new Thread(new PrintEven(n, lock));
        tOdd.start();
        tEven.start();
    }

    public static class PrintOdd implements Runnable
    {
        int n;
        Object lock;
        PrintOdd(int n, Object lock) {
            this.n = n;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while(counter <n) {// < to avoid printing one num extra
                    // wait while the number is odd and not changed to odd
                    if (counter %2 == 0) { //since waiting is required before notifying, the logic should be reversed, ie. checking odd number to print even, ie the logic checks what to wait for
                        try {
                            //System.out.println("PrintOdd waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //System.out.println("PrintOdd Notifying...");
                    System.out.println(counter++);
                    lock.notify();
                }
            }
        }
    }

    public static class PrintEven implements Runnable
    {
        int n;
        Object lock;
        PrintEven(int n, Object lock) {
            this.n = n;
            this.lock = lock;
        }
        @Override
        public void run() {
            synchronized (lock) {
                while(counter <n) {
                    // wait while the number is odd and not changed to even
                    if (counter % 2 == 1) { //since waiting is required before notifying, the logic should be reversed, ie. checking odd number to print even, ie the logic checks what to wait for
                        try {
                            //System.out.println("PrintEven waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //System.out.println("PrintEven Notifying...");
                    System.out.println(counter++);
                    lock.notify();
                }
            }
        }
    }


}
