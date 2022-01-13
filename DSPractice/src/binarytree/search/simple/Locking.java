package binarytree.search.simple;

import java.util.concurrent.Semaphore;

public class Locking {

 // Update the MyModel class so that no calls to take return null
public static class MyModel<T extends Object> {
private volatile T savedValue;
  Semaphore semaphore1 = new Semaphore(1);
  Semaphore semaphore2 = new Semaphore(1);

 public void put(T value) throws InterruptedException {
  semaphore1.acquire(1);
this.savedValue = value;
  semaphore1.release();
  semaphore2.release();
}

 public T take() throws InterruptedException {
  semaphore2.acquire(1);
T returnVal = savedValue;

 return returnVal;
}

}

 private static MyModel model = new MyModel<String>();

 public static void main(String[] args) {
startThread(() -> System.out.println("Take :" + model.take()));
startThread(() -> System.out.println("Take :" + model.take()));
startThread(() -> System.out.println("Take :" + model.take()));

 startThread(() -> model.put("one"));
startThread(() -> model.put("two"));
startThread(() -> model.put("three"));
}

 @FunctionalInterface
private interface RunWithException {
void Run() throws Exception;
}

 private static void startThread(RunWithException r) {
new Thread(() -> {
try {
r.Run();
} catch (Exception e) {
e.printStackTrace();
}
}).start();
}
}